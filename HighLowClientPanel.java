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
public class HighLowClientPanel extends JPanel {
    
    
     MavBuyTest com;
        JPanel detail;
   JPanel left;
  //
   JTextArea text2;
   JComboBox<String> sublist;
   JPanel display;
   
   JScrollPane textScrollPane;
   JLabel allLabel;
   JPanel topdetails;
   JPanel topdetailsFrame ;
   JButton go;
   JTextField year;
   JLabel yearLabel;
    JPanel infoBox;
     public HighLowClientPanel(MavBuyTest com){
         this.com= com;
       setLayout(new BorderLayout());
        left = new JPanel();
        left.setLayout(new BorderLayout(500,200));
        infoBox=new JPanel();
        left.add(infoBox, BorderLayout.NORTH);
        infoBox.setLayout(new GridLayout(4,2));
        
         go = new JButton("GO");
         year= new JTextField(10);;
          yearLabel= new JLabel("Enter a Year: ");
           
         
        
         infoBox.add(yearLabel);
         infoBox.add(year);
         
         infoBox.add(go);
                 
          
        this.add(left,BorderLayout.WEST);
        getID ev = new getID();
       
      year.addActionListener(ev);
      
       go.addActionListener(ev);

      
        detail= new JPanel();
        this.add(detail);
         display = new JPanel();
         display.setLayout(new BorderLayout());
         topdetails= new JPanel();
       allLabel= new JLabel("CLIENTS WITH HIGHEST & LOWEST AMOUNT BY YEAR");
         detail.setLayout(new BorderLayout(500,25));
         detail.add(topdetails, BorderLayout.NORTH);
         detail.add(display,BorderLayout.CENTER);
         textScrollPane = new JScrollPane(display);
         textScrollPane.setPreferredSize(new Dimension(500,475));
         detail.add(textScrollPane);
         text2= new JTextArea();
         text2.setEditable(false);
          
         
          setVisible(true);
           
    }
    
 
    private class getID implements ActionListener{
        public void actionPerformed(ActionEvent e){
          int yr;
          if(e.getSource()==go){
            try{     
                        
                              yr= Integer.parseInt(year.getText());
                        text2.setText(com.spentLowestHighest(yr));
                      
            }catch (Exception a){
                         
              JOptionPane.showMessageDialog(null, "Invalid Input. Try again.");

            }
      }
          display.add(text2);
        }
    }
}
