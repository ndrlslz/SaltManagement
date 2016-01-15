package domain.run;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class RunReturn implements Serializable{
    private static final long serialVersionUID = 5231482781555045348L;

    @JsonProperty("return")
    private List<RunReturnEntity> list;

    public List<RunReturnEntity> getList() {
        return list;
    }

    public void setList(List<RunReturnEntity> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "RunReturn{" +
                "list=" + list +
                '}';
    }
}
