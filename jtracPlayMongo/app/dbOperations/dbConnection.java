
package dbOperations;

import java.net.UnknownHostException;

import Models.Item;
import Models.jtracutil;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

public class dbConnection {
	
	public static void createDBConnection() {
		// Mongo object created
		try {
			
			MorphiaObject.mongo = new Mongo(jtracutil.HOST, 27017);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		// Creating Morphia object
		MorphiaObject.morphia = new Morphia();

		// MorphiaObject.morphia.map(Hotel.class).map(Address.class);
		MorphiaObject.datastore = MorphiaObject.morphia.createDatastore(
				MorphiaObject.mongo, jtracutil.DBNAME);
		
		System.out.println(MorphiaObject.datastore.toString());
		
	}
	
	/*public static void insertItem() throws UnknownHostException
	{
		Item item = new Item();
		item.setType("bug");
		item.setSequenceNum(100);
		
		Datastore ds = dbConnection.createDBConnection();
		ds.save(item);
	}*/
	
	/*public static void findItem() throws UnknownHostException {
		
		Datastore ds = dbConnection.databaseConnection();
		//List <Item> items = ds.get(Item.class,id);
		List <Item> items = (List<Item>) ds.find(Item.class);
		
		for (Item item : items)	{
			System.out.println(item + "\n" );
		}
		//Item item1 = ds.get(Item.class,"bug");
		//Item item1 = (Item) ds.find(Item.class);
		//System.out.println(item1 + "\n" );

	}	*/	
	public static void main( String[] args ) throws UnknownHostException{
	
		createDBConnection();
	}

}
