package org.acme.ws;

import java.util.Collections;

import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.model.Customer;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.enterprise.context.ApplicationScoped;


@Path("/customers")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClustomerService {
    
    
  
    @Inject
    EntityManager entityManager;
    
    private Set<Customer> customers = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

   
    @GET
    public Set<Customer> list() {
         customers.addAll(entityManager.createNamedQuery("Customers.findAll", Customer.class)
                .getResultList());
         return customers;
    }

    @POST
    @Transactional
    public Response add(Customer customer) {
        if (customer.getID() != null) {
            throw new WebApplicationException("Id was invalidly set on request.", 422);
        }

        entityManager.persist(customer);
        return Response.ok(customer).status(201).build();
       
    }

    @DELETE
    @Transactional
    public Response delete(@PathParam("id") Integer id) {
        Customer entity =  entityManager.getReference(Customer.class,id);
        if (entity == null) {
            throw new WebApplicationException("Customer with id of " + id + " does not exist.", 404);
        }
        entityManager.remove(entity);
        return Response.status(204).build();
    }
}
