package mongodrivertest;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * Java + MongoDB comparison test 
 * Creator: Imtiaz Mirza @author imtiaz  @ imz.mrz@gmail.com
 * Date: April 1, 2015
 */

@Configuration
public class SpringDataDBUtils  {

    private static MongoOperations mongoOperation;
    protected static String connectionURL = "mongodb://u:p@localhost:27017";
    
	public static MongoOperations getMongoOperations() throws Exception {
		
		if( mongoOperation==null){
		
			MongoClientURI uri = new MongoClientURI(connectionURL); 
		    MongoClient client = new MongoClient(uri);
		    mongoOperation = new MongoTemplate(client, "testspringdata");
       
		}
		 return mongoOperation;
	}
}