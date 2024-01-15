import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.JTable.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
public class Sells extends JFrame implements ActionListener {
     static JButton c,s,hm,bk; static JTable tb;
     static Border b=BorderFactory.createLineBorder(Color.red,1);
     static Border b1=BorderFactory.createLineBorder(Color.green,5);
	Sells(){
		setVisible(true);
		setSize(1220,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	    setResizable(false);
	    setLayout(null);
	        
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
	    
	        c=new JButton("Customer Data");
	        c.setOpaque(true);
	        c.setBounds(440,10,150,35);
	        c.setFont(new Font("ARIAL", Font.PLAIN, 14));
	        c.setForeground(new Color(255,255,255));
	        c.setFocusable(false);
	        c.setBackground(new Color(150, 50, 120));
	        c.addActionListener(this);
	        
	        s=new JButton("Sells Report");
	        s.setOpaque(true);
	        s.setBounds(650,10,150,35);
	        s.setFont(new Font("ARIAL", Font.PLAIN, 14));
	        s.setForeground(new Color(255,255,255));
	        s.setFocusable(false);
	        s.setBackground(new Color(50, 150, 120));
	        s.addActionListener(this);
	        
	    add(hm);
	    add(bk);
	    add(c);
	    add(s);
	}
	
    public void Cus_Info() throws SQLException {
    	DefaultTableModel o=new DefaultTableModel(new Object[]{"Name","Total Expense"},0);
        JDBCcode c=new JDBCcode();
        List<String> Name=new ArrayList<>();
        Name=c.CUSNAME();

        List<Integer> expense=new ArrayList<>();
        expense=c.EXPENSE();
        for (int i = 0; i < Name.size(); i++) {
            o.addRow(new Object[]{Name.get(i), expense.get(i)});
        }
        
        tb=new JTable(o);
        tb.setEnabled(true);
        tb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tb.setBorder(b);
        JScrollPane sc=new JScrollPane(tb);
        sc.setSize(520,520);
        sc.setLocation(50,150);
  	//-------------------------------------label code -----------------------------------//
  	add(sc);
    }
    public void sell() throws SQLException {
    	
    	//-----------------table code ----------------------------------------------------
    	
    	  DefaultTableModel o=new DefaultTableModel(new Object[]{"item_name","price"},0);
          JDBCcode c=new JDBCcode();
          List<String> items=new ArrayList<>();
          items=c.tabledata();

          List<Integer> sell=new ArrayList<>();
          sell=c.sell();
          for (int i = 0; i < sell.size(); i++) {
              o.addRow(new Object[]{items.get(i), sell.get(i)});
          }
          
          tb=new JTable(o);
          tb.setEnabled(true);
          tb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          tb.setBorder(b);
          JScrollPane sc=new JScrollPane(tb);
          sc.setSize(520,520);
          sc.setLocation(550,150);
    	//-------------------------------------label code -----------------------------------//
    	add(sc);
    	
    	validate();
    }
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==hm) {
			   RSMS.obj.setVisible(true);
			   dispose();
		   }
	       if(e.getSource()==bk) {
			   new AdminPage();
			   dispose();
		   }
	       
	       if(e.getSource()==c) {
	    	   try {
				Cus_Info();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	   System.out.println("button one working");
	       }
	       if(e.getSource()==s) {
	    	   try {
				sell();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	   System.out.println("button two working");
	       }
	}
}
