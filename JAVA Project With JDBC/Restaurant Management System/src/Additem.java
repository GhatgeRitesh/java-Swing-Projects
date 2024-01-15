import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Additem extends JFrame implements ActionListener {
   static JTextField t;
   static JTextField t1;
   static JTextField t2;
   static JButton b3,hm,bk;
   static JLabel lb4=new JLabel();
  
    Additem(){
        JLabel lb=new JLabel();
        JLabel lb1=new JLabel();
        JLabel lb2=new JLabel();
        JLabel lb3=new JLabel();
        
        Border b2=BorderFactory.createLineBorder(Color.orange,2);
        Border b1=BorderFactory.createLineBorder(Color.red,2);
      
        //labels code go here
      
       lb.setText("Item Name ");
       lb.setHorizontalTextPosition(JLabel.LEFT);
       lb.setVerticalTextPosition(JLabel.BOTTOM);
       lb.setVerticalAlignment(JLabel.CENTER);
       lb.setHorizontalAlignment(JLabel.LEFT);
       lb.setOpaque(true);
       lb.setBounds(400,200,150,30);
       lb.setBackground(new Color(250,223,250,89));
       lb.setFont(new Font("ARIAL",Font.PLAIN, 18)); 
       lb.setBorder(b1);
       

       lb1.setText("Item price ");
       lb1.setHorizontalTextPosition(JLabel.LEFT);
       lb1.setVerticalTextPosition(JLabel.BOTTOM);
       lb1.setVerticalAlignment(JLabel.CENTER);
       lb1.setHorizontalAlignment(JLabel.LEFT);
       lb1.setOpaque(true);
       lb1.setBounds(400,300,150,30);
       lb1.setBackground(new Color(250,223,250,89)); 
       lb1.setFont(new Font("ARIAL",Font.PLAIN, 18));
       lb1.setBorder(b1);

       lb2.setText("margin");
       lb2.setHorizontalTextPosition(JLabel.LEFT);
       lb2.setVerticalTextPosition(JLabel.BOTTOM);
       lb2.setVerticalAlignment(JLabel.CENTER);
       lb2.setHorizontalAlignment(JLabel.LEFT);
       lb2.setOpaque(true);
       lb2.setBounds(400,400,150,30);
       lb2.setBackground(new Color(250,223,250,89)); 
       lb2.setFont(new Font("ARIAL",Font.PLAIN, 18));
       lb2.setBorder(b1);
       
       lb3.setOpaque(true);
       lb3.setBounds(100,50,950,530);
       lb3.setBackground(new Color(250,223,250,89));
       lb3.setBorder(b2); 
       
       
       lb4.setText("Successful");
       lb4.setOpaque(true);
       lb4.setBounds(510,0,200,75);
       lb4.setBackground(new Color(50,60,50)); 
       lb4.setFont(new Font("ARIAL",Font.PLAIN, 36));
       
       JLabel lb5=new JLabel();
       lb5.setText("<html><center>ADD NEW DISH  TO MENU CARD</html>");
       lb5.setHorizontalTextPosition(JLabel.CENTER);
       lb5.setVerticalTextPosition(JLabel.CENTER);
       lb5.setVerticalAlignment(JLabel.CENTER);
       lb5.setHorizontalAlignment(JLabel.CENTER);
       lb5.setOpaque(true);
       lb5.setBounds(450,75,350,60);
       lb5.setBackground(new Color(250,223,250)); 
       lb5.setFont(new Font("ARIAL",Font.PLAIN, 24));
       
       
       // textfield code goes here
       t=new JTextField();
       t.setBorder(b2);
       t.setBackground(Color.LIGHT_GRAY);
       t.setBounds(520,200,300,30);
       t.setCaretColor(Color.MAGENTA);
       t.setColumns(2);
       t.addActionListener(this);

       t1=new JTextField();
       t1.setBorder(b2);
       t1.setBackground(Color.LIGHT_GRAY);
       t1.setBounds(520,300,300,30);
       t1.setCaretColor(Color.MAGENTA);
       t1.setColumns(2);
       t1.addActionListener(this);

       t2=new JTextField();
       t2.setBorder(b2);
       t2.setBackground(Color.LIGHT_GRAY);
       t2.setBounds(520,400,300,30);
       t2.setCaretColor(Color.MAGENTA);
       t2.setColumns(2);
       t2.addActionListener(this);
       
       // button code
       b3=new JButton();
       b3.setText("Submit");
       b3.setOpaque(true);
       b3.setBounds(500,524,175,30);
       b3.setFont(new Font("MALVIC", Font.PLAIN, 24));
       b3.setFocusable(false);
       b3.setBackground(Color.gray);
       b3.addActionListener(this);
       b3.setBorder(b2);
     
       hm=new JButton("Home");
       hm.setOpaque(true);
       hm.setBounds(10,0,75,25);
       hm.setFont(new Font("ARIAL", Font.PLAIN, 14));
       hm.setForeground(new Color(255,255,255));
       hm.setFocusable(false);
       hm.setBackground(new Color(50, 50, 20));
       hm.addActionListener(this);
       
       bk=new JButton("Back");
       bk.setOpaque(true);
       bk.setBounds(10,30,75,25);
       bk.setFont(new Font("ARIAL", Font.PLAIN, 14));
       bk.setForeground(new Color(255,255,255));
       bk.setFocusable(false);
       bk.setBackground(new Color(50, 50, 20));
       bk.addActionListener(this);
      
     // main frame code goes here
             setVisible(true);
             setTitle("item insertion");
             setSize(1220,750);
             setLocationRelativeTo(null);
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             setResizable(false);
             setLayout(null);
             add(b3);
             add(lb);
             add(lb1);
             add(lb2);
             add(t);
             add(t1);
        add(t2);
        add(lb3);
        add(hm);
        add(bk);
        add(lb5);
        
    }
    public void actionPerformed(ActionEvent e){
        try {
          if(e.getSource()==b3)
          {
            String name=t.getText();
            System.out.println(name);
            int price=Integer.parseInt(t1.getText());
            System.out.println(price);
            int margin=Integer.parseInt(t2.getText());
            System.out.println(margin);
            JDBCcode o=new JDBCcode();
            o.insert(name,price,margin);
           
            
            t.setText("");
            t1.setText("");
            t2.setText("");
            this.add(lb4);
            validate();
          }
          if(e.getSource()==hm/*del*/) {
     		   RSMS.obj.setVisible(true);
     		   dispose();
     	   }
        } catch (Exception e2) {
          // TODO: handle exception
          System.out.println(e2);
        }  
        if(e.getSource()==bk) {
 		   new AdminPage();
 		   dispose();
 	   }
    }
}
