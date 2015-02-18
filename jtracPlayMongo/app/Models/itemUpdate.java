/**
 * 
 */
package Models;

import java.util.Date;

import com.google.code.morphia.annotations.Entity;

import dbOperations.MorphiaObject;

/**
 * @author titli
 *
 */
@Entity("Item")
public class itemUpdate {

	public void update(Item item,Priority p) {
		item.setPriority(p);
		MorphiaObject.datastore.save(item);
	}
	
	public void updateField(Item item,String s,Priority p,Date date) {
		//if(item != null){
		if(item == null){
			System.out.println("ITEM IS :"+item);
		}
			item.updatedPriorities.add(p);
			item.updatedDates.add(date);
		    item.AssignTo.add(s);
		//}
		MorphiaObject.datastore.save(item);
	}
	
	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
