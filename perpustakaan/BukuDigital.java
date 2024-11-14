package perpustakaan;


public class BukuDigital extends Buku {
    private String bentukfile;
    private int kode;
    
public BukuDigital(String judul, String pengarang, int tahunTerbit, String ISBN, String bentukfile, int kode) {
        super(judul, pengarang, tahunTerbit, ISBN, true);
        this.bentukfile = bentukfile;
        this.kode = kode;   
    }


    @Override
    public void infobuku() {
        super.infobuku();
        System.out.println("format file : " + bentukfile);
        System.out.println("dengan kode " + kode);
        
    }
}
