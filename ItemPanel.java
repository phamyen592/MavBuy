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
public class ItemPanel extends JPanel {
    
    MavBuyTest com= new MavBuyTest();
   JLabel message ;
   JPanel top;
   JComboBox <Object>mainList ;
   Expendixture expendixture = new Expendixture(com);
   RevenuePanel revenue = new RevenuePanel(com);
   DetailItems displayAllDetails= new DetailItems(com);


    public ItemPanel(MavBuyTest com ) {
       // this.sublist = new JComboBox();
       
    this.com = com;
       
      setLayout(new BorderLayout());
        message = new JLabel("Options");
        top= new JPanel();
        top.add(message);
         String list[]= {"Revenue for the data set","Items Details","Expenditure"};
         mainList = new JComboBox(list);
            top.add(mainList);
            this.add(top, BorderLayout.NORTH);
         
         displayAllDetails = new DetailItems(com);
        //mainList.add(list[0],this.displayAllDetails);
         expendixture = new Expendixture(com);
         revenue = new RevenuePanel(com);
        // mainList.add(list[1],this.revenue);
        // mainList.add(list[2],this.expendixture);
            
           // top.add(mainList, BorderLayout.);
           // mainList.setSize(15, 50);
          MainListEvent e = new MainListEvent();
            mainList.setEditable(false);
           mainList.addActionListener(new MainListEvent());
            
            this.setVisible(true);
    }
        public class MainListEvent implements ActionListener{
        
