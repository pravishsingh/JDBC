import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Read {
    public static void main(String[] args) {
        try {
            String url="jdbc:mysql://localhost:3306/hospital";
            String username="root";
            String password="9454";

            Connection con= DriverManager.getConnection(url,username,password);
            String query = "select * from patient";
            String query2="select * from doctor";

            Statement stmt=con.createStatement();
            ResultSet set=stmt.executeQuery(query);
//            ResultSet set1=stmt.executeQuery(query2);

            while (set.next()){
                int id = set.getInt("pId"); // Assuming pId is the patient ID column
                String name = set.getString("pName");
                String gender = set.getString("Gender");
                int age = set.getInt("Age");
                System.out.println("Patient ID: " + id + ", Name: " + name + ", Gender: " + gender + ", Age: " + age);
            }
            set.close();
            stmt.close();
            con.close();



        }catch (Exception e){
            System.out.println(e);
        }
    }
}
