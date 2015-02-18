package controllers;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

import Models.Item;
import Models.Priority;
import Models.formTest;
import Models.itemUpdate;
import Models.listOperations;
import dbOperations.MorphiaObject;
import dbOperations.dbConnection;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;


public class IssueController extends Controller {
  
  
  public static Result dbconn() {
	  
	    dbConnection.createDBConnection();
	    
	    //System.out.println(ds);
	    System.out.println("mijio");
	    return ok("database connected");
  }  //end of dbconn()
  
  public static Result insertItem() {
		
	    dbconn();
	    
	  	Item item = new Item();
		item.setId("i1");
		item.setType("bug");
		item.setSequenceNum(100);
		item.setPriority(Priority.Fatal);
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		String formattedDate = sdf.format(date);
		item.setDate(date);
		item.setData();
		//item.setDatalist(datalist);
		item.inputData("Sevierity", 3);
		item.inputData("Completion Percentage", 5);
        item.inputData("Priority", 4);
		MorphiaObject.datastore.save(item);
		
		return ok("item inserted");
	}//end of insertItem()
  
  public static Result updateItem() {
	  
	    dbconn();
	    //find item by id .........
	    Item item = MorphiaObject.datastore.get(Item.class,"i1");
        itemUpdate u = new itemUpdate();
        u.update(item, Priority.Low);
        item.setItemupdate(u);
		MorphiaObject.datastore.save(item);

	    return ok("item updated");
  }//end of updateItem
 
  public static Result updateItemField() {
	  
	    dbconn();
	    //find item by id .........
	  Item item = MorphiaObject.datastore.get(Item.class,"i1");
      itemUpdate u = new itemUpdate();
      u.updateField(item, "Joy Dutta",Priority.Mejor,new Date());
      u.updateField(item, "Titli Sarkar",Priority.Fatal,new Date());
      u.updateField(item, "Pramita Ghosh",Priority.Low,new Date());

      item.setItemupdate(u);
	  MorphiaObject.datastore.save(item);

	 return ok("item updated");
 }//end of updateItemField
//-------------------------------------------------------------------------------------------
  public static Result itemCreate()
  {
	  //formTest itemData = new formTest();
      //itemData.setLabels(); 
      //itemData.setIds();
	 // itemData.setId("f1");
	 // itemData.save(itemData);

	 // String labelName = itemData.labels.get(1);


	 return ok(views.html.item.render()); 
  }
  public static Result itemInsert() {
	  
	  //formTest itemData = MorphiaObject.datastore.get(formTest.class,"f1");
	  formTest itemData = new formTest();
      
	  ArrayList<String> singleList = new ArrayList<String>();
	  ArrayList<String> anotherList = new ArrayList<String>();
	  ArrayList<ArrayList<String>> listOLists = new ArrayList<ArrayList<String>>();
			  
	  DynamicForm bindedForm = form().bindFromRequest();
	  
	  String summary =bindedForm.get("summary");
	  String description = bindedForm.get("description");
	  String priority = bindedForm.get("Priority");
      
	  //itemData.setId("f1");
	  itemData.setSummary(summary);
	  itemData.setDescription(description);
	  itemData.setPriority(priority);
	  //itemData.setSingleList(singleList);
	 // itemData.setAnotherList(anotherList);
	  //itemData.setListOLists(listOLists);
	  itemData.setLabels(); 
      //itemData.setIds();
	  
      System.out.println(summary);
      System.out.println(description);
      System.out.println(priority);

	  itemData.save(itemData);
      // MorphiaObject.datastore.save(itemData);
	  return ok(views.html.main.render("",null));
  }//end of itemCreate() 
  
 /* public static String getLabelName() {
      
	  String labelName = null;
	  formTest ft = MorphiaObject.datastore.get(formTest.class,"f1");
	  Integer lenOfIdList = ft.ids.size();
	  Integer lenOfLabelList = ft.labels.size();
	  for(Integer i = 0;i<lenOfIdList && i<lenOfIdList;i++){
		  if(ft.ids.get(i) != null){
			  labelName = ft.labels.get(i);
		  }
	  }
	  labelName = ft.labels.get(1);

	  return (labelName);
  }*/
  
  public static Result listop() {
	  listOperations l = new listOperations();
	  l.list.add("Orange");
	  l.list.add("Apple");
	  l.list.add("Mango");
	  l.save(l);
	  return ok();
  }
  //----------------------------------------------------------------------------
  
  public static void main(String[] args) {
	  Item item = MorphiaObject.datastore.get(Item.class,"i1");
      
	  /*for (Priority s : item.updatedPriorities) {
          System.out.println("New priority : " + s);
         }*/
	  
	  item.displayData();
  }//end of main()
  
  
}