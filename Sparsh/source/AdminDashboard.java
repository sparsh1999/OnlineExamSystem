import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminDashboard extends HttpServlet
{
	public static void main(String[] args) {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		HttpSession session = req.getSession();
		session.setAttribute("uid", 1);
		session.setAttribute("user", "Admin");
		//System.out.println(req.getContextPath()+"\\Images\\admin.png");
		PrintWriter pw = resp.getWriter();
		pw.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"	<title>Admin DashBoard</title>\r\n" + 
				"	<meta charset=\"utf-8\">\r\n" + 
				"\r\n" + 
				"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
				"\r\n" + 
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				" \r\n" + 
				"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n" + 
				"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n" + 
				"<style>\r\n" + 
				".navbar {\r\n" + 
				"    overflow: hidden;\r\n" + 
				"    background-color: #333;\r\n" + 
				"    font-family: Arial, Helvetica, sans-serif;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".navbar a {\r\n" + 
				"    float: left;\r\n" + 
				"    font-size: 16px;\r\n" + 
				"    color: white;\r\n" + 
				"    text-align: center;\r\n" + 
				"    padding: 14px 16px;\r\n" + 
				"    text-decoration: none;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".dropdown {\r\n" + 
				"    float: left;\r\n" + 
				"    overflow: hidden;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".dropdown .dropbtn {\r\n" + 
				"    font-size: 16px;    \r\n" + 
				"    border: none;\r\n" + 
				"    outline: none;\r\n" + 
				"    color: white;\r\n" + 
				"    padding: 14px 16px;\r\n" + 
				"    background-color: inherit;\r\n" + 
				"    font-family: inherit;\r\n" + 
				"    margin: 0;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".navbar a:hover, .dropdown:hover .dropbtn {\r\n" + 
				"    background-color: red;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".dropdown-content {\r\n" + 
				"    display: none;\r\n" + 
				"    position: absolute;\r\n" + 
				"    background-color: #f9f9f9;\r\n" + 
				"    min-width: 160px;\r\n" + 
				"    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\r\n" + 
				"    z-index: 1;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".dropdown-content a {\r\n" + 
				"    float: none;\r\n" + 
				"    color: black;\r\n" + 
				"    padding: 12px 16px;\r\n" + 
				"    text-decoration: none;\r\n" + 
				"    display: block;\r\n" + 
				"    text-align: left;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".dropdown-content a:hover {\r\n" + 
				"    background-color: #ddd;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".dropdown:hover .dropdown-content {\r\n" + 
				"    display: block;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"</head>\r\n" + 
				"<body style=\"background-color:#79ff4d\">\r\n" + 
"<img src= "+req.getContextPath()+"/Images/admin.png \" style=\"max-height:300px;width: 100%;display: block; image-rendering: auto;\" >"+ 
				"\r\n" + 
				"<div class=\"navbar\">\r\n" + 
				"  <a href=\"#\">Home</a>\r\n" + 
				"  \r\n" + 
				"  <div class=\"dropdown\">\r\n" + 
				"    <button class=\"dropbtn\">Student Management\r\n" + 
				"      <i class=\"fa fa-caret-down\"></i>\r\n" + 
				"    </button>\r\n" + 
				"    <div class=\"dropdown-content\">\r\n" + 
				"      <a href=\"StudentDetails\">Student Details</a>\r\n" + 
				"      <a href=\"RemoveStudent\">Remove Student</a>\r\n" + 
				"    </div>\r\n" + 
				"  </div> \r\n" + 
				"  <div class=\"dropdown\">\r\n" + 
				"    <button class=\"dropbtn\" href >Result Management \r\n" + 
				"      <i class=\"fa fa-caret-down\"></i>\r\n" +
				"     \r\n" + 
				"    </button>\r\n" + 
				"    <div class=\"dropdown-content\">\r\n" + 
				"      <a href=\"ResultManagement\">Result</a>\r\n" + 
				"   \r\n" + 
				"  </div> \r\n" + 
				"  </div> \r\n" +
				"  <div class=\"dropdown\">\r\n" + 
				"    <button class=\"dropbtn\">Question Management \r\n" + 
				"      <i class=\"fa fa-caret-down\"></i>\r\n" + 
				"    </button>\r\n" + 
				"    <div class=\"dropdown-content\">\r\n" + 
				"      <a href=\"AddQ\">Add Question</a>\r\n" + 
				"      <a href=\"RemoveQues\">Remove Qestion</a>\r\n" + 
				"      <a href=\"UpdateQues\">Update Qestion</a>\r\n" + 
				"    </div>\r\n" + 
				"  </div> \r\n" + 
				"  <div class=\"dropdown\">\r\n" + 
				"    <button class=\"dropbtn\">Report Management \r\n" + 
				"      <i class=\"fa fa-caret-down\"></i>\r\n" + 
				"      \r\n" + 
				"    </button>\r\n" + 
				"    <div class=\"dropdown-content\">\r\n" + 
				"      <a href=\"ReportManagement\">Report Management</a>\r\n" + 
				"   \r\n" + 
				"    </div>\r\n" + 
				"  </div> \r\n" + 
				"  <div class=\"dropdown\">\r\n" + 
				"    <button class=\"dropbtn\">About\r\n" + 
				"      \r\n" + 
				"    </button>\r\n" + 
				"    \r\n" + 
				"  </div> \r\n" + 
				"<div class=\"dropdown\">\r\n" + 
				"    <button class=\"dropbtn\">Logout\r\n" + 
				"      <i class=\"fa fa-caret-down\"></i>\r\n" + 
				"    \r\n" + 
				"    </button>\r\n" + 
				"    <div class=\"dropdown-content\">\r\n" + 
				"      <a href=\"Logout\">Logout</a>\r\n" + 
				"   \r\n" + 
				"  </div> \r\n" + 
				
				"</div>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>\r\n" + 
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
