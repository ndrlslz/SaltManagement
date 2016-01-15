package domain.key;

import java.io.Serializable;

public class KeyBody implements Serializable {
    private static final long serialVersionUID = -5517557176256837530L;
    private String client;
    private String fun;
    private String tgt;
    private String match;

    public KeyBody() {
        client = "wheel";
    }

    public KeyBody(String fun) {
        this.client = "wheel";
        this.fun = fun;
    }

    public KeyBody(String fun, String minionId) {
        this.client = "wheel";
        this.fun = fun;
        this.match = minionId;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getFun() {
        return fun;
    }

    public void setFun(String fun) {
        this.fun = fun;
    }

    public String getTgt() {
        return tgt;
    }

    public void setTgt(String tgt) {
        this.tgt = tgt;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    @Override
    public String toString() {
        return "KeyBody{" +
                "client='" + client + '\'' +
                ", fun='" + fun + '\'' +
                ", tgt='" + tgt + '\'' +
                ", match='" + match + '\'' +
                '}';
    }
}
