/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

/**
 *
 * @author gstafie
 */
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/customer/{id}")
public class CustomerController {

    List<Customer> customers = new ArrayList<Customer>();
//    private Customer[] customers;

    public CustomerController() {
        for (int i = 1; i <= 100; i++) {
            customers.add(new Customer(i, "customer_" + Integer.toString(i), "password" +   Integer.toString(i)));
        }
    }

    @GET
    public String getCustomer(@PathParam("id") int id) {
        return customers.get(id + 1).getJSON();
    }

}
