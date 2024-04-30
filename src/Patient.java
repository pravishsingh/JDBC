import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLOutput;
import java.sql.Statement;

public class Patient {

    public static void main(String[] args) {
        try{
            // Create a connection

            String url = "jdbc:mysql://localhost:3306/hospital";
            String username= "root";
            String password = "9454";
            Connection con = DriverManager.getConnection(url, username, password);

            // Create a query
            String pq="create table patient(pId int(20) primary key auto_increment , pName varchar(200) not null , Gender varchar(200) not null , age int(20), DepartmentId int(20) foreign key) ";
// create a statement
            Statement stmt=con.createStatement();
            stmt.executeUpdate(pq);
            System.out.println("Patent table created in database");

            con.close();



        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
