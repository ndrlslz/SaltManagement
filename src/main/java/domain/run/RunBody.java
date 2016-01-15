package domain.run;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

public class RunBody implements Serializable{
    private static final long serialVersionUID = -3624991262462503907L;

    @JsonProperty("fun")
    private String fun;

    @JsonProperty("tgt")
    private String tgt;

    @JsonProperty("client")
    private String client;

    @JsonProperty("arg")
    private String arg;

    public RunBody(String tgt, String arg) {
        this.fun = "cmd.run";
        this.client = "local";
        this.tgt = tgt;
        this.arg = arg;
    }

    public RunBody() {

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

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getArg() {
        return arg;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }

    @Override
    public String toString() {
        return "RunBody{" +
                "fun='" + fun + '\'' +
                ", tgt='" + tgt + '\'' +
                ", client='" + client + '\'' +
                ", arg='" + arg + '\'' +
                '}';
    }
}
