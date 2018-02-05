/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;

/**
 *
 * @author gstafie
 */
public class Account {
    private long id;
    private long customerId;
    private long amount;
    public Account(long id, long custId, long amount){
        this.id = id;
        this.customerId = custId;
        this.amount = amount;
    }

    
    public String getJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the customerId
     */
    public long getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the amount
     */
    public long getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(long amount) {
        this.amount = amount;
    }
    
}
