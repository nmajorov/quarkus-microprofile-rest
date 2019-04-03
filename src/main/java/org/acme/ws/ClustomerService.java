package org.acme.ws;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.acme.model.Customer;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClustomerService {

    // mocked customer db
    private Set<Customer> fruits = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    @GET
    public Set<Customer> list() {
        return fruits;
    }

    @POST
    public Set<Customer> add(Customer customer) {
        fruits.add(customer);
        return fruits;
    }

    @DELETE
    public Set<Customer> delete(Customer customer) {
        fruits.remove(customer);
        return fruits;
    }
}
