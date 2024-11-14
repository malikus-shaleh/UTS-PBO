package perpustakaan;
import java.util.ArrayList;

public class Perpustakaan {
    private ArrayList<Buku> daftarBuku;
    private ArrayList<Anggota> daftarAnggota;

    public Perpustakaan() {
        daftarBuku = new ArrayList<>();
        daftarAnggota = new ArrayList<>();
    }

    public void tambahBukubaru(Buku buku) {
        daftarBuku.add(buku);
        System.out.println("Buku " + buku.getJudul() + " berhasil ditambahkan.");
    }

    public void tambahAnggota(Anggota anggota) {
        daftarAnggota.add(anggota);
        System.out.println("Anggota " + anggota.getNama() + " berhasil didaftarkan.");
    }

    public void minjamBuku(String namaAnggota, String judul) {
        Anggota anggota = mencariAnggota(namaAnggota);
        Buku buku = cariBuku(judul);

        if (anggota == null) {
            System.out.println("Anggota " + namaAnggota + " tidak ditemukan.");
            return;
        }
        if (buku == null) {
            System.out.println("Buku " + judul + " tidak ditemukan.");
            return;
        }

        if (buku.isStatus()) {
            buku.setStatus(false);
            anggota.pinjamBuku(buku);
            System.out.println("Buku " + judul + " berhasil dipinjam oleh " + namaAnggota + ".");
        } else {
            System.out.println("Buku \"" + judul + "\" saat ini sedang dipinjam.");
        }
    }

    public void kembalikanBuku(String namaAnggota, String judulBuku) {
        Anggota anggota = mencariAnggota(namaAnggota);
        Buku buku = cariBuku(judulBuku);

        if (anggota == null) {
            System.out.println("Anggota \"" + namaAnggota + "\" tidak ditemukan.");
            return;
        }
        if (buku == null) {
            System.out.println("Buku \"" + judulBuku + "\" tidak ditemukan.");
            return;
        }

        if (anggota.bukudipinjam(buku)) {
            buku.setStatus(true);
            anggota.kembalikanBuku(buku);
            System.out.println("Buku \"" + judulBuku + "\" berhasil dikembalikan oleh " + namaAnggota + ".");
        } else {
            System.out.println("Anggota \"" + namaAnggota + "\" tidak meminjam buku ini.");
        }
    }
    
    public void daftarBukuTersedia() {
        System.out.println("Daftar Buku Tersedia:");
        for (Buku buku : daftarBuku) {
            if (buku.isStatus()) {
                buku.infobuku();
            }else{
                System.out.println("buku sedang dipinjam");
            }
                
        }
    }
    
    private Buku cariBuku(String judul) {
        for (Buku buku : daftarBuku) {
            if (buku.getJudul().equalsIgnoreCase(judul)) {
                return buku;
            }
        }
        return null;
    }
    
     public void tampilkanInfoAnggota(String nama) {
        Anggota anggota = mencariAnggota(nama);
        if (anggota != null) {
            anggota.tampilkanInfoAnggota();
        } else {
            System.out.println("Anggota \"" + nama + "\" tidak ditemukan.");
        }
    }

    private Anggota mencariAnggota(String nama) {
        for (Anggota anggota : daftarAnggota) {
            if (anggota.getNama().equalsIgnoreCase(nama)) {
                return anggota;
            }
        }
        return null;
    }
}
