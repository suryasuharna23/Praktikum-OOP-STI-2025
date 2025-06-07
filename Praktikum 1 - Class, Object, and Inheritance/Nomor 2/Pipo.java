/**
 * Pipo.java
 * [Jelaskan kegunaan class ini]
 * 
 * @author 18223075 Surya Suharna
 */

 public class Pipo extends Handphone {
	private String camera;

	public Pipo(String camera) {
        super("Pipo", 3000000, 3);
        this.camera = camera;
		// Sesuai dengan Soal
	}

	@Override
	public Boolean tawar(Integer hargaTawaran) {
        if (hargaTawaran >= 2500000){
            return true;
        } else {
            return false;
        }
		// Sesuai dengan soal
	}

	@Override
	public void printSpeciality() {
        System.out.println("Kamera ni HP "+camera);
		// Print (tanpa tanda kutip, diakhiri newline):
		// "Kamera ni HP " + camera
	}
}