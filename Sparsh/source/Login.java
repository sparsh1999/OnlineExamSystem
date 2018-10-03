import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet
{
	public static void main(String[] args) {
		
	}
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doGet(req, resp);
    PrintWriter pw = resp.getWriter();
    String id = req.getParameter("id");
    
    pw.println("<!DOCTYPE html>\r\n" + 
    		"<html lang=\"en\">\r\n" + 
    		"<head>\r\n" + 
    		"  <title>Login</title>\r\n" + 
    		"  <meta charset=\"utf-8\">\r\n" + 
    		"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
    		"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
    		"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n" + 
    		"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n" + 
    		"</head>\r\n" + 
    		"<body style=\"background-color:tomato;\">\r\n" + 
    		"\r\n" + 
    		"<div class=\"container\">\r\n" + 
    		"  <h2>Login</h2>\r\n" + 
    		"  <form class=\"form-horizontal\" action=\"Login\" method=\"post\">\r\n" + 
    		"\r\n" + 
    		"  	<div class=\"form-group\">\r\n" + 
    		"      <label class=\"control-label col-sm-2\" for=\"text\">Username:</label>\r\n" + 
    		"      <div class=\"col-sm-10\">\r\n" + 
    		"        <input type=\"text\" class=\"form-control\" required placeholder=\"Enter username\" name=\"user\">\r\n" + 
    		"      </div>\r\n" + 
    		"    </div>\r\n" + 
    		"    <div class=\"form-group\">\r\n" + 
    		"      <label class=\"control-label col-sm-2\" for=\"text\">UserId</label>\r\n" + 
    		"      <div class=\"col-sm-10\">\r\n" + 
    		"        <input type=\"text\" class=\"form-control\" required placeholder=\"Enter UserId\" name=\"uid\">\r\n" + 
    		"      </div>\r\n" + 
    		"    </div>\r\n" + 
    		"    <div class=\"form-group\">\r\n" + 
    		"      <label class=\"control-label col-sm-2\" for=\"pwd\">Password:</label>\r\n" + 
    		"      <div class=\"col-sm-10\">          \r\n" + 
    		"        <input type=\"password\" class=\"form-control\" required placeholder=\"Enter password\" name=\"pwd\">\r\n" + 
    		"      </div>\r\n" + 
    		"    </div>\r\n" + 
    		"    <div class=\"form-group\">        \r\n" + 
    		"      <div class=\"col-sm-offset-2 col-sm-10\">\r\n" + 
    		"        <div class=\"checkbox\">\r\n" + 
    		"          <label><input type=\"checkbox\" name=\"remember\"> Remember me</label>\r\n" + 
    		"        </div>\r\n" + 
    		"      </div>\r\n" + 
    		"    </div>\r\n" + 
    		"    <div class=\"form-group\">        \r\n" + 
    		"      <div class=\"col-sm-offset-2 col-sm-10\">\r\n" + 
    		"        <button type=\"submit\" class=\"btn btn-default\">Submit</button>\r\n" + 
    		"        <a href=\"Home\" class=\"btn btn-default\" role=\"button\">Back to Home</a>\r\n" + 
    		"      </div>\r\n" + 
    		"    </div>\r\n" + 
    		"  </form>\r\n" + 
    		"</div>\r\n" + 
    		"\r\n" + 
    		"</body>\r\n" + 
    		"</body>\r\n" + 
    		"</html>\r\n" + 
    		"");
}
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doPost(req, resp);
	  RequestDispatcher rd = null;
	  Connection con = DBInfo.DBconnect();
		String uid = req.getParameter("uid");
		String pass = req.getParameter("pwd");
		int uid1 = Integer.parseInt(uid);
		String query = "select password from udetails where uid="+uid1;
		
		try {
		     PreparedStatement ps = con.prepareStatement(query);
			 
			ResultSet rs = ps.executeQuery();
			rs.next();
			//System.out.println(rs.getString(1));
			if (uid1==1&&pass.equals(rs.getString(1)))
			{
				rd = req.getRequestDispatcher("AdminDashboard");
			}
			else if(rs.getString(1).equals(pass))
			{rd = req.getRequestDispatcher("DashBoard");
			}
			ps.close();con.close();
			rd.forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	  	  
}
  
}