            @Override
        public void actionPerformed(ActionEvent e){
            if (e.getSource()== mainList){
        JComboBox cb = (JComboBox)e.getSource();
        //String option = (String)cb.getSelectedItem();
           int op = cb.getSelectedIndex();
           if (e.getSource()==mainList)
        if (op==0){
           
            displayAllDetails.setVisible(false);
            expendixture.setVisible(false);
             add(revenue);
             revenue.setVisible(true);
           
        }
            
        if (op==1){
            
            revenue.setVisible(false);
            expendixture.setVisible(false);
                add(displayAllDetails);
                displayAllDetails.setVisible(true);

            
        }if (op==2){

            displayAllDetails.setVisible(false);
            revenue.setVisible(false);
            add(expendixture);
            expendixture.setVisible(true);
            }
    }
        }
          
    }
//  public void DetailItems(){
//      
//       
//        left = new JPanel();
//        left.setLayout(new BorderLayout(500,200));   
//        String listStr[]= {"Item ID","All Items"};
//       sublist = new JComboBox<String>(listStr);
//      
//        this.add(left, BorderLayout.WEST);
//        left.add(sublist,BorderLayout.NORTH);
//        detail= new JPanel();
//       detail.setLayout(new BorderLayout(500,25));   
//        this.add(detail,BorderLayout.CENTER);
//       sublist.setEditable(false);
//        sublist.addActionListener(new DetailEvent());
//        
//         display = new JPanel();
//         display.setLayout(new BorderLayout());
//         topdetailsFrame= new JPanel();
//         topdetails = new JPanel();
//         topdetailsFrame.setLayout(new BorderLayout(500,25));
//         topdetailsFrame.add(topdetails, BorderLayout.NORTH);
//         detail.add(topdetailsFrame, BorderLayout.NORTH);
//         detail.add(display,BorderLayout.CENTER);
//         textScrollPane = new JScrollPane(display);
//         textScrollPane.setPreferredSize(new Dimension(500,475));
//         detail.add(textScrollPane);
//         
//         this.setVisible(true);
//   } 
//         
//         
//    

//    private class DetailEvent implements ActionListener{
//        public void actionPerformed(ActionEvent e){
//            if (e.getSource()== sublist){
//        JComboBox cb = (JComboBox)e.getSource();
//        //String option = (String)cb.getSelectedItem();
//        int op = cb.getSelectedIndex();
//        if (e.getSource()==sublist)
//        if (op==1){
//             topdetails.removeAll();
//             //text.removeAll();
//             text= new JTextArea();
//             text.setEditable(false);
//            text.setWrapStyleWord(true);
//            text.setLineWrap(true);
//            allLabel= new JLabel("ALL ITEMS DETAILS");
//             topdetails.add(allLabel);
//           
//            text.setText(com.getALLItemText());
//           display.add(text);
//           
//            
//        if (op==0){
//            topdetails.removeAll();
//            ID= new JTextField(10);
//            
//            IDLabel = new JLabel("Enter Item ID");
//            go = new JButton("GO");
//            
//            topdetails.add(IDLabel);
//            topdetails.add(ID);
//            topdetails.add(go);
//            getID ev = new getID();
//           ID.addActionListener(ev);
//           go.addActionListener(ev);
//           
//        }
//      
//    }}
//          
//    }}
//    private class getID implements ActionListener{
//        public void actionPerformed(ActionEvent e){
//         
//            if (e.getSource()==ID||e.getSource()== go){
//                String Id;
//                try{
//                    Id = (String)ID.getText();
//                    
//                }catch(Exception a){
//                    Id = " ";
//                }
//                text= new JTextArea();
//            text.setEditable(false);
//            text.setWrapStyleWord(true);
//            text.setLineWrap(true);
//                 
//                  display.add(text);
//                 text.setText(com.getItemText(Id));
//            }
//        }
//    }
//    public void expendixture (){
//           
//        left = new JPanel();
//        left.setLayout(new BorderLayout(500,200));   
//        String list[];
//            list = new String[com.getItems().size()+1];
//        list[0]=("Enter Item ID");
//        for(int i = 0; i<com.getItems().size();i++){
//            list[i+1]=(com.getItems().get(i).getModelID());
//        }
//                
//       sublist = new JComboBox<String>(list);
//         
//        this.add(left, BorderLayout.WEST);
//        left.add(sublist,BorderLayout.NORTH);
//        detail= new JPanel();
//       detail.setLayout(new BorderLayout(500,25));   
//        this.add(detail,BorderLayout.CENTER);
//       sublist.setEditable(false);
//        sublist.addActionListener(new DetailEvent2());
//        
//         display = new JPanel();
//         display.setLayout(new BorderLayout());
//         topdetails = new JPanel();
//         topdetailsFrame = new JPanel();
//         topdetailsFrame.setLayout(new BorderLayout());
//         topdetailsFrame.add(topdetails, BorderLayout.NORTH);
//         detail.add(topdetailsFrame, BorderLayout.NORTH);
//         detail.add(display,BorderLayout.CENTER);
//         textScrollPane = new JScrollPane(display);
//         textScrollPane.setPreferredSize(new Dimension(500,475));
//         detail.add(textScrollPane);
//         this.setVisible(true);
//         
//        }
//         private class DetailEvent2 implements ActionListener{
//        public void actionPerformed(ActionEvent e){
//            if (e.getSource()== sublist){
//        JComboBox cb = (JComboBox)e.getSource();
//        //String option = (String)cb.getSelectedItem();
//        int op = cb.getSelectedIndex();
//        if (e.getSource()==sublist){
//        if (op==0){topdetails.removeAll();
//            ID= new JTextField(10);
//            
//            IDLabel = new JLabel("Enter Employee ID");
//            go = new JButton("GO");
//            
//            
//            topdetails.add(IDLabel);
//            topdetails.add(ID);
//            topdetails.add(go);
//            getID2 ev = new getID2();
//           ID.addActionListener(ev);
//           go.addActionListener(ev);
//          
//             
//        }
//         else {int index = op-1;
//            topdetails.remove(allLabel);
//             //text.removeAll();
//             text= new JTextArea();
//             text.setEditable(false);
//            text.setWrapStyleWord(true);
//            text.setLineWrap(true);
//            allLabel= new JLabel("ITEM " + com.getItems().get(index).getModelID());
//             topdetails.add(allLabel);
//           
//            text.setText(com.expenditure(com.getItems().get(index).getModelID()));
//           display.add(text);
//           
//        }
//      
//    }}
//    
// }
//        
//         }
//         private class getID2 implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e){
//         String Id;
//            if (e.getSource()==ID||e.getSource()== go){
//             
//                    Id = (String)ID.getText();
//                    
//               
//                text= new JTextArea();
//            text.setEditable(false);
//            text.setWrapStyleWord(true);
//            text.setLineWrap(true);
//                 text.setText(com.expenditure(Id));
//                  display.add(text);
//            }
//        }
//    }
//    public void revenue(){
//        
//    }
}