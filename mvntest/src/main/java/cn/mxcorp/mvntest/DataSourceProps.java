package cn.mxcorp.mvntest;

import java.io.Serializable;

/**
 * User: landy
 * Date: 15/2/7
 * Time: 上午9:40
 */
public class DataSourceProps implements Serializable {
    private String driverClass;
    private String url;
    private String userName;
    private String passWord;

    public ServerProps getServer() {
        return server;
    }

    public void setServer(ServerProps server) {
        this.server = server;
    }

    private ServerProps server;
    private DatabaseType databaseType;
    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    public DatabaseType getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(DatabaseType databaseType) {
        this.databaseType = databaseType;
    }
}
