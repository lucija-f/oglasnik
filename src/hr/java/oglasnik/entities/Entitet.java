package hr.java.oglasnik.entities;

import java.io.Serializable;

public class Entitet implements Serializable {

    Long id;

    public Entitet(Long id) {
        super();
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
