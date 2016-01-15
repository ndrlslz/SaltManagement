package domain.key;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class KeysReturn implements Serializable {
    private static final long serialVersionUID = 158835796083536810L;

    @JsonProperty("return")
    private List<KeysReturnEntity> list;

    public List<KeysReturnEntity> getList() {
        return list;
    }

    public void setList(List<KeysReturnEntity> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "KeysReturn{" +
                "list=" + list +
                '}';
    }
}
