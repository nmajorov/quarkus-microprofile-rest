package org.acme.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
/**
 * Customer record in db 
 * @author nmajorov
 *
 */
@Entity
@Table(name = "customers")
@NamedQuery(name = "Customers.findAll",
query = "SELECT f FROM Customer f ORDER BY f.name",
hints = @QueryHint(name = "org.hibernate.cacheable", value = "true") )
@Cacheable
public class Customer {

   
    @Column(length = 40, unique = true)
    private String name;
    
    @Column
    private Integer revenue;
    
    @Id
    Integer ID;
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", revenue=" + revenue + ", ID=" + ID + "]";
    }

    
}
