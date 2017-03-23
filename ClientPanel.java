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
public class ClientPanel extends JPanel{
     MavBuyTest com;
//   details
    JLabel message ;
    JPanel top;
   JComboBox mainList ;
//   
   HighLowClientPanel highlow;
   ClientDetailsPanel clientDetails;
   ListPurchasePanel listPurchase;
   //salary
   
  // mainList.addActionListener();

    public ClientPanel(MavBuyTest com ) {
       this.com = com;
       
      setLayout(new BorderLayout());
        message = new JLabel("Options");
        top= new JPanel();
        top.add(message);
         String list[]= {"Client Details", "Purchase by year","Client Spent Highest and Lowest Amount",};
         mainList = new JComboBox(list);
            top.add(mainList);
            this.add(top, BorderLayout.NORTH);
           // mainList.setSize(15, 50);
            //MainListEvent e = new MainListEvent();
            mainList.setEditable(false);
            mainList.addActionListener(new MainListEventClient());
            highlow= new HighLowClientPanel(com);
            clientDetails = new ClientDetailsPanel(com);
           listPurchase = new ListPurchasePanel(com);
            this.setVisible(true);
    }
   
    private class MainListEventClient implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getSource()== mainList){
        JComboBox cb = (JComboBox)e.getSource();
        //String option = (String)cb.getSelectedItem();
           int op = cb.getSelectedIndex();
        if (op==0){
            
           clientDetails.setVisible(true);
            highlow.setVisible(false);
            listPurchase.setVisible(false);
             add(clientDetails, BorderLayout.CENTER);
             
        }
            if (op==1){
        highlow.setVisible(false);
        clientDetails.setVisible(false);
        listPurchase.setVisible(true);
           add(listPurchase);  
        }
             
        if (op==2){
             clientDetails.setVisible(false);
            highlow.setVisible(true);
            listPurchase.setVisible(false);
             add(highlow, BorderLayout.CENTER);
        }
            }
    }
          
    }
    
}
