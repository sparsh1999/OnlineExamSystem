import java.sql.Connection;
import java.sql.DriverManager;

public class DBInfo
{
static 
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static Connection DBconnect()
{
	Connection c = null;
	try
	{
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/OES","root","oracle");
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	return c;
	
}


}
