package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion
{

    private Connection conexion;
    String url = "jdbc:mysql://localhost:3306/sales";
    String user = "root";
    String password = "root";

    public Connection getConexion()
    {
        return conexion;
    }

    public void setConexion(Connection conexion)
    {
        this.conexion = conexion;
    }

    public Connection GetConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);

            // System.out.println("Successful Conecction with DB");
        }
        catch (Exception e)
        {
            System.out.println("ERROR Connected wirt the DB: " + e.getMessage());
        }

        return conexion;
    }

    public void Disconnected()
    {
        try
        {
            if (!conexion.isClosed())
            {
                conexion.close();
            }
        }
        catch (Exception e)
        {
            System.out.println("ERROR Close of the Connectig with the DB: " + e.getMessage());
        }
    }

//    public static void main(String[] args)
//    {
//       Conexion conexion = new Conexion();
//       conexion.GetConnection();
//    }
}
