package domain.run;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

public class RunReturnEntity implements Serializable{
    private static final long serialVersionUID = -8147145805228565292L;

    @JsonProperty("trainyx02")
    private String minion;

    public String getMinion() {
        return minion;
    }

    public void setMinion(String minion) {
        this.minion = minion;
    }

    @Override
    public String toString() {
        return "RunReturnEntity{" +
                "minion='" + minion + '\'' +
                '}';
    }
}
