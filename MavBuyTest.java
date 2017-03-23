/**
 * Author: 	Yen Pham
 * Language:	Java
 * ID:          1001230920
 * date:        07/25/2016
 * Purpose:		This program uses MavBuyTest class to read data from a text file to initialize
 * 				employees, items, clients, etc.
 * 				
 *              It checks and recovers from some exceptions while reading the input file
 *                 uses a bufferedReader which is different from project 2
 *              NO assumptions on the #employees etc. adjust your code accordingly!
 
 *              also shows how to write to an output file
 * 
 * USAGE:       You need to initialize your data structures as the first step. 
 *              once the values are read into local variables, 
 *              it  is YOUR responsibility to add code at proper places to create objects and manage them!
 *
 *              input and output file names are given as a command line argument 
 *              (e.g, java MavBuyTest dataFile-proj3.txt proj3-output.txt)
 *              for the naming convention used in this file. if you forget to give the data 
 *              files as  command line arguments, it will prompt you for that.	
 *          
 *              you can remove or comment out prints once you are sure it is reading the input correctly
 *
 * MAKE SURE:   your program is case insensitive (for state code, city, gender, employee type etc.)
 */




import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @param inputfileName
 *            as input data filename contaning input items with : as item separators
 * @param   outputFileName as output file name 
 */

public class MavBuyTest implements DateConstants, Proj3Constants  {

/**
     *class instance: 
     * companyName: name of the company
     * client: list of Clients 
     * employee: list of Employees
     * items: list of Items
     */
    public String companyName;

    private ArrayList<Client> client = new ArrayList<Client>();

    private ArrayList<Employee> employee = new ArrayList<Employee>();

    private ArrayList<Items> items = new ArrayList<Items>();
    
    private ArrayList<Integer> yearActive = new ArrayList<Integer>();
    

    private static BufferedReader finput;
    private static Scanner cp;  //this is still command prompt
    private static PrintWriter foutput;

    //define other variables as needed

	//Note that we are using a DIFFERENT method for reading input file;
	/**
     * @param fileName
	 * @param iFileName is the input data file name
     * @return 
	 */		

    public static BufferedReader openReadFile(String fileName){
        BufferedReader bf = null;
        try{
            bf = new BufferedReader(new FileReader(fileName));
        }     
        catch(FileNotFoundException FNFE){    
          bf = null;
        }
       finally{
          return bf;
       }
    }

/**
	 * @param oFileName is the input data file name
	 */		

    /**
     *
     * @param fileName
     * @param oFileName is the input data file name
     * @return 
     */
    public static PrintWriter openWriteFile(String fileName){
        PrintWriter outputFile = null;
        try{
            outputFile = new PrintWriter(new FileWriter(fileName));
        }     
        catch(IOException IOE){    
          outputFile = null;
        }
       finally{
          return outputFile;
       }
    }


            /**
             * method: to print the list of all employees
             */
            public void printEmployee() {
                foutput.println("#EMPLOYEES: " + employee.size());
                foutput.println("Type  ID  FirstName  LastName  DOB  Gender  DateJoin  OnCall  BaseSalary");
                for (int i = 0; i < employee.size(); i++) 
                    foutput.println(employee.get(i));
            }

            /**
             * method: to print the list of clients
             */
            public void printClient() {
                foutput.println("#CUSTOMER: " + client.size());
                foutput.println("ID  FirstName  LastName  DOB  Gender  Type  Address");
                for (int i = 0; i < client.size(); i++) 
                    foutput.println(client.get(i));
            }

            /**
             * method: to print the list of items
             */
            public void printItems() {
                foutput.println("#ITEMS: " + items.size());
                foutput.println("ModelID  CompanyName  Condition  ShippingCost  StoreAvailable  AvailabilityDate  ShippingDays  Price  Type");
                for (int i = 0; i < items.size(); i++) foutput.println(items.get(i));
            }

            /**
             * Constructor: default (company Name is NULL, client, items, employee also NULL)
             */
            public MavBuyTest() {
            }

            /**
             * Method : to set the company name
             * @param companyName
             */
            public void setCompanyName(String companyName) {
                this.companyName = companyName;
            }

            /**
             * Method: to get the name of the company
             * @return companyName
             */
            public String getCompanyName() {
                return companyName;
            }

            public ArrayList<Integer> getYearActive() {
                return yearActive;
            }

            public void addYearActive(int year) {
               for(int i=0; i<yearActive.size();i++){
                    if(year ==yearActive.get(i)){
                        return;
                    }
                }

                yearActive.add(year);
            }

                public ArrayList<Client> getClient() {
                    return client;
                }

                public void setClient(ArrayList<Client> client) {
                    this.client = client;
                }

                public ArrayList<Employee> getEmployee() {
                    return employee;
                }

                public void setEmployee(ArrayList<Employee> employee) {
                    this.employee = employee;
                }

                public ArrayList<Items> getItems() {
                    return items;
                }

                public void setItems(ArrayList<Items> items) {
                    this.items = items;
                }

       

            
            
             public int getClientIndex(int clientId){
                 int posClient = -1;
                for (int i = 0; i < client.size(); i++) {
                    if (client.get(i).getID() == clientId)
                        posClient = i;
                }
             return posClient;
             }
             public int getItemIndex(String itemId){
                 int posItem =-1;
                   for (int i = 0; i < items.size(); i++) {
                        if (itemId.toUpperCase().equals(items.get(i).getModelID().toUpperCase())) {
                            posItem = i;
                            break;
                        }
                    }
                   return posItem;
             }
             public int getEmployeeIndex(int empId){
                 int posEmp= -1;
                    for (int i = 0; i < employee.size(); i++) {
                        if (employee.get(i).getID() == empId) {
                            posEmp= i;
                            break;
                        }
                    }
                    return posEmp;
             }
            /**
             * Method:  to print the list of client by state or * for all 
             */
            public void printClientByState() {
                String state = "";
                int count = 0;
                System.out.println("Please input the clients state code. (* for all state)");
                state = cp.next();
                if (state.equals("*")) {
                    this.printClient();
                    count++;
                } else {    
                    for (int i = 0; i < client.size(); i++) {
                        if (state.toUpperCase().equals(client.get(i).getAddress().getState())) {
                            System.out.println(client.get(i));
                            count++;
                        }
                    }
                }
                if (count == 0)
                    System.out.println("There is no customer in the state of " + state);
            }

            
            /**
             * Method : to purchase the items
             */
            public void purchase() {
                int id;
                String IdStr;
                //input the ID of the customer and get possition of the customer in the customer list
                System.out.println("Please input the client ID.");
                IdStr = cp.next();
                int posClient = -1;

                try{
                    id = Integer.parseInt(IdStr);
                }catch (Exception e) {
                    id=0;
                }
                 posClient= getClientIndex(id);
                if (posClient == -1) {
                    System.out.println("The client is not found. Purchase failed.");
                    return;
                }
                //input the ID of the Item and get possition of the item in the items list
                cp.nextLine();// take care of [ENTER] between 2 input
                String itemId;
                int posItem;
                    System.out.println("Please input the items ID:");
                    itemId = cp.nextLine();
                    posItem= getItemIndex(itemId);
                    if (posItem == -1) {
                        System.out.println("The item is not found. Purchase failed.");
                        return;
                    }

                //input date of purchase from user. The date has to be after availability date of the item
                Date date = new Date();

                    System.out.println("What date of purchase? [mm-dd-yyyy]");
                    String dateString = cp.nextLine();


                    date.setDate(dateString);
                    if (date.isValid() == false) {
                        System.out.println("Invalid date. Purchase failed.");
                        return;
                    }
                    if (date.isBefore(items.get(posItem).getAvailableDate())){
                        System.out.println("The item is available after " + items.get(posItem).getAvailableDate()+". Purchase failed");
                        return;
                    }

                //input quantity of items from user. Quantity have to be greater than 0
                int quan;
                    System.out.println("how many do they want to buy?");
                     quan = cp.nextInt();
                     if (quan <1)
                         System.out.println("Quantity has to be >0. Purchase failed. ");

                //input store from user. the store have to be 0-9. then check for availability
                int store;
                do {
                    System.out.println("Which store do they want to buy? (input store id 0-9)(or q to quit from purchasing)");
                    String storeStr = cp.next();
                    if (storeStr.equals("q"))
                        return;
                    try{
                        store =Integer.parseInt(storeStr);
                    }catch(Exception e){
                        store =-1;
                    }
                    if (store < 0 && store > 9) {
                        System.out.println("Invalid store. Please enter again.");
                        continue;
                    }
                    if (items.get(posItem).isAvailable(store, quan) == false) {
                        System.out.println("Out of stock. Please choose another store. ");
                        continue;
                    }
                    break;
                } while (true);
                //construct a new PurchaseItem object with all the information just got from user
                PurchaseItem purchase = new PurchaseItem(itemId, quan, date, store);
                //add a new purchase to the list of purchase of client
                client.get(posClient).addPurchaseItem(purchase);
                //reduce the store availability 
                items.get(posItem).setAvailableByIndex(store, items.get(posItem).getStoreAvailability()[store] - quan);
                System.out.println("Process is successful");
            }

            
            
