package domain.key;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

import java.io.Serializable;
import java.util.List;

@JsonRootName("return")
public class Keys implements Serializable {
    private static final long serialVersionUID = 7400486285863865553L;

    @JsonProperty("minions_pre")
    private List<String> minionsPre;

    @JsonProperty("minions_rejected")
    private List<String> minionsRejected;

    @JsonProperty("minions_denied")
    private List<String> minionsDenied;

    @JsonProperty("local")
    private List<String> local;

    @JsonProperty("minions")
    private List<String> minions;

    public List<String> getMinionsPre() {
        return minionsPre;
    }

    public void setMinionsPre(List<String> minionsPre) {
        this.minionsPre = minionsPre;
    }

    public List<String> getMinionsRejected() {
        return minionsRejected;
    }

    public void setMinionsRejected(List<String> minionsRejected) {
        this.minionsRejected = minionsRejected;
    }

    public List<String> getMinionsDenied() {
        return minionsDenied;
    }

    public void setMinionsDenied(List<String> minionsDenied) {
        this.minionsDenied = minionsDenied;
    }

    public List<String> getLocal() {
        return local;
    }

    public void setLocal(List<String> local) {
        this.local = local;
    }

    public List<String> getMinions() {
        return minions;
    }

    public void setMinions(List<String> minions) {
        this.minions = minions;
    }

    @Override
    public String toString() {
        return "Keys{" +
                "minionsPre=" + minionsPre +
                ", minionsRejected=" + minionsRejected +
                ", minionsDenied=" + minionsDenied +
                ", local=" + local +
                ", minions=" + minions +
                '}';
    }
}
