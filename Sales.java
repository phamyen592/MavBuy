/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yenpham
 */
public class Sales {
    int ClientId;
    int quan;
    Date date;
    double amount;
    int store;
    
    public Sales(){}
    public Sales(int ClientId, int quan, Date date, double amount,int store) {
        this.ClientId = ClientId;
        this.quan = quan;
        this.date = date;
        this.amount = amount;
        this.store =store;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int ClienId) {
        this.ClientId = ClienId;
    }

    public int getQuan() {
        return quan;
    }

    public void setQuan(int quan) {
        this.quan = quan;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
}
