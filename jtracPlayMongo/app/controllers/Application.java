package controllers;

import dbOperations.dbConnection;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
  
  public static Result index() {
    
    
    dbConnection.createDBConnection();
    
    //System.out.println(ds);
    System.out.println("mijio");
    return ok("");
  
  }
  
}