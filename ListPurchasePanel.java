/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.ActionListener;
/**
 *
 * @author Yenpham
 */
public class ListPurchasePanel extends JPanel{
    MavBuyTest com;
    JTextField ID;
   JLabel IDLabel;
   JTextField year;
   JLabel yearLabel;
   JPanel infoBox;
   JPanel left;
   JButton go;
   JPanel display;
   JScrollPane textScrollPane;
   JLabel allLabel;
   JPanel topdetails;
   JPanel topdetailsFrame;
   JTextArea text;
   JLabel message ;
   JPanel detail;
    
    public ListPurchasePanel(MavBuyTest com){
        this.com= com;
       setLayout(new BorderLayout());
     
       
        left = new JPanel();
        left.setLayout(new BorderLayout(500,200));
        infoBox=new JPanel();
        left.add(infoBox, BorderLayout.NORTH);
        infoBox.setLayout(new GridLayout(4,2));
        ID= new JTextField(10);
         IDLabel = new JLabel("Enter Customer ID:");
         go = new JButton("GO");
         
            year= new JTextField(10);;
         yearLabel= new JLabel("Year");
         
         infoBox.add(IDLabel);
         infoBox.add(ID);
         
         infoBox.add(yearLabel);
         infoBox.add(year);
         infoBox.add(go);
                 
          
        add(left,BorderLayout.WEST);
        PurchaseEvent ev = new PurchaseEvent();
       ID.addActionListener(ev);
      year.addActionListener(ev);
      
       go.addActionListener(ev);

      
        detail= new JPanel();
        add(detail, BorderLayout.CENTER);
         display = new JPanel();
         display.setLayout(new BorderLayout());
         topdetails= new JPanel();
         allLabel= new JLabel("EMPOYEES SALARY");
         detail.setLayout(new BorderLayout(500,25));
         detail.add(topdetails, BorderLayout.NORTH);
         detail.add(display,BorderLayout.CENTER);
         textScrollPane = new JScrollPane(display);
         textScrollPane.setPreferredSize(new Dimension(500,475));
         detail.add(textScrollPane);
         text= new JTextArea();
         text.setEditable(false);
            text.setWrapStyleWord(true);
            display.add(text,BorderLayout.CENTER);
          setVisible(true);
        
    }
    private class PurchaseEvent implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int id,yr;
            String y;
            try{
                
            //if (e.getSource()== ID){
                id = Integer.parseInt(ID.getText());
                //if (e.getSource()== count){
                y = year.getText();
                if (y.equals("*"))
                    text.setText(com.ListPurchaseAll(id));
                else{
                 yr = Integer.parseInt(year.getText());
                    //if (e.getSource()== month){
                
                             
                             
                        text.setText(com.list_purchase_year(id, yr));
                      
                       // }
                   // }
               // }
            }}catch (Exception a){
                         
                         JOptionPane.showMessageDialog(null, "Invalid Input. Try again.");
                      
      }
    }
    
    }
}
