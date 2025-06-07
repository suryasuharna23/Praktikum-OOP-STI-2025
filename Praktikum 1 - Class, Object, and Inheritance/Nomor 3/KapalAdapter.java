/**
 * KapalAdapter.java
 * [Jelaskan kegunaan class ini]
 * 
 * @author 18223075 Surya Suharna
 */

 public class KapalAdapter extends WargaSipil {
    private Kapal kapal;

    public KapalAdapter(Kapal kapal, String namaPemesan) {
        super(namaPemesan);
        this.kapal = kapal;
        // Implementasi sesuai petunjuk soal
    }

    public void urusAdministrasi() {
        kapal.pesanTiket(this.namaPemesan);
        kapal.pilihKamar(this.namaPemesan);
        // Implementasi sesuai petunjuk soal
    }

    public void cobaKabur() {
        kapal.berangkatKePelabuhan(this.namaPemesan);
        kapal.verifikasiTiket(this.namaPemesan);
        // Implementasi sesuai petunjuk soal
    }
    
    public void berhasilKabur() {
        kapal.naikKapal(this.namaPemesan);
        kapal.berlayar();
        // Implementasi sesuai petunjuk soal
    }
}