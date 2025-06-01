import java.util.List;
import java.util.function.BinaryOperator;

public class Fold {
    /**
     * Menggabungkan seluruh elemen dalam daftar menjadi satu nilai dengan menerapkan operasi BinaryOperator secara berurutan.
     *
     * Metode ini menggunakan elemen pertama dalam daftar sebagai nilai awal,
     * lalu menerapkan operator secara berurutan dari kiri ke kanan untuk menggabungkan seluruh elemen
     *
     *
     * @param <T>       tipe data elemen dalam daftar
     * @param list      daftar elemen yang akan digabungkan; PASTI tidak null atau kosong
     * @param operator  BinaryOperator yang mendefinisikan bagaimana dua elemen digabungkan, 
     *                  dapat digunakan sebagai fungsi dengan memanggil operator.apply(param1, param2)
     * @return          hasil akhir setelah seluruh elemen digabungkan
     */
    public static <T> T reduce(List<T> list, BinaryOperator<T> operator) {
        T result = list.get(0);

        for (int i = 1; i < list.size(); i++){
            result = operator.apply(result, list.get(i));
        }
        return result;
    }

    /* CONTOH CARA PEMANGGILAN: sum
     * 
     * List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
     * int result = Fold.reduce(list, (a, b) -> a+b) 
     *                              // ^^^^^^^^^^^^ fungsi (BinaryOperator) yang menerima dua bilangan 
     *                              //              a dan b kemudian mengembalikan jumlahnya
     * 
     * System.out.println(result); // mencetak 15
     */
}