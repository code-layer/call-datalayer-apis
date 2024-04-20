package in.datalayer;

import java.io.Serializable;

public class RequestData implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
