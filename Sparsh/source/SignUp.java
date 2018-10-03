import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUp extends HttpServlet
{
	
	public static void main(String[] args) {
		
	}
  @Override
	protected void doGet(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		PrintWriter pw = resp.getWriter();
		pw.println("<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"<head>\r\n" + 
				"  <title>SignUp</title>\r\n" + 
				"  <meta charset=\"utf-8\">\r\n" + 
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
				"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n" + 
				"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n" + 
				"</head>\r\n" + 
				"<body style=\"background-color:tomato;\">\r\n" + 
				"\r\n" + 
				"<div class=\"container\">\r\n" + 
				"  <h2>SIGNUP Form</h2>\r\n" + 
				"  <form class=\"form-horizontal\" action=\"SignUp\" method=\"post\">\r\n" + 
				"\r\n" + 
				"  	<div class=\"form-group\">\r\n" + 
				"      <label class=\"control-label col-sm-2\" for=\"email\">Username:</label>\r\n" + 
				"      <div class=\"col-sm-10\">\r\n" + 
				"        <input type=\"text\" class=\"form-control\" required placeholder=\"Enter Username\" name=\"user\">\r\n" + 
				"      </div>\r\n" + 
				"    </div>\r\n" + 
				"    <div class=\"form-group\">\r\n" + 
				"      <label class=\"control-label col-sm-2\" for=\"email\">Email:</label>\r\n" + 
				"      <div class=\"col-sm-10\">\r\n" + 
				"        <input type=\"email\" class=\"form-control\" required placeholder=\"Enter email\" name=\"email\">\r\n" + 
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
				"</html>\r\n" + 
				"");
		pw.close();
	}
  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		Connection con = DBInfo.DBconnect();
		
		String query = "insert into udetails (username,password,email) values(?,?,?)";
		
		String user = req.getParameter("user");
		String pass = req.getParameter("pwd");
		String email = req.getParameter("email");
		
		try {
		     PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.setString(3, email);
			
			ps.executeUpdate();
			ps.close();con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		resp.sendRedirect("Home");
		
		
	}
}
