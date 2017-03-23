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
 public class Expendixture extends JPanel{
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
        public Expendixture (MavBuyTest com){
           this.setLayout(new BorderLayout());
           this.com= com;
        left = new JPanel();
        left.setLayout(new BorderLayout(500,200));   
        String list[];
            list = new String[com.getItems().size()+1];
        list[0]=("Enter Item ID");
        for(int i = 0; i<com.getItems().size();i++){
            list[i+1]=(com.getItems().get(i).getModelID());
        }
                
       sublist = new JComboBox<String>(list);
         
        this.add(left, BorderLayout.WEST);
        left.add(sublist,BorderLayout.NORTH);
        detail= new JPanel();
       detail.setLayout(new BorderLayout(500,25));   
        this.add(detail,BorderLayout.CENTER);
       sublist.setEditable(false);
        sublist.addActionListener(new DetailEvent2());
        
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
         this.setVisible(true);
         ID= new JTextField(10);
         IDLabel = new JLabel("Enter Item ID");
          go = new JButton("GO");
          text= new JTextArea();
             text.setEditable(false);
             text2= new JTextArea();
             text2.setEditable(false);
             allLabel= new JLabel();
        }
         private class DetailEvent2 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (e.getSource()== sublist){
        JComboBox cb = (JComboBox)e.getSource();
        //String option = (String)cb.getSelectedItem();
        int op = cb.getSelectedIndex();
        
        if (op==0){
            topdetails.removeAll();
            IDLabel.setVisible(true);
            ID.setVisible(true);
            go.setVisible(true);
            allLabel.setVisible(false);
            text2.setVisible(false);
            text.setVisible(true);
            topdetails.add(IDLabel);
            topdetails.add(ID);
            topdetails.add(go);
            getID2 ev = new getID2();
           ID.addActionListener(ev);
           go.addActionListener(ev);
          
             
        }
         else {int index = op-1;
         topdetails.removeAll();
            IDLabel.setVisible(false);
            ID.setVisible(false);
            go.setVisible(false);
            allLabel.setVisible(true);
            text2.setVisible(true);
            text.setVisible(false);
            allLabel= new JLabel("ITEM " + com.getItems().get(index).getModelID());
             topdetails.add(allLabel);
           
            text2.setText(com.expenditure(com.getItems().get(index).getModelID()));
           display.add(text2);
           
        }
      
    }
    
 }
        
         }
         private class getID2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
         String Id;
            if (e.getSource()==ID||e.getSource()== go){
             
                    Id = (String)ID.getText();
                   
                 text.setText(com.expenditure(Id));
                  display.add(text);
            }
        }
    }
    } 
