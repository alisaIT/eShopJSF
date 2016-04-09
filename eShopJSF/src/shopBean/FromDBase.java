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

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

import org.bson.Document;
import org.bson.Document;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;




@ManagedBean(name = "dbBean", eager = true)
//@ManagedBean(name = "dbBean")

@SessionScoped

public class FromDBase implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int click = 0;
	double gesamtpreis=0.0;

	public double getGesamtpreis() {
		return gesamtpreis;
	}

	public void setGesamtpreis(double gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}

	public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
	}

	Document myDoc = new Document();
	ArrayList<String> einkaufWagen = new ArrayList<String>();

	public ArrayList<String> getEinkaufWagen() {
		return einkaufWagen;
	}

	public void setEinkaufWagen(ArrayList<String> einkaufWagen) {
		this.einkaufWagen = einkaufWagen;
	}

	MongoDatabase db;
	protected DB db1;
	protected MongoCollection<Document> collection;
	protected Mongo mongo;

	public ArrayList<String> listeBuecher = new ArrayList<String>();

	public MongoDatabase openDB() throws IOException {

		MongoClient mongoC = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoC.getDatabase("test3");

		return db;
	}

	public boolean connectDBCollection(String collectionName) {
		if (null == collectionName || collectionName.isEmpty()) {
			return false;
		}
		collection = db.getCollection(collectionName);
		return true;
	}

	public BasicDBObject getBasicDBObject() {
		return new BasicDBObject();
	}

	public void countClick() {
		click = click + 1;
	}

	public void calcutate() throws IOException{
		MongoDatabase db = openDB();
		countClick();

		FindIterable<Document> iterableI;
		// db.getCollection("testC4").find().

		// collection testC7 has actual data

		iterableI = getAllDocuments("testC7", db);
		MongoCursor<Document> iter = iterableI.iterator();
		int i = 0;
		int int1;
		
		double int1Double=0.0;
		
		while (iter.hasNext()) {
			i++;
			Document doc = iter.next();
			System.out.println(doc.toJson());

			System.out.println("Document" + i + ": " + doc.getDouble("price"));
			int1Double = doc.getDouble("price");
			// = Integer.toString(int1);
			while(!doc.isEmpty()){
				gesamtpreis=gesamtpreis+int1Double;
				}
			}
		System.out.println("gesamtpreis ist" +gesamtpreis);
	}
	public void test() {
		System.out.println("test bean geht!");
		
	}
	public void test2(String test) {
		System.out.println("test bean geht mit string übergabe!");
	}
	
	public void writeEinkaufToDB(String blub2) throws IOException {
		MongoDatabase db = openDB();
		countClick();

		FindIterable<Document> iterableI;
		// db.getCollection("testC4").find().

		// collection testC7 has actual data

		iterableI = getAllDocuments("testC7", db);
		MongoCursor<Document> iter = iterableI.iterator();
		int i = 0;
		int int1;
		String blub;
		String int1String;
		while (iter.hasNext()) {
			i++;
			Document doc = iter.next();
			System.out.println(doc.toJson());

			System.out.println("Document" + i + ": " + doc.getString("isbn"));
			int1String = doc.getString("isbn");
			// = Integer.toString(int1);
			System.out.println(" " + int1String);

			if (blub2.equals(int1String)) {
				blub = doc.getString("name");
				System.out.println("das ist blub " + blub);
				
				double preis=doc.getDouble("price");
				gesamtpreis=gesamtpreis+preis;
				einkaufWagen.add(blub+"        "+preis+" €");
			}
			System.out.println("ges "+gesamtpreis);

		}

		/*
		 * db.getCollection("testC5").insertOne( new Document("Einkauf", new
		 * Document() .append("user", userMail) .append("userPW", userPw)));
		 */
		System.out.println("wurde ausgeführt einfügen user");

	}

	public void createUserAndPword() throws IOException, ParseException {
		MongoDatabase db = openDB();

		String userMail = "mail";
		String userPw = "pw";

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);

		db.getCollection("testC3")
				.insertOne(new Document("user", new Document().append("user", userMail).append("userPW", userPw)));
		System.out.println("wurde ausgeführt einfügen user");

	}

	public String readFirstElemFromCol(String collectionName) {
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.get(1);
		String elem = "";
		db.getCollection(collectionName).find(whereQuery);
		System.out.println(elem);
		return elem;
	}

	public void getSingleField() {

		BasicDBObject allQuery = new BasicDBObject();
		BasicDBObject fields = new BasicDBObject();
		fields.put("name", 1);
		// eq("0", "test")

		myDoc = collection.find(fields).first();
		System.out.println(myDoc.toJson());

	}

	public ArrayList<String> listeBuecher() throws IOException {
		// openDB();

		FindIterable<Document> iterable;
		// iterable= MongoDBVerbindung.getDocuments("testC2", "name",
		// "mkyong-5", db);
		// MongoClient mongoC = new MongoClient( "localhost" , 27017 );
		// MongoDatabase db = mongoC.getDatabase("test3");
		MongoClient mongoC = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoC.getDatabase("test3");

		iterable = getAllDocuments("testC2", db);
		MongoCursor<Document> iter = iterable.iterator();
		int i = 0;
		int int1;
		String int1String;
		while (iter.hasNext()) {
			i++;
			Document doc = iter.next();
			System.out.println("Document" + i + ": " + doc.getString("name"));
			int1String = doc.getString("name");
			// int1String = Integer.toString(int1);
			System.out.println(" " + int1String);
			listeBuecher.add(int1String);
		}

		return listeBuecher;
	}

	public void enotheTestQuerying(String collName) {
		FindIterable<Document> iterable = db.getCollection(collName).find();

		iterable.forEach(new Block<Document>() {
			@Override
			public void apply(final Document document) {
				System.out.println(document.toString());
			}
		});

	}

	public static FindIterable<Document> getAllDocuments(String collection, MongoDatabase db) {

		FindIterable<Document> iterable = null;

		iterable = getDocuments(collection, null, null, db);

		return iterable;
	}

	public static FindIterable<Document> getDocuments(String collection, String field, int value, MongoDatabase db) {

		return getDocuments(collection, field, String.valueOf(value), db);
	}

	public static FindIterable<Document> getDocuments(String collection, String field, String value, MongoDatabase db) {

		FindIterable<Document> iterable = null;

		try {
			// System.out.println("try to get documents...");
			if (field == null && value == null) {
				System.out.println("Search for all documents in collection '" + collection + "'");

				iterable = db.getCollection(collection).find();
			} else {
				System.out.println("Search for document with <" + value + "> in field <" + field + ">");
				iterable = db.getCollection(collection).find(eq(field, value));
			}

		} catch (Exception e) {
			System.out.println("FAIL: Something went wrong trying to get documents.");
			System.out.println(e.toString());
		}

		// ErrorClass.checkNull(iterable, "Found documents", "No documents
		// found");

		return iterable;
	}

	// SHOW [toString()]
	public static void showDocuments(FindIterable<Document> docs) {

		docs.forEach(new Block<Document>() {
			public void apply(final Document document) {
				System.out.println(document);
			}
		});
	}

	public void closeDB() {
		mongo.close();
	}

	String userpassword = "";
	public String getUserpassword() {
		return userpassword;
	}
	
	
}
