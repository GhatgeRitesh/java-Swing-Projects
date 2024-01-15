import java.sql.*; 
import java.util.*;
// implementing  into  
public class JDBCcode{
	static Connection conn;
	
	    JDBCcode() throws SQLException{
		String username= "root";
	    String password="Rit!@#1115";
	    String url="jdbc:mysql://localhost:3306/Restaurant_Project";
		this.conn=DriverManager.getConnection(url,username,password);
	}
	    
	    
	    //-----------------------cus_info table data fetct to mysql ------------------------------------------>
	public void insertCus_info(String name,String Email,int mob)throws SQLException {
		String qq="insert into Cus_info (Name,Email_ID,Mob_no,total) values(?,?,?,?)";
		PreparedStatement p= conn.prepareStatement(qq);
		
		p.setString(1,name);
		p.setString(2,Email);
		p.setInt(3,mob);
		p.setInt(4, 1);
		p.executeUpdate();
		
	}
	public void expense(double d) throws SQLException {
		String query="update cus_info set total= total + ?";
		PreparedStatement p=conn.prepareStatement(query);
		p.setDouble(1, d);
		p.executeUpdate();
	}
	public List<String> CUSNAME()throws SQLException{
		List<String> Name=new ArrayList<>();
		ResultSet r=conn.createStatement().executeQuery("select * from cus_info");
		while(r.next()) {Name.add(r.getString("Name"));}
		return Name;
	}
	public List<Integer> EXPENSE()throws SQLException{
		List<Integer> total=new ArrayList<>();
		ResultSet r=conn.createStatement().executeQuery("select * from Cus_Info");
		while(r.next()) {total.add(r.getInt("total"));}
		return total;
	}
	
	
	
	//----------------------------------admin accesed database -----------------------------------//
	//admin-accessed adding menu list 
	public void insert(String Itemname,int price,int margin) throws SQLException{
		String q1= "insert into items(item_name,price,margin) values(?,?,?)";
		PreparedStatement p=conn.prepareStatement(q1);
		p.setString(1, Itemname);
		p.setInt(2,price);
		p.setInt(3,margin);
		p.executeUpdate();
	}
	//---------------------------deletion operation--------------------------------
	public void delete(String name) throws SQLException {
		 String q3="delete from items where item_name=?";
		 PreparedStatement p=conn.prepareStatement(q3);
		 p.setString(1, name);
		 p.executeUpdate();
	}
	
  //-------------------------------------Adding the sells into the table -----------------------------------
	public void  update(List<Integer> Quantity ,List<String> item) throws SQLException{
		String q2="UPDATE items set Sell=Sell+ ? where item_name= ? ";
		PreparedStatement p=conn.prepareStatement(q2);
		int n=Quantity.size();
		for(int i=0;i<n;i++) {
		p.setInt(1, Quantity.get(i));
		p.setString(2,item.get(i));
		p.executeUpdate();
		}
	}
//---------------------------------------data fetch into the  UI / tables ---------------------------------	
	/*public List<String> fetchdata()throws SQLException{
		List<String> itemname=new ArrayList<>();
		List<Integer> price=new ArrayList<>();
		List<Integer> margin=new ArrayList<>();
		
		ResultSet r=conn.createStatement().executeQuery("select * from items");
		while(r.next()) {
			itemname.add(r.getString("item_name"));
			price.add(r.getInt("price"));
			margin.add(r.getInt("margin"));
		}

		
		return itemname ;
	}*/
	//----------------------------------------------------- fetching the data into table for the menu--------
	public List<String> tabledata()throws SQLException{
		List<String> itemname=new ArrayList<>();
		ResultSet r=conn.createStatement().executeQuery("select * from items");
		while(r.next()) {itemname.add(r.getString("item_name"));}
		return itemname;
	}
	public List<Integer> getprice()throws SQLException{
		List<Integer> price=new ArrayList<>();
		ResultSet r=conn.createStatement().executeQuery("select * from items");
		while(r.next()) {price.add(r.getInt("price"));}
		return price;
	}
	public List<Integer> sell()throws SQLException{
		List<Integer> Quantity=new ArrayList<>();
		ResultSet r=conn.createStatement().executeQuery("select * from items");
		while(r.next()) {Quantity.add(r.getInt("Sell"));}
		return Quantity;
	}
	
	
	
	// ----------------------------------------------close Connection with Mysql--------------------------------
	public void  closeconnection() throws SQLException {
		 if(conn!=null) {
			 conn.close();
		 }
	}
}