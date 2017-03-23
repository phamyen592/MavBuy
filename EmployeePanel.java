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
public class EmployeePanel extends JPanel {
   MavBuyTest com;
//   details
    JLabel message ;
    JPanel top;
   JComboBox mainList ;
  
  LongestEmployee longest;
  SalaryPanel salary;
  EmployeeDetailPanel empdetail;
  
  // mainList.addActionListener();

    public EmployeePanel(MavBuyTest com ) {
       this.com = com;
       
      setLayout(new BorderLayout());
        message = new JLabel("Options");
        top= new JPanel();
        top.add(message);
         String list[]= {"Compute Salary","Longest Employee","Employee Details"};
         mainList = new JComboBox(list);
            top.add(mainList);
            this.add(top, BorderLayout.NORTH);
           // mainList.setSize(15, 50);
            //MainListEvent e = new MainListEvent();
            mainList.setEditable(false);
            mainList.addActionListener(new MainListEvent());
            longest = new LongestEmployee(com);
            salary = new SalaryPanel(com);
            empdetail = new EmployeeDetailPanel(com);
            this.setVisible(true);
    }
    
    private class MainListEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getSource()== mainList){
        JComboBox cb = (JComboBox)e.getSource();
        //String option = (String)cb.getSelectedItem();
           int op = cb.getSelectedIndex();
         if (e.getSource()==mainList)
        if (op==0){
            //SalaryPanel();
            empdetail.setVisible(false);
            longest.setVisible(false);
            salary.setVisible(true);
            add(salary);
        }
            
        if (op==1){
           empdetail.setVisible(false);
            longest.setVisible(true);
            salary.setVisible(false);
            add(longest);
        }
             
        if (op==2){
            empdetail.setVisible(true);
            longest.setVisible(false);
            salary.setVisible(false);
            add(empdetail);
        }
            }
    }
          
    }
   
    
   
}