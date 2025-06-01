public class SimpleWordCountServer {
    private int nWorkers;

    /**
     * Constructor untuk simple word count server
     * 
     * @param nWorkers jumlah maximum threads yang tersedia pada server a.k.a thread
     *                 pool
     */
    public SimpleWordCountServer(int nWorkers) {
        this.nWorkers = nWorkers;
    }

    /**
     * Ikuti instruksi yang ada di deskripsi soal ya!
     * 1. processRequests akan membuat threads dan memetakan elemen-elemen requests
     * kepada threads tersebut
     * 2. setiap thread kemudian memanggil method countWords
     * 3. main thread (thread yang invoked method ini) akan menunggu semua thread
     * selesai
     * 4. terakhir main thread akan mengembalikan hasil penghitungan kata untuk
     * setiap elemen requests
     * 
     * @param requests array kalimat yang dikirimkan client
     */
    public Integer[] processRequests(String[] requests) throws InterruptedException {
        Integer[] wordCounts = new Integer[requests.length];
        Thread[] threads = new Thread[nWorkers];
        for (int i = 0; i < nWorkers; i++) {
            final int temp = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = temp; j < requests.length; j += nWorkers) {
                        wordCounts[j] = countWords(requests[j]);
                    }
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            if (thread != null)
                thread.join();
        }
        return wordCounts;
    }

    /**
     * countWords adalah metode yang mengembalikkan jumlah kata dalam suatu kalimat
     * HINT : beberapa fungsi yang berguna :
     * - trim() : menghilangkan trailing / leading white space
     * - isWhiteSpace() : cek apakah suatu karakter merupakan white space (tab,
     * space atau newline)
     * - isEmpty() : cek apakah suatu string kosong ("") atau tidak
     * seluruh fungsi diatas dapat dipakai dengan namaVariabelString.namaFungsi()
     * misalnya :
     * String s1 = "tomoro"
     * s1.isEmpty() -> akan menghasilkan nilai false
     * - charAt(i) : memberikan karakter pada indeks i.
     * Cara pemakaiannya string.charAt(i) dengan i sebagai indeks.
     * 
     * HINT 2 : Coba iterasi perkarakter di string kalian dan gunakan whitespace
     * sebagai patokan akhir kalimat :D
     * 
     * @param request kalimat yang dikirimkan client
     */
    protected int countWords(String request) {
        request = request.trim();
        if (request.length() == 0)
            return 0;
        else {
            int sum = 1;
            for (int i = 1; i < request.length(); i++) {
                if (request.charAt(i) == ' ' && request.charAt(i - 1) != ' ')
                    sum++;
            }
            return sum;
        }
    }
}
