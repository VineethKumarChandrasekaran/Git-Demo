package organisation;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.vt.crm.generic.databaseUtility.DatabaseUtility;

public class ReadingDataFromMySql {
@Test
public void connectDatabase() throws SQLException
{
	DatabaseUtility du=new DatabaseUtility();
	du.getDatabaseConnection();
	ResultSet values = du.executeSelectQuery("select * from employee");
	values.next();
	System.out.println(values.getString(1)+"\t"+values.getString(2));
	
	du.executeNonSelectQuery("insert into employee values('TP_006','Vanchu','BDA',2,'Fresher')");
	du.closeConnection();
	
	
}
}
