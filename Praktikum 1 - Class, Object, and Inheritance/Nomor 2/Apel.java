/**
 * Apel.java
 * [Jelaskan kegunaan class ini]
 * 
 * @author 18223075 Surya Suharna
 */

 public class Apel extends Handphone {
	public Apel() {
        super("Apel", 10000000, 6);
		// Sesuai dengan Soal
	}

	@Override
	public Boolean tawar(Integer hargaTawaran) {
		return false; // karena gabisa ditawar
	}

	@Override
	public void printSpeciality() {
        System.out.println("Stylish nih bos");
		// Print (tanpa tanda kutip, diakhiri newline):
		// "Stylish nih bos"
	}
}