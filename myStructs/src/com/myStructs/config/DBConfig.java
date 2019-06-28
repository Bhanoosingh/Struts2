package com.myStructs.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DBConfig 
{
	/*after adding jdbc driver(googl) we can change these values
	4projects to change the database for project*/
      private static final  String DBURL="jdbc:h2:tcp://localhost/~/struts";
      private static final  String DBDRIVER="org.h2.Driver";
      private static final  String DBUSERNAME="sa";
      private static final  String DBPASSWORD="";
    //no changes has to be made from here
    private static Statement stmt=null;
    
    private static void openConnection()
    {
    	try 
    	{
    		Class.forName(DBDRIVER);
    		Connection conn=DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);
    	     stmt=conn.createStatement();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    //to use ddl and dml command
    public static int executeUpdate(String sql)
    
    {
 	   try {
 		   openConnection();//to open Database Connection and initilize stmt
 		   return stmt.executeUpdate(sql);//for all translational(ddl(success returns 0),dml(1)failur-1) query								
 		   }
 	   catch(Exception e)
 	   {
 		   e.printStackTrace();
 		   return -1;
 	   }
 	  
    }
    
    //Function used for select statement
    public static ResultSet executeQuery(String sql)
    {
 	   try {
 		   openConnection(); 
 		   return stmt.executeQuery(sql);//this will return collection of data
 		   }
 	   catch(Exception e)
 	   {
 		   e.printStackTrace();
 		   return null;
 	   }
    }
 }
/*public static 1List<User> executeQuery(String sql)
                 2List
    {      
 	   try {
 		   openConnection(); 
 		   1List<User>
 		   ResultSet rs=stmt.executeQuery(String sql)
 		   2list dataSet=new ArrayList();
 		     while(rs.next()){
 		       return(dataSet.e);
 		     }
 		   return (List)stmt.executeQuery(sql);//this will return collection of data
 		   }
 	   catch(Exception e)
 	   {
 		   e.printStackTrace();
 		   return null;
 	   }
    }
*/

