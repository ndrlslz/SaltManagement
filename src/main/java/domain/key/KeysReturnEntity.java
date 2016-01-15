package domain.key;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

public class KeysReturnEntity implements Serializable{
    private static final long serialVersionUID = -2599845663709667033L;


    @JsonProperty("tag")
    private String tag;

    @JsonProperty("data")
    private KeysData keysData;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public KeysData getKeysData() {
        return keysData;
    }

    public void setKeysData(KeysData keysData) {
        this.keysData = keysData;
    }

    @Override
    public String toString() {
        return "KeysReturn{" +
                "tag='" + tag + '\'' +
                ", keysData=" + keysData +
                '}';
    }
}
