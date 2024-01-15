import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
public class BookingPage extends JFrame implements ActionListener {
    
	static JButton sub=new JButton();
    static JButton h=new JButton();
    static JTextField t=new JTextField();
    static JTextField t1=new JTextField();
    static JTextField t2=new JTextField();
    static JLabel l;
    static JLabel lb;
    static BookingPage b;
    static String name,EmailId;
    static int mob;
    BookingPage() {
        //   JOptionPane.showMessageDialog(null, "Welcome to myframe", "prompt", JOptionPane.INFORMATION_MESSAGE);
        //   JOptionPane.showConfirmDialog(null, "are you mad", null, 0);
        //   JOptionPane.showInputDialog(null, "enter your name", "input promt", JOptionPane.QUESTION_MESSAGE);
        //   JOptionPane.showConfirmDialog(null, "are you mad", "alert", 0, JOptionPane.ERROR_MESSAGE, null);
       
        l=new JLabel();
        t=new JTextField();
        Border br=BorderFactory.createEtchedBorder(4,Color.gray,new Color(123,50,250));
        Border br2=BorderFactory.createEtchedBorder(25,Color.blue,new Color(123,250,50));
        //text feild code goes here
        t.setBounds(500,240,250,30);
        t.setBackground( Color.white);
        t.setText("Enter your Name"); 
        t.setBorder(br);
        t.setEditable(true);

        t1.setBounds(500,340,250,30);
        t1.setBackground( Color.white);
        t1.setText("Email ID");  
        t1.setBorder(br);
        // text field for number goes here 
        t2.setBounds(500,440,250,30);
        t2.setBackground( Color.white);
        t2.setText("Mobile Number");
        t2.setBorder(br);

        //sub button code goes here
        sub=new JButton();
        sub.setText("submit");
        sub.setBounds(550,550,150,50);
        sub.setFont(new Font("Vardana",Font.ITALIC, 18));
        sub.setBackground(getForeground());
        sub.addActionListener(this);
        sub.setOpaque(true);
        sub.setFocusPainted(false); 
        
        // home button code goes here
        h.setText("Home");
        h.setOpaque(true);
        h.setBounds(0,0,90,20);
        h.setFont(new Font("MALVIC", Font.PLAIN, 18));
        h.setBackground(new Color(220,120,170,100));
        h.addActionListener(this);
        h.setFocusPainted(false);
  
        //jlabel code goes here
        l.setOpaque(true);
        l.setBounds(350,70,550,550);
        l.setBackground(new Color(220,190,70,100));
        l.setBorder(br2);
        
        //head label text
        JLabel l2=new JLabel();
        l2.setText("Customer Information");
        l2.setFont(new Font("Dean Martin ",Font.ITALIC, 18));
        l2.setForeground(new Color(120,150,120));
        l2.setOpaque(true);
        l2.setBounds(475,125,290,50);  
        l2.setBackground(new Color(250,223,250,89)); 
        l2.setHorizontalTextPosition(JLabel.CENTER);
        l2.setVerticalTextPosition(JLabel.BOTTOM);
        l2.setVerticalAlignment(JLabel.CENTER);
        l2.setHorizontalAlignment(JLabel.CENTER);
        l2.setBorder(br2);

        JLabel l3=new JLabel();
        ImageIcon i=new ImageIcon("back2.jpg");
        l3.setIcon(i);
        l3.setBounds(0,0,1220,720);
        l3.setOpaque(true);
        
        lb= new JLabel();
        lb.setBounds(310,50,310,150);
        lb.setText("* Enter valid inputs");
        lb.setForeground(Color.red);
        lb.setOpaque(true);
        
        // jframe code goes here
        this.setVisible(true);
        this.setSize(1220,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.add(h);
        this.add(sub);
        this.add(t);
        this.add(t1);
        this.add(t2);
        this.add(l2);
        this.add(l);
        this.add(l3);  
    
    }
    public void actionPerformed(ActionEvent e)
    {
   try {  
     
      if(e.getSource()==sub){
         name=t.getText();
         EmailId=t1.getText();  
         mob= Integer.parseInt(t2.getText());
      if(EmailId=="Email ID"||EmailId==null || name=="Enter your Name" || name==null) {

    	  new BookingPage();
    	  this.add(lb); 
      }  
      else if(EmailId!="Email ID"||EmailId!=null || name!="Enter your Name" || name!=null){
       System.out.println(t.getText()+" welcome");
       System.out.println(EmailId+" email");
       System.out.println(mob+" mob");
       sub.setEnabled(false);
       JDBCcode o=new JDBCcode();
       o.insertCus_info(name,EmailId,mob);
       //JOptionPane.showMessageDialog(null,"loading Menu list","Alert",JOptionPane.INFORMATION_MESSAGE);
       new menulist();
       Billing b=new Billing(name);
       dispose();
       System.out.println("success");
           }
      }
   }
      catch(Exception e1) {
    	  System.out.println(e1);
      }
       
       if(e.getSource()==h){
        RSMS.obj.setVisible(true);
        //dispose();
       }
      }
    }  
        

