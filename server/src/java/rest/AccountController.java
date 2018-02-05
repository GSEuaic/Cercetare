/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author gstafie
 */
@Path("/account/{id}")

public class AccountController {

    List<Account> accounts = new ArrayList<Account>();
//    private Customer[] customers;

    public AccountController() {
        for (int i = 1; i <= 100; i++) {
            accounts.add(new Account(i, i, 10 * i));
        }
    }

    @GET
    public String getAccounts(@PathParam("id") int id) {
        return accounts.get(id + 1).getJSON();
    }

}
