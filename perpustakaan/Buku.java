package perpustakaan;

class Buku {
    String judul;
    private String pengarang;
    private int tahunterbit;
    private String ISBN;
    boolean status;

    public Buku(String judul, String pengarang, int tahunterbit, String ISBN, boolean status) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunterbit = tahunterbit;
        this.ISBN = ISBN;
        this.status = status;
    }
    public void infobuku() {
        System.out.println("Judul: " + judul);
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Tahun Terbit: " + tahunterbit);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Status: " + (status ? "belum dipinjam" : "sudah Dipinjam"));
    }
    public String getJudul() {
        return judul;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    void infoBuku() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

