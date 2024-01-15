import java.util.ArrayList; 
import java.util.List; 
import javax.swing.*;
import javax.swing.border.Border;
import java.time.*;
import java.time.format.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.table.*;
import javax.swing.table.DefaultTableModel.*;

public class Billing extends JFrame implements ActionListener {
	    List<String> item=new ArrayList<>();
	    List<Integer> price=new ArrayList<>();
	    List<Integer> Quan=new ArrayList<>();
	    List<Integer> price1=new ArrayList<>();
	    static String cus;
	    double total;
	static JButton hm,dn;
	 public Billing(String name) {cus=name;}
       Billing() {
    	setVisible(true);
		setTitle("Billing page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1210,750);
		setLocationRelativeTo(null);
		setLayout(null);
		Border b= BorderFactory.createLineBorder(Color.orange,2);
		Border b1= BorderFactory.createLineBorder(Color.black);
		Border bbb1= BorderFactory.createLineBorder(Color.yellow);
		
		// code for lable of hotel krishna 
		JLabel lb= new JLabel("Original Reciept");
		ImageIcon i=new ImageIcon("Kitchens.png");
		lb.setIcon(i);
		lb.setIconTextGap(50);
		lb.setVerticalTextPosition(JLabel.CENTER);
		lb.setHorizontalTextPosition(JLabel.RIGHT);
		lb.setVerticalAlignment(JLabel.TOP);
		lb.setOpaque(true);
		lb.setBounds(300,10,500,150);
		lb.setForeground(new Color(150,123,50));
		lb.setFont(new Font("Arial", Font.BOLD, 36));
		lb.setBackground(new Color(255,255,255));
		lb.setBorder(b);
		
		//BookingPage bo=new BookingPage();
		//String Name=bo.name;
		JLabel lb1=new JLabel("Name :- "+ cus);
		lb1.setHorizontalTextPosition(JLabel.LEFT);
		lb1.setFont(new Font("Arial", Font.BOLD, 14));
		lb1.setOpaque(true);
		lb1.setBounds(300,160,250,50);
		lb1.setBorder(b1);
	     

	    LocalDateTime time=LocalDateTime.now();
	    DateTimeFormatter form=DateTimeFormatter.ofPattern("dd-MM-yyyy , HH:mm:ss");
	    String datetime =time.format(form);
	    JLabel lb3=new JLabel("<html><Bold><Right>Details<br>DATE :-"+datetime);
	    lb3.setFont(new Font("Arial", Font.BOLD, 14));
	    lb3.setOpaque(true);
	    
        
	    
	    JLabel lb4= new JLabel();
	    lb4.setOpaque(true);
	    lb4.setBounds(100,10,900,675);
	    lb4.setBackground(new Color(255,255,255,100));
	    lb4.setBorder(b);
	    
	    hm=new JButton("Home");
	       hm.setOpaque(true);
	       hm.setBounds(10,0,75,25);
	       hm.setFont(new Font("ARIAL", Font.PLAIN, 14));
	       hm.setForeground(new Color(255,255,255));
	       hm.setFocusable(false);
	       hm.setBackground(new Color(50, 50, 20));
	       hm.addActionListener(this);
	       
	       dn=new JButton("DONE");
	       dn.setOpaque(true);
	       dn.setBounds(850,650,100,25);
	       dn.setFont(new Font("ARIAL", Font.PLAIN, 14));
	       dn.setForeground(new Color(255,255,255));
	       dn.setFocusable(false);
	       dn.setBackground(new Color(50, 50, 20));
	       dn.addActionListener(this);
//--------------------------------------------------------------------------------------------------------------	        
	    // table code 
	    try { 
			 menulist m=new menulist(); 
			 m.dispose();
			 item=m.itemselected;
			 price=m.priceselected;
			 Quan=m.Quantity;
			 int len=item.size();
			 for(int z=0;z<len;z++) {price1.add(price.get(z)*Quan.get(z));}
		    }catch(Exception e) {System.out.println(e);}
	   
	    String[] columnNames = {"Items","Quantity","Price","Total"};
	    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
	    JTable table = new JTable(tableModel);
	    table.setSize(450,230);
	    table.setLocation(325, 210);
	    

	    // Adding items, quantities, and prices to the table
	    for (int j = 0; j < item.size(); j++) {
	        tableModel.addRow(new Object[]{item.get(j),Quan.get(j),price.get(j),price1.get(j)});
	    }

	    // Creating a label for the total
	    JLabel total = new JLabel("Total: " + calculateTotal());
	    total.setOpaque(true);
	    //total.setBackground(new Color(20,25,25));
	    total.setForeground(Color.black);
	    Border bbb=BorderFactory.createBevelBorder(2, Color.red, Color.gray);
	    total.setVerticalAlignment(JLabel.CENTER);
	    

	    // Creating scroll pane for the table
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBorder(bbb1);
	    // Creating panel for the table and total label
	    
	    // Adding the main panel to the frame
	    
	    

	    // Method to calculate the total
	    
	    
//----------------------------------------------------------------------------------------------------------------	       

	        //code for the Jpanel Details and Table Insert
	  		JPanel jp=new JPanel();
	  		jp.setOpaque(true);
	  		jp.setBounds(550,160,250,50);
	  		jp.add(lb3);
	  		jp.setBorder(b1);
	  		
	  	   
	  	    
	  	    JPanel jp1=new JPanel();
	  	    jp1.setOpaque(true);
	  	    jp1.setBounds(300,210,500,450);
	  	    jp1.setBorder(b1);
	  	    jp1.add(scrollPane);
	  	    
	  	    JPanel jp2=new JPanel();
	  	    jp2.setOpaque(true);
	  	    jp2.setBounds(600,620,200,40);
	  	    jp2.setBorder(bbb1);  
	  	    jp2.add(total);
//	  	    jp2.setBackground(new Color(150,23,25));
	  		
		add(lb);
		add(lb1);
		add(lb4);
		add(jp);
		add(jp2);
		add(jp1);
		add(hm);
		add(dn);
		//add(scrollPane);
		validate();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource()==hm ) {
			   RSMS.obj.setVisible(true);
			   dispose();
		   }
		 if(e.getSource()==dn) {
			 try {
				JDBCcode c=new JDBCcode();
				c.update(Quan,item);
				c.expense(total);
				dispose();
				RSMS.obj.setVisible(true); 
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 }
		
	}
	private double calculateTotal() {
	     total = 0;
	    for (int i = 0; i < item.size(); i++) {
	        total += price1.get(i);
	    }
	    return total;
	    }
	}




