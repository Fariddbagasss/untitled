package CRUD_MST_Materi;
import java.sql.*;
public class ConnectMateri
{
    public Connection conn;
    public Statement stat;
    public ResultSet result;
    public PreparedStatement pstat;

    public ConnectMateri()
    {
        try {
            String url = "jdbc:sqlserver://localhost;database=Gemitasi;user=sa;password=polman";
            conn = DriverManager.getConnection(url);
            stat = conn.createStatement();

        }catch (Exception e)
        {
            System.out.println("Error saat connect database: "+e);
        }
    }

    public static void main(String[]args)
    {
        ConnectMateri connect = new ConnectMateri();
        System.out.println("Connection berhasil ");
    }
}
