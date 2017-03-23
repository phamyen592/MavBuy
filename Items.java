

import java.util.*;


/**
 *
 * @author Yenpham
 */
public class Items {

    private String modelID;

    private String companyName;

    private String condition;

    private double shippingCost;

    private int[] storeAvailability = new int[10];

    private Date availabilityDate = new Date();

    private double shippingDays;

    private double price;

    private String type;
    
    private ArrayList<Sales>salesList = new ArrayList<Sales>();

    /**
     * Constructor: default item  
     */
    public Items() {
    }

    /**
     * comStructor: construct a new item object with all parameters
     * @param itemId
     * @param itemCompanyName
     * @param itemCondition
     * @param itemShippingCost
     * @param itemAvailability
     * @param itemAvailabilityDate
     * @param itemShippingDays
     * @param itemPrice
     * @param itemCategory
     */
    public Items(String itemId, String itemCompanyName, String itemCondition, double itemShippingCost, String itemAvailability, String itemAvailabilityDate, double itemShippingDays, double itemPrice, String itemCategory) {
        modelID = itemId;
        companyName = itemCompanyName;
        condition = itemCondition;
        shippingCost = itemShippingCost;
        try {
            String[] tok = itemAvailability.split(",");
            for (int i = 0; i < 10; i++) storeAvailability[i] = Integer.parseInt(tok[i]);
        } catch (Exception e) {
            System.out.println("Error.");
        }
        availabilityDate.setDate(itemAvailabilityDate);
        shippingDays = itemShippingDays;
        price = itemPrice;
        type = itemCategory;
    }

    /**
     * Method: to set available of store index to the value of newAvailable
     * @param index
     * @param newAvailable
     */
    public void setAvailableByIndex(int index, int newAvailable) {
        storeAvailability[index] = newAvailable;
    }

    /**
     * Method: to check if the item available in store with the quantity of quan.
     * @param store
     * @param quan
     * @return
     */
    public boolean isAvailable(int store, int quan) {
        if (storeAvailability[store-1] >= quan)
            return true;
        return false;
    }

    /**
     * Method: to set employee from a String
     * @param emp
     */
    public void setItem(String emp) {
        String[] tok = emp.split(":");
        try {
            modelID = tok[0];
            companyName = tok[1];
            condition = tok[2];
            shippingCost = Double.parseDouble(tok[3]);
            String[] tok2 = tok[4].split(",");
            for (int i = 0; i < 10; i++) {
                storeAvailability[i] = Integer.parseInt(tok2[i]);
            }
            availabilityDate.setDate(tok[5]);
            shippingDays = Integer.parseInt(tok[6]);
            price = Double.parseDouble(tok[7]);
            type = tok[8];
        } catch (Exception e) {
            System.out.println("Invalid Employee information.");
        }
    }

    public String getStoreAvailableString() {
        String result = Integer.toString(storeAvailability[0]);
        for (int i = 1; i < 10; i++) result = result + "," + Integer.toString(storeAvailability[i]);
        return result;
    }

    @Override
    public String toString() {
        return modelID + " " + companyName + " " + condition + " " + shippingCost + " " + "["+ this.getStoreAvailableString()+ "]"+ " [" + availabilityDate + "] " + shippingDays + " " + price + " " + type;
    }

    /**
     * Method: to get modelID
     * @return modelID
     */
    public String getModelID() {
        return modelID;
    }

    /**
     * Method: to get companyName
     * @return companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Method: to get Condition of an item
     * @return condition
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Method: get ShippingCost
     * @return ShippingCost
     */
    public double getShippingCost() {
        return shippingCost;
    }

    /**
     * Method: to get Store Availability
     * @return StoreAvailability
     */
    public int[] getStoreAvailability() {
        return storeAvailability;
    }

    /**
     * Method:  to getAvailableDate
     * @return AvailableDate
     */
    public Date getAvailableDate() {
        return availabilityDate;
    }

    /**
     *Method: get Price of item
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     *method : get available date of item
     * @return
     */
    public Date getAvailabilityDate() {
        return availabilityDate;
    }

    /**
     * method: set available date for an item
     * @param availabilityDate
     */
    public void setAvailabilityDate(Date availabilityDate) {
        this.availabilityDate = availabilityDate;
    }

    /**
     *Method to get List of sale item
     * @return
     */
    public ArrayList<Sales> getSalesList() {
        return salesList;
    }

    /**
     *Method to set a whole list of sales
     * @param SalesList
     */
    public void setSalesList(ArrayList<Sales> SalesList) {
        this.salesList = SalesList;
    }

    /**
     * Method add a sale into sale List
     * @param sale
     */
    public void addSales (Sales sale){
        salesList.add(sale);
    }

    public double getShippingDays() {
        return shippingDays;
    }

    public void setShippingDays(double shippingDays) {
        this.shippingDays = shippingDays;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}

   

