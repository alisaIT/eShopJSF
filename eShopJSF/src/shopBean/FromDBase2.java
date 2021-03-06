package shopBean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;


public class FromDBase2 implements Serializable {

	String userpassword = "";
	public String getUserpassword() {
		return userpassword;
	}
	
	  public void register () throws NumberFormatException, SQLException{
	        ResultSet rs;
	        String i;
	        String m= getEmail();
	        String p= getUserpassword();
	        DBVerbindung verbindung = new DBVerbindung();
	        verbindung.oeffneDB();

	        verbindung.schreibe("Insert Into user (iduser, name, password) Values ('"+m+"','"+m+"','"+p+"');");
	        
	        System.out.println("register geht! m="+m+" p="+p);
	         
	         
	    }
	     
	    public String login (String mail, String pw) throws SQLException{
	    	String url="";
	    	ResultSet rs;
	        String password;
	        DBVerbindung verbindung = new DBVerbindung();
	        verbindung.oeffneDB();
	        rs=verbindung.lesen("Select password from user Where mail='"+mail+"';");
	        password=rs.getString(0);
	        
	        System.out.println("login geht!");
	        if (pw != password){
	            //Errorhandling
	        	
	        	url= "http://localhost:8080/eShopJSF/faces/start3.xhtml";
	        }
	        return url;
        
	         
	         
	         
	    }

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
		System.out.println("pw ist gesetzt");
	}

	public String getEmail() {
		return email;
		
	}

	public void setEmail(String email) {
		this.email = email;
		System.out.println("mail ist gesetzt");
	}

	String email = "";
	
	String urlEinkaufswagen= "http://localhost:8080/eShopJSF/faces/einkaufswagen.xhtml";
	
	
	public String einkaufswagenURL(){
		
		return "ok";
	}
	
	public String getUrlEinkaufswagen() throws IOException {
		
	return "ok"; 
		
		
		
	}

	

	private static final long serialVersionUID = 1L;

	ArrayList<String> user = new ArrayList<String>();

	public ArrayList<String> getUser() {
		return user;
	}

	public void setUser(ArrayList<String> user) {
		this.user = user;
	}

	public String test() {
		String success = "success!!!!";
		System.out.println(success);
		return success;
	}
	
	public void deleteFromDB(String isbn){
		System.out.println("erfolgreich zugegriffen auf delete");
	}

	ArrayList<String> einkaufskorb = new ArrayList<String>();

	public ArrayList<String> getEinkaufskorb() {
		return einkaufskorb;
	}

	public void setEinkaufskorb(ArrayList<String> einkaufskorb) {
		this.einkaufskorb = einkaufskorb;
	}

	public void thisItoWagen(String isbn) {

		DBVerbindung verbindung = new DBVerbindung();
		verbindung.oeffneDB();
		verbindung.schreibe("insert into orders (isbn) VALUES ('" + isbn + "');");

		//verbindung.schliesseDB();

		einkaufskorb.add(isbn);

		System.out.println("test gegl�ckt!!");
	}

	public int coutWasImWagen() {
		DBVerbindung verbindung = new DBVerbindung();
		verbindung.oeffneDB();
		verbindung.lesen("select count(*) from orders");
		
		return einkaufskorb.size();
	}

	public int count() {
		int c = 0;
		c = +c;
		System.out.println("test mit " + c);
		return c;
	}

	public void setEintragImDB(ArrayList<String> eintragImDB) {
		this.eintragImDB = eintragImDB;
	}

	ArrayList<String> eintragImDB = new ArrayList<String>();
	ArrayList<String> bilderList = new ArrayList<String>();

	public void setBilderList(ArrayList<String> bilderList) {
		this.bilderList = bilderList;
	}

	public String getElementFromEintrag(String i) {

		int x = 0;
		Enum test = Enum.valueOf(i);

		switch (test) {
		case EINS:
			x = 1;

			break;
		case ZWEI:
			x = 2;

			break;
		case DREI:
			x = 3;
			break;

		case VIER:
			x = 4;
			break;

		case FUENF:
			x = 5;
			break;

		case SECHS:
			x = 6;
			break;

		case SIEBEN:
			x = 7;
			break;

		case ACHT:
			x = 8;
		default:
			break;
		}
		String elem = eintragImDB.get(x);
		return elem;

	}

	public ArrayList<String> getBilderList() {
		ResultSet rsA = null;

		String mSQL = "select concat('/pictures/', isbn, '.jpg') as url from b�cher_gelesen";

		try {
			DBVerbindung verbindung = new DBVerbindung();
			verbindung.oeffneDB();

			rsA = verbindung.lesen(mSQL);

			while (rsA.next()) {
				eintragImDB.add(rsA.getString("url"));
				System.out.println(rsA.getString("url"));
			}

			rsA.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bilderList;
	}

	public ArrayList<String> getEintragImDB() {
		ResultSet rsA = null;

		String mSQL = "select * from b�cher_gelesen";

		try {
			DBVerbindung verbindung = new DBVerbindung();
			verbindung.oeffneDB();

			rsA = verbindung.lesen(mSQL);

			while (rsA.next()) {
				eintragImDB.add(rsA.getString("titel"));

			}
			rsA.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eintragImDB;
	}

	public enum Enum {

		EINS, ZWEI, DREI, VIER, FUENF, SECHS, SIEBEN, ACHT, NEUN, ZEHN

	}
}
