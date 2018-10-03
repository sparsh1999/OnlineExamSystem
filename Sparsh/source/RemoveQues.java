import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveQues extends HttpServlet
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
				"  <title>Remove Question</title>\r\n" + 
				"  <meta charset=\"utf-8\">\r\n" + 
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
				"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n" + 
				"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n" + 
				"</head>\r\n" + 
				"<body style=\"background-color:tomato;\">\r\n" + 
				"\r\n" + 
				"<div class=\"container\">\r\n" + 
				"  <h2>Remove Question</h2>\r\n" + 
				"  <form class=\"form-horizontal\" action=\"RemoveQues\" method=\"post\">\r\n" + 
				"\r\n" + 
				
				"    <div class=\"form-group\">\r\n" + 
				"      <label class=\"control-label col-sm-2\" for=\"text\">Question Id</label>\r\n" + 
				"      <div class=\"col-sm-10\">\r\n" + 
				"        <input type=\"text\" class=\"form-control\" required placeholder=\"Enter Question Id\" name=\"ques\">\r\n" + 
				"      </div>\r\n" + 
				"    </div>\r\n" + 
				"     \r\n" + 
				"\r\n" + 
				"  <div class=\"form-group\">        \r\n" + 
				"      <div class=\"col-sm-offset-2 col-sm-10\">\r\n" + 
				"        <button type=\"submit\" class=\"btn btn-default\">Delete</button>\r\n" + 
				"        <a href=\"AdminDashboard\" class=\"btn btn-default\" role=\"button\">Back to Admin Page</a>\r\n" + 
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
		
		Connection conn = DBInfo.DBconnect();
	//	int examid = Integer.valueOf(req.getParameter("exam"));
		int ques = Integer.valueOf(req.getParameter("ques"));
		
		String query = "delete from questions where qid="+ques;
		
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.executeUpdate();
			ps.close();conn.close();
			resp.sendRedirect("Confirmation?id=rques");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
	}

}
