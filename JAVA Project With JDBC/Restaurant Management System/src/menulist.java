import javax.swing.JFrame;  
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class menulist extends JFrame implements ActionListener {
    static JButton bt,bt2,hm;
    static JTable tb;
    static JLabel lb2;
    static JTextField t;
    static List<String> itemselected=new ArrayList<>();
	static List<Integer> priceselected=new ArrayList<>();
	static List<Integer> Quantity=new ArrayList<>();
      menulist()throws SQLException{
    	      
              // border
              Border b=BorderFactory.createLineBorder(new Color(14,122,52), 5,true);
              Border b1=BorderFactory.createLineBorder(new Color(14,122,52), 1,true);
             // table code goes here
              
              DefaultTableModel o=new DefaultTableModel(new Object[]{"item_name","price"},0);
              JDBCcode c=new JDBCcode();
              List<String> items=new ArrayList<>();
              items=c.tabledata();

              List<Integer> price=new ArrayList<>();
              price=c.getprice();
              for (int i = 0; i < items.size(); i++) {
                  o.addRow(new Object[]{items.get(i), price.get(i)});
              }
              
              tb=new JTable(o);
              tb.setEnabled(true);
              tb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
              
              JScrollPane sc=new JScrollPane(tb);
              sc.setSize(520,320);
              sc.setLocation(350,150);
            
            // lable 1 code goes here
            JLabel lb1=new JLabel();
            lb1.setOpaque(true);  
            lb1.setText("<html><center>Welcome to Menu List <br>PLz Select Items</html>");
            lb1.setForeground(new Color(123,50,250));
            lb1.setFont(new Font("ARIAL",Font.PLAIN, 36));
            lb1.setHorizontalAlignment(JLabel.CENTER);
            lb1.setVerticalAlignment(JLabel.TOP);
            lb1.setBounds(260,55,710,590);
            lb1.setBorder(b);
            
            // text field for the  quantiy of items
            t=new JTextField("1");
            t.setOpaque(true);
            t.setFont(new Font("ARIAL",Font.PLAIN, 14));
            t.setHorizontalAlignment(JLabel.CENTER);
            t.setBounds(465,500,50,30);
            t.setBorder(b1);
            
            JLabel ll=new JLabel("Quantity");
            ll.setOpaque(true);
            ll.setBorder(b1);
            ll.setFont(new Font("ARIAL",Font.PLAIN, 14));
            ll.setForeground(Color.red);
            ll.setHorizontalTextPosition(JLabel.CENTER);
            ll.setBounds(365,500,100,30);
            
            // add button 
            bt= new JButton("ADD");
            bt.setBounds(550,500,80,55);
            bt.setFocusable(false);
            bt.setBackground(new Color(225,125,125));
            bt.addActionListener(this);
            
            
            bt2=new JButton("Get Bill");
            bt2.setBounds(750,500,80,55);
            bt2.setFocusable(false);
            bt2.setBackground(new Color(125,225,125));
            bt2.addActionListener(this);
            
            hm=new JButton("Home");
            hm.setOpaque(true);
            hm.setBounds(10,0,75,25);
            hm.setFont(new Font("ARIAL", Font.PLAIN, 14));
            hm.setForeground(new Color(255,255,255));
            hm.setFocusable(false);
            hm.setBackground(new Color(50, 50, 20));
            hm.addActionListener(this);
            
            // frame code 
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(1220,750);
            setLocationRelativeTo(null);
            setResizable(false);
            setLayout(null);
            add(sc);
            add(t);
            add(ll);
            add(bt);
            add(bt2);
            add(lb1);
            add(hm);
           
            validate();
            
          }
          




@Override
  public void actionPerformed(ActionEvent e){
	 if (e.getSource() == bt) {
		 
		 /* */
	        	 
	        int[] selectedRows = tb.getSelectedRows();
	        int quantity=Integer.parseInt(t.getText());
	        if (selectedRows.length > 0) {
	            System.out.println("Selected Items:");
	           
	        
	            for (int row : selectedRows) {
	            	String itemName = (String) tb.getValueAt(row, 0);
	                int price = (int) tb.getValueAt(row, 1);
	                System.out.println("Item: " + itemName + ", Price: " + price);
	                itemselected.add(itemName);
	                priceselected.add(price);
	                Quantity.add(quantity);
	          }
	         t.setText("1");   
	           
	        } else {
	            System.out.println("No items selected.");
	        }
	 }
	 if(e.getSource()==bt2) {
		 for (int i = 0; i < itemselected.size(); i++) {
             System.out.println(itemselected.get(i));
         }
		 Billing bb=new Billing();
		 dispose();
	    }
	 if(e.getSource()==hm/*del*/) {
		   RSMS.obj.setVisible(true);
	   }
	 
  }          
    
}
