package domain.auth;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class AuthReturn implements Serializable, Iterable<ReturnEntity> {

    private static final long serialVersionUID = -1109935428104382430L;

    @JsonProperty("return")
    private List<ReturnEntity> list;

    public List<ReturnEntity> getList() {
        return list;
    }

    public void setReturnEntity(List<ReturnEntity> returnEntity) {
        this.list = returnEntity;
    }

    @Override
    public String toString() {
        return "AuthReturn{" +
                "returnEntity=" + list +
                '}';
    }

    @Override
    public Iterator<ReturnEntity> iterator() {
        return list.iterator();
    }
}
