/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yenpham
 */
public class Accountant extends Employee {
    private Date hireDate;
    private double hourlyRate;
    private final boolean onCall = false;
    private final String  type ="ACCT";
    
    public Accountant(){}
    
    public Accountant(String fName, String lName, String BDay, String gend,String dateHire, double rate){
        
        super(fName,lName,BDay,gend);
        hireDate= new Date();
        hireDate.setDate(dateHire);
        hourlyRate = rate;
        
        
    }

    /**
     *
     * @return
     */
   
    public double getBaseSalary(){
        return 0;
    }
    
    
    public Date getHireDate() {
        return hireDate;
    }
    
    public void setRate(double rate){
        hourlyRate = rate;
    }
    /**
     *
     * @return
     */
   
    public double getRate() {
        return hourlyRate;
    }
  
   
    public boolean isOnCall() {
        return onCall;
    }

    
    public String getType() {
        return type;
    }
   
    public void setHireDate(Date date){
        hireDate= date;
       
    }
    
    @Override
     public double computeSalary(int hours){
        double salary;
        salary = hourlyRate*hours;
        return salary;
    }

    @Override
     public String toString(){
        
        String text = String.format("ID:%-3d %-13s  %-10s %-10s BOD: [%10s] %7s Hire Date: [%10s] On call: %b ",super.getID(),"Accountant", super.getFirstName(),super.getLastName() , super.getDob(), super.getGender().toUpperCase(), hireDate,onCall);
         return text;
     }
     
}
