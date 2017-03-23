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
public class RevenuePanel extends JPanel {
    MavBuyTest com ;
      
        JPanel detail;
   JPanel left;
   JTextArea text;
   JTextArea text2;
   JComboBox<String> sublist;
   JPanel display;
   JTextField year;
   JLabel yearLabel;
   JScrollPane textScrollPane;
   JLabel allLabel;
   JPanel topdetails;
   JPanel topdetailsFrame ;
   JButton go;
   JLabel category;
   JPanel catagoryBox;
//     JTextField year1;
//   JLabel yearLabel1;
//     JButton go1;
    public RevenuePanel(MavBuyTest com){
        this.setLayout(new BorderLayout());
           this.com= com;
        left = new JPanel();
        left.setLayout(new BorderLayout(500,200));   
       
        ArrayList<String>listType = new ArrayList<String>();
        for(int i = 0; i<com.getItems().size();i++){
           int  pos =-1;
            for(int j =0 ;j<listType.size();j++){
                if (com.getItems().get(i).getType().equals(listType.get(j))){
                    pos = j;
                    break;
                }
            }
            if (pos==-1){
                listType.add(com.getItems().get(i).getType());
            }
            
        }
         String list[];
            list = new String[listType.size()+1];
        list[0]=("All Type.");
        for(int j =0 ;j<listType.size();j++){
            list[j+1]= listType.get(j);
        }
        
        
        sublist = new JComboBox<String>(list);
         category =new JLabel(" + Category: ");
         catagoryBox = new JPanel();
         catagoryBox.setLayout(new GridLayout(2,1));
         catagoryBox.add(category);
        this.add(left, BorderLayout.WEST);
        
        left.add(catagoryBox,BorderLayout.NORTH);
        catagoryBox.add(sublist);
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
         
          text= new JTextArea();
             text.setEditable(false);
             text2= new JTextArea();
             text2.setEditable(false);
             allLabel= new JLabel();
             

          
    }
     private class DetailEvent2 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int op=-1;
            if (e.getSource()== sublist){
        JComboBox cb = (JComboBox)e.getSource();
        //String option = (String)cb.getSelectedItem();
        op = cb.getSelectedIndex();
            }
        if (op==0){
           topdetails.removeAll();

            text2.setVisible(false);
            text.setVisible(true);
           year= new JTextField(10);
         yearLabel = new JLabel("Enter year[or * for all]: ");
          go = new JButton("GO");
            topdetails.add(yearLabel);
             topdetails.add(year);
            topdetails.add(go);
            
            GetYear2 ev = new GetYear2();
           year.addActionListener(ev);
           go.addActionListener(ev);
         
             
        }
         else {int index = op-1;
         topdetails.removeAll();

            text2.setVisible(true);
            text.setVisible(false);
            
            yearLabel = new JLabel("Enter year[or * for all]: ");
            year= new JTextField(10);
          go = new JButton("GO");
            
           topdetails.add(yearLabel);
           topdetails.add(year);
            topdetails.add(go);
             
            GetYear ev = new GetYear(index);
           year.addActionListener(ev);
           go.addActionListener(ev);
           
        
      
    }
    
 }
        
         }
    private class GetYear2 implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
         String yr;
         int y;
            if (e.getSource()==year||e.getSource()== go){
               try{
                    yr = (String)year.getText();
                   if (yr.equals("*"))
                       text.setText(com.revenueAllYear());
                   else{
                      
                           y= Integer.parseInt(yr);
                           text.setText(com.revenuePerYear(y));
                       }}catch (Exception a){
                           JOptionPane.showMessageDialog(null, "Invalid Input. Try again.");
                       }
                   
                 
                  display.add(text);
            }
        }
    }
    private class GetYear implements ActionListener{
        int index;
        public GetYear(int index){
            this.index = index;
        }
        @Override
        public void actionPerformed(ActionEvent e){
         String yr;
         int y;
            if (e.getSource()==year||e.getSource()== go){
              try{
                    yr = (String)year.getText();
                   if (yr.equals("*"))
                       text2.setText(com.revenuePerType(com.itemTypeList().get(index)));
                   else{
                      
                           y= Integer.parseInt(yr);
                           text2.setText(com.revenueByCatePerYear(com.itemTypeList().get(index),y));
                   }}catch (Exception a){
                           JOptionPane.showMessageDialog(null, "Invalid Input. Try again.");
                       }
                   
                 
                  display.add(text2);
            }
        }
    }
}
