package myStructs;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.myStructs.config.DBConfig;

public class Users {
      private int id;
      private String name;
      private String phone;
      private String email;
      private String password;
      
      public String validateAndSave() {
		if(this.confirmPassword.equals(this.password)) 
		{
			DBConfig.executeUpdate("insert into User(id,name,email,password,phone) values("+id+",'"+name+"','"+email+"','"+password+"','"+phone+"')");
			return("success");
		}
		else {
			return("failure");
		}
    	  
      }
      
      
      public String authUser() {
    	  String sql="select * from User where email='"+this.email+"' and password='"+this.password+"'";
    	  ResultSet rs=DBConfig.executeQuery(sql);
    	  try {
    		  rs.first();
    	  if(rs.getRow()==1) {
				System.out.println(rs.getString("name"));
				this.name=rs.getString("name");
				this.id=rs.getInt("id");
    		  return "success";
    	  }
    	  else {
    		  System.out.println("Selected row="+rs.getRow());
    		  return "failure";
    	  }
    	  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println();
				return "failure";
			}
      }
      
      public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	private String confirmPassword;
}

