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
public class Transaction {

    private long id;
    private long sourceAccount;
    private long destinationAccount;
    private long amount;
    private String status;

    public Transaction(long id, long source,long destination,long amount) {
        this.id = id;
        this.sourceAccount = source;
        this.destinationAccount = destination;
        this.amount = amount;
        this.status= "pending";

    }

    public String getJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    /**
     * @return the sourceAccount
     */
    public long getSourceAccount() {
        return sourceAccount;
    }

    /**
     * @param sourceAccount the sourceAccount to set
     */
    public void setSourceAccount(long sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    /**
     * @return the destinationAccount
     */
    public long getDestinationAccount() {
        return destinationAccount;
    }

    /**
     * @param destinationAccount the destinationAccount to set
     */
    public void setDestinationAccount(long destinationAccount) {
        this.destinationAccount = destinationAccount;
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

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
