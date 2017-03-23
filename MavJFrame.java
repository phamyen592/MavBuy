/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yenpham
 */
import javax.swing.*;
import java.awt.*;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.PAGE_START;
import java.awt.event.ActionEvent;
import java.util.*;
/**
 *
 * @author Yenpham
 */
public class MavJFrame extends JFrame {
    
    MavBuyTest com;
    int width = 740;
    int height = 580;
    int gridRow = 3;
    int gridCol = 1;
    JPanel wel;
    JLabel greeting;
    ClientPanel ClientPanel;
    EmployeePanel employeePanel;
    ItemPanel itemPanel;
    JTabbedPane tabs;
    
    /**
     * Creates new form MavJFrame
     * @param a
     */
    public MavJFrame(MavBuyTest  a) {
            com= a;
  
            setTitle("MavBuyTest");
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		//setLayout(new GridLayout(gridRow,gridCol));
		greeting= new JLabel("Welcome to "+a.getCompanyName()+"!");
               // greeting.setVerticalTextPosition(JLabel.CENTER);
                greeting.setHorizontalTextPosition(JLabel.CENTER);
             wel = new JPanel();
//                wel.setSize(wi);
                wel.setLayout(new BorderLayout());
                wel.add(greeting,BorderLayout.CENTER);
                this.add(wel,BorderLayout.NORTH);
              
                 ClientPanel=new ClientPanel(a); 
                 tabs = new JTabbedPane();
                 this.add(tabs,BorderLayout.CENTER);
                 tabs.setBackground(Color.PINK);
                 
                 tabs.addTab("Client",ClientPanel);
                 employeePanel = new EmployeePanel(a);
                  tabs.addTab("Employee",employeePanel);
                  itemPanel = new ItemPanel(a);
                  tabs.addTab("Items",itemPanel);
            
		setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        popupMenu1 = new java.awt.PopupMenu();

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables



    
 
}
 
