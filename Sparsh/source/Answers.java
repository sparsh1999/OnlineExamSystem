import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Answers extends HttpServlet
{
   public static void main(String[] args) {
	
}
   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
	   
	   String answers = "<!DOCTYPE html>\r\n" + 
	   		"<html lang=\"en\">\r\n" + 
	   		"<head>\r\n" + 
	   		"  <title>Answers</title>\r\n" + 
	   		"  <meta charset=\"utf-8\">\r\n" + 
	   		"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
	   		"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
	   		"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n" + 
	   		"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n" + 
	   		"</head>\r\n" + 
	   		"<body style=\"background-color: #ffd480\">\r\n" + 
	   		"\r\n" + 
	   		"<div class=\"container\">\r\n" + 
	   		"  <h2>Answers</h2>\r\n" + 
	   		"  <p>All the Answers for question asked are available here</p>\r\n" + 
	   		"  <table class=\"table table-hover table-bordered table-striped\">\r\n" + 
	   		"    <thead>\r\n" + 
	   		"      <tr>\r\n" + 
	   		"        <th>Question No</th>\r\n" + 
	   		"        <th>Question</th>\r\n" + 
	   		"        <th>Option 1</th>\r\n" + 
	   		"        <th>Option 2</th>\r\n" + 
	   		"        <th>Option 3</th>\r\n" + 
	   		"        <th>Option 4</th>\r\n" + 
	   		"        <th>Answer</th>\r\n" + 
	   		"\r\n" + 
	   		"      </tr>\r\n" + 
	   		"    </thead>\r\n" + 
	   		"    <tbody>";
	   
	   Connection conn = DBInfo.DBconnect();
	   PrintWriter pw = resp.getWriter();
	   HttpSession session = req.getSession();
	   String exam = (String) session.getAttribute("exam");
	   int examid =0;
	   if (exam.equalsIgnoreCase("C"))
		   examid = 1;
	   else if (exam.equalsIgnoreCase("C"))
		   examid = 2;
	   else if (exam.equalsIgnoreCase("C"))
		   examid = 3;
		   
	
	   String query = "select qno,question,option1,option2,option3,option4,answer from questions where qno!=0 and examid="+examid+" order by qno";
	   
	   try {
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next())
		{
			answers+= "<tr>\r\n" + 
					"        <td>"+rs.getInt(1)+"</td>\r\n" + 
					"        <td>"+rs.getString(2)+"</td>\r\n" + 
					"        <td>"+rs.getString(3)+"</td>\r\n" + 
					"        <td>"+rs.getString(4)+"</td>\r\n" + 
					"        <td>"+rs.getString(5)+"</td>\r\n" + 
					"        <td>"+rs.getString(6)+"</td>\r\n" + 
					"        <td>Option "+rs.getInt(7)+"</td>\r\n" + 
					"      </tr>   ";
		}
		answers+=" </tbody>\r\n" + 
				"\r\n" + 
				"  </table>\r\n" + 
				"</div>\r\n" + 
				"<div class=\"col-sm-4\">\r\n" + 
				"</div>\r\n" + 
				"  <div class=\"col-sm-8\"><button class=\"btn btn-default\" onclick()=\"goBack()\" >Back to Results</button>  </div>\r\n" + 
				
				"\r\n" + 
				"<script>\r\n" + 
				"function goBack() {\r\n" + 
				"    window.history.back();\r\n" + 
				"}\r\n" + 
				"</script>"+
				"</body>\r\n" + 
				"</html>\r\n" + 
				"\r\n" + 
				"";
		
		pw.println(answers);
		ps.close();
		conn.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
	}
   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
	   
	   
	   
	}
	
}
