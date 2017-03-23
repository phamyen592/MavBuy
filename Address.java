

import java.util.*;

/**
 *
 * @author Yenpham
 */
public class Address {

    private int number;

    private String street;

    private String city;

    private String state;

    /**
     * Constructor: 
     * @param num
     * @param st
     * @param ci
     * @param sta
     */
    public Address(int num, String st, String ci, String sta) {
        number = num;
        street = st;
        city = ci;
        state = sta;
    }

    /**
     * Method: to set a Address from a string 
     * @param address
     */
    public void setAddress(String address) {
        String[] tok = address.split(":");
        try {
            number = Integer.parseInt(tok[0]);
            street = tok[1];
            city = tok[2];
            state = tok[3];
        } catch (Exception e) {
            System.out.println("Invalid address.");
        }
    }

    /**
     * Constructor: create a new default address (number 0, city=street=state= NULL
     */
    public Address() {
    }

    /**
     * Method: to get the State
     * @return state
     */
    public String getState() {
        return state;
    }

    public String toString() {
        return number + " " + street + ", " + city + ", " + state;
    }
}
