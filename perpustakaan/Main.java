package perpustakaan;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Perpustakaan perpustakaan = new Perpustakaan();
        boolean pilih = true;

        while (pilih) {
            System.out.println("\n====silahkan pilih====");
            System.out.println("1. Tambah Buku Baru");
            System.out.println("2. Tambah Anggota Baru");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Kembalikan Buku");
            System.out.println("5. Daftar Buku Tersedia");
            System.out.println("6. Tampilkan Informasi Anggota");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scan.nextInt();
            scan.nextLine();  
            
            //menambahkan buku baru
            switch (pilihan) {
                case 1:
                    System.out.println("=====================");
                    System.out.println("Pilih jenis buku:");
                    System.out.println("1. Buku Biasa");
                    System.out.println("2. Buku Digital");
                    System.out.print("masukkan pilihan anda: ");
                    int pilihJenis = scan.nextInt();
                    scan.nextLine();  // Membersihkan buffer newline

                    switch (pilihJenis) {
                        case 1:
                            // Tambah Buku Biasa
                            System.out.print("Masukkan judul buku: ");
                            String judul = scan.nextLine();
                            System.out.print("Masukkan nama pengarang: ");
                            String pengarang = scan.nextLine();
                            System.out.print("Masukkan tahun terbit: ");
                            int tahunTerbit = scan.nextInt();
                            scan.nextLine();  // Membersihkan buffer newline
                            System.out.print("Masukkan ISBN: ");
                            String ISBN = scan.nextLine();
                            
                            Buku bukuBaru = new Buku(judul, pengarang, tahunTerbit, ISBN, true);
                            perpustakaan.tambahBukubaru(bukuBaru);
                            break;

                        case 2:
                            // Tambah Buku Digital
                            System.out.print("Masukkan judul buku: ");
                            judul = scan.nextLine();
                            System.out.print("Masukkan nama pengarang: ");
                            pengarang = scan.nextLine();
                            System.out.print("Masukkan tahun terbit: ");
                            tahunTerbit = scan.nextInt();
                            scan.nextLine();  
                            System.out.print("Masukkan ISBN: ");
                            ISBN = scan.nextLine();
                            System.out.print("Masukkan jenis file yang anda ingin masukkan: ");
                            String bentukfile = scan.nextLine();
                            System.out.print("Masukkan kode dari file tersebut1"
                                    + ": ");
                            int kode = scan.nextInt();
                            scan.nextLine(); 
                            
                            BukuDigital bukudigitalBaru = new BukuDigital(judul, pengarang, tahunTerbit, ISBN, bentukfile, kode);
                            perpustakaan.tambahBukubaru(bukudigitalBaru);
                            break;

                        default:
                            System.out.println("Jenis buku tidak valid. Silakan coba lagi.");
                            break;
                    }
                    break;

                case 2:
                    // menambahkan Anggota
                    System.out.println("=====================");
                    System.out.print("Masukkan nama anggota: ");
                    String nama = scan.nextLine();
                    System.out.print("Masukkan nomor anggota: ");
                    String nomorAnggota = scan.nextLine();
                    System.out.print("Masukkan alamat anggota: ");
                    String alamat = scan.nextLine();

                    Anggota anggotaBaru = new Anggota(nama, nomorAnggota, alamat);
                    perpustakaan.tambahAnggota(anggotaBaru);
                    break;

                case 3:
                    // meminjam Buku
                    System.out.println("=====================");
                    System.out.print("Masukkan nama anggota yang ingin meminjam buku: ");
                    String namaPeminjam = scan.nextLine();
                    System.out.print("Masukkan judul buku yang ingin dipinjam: ");
                    String judulPinjam = scan.nextLine();

                    perpustakaan.minjamBuku(namaPeminjam, judulPinjam);
                    break;

                case 4:
                    // mengembalikan Buku
                    System.out.println("=====================");
                    System.out.print("Masukkan nama anggota yang ingin mengembalikan buku: ");
                    String namaPengembali = scan.nextLine();
                    System.out.print("Masukkan judul buku yang ingin dikembalikan: ");
                    String judulKembali = scan.nextLine();

                    perpustakaan.kembalikanBuku(namaPengembali, judulKembali);
                    break;

                case 5:
                    System.out.println("=====================");
                    perpustakaan.daftarBukuTersedia();
                    break;

                case 6:
                    // mencari Informasi Anggota
                    System.out.println("=====================");
                    System.out.print("Masukkan nama anggota yang ingin dicari: ");
                    String namaAnggotaInfo = scan.nextLine();
                    perpustakaan.tampilkanInfoAnggota(namaAnggotaInfo);
                    break;

                case 7:
                    pilih = false;
                    System.out.println("Terima kasih banyak, semoga harimu menyenangkan.");
                    break;

                default:
                    System.out.println("Pilihan anda tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }
}
