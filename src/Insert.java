import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insert {
    public static void main(String[] args) {
        try {
            String url="jdbc:mysql://localhost:3306/hospital";
            String username="root";
            String password="9454";

            Connection con= DriverManager.getConnection(url,username,password);

            //Create a query for insert the data
            String q="insert into doctor(dId,Name,Designation,DepartmentId) values (?,?,?,?)";

            // get the PreparedStatement object

            PreparedStatement pstmt=con.prepareStatement(q);

            //set the values to query

            pstmt.setInt(1,1);
            pstmt.setString(2,"Sachin");
            pstmt.setString(3,"Ortho");
            pstmt.setInt(4,100);

            pstmt.executeUpdate();
            System.out.println("inserted the data into the sql");
            con.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
