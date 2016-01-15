package domain.key;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

import java.io.Serializable;

@JsonRootName("data")
public class KeysData implements Serializable {
    private static final long serialVersionUID = -2642919423717525123L;

    @JsonProperty("jid")
    private String jid;

    @JsonProperty("return")
    private Keys keys;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("_stamp")
    private String stamp;

    @JsonProperty("tag")
    private String tag;

    @JsonProperty("user")
    private String user;

    @JsonProperty("fun")
    private String fun;

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
    }

    public Keys getKeys() {
        return keys;
    }

    public void setKeys(Keys keys) {
        this.keys = keys;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getStamp() {
        return stamp;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFun() {
        return fun;
    }

    public void setFun(String fun) {
        this.fun = fun;
    }

    @Override
    public String toString() {
        return "KeysData{" +
                "jid='" + jid + '\'' +
                ", keys=" + keys +
                ", success=" + success +
                ", stamp='" + stamp + '\'' +
                ", tag='" + tag + '\'' +
                ", user='" + user + '\'' +
                ", fun='" + fun + '\'' +
                '}';
    }
}
