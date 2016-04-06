package shopBean;

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
import javax.faces.event.ComponentSystemEvent;

@ManagedBean(name = "dbBean", eager = true)
@SessionScoped
public class FromDBase implements Serializable {

	private static final long serialVersionUID = 1L;

	ArrayList<String> user = new ArrayList<String>();

	public ArrayList<String> getUser() {
		return user;
	}

	public void setUser(ArrayList<String> user) {
		this.user = user;
	}

	public void setEintragImDB(ArrayList<String> eintragImDB) {
		this.eintragImDB = eintragImDB;
	}

	ArrayList<String> eintragImDB = new ArrayList<String>();
	ArrayList<String> bilderList = new ArrayList<String>();
	

	

	public void setBilderList(ArrayList<String> bilderList) {
		this.bilderList = bilderList;
	}
	
	public String  getElementFromEintrag(String i) {
		
		int x = 0;
		Enum test = Enum.valueOf(i);
		
		switch (test) {
		case EINS: x = 1;
			
			break;
		case ZWEI: x = 2;

		break;
		case DREI: x = 3;
		break;
		
		case VIER: x = 4;
		break;
		
		case FUENF: x = 5;
		break;
		
		case SECHS: x = 6;
		break;
		
		case SIEBEN: x = 7;
		break;
		
		case ACHT: x = 8;
		default:
			break;
		}
		String elem = eintragImDB.get(x);
		return elem;
		
	}
	
	public ArrayList<String> getBilderList() {
		ResultSet rsA = null;

		String mSQL = "select concat('/pictures/', isbn, '.jpg') as url from bücher_gelesen";

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

		String mSQL = "select * from bücher_gelesen";

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
		

	    EINS,
	    ZWEI,
	    DREI,
	    VIER,
	    FUENF,
	    SECHS,
	    SIEBEN,
	    ACHT,
	    NEUN,
	    ZEHN
	  
}
}

