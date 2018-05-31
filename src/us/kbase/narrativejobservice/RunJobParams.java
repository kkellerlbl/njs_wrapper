
package us.kbase.narrativejobservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import us.kbase.common.service.UObject;


/**
 * <p>Original spec-file type: RunJobParams</p>
 * <pre>
 * method - service defined in standard JSON RPC way, typically it's
 *     module name from spec-file followed by '.' and name of funcdef 
 *     from spec-file corresponding to running method (e.g.
 *     'KBaseTrees.construct_species_tree' from trees service);
 * params - the parameters of the method that performed this call;
 * Optional parameters:
 * service_ver - specific version of deployed service, last version is
 *     used if this parameter is not defined
 * rpc_context - context of current method call including nested call
 *     history
 * remote_url - run remote service call instead of local command line
 *     execution.
 * source_ws_objects - denotes the workspace objects that will serve as a
 *     source of data when running the SDK method. These references will
 *     be added to the autogenerated provenance.
 * app_id - the id of the Narrative application running this job (e.g.
 *     repo/name)
 * mapping<string, string> meta - user defined metadata to associate with
 *     the job. This data is passed to the User and Job State (UJS)
 *     service.
 * wsid - a workspace id to associate with the job. This is passed to the
 *     UJS service, which will share the job based on the permissions of
 *     the workspace rather than UJS ACLs.
 * </pre>
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "method",
    "params",
    "service_ver",
    "rpc_context",
    "remote_url",
    "source_ws_objects",
    "app_id",
    "meta",
    "wsid",
    "parent_job_id"
})
public class RunJobParams {

    @JsonProperty("method")
    private java.lang.String method;
    @JsonProperty("params")
    private List<UObject> params;
    @JsonProperty("service_ver")
    private java.lang.String serviceVer;
    /**
     * <p>Original spec-file type: RpcContext</p>
     * <pre>
     * call_stack - upstream calls details including nested service calls and 
     *     parent jobs where calls are listed in order from outer to inner.
     * </pre>
     * 
     */
    @JsonProperty("rpc_context")
    private RpcContext rpcContext;
    @JsonProperty("remote_url")
    private java.lang.String remoteUrl;
    @JsonProperty("source_ws_objects")
    private List<String> sourceWsObjects;
    @JsonProperty("app_id")
    private java.lang.String appId;
    @JsonProperty("meta")
    private Map<String, String> meta;
    @JsonProperty("wsid")
    private Long wsid;
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();
    @JsonProperty("parent_job_id")
    private String parentJobId;


    @JsonProperty("method")
    public java.lang.String getMethod() {
        return method;
    }

    @JsonProperty("method")
    public void setMethod(java.lang.String method) {
        this.method = method;
    }

    public RunJobParams withMethod(java.lang.String method) {
        this.method = method;
        return this;
    }

    @JsonProperty("params")
    public List<UObject> getParams() {
        return params;
    }

    @JsonProperty("params")
    public void setParams(List<UObject> params) {
        this.params = params;
    }

    public RunJobParams withParams(List<UObject> params) {
        this.params = params;
        return this;
    }

    @JsonProperty("service_ver")
    public java.lang.String getServiceVer() {
        return serviceVer;
    }

    @JsonProperty("service_ver")
    public void setServiceVer(java.lang.String serviceVer) {
        this.serviceVer = serviceVer;
    }

    public RunJobParams withServiceVer(java.lang.String serviceVer) {
        this.serviceVer = serviceVer;
        return this;
    }

    /**
     * <p>Original spec-file type: RpcContext</p>
     * <pre>
     * call_stack - upstream calls details including nested service calls and 
     *     parent jobs where calls are listed in order from outer to inner.
     * </pre>
     * 
     */
    @JsonProperty("rpc_context")
    public RpcContext getRpcContext() {
        return rpcContext;
    }

    /**
     * <p>Original spec-file type: RpcContext</p>
     * <pre>
     * call_stack - upstream calls details including nested service calls and 
     *     parent jobs where calls are listed in order from outer to inner.
     * </pre>
     * 
     */
    @JsonProperty("rpc_context")
    public void setRpcContext(RpcContext rpcContext) {
        this.rpcContext = rpcContext;
    }

    public RunJobParams withRpcContext(RpcContext rpcContext) {
        this.rpcContext = rpcContext;
        return this;
    }

    @JsonProperty("remote_url")
    public java.lang.String getRemoteUrl() {
        return remoteUrl;
    }

    @JsonProperty("remote_url")
    public void setRemoteUrl(java.lang.String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    public RunJobParams withRemoteUrl(java.lang.String remoteUrl) {
        this.remoteUrl = remoteUrl;
        return this;
    }

    @JsonProperty("source_ws_objects")
    public List<String> getSourceWsObjects() {
        return sourceWsObjects;
    }

    @JsonProperty("source_ws_objects")
    public void setSourceWsObjects(List<String> sourceWsObjects) {
        this.sourceWsObjects = sourceWsObjects;
    }

    public RunJobParams withSourceWsObjects(List<String> sourceWsObjects) {
        this.sourceWsObjects = sourceWsObjects;
        return this;
    }

    @JsonProperty("app_id")
    public java.lang.String getAppId() {
        return appId;
    }

    @JsonProperty("app_id")
    public void setAppId(java.lang.String appId) {
        this.appId = appId;
    }

    public RunJobParams withAppId(java.lang.String appId) {
        this.appId = appId;
        return this;
    }

    @JsonProperty("meta")
    public Map<String, String> getMeta() {
        return meta;
    }

    @JsonProperty("meta")
    public void setMeta(Map<String, String> meta) {
        this.meta = meta;
    }

    public RunJobParams withMeta(Map<String, String> meta) {
        this.meta = meta;
        return this;
    }

    @JsonProperty("wsid")
    public Long getWsid() {
        return wsid;
    }

    @JsonProperty("wsid")
    public void setWsid(Long wsid) {
        this.wsid = wsid;
    }

    public RunJobParams withWsid(Long wsid) {
        this.wsid = wsid;
        return this;
    }

    @JsonProperty("parent_job_id")
    public String getParentJobId() {
        return parentJobId;
    }

    @JsonProperty("parent_job_id")
    public void setParentJobId(String parentJobId) {
        this.parentJobId = parentJobId;
    }

    public RunJobParams withParentJobId(String parentJobId) {
        this.parentJobId = parentJobId;
        return this;
    }




    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public java.lang.String toString() {
        return ((((((((((((((((((((("RunJobParams"+" [method=")+ method)+", params=")+ params)+", serviceVer=")+ serviceVer)+", rpcContext=")+ rpcContext)+", remoteUrl=")+ remoteUrl)+", sourceWsObjects=")+ sourceWsObjects)+", appId=")+ appId)+", meta=")+ meta)+", wsid=")+ wsid)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
