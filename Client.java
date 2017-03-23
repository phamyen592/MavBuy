

import java.util.*;


/**
 *
 * @author Yenpham
 */
public class Client {

    private int ID;

    private String firstName;

    private String lastName;

    private Date dob;

    private String gender;

    private String type;

    private Address address;
    private ArrayList<Double> amountByYear=new ArrayList<Double>();  
    private ArrayList<Integer> yearsPurchase = new ArrayList<Integer>();

    private ArrayList<PurchaseItem> buyList = new ArrayList<PurchaseItem>();

    /**
     * Method: to add a new PurchaseItem into customer's buy list 
     * @param newItem
     */
    public void addPurchaseItem(PurchaseItem newItem) {
        buyList.add(newItem);
    }

    /**
     * Method: get the list of purchase item
     * @return buyList
     */
    public ArrayList<PurchaseItem> getBuyList() {
        return buyList;
    }
    public void sortBuyListByDate(){
        boolean sorted =false;
        do {
            sorted= true;
            for (int i=0; i<buyList.size()-1;i++){
                if(buyList.get(i+1).getDate().isBefore(buyList.get(i).getDate())){
                    sorted= false;
                    PurchaseItem temp= buyList.get(i);
                    buyList.set(i, buyList.get(i+1));
                    buyList.set(i+1, temp);
                }
                    
            }
            
        }while(!sorted);
    }
  
    public int yearFirstPurchase(){
        if (buyList.size()==0)
            return 0;
        this.sortBuyListByDate();
        return buyList.get(0).getDate().getYear();
    }
    
    public int yearLastPurchase(){
        if (buyList.size()==0)
            return 0;
        this.sortBuyListByDate();
        return buyList.get(buyList.size()-1).getDate().getYear();
    }
    /**
     * Method: to set a buyList  for a customer
     * @param buyList
     */
    public void setBuyList(ArrayList<PurchaseItem> buyList) {
        this.buyList = buyList;
    }

    /**
     * Method to get Id of client
     * @return ID
     */
    public int getID() {
        return ID;
    }

    
    /**
     * Method: to get customer's First name
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    

    /**
     *Method: to get customer's Last name
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Method: to get customer's Address 
     * @return address
     */
    public Address getAddress() {
        return address;
    }


    /**
     * constructor: construct a new client with those information
     * @param clientId
     * @param clientFName
     * @param clientLName
     * @param clientDOB
     * @param clientGender
     * @param clientMemType
     * @param clientHouseNum
     * @param clientStreet
     * @param clientCity
     * @param clientState
     */
    public Client(int clientId, String clientFName, String clientLName, String clientDOB, String clientGender, String clientMemType, int clientHouseNum, String clientStreet, String clientCity, String clientState) {
        ID = clientId;
        firstName = clientFName;
        lastName = clientLName;
        dob = new Date();
        dob.setDate(clientDOB);
        gender = clientGender;
        type = clientMemType;
        address = new Address(clientHouseNum, clientStreet, clientCity, clientState);
    }

    /**
     * constructor: default client
     */
    public Client() {
    }

    @Override
    public String toString() {
        return ID + " " + firstName + " " + lastName + " [" + dob + "] " + gender + " " + type + " " + address;
    }

    public double getAmountByYear(int year) {
        double totalAmount=0;
       for(int i=0; i<yearsPurchase.size();i++){
            if(year ==yearsPurchase.get(i)){
                totalAmount= amountByYear.get(i);
            }
        }
        return totalAmount;
    }

    public  void addAmountByYear(double amount,int year) {
        
        for(int i=0; i<yearsPurchase.size();i++){
            if(year ==yearsPurchase.get(i)){
                amountByYear.set(i, amountByYear.get(i)+amount);
                return;
            }
        }
        amountByYear.add(amount);
        yearsPurchase.add(year);
    }

    public ArrayList<Integer> getYearsPurchase() {
        return yearsPurchase;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<Double> getAmountByYear() {
        return amountByYear;
    }

    public void setAmountByYear(ArrayList<Double> amountByYear) {
        this.amountByYear = amountByYear;
    }

    
    public String getType() {
        return type;
    }

   
}