            /**
             * Method: to release a employee from the list
     * @param employeeId
             */
            public void releaseEmployee(int employeeId) {
                
      
                boolean found = false;
                for (int i = 0; i < employee.size(); i++) {
                    if (employee.get(i).getID() == employeeId) {
                        employee.remove(i);
                        foutput.println("Releassing Employee Id: "+ employeeId);
                        foutput.println(employee.get(i));
                        foutput.println();
                        found = true;
                        break;
                    }
                }
                if (!found)
                    foutput.println("Employee "+ employeeId+" does not exist.");
                this.printEmployee();
                    foutput.println();
            }

            /**
             * Method: to print a particular customer details include customer ID, Name, and purchased history
     * @param clientId
             */
            public void printPortfolioClient(int clientId) {
                //input the ID of the customer and get possition of the customer inthe list
                int posClient = this.getClientIndex(clientId);
                if (posClient == -1) {
                    foutput.println("Client "+clientId+" does not exist.");
                    return;
                }
                
                // check if the customer not buy anything yet.
                if (client.get(posClient).getBuyList().size() == 0) {
                    foutput.println("Client "+clientId+" had not purchased any items.");
                    return;
                }
                // print customer's purchase history
                foutput.println("Purchases from client "+clientId+" in all year.");
                for (int i = 0; i < client.get(posClient).getBuyList().size(); i++) {
                    foutput.printf("%s by %s %s\n",client.get(posClient).getBuyList().get(i),client.get(posClient).getFirstName() ,client.get(posClient).getLastName());
                    
                }
                foutput.println();
            }

    /**
     *
     * @param clientId
     * @param itemId
     * @param date
     * @param quan
     * @param store
     */
    public void processPurchase(int clientId, String itemId, Date date, int quan, int store){
            
                int posClient= getClientIndex(clientId);
           
                if (posClient == -1) {
                    foutput.println("The client is not found. Purchase failed.");
                    return;
                }
 
                int posItem=getItemIndex(itemId);
                    if (posItem == -1) {
                       foutput.println("The item is not found. Process purchase: "+ clientId+" "+itemId+" "+ date+" "+ quan + " "+ store+" failed.");
                        return;
                    }

                //input date of purchase from user. The date has to be after availability date of the item

                    if (date.isValid() == false) {
                        foutput.println("Invalid date. Process purchase: "+ clientId+" "+itemId+" "+ date+" "+ quan + " "+ store+" failed.");
                        return;
                    }
                    if (date.isBefore(items.get(posItem).getAvailableDate())){
                        foutput.println("The item is available after " + items.get(posItem).getAvailableDate()+". Process purchase: "+ clientId+" "+itemId+" "+ date+" "+ quan + " "+ store+" failed.");
                        return;
                    }

               // Quantity have to be greater than 0
                     if (quan <1){
                         foutput.println("Quantity has to be >0. Process purchase: "+ clientId+" "+itemId+" "+ date+" "+ quan + " "+ store+" failed. ");
                         return;
                     }

                // the store have to be 0-9. then check for availability
                
                      if (store < 1||store>10) {
                        foutput.println("Invalid store. Process purchase: "+ clientId+" "+itemId+" "+ date+" "+ quan + " "+ store+" failed." );
                        return;
                   
                    }
                System.out.println("pass"+clientId);
                   
                    if (items.get(posItem).isAvailable(store, quan) == false) {
                        foutput.println("Out of stock. Process purchase: "+ clientId+" "+itemId+" "+ date+" "+ quan + " "+ store+" failed.");
                       return;
                    }
     
                //construct a new PurchaseItem object with all the information just got from user
                PurchaseItem purchase = new PurchaseItem(itemId, quan, date, store);
                double amount = items.get(posItem).getPrice()*quan;
                if (client.get(posClient).getType().toLowerCase().equals("gold")){
                    amount = amount*0.9;
                }
                purchase.setAmount(amount);
                purchase.setShipping(items.get(posItem).getShippingCost());
                //add a new purchase to the list of purchase of client
                client.get(posClient).addPurchaseItem(purchase);
                //reduce the store availability 
                items.get(posItem).setAvailableByIndex(store-1, items.get(posItem).getStoreAvailability()[store-1] - quan);
                Sales sale= new Sales(clientId,quan,date,amount, store);
                items.get(posItem).addSales(sale);
                this.addYearActive(date.getYear());
               client.get(posClient).addAmountByYear(amount+items.get(posItem).getShippingCost(), date.getYear());
                    foutput.printf("client: %d %-10s %-10s bought", clientId,client.get(posClient).getFirstName(),client.get(posClient).getLastName());
                    foutput.printf("%s",purchase);
                    foutput.printf("\n");
                    
                
                
                
            
        }
        
