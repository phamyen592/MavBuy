/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Yenpham
 */
public class PurchaseItem {
    private String itemID;
    private int quantity;
    private Date date;
    private int storeID; // 0-9
    private double amount;
    private double shipping;
    /**
     *constructor: construct a default purchase which itemID is NULL, 
     * 
     */
    public PurchaseItem(){}

    /**
     * constructor: construct a purchase 
     * @param item
     * @param quan
     * @param d
     * @param store
     */
    public PurchaseItem(String item, int quan, Date d, int store ){
        itemID =item;
        quantity = quan;
        date = new Date();
        date = d;
        storeID= store;
        
    }

    /**
     *
     * @return
     */
    public String getItemID() {
        return itemID;
    }

    /**
     *
     * @param itemID
     */
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    /**
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @return
     */
    public double getAmount() {
        return amount;
    }

    /**
     *
     * @param amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     *
     * @return
     */
    public double getShipping() {
        return shipping;
    }

    /**
     *
     * @param shipping
     */
    public void setShipping(double shipping) {
        this.shipping = shipping;
    }
    
    
    
    /**
     * Method: to get an object data as a string
     * @return a String contains item ID, Date, Store, and quantity.
     */
    public String toString (){
        String text= String.format( "%-2d of Item %-15s for $%-10.2f on [%10s] at store #%d with shipping cost: $%.2f",
                            quantity, itemID, amount, date, storeID, shipping);
        return text;
    
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }
    
}
