

import java.util.*;


/**
 *
 * @author Yenpham
 */
public abstract class Employee {

    private int ID;

    private static int counter = 000;

    private String firstName;

    private String lastName;

    private String gender;

    private Date dob = new Date();

    public abstract double computeSalary(int count);

    /**
     *constructor: default employee
     */
    public Employee() {
        
    }

    /**
     *Method to get employee's first name
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method to get employee's Last name 
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method to get employee ID
     * @return ID
     */
    public int getID() {
        return ID;
    }
    /**
     * Method to get employee Gender
     * @return gender
     */
    public String getGender() {
        return gender;
    }


    /**
     *Method: to get employee's Date of birth 
     * @return dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Method: to get counter
     * @return counter
     */
    public static int getCounter() {
        return counter;
    }

    /**
     * Method: to set counter using to apply an ID for employee
     * @param counter
     */
    public static void setCounter(int counter) {
        Employee.counter = counter;
    }

    /**
     * Method to set customer ID
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public abstract String toString();
    /**
     * Constructor: get those information to construct a new employee
     * 
     * @param fName
     * @param lName
     * @param BDay
     * @param gender
     */
    public Employee(String fName, String lName, String BDay, String gend) {
        counter++;
        ID = counter;
        
        firstName = fName;
        lastName = lName;
        dob.setDate(BDay);
        gender = gend;
       
    }
// public abstract String getType();
//    public abstract boolean isOnCall();
//    public abstract void setRate(double rate);
//    public abstract double getRate();
//    public abstract double getBaseSalary();
//    public abstract void setHireDate(Date date);
//    public abstract Date getHireDate();
//    
    
}
