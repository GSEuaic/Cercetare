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
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.annotation.security.DeclareRoles;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;


@DeclareRoles({ "foo", "bar", "kaz" })
@ServletSecurity(@HttpConstraint(rolesAllowed = ""))
@Path("/transactions/{id}")
public class TransactionController {

    List<Transaction> transactions = new ArrayList<Transaction>();

    public TransactionController() {
        for (int i = 1; i <= 10; i++) {
            transactions.add(new Transaction(i, 100 - i, i, 200 - i));
        }
    }

    @GET
    public String getTransaction(@PathParam("id") int id) {
        return transactions.get(id + 1).getJSON();
    }
    @DELETE
    public String deleteTransaction(@PathParam("id") int id) {
        transactions.remove(id);
        return "200";
    }
}
