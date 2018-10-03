import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Result extends HttpServlet
{
	public static void main(String[] args) {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		
		Connection conn = DBInfo.DBconnect();
		
		HttpSession session = req.getSession();
		String uid = (String) session.getAttribute("uid");
		String exam = (String) session.getAttribute("exam");
		String user12 = (String) session.getAttribute("user");
		LocalDateTime date1 = (LocalDateTime) session.getAttribute("date");
		
		String  date3 = date1.toString();
		int examid1 = 0;
		if (exam.equalsIgnoreCase("C"))
			examid1 = 1;
		else if (exam.equalsIgnoreCase("C++"))
			examid1 = 2;
		else if (exam.equalsIgnoreCase("Java"))
			examid1 = 3;
		
		int marks =0,right=0,wrong=0;
		String remark = "";
		
		PrintWriter pw = resp.getWriter();
		
		String query = "select * from questions where qno != 0 and examid ="+examid1+" order by qno";
		String entry = "insert into report (studentid,date,examid,marks,remark) values(?,?,?,?,?)";
		String image="<div class=\"col-sm-4\"><img src =";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ps = conn.prepareStatement(entry);
			ps.setString(2, date3);
			ps.setInt(1, Integer.valueOf(uid));
			ps.setInt(3,examid1 );
			
			int i =1;
			while (rs.next())
			{
				int c = rs.getInt(7);
//				System.out.println(c+" "+rs.getString(c+2)+" "+req.getParameter("value"+i));
				if (c==Integer.valueOf(req.getParameter("value"+i)))
				{	marks = marks+4;
				right++;
				}
				else
				{	marks = marks-1;
				wrong++;
				}
				i++;	
				
			}
			
			if (marks>=20)
			{	remark = "pass";
			   image += req.getContextPath()+"/Images/exampas.jpg align=\"center\">";
			}
			else
			{	remark = "fail";
			    image += req.getContextPath()+"/Images/examfail.jpg align=\"center\" style=\"min-width: 450px;max-height: 220px;\">";
			}
			ps.setInt(4, marks);
			ps.setString(5,remark);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		pw.print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"	<title>Result</title>\r\n" + 
				"	<meta charset=\"utf-8\">\r\n" + 
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
				"  <meta http-equiv=\"title\" content=\"3\"; url=http://stackoverflow.com/\" />\r\n" + 
				"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n" + 
				"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n" + 
				"</head>\r\n" + 
				"<body style=\"background-color: #ffd480\">\r\n" + 
				"<h4 color=\"orange\" style=\"background-color:orange;\" ><marquee >Welcome "+user12+" ID "+uid+"</marquee></h4></div><br>\r\n" + 
				"<table  class=\"table table-hover table-bordered table-striped\" style=\"width: 60%\" align=\"center\">\r\n" + 
				"	<tr >\r\n" + 
				"		<th colspan=\"2\" >RESULT</th>\r\n" + 
				"	</tr>"+
				"	<tr>\r\n" + 
				"		<td>Student ID</td>\r\n" + 
				"		<td>"+uid+"</td>\r\n" + 
				"	</tr>\r\n" + 
				"	<tr>\r\n" + 
				"		<td>Examination Of</td>\r\n" + 
				"		<td>"+exam+"</td>\r\n" + 
				"	</tr>\r\n" + 
				"	<tr>\r\n" + 
				"		<td>Date Of Exam</td>\r\n" + 
				"		<td>"+date3+"</td>\r\n" + 
				"	</tr>\r\n" + 
				"	<tr>\r\n" + 
				"		<td>Total Questions</td>\r\n" + 
				"		<td>"+10+"</td>\r\n" + 
				"	</tr>\r\n" + 
				"	<tr>\r\n" + 
				"		<td>Marks Obtained</td>\r\n" + 
				"		<td>"+marks+"</td>\r\n" + 
				"	</tr>\r\n" + 
				"	<tr>\r\n" + 
				"		<td>Remarks</td>\r\n" + 
				"		<td>"+remark+"</td>\r\n" + 
				"	</tr>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</table>\r\n" + 
				"<br />\r\n" + 
				"<br>\r\n" + 
				"<div class=\"col-sm-4\"></div>\r\n" + 
				image+"\r\n" + 
			    "		<br><br>\r\n" + 
			    "<div class=\"container center\" >\r\n" + 
			    "	\r\n" + 
			    "	<div class=\"col-sm-3\"><a href=\"Answers\" class=\"btn btn-success\" role=\"button\" >View Answers</a></div>\r\n" + 
			    "	\r\n" + 
			    "	<div class=\"col-sm-4\"><a href=\"Dashboard\" class=\"btn btn-warning\" role=\"button\" >Dashboard</a></div>\r\n" + 
			    "</div>"+
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
