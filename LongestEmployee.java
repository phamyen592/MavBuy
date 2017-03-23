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
public class LongestEmployee extends JPanel{
    MavBuyTest com;
//   details
    JLabel message ;
    JPanel top;
   JComboBox mainList ;
   JPanel detail= new JPanel();//
   JPanel left= new JPanel();//
   JTextArea text1;
   JTextArea text2;
   JTextArea text3;
   JTextArea text4;
   JComboBox<String> sublist ;
   JPanel display= new JPanel();
   JPanel displayFrame;
  
   JScrollPane textScrollPane= new JScrollPane();
   JLabel allLabel;
   JPanel topdetails;
   JPanel topdetailsFrame= new JPanel();
   JButton go;
  
    
   
  
     public LongestEmployee(MavBuyTest com){
         this.com= com;
       setLayout(new BorderLayout());
        left = new JPanel();
        left.setLayout(new BorderLayout(500,200));   
        add(left,BorderLayout.WEST);
        detail = new JPanel();
        
        
        display = new JPanel();
        add(detail, BorderLayout.CENTER);
         display.setLayout(new BorderLayout());
         topdetailsFrame= new JPanel();
         
        
         detail.add(topdetailsFrame, BorderLayout.NORTH);
         detail.add(display,BorderLayout.CENTER);
         textScrollPane = new JScrollPane(display);
         textScrollPane.setPreferredSize(new Dimension(500,475));
         detail.add(textScrollPane);
         
         String list[]= {"Longest Employee.", "Longest Accountant", "Longest Agent","Longest WebDesigner"};
          sublist = new JComboBox(list);
            sublist.addActionListener(new DetailEvent());
            
            text1= new JTextArea(); 
            text1.setEditable(false);
            text2= new JTextArea();
            text2.setEditable(false);
            text3= new JTextArea();
            text3.setEditable(false);
            text4= new JTextArea();
            text4.setEditable(false);
             left.add(sublist,BorderLayout.NORTH );
          setVisible(true);
    }
      private class DetailEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getSource()== sublist){
        JComboBox cb = (JComboBox)e.getSource();
        //String option = (String)cb.getSelectedItem();
           int op = cb.getSelectedIndex();
           
        if (op==0){
            text1.setVisible(true);
            text2.setVisible(false);
            text3.setVisible(false);
            text4.setVisible(false);
            
            text1.setText(com.longestEmployee());
             display.add(text1);
        }if(op==1){
            text1.setVisible(false);
            text2.setVisible(true);
            text3.setVisible(false);
            text4.setVisible(false);
            //display.remove(text);
            
            text2.setText(com.longestEmployeeByDepartment("ACCT"));
             display.add(text2);
        }if(op==2){
            text1.setVisible(false);
            text2.setVisible(false);
            text3.setVisible(true);
            text4.setVisible(false);
            //display.remove(text);
           
             text3.setText(com.longestEmployeeByDepartment("AGT"));
            
             display.add(text3);
        }if(op==3){
            text1.setVisible(false);
            text2.setVisible(false);
            text3.setVisible(false);
            text4.setVisible(true);
           // display.remove(text);
           
             text4.setText(com.longestEmployeeByDepartment("WD"));
            
             display.add(text4);
        }
            }
        }
      }
}
