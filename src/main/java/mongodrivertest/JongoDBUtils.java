package mongodrivertest;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
/**
 * Java + MongoDB comparison test 
 * Creator: Imtiaz Mirza @author imtiaz  @ imz.mrz@gmail.com
 * Date: April 1, 2015
 */

public class JongoDBUtils  {
	    
	    protected static String connectionURL = "mongodb://u:p@localhost:27017";
	    public static final String collectionName = "testjongo";
	    public static final String databaseName = "testdb";
	    protected static MongoCollection collection;
	    protected static DB db;

	    public JongoDBUtils() {
	    	  
	    	MongoClientURI uri = new MongoClientURI(connectionURL ); 
	        MongoClient client = new MongoClient(uri);
	    	
	        db = client.getDB(databaseName);
	        Jongo jongo = new Jongo(db);
	        
	        collection = jongo.getCollection(collectionName);
	   }
	    
	    public static MongoCollection getCollection(){
	    	
	    	if (collection==null){
	  

		    	MongoClientURI uri = new MongoClientURI(connectionURL ); 
		        MongoClient client = new MongoClient(uri);
		    	
		        db = client.getDB(databaseName);
		        Jongo jongo = new Jongo(db);
		        
		        collection = jongo.getCollection(collectionName);
		        
		       return collection;
	    	}
	    	else{ 
	    		
	    		return collection;
	    	}
	    }
	  
	}
	

