package hospital.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

    Connection connection;
    Statement statement;
    String url = "jdbc:mysql://localhost:3306/Hospital_Management";
    String user = "root";
    String password = "Bh@rdw@j90";
    public Conn(){
        try{
            connection = DriverManager.getConnection(url,user,password);
            statement = connection.createStatement();
            System.out.println("DATABASE CONNECTED SUCCESSFULLY");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
