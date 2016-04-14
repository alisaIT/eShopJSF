package shopBean;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MainTestMongo {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		MongoClient mongoC = new MongoClient( "localhost" , 27017 );
		MongoDatabase db = mongoC.getDatabase("test3");
		
		MongoDBVerbindung m= new  MongoDBVerbindung();
		//m.openDB();
		//m.connectDBCollection("testC2");
		//m.readFirstElemFromCol("testC2");
		//m.getSingleField();
		
		//m.enotheTestQuerying("testC2");
		
		FindIterable<Document> iterable;
		//iterable= MongoDBVerbindung.getDocuments("testC2", "name", "mkyong-5", db);
		
	 iterable = MongoDBVerbindung.getAllDocuments("testC2", db);
		MongoCursor<Document> iter = iterable.iterator();
		int i = 0;
		while (iter.hasNext()){
			i++;
			Document doc = iter.next();
			System.out.println("Document"+i+": "+doc.getString("name"));
		}
		ArrayList<String> ar= new ArrayList<String>();
		ArrayList<String> ar2= new ArrayList<String>();
		
		ar =m.listeBuecher();
		for (String s : ar) {
			System.out.println(s);
		}
		
		System.out.println();
		
		m.createUserAndPword();
		
		String blub= "9780689869129";
		m.writeEinkaufToDB(blub);
		m.writeEinkaufToDB(blub);
		
		ar2 =m.einkaufWagen;
		for (String s : ar2) {
			System.out.println(s);
		}

		
	}

}
