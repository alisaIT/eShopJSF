package shopBean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		FromDBase t = new FromDBase();
		
		
		
		ArrayList<String> test= t.getBilderList();
		
		Iterator<String>  iter = test.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
	}
	

}
