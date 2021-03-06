FROM kbase/kb_jre

# These ARGs values are passed in via the docker build command
ARG BUILD_DATE
ARG VCS_REF
ARG BRANCH=develop


ADD ./dev_tools/install.sh /install.sh 
CMD ["/install.sh"]
RUN /install.sh


# The htcondor package tries an interactive config, set DEBIAN_FRONTEND to
# noninteractive in order to prevent that
RUN apt-get update && \
    export DEBIAN_FRONTEND=noninteractive && \
    apt-get install -y htcondor zile vim libgomp1 && \
    chown -R kbase:kbase /etc/condor && \
    mkdir /scratch && \
    cd /tmp && \
    wget http://submit-3.batlab.org/nmi-runs/condorauto/2018/03/condorauto_submit-3.batlab.org_1520871025_1539075/userdir/nmi:x86_64_Debian9/results.tar.gz && \
    tar xvzf results.tar.gz && \
    cd public && \
    tar xvzf condor-8.6.10-x86_64_Debian9-stripped.tar.gz && \
    cd condor-8.6.10-x86_64_Debian9-stripped && \
    ./condor_install --prefix=/usr --type=submit --local-dir=/scratch/condor --owner=kbase --overwrite && \
    cd /tmp && \
    rm -rf results.tar.gz public && \
    mkdir /var/run/condor && \
    chown kbase /run/condor /var/lock/condor /var/log/condor /var/lib/condor/execute

USER kbase
COPY --chown=kbase deployment/ /kb/deployment/



# Extra all of the jars for NJS so that the scripts can use them in classpath
RUN cd /kb/deployment/lib && unzip /kb/deployment/jettybase/webapps/root.war


ENV KB_DEPLOYMENT_CONFIG /kb/deployment/conf/deployment.cfg

# The BUILD_DATE value seem to bust the docker cache when the timestamp changes, move to
# the end
LABEL org.label-schema.build-date=$BUILD_DATE \
      org.label-schema.vcs-url="https://github.com/kbase/njs_wrapper.git" \
      org.label-schema.vcs-ref=$VCS_REF \
      org.label-schema.schema-version="1.0.0-rc1" \
      us.kbase.vcs-branch=$BRANCH \
      maintainer="Steve Chan sychan@lbl.gov"

EXPOSE 7058
ENTRYPOINT [ "/kb/deployment/bin/dockerize" ]
CMD [ "-template", "/kb/deployment/conf/.templates/deployment.cfg.templ:/kb/deployment/conf/deployment.cfg", \
      "-template", "/kb/deployment/conf/.templates/http.ini.templ:/kb/deployment/jettybase/start.d/http.ini", \
      "-template", "/kb/deployment/conf/.templates/server.ini.templ:/kb/deployment/jettybase/start.d/server.ini", \
      "-template", "/kb/deployment/conf/.templates/start_server.sh.templ:/kb/deployment/bin/start_server.sh", \
      "-template", "/kb/deployment/conf/.templates/condor_config.templ:/etc/condor/condor_config.local", \
      "-stdout", "/kb/deployment/jettybase/logs/request.log", \
      "/kb/deployment/bin/start_server.sh" ]

WORKDIR /kb/deployment/jettybase

# for a NJS worker node use the following CMD in the docker-compose file
#CMD [ "-template", "/kb/deployment/conf/.templates/condor_config.templ:/etc/condor/condor_config.local", \
#      "-stdout", "/var/log/condor/ProcLog", \
#      "-stdout", "/var/log/condor/StartLog", \
#      "/kb/deployment/bin/start-condor.sh" ]
