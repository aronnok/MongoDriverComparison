package mongodrivertest.entiry;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Java + MongoDB comparison test 
 * Creator: Imtiaz Mirza @author imtiaz  @ imz.mrz@gmail.com
 * Date: April 1, 2015
 */

@Document(collection = "category")
public class Category {

	@Id
	private String _id;
	private String name;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category(){
    	
    }
}
