import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/db_pelatihan_karyawan"; // Sesuaikan dengan nama database Anda
    private static final String USER = "revahanum"; // Username database
    private static final String PASSWORD = "reva163"; // Password database

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi berhasil!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection; 
    }
}
   