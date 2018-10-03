import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Home extends HttpServlet
{
	public static void main(String[] args) {
		
	}
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doGet(req, resp);
	PrintWriter pw = resp.getWriter();
	pw.println("<!DOCTYPE html>\r\n" + 
			"<html lang=\"en\">\r\n" + 
			"<head>\r\n" + 
			"  <title>Online Exam System</title>\r\n" + 
			"  <meta charset=\"utf-8\">\r\n" + 
			"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
			"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
			"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n" + 
			"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n" + 
			"\r\n" + 
			"  <style type=\"text/css\">\r\n" + 
			"  	.center {\r\n" + 
			"  		display: block;\r\n" + 
			" \r\n" + 
			"    width: 60%;\r\n" + 
			"    margin-left: auto;\r\n" + 
			"    margin-right: auto;\r\n" + 
			"    \r\n" + 
			"  	}\r\n" + 
			"  </style>\r\n" + 
			"</head>\r\n" + 
			"<body style=\"background-color: #ffd480\">\r\n" + 
			"	\r\n" + 
			"<img src= "+req.getContextPath()+"/Images/title.jpg \"  class=\"center\" >\r\n" + 
			"  \r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<div class=\"container text-center\">\r\n" + 
			"  <h1>Sparsh Analytics Pvt ltd</h1>\r\n" + 
			"  <p>Conduct Exams Smoothly and Effectively!</p> \r\n" + 
			"</div>\r\n" + 
			"\r\n" + 
			"<div class=\"container center\" >\r\n" + 
			"	<div class=\"row\">\r\n" + 
			"		 <div class=\"dropdown\">\r\n" + 
			"    <button class=\"btn btn-primary dropdown-toggle col-sm-2\" type=\"button\" data-toggle=\"dropdown\">Login\r\n" + 
			"    <span class=\"caret\"></span></button>\r\n" + 
			"    <ul class=\"dropdown-menu\">\r\n" + 
			"      <li><a href=\"Login?id=Student\">Student Login</a></li>\r\n" + 
			"      <li><a href=\"Login?id=Administrator\">Admininstrator Login</a></li>\r\n" + 
			"    </ul>\r\n" + 
			"  </div>\r\n" + 
			"<div  class=\"col-sm-1\">\r\n" + 
			" <a href=\"SignUp\" class=\"btn btn-primary\" role=\"button\">SIGNUP</a></div>\r\n" + 
			" <div class=\"col-sm-1\"></div>\r\n" + 
			" \r\n" + 
			"  <div class=\"col-sm-1\"> <a href=\"Demo.html\" class=\"btn btn-info\" role=\"button\">Info</a>\r\n" + 
			"\r\n" + 
			"	</div></div>\r\n" + 
			"</div>\r\n" + 
			" \r\n" + 
			"\r\n" + 
			"</body>\r\n" + 
			"</html>\r\n" + 
			"");
}
  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
	  doGet(req, resp);
	}
}
