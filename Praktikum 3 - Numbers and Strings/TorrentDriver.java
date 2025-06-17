// Author: Surya Suharna 18223075

import java.util.Scanner;

public class TorrentDriver {

    private static void printSeparator() {
        System.out.println("------------");
    }

    /**
     * method helper untuk mencetak elemen array
     * @param array
     */
    private static void printArrayElements(Object[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(String.format("%s, ", array[i]));
        }
        if (array.length > 0) {
            System.out.println(array[array.length - 1]);
        }
    }

        /**
     * method helper untuk mencetak elemen array
     * @param array
     */
    private static void printArrayElements(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(String.format("%d, ", array[i]));
        }
        if (array.length > 0) {
            System.out.println(array[array.length - 1]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // String fileName = scanner.nextLine();

        String fileName=scanner.nextLine();
        int banyak_peers=Integer.parseInt(scanner.nextLine());
        
        TorrentPeer[] peers = new TorrentPeer[banyak_peers];
        for (int i=0;i<banyak_peers;i++) {
            String[] chunkStrings = scanner.nextLine().split(" ");
            int[] chunks = new int[chunkStrings.length];
            for (int j = 0; j < chunkStrings.length; j++) {
                chunks[j] = Integer.parseInt(chunkStrings[j]);
            }
            peers[i] = new TorrentPeer("Peer" + (i+1), chunks);
        }
        scanner.close();
        
        for (TorrentPeer peer:peers) {
            System.out.print(peer.name +" memiliki chunk: ");
            printArrayElements(peer.chunks);
        }

        printSeparator();
        
        boolean[] unik_chunks = new boolean[100];
        int[] urutan_download = new int[100];
        int count = 0;

        for (TorrentPeer peer : peers) {
            for (int chunk:peer.chunks) {
                if (!unik_chunks[chunk]) {
                    unik_chunks[chunk] = true;
                    urutan_download[count] = chunk;
                    count++;
                }
            }
        }
        
        for (int i=0; i<count - 1; i++) {
            for (int j=0;j<count-i-1; j++) {
                if (urutan_download[j]>urutan_download[j+ 1]) {
                    int temp=urutan_download[j];
                    urutan_download[j] = urutan_download[j + 1];
                    urutan_download[j + 1] = temp;
                }
            }
        }

        String isi_file = "";
        for (int i = 0; i<count; i++) {
            int chunk = urutan_download[i];
            for (TorrentPeer peer : peers) {
                if (peer.hasChunk(chunk)) {
                    System.out.println("Mengunduh chunk " + chunk+" dari " + peer.name+ "...");
                    isi_file +="[Chunk-" + chunk + "]";
                    break;
                }
            }
        }
        
        printSeparator();
        System.out.println("Semua chunk berhasil diunduh!");
        System.out.println("Menyusun kembali file...");
        System.out.println("File " + fileName + " berhasil direkonstruksi dari " + count + " chunk.");
        System.out.println("Isi rekontruksi file: " + isi_file);
    }
        /*
        * Kalian bisa mencoba menggunakan pendekatan kalian sendiri, petunjuk di bawah
        merupakan salah satu pendekatan yang dapat kalian ikuti.

         * Tahap 1
         * Hal yang perlu dilakukan yaitu:
         * Mengambil input nama file dan jumlah peer
         * 
         * TIPS: disarankan menggunakan Integer.parseInt(myScanner.nextLine()) untuk mengambil nilai input Integer 
         * secara aman dan mengurangi error atau masalah yang terjadi saat pembacaan input.
         */

        /*
         *  Tahap 2
         *  Hal yang perlu dilakukan yaitu:
         *  - Mengambil input konten masing-masing peer
         *  - masing-masing peer memiliki atribut nama dengan format nama "PeerX" dengan X merupakan
         *  bilangan integer
         * 
         *  Contoh input jika kalian mengatur jumlah peer nya 4 adalah sebagai berikut:
         *  2 3 1 4
            5 9 6 7
            1 8
            7 5 2
         * 
         *  Masukkan input-input tersebut ke dalam array of TorrentPeer. untuk instansiasinya
         *  bisa mengikuti konstruktor yang telah disediakan
         * 
         *  TIPS: gunakan method split(separator) pada kelas String untuk men-split string menjadi array dengan
         *  pembagi elemen sesuai dengan input separator
         *  Contoh:
         *      String inputSaya = "1 2 3 4";
         *      String[] inputSplit = inputSaya.split(" ");  // inputSplit = ["1", "2", "3", "4"]
         * 
         *      // ubah semua elemennya menjadi integer
         *      int[] inputInteger = new int[inputSplit.length];
         *      for (int i = 0; i < inputSplit.length < i++) {
         *          inputInteger[i] = Integer.parseInt(inputSplit[i]);
         *      }
         */

         /*
          * Tahap 3
            Hal yang perlu diperhatikan yaitu:
            - Masukkan chunk-chunk ke dalam sebuah array yang berisi chunk-chunk unik. misalnya pada contoh yang diberikan,
            terdapat total 13 chunk yang dimiliki oleh 4 peer, namun total chunk unik keseluruhannya adalah 9
            - array chunk unik tersebut nantinya akan digunakan untuk mengunduh secara urut chunk-chunk tersebut sehingga
            menghasilkan hasil rekonstruksi file yang valid
            - Kalian juga perlu men-track jumlah chunk unik yang ada karena diperlukan juga pada salah satu print statement
            
            CATATAN:
            berdasarkan catatan dari deskripsi soal, maksimal jumlah chunk unik yang dimiliki oleh seluruh peer yaitu
            100. untuk itu, kalian bisa membuat set sederhana menggunakan array of boolean dengan indeks array sebagai key
            dari chunk kalian.

                boolean[] unik_chunks = new boolean[100];
            
            TIPS:
            - Untuk mengecek duplikasi, kalian bisa mengecek apakah unik_chunks[key] true atau false
          */ 

          // Tahap 4
          // Menggunakan String biasa untuk rekonstruksi file
          // Alih-alih StringBuilder, kita menambahkan string langsung menggunakan operator "+"
          //
          // Contoh:
          //    String text = "Hello";
          //    text = text + " World!";
          //    System.out.println(text); // output: "Hello World!"

          /*
           * Catatan tambahan:
           * - Pada contoh output yang diberikan pada deskripsi soal, terdapat
           *  output "------------" yang merupakan separator.
           * - Gunakan method static printSeparator() untuk mencetak separator tersebut pada output
           * - Kalian bebas menggunakan method helper yang telah disediakan dalam pengerjaan soal
           * - Jangan lupa close scannernya untuk mencegah resource/memory leak
           */
}
