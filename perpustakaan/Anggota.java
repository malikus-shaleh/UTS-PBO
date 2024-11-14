package perpustakaan;
import java.util.ArrayList;

public class Anggota {
    private String nama;
    private String nomorAnggota;
    private String alamat;
    private ArrayList<Buku> daftarPinjaman;

    public Anggota(String nama, String nomorAnggota, String alamat) {
        this.nama = nama;
        this.nomorAnggota = nomorAnggota;
        this.alamat = alamat;
        this.daftarPinjaman = new ArrayList<>();
    }
    public void tampilkanInfoAnggota() {
        System.out.println("Nama: " + nama);
        System.out.println("Nomor Anggota: " + nomorAnggota);
        System.out.println("Alamat: " + alamat);
        System.out.println("Daftar Pinjaman:");
        
        
        for (Buku buku : daftarPinjaman) {
            buku.infobuku();
            System.out.println();
        }
    }
    public String getNama() {
        return nama;
    }

    public void pinjamBuku(Buku buku) {
        daftarPinjaman.add(buku);
    }

    public void kembalikanBuku(Buku buku) {
        daftarPinjaman.remove(buku);
    }
    
    public boolean bukudipinjam(Buku buku) {
        return daftarPinjaman.contains(buku);
    }
}
