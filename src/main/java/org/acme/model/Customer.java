package org.acme.model;

/**
 * Customer entity 
 * @author nmajorov
 *
 */
public class Customer {

   

    String name;
    
    Long ID;
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        ID = iD;
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", ID=" + ID + "]";
    }
}
