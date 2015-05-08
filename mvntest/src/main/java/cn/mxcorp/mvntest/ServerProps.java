package cn.mxcorp.mvntest;

import java.io.Serializable;

/**
 * User: landy
 * Date: 15/2/7
 * Time: 上午10:42
 * TODO 加上密钥验证
 */
public class ServerProps implements Serializable {
    private String serverName;
    private Integer serverId;
    private String serverDesc;
    private String ip;
    private String rootUrl;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public String getServerDesc() {
        return serverDesc;
    }

    public void setServerDesc(String serverDesc) {
        this.serverDesc = serverDesc;
    }

    public String getRootUrl() {
        return rootUrl;
    }

    public void setRootUrl(String rootUrl) {
        this.rootUrl = rootUrl;
    }
}
