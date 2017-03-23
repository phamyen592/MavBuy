/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yenpham
 */
public class WebDesigner extends Employee  {
    private Date dateJoin ;
    private double monthlyBase;
    private double ratePerClick;
    private final boolean onCall= true;
    private final String  type ="WD";
    
    /**
     *
     */
    public WebDesigner(){}
    
    /**
     *
     * @param fName
     * @param lName
     * @param BDay
     * @param gend
     * @param dateHire
     * @param baseSalary
     * @param rate
     */
    public WebDesigner (String fName, String lName, String BDay, String gend,String dateHire, double baseSalary,double rate){
        
        super(fName,lName,BDay,gend);
        dateJoin = new Date();
        dateJoin.setDate(dateHire);
        monthlyBase = baseSalary;
        ratePerClick = rate;
        
    }
    /**
     *
     * @return
     */
    public double getBaseSalary(){
        return 0;
    }
    
    /**
     *
     * @return
     */
    public Date getHireDate() {
        return dateJoin;
    }

    /**
     *
     * @param rate
     */
    public void setRate(double rate){
        ratePerClick = rate;
    }
    /**
     *
     * @return
     */
    public double getRate() {
        return ratePerClick;
    }
  
    /**
     *
     * @return
     */
    public boolean isOnCall() {
        return onCall;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param date
     */
    public void setHireDate(Date date){
        dateJoin= date;
       
    }
    
    /**
     *
     * @param numberClick
     * @return
     */
    @Override
     public double computeSalary(int numberClick){
        double salary;
        salary = monthlyBase +ratePerClick*numberClick;
        return salary;
    }
    @Override
     public String toString() {
         String text = String.format("ID:%-3d %-13s  %-10s %-10s BOD: [%10s] %7s Hire Date: [%10s] On call: %b ",super.getID(),"WebDesigner", super.getFirstName(),super.getLastName() , super.getDob(), super.getGender().toUpperCase(), dateJoin,onCall);
         return text;
     }
     public static void main(String[] arg){
         
     }
}
