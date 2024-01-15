import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends JFrame implements ActionListener {
  static JLabel ob; 
  
  static JButton b2,b3,b4,ad;
 
  
   AdminPage(){
        System.out.println("successful transit");
        Border b=BorderFactory.createTitledBorder("Admin"); 
        //main label code

         ob =new JLabel();
         ob.setText("Choose Access Choices ");
         ob.setVerticalTextPosition(JLabel.TOP);
         ob.setHorizontalTextPosition(JLabel.CENTER);
         ob.setVerticalAlignment(JLabel.TOP);
         ob.setHorizontalAlignment(JLabel.CENTER);
         ob.setOpaque(true);
         ob.setBounds(325,40,610,650);
         ob.setBorder(b);
         ob.setFont(new Font("MALVIC", Font.PLAIN, 24));
         
  
       // button codes
        ad=new JButton("Home");
        ad.setOpaque(true);
        ad.setBounds(10,0,75,25);
        ad.setFont(new Font("ARIAL", Font.PLAIN, 14));
        ad.setForeground(new Color(255,255,255));
        ad.setFocusable(false);
        ad.setBackground(new Color(50, 50, 20));
        ad.addActionListener(this);
        
       b2=new JButton();
       b2.setText("Add Item");
       b2.setOpaque(true);
       b2.setBounds(550,194,220,30);
       b2.setFont(new Font("ARIAL", Font.PLAIN, 24));
       b2.setFocusable(false);
       b2.setBackground(new Color(250, 250, 120));
       b2.addActionListener(this);

       b3=new JButton();
       b3.setText("Delete Item");
       b3.setOpaque(true);
       b3.setBounds(420,294,220,30);
       b3.setFont(new Font("MALVIC", Font.PLAIN, 24));
       b3.setFocusable(false);
       b3.setBackground(Color.gray);
       b3.addActionListener(this);

       b4= new JButton();
       b4.setText("Sells analysis");
       b4.setOpaque(true);
       b4.setBounds(650,294,220,30);
       b4.setFont(new Font("MALVIC", Font.PLAIN, 24));
       b4.setFocusable(false);
       b4.setBackground(Color.white);
       b4.addActionListener(this);


       //mainframe code goes here\
        this.setVisible(true);
        this.setSize(1220,750);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        add(ad);
        this.add(ob);
        this.setLayout(null);
     }
     public void actionPerformed(ActionEvent e){
           try {
            if(e.getSource()==b2){
            new Additem();
            dispose();
           } 
            if(e.getSource()==b3){
                new deleteitem();
                dispose();
               } 
            if(e.getSource()==ad) {
            	RSMS.obj.setVisible(true);
                dispose();
            }
            if(e.getSource()==b4) {
            	new Sells();
                dispose();
            }
           } catch (Exception e2) {
            // TODO: handle exception
            System.out.println(e2);
           }
     }
}
