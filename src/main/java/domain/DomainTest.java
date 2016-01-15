package domain;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

public class DomainTest implements Serializable{

    private static final long serialVersionUID = -668025235838756471L;

    public DomainTest() {

    }

    public DomainTest(String name) {
        this.name = name;
    }

    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DomainTest{" +
                "name='" + name + '\'' +
                '}';
    }
}
