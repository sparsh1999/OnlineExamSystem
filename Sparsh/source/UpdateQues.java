import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateQues extends HttpServlet
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
	 		"  <title>Update Question</title>\r\n" + 
	 		"  <meta charset=\"utf-8\">\r\n" + 
	 		"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
	 		"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
	 		"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n" + 
	 		"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n" + 
	 		"</head>\r\n" + 
	 		"<body style=\"background-color:tomato;\">\r\n" + 
	 		"\r\n" + 
	 		"<div class=\"container\">\r\n" + 
	 		"  <h2>Update Question</h2>\r\n" + 
	 		"  <form class=\"form-horizontal\" action=\"UpdateQues\" method=\"post\">\r\n" + 
	 		"\r\n" + 
	 		"  	<div class=\"form-group\">\r\n" + 
	 		"      <label class=\"control-label col-sm-2\" for=\"number\">Exam Id</label>\r\n" + 
	 		"      <div class=\"col-sm-10\">\r\n" + 
	 		"        <input type=\"number\" class=\"form-control\" required placeholder=\"Enter Exam Id No\" name=\"exam\">\r\n" + 
	 		"      </div>\r\n" + 
	 		"    </div>\r\n" + 
	 		"    <div class=\"form-group\">\r\n" + 
	 		"      <label class=\"control-label col-sm-2\" for=\"number\">Question ID</label>\r\n" + 
	 		"      <div class=\"col-sm-10\">\r\n" + 
	 		"        <input type=\"number\" class=\"form-control\" required placeholder=\"Enter Question Id No\" name=\"quesid\">\r\n" + 
	 		"      </div>\r\n" + 
	 		"    </div>\r\n" + 
	 		"    <div class=\"form-group\">\r\n" + 
	 		"      <label class=\"control-label col-sm-2\" for=\"number\">Question No</label>\r\n" + 
	 		"      <div class=\"col-sm-10\">\r\n" + 
	 		"        <input type=\"number\" class=\"form-control\" required placeholder=\"Enter Question  No\" name=\"qno\">\r\n" + 
	 		"      </div>\r\n" + 
	 		"    </div>\r\n" + 
	 		"    <div class=\"form-group\">\r\n" + 
	 		"      <label class=\"control-label col-sm-2\" for=\"text\">Question</label>\r\n" + 
	 		"      <div class=\"col-sm-10\">\r\n" + 
	 		"        <input type=\"text\" class=\"form-control\" required placeholder=\"Enter Question\" name=\"ques\">\r\n" + 
	 		"      </div>\r\n" + 
	 		"    </div>\r\n" + 
	 		"     <div class=\"form-group\">\r\n" + 
	 		"      <label class=\"control-label col-sm-2\" for=\"text\">Option 1</label>\r\n" + 
	 		"      <div class=\"col-sm-10\">\r\n" + 
	 		"        <input type=\"text\" class=\"form-control\" required placeholder=\"Enter option1\" name=\"opt1\">\r\n" + 
	 		"      </div>\r\n" + 
	 		"    </div>\r\n" + 
	 		"     <div class=\"form-group\">\r\n" + 
	 		"      <label class=\"control-label col-sm-2\" for=\"text\">Option 2</label>\r\n" + 
	 		"      <div class=\"col-sm-10\">\r\n" + 
	 		"        <input type=\"text\" class=\"form-control\" required placeholder=\"Enter option2\" name=\"opt2\">\r\n" + 
	 		"      </div>\r\n" + 
	 		"    </div>\r\n" + 
	 		"     <div class=\"form-group\">\r\n" + 
	 		"      <label class=\"control-label col-sm-2\" for=\"text\">Option 3</label>\r\n" + 
	 		"      <div class=\"col-sm-10\">\r\n" + 
	 		"        <input type=\"text\" class=\"form-control\" required placeholder=\"Enter option3\" name=\"opt3\">\r\n" + 
	 		"      </div>\r\n" + 
	 		"    </div>\r\n" + 
	 		"     <div class=\"form-group\">\r\n" + 
	 		"      <label class=\"control-label col-sm-2\" for=\"text\">Option 4</label>\r\n" + 
	 		"      <div class=\"col-sm-10\">\r\n" + 
	 		"        <input type=\"text\" class=\"form-control\" required placeholder=\"Enter option4\" name=\"opt4\">\r\n" + 
	 		"      </div>\r\n" + 
	 		"    </div>\r\n" + 
	 		"     <div class=\"form-group\">\r\n" + 
	 		"      <label class=\"control-label col-sm-2\" for=\"text\">Answer</label>\r\n" + 
	 		"      <div class=\"col-sm-10\">\r\n" + 
	 		"        <input type=\"text\" class=\"form-control\" required placeholder=\"Enter Answer No\" name=\"ans\">\r\n" + 
	 		"      </div>\r\n" + 
	 		"    </div>\r\n" + 
	 		"\r\n" + 
	 		"  <div class=\"form-group\">        \r\n" + 
	 		"      <div class=\"col-sm-offset-2 col-sm-10\">\r\n" + 
	 		"        <button type=\"submit\" class=\"btn btn-default\">Update</button>\r\n" + 
	 		"        <a href=\"AdminDashboard\" class=\"btn btn-default\" role=\"button\">Back to Admin Page</a>\r\n" + 
	 		"      </div>\r\n" + 
	 		"    </div>\r\n" + 
	 		"  </form>\r\n" + 
	 		"</div>\r\n" + 
	 		"\r\n" + 
	 		"</body>\r\n" + 
	 		"</html>\r\n" + 
	 		"");
	}
 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
	 
	 Connection conn = DBInfo.DBconnect();
	 
	 String  ques = req.getParameter("ques");
		int examid = Integer.valueOf(req.getParameter("exam"));
		String opt1 = req.getParameter("opt1");
		String opt2 = req.getParameter("opt2");
		String opt3 = req.getParameter("opt3");
		String opt4 = req.getParameter("opt4");
		int ans = Integer.valueOf(req.getParameter("ans"));
		int quesid = Integer.valueOf(req.getParameter("quesid"));
		int qno = Integer.valueOf(req.getParameter("qno"));
		
		String query = "update questions set examid="+examid+" , qno="+qno+" , answer="+ans+" , question='"+ques+"' ,  option1='"+opt1+"' , option2='"+opt2+"' , option3='"+opt3+"' , option4='"+opt4+"'  where qid="+quesid  ;
    
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
			ps.close();
			conn.close();
			resp.sendRedirect("Confirmation?id=uques");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
 
 }
}
