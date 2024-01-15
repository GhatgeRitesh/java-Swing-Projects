import java.util.*; 
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
public class deleteitem extends JFrame implements ActionListener{
	 static List<String> itemselected=new ArrayList<>();
	 static List<Integer> priceselected=new ArrayList<>();
	 static JTable tb;
	 static JButton hm,del,cus,bk;
   deleteitem() throws SQLException{
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
	   
       JLabel lb=new JLabel();
       lb.setText("<html><center>Select the below options <br> to be deleted from the databases</html>");
       lb.setLayout(new FlowLayout());
       lb.setVerticalTextPosition(JLabel.TOP);
       lb.setBounds(390,10,550,160);
       lb.setForeground(Color.red);
       lb.setFont(new Font("ARIAL",Font.PLAIN, 30));
       lb.setOpaque(true);
       
       del=new JButton("<html><center>DELETE <br> ELEMENT</html>");
       del.setOpaque(true);
       del.setBounds(550,550,100,50);
       del.setFocusable(false);
       del.addActionListener(this);
       del.setBackground(Color.white);
       del.setForeground(Color.black);
       
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
       
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(1220,750);
       setLocationRelativeTo(null);
       setResizable(false);
       setLayout(null);
       add(sc);
       add(lb);
       add(bk);
       add(del);
       add(hm);
	   validate();
   }
   public void actionPerformed(ActionEvent e) {
	   if(e.getSource()==del) {
		   int t=tb.getSelectedRow();
		   String itemname=(String) tb.getValueAt(t,0);
		   System.out.println(itemname +" delete value");
		   try {
			JDBCcode obj=new JDBCcode();
			obj.delete(itemname);
			dispose();
			new deleteitem();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
		    System.out.println("vaule not found"+e1);
		}
	   }
       if(e.getSource()==hm/*del*/) {
		   RSMS.obj.setVisible(true);
		   dispose();
	   }
       if(e.getSource()==bk) {
		   new AdminPage();
		   dispose();
	   }
   }
   
}
