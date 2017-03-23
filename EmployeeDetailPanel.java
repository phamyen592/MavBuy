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
public class EmployeeDetailPanel extends JPanel {
    MavBuyTest com;
     JPanel detail;//
   JPanel left;//
   JTextArea text;
   JTextArea text1;
   JComboBox<String> sublist ;
   JPanel display;
   JPanel displayFrame;
   JTextField ID;
   JLabel IDLabel;
   JScrollPane textScrollPane= new JScrollPane();
   JLabel allLabel;
   JPanel topdetails;
   JPanel topdetailsFrame= new JPanel();
   JButton go;
   JPanel infoBox= new JPanel();
    JTextField count;
   JLabel countLabel;
   JTextField month;
   JLabel monthLabel;
    
    public EmployeeDetailPanel(MavBuyTest com){
        this.com= com;
       setLayout(new BorderLayout());
        left = new JPanel();
        left.setLayout(new BorderLayout(500,200));   
        String listStr[]= {"Enter Employee ID","All Employee"};
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
         topdetailsFrame= new JPanel();
         topdetails = new JPanel();
         topdetailsFrame.setLayout(new BorderLayout(500,25));
         topdetailsFrame.add(topdetails, BorderLayout.NORTH);
         detail.add(topdetailsFrame, BorderLayout.NORTH);
         detail.add(display,BorderLayout.CENTER);
         textScrollPane = new JScrollPane(display);
         textScrollPane.setPreferredSize(new Dimension(500,475));
         detail.add(textScrollPane);
         text1= new JTextArea();
            text1.setEditable(false);
        text= new JTextArea();
             text.setEditable(false);
    }
     private class DetailEvent implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (e.getSource()== sublist){
        JComboBox cb = (JComboBox)e.getSource();
        //String option = (String)cb.getSelectedItem();
        int op = cb.getSelectedIndex();
        if (e.getSource()==sublist)
        if (op==1){
             topdetails.removeAll();
             //text.removeAll();
             text.setVisible(true);
            text1.setVisible(false);
            
            allLabel= new JLabel("ALL EMPOYEES DETAILS");
             topdetails.add(allLabel);
           
            text.setText(com.getALLEmployeeText());
           display.add(text);
           
        }
            
        if (op==0){
            text.setVisible(false);
            text1.setVisible(true);
            topdetails.removeAll();
            ID= new JTextField(10);
            IDLabel = new JLabel("Enter Employee ID");
            go = new JButton("GO");
            
            
            topdetails.add(IDLabel);
            topdetails.add(ID);
            topdetails.add(go);
            getID ev = new getID();
           ID.addActionListener(ev);
           go.addActionListener(ev);
           display.add(text1);
           
            
            
        }
      
    }}
          
    }
    private class getID implements ActionListener{
        public void actionPerformed(ActionEvent e){
         
            if (e.getSource()==ID||e.getSource()== go){
                int Id;
                try{
                    Id = Integer.parseInt(ID.getText());
                     text1.setText(com.getEmployeeText(Id));
                }catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Invalid Input. Try again.");
                    
                }
                
            }
        }
    
    
}
}
