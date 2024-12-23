import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.Random;

public class Login {
    private Scanner scanner;

    public Login(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean performLogin() {
        boolean loginSuccess = false;

        while (!loginSuccess) {
            System.out.println("===== LOGIN =====");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            // Generate Captcha
            String captcha = generateCaptcha();
            System.out.println("Captcha: " + captcha);
            System.out.print("Masukkan Captcha: ");
            String captchaInput = scanner.nextLine();

            // Validasi Captcha
            if (!captcha.equalsIgnoreCase(captchaInput)) {
                System.out.println("Captcha salah. Silakan coba lagi.");
                continue;
            }

            try (Connection conn = DatabaseConnection.getConnection()) {
                // Query untuk memvalidasi username dan password
                String query = "SELECT * FROM users WHERE username = ? AND password = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    // Jika username dan password valid
                    System.out.println("Login berhasil! Selamat datang, " + username + "!");
                    loginSuccess = true;
                } else {
                    // Jika username atau password salah
                    System.out.println("Login gagal! Username atau password salah.");
                }
            } catch (Exception e) {
                // Menangani exception
                System.out.println("Terjadi kesalahan saat login.");
                e.printStackTrace();
            }
        }

        return loginSuccess;
    }

    // Metode untuk menghasilkan captcha acak
    private String generateCaptcha() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder captcha = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 6; i++) { // Panjang captcha 6 karakter
            captcha.append(chars.charAt(random.nextInt(chars.length())));
        }
        return captcha.toString();
    }    
}
