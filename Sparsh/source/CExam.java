import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CExam extends HttpServlet
{
	public static void main(String[] args) {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		Connection conn = DBInfo.DBconnect();
		HttpSession session = req.getSession();
		
		String user = (String) session.getAttribute("user");
		String uid = (String) session.getAttribute("uid");
		PrintWriter pw = resp.getWriter();
		String page = "<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"	<title>C Exam</title>\r\n" + 
				"	<meta charset=\"utf-8\">\r\n" + 
				"	<meta http-equiv=\"refresh\" content=\"540\"; url=result.html\" />\r\n" + 
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
				"  <meta http-equiv=\"title\" content=\"3\"; url=http://stackoverflow.com/\" />\r\n" + 
				"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n" + 
				"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n" + 
				"</head>\r\n" + 
				"<body >\r\n" + 
				"\r\n" + 
				"<h4 color=\"orange\" style=\"background-color:orange;\" ><marquee >Welcome "+user+" ID "+uid+"</marquee></h4></div>\r\n" + 
				"<div class=\"container\">\r\n" + 
				"	<div class=\"col-sm-4\"><img src= "+req.getContextPath()+"/Images/c.png \""+" >\r\n" + 
				"	\r\n" + 
				"	<div class=\"col-sm-4\"><a href=\"Logout\" class=\"btn btn-warning\" role=\"button\" >Logout</a></div>\r\n" + 
				"<span id=\"demo\"style=\"font-size: 25px;border: 1px solid black ;\"></span>"+"</div>\r\n" + 
				"<div class=\"container\">\r\n" + 
				"	<div class=\"col-sm-1\"></div>\r\n" + 
				"<div  style=\"border: 2px solid black;\" class=\"col-sm-10\">\r\n" + 
				"<form id = \"adminForm\" method=\"post\" action=\"Result\">\r\n" + 
				"<h2 align=\"center\">C++ Programming Quiz</h2><hr>  ";
		
		String query = "select * from questions where qno != 0 and examid =1 order by qno";
		int i=1;
		//int qno[] = new int[10];
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				//<p><b>Q1) First Question </b><br> A <input type="radio" name="value1"> value1<br> B <input type="radio" name=""> value 1<br> C <input type="radio" name=""> value 1<br> D <input type="radio" name=""> value 1 <hr ></p>
			
				page += "<p><b>Q"+i+") "+rs.getString(2)+" </b><br> A <input type=\"radio\" required value=\"1\" name=\"value"+rs.getInt(1)+"\"> "+rs.getString(3)+" <br> B <input type=\"radio\" value=\"2\" name=\"value"+rs.getInt(1)+"\"> "+rs.getString(4)+" <br> C <input type=\"radio\" value=\"3\" name=\"value"+rs.getInt(1)+"\"> "+rs.getString(5)+" <br> D <input type=\"radio\"  value=\"4\" name=\"value"+rs.getInt(1)+"\"> "+rs.getString(6)+"<hr></p>";
			    //qno[i] = rs.getInt(1);
				i++;
			}
			page+="<div class=\"col-sm-5\"></div>\r\n" + 
					" <button type=\"submit\" class=\"btn btn-success\">Submit</button>\r\n" + 
					"</form>\r\n" + 
					"</div>\r\n" + 
					"</div>\r\n" + 
					"<script>\r\n" + 
					"// Set the date we're counting down to\r\n" + 
					"var countDownDate = new Date().getTime()+600000;\r\n" + 
					"\r\n" + 
					"// Update the count down every 1 second\r\n" + 
					"var x = setInterval(function() {\r\n" + 
					"\r\n" + 
					"    // Get todays date and time\r\n" + 
					"    var now = new Date().getTime();\r\n" + 
					"    \r\n" + 
					"    // Find the distance between now and the count down date\r\n" + 
					"    var distance = countDownDate - now;\r\n" + 
					"    \r\n" + 
					"    // Time calculations for days, hours, minutes and seconds\r\n" + 
					"   \r\n" + 
					"    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));\r\n" + 
					"    var seconds = Math.floor((distance % (1000 * 60)) / 1000);\r\n" + 
					"    \r\n" + 
					"    // Output the result in an element with id=\"demo\"\r\n" + 
					"    document.getElementById(\"demo\").innerHTML = minutes + \"m \" + seconds + \"s \";\r\n" + 
					"    \r\n" + 
					"    // If the count down is over, write some text \r\n" + 
					"    if (distance < 0) {\r\n" + 
					"        clearInterval(x);\r\n" + 
					"        document.getElementById(\"demo\").innerHTML = \"EXPIRED\";\r\n" + 
					"\r\n" + 
					" document.getElementById(\"adminForm\").action=\"Result\";\r\n" + 
					" document.getElementById(\"adminForm\").method = \"Post\";\r\n" + 
					" document.getElementById(\"adminForm\").submit();\r\n" + 
					"\r\n" + 
					"    }\r\n" + 
					"}, 1000);\r\n" + 
					"</script>\r\n" + 
					""+
					"</body>\r\n" + 
					"</html>";
			pw.println(page);
			session.setAttribute("exam", "C");
			session.setAttribute("date", LocalDateTime.now());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		doGet(req, resp);
	}

}
