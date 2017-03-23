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
public class SalaryPanel extends JPanel{
    MavBuyTest com;
    JTextField ID;
   JLabel IDLabel;
   JTextField count;
   JLabel countLabel;
   JTextField month;
   JLabel monthLabel;
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
   public SalaryPanel(MavBuyTest com){
       this.com= com;
       setLayout(new BorderLayout());
     
       
        left = new JPanel();
        left.setLayout(new BorderLayout(500,200));
        infoBox=new JPanel();
        left.add(infoBox, BorderLayout.NORTH);
        infoBox.setLayout(new GridLayout(4,2));
        ID= new JTextField(10);
         IDLabel = new JLabel("Enter Employee ID:");
         go = new JButton("GO");
         count= new JTextField(10);;
          countLabel= new JLabel("Count unit:");
            month= new JTextField(10);;
         monthLabel= new JLabel("Month");
         
         infoBox.add(IDLabel);
         infoBox.add(ID);
         infoBox.add(countLabel);
         infoBox.add(count);
         infoBox.add(monthLabel);
         infoBox.add(month);
         infoBox.add(go);
                 
          
        add(left,BorderLayout.WEST);
        SalaryEvent ev = new SalaryEvent();
       ID.addActionListener(ev);
      count.addActionListener(ev);
       month.addActionListener(ev);
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
    private class SalaryEvent implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int id,cnt, mth;
            try{
                
            //if (e.getSource()== ID){
                id = Integer.parseInt(ID.getText());
                //if (e.getSource()== count){
                 cnt = Integer.parseInt(count.getText());
                    //if (e.getSource()== month){
                  mth = Integer.parseInt(month.getText());
                        if(e.getSource()==go){
                             
                             
                        text.setText(com.employeeSalary(id,cnt,mth));
                      
                       // }
                   // }
               // }
            }}catch (Exception a){
                         
                        text.setText("Invalid Input");
                      
      }
    }
    }
}
