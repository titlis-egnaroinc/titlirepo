
package Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import play.data.validation.Constraints.Required;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;

/**
 * @author titli
 *
 */
@Entity("Item")
public class Item {

	
	public Item() {
		
	}
    
	@Id
	@Property("id")
	//public ObjectId id;
	public String id;
	@Required
	private Integer sequenceNum;
	private String type;
	
	private Priority priority;
	private Date date;
	
	@Embedded
    itemUpdate itemupdate ;
	
	public ArrayList<Priority> updatedPriorities = new ArrayList<Priority>();
	public ArrayList<Date> updatedDates = new ArrayList<Date>();
	public ArrayList<String> AssignTo = new ArrayList<String>();
	
	Map<String, String> data = new HashMap<String, String>();
	Map<String, ArrayList<Integer>> datalist = new HashMap<String, ArrayList<Integer>>();

	public String label;
	public ArrayList<String> fieldValues = new ArrayList<String>();
	//getters and setters 
    public String getId() {
		return id;
	}
    public void setId(String id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getSequenceNum() {
		return sequenceNum;
	}
	public void setSequenceNum(int sequenceNum) {
		this.sequenceNum = sequenceNum;
	}

	public Priority getPriority() {
		return priority;
	}
    public void setPriority(Priority priority) {
		this.priority = priority;
	}
    
    public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
    public itemUpdate getItemupdate() {
		return itemupdate;
	}
	public void setItemupdate(itemUpdate itemupdate) {
		this.itemupdate = itemupdate;
	}
	
	public List<Priority> getUpdatedPriorities() {
		return updatedPriorities;
	}
	public void setUpdatedPriorities(List<Priority> updatArrayListedPriorities) {
		this.updatedPriorities = (ArrayList<Priority>) updatedPriorities;
	}
	public List<Date> getUpdatedDates() {
		return updatedDates;
	}
	public void setUpdatedDates(List<Date> updatedDates) {
		this.updatedDates = (ArrayList<Date>) updatedDates;
	}
	
	public ArrayList<String> getAssignTo() {
		return AssignTo;
	}
	public void setAssignTo(ArrayList<String> assignTo) {
		AssignTo = assignTo;
	}
    
	public Map<String, String> getData() {
		return data;
	}
	public void setData() {
		
		data.put("John", "Taxi Driver");
	    data.put("Mark", "Professional Killer");
		//this.data = data;ArrayList
	}
	
	public Map<String, ArrayList<Integer>> getDatalist() {
		return datalist;
	}
	public void setDatalist(Map<String, ArrayList<Integer>> datalist) {
		this.datalist = datalist;
	}
	
	public void inputData(String name ,int number) {
	    Random rndData = new Random();
	    ArrayList<Integer> fruit = new ArrayList<Integer>();
	    for(int i=0 ; i<number ; i++){
	        fruit.add(rndData.nextInt(10));
	    }
	    datalist.put(name, fruit);
	}//end of inputData()
	public void displayData(){
	    for (Entry<String, ArrayList<Integer>> entry : datalist.entrySet()) {
	        System.out.print(entry.getKey()+" | ");
	        for(int fruitNo : entry.getValue()){
	            System.out.print(fruitNo+" ");
	        }
	        System.out.println();
	  }
	} //end of displayData()
	//---------------------------------------------------------------
	/* static void main(String[] args) {
		
	}*/

}
