package Models;

import java.util.ArrayList;

import com.google.code.morphia.annotations.Entity;

import dbOperations.MorphiaObject;

@Entity("List")
public class listOperations {

	
	
	public listOperations() {
		
	}

	public ArrayList<String> list = new ArrayList<String>();

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}
	
	public void save(listOperations l){
		MorphiaObject.datastore.save(l);
	}
}
