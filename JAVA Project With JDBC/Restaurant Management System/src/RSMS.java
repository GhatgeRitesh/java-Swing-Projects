
  // <=============================================Restaurant System Management Software =====================================================================>//

  
//import java.util.*;
import javax.swing.JFrame; 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public  class RSMS implements ActionListener{
  static JButton bt1;
 static JButton ad;
 static JFrame obj;
 
      public static void main(String[] args) {
        // Database connection code
        try { JDBCcode c=new JDBCcode();
        }
        catch(Exception e) {System.out.println(e);}
        // all declaration of 
         RSMS f=new RSMS(); 
         Border b=BorderFactory.createLineBorder(Color.green,4);
         Border b2=BorderFactory.createLineBorder(Color.white,2);
         obj=new JFrame("First Page");
         JLabel l1=new JLabel();
        
          // admin button ad goes here
          ad=new JButton();
          ad.setText("Admin ");
          ad.addActionListener(f);
          ad.setFont(new Font("Vardana",Font.ITALIC, 24));
          ad.setBounds(650,570,150,75);
          ad.setOpaque(true);
          ad.setFocusPainted(false);
          ad.setBorder(b2);
          ad.setBackground(new Color(120,170,220));

         //jbutton bt1 code goes here
          bt1=new JButton();
          bt1.setText("<html><center>Create<br><bold>Order</html>");
          bt1.addActionListener(f);
          bt1.setFont(new Font("Vardana",Font.ITALIC, 18));
          bt1.setBounds(350,570,150,75);
          bt1.setOpaque(true);
          bt1.setFocusPainted(false);
          bt1.setBorder(b2);
          bt1.setBackground(new Color(220,170,120));

          
         // jlabel code goes here
           l1.setText("<html><center>Welcome <br> <center>  to   <br><center> Restaunt Managment System</html>");
           l1.setHorizontalTextPosition(JLabel.CENTER);
           l1.setVerticalTextPosition(JLabel.BOTTOM);
           l1.setVerticalAlignment(JLabel.TOP);
           l1.setHorizontalAlignment(JLabel.CENTER);
           ImageIcon i2 =new ImageIcon("logo1.png");
           l1.setIcon(i2);
           l1.setForeground(new Color(120,50,120));
           l1.setOpaque(true);
           l1.setBounds(225,30,710,625);
           l1.setBorder(b);
           //l1.setBackground(new Color(50,250,123));
           l1.setFont(new Font("ARIAL",Font.PLAIN, 30));

        //jframe code goes below
         obj.setSize(1220,750);
         obj.setLocationRelativeTo(null);
         obj.setVisible(true);
         obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         obj.add(ad);
         
         obj.add(bt1);
         obj.add(l1);
         obj.setLayout(null);
         ImageIcon i=new ImageIcon("logo.jpg");
         obj.setIconImage(i.getImage());
         
                
     }
    
     public void actionPerformed(ActionEvent e){
       
       if(e.getSource()==bt1)
      {
        System.out.println(" transfer to Booking page");
        //JOptionPane.showMessageDialog(null,"you are Directed towards booking page","Alert",JOptionPane.INFORMATION_MESSAGE);
        new BookingPage();
        //obj.dispose();
        
      }
       
       if(e.getSource()==ad){
          // repeat code for the adfmin page login until user cancels operation
       Boolean flag=true;
       int pass=123456;
       try {
         while(flag!=false){  
         int input=Integer.parseInt(JOptionPane.showInputDialog("enter the password"));
          if(input==pass){
             new AdminPage();
            // obj.dispose();
             flag=false;
            }
          } 
          } catch (Exception e1) {
            System.out.println(e1);
          }
       }//end of if
     }
}

