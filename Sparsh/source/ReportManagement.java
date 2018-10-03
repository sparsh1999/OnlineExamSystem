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

public class ReportManagement extends HttpServlet
{
	public static void main(String[] args) {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		Connection conn = DBInfo.DBconnect();
		String query = "select * from report,udetails where report.studentid = udetails.uid";
		PrintWriter pw = resp.getWriter();
		
		String table = "<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"<head>\r\n" + 
				"  <title>Report Management</title>\r\n" + 
				"  <meta charset=\"utf-8\">\r\n" + 
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
				"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n" + 
				"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n" + 
				"</head>\r\n" + 
				"<body style=\"background-color: #ffd480\">\r\n" + 
				"\r\n" + 
				"<div class=\"container\">\r\n" + 
				"  <h2>Report Management</h2>\r\n" + 
				"  <p>All the test reports are available for admin</p>\r\n" + 
				"  <table class=\"table table-hover table-bordered table-striped\">\r\n" + 
				"    <thead>\r\n" + 
				"      <tr>\r\n" + 
				"        <th>Student Name</th>\r\n" + 
				"        <th>Student ID</th>\r\n" + 
				"        <th>Student Email ID</th>\r\n" + 
				"        <th>Given Exam Date</th>\r\n" + 
				"        <th>Exam Name</th>\r\n" + 
				"        <th>Marks Obtained</th>\r\n" + 
				"        <th>Remarks</th>\r\n" + 
				"\r\n" + 
				"      </tr>\r\n" + 
				"    </thead>\r\n" + 
				"    <tbody>";
		
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
		
			String exam = "";
			String style="";
			
			while(rs.next())
			{
				if (rs.getString(6).equalsIgnoreCase("pass"))
					style = "success";
				else
					style = "danger";
				
				if (rs.getInt(4)==1)
					exam = "C";
				else if (rs.getInt(4)==2)
					exam = "C++";
					else if (rs.getInt(4)==3)
						exam = "Java";
				
				table+= " <tr class=\""+style+"\">\r\n" + 
						"        <td>"+rs.getString(8)+"</td>\r\n" + 
						"        <td>"+rs.getInt(2)+"</td>\r\n" + 
						"        <td>"+rs.getString(10)+"</td>\r\n" + 
						"        <td>"+rs.getString(3)+"</td>\r\n" + 
						"        <td>"+exam+"</td>\r\n" + 
						"        <td>"+rs.getInt(5)+"</td>\r\n" + 
						"        <td>"+rs.getString(6)+"</td>\r\n" + 
						"      </tr>";
						
			}
			
			table+="  </tbody>\r\n" + 
					"\r\n" + 
					"  </table>\r\n" + 
					"</div>\r\n" + 
					"<div class=\"col-sm-4\">\r\n" + 
					"</div>\r\n" + 
					"  <div class=\"col-sm-8\"><a href=\"AdminDashboard\" class=\"btn btn-default\" role=\"button\">Back to Admin Page</a>  </div>\r\n" + 
					"</body>\r\n" + 
					"</html>\r\n" + 
					"\r\n" + 
					"";
			
			pw.println(table);
			ps.close();conn.close();

			
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
