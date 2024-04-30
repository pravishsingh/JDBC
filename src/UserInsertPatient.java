import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLOutput;

public class UserInsertPatient {
    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost:3306/hospital";
            String username = "root";
            String password = "9454";

            Connection con= DriverManager.getConnection(url,username,password);

            String q="insert into patient(pName,Gender,Age,DepartmentId) values (?,?,?,?)";

            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter name: ");
            String name=br.readLine();

            System.out.println("enter your Gender : ");
            String gender=br.readLine();

            System.out.println("Enter your age :");
            int age=Integer.parseInt(br.readLine());

            System.out.println("Enterd the  Department : ");
            int Department= Integer.parseInt(br.readLine());

            PreparedStatement pstmt=con.prepareStatement(q);

            pstmt.setString(1,name);
            pstmt.setString(2,gender);
            pstmt.setInt(3,age);
            pstmt.setInt(4,Department);

            pstmt.executeUpdate();


            System.out.println("values inserted into the database");

            //create a query



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
