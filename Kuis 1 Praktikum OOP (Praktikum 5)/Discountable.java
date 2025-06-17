/**
 * Discountable.java
 *
 * Interface yang mendefinisikan metode negosiasi harga untuk sebuah Bike.
 */
public interface Discountable {
    /**
     * Menentukan apakah sepeda menerima tawaran harga.
     *
     * @param yourOffer tawaran harga sebagai Number
     * @return true jika sepeda menerima tawaran tersebut, false jika tidak
     */
    boolean discountOffer(Number yourOffer);
}
