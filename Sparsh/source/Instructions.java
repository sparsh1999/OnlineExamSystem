import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Instructions extends HttpServlet
{
	public static void main(String[] args) {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		PrintWriter pw = resp.getWriter();
		pw.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"	<title>Instructions</title>\r\n" + 
				"	<meta charset=\"utf-8\">\r\n" + 
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
				"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n" + 
				"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n" + 
				"</head>\r\n" + 
				"<body style=\"background-color:#79ff4d\">\r\n" + 
				"\r\n" + 
				"<div class=\"container\">\r\n" + 
				"<h2 align=\"center\" class=\"col-sm-10\" >Welcome guest</h2>\r\n" + 
				"<a href=\"Demo.html\" class=\"btn btn-warning col-sm-2\" role=\"button\" margin=top=\"10px\" >Logout</a>\r\n" + 
				" \r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div class=\"container\">\r\n" + 
				"  <div class=\"panel panel-default\">\r\n" + 
				"    <div class=\"panel-heading\">Test Instructions</div>\r\n" + 
				"    <span id=\"demo\"style=\"font-size: 25px;border: 1px solid black ; float: right\"></span>\r\n" + 
				"    <div class=\"panel-body\">Your test will start in few minutes .Please go through the instructions carefully <br /> Note the Exam id for future use\r\n" + 
				"   <br /> <br /> <b>INSTRUCTIONS</b>\r\n" + 
				"    <br /> <ol>\r\n" + 
				"    	<li>Test willl be of seconds</li>\r\n" + 
				"    	<li>you have to finish the exam in the timer</li>\r\n" + 
				"    </ol>\r\n" + 
				"    <br /> <b>HOW TO ANSWER</b>\r\n" + 
				"    <br /> <ol><li>Just click the wright option</li>\r\n" + 
				"    	<li>Once completed click the submit button</li></ol>\r\n" + 
				"    <ol>\r\n" + 
				"    	\r\n" + 
				"    </ol>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				"</div>\r\n" + 
				"<div align=\"center\"><a id = \"adminForm\" href=\"CExam\" class=\"btn btn-default\" role=\"button\" >Proceed</a></div>\r\n" + 
				"\r\n" + 
				"<script>\r\n" + 
				"// Set the date we're counting down to\r\n" + 
				"var countDownDate = new Date().getTime()+20000;\r\n" + 
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
				" document.getElementById(\"adminForm\").click();\r\n" + 
				" \r\n" + 
				"\r\n" + 
				"    }\r\n" + 
				"}, 1000);\r\n" + 
				"</script>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		doGet(req, resp);
	}

}
