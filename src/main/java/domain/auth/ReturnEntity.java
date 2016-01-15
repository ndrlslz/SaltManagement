package domain.auth;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

import java.io.Serializable;
import java.util.List;

@JsonRootName("returnEntity")
public class ReturnEntity implements Serializable {
    private static final long serialVersionUID = -3903428118739784012L;

    @JsonProperty
    private List<String> perms;

    @JsonProperty("start")
    private Long start;

    @JsonProperty("token")
    private String token;

    @JsonProperty("expire")
    private Long expire;

    @JsonProperty("user")
    private String user;

    @JsonProperty("eauth")
    private String eauth;

    public List<String> getPerms() {
        return perms;
    }

    public void setPerms(List<String> perms) {
        this.perms = perms;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEauth() {
        return eauth;
    }

    public void setEauth(String eauth) {
        this.eauth = eauth;
    }

    @Override
    public String toString() {
        return "ReturnEntity{" +
                "perms=" + perms +
                ", start=" + start +
                ", token='" + token + '\'' +
                ", expire=" + expire +
                ", user='" + user + '\'' +
                ", eauth='" + eauth + '\'' +
                '}';
    }
}
