import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdatePatient {
    public static void main(String[] args) {
        try{
            String url="jdbc:mysql://localhost:3306/hospital";
            String name="root";
            String password="9454";

            Connection con= DriverManager.getConnection(url,name,password);

            String q ="update patient set pName =?, Gender=? where pId=? ";

            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter new name:");
            String name1=br.readLine();

            System.out.println("Enter Gender :");
            String gender= br.readLine();

            System.out.println("enter the the pId:");
            int id=Integer.parseInt(br.readLine());

            PreparedStatement pstmt = con.prepareStatement(q);

            pstmt.setString(1,name1);
            pstmt.setString(2,gender);
            pstmt.setInt(3,id);

            pstmt.executeUpdate();
            System.out.println("done");
            con.close();




        }catch (Exception e){
            System.out.println(e);
        }
    }
}
