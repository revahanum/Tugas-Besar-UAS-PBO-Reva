

public class Peserta {
    private int id;
    private String nama;
    private String email;
    private String nomorTelepon;
    private String alamat;

    // Constructor
    public Peserta(int id, String nama, String email, String nomorTelepon, String alamat) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.nomorTelepon = nomorTelepon;
        this.alamat = alamat;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNomorTelepon() { return nomorTelepon; }
    public void setNomorTelepon(String nomorTelepon) { this.nomorTelepon = nomorTelepon; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    @Override
    public String toString() {
        return "ID: " + id + ", Nama: " + nama + ", Email: " + email + ", No Telepon: " + nomorTelepon + ", Alamat: " + alamat;
    }
}