    /**
     *
     * @param clientId
     * @param year
     */
    public String list_purchase_year(int clientId, int year){
            int posClient= this.getClientIndex(clientId);
                if (posClient == -1) {
                    foutput.println("Client "+clientId+" does not exist.");
                    return "Client "+clientId+" does not exist.";
                }
                
                // check if the customer not buy anything yet.
                if (client.get(posClient).getBuyList().isEmpty()) {
                    
                    foutput.println("Client " +clientId+" had not purchased any item.");
                    foutput.println();
                    return "Client " +clientId+" had not purchased any item.";
                }
                int count = 0;
                for(int i= 0; i< client.get(posClient).getBuyList().size(); i++){
                    if (client.get(posClient).getBuyList().get(i).getDate().getYear()==year)
                        count++;
                }
                if (count==0){
                    foutput.println("Client " +clientId+" had not purchased any items in "+year);
                    foutput.println();
                    return "Client " +clientId+" had not purchased any items in "+year;
                }
         String text = "";
                // print customer's purchase history
                foutput.println("Purchases from client "+client.get(posClient).getFirstName()+" "+ client.get(posClient).getLastName()+" in "+ year+": ");
                text+=" \n + Purchases from client "+client.get(posClient).getFirstName()+" "+client.get(posClient).getLastName()+" in "+ year+": \n";
                for(int i= 0; i< client.get(posClient).getBuyList().size(); i++){
                    if (client.get(posClient).getBuyList().get(i).getDate().getYear()==year){
                    foutput.println(client.get(posClient).getBuyList().get(i)+ " by " +client.get(posClient).getFirstName()+" "+ client.get(posClient).getLastName());
                    double amount = client.get(posClient).getBuyList().get(i).getAmount()+client.get(posClient).getBuyList().get(i).getShipping();
                    text+= " Client ID: "+clientId+"\n Item ID: "+client.get(posClient).getBuyList().get(i).getItemID()+"\n Store: "+client.get(posClient).getBuyList().get(i).getStoreID()+"\n Quantity: "+client.get(posClient).getBuyList().get(i).getQuantity()+"\n Amount (include Shipping): $"+ Math.round(amount*100.0)/100.0+ "\n\n";
                    }
                }
                foutput.println();
                
                    return text;
        }
public String ListPurchaseAll(int clientId){
    int posClient= this.getClientIndex(clientId);
                if (posClient == -1) {
                    foutput.println("Client "+clientId+" does not exist.");
                    return "Client "+clientId+" does not exist.";
                }
                String text="";
                for(int i= 0; i<yearActive.size();i++){
                    text+=list_purchase_year(clientId,yearActive.get(i));
                }
                return text;
}
    /**
     *
     * @param empType
     * @param empFName
     * @param empLName
     * @param empBDate
     * @param empGender
     * @param empHireDate
     * @param empBaseSalary
     * @param empRate
     */
    public void hireEmployee(String empType, String empFName, String empLName, String empBDate, String empGender, String empHireDate, double empBaseSalary,double empRate){
                    
                Employee temp= null;
				//create a new employee
                if (empType.toUpperCase().equals("WD")){
                    temp = new WebDesigner(empFName, empLName, empBDate, empGender, empHireDate, empBaseSalary,empRate);
                }else if (empType.toUpperCase().equals("AGT")){
                    temp = new Agent(empFName, empLName, empBDate, empGender, empHireDate, empBaseSalary,empRate);
                }else if(empType.toUpperCase().equals("ACCT")){
                    temp = new Accountant(empFName, empLName, empBDate, empGender, empHireDate,empRate);
                     }
                
                //add employee to the list
                if (temp!=null)
                employee.add(temp);
                foutput.println(temp);
            }
             
