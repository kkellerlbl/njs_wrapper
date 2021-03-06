package us.kbase.narrativejobservice;

import com.mongodb.BulkWriteResult;
import org.ini4j.Ini;
import us.kbase.narrativejobservice.test.TesterUtils;
import us.kbase.narrativejobservice.ReaperService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import java.io.File;



public class ReaperServiceServlet implements ServletContextListener {

    private Thread myThread = null;
    static Map<String, String> config;


    private ReaperService getReaperService() throws Exception {
        Ini config = new Ini(new File(System.getenv("KB_DEPLOYMENT_CONFIG")));
        String host = config.get("NarrativeJobService","ujs-mongodb-host");
        String dbName = config.get("NarrativeJobService","ujs-mongodb-database");
        String user = config.get("NarrativeJobService","ujs-mongodb-user");
        String pwd = config.get("NarrativeJobService", "ujs-mongodb-pwd");
        return new ReaperService(user, pwd, host, dbName);
    }

    public void contextInitialized(ServletContextEvent sce) {

        if ((myThread == null) || (!myThread.isAlive())) {
            final File file = new File("reaper.log");
            Thread myThread = new Thread(new Runnable() {
                public void run() {
                    try {
                        ReaperService r = getReaperService();

                        while (true) {
                            String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) + "\n";
                            FileUtils.writeStringToFile(file, "RUNNING REAPER at " + time,true);
                            BulkWriteResult result = r.purgeGhostJobs();
                            if (result != null)
                                System.out.println(result);
                            else {
                                System.out.println("No Jobs To Purge.");
                            }
                            //30 Minutes Before Each Run
                            Thread.sleep(1000 * 60 * 30);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            myThread.isDaemon();
          myThread.start();
        }
        else{
            System.out.println("FAILED TO RUN REAPER");
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        try {
            myThread.interrupt();
        } catch (Exception ex) {
        }
    }
}


