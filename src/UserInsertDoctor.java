import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserInsertDoctor {
    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost:3306/hospital";
            String username = "root";
            String password = "9454";

            Connection con= DriverManager.getConnection(url,username,password);

            String q="insert into doctor(dId,Name,Designation,DepartmentId) values (?,?,?,?)";

            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            System.out.println("enter the doctor id:");
            int dId=Integer.parseInt(br.readLine());
            
            System.out.println("Enter name: ");
            String name=br.readLine();

            System.out.println("enter Designation : ");
            String Designation =br.readLine();

            System.out.println("Entered the  Department : ");
            int Department= Integer.parseInt(br.readLine());

            PreparedStatement pstmt=con.prepareStatement(q);
            pstmt.setInt(1,dId);
            pstmt.setString(2,name);
            pstmt.setString(3, Designation);
            pstmt.setInt(4,Department);

            pstmt.executeUpdate();


            System.out.println("values inserted into the database");

            //create a query



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
