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
        System.out.println("berhasil menambahkan buku baru");
    }

    public void tambahAnggota(Anggota anggota) {
        daftarAnggota.add(anggota);
        System.out.println("Anggota sudah berhasil didaftarkan.");
    }

    public void minjamBuku(String namaAnggota, String judul) {
        Anggota anggota = mencariAnggota(namaAnggota);
        Buku buku = cariBuku(judul);

        if (anggota == null) {
            System.out.println("tidak ditemukan anggota dengan nama " + namaAnggota);
            return;
        }
        if (buku == null) {
            System.out.println("tidak ada buku dengan judul " + judul);
            return;
        }

        if (buku.isStatus()) {
            buku.setStatus(false);
            anggota.pinjamBuku(buku);
            System.out.println("Buku " + judul + " berhasil dipinjam oleh " + namaAnggota);
        } else {
            System.out.println("bukunya udah dipinjam ya ");
        }
    }

    public void kembalikanBuku(String namaAnggota, String judulBuku) {
        Anggota anggota = mencariAnggota(namaAnggota);
        Buku buku = cariBuku(judulBuku);

        if (anggota == null) {
            System.out.println("salah nama kayaknya");
            return;
        }
        if (buku == null) {
            System.out.println("tidak ada buku yang berjudul itu");
            return;
        }

        if (anggota.bukudipinjam(buku)) {
            buku.setStatus(true);
            anggota.kembalikanBuku(buku);
            System.out.println("Buku sudah dikembalikan");
        } else {
            System.out.println("Dia tidak meminjam buku itu");
        }
    }
    
    public void daftarBukuTersedia() {
        System.out.println("buku yang tersedia:");
        for (Buku buku : daftarBuku) {
            if (buku.isStatus()) {
                buku.infobuku();
                System.out.println("buku masih ada di perpustakaan");
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
            System.out.println("dia tidak ditemukan atau belum terdaftar");
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
