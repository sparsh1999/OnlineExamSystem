import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Exam extends HttpServlet
{
	public static void main(String[] args) {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		HttpSession session = req.getSession();
		String user = (String) session.getAttribute("user");
		String uid = (String) session.getAttribute("uid");
	    PrintWriter pw = resp.getWriter();
	    pw.print("<!DOCTYPE html>\r\n" + 
	    		"<html>\r\n" + 
	    		"<head>\r\n" + 
	    		"	<title>Exam</title>\r\n" + 
	    		"	<meta charset=\"utf-8\">\r\n" + 
	    		"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
	    		"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
	    		"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n" + 
	    		"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n" + 
	    		"</head>\r\n" + 
	    		"<body style=\"background-color:#79ff4d\">\r\n" + 
	    		"\r\n" + 
	    		"<h4 color=\"orange\" style=\"background-color:orange;\" ><marquee >Welcome "+user+" ID "+uid+"</marquee></h4></div>\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"<img src= "+req.getContextPath()+"/Images/exam1.png \" style=\"width: 100%;height: auto;display: block; image-rendering: auto;\" >\r\n" + 
	    		"<br />\r\n" + 
	    		"<div class=\"container\" >\r\n" + 
	    		"	<div class=\"col-sm-1\"><a href=\"#\" class=\"btn btn-primary\" role=\"button\" >Home</a></div>\r\n" + 
	    		"	<div class=\"col-sm-1\"><a href=\"Instructions\" class=\"btn btn-success\" role=\"button\" >C</a></div>\r\n" + 
	    		"	<div class=\"col-sm-1\"><a href=\"#\" class=\"btn btn-success\" role=\"button\" >C++</a></div>\r\n" + 
	    		"	<div class=\"col-sm-1\"><a href=\"#\" class=\"btn btn-success\" role=\"button\" >Java</a></div>\r\n" + 
	    		"	<div class=\"col-sm-6\"></div>\r\n" + 
	    		"	<div class=\"col-sm-1\"><a href=\"Logout\" class=\"btn btn-warning\" role=\"button\" >Logout</a></div>\r\n" + 
	    		"</div>\r\n" + 
	    		"</body>\r\n" + 
	    		"</html>");
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
	}

}
