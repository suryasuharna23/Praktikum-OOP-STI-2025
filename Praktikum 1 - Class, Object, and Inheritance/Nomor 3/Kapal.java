public class Kapal {
    private String namaKapal;
    private String tujuan;
    private int harga;

    public Kapal(String namaKapal, String tujuan, int harga) {
        this.namaKapal = namaKapal;
        this.tujuan = tujuan;
        this.harga = harga;
    }

    public void pesanTiket(String namaPemesan) {
        System.out.println(namaPemesan + " berhasil memesan tiket kapal dengan informasi sebagai berikut:");
        System.out.println("Nama Kapal: " + namaKapal);
        System.out.println("Tujuan: " + tujuan);
        System.out.println("Harga: " + harga);
    }

    public void pilihKamar(String namaPemesan) {
        System.out.println(namaPemesan + " memilih kamar di kapal");
    }

    public void berangkatKePelabuhan(String namaPemesan) {
        System.out.println(namaPemesan + " berangkat menuju pelabuhan");
    }

    public void verifikasiTiket(String namaPemesan) {
        System.out.println(namaPemesan + " melakukan verifikasi tiket");
    }

    public void naikKapal(String namaPemesan) {
        System.out.println(namaPemesan + " menaiki kapal " + namaKapal);
    }

    public void berlayar() {
        System.out.println(namaKapal + " berlayar menuju " + tujuan);
    }
}