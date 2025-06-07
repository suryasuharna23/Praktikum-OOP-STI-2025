/**
 * Huawoi.java
 * [Jelaskan kegunaan class ini]
 * 
 * @author 18223075 Surya Suharna
 */

 public class Huawoi extends Handphone {
	private Boolean isKW;

	public Huawoi(Boolean isKW) {
		super("Huawoi", 5000000, 4);
        this.isKW = isKW; 
        if (isKW){
            this.setNama("Huawoi KW");
            this.setHarga(2000000);
            this.setRam(2);
        } 
	}

	@Override
	public Boolean tawar(Integer hargaTawaran) {
        if ((hargaTawaran >= this.getHarga()-1000000) && (hargaTawaran < this.getHarga()) ){
            return true;
        } else {
            return false;
        }
	}

	@Override
	public void printSpeciality() {
        if (isKW){
            System.out.println("HPnya murah bos");
        } else {
            System.out.println("Speknya kenceng bos");
        }
		// Bila isKW = true, Print (tanpa tanda kutip, diakhiri newline) "HPnya murah
		// bos"
		// Bila isKW = false, Print (tanpa tanda kutip, diakhiri newline) "Speknya
		// kenceng bos"
	}
}