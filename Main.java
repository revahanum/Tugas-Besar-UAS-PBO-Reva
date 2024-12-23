import java.util.Scanner;
import java.util.List;

public class Main { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Proses Login
        Login login = new Login(scanner);
        if (!login.performLogin()) {
            System.out.println("Program dihentikan karena login gagal.");
            return;
        }

        // Menu utama setelah login berhasil
        PesertaDAO pesertaDAO = new PesertaDAO();

        while (true) {
            System.out.println("1. Tambah Peserta");
            System.out.println("2. Lihat Peserta");
            System.out.println("3. Update Peserta");
            System.out.println("4. Hapus Peserta");
            System.out.println("5. Keluar");

            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (pilihan) {
                case 1:
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Nomor Telepon: ");
                    String nomorTelepon = scanner.nextLine();
                    System.out.print("Alamat: ");
                    String alamat = scanner.nextLine();

                    Peserta peserta = new Peserta(0, nama, email, nomorTelepon, alamat);
                    pesertaDAO.create(peserta);
                    break;

                case 2:
                    List<Peserta> pesertaList = pesertaDAO.readAll();
                    for (Peserta p : pesertaList) {
                        System.out.println(p);
                    }
                    break;

                case 3:
                    System.out.print("ID Peserta: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // clear buffer

                    System.out.print("Nama: ");
                    nama = scanner.nextLine();
                    System.out.print("Email: ");
                    email = scanner.nextLine();
                    System.out.print("Nomor Telepon: ");
                    nomorTelepon = scanner.nextLine();
                    System.out.print("Alamat: ");
                    alamat = scanner.nextLine();

                    peserta = new Peserta(id, nama, email, nomorTelepon, alamat);
                    pesertaDAO.update(peserta);
                    break;

                case 4:
                    System.out.print("ID Peserta: ");
                    id = scanner.nextInt();
                    pesertaDAO.delete(id);
                    break;

                case 5:
                    System.out.println("Keluar...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opsi tidak valid!");
            }
        }
    }
}
