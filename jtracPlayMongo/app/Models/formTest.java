package Models;

import java.util.ArrayList;
import java.util.List;

import com.google.code.morphia.annotations.Entity;

import dbOperations.MorphiaObject;

@Entity
public class formTest {

	public String id ;
	public String summary;
	public String description;
	public String Priority;
    //public ArrayList<Integer> ids = new ArrayList();
    public ArrayList<String> labels = new ArrayList<String>();
	
    /*public ArrayList<ArrayList<String>> listOLists = new ArrayList<ArrayList<String>>();
    

	public ArrayList<String> singleList = new ArrayList<String>();
    public ArrayList<String> anotherList = new ArrayList<String>();
   */
    //constructor =============================>
    public formTest() {
		
		this.summary = " ";
		this.description = " ";
		this.Priority = " ";
		this.id = "f1" ; 
	}

    //getters ans setters   ========================================>
   
    /*public ArrayList<ArrayList<String>> getListOLists() {
		return listOLists;
	}

	public void setListOLists(ArrayList<ArrayList<String>> listOLists) {
		listOLists.add(singleList);
		listOLists.add(anotherList);
		this.listOLists = listOLists;
	}
    public ArrayList<String> getSingleList() {
		return singleList;
	}
    public void setSingleList(ArrayList<String> singleList) {
		
		singleList.add("hello");
	    singleList.add("world");
	    listOLists.add(singleList);
		this.singleList = singleList;
	}
    
    public ArrayList<String> getAnotherList() {
		return anotherList;
	}
    public void setAnotherList(ArrayList<String> anotherList) {
		
		anotherList.add("this is another list");
		listOLists.add(anotherList);
		this.anotherList = anotherList;
	}
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}*/
        public ArrayList<String> getLabels() {
			return labels;
		}
		public void setLabels() {
			
			this.labels.add("Priority");
			this.labels.add("Sevierity");
			this.labels.add("completion percentage");
			//this.labels = labels;
		}
		
		/*public ArrayList<Integer> getIds() {
			return ids;
		}
		public void setIds() {
			
			ids.add(1);
			ids.add(1);
			ids.add(0);
			this.ids = ids;
		}
		*/
		public String getPriority() {
			return Priority;
		}
		public void setPriority(String priority) {
			Priority = priority;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getSummary() {
			return summary;
		}
		public void setSummary(String summary) {
			this.summary = summary;
		}
	//========================================================>	
		public void save(formTest obj) {
			
			MorphiaObject.datastore.save(obj);
		}
		
		//ArrayList<String> lbls =getLabels();
}
