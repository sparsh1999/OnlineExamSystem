import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Confirmation extends HttpServlet
{
	public static void main(String[] args) {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String id = (String)req.getParameter("id");
        String heading = "";
        String img = "<img src =";
        String back = " <a href =";
        
        System.out.println(req.getParameter("id"));
		if (id.equalsIgnoreCase("\"remove\""))
			{heading = "Student is Removed Successfully";
			img+=req.getContextPath()+"/Images/student.jpg \"> ";
			back+="\"RemoveStudent\" class=\"btn btn-default\" role=\"button\"> Remove More Students </a>";
			}
		else if (id.equalsIgnoreCase("update"))
			{heading = "Student Record Updated Successfully";
			img+=req.getContextPath()+"/Images/student.jpg \"> ";
			back+="\"UpdateStudent\" class=\"btn btn-default\" role=\"button\"> Update More Students </a>";
			}
		else if (id.equalsIgnoreCase("rques"))
		{
			heading = "Question is Removed Successfully";
			img+=req.getContextPath()+"/Images/questions.jpg \"> ";
			back+="\"RemoveQues\" class=\"btn btn-default\" role=\"button\"> Remove More Questions </a>";
		}
		else if (id.equalsIgnoreCase("aques"))
		{
			heading = "Qeestion is Added Successfully";
			img+=req.getContextPath()+"/Images/questions.jpg \"> ";
			back+="\"AddQues\" class=\"btn btn-default\" role=\"button\"> Add More Questions </a>";
		}
		else if (id.equalsIgnoreCase("uques"))
		{
			heading = "Question Record Updated Successfully";
			img+=req.getContextPath()+"/Images/questions.jpg \"> ";
			back+="\"UpdateQues\" class=\"btn btn-default\" role=\"button\"> Update More Questions </a>";
		}
		
		
		PrintWriter pw = resp.getWriter();
		pw.print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"	<title>Confirmation</title>\r\n" + 
				"	<meta charset=\"utf-8\">\r\n" + 
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
				"  <meta http-equiv=\"title\" content=\"3\"; url=http://stackoverflow.com/\" />\r\n" + 
				"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n" + 
				"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n" + 
				"</head>\r\n" + 
				"<body style=\"background-color: #ffd480\">\r\n" + 
				"	<div class=\"center\" align=\"center\">\r\n" + 
				"<h2>"+heading+"</h2>\r\n" + 
				img+
				"<br><br>\r\n" + 
				"  <a href=\"AdminDashboard\" class=\"btn btn-default\" role=\"button\">Admin DashBoard</a>\r\n" + 
				back+
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
