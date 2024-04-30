import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Drop {
    public static void main(String[] args) {
        try {
            // Create a connection
            String url = "jdbc:mysql://localhost:3306/hospital";
            String username = "root";
            String password = "9454";
            Connection con = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement stmt = con.createStatement();

            // Drop the doctor table
            String dropDoctorTable= "DROP TABLE IF EXISTS doctor";
            stmt.executeUpdate(dropDoctorTable);
            System.out.println("Doctor table deleted from the database");

            // Close resources
            stmt.close();
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
