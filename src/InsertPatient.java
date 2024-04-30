import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertPatient {
    public static void main(String[] args) {
        try {
            String url="jdbc:mysql://localhost:3306/hospital";
            String username="root";
            String password="9454";

            Connection con= DriverManager.getConnection(url,username,password);

            //Create a query for insert the data
            String q="insert into patient(pName,Gender,Age,DepartmentId) values (?,?,?,?)";

            // get the PreparedStatement object

            PreparedStatement pstmt=con.prepareStatement(q);

            //set the values to query

            pstmt.setString(1,"Gopal");
            pstmt.setString(2,"M");
            pstmt.setInt(3,34);
            pstmt.setInt(4,100);

            pstmt.executeUpdate();
            System.out.println("inserted the data into the patient table");
            con.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
