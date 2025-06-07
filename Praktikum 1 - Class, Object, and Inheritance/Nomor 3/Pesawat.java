public class Pesawat {
    private String namaMaskapai;
    private String tujuan;
    private int harga;

    public Pesawat(String namaMaskapai, String tujuan, int harga) {
        this.namaMaskapai = namaMaskapai;
        this.tujuan = tujuan;
        this.harga = harga;
    }

    public void pesanTiket(String namaPemesan) {
        System.out.println(namaPemesan + " berhasil memesan tiket pesawat dengan informasi sebagai berikut:");
        System.out.println("Maskapai: " + namaMaskapai);
        System.out.println("Tujuan: " + tujuan);
        System.out.println("Harga: " + harga);
    }

    public void berangkatKeBandara(String namaPemesan) {
        System.out.println(namaPemesan + " berangkat ke bandara");
    }

    public void checkIn(String namaPemesan) {
        System.out.println(namaPemesan + " melakukan check-in dan mengurus bagasi");
    }

    public void naikPesawat(String namaPemesan) {
        System.out.println(namaPemesan + " naik pesawat dan menunggu pesawat lepas landas");
    }

    public void boarding() {
        System.out.println("Pesawat " + namaMaskapai + " lepas landas menuju " + tujuan);
    }
}