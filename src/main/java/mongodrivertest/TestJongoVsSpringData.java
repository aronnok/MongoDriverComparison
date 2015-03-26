package mongodrivertest;


import java.util.ArrayList;
import java.util.List;

import mongodrivertest.entiry.Category;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoException;


 
/**
 * Java + MongoDB comparison test 
 * Creator: Imtiaz Mirza @author imtiaz  @ imz.mrz@gmail.com
 * Date: April 1, 2015
 */
public class TestJongoVsSpringData {
	
  private static String JONGO      = "Jongo";	
  private static String SPRINGDATA = "SpringData";
  private static String ADD        = "Add";	
  private static String FIND       = "Find";
  private static String BATCHADD   = "BatchAdd";
  
  
  public static void main(String[] args) throws Exception {
 
    try {
    	
    	
    	/*  ########################################## */
    	/*  Change you test driver and test type here */
       	
    	 String run      = JONGO;
         String testType = ADD;
        
         /*  ########################################## */
     	 
         
        if (run.equals(JONGO ) && testType.equals(ADD) ){
	    	
	    	long startTime = System.currentTimeMillis();
	    	Category c = new Category();
	    	
	    	for( int i=0; i< 10000; i++){
	    		
	    		c.setName(i+"");
	    		JongoDBUtils.getCollection().save(c);
	    		if((i%500)==0) System.out.print("i="+i+" ");
	    	}
	    	
	    	long stopTime = System.currentTimeMillis();
	    	
	    	System.out.println("Total time took:"+(stopTime-startTime));
        }
        
        
        //##################################################//
        
        
        if (run.equals(SPRINGDATA ) && testType.equals(ADD) ){
	    	
	    	long startTime = System.currentTimeMillis();
	    	Category c = new Category();
	    	
	    	for( int i=0; i< 10000; i++){
	    		
	    		c = new Category();
	    		c.setName(i+"");
	    		SpringDataDBUtils.getMongoOperations().insert(c);
	    		if((i%500)==0) System.out.print("i="+i+" ");
	    	}
	    	
	    	long stopTime = System.currentTimeMillis();
	    	
	    	System.out.println("Total time took:"+(stopTime-startTime));
        }
    	
        //##################################################//
        
        if (run.equals(JONGO ) && testType.equals(FIND) ){
	    	
        	long startTime = System.currentTimeMillis();
	    	

			Category c =(Category) JongoDBUtils.getCollection().findOne( "{name:'0'}").as(Category.class);
			
	    	long stopTime = System.currentTimeMillis();
	    	if( c.getName().equals("0") )
	    	{
	    		System.out.println("Found it! First one,id="+c.getName());
	    	}
	    		
	    	System.out.println("Total time took:"+(stopTime-startTime));
	    	
	    	
	    	startTime = System.currentTimeMillis();
	    
	    	c =(Category) JongoDBUtils.getCollection().findOne( "{name:'5000'}").as(Category.class);
			
	        stopTime = System.currentTimeMillis();
	    	if( c.getName().equals("5000") )
	    	{
	    		System.out.println("Found it!5000,id="+c.getName());
	    	}
	    		
	    	System.out.println("Total time took:"+(stopTime-startTime));
        	
        	
	    	startTime = System.currentTimeMillis();
	        c =(Category) JongoDBUtils.getCollection().findOne( "{name:'9999'}").as(Category.class);
	    	
	       stopTime = System.currentTimeMillis();
	    	if( c.getName().equals("9999") )
	    	{
	    		System.out.println("Found it!,id="+c.getName());
	    	}
	    		
	    	System.out.println("Total time took:"+(stopTime-startTime));
        }
        
        
       //##################################################//
   	
       
       if (run.equals(SPRINGDATA ) && testType.equals(FIND) ){
	    	
       	long startTime = System.currentTimeMillis();
	    	Query query = new Query();
			query.addCriteria(Criteria.where("name").is("0"));

			Category c = SpringDataDBUtils.getMongoOperations().findOne(query,
					Category.class);
			
	    	long stopTime = System.currentTimeMillis();
	    	if( c.getName().equals("0") )
	    	{
	    		System.out.println("Found it! First one,id="+c.get_id());
	    	}
	    		
	    	System.out.println("Total time took:"+(stopTime-startTime));
	    	
	    	
	    	startTime = System.currentTimeMillis();
	    	query = new Query();
			query.addCriteria(Criteria.where("name").is("5000"));

			 c = SpringDataDBUtils.getMongoOperations().findOne(query,
					Category.class);
			
	        stopTime = System.currentTimeMillis();
	    	if( c.getName().equals("5000") )
	    	{
	    		System.out.println("Found it!5000,id="+c.get_id());
	    	}
	    		
	    	System.out.println("Total time took:"+(stopTime-startTime));
       	
       	
	    	startTime = System.currentTimeMillis();
	    	query = new Query();
			query.addCriteria(Criteria.where("name").is("9999"));

		     c = SpringDataDBUtils.getMongoOperations().findOne(query,
					Category.class);
			
	       stopTime = System.currentTimeMillis();
	    	if( c.getName().equals("9999") )
	    	{
	    		System.out.println("Found it!,id="+c.get_id());
	    	}
	    		
	    	System.out.println("Total time took:"+(stopTime-startTime));
       }
       
    // #########################################################
       
       if (run.equals(JONGO ) && testType.equals(BATCHADD ) ){
	    	
	    	long startTime = System.currentTimeMillis();
	    	Category c = new Category();
	    	List<Category> catList = new ArrayList<Category>();
	    	
	    	for( int i=0; i< 10000; i++){
	    		c = new Category();
	    		c.setName(i+"");
	    		catList.add(c);
	    		if((i%500)==0) System.out.print("i="+i+" ");
	    	}
	    	
	    	JongoDBUtils.getCollection().insert(catList.toArray());
	    	
	    	long stopTime = System.currentTimeMillis();
	    	
	    	System.out.println("Total time took:"+(stopTime-startTime));
        }
       // #########################################################
       
       if (run.equals(SPRINGDATA ) && testType.equals(BATCHADD ) ){
	    	
	    	long startTime = System.currentTimeMillis();
	    	Category c = new Category();
	    	List<Category> catList = new ArrayList<Category>();
	    	
	    	for( int i=0; i< 10000; i++){
	    		c = new Category();
	    		c.setName(i+"");
	    		catList.add(c);
	    		if((i%500)==0) System.out.print("i="+i+" ");
	    	}
	    	
	    	SpringDataDBUtils.getMongoOperations().insert(catList,Category.class);
	    	
	    	long stopTime = System.currentTimeMillis();
	    	
	    	System.out.println("Total time took:"+(stopTime-startTime));
        }
       
    	
    } catch (MongoException e) {
    	e.printStackTrace();
    }
 
  }
}