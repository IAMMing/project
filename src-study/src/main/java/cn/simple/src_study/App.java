package cn.simple.src_study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	
    	Class.forName("");
    	Connection connection = DriverManager.getConnection("");
    	PreparedStatement stat = connection.prepareStatement("?");
    	stat.setString(0, "");
    	
        System.out.println( "Hello World!" );
        
        
    }
}
