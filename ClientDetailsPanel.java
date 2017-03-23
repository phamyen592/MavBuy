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
public class ClientDetailsPanel extends JPanel{
     MavBuyTest com;
//   details
    JLabel message ;
    JPanel top;
   JComboBox mainList ;
   JPanel detail;//
   JPanel left;//
   JTextArea text;
   JTextArea text1;
   JComboBox<String> sublist ;
   JPanel display;
   JPanel displayFrame;
   JTextField ID;
   JLabel IDLabel;
   JScrollPane textScrollPane;
   JLabel allLabel;
   JPanel topdetails;
   JPanel topdetailsFrame;
   JButton go;
     public ClientDetailsPanel( MavBuyTest com){
       this.com= com;
       setLayout(new BorderLayout());
        left = new JPanel();
        left.setLayout(new BorderLayout(500,200));   
        String listStr[]= {"Enter Client ID","All Client"};
       sublist = new JComboBox<String>(listStr);
      
        this.add(left, BorderLayout.WEST);
        left.add(sublist,BorderLayout.NORTH);
        detail= new JPanel();
       detail.setLayout(new BorderLayout(500,25));  
   //
       sublist.setEditable(false);
        sublist.addActionListener(new DetailEventClient());
        //
        this.add(detail,BorderLayout.CENTER);
         display = new JPanel();
         display.setLayout(new BorderLayout());
         topdetailsFrame= new JPanel();
         topdetails = new JPanel();
         topdetailsFrame.setLayout(new BorderLayout());
         topdetailsFrame.add(topdetails, BorderLayout.NORTH);
         detail.add(topdetailsFrame, BorderLayout.NORTH);
         detail.add(display,BorderLayout.CENTER);
         textScrollPane = new JScrollPane(display);
         textScrollPane.setPreferredSize(new Dimension(500,475));
         detail.add(textScrollPane);
          text= new JTextArea();
             text.setEditable(false);
         text1= new JTextArea();
            text1.setEditable(false);
         
    }
     private class DetailEventClient implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (e.getSource()== sublist){
        JComboBox cb = (JComboBox)e.getSource();
        //String option = (String)cb.getSelectedItem();
        int op = cb.getSelectedIndex();
        if (op==1){
             topdetails.removeAll();
             //text.removeAll();
            text.setVisible(true);
            text1.setVisible(false);
            text.setWrapStyleWord(true);
            text.setLineWrap(true);
            allLabel= new JLabel("ALL CLIENTS DETAILS");
             topdetails.add(allLabel);
           
            text.setText(com.getALLClientText());
           display.add(text, BorderLayout.CENTER);
           
        }
            
        if (op==0){
            topdetails.removeAll();
            text.setVisible(false);
            text1.setVisible(true);
            ID= new JTextField(10);
            IDLabel = new JLabel("Enter Client ID");
            go = new JButton("GO");
            
            
            topdetails.add(IDLabel);
            topdetails.add(ID);
            topdetails.add(go);
            getID ev = new getID();
           ID.addActionListener(ev);
           go.addActionListener(ev);
           
        }
      
    }}
          
    }
    private class getID implements ActionListener{
        public void actionPerformed(ActionEvent e){
         
            if (e.getSource()==ID||e.getSource()== go){
                int Id;
                try{
                    Id = Integer.parseInt(ID.getText());
                    text1.setText(com.getClientText(Id));
                    display.add(text1);
                }catch(Exception a){
                  JOptionPane.showMessageDialog(null, "Invalid Input. Try again.");
                }
                
            }
        }
    }
}
