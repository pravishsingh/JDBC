import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Doctor {

    public static void main(String[] args) {
        try {
            // Create a connection
            String url = "jdbc:mysql://localhost:3306/hospital";
            String username = "root";
            String password = "9454";
            Connection con = DriverManager.getConnection(url, username, password);

            // Create the patient table
            String createPatientTableQuery = "CREATE TABLE patient (" +
                    "pId INT(20) PRIMARY KEY AUTO_INCREMENT, " +
                    "pName VARCHAR(200) NOT NULL, " +
                    "Gender VARCHAR(200) NOT NULL, " +
                    "age INT(20), " +
                    "DepartmentId INT(20), " +
                    "INDEX idx_DepartmentId (DepartmentId)" +
                    ")";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(createPatientTableQuery);
            System.out.println("Patient table created in database");

            // Create the doctor table with foreign key constraint referencing patient table
            String createDoctorTableQuery = "CREATE TABLE doctor (" +
                    "dId INT(20) PRIMARY KEY, " +
                    "Name VARCHAR(200) NOT NULL, " +
                    "Designation VARCHAR(200) NOT NULL, " +
                    "DepartmentId INT(20), " +
                    "FOREIGN KEY (DepartmentId) REFERENCES patient(DepartmentId)" +
                    ")";
            stmt.executeUpdate(createDoctorTableQuery);
            System.out.println("Doctor table created in database");

            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
