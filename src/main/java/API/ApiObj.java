package API;

import conf.ConfProperties;

public class ApiObj {
    protected String key = ConfProperties.getProperty("apikey");
    protected String token = ConfProperties.getProperty("apitoken");
    protected String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public String getToken() {
        return token;
    }

    public String getId() {
        return id;
    }
}
