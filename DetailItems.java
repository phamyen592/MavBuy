
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.ActionListener;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yenpham
 */
 public class DetailItems extends JPanel{
         MavBuyTest com;
        JPanel detail;
   JPanel left;
   JTextArea text;
   JTextArea text2;
   JComboBox<String> sublist;
   JPanel display;
   JTextField ID;
   JLabel IDLabel;
   JScrollPane textScrollPane;
   JLabel allLabel;
   JPanel topdetails;
   JPanel topdetailsFrame ;
   JButton go;
   public DetailItems(MavBuyTest com){
       this.com= com;
       this.setLayout(new BorderLayout());
        left = new JPanel();
        left.setLayout(new BorderLayout(500,200));   
        String listStr[]= {"Enter Item ID","All Items"};
       sublist = new JComboBox<String>(listStr);
      
        this.add(left, BorderLayout.WEST);
        left.add(sublist,BorderLayout.NORTH);
        detail= new JPanel();
       detail.setLayout(new BorderLayout(500,25));   
        this.add(detail,BorderLayout.CENTER);
       sublist.setEditable(false);
        sublist.addActionListener(new DetailEvent());
        
         
         display = new JPanel();
         display.setLayout(new BorderLayout());
         topdetails = new JPanel();
         topdetailsFrame = new JPanel();
         topdetailsFrame.setLayout(new BorderLayout());
         topdetailsFrame.add(topdetails, BorderLayout.NORTH);
         detail.add(topdetailsFrame, BorderLayout.NORTH);
         detail.add(display,BorderLayout.CENTER);
         textScrollPane = new JScrollPane(display);
         textScrollPane.setPreferredSize(new Dimension(500,475));
         detail.add(textScrollPane);
         
         ID= new JTextField(10);
         text= new JTextArea();
         text.setEditable(false);
         text2= new JTextArea();
         text2.setEditable(false);
         allLabel= new JLabel("ALL ITEMS DETAILS");
         IDLabel = new JLabel("Enter Item ID");
            go = new JButton("GO");
         this.setVisible(true);
   } 
         
         
    

    private class DetailEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
           
        JComboBox cb = (JComboBox)e.getSource();
        //String option = (String)cb.getSelectedItem();
        int op = cb.getSelectedIndex();
         if (e.getSource()== sublist){
        if (op==1){
             topdetails.removeAll();
             
            text.setVisible(true);
            text2.setVisible(false);
            IDLabel.setVisible(false);
            ID.setVisible(false);
            go.setVisible(false);
             topdetails.add(allLabel);
           
            text.setText(com.getALLItemText());
           display.add(text);
           
        }
        if (op==0){
            
           
           topdetails.removeAll();
            IDLabel.setVisible(true);
            ID.setVisible(true);
            go.setVisible(true);
            allLabel.setVisible(false);
            text2.setVisible(true);
            text.setVisible(false);
            topdetails.add(IDLabel);
            topdetails.add(ID);
            topdetails.add(go);
            getID ev = new getID();
           ID.addActionListener(ev);
           go.addActionListener(ev);
        }
      
    }
          
    }}
    private class getID implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
          String Id;
            if (e.getSource()==ID||e.getSource()== go){
                
                    Id = (String)ID.getText();

                  display.add(text2);
                 text2.setText(com.getItemText(Id));
            }
        }
    }
    }