    /**
     *
     * @param empId
     * @param count
     * @param month
     */
    public String employeeSalary(int empId, int count, int month){
                    String month_array[]= {" ","JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
                   String text="";
                    int posEmp= this.getEmployeeIndex(empId);
                    if (posEmp==-1){
                        foutput.println("Employee " + empId+" does not exist.");
                        text += "Employee " + empId+" does not exist.";
                        foutput.println();
                        return text;
                    }
                    if (month<1||month>12)
                        return "Invalid Month.";
                    double salary = employee.get(posEmp).computeSalary(count);
                    int id = employee.get(posEmp).getID();
                    String type="";
                    if(employee.get(posEmp) instanceof WebDesigner){
                        type ="WebDesigner";
                    }else if(employee.get(posEmp) instanceof Agent){
                        type= "Agent";
                    }else if (employee.get(posEmp) instanceof Accountant){
                            type="Accountant";
                    }
                    String fname = employee.get(posEmp).getFirstName();
                    String lname = employee.get(posEmp).getLastName();
                    String gender = employee.get(posEmp).getGender();
                    
                    String text2 = String.format("ID: %-4d, Type: %-13s, First Name: %-10s, Last Name: %-10s, Gender: %-8s, Month: %-12s, Salary: %-10.2f",id, type, fname,lname,gender,month_array[month],salary);
                    foutput.println(text2);
                    foutput.println();
                    text +=  String.format("ID: %-4d\nType: %-13s\nFirst Name: %-10s\nLast Name: %-10s\nGender: %-8s\nMonth: %-12s\nSalary: %-10.2f",id, type, fname,lname,gender,month_array[month],salary);
                    return text;
               }
               
    /**
     *
     * @param itemId
     * @return 
     */
    public String expenditure (String itemId){
                    String text = "";
                    String text2="";
                   int posItem = this.getItemIndex(itemId);
                    if (posItem == -1) {
                       foutput.println("The item "+ itemId+" is not found.");
                        return "The item "+ itemId+" is not found.";
                    }
                    if (items.get(posItem).getSalesList().size()==0){
                        foutput.println("No item "+itemId+" had been sold.");
                        foutput.println();
                        return "No item "+itemId+" had been sold.";
                    }
                        foutput.println("Item "+itemId+": ");
                        double rev=0;
                        for(int i =0; i<yearActive.size();i++){
                            rev+=revenueByItemPerYear(itemId,yearActive.get(i));
                            text2+=revenueByItemIDPerYear(itemId,yearActive.get(i));
//                         int posClient = this.getClientIndex(items.get(posItem).getSalesList().get(i).getClientId());
//                         
//                         double amount= items.get(posItem).getSalesList().get(i).getAmount()+items.get(posItem).getShippingCost();
//                        foutput.printf("%d Item: %-15s was sold on [%s] to %-10s %-10s for $%.2f\n",items.get(posItem).getSalesList().get(i).getQuan(),
//                                itemId, client.get(posClient).getBuyList().get(i).getDate(),client.get(posClient).getFirstName(), client.get(posClient).getLastName(), amount);
//                                text+= String.format("Item: %-15s\nSold Date: [%s]\nClient: %-10s %-10s\n Quantity: %d\nAmount (include Shipping cost): $%.2f\n\n",
//                                itemId, client.get(posClient).getBuyList().get(i).getDate(),client.get(posClient).getFirstName(), client.get(posClient).getLastName(),items.get(posItem).getSalesList().get(i).getQuan(), amount);                                }
                        
                        }
                            foutput.println();   
                            text =" Total revenue of the item "+itemId+" is $"+Math.round(rev*100.0)/100.0+"\n\n";
                            text+=text2;
                     return text;
                     }
    public ArrayList<String> itemTypeList(){
        ArrayList<String>listType = new ArrayList<String>();
        for(int i = 0; i<items.size();i++){
           int  pos =-1;
            for(int j =0 ;j<listType.size();j++){
                if (items.get(i).getType().equals(listType.get(j))){
                    pos = j;
                    break;
                }
            }
            if (pos==-1){
                listType.add(items.get(i).getType());
            }
            
        }
        return listType;
    }
    public int indexOfType(String type){
        int  pos =-1;
            for(int j =0 ;j<itemTypeList().size();j++){
                if (type.equals(itemTypeList().get(j))){
                    pos = j;
                    break;
                }
            }
            return pos;
            
    }
     public double revenueByItemPerYear(String itemId,int year){
           double rev=0;
                  int posItem = this.getItemIndex(itemId);
                    if (posItem == -1) {
                       foutput.println("The item "+ itemId+" is not found.");
                       return rev;
                    }
                   
                    int yearPos = -1;
                    for(int i=0;i<this.yearActive.size();i++){
                        if (year==yearActive.get(i))
                            yearPos= i;
                    }
                    if (yearPos ==-1)
                       return rev;
          for (int i =0; i<items.size();i++){
              if(items.get(i).getModelID().equals(itemId)){
              for(int j=0;j<items.get(i).getSalesList().size();j++){
                  if (items.get(i).getSalesList().get(j).getDate().getYear()==year){
                      
                 //int posClient = this.getClientIndex(items.get(i).getSalesList().get(j).getClientId());
                double amount= items.get(i).getSalesList().get(j).getAmount()+items.get(i).getShippingCost();
                    rev += amount;
                  }
              }
          }
         
          }       
                  
          return rev;
      }   
    
    public double revenueByTypePerYear(String type,int year){
           double rev=0;
                  int posType = this.indexOfType(type);
                    if (posType == -1) {
                       foutput.println("The item "+ type+" is not found.");
                       return rev;
                    }
                   
                    int yearPos = -1;
                    for(int i=0;i<this.yearActive.size();i++){
                        if (year==yearActive.get(i))
                            yearPos= i;
                    }
                    if (yearPos ==-1)
                       return rev;
          for (int i =0; i<items.size();i++){
              if(items.get(i).getType().equals(type)){
              for(int j=0;j<items.get(i).getSalesList().size();j++){
                  if (items.get(i).getSalesList().get(j).getDate().getYear()==year){
                      
                 //int posClient = this.getClientIndex(items.get(i).getSalesList().get(j).getClientId());
                double amount= items.get(i).getSalesList().get(j).getAmount()+items.get(i).getShippingCost();
                    rev += amount;
                  }
              }
          }
         
          }       
                  
          return rev;
      }   
     public String  revenueByItemIDPerYear(String itemId,int year){
          String text = "";
        String text2="";
                  int posItem = this.getItemIndex(itemId);

                    if (posItem == -1) {
                       foutput.println("The type "+ itemId+" is not found.");
                        return " + The type "+ itemId+" is not found.";
                    }
                    
                    int yearPos = -1;
                    for(int i=0;i<this.yearActive.size();i++){
                        if (year==yearActive.get(i))
                            yearPos= i;
                    }
                    if (yearPos ==-1)
                        return "Inactived year.";
          double rev=0;
           for (int i =0; i<items.size();i++){
              if(items.get(i).getModelID().equals(itemId)){
              for(int j=0;j<items.get(i).getSalesList().size();j++){
                  if (items.get(i).getSalesList().get(j).getDate().getYear()==year){
                 int posClient = this.getClientIndex(items.get(i).getSalesList().get(j).getClientId());
                double amount= items.get(i).getSalesList().get(j).getAmount()+items.get(i).getShippingCost();
                    rev+=amount;
                  text2+= String.format(" Item: %-15s\n Type: %s\n Sold Date: [%s]\n Client: %-10s %-10s\n Quantity: %d\n Amount (include Shipping cost): $%.2f\n\n",
                                items.get(i).getModelID(),items.get(i).getType(), items.get(i).getSalesList().get(j).getDate(),client.get(posClient).getFirstName(), client.get(posClient).getLastName(),items.get(i).getSalesList().get(j).getQuan(), amount);
                  }
              }
              }
           }
        if (rev==0){
                    
            text+= " + In "+ year+", total revenue from "+ itemId+" is $"+Math.round(rev*100.0)/100.0+"\n\n";
             text+= "  No item "+itemId+" had been sold in"+ year +" .\n\n";
            return text;
        }
          text += " + In "+ year+", total revenue from "+ itemId+" is $"+Math.round(rev*100.0)/100.0+"\n\n";
          text += "";
       text += text2;
                  
                  
          return text;
      }  
      public String  revenueByCatePerYear(String type,int year){
          String text = "";
        String text2="";
                  int posType = this.indexOfType(type);

                    if (posType == -1) {
                       foutput.println("The type "+ type+" is not found.");
                        return " + The type "+ type+" is not found.";
                    }
                    
                    int yearPos = -1;
                    for(int i=0;i<this.yearActive.size();i++){
                        if (year==yearActive.get(i))
                            yearPos= i;
                    }
                    if (yearPos ==-1)
                        return "Inactived year.";
          double rev=0;
           for (int i =0; i<items.size();i++){
              if(items.get(i).getType().equals(type)){
              for(int j=0;j<items.get(i).getSalesList().size();j++){
                  if (items.get(i).getSalesList().get(j).getDate().getYear()==year){
                 int posClient = this.getClientIndex(items.get(i).getSalesList().get(j).getClientId());
                double amount= items.get(i).getSalesList().get(j).getAmount()+items.get(i).getShippingCost();
                    rev+=amount;
                  text2+= String.format(" Item: %-15s\n Type: %s\n Sold Date: [%s]\n Client: %-10s %-10s\n Quantity: %d\n Amount (include Shipping cost): $%.2f\n\n",
                                items.get(i).getModelID(),type, items.get(i).getSalesList().get(j).getDate(),client.get(posClient).getFirstName(), client.get(posClient).getLastName(),items.get(i).getSalesList().get(j).getQuan(), amount);
                  }
              }
              }
           }
        if (rev==0){
                    
            text+= "+ In "+ year+", total revenue from "+ type+" is $"+Math.round(rev*100.0)/100.0+"\n\n";
             text+= "  No item "+type+" had been sold in"+ year +" .\n\n";
            return text;
        }
          text += "+ In "+ year+", total revenue from "+ type+" is $"+Math.round(rev*100.0)/100.0+"\n\n";
          text += "";
       text += text2;
                  
                  
          return text;
      }     
      public String revenuePerType(String type){
          String text = "++ Total revenue for the category of " +type+" ";
                  double rev=0;
                  String text2="";
                  
          for (int i=0; i<yearActive.size();i++){
              rev+=revenueByTypePerYear(type,yearActive.get(i));
              text2+=revenueByCatePerYear(type,yearActive.get(i));
          }
          text+=Math.round(rev*100.0)/100.0 +"\n\n";
          text+= text2;
         return text; 
      }
      public String revenueAllYear(){
          String text = "+++ Total revenue for "+companyName+" in all Year is $";
          double total=0;
          for(int i=0; i<this.itemTypeList().size();i++){
              for(int j=0; j<yearActive.size();j++){
                  total+=revenueByTypePerYear(itemTypeList().get(i),yearActive.get(j));
              }
                  
          }
          text+= Math.round(total*100.0)/100.0 + "\n\n";
          for(int j=0; j<yearActive.size();j++){
              text+=revenuePerYear(yearActive.get(j));
          }
          return text;
      }
    public String revenuePerYear(int year){
        double total =0; 
        String text="";
        String text2="The revenue generated in "+year+" by each type: \n\n";
        int yearPos = -1;
           for(int i=0;i<this.yearActive.size();i++){
                 if (year==yearActive.get(i))
                        yearPos= i;
                    }
            if (yearPos ==-1)
                   return "Inactived year.";
//       
        for(int i =0 ; i<itemTypeList().size();i++){
            total+= revenueByTypePerYear(itemTypeList().get(i), year);
            text2+= revenueByCatePerYear(itemTypeList().get(i), year);
        }
        text+= "++ Total revenue for "+companyName+" in "+year+" is $"+Math.round(total*100.0)/100.0+".\n\n";
        text+= text2;
        return text;
    }
    /**
     *
     * @param clientId
     * @param year
     * @return
     */
    public String clientStatusByYear(int clientId, int year){
                   int posClient= this.getClientIndex(clientId);
                   if (client.get(posClient).getAmountByYear(year-1)>=1000)
                       return "GOLD";
                   return "REGULAR";
               }

    public String spentLowestHighest(int year){
        String text = "";
        double max = 0,min=99999999999.9999;
         int yearPos = -1;
                    for(int i=0;i<this.yearActive.size();i++){
                        if (year==yearActive.get(i)){
                            yearPos= i;
                        break;}
                    }
                    if (yearPos ==-1)
                        return " Inactived year.";
        
        for(int i=0; i<client.size();i++){
            if(client.get(i).getAmountByYear(year)>max&&client.get(i).getAmountByYear(year)>0.0){
                max= client.get(i).getAmountByYear(year);
               
            }else if(client.get(i).getAmountByYear(year)<min&&client.get(i).getAmountByYear(year)>0.0){
                min= client.get(i).getAmountByYear(year);
               
            }
        }
        text+= String.format("+ Customer(s) spent highest amount in %d\n",year);
        for(int i=0; i<client.size();i++){
            if(client.get(i).getAmountByYear(year)==max){
               Client tempmax = client.get(i);
                  text+= String.format("\n Name: %s, %s\n Type: %s\n DOB: %s\n Amount spent: $%.2f\n\n",
                tempmax.getLastName(), tempmax.getFirstName(),clientStatusByYear(tempmax.getID(),year),tempmax.getDob(),tempmax.getAmountByYear(year) );
     
            }
        }
        text+= String.format("+ Customer(s) spent lowest amount in %d\n",year);
        for(int i=0; i<client.size();i++){
            if(client.get(i).getAmountByYear(year)==min&&client.get(i).getAmountByYear(year)>0.0){
                 Client tempmin = client.get(i);
                text+= String.format("\n Name: %s, %s\n Type: %s\n DOB: %s\n Amount spent: $%.2f\n\n",
                tempmin.getLastName(), tempmin.getFirstName(),clientStatusByYear(tempmin.getID(),year),tempmin.getDob(),tempmin.getAmountByYear(year) );
    
                
            }
        }
           return text;
    }
    /**
     *
     * @param clientIdStr
     * @param yearStr
     */
    public void clientStatus(String clientIdStr, String yearStr ){
                   
                  if(clientIdStr.equals("*")){
                       foutput.printf("Membership Status for All Client: \n");
                      for (int i=0;i <client.size();i++){
                          
                        if (yearStr.equals("*")){
    
                              foutput.printf("\tMembership Status for Client %d ",client.get(i).getID());
                              foutput.printf("in all year\n");
                              for (int j = 0; j<this.getYearActive().size();j++){

                                  foutput.printf("\t%d:",yearActive.get(j));
                                  foutput.printf(" Client: %-4d,%-15s,%-15s, type for the following year is %-8s with purchased total of %.2f\n", 
                                          client.get(i).getID(),client.get(i).getFirstName(),client.get(i).getLastName()
                                          ,clientStatusByYear(client.get(i).getID(),yearActive.get(j)+1), client.get(i).getAmountByYear(yearActive.get(j)) );
                           
                              } foutput.println();
                            }
                        else{
                            foutput.printf("\tMembership Status for Client %d ",client.get(i).getID());
                               int  year= Integer.parseInt(yearStr);
                          foutput.printf("\tin %d\n",year);
                                  foutput.printf("Client: %-4d,%-15s,%-15s, type for the following year is %-8s, with purchased total of %.2f\n", 
                                          client.get(i).getID(),client.get(i).getFirstName(),client.get(i).getLastName()
                                          ,clientStatusByYear(client.get(i).getID(),year+1), client.get(i).getAmountByYear(year)  );
                           
                      }
                         foutput.println();
                  }
                   
                   
                  }else {
                      int clientId= Integer.parseInt(clientIdStr);
                      int posClient =this.getClientIndex(clientId);
                            if (posClient == -1) {
                                foutput.println("Not found");
                                foutput.println();
                                return;
                          } 
                      
                       if (yearStr.equals("*")){
                               
//                              
                              
                               foutput.printf("Membership Status for Client %d in all year:\n",clientId);
                               
                              for (int j = 0; j< yearActive.size();j++){
                                 
                                  foutput.printf("In %d: ",yearActive.get(j));
                                  foutput.printf("Client: %-4d,%-15s,%-15s, type for the following year is %-8s, with purchased total of %.2f\n", 
                                          client.get(posClient).getID(),client.get(posClient).getFirstName(),client.get(posClient).getLastName()
                                          ,clientStatusByYear(clientId,yearActive.get(j)+1), client.get(posClient).getAmountByYear(yearActive.get(j))  );
                           
                              }
                              foutput.println();
                            }
                        else{
                           
                               int  year= Integer.parseInt(yearStr);
                               foutput.printf("Membership Status for Client %d ",clientId);
                          foutput.printf("in %d\n",year);
                                  foutput.printf("Client: %-4d,%-15s,%-15s,type for the following year is %-6s, with purchased total of %.2f\n", 
                                          clientId,client.get(posClient).getFirstName(),client.get(posClient).getLastName()
                                          ,clientStatusByYear(clientId,year+1), client.get(posClient).getAmountByYear(year)  );
                                  foutput.println();
                       }
                       
                  }
               }
	/**
     * @param args
	 * @param takes
	 *            fileNames as command line argument. prompts if not given
	 */
	public static void main(String[] args) {

		// declare variables used for input handling
            String enterprisename = DEFAULT_ENTERPRISE_NAME;
            String inputLine = "", ifName = "", ofName = "";
            MavBuyTest company = new MavBuyTest();
		// determine if correct input file is provided

		cp = new Scanner(System.in);
		if (args.length <= 1) {
			System.out.println("Input Data file name was not supplied");
			System.out.printf("Please type input data file name: ");
			ifName = cp.nextLine();
                         
        
		}
        else if (args.length <= 3){
           ifName =  args[ZEROI];       
         
            System.out.printf("Please type output data file name: ");
            ofName =cp.nextLine();
        } else {
            ifName = args[ZEROI];
            ofName = args[ONEI];
           }

		// See HOW RECOVERY is done (will cover next week)
		//System.out.println("ifName ="+ifName);
		//System.out.println("ofName ="+ofName);
		finput = openReadFile(ifName);
		while (finput == null) {
			System.out.println("ifName ="+ifName);
			System.out.println("Error: Input FILE "+ ifName+" does not exist.\nEnter correct file name: ");
			ifName = cp.nextLine();
			finput = openReadFile(ifName);
		}
       foutput = openWriteFile(ofName);
		System.out.println("ofName ="+ofName);
        while (foutput == null){
			System.out.printf("Error: Output FILE %s %s",  ofName,  " does not exist.\nEnter correct file name: ");
            ofName = cp.nextLine();
            foutput = openWriteFile(ofName);
		}  

		/* GET MavBuyTest DETAILS */
		// start reading from data file
		// get name
		try {
			inputLine = finput.readLine();
			while (inputLine.charAt(BASE_INDEX) == '/')
				inputLine = finput.readLine();
			String enterpriseName = inputLine;
			System.out.printf("\n%s %s \n", "Enterprise name is: ",
					enterpriseName);

                        company.setCompanyName(enterpriseName);
			/* GET EMPLOYEE DETAILS */

			// reading details for each employee from the data file
	        int numEmployees = 0;
            inputLine = finput.readLine();
			while (inputLine.charAt(BASE_INDEX) == '/')
					inputLine = finput.readLine();		
			while ( (!inputLine.toLowerCase().equals("end"))){
            	
                           
				String[] chopEmp = inputLine.split(":");

				// fill all fields for a single employee from a single line
				String empType = chopEmp[ZEROI];
				String empFName = chopEmp[ONEI];
			    String empLName = chopEmp[TWOI];
				String empBDate = chopEmp[THREEI];
				String empGender = chopEmp[FOURI];
				String empHireDate = chopEmp[FIVEI];
                double empBaseSalary = Double.parseDouble(chopEmp[SIXI]);
                double empRate = Double.parseDouble(chopEmp[SEVENI]);
                Employee temp= null;
				//create a new employee
                if (empType.toUpperCase().equals("WD")){
                    temp = new WebDesigner(empFName, empLName, empBDate, empGender, empHireDate, empBaseSalary,empRate);
                }else if (empType.toUpperCase().equals("AGT")){
                    temp = new Agent(empFName, empLName, empBDate, empGender, empHireDate, empBaseSalary,empRate);
                }else if(empType.toUpperCase().equals("ACCT")){
                    temp = new Accountant(empFName, empLName, empBDate, empGender, empHireDate,empRate);
                     }
                
                //add employee to the list
                if (temp!=null)
                company.employee.add(temp);
                         
				
				// add code here: also, empTYpe is read as a string; if u are using a
				// enum, you need to convert it  using a switch or if statement

                //add this employee to array list
                inputLine = finput.readLine();
				while (inputLine.charAt(BASE_INDEX) == '/')
					inputLine = finput.readLine();	
                numEmployees +=1;
			}
            System.out.printf("#Employees: %d\n", numEmployees);

			// reading details of items from the data file
			System.out.printf("\nItems: \n");

            int numItems =0;
			inputLine = finput.readLine();
			while (inputLine.charAt(BASE_INDEX) == '/')
					inputLine = finput.readLine();

            while ( (!inputLine.toLowerCase().equals("end"))){
				String[] chopitem = inputLine.split(":");

				// get all fields of the donor
				String itemId = chopitem[ZEROI];
                String itemCompanyName = chopitem[ONEI];
                String itemCondition = chopitem[TWOI];
				double itemShippingCost = Double.parseDouble(chopitem[THREEI]);
                String itemAvailability = chopitem[FOURI];
				String itemAvailabilityDate = chopitem[FIVEI];
                double itemShippingDays = Double.parseDouble(chopitem[SIXI]);
				double itemPrice = Double.parseDouble(chopitem[SEVENI]);
				String itemCategory = chopitem[EIGHTI];
				
                   
				// create a new item
                Items temp = new Items(itemId, itemCompanyName, itemCondition, itemShippingCost, itemAvailability, itemAvailabilityDate, itemShippingDays, itemPrice, itemCategory);
                // add the new item to the list
                company.items.add(temp);
				// add code here to add item object to the enterprise

                inputLine = finput.readLine();
				while (inputLine.charAt(BASE_INDEX) == '/')
					inputLine = finput.readLine();	
                numItems +=1;
			}
            System.out.printf("#Items: %d\n", numItems);

			/* GET CLIENT DETAILS */

			// reading details for each client from the data file
			System.out.printf("\nClients: \n");
			
            int numClients =0;
			inputLine = finput.readLine();
			while (inputLine.charAt(BASE_INDEX) == '/')
				inputLine = finput.readLine();

            while ( (!inputLine.toLowerCase().equals("end"))){
				String[] chopAthlete = inputLine.split(":");

				// fill all fields for a single client from a single line
				String[] chopClient = inputLine.split(":");
									
				// fill all fields for a single client from a single line 
				int clientId = Integer.parseInt(chopClient[ZEROI]);
				String clientFName = chopClient[ONEI];
                String clientLName = chopClient[TWOI];
				String clientDOB = chopClient[THREEI];
				String clientGender = chopClient[FOURI];
				String clientMemType = chopClient[FIVEI]; 
				int  clientHouseNum = Integer.parseInt(chopClient[SIXI]);
                String clientStreet = chopClient[SEVENI];
                String clientCity = chopClient[EIGHTI];
                String clientState = chopClient[NINEI];
                
				// add code: construct client object as appropriate
				
				// create a new client
                Client temp = new Client(clientId, clientFName, clientLName, clientDOB, clientGender, clientMemType, clientHouseNum, clientStreet, clientCity, clientState);
                // add the client to the list
                company.client.add(temp);

                inputLine = finput.readLine();
				while (inputLine.charAt(BASE_INDEX) == '/')
					inputLine = finput.readLine();
                numClients += 1;
			}
            System.out.printf("#clients: %d\n", numClients);
            
			// process menu from here
           
            int option=10;
          
		
            while ((inputLine = finput.readLine()) != null){
            if (inputLine.charAt(BASE_INDEX) == '/'){
                //System.out.println(inputLine);
                foutput.println(inputLine);
                foutput.println();
            }
            else {
                    
             //add code: for processing them; use a switch statement after converting the first field
             //you can use foutput.print or foutput.println statements to write to an output file 
            String tok[]= inputLine.split(":");
            int num=0;
            try {
                num = Integer.parseInt(tok[0]);
            }catch (Exception e){
               foutput.println(inputLine+" Invalid input data form");
               continue;
            }
            if(num!=option&& num!=0){
                foutput.println();
                foutput.println("---------------------------Menu Item Numer: "+num);
                foutput.println();
                foutput.println();
            }
            option=num;
            switch(option) {
                case 0:
                    foutput.println("---------End of program.----------");
                    break;
                case 10:
                                foutput.println();	
                               foutput.println("------------ WELCOME TO "+company.getCompanyName()+"------------");
                                    foutput.println();	
                            foutput.printf("1.) List employee details \n2.) List client in a state \n3.) List portfolio of a client \n4.) Release an employee\n5.) List item details \n6.) Display customer details \n7.) Purchase items \n0.) Exit\n");
                            
                    break;
                case 11:
                    int clientId=0, quan=0, store=0;
                    String itemId="";
                    Date date= new Date();
                   try{
                        clientId = Integer.parseInt(tok[1]);
                        itemId= tok[2];
                        date.setDate(tok[3]);
                        quan = Integer.parseInt(tok[4]);
                        store = Integer.parseInt(tok[5]);
                   }catch(Exception e){
                foutput.println(inputLine+" Invalid input data form "+option);
                break;
                   } 
                    
                    company.processPurchase(clientId,itemId,date,quan,store);
                    
                    break;
                case 12:
                    String year;
                        try{
                        clientId = Integer.parseInt(tok[1]);
                        year = tok[2];
                        if(year.equals("*")){
                            company.printPortfolioClient(clientId);
                        }else{
                        int y= Integer.parseInt(year);
                        company.list_purchase_year(clientId,y);
                         foutput.println();
                        }
                        }catch (Exception e){
                            foutput.println(inputLine+" Invalid input data form "+option);
                            break;
                        }
                     
                  
                    break;
                case 13:
                    try{
                    String empType = tok[ONEI];
				String empFName = tok[TWOI];
			    String empLName = tok[THREEI];
				String empBDate = tok[FOURI];
				String empGender = tok[FIVEI];
				String empHireDate = tok[SIXI];
                double empBaseSalary = Double.parseDouble(tok[SEVENI]);
                double empRate = Double.parseDouble(tok[EIGHTI]);
                company.hireEmployee(empType,empFName,empLName,empBDate,empGender,empHireDate,empBaseSalary,empRate);
                    System.out.println(option);
                    }catch(Exception e){
                            foutput.println(inputLine+" Invalid input data form "+option);
                            break;
                            }
                    break;
                case 14:
                    try{
                    int empId= Integer.parseInt(tok[ONEI]);
                    company.releaseEmployee(empId);
                    System.out.println(option);
                    }catch(Exception e){
                            foutput.println(inputLine+" Invalid input data form "+option);
                            break;
                    }
                    break;
                case 15:
                    try{
                    int empId = Integer.parseInt(tok[ONEI]);
                    int count = Integer.parseInt(tok[TWOI]);
                    int month = Integer.parseInt(tok[THREEI]);
                    
                    company.employeeSalary(empId, count, month);
                    System.out.println(option);
                    }catch(Exception e){
                            foutput.println(inputLine+" Invalid input data form "+option);
                            break;
                    }
                    break;
                case 16:
                    try{
                    itemId = tok[ONEI];
                    company.expenditure(itemId);
                    System.out.println(option);
                    }catch(Exception e){
                            foutput.println(inputLine+" Invalid input data form "+option);
                            break;
                    }
                    break;
                case 17:
                    try{
                    String clientIdStr = tok[ONEI];
                    String yearStr = tok[TWOI];
                    company.clientStatus(clientIdStr,yearStr );
                    System.out.println(option);
                    }catch(Exception e){
                            foutput.println(inputLine+" Invalid input data form " +option);
                            break;
                    }
                    break;
            }
             
            
             
          }	      
        }      
		} catch (NumberFormatException NFE) {
			System.out.println("I/O Error in File: " + ifName + "\ncheck for: "
					+ NFE.getMessage() + " and correct it in: " + inputLine);
		} catch (RuntimeException RE) {
			System.out.println("Invalid Data error in File: " + ifName
					+ "\nPlease correct " + RE.getMessage() + " in the file!" + inputLine);
		}
        catch(IOException IOE){
        System.out.println("input/output Data error in File: " + ifName + "\nPlease correct " + IOE.getMessage() + " in the file!" + inputLine);
        } 
        finally {
                   System.out.println(company.longestEmployee());
                  MavJFrame frame= new MavJFrame(company);
                frame.setVisible(true);
		  foutput.close();
                  System.out.println("done");
		}
	}
        
        
        public String getClientText(int clientId){
        int index= this.getClientIndex(clientId);
        String text = "\n";
        if (index==-1)
            return " Invalid Client ID";
        text+= " Client ID:    "+clientId+"\n";
        text+= " Name          "+this.getClient().get(index).getLastName()+", "+this.getClient().get(index).getFirstName()+"\n";
        text+= " DOB:          "+ this.getClient().get(index).getDob().toString()+"\n";
        text+= " Gender:       "+ this.getClient().get(index).getGender()+"\n";
        text+= " Type          "+ this.getClient().get(index).getType()+"\n";
        text+= " Address:      "+ this.getClient().get(index).getAddress().toString()+"\n\n";
        return text;
    }
 public String getEmployeeText(int empId){
        int index= this.getEmployeeIndex(empId);
        String text = "\n";
        if (index==-1)
            return " Invalid Employee ID";
        text+= " Employee ID:     "+empId+"\n";
        text+= " Name             "+this.getEmployee().get(index).getLastName()+", "+this.getEmployee().get(index).getFirstName()+"\n";
        text+= " DOB:             "+ this.getEmployee().get(index).getDob().toString()+"\n";
        text+= " Gender:          "+ this.getEmployee().get(index).getGender()+"\n";
        text+= " Type:            ";
        if (this.getEmployee().get(index) instanceof Accountant){
            text+="Accountant"+"\n";
         Accountant temp = (Accountant)this.getEmployee().get(index);
        text+= " On Call:         "+ temp.isOnCall()+"\n";
        text+= " Hire Date:       "+ temp.getHireDate()+"\n";
        text+= " Hourly Rate:     "+ temp.getRate()+"\n";
        }
        if (this.getEmployee().get(index) instanceof Agent){
            text+="Agent"+"\n";
            Agent temp = (Agent)this.getEmployee().get(index);
        text+= " On Call:         "+ temp.isOnCall()+"\n";
        text+= " Hire Date:       "+ temp.getHireDate()+"\n";
        text+= " Monthly Base:    "+ temp.getBaseSalary()+"\n";
        text+= " Overtime Rate:   "+ temp.getRate()+"\n";
        }
        if (this.getEmployee().get(index) instanceof WebDesigner){
            text+="WebDesigner";
            text+="\n";
            WebDesigner temp = (WebDesigner)this.getEmployee().get(index);
        text+= " On Call:         "+ temp.isOnCall()+"\n";
        text+= " Hire Date:       "+ temp.getHireDate()+"\n";
        text+= " Monthly Base:    "+ temp.getBaseSalary()+"\n";
        text+= " Click Rate:      "+ temp.getRate()+"\n\n";
        }   
           return text;
    }
 public String getItemText(String itemId){
        int index= this.getItemIndex(itemId);
        String text = "\n";
        if (index==-1)
            return "Invalid Item ID";
        text+= " Item ID:             "+itemId+"\n";
        text+= " Company:             "+this.getItems().get(index).getCompanyName()+"\n";
        text+= " Condition:           "+ this.getItems().get(index).getCondition()+"\n";
        text+= " Type:                "+ this.getItems().get(index).getType()+"\n";
        text+= " Price:               "+this.getItems().get(index).getPrice()+"\n";
        text+= " Shipping cost:       "+ this.getItems().get(index).getShippingCost()+"\n";
        text+= " Shipping days:       "+this.getItems().get(index).getShippingDays()+"\n";
        text+= " Store Availability:  "+ "["+ this.getItems().get(index).getStoreAvailableString()+"]"+"\n";
        text+= " Available Date:      "+ this.getItems().get(index).getAvailabilityDate().toString()+"\n\n";
        return text;
    }

   public String getALLItemText(){
       String text="";
       for (int i=0;i<items.size();i++){
           text+= getItemText(items.get(i).getModelID());
       }
       return text;
   }
          
    public String getALLEmployeeText(){
       String text="";
       for (int i=0;i<employee.size();i++){
           text+= getEmployeeText(employee.get(i).getID());
       }
       return text;
   }
                     
    public String getALLClientText(){
       String text="";
       for (int i=0;i<client.size();i++){
           text+= getClientText(client.get(i).getID());
       }
       return text;
   }
    public String longestEmployee(){
        String text = "";
        Date today= new Date(8,4,2016);
        int longestEmpID=-1;
        int longest =0;
        for (int i=0;i<employee.size();i++){
         if (this.getEmployee().get(i) instanceof Accountant){
            
         Accountant temp = (Accountant)this.getEmployee().get(i);
        if(longest < temp.getHireDate().daysBetween(today)){
            //longestEmpID= employee.get(i).getID();
            longest= temp.getHireDate().daysBetween(today);
        }
        }
        if (this.getEmployee().get(i) instanceof Agent){
            
            Agent temp = (Agent)this.getEmployee().get(i);
       if(longest < temp.getHireDate().daysBetween(today)){
            //longestEmpID= employee.get(i).getID();
            longest= temp.getHireDate().daysBetween(today);
        }
        }
        if (this.getEmployee().get(i) instanceof WebDesigner){
            
            WebDesigner temp = (WebDesigner)this.getEmployee().get(i);
        if(longest < temp.getHireDate().daysBetween(today)){
            //longestEmpID= employee.get(i).getID();
            longest= temp.getHireDate().daysBetween(today);
        } 
        }
        }

        
        for (int i=0;i<employee.size();i++){
         if (this.getEmployee().get(i) instanceof Accountant){
            
         Accountant temp = (Accountant)this.getEmployee().get(i);
        if(longest == temp.getHireDate().daysBetween(today)){
            longestEmpID= employee.get(i).getID();
            text= getEmployeeText(longestEmpID);
            text+= "Total year:      "+ longest/365+"\n\n";
            longest= temp.getHireDate().daysBetween(today);
        }
        }
        if (this.getEmployee().get(i) instanceof Agent){
            
            Agent temp = (Agent)this.getEmployee().get(i);
       if(longest == temp.getHireDate().daysBetween(today)){
            longestEmpID= employee.get(i).getID();
            text= getEmployeeText(longestEmpID);
            text+= "Total year:      "+ longest/365+"\n\n";
            longest= temp.getHireDate().daysBetween(today);
        }
        }
        if (this.getEmployee().get(i) instanceof WebDesigner){
            
            WebDesigner temp = (WebDesigner)this.getEmployee().get(i);
        if(longest == temp.getHireDate().daysBetween(today)){
            longestEmpID= employee.get(i).getID();
            text= getEmployeeText(longestEmpID);
            text+= "Total year:      "+ longest/365+"\n\n";
            longest= temp.getHireDate().daysBetween(today);
        } 
        }
        }
        if (longestEmpID ==-1)
            return "There is no longest Employee.";
        
        
        
        return text;
    }
     public String longestEmployeeByDepartment(String depart){
        String text = "";
        Date today= new Date(8,4,2016);
        int longestEmpID=-1;
        int longest =0;
        for (int i=0;i<employee.size();i++){
         if (this.getEmployee().get(i) instanceof Accountant){
         Accountant temp = (Accountant)this.getEmployee().get(i);
        if(longest < temp.getHireDate().daysBetween(today)&& temp.getType().equals(depart.toUpperCase())){
            //longestEmpID= employee.get(i).getID();
            longest= temp.getHireDate().daysBetween(today);
        }
        }
        if (this.getEmployee().get(i) instanceof Agent){
            
            Agent temp = (Agent)this.getEmployee().get(i);
       if(longest < temp.getHireDate().daysBetween(today)&& temp.getType().equals(depart.toUpperCase())){
            //longestEmpID= employee.get(i).getID();
            longest= temp.getHireDate().daysBetween(today);
        }
        }
        if (this.getEmployee().get(i) instanceof WebDesigner){
            
            WebDesigner temp = (WebDesigner)this.getEmployee().get(i);
        if(longest < temp.getHireDate().daysBetween(today)&& temp.getType().equals(depart.toUpperCase())){
            //longestEmpID= employee.get(i).getID();
            longest= temp.getHireDate().daysBetween(today);
        } 
        }
        }

        
        for (int i=0;i<employee.size();i++){
         if (this.getEmployee().get(i) instanceof Accountant){
            
         Accountant temp = (Accountant)this.getEmployee().get(i);
        if(longest == temp.getHireDate().daysBetween(today)&& temp.getType().equals(depart.toUpperCase())){
            longestEmpID= employee.get(i).getID();
            text= getEmployeeText(longestEmpID);
            text+= "Total year:      "+ longest/365+"\n\n";
            longest= temp.getHireDate().daysBetween(today);
        }
        }
        if (this.getEmployee().get(i) instanceof Agent){
            
            Agent temp = (Agent)this.getEmployee().get(i);
       if(longest == temp.getHireDate().daysBetween(today)&& temp.getType().equals(depart.toUpperCase())){
            longestEmpID= employee.get(i).getID();
            text= getEmployeeText(longestEmpID);
            text+= "Total year:      "+ longest/365+"\n\n";
            longest= temp.getHireDate().daysBetween(today);
        }
        }
        if (this.getEmployee().get(i) instanceof WebDesigner){
            
            WebDesigner temp = (WebDesigner)this.getEmployee().get(i);
        if(longest ==temp.getHireDate().daysBetween(today)&& temp.getType().equals(depart.toUpperCase())){
            longestEmpID= employee.get(i).getID();
            text= getEmployeeText(longestEmpID);
            text+= "Total year:      "+ longest/365+"\n\n";
            longest= temp.getHireDate().daysBetween(today);
        } 
        }
        }
        if (longestEmpID ==-1)
            return "There is no Employee in this department.";
        
        
        
        return text;
    }
}
