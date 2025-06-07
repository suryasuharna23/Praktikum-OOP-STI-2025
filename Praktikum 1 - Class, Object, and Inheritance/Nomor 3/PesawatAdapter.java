/**
 * PesawatAdapter.java
 * [Jelaskan kegunaan class ini]
 * 
 * @author 18223075 Surya Suharna
 */

 public class PesawatAdapter extends WargaSipil {
    private Pesawat pesawat;

    public PesawatAdapter(Pesawat pesawat, String namaPemesan) {
        super(namaPemesan);
        this.pesawat = pesawat;
        // Implementasi sesuai petunjuk soal
    }

    public void urusAdministrasi() {
        pesawat.pesanTiket(this.namaPemesan);
        // Implementasi sesuai petunjuk soal
    }

    public void cobaKabur() {
        pesawat.berangkatKeBandara(this.namaPemesan);
        pesawat.checkIn(this.namaPemesan);
        // Implementasi sesuai petunjuk soal
    }
    
    public void berhasilKabur() {
        pesawat.naikPesawat(this.namaPemesan);
        pesawat.boarding();
        // Implementasi sesuai petunjuk soal
    }
}