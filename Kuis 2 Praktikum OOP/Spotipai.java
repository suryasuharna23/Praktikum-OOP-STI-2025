import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue; 

public class Spotipai {
    private List<Song> daftarLagu; // pustaka lagu yang tersedia
    private Queue<Song> queue;     // Antrian lagu
    private Song nowPlaying;       // Lagu yang sedang diputar

    public Spotipai() {
        this.daftarLagu = new ArrayList<>();
        this.queue = new LinkedList<>();
        this.nowPlaying = null;
        // tulis constructor untuk menginisialisasi daftarLagu, queue, dan nowPlaying
    }

    public static class Song {
        private String title;
        private String artist;
        private int duration; // in seconds

        public Song(String title, String artist, int duration) {
            this.title = title;
            this.artist = artist;
            this.duration = duration;
            // tulis constructor untuk menginisialisasi title, artist, dan duration
        }

        public String getTitle() {
            return title;
            // isi di sini
        }

        public String getArtist() {
            return artist;
            // isi di sini
        }

        public int getDuration() {
            return duration;
            // isi di sini
        }

        @Override
        public String toString() { 
            return (String.format("'%s' oleh %s (%d detik)", this.getTitle(), this.getArtist(), this.getDuration()));
            // tulis representasi string dari lagu dengan format "'[judul]' oleh [artis] ([durasi] detik)"
            // contoh "'Mangu' oleh Fourtwnty (240 detik)"
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) { 
                return false;
            }
            Song songLain = (Song) o;
            return this.duration == songLain.duration &&
                   Objects.equals(this.title, songLain.title) && 
                   Objects.equals(this.artist, songLain.artist);
            // implementasi equals method dengan membandingkan title, artist, dan duration.
            // untuk check apakah object merupakan class Song, gunakan method getClass() untuk mendapatkan class dari object tersebut.
        }

        @Override
        public int hashCode() {
            return Objects.hash(title, artist, duration);
        }
    }

    /**
     * Menambahkan lagu ke dalam library.
     * Jika lagu yang ditambahkan tidak valid (null), cetak "Masukan tidak valid."
     * Tambahkan lagu ke daftarLagu, lalu cetak pesan "Ditambahkan ke pustaka: [lagu]"
     */
    public void addSongToLibrary(Song song) {
        if (song == null){
            System.out.println("Masukan tidak valid.");
        } else {
            daftarLagu.add(song);
            System.out.println("Ditambahkan ke pustaka: "+ song);   
        }
    }

    /**
     * Memainkan atau mengantri lagu.
     * Jika input tidak valid (null), cetak "Masukan tidak valid."
     * Jika lagu tidak ada di daftar lagu, cetak "[lagu] tidak ditemukan di pustaka. Tolong tambahkan dulu ke pustaka."
     * Jika berhasil, tambahkan lagu ke queue dan cetak "Ditambahkan ke antrian: [lagu]".
     * Putar lagu selanjutnya jika tidak ada lagu yang sedang dimainkan.
     */
    public void playOrQueueSong(Song song) {
        if (song == null) {
            System.out.println("Masukan tidak valid.");
        } else if (!daftarLagu.contains(song)) {
            System.out.println(song + " tidak ditemukan di pustaka. Tolong tambahkan dulu ke pustaka.");
        } else {
            queue.add(song); 
            System.out.println("Ditambahkan ke antrian: " + song);
            if (nowPlaying == null) { 
                playNext();         
            }
        }
    }

    /**
     * Memainkan lagu selanjutnya dari antrian.
     * Mainkan lagu dari antrian jika ada, lalu cetak "Sekarang memutar: [lagu]".
     * JIka antrian ada, dan sedang ada lagu yang sedang dimainkan, cetak "Selesai memutar: [lagu]. Antrian kosong. Pemutaran dihentikan.",
     * jika antrian kosong dan tidak ada lagu yang sedang dimainkan, cetak "Antrian kosong. Tidak ada yang diputar."
     * */
    public void playNext() {
        Song previouslyPlaying = this.nowPlaying; 

        if (!queue.isEmpty()) {
            this.nowPlaying = queue.poll(); 
            if (previouslyPlaying != null) {
                System.out.println("Selesai memutar: " + previouslyPlaying + ".");
            }
            System.out.println("Sekarang memutar: " + this.nowPlaying);
        } else { 
            if (previouslyPlaying != null) { 
                System.out.println("Selesai memutar: " + previouslyPlaying + ". Antrian kosong. Pemutaran dihentikan.");
                this.nowPlaying = null; 
            } else { 
                System.out.println("Antrian kosong. Tidak ada yang diputar.");
            }
        }
    }

    /**
     * Menunjukkan isi antrian lagu.
     * Jika antrian kosong, cetak "Antrian kosong."
     * Jika ada lagu dalam antrian, cetak daftar lagu dan pisahkan antara satu lagu dengan yang lainnya pada baris berbeda. tulis dengan format:
     * 1. [lagu]
     * 2. [lagu]
     * dst.
     * */
    public void showQueue() {
        if (queue.isEmpty()){
            System.out.println("Antrian kosong.");
        } else {
            int i = 1;
            for (Song s : queue){
                System.out.println(i+". "+s);
                i++;
            }
        }
        // isi di sini
    }

    /**
     * Hapus lagu tertentu dari antrian.
     * Jika input tidak valid (null), cetak "Masukan tidak valid."
     * Jika lagu tidak ada di antrian, cetak "[lagu] tidak ditemukan di antrian."
     * Jika berhasil, hapus lagu dari antrian dan cetak "Menghapus [lagu] dari antrian".
     */
    public void removeFromQueue(Song song) {
        if (song == null){
            System.out.println("Masukan tidak valid.");
        } else if (!queue.contains(song)){
            System.out.println(song+" tidak ditemukan di antrian.");
        } else {
            queue.remove(song);
            System.out.println("Menghapus "+song+" dari antrian");
        }
    }

    /**
     * Memberhentikan lagu yang sedang dimainkan.
     * Jika ada lagu yang sedang dimainkan, cetak "Berhenti memutar: [lagu]".
     * Jika tidak ada lagu yang sedang dimainkan, cetak "Tidak ada lagu yang sedang diputar."
     */
    public void stopSong() {
        if (nowPlaying != null){
            System.out.println("Berhenti memutar: "+nowPlaying);
            this.nowPlaying = null;
        } else {
            System.out.println("Tidak ada lagu yang sedang diputar.");
        }
    }

    /**
     * Menunjukkan lagu yang sedang diputar.
     * Jika ada lagu yang sedang diputar, cetak "Sedang memutar: [lagu]".
     * Jika tidak ada lagu yang sedang diputar, cetak "Tidak ada lagu yang sedang diputar."
     */
    public void showNowPlaying() {
        if (nowPlaying != null){
            System.out.println("Sedang memutar: "+nowPlaying);
        } else {
            System.out.println("Tidak ada lagu yang sedang diputar.");
        }
    }

    /**
     * Menampilkan semua lagu yang ada di pustaka.
     * Jika kosong, cetak "Tidak ada lagu di dalam pustaka."
     * Jika ada, cetak daftar lagu dengan format:
     * "- [lagu]"
     * "- [lagu]"
     * dst.
     */
    public void showAllSongsInLibrary() {
        if (daftarLagu.isEmpty()){ // Perbaikan: Gunakan isEmpty()
            System.out.println("Tidak ada lagu di dalam pustaka.");
        } else {
            for (Song s : daftarLagu){
                System.out.println("- "+s);
            }
        }
    }

    /**
     * Hapus sebuah lagu dari pustaka. Asumsikan bahwa pustaka lagu bersifat unik.
     * Jika input tidak valid (null), cetak "Masukan tidak valid."
     * Jika lagu tidak ada di pustaka, cetak "[lagu] tidak ditemukan di pustaka."
     * Jika berhasil, hapus lagu dari pustaka dan cetak "Menghapus [lagu] dari pustaka."
     * Jika lagu yang dihapus adalah lagu yang sedang diputar, hentikan pemutaran lagu tersebut dan cetak "[lagu] sedang diputar. Dihentikan."
     */
    public void removeSongFromLibrary(Song song) {
        if (song == null) {
            System.out.println("Masukan tidak valid.");
        } else if (!daftarLagu.contains(song)) {
            System.out.println(song + " tidak ditemukan di pustaka.");
        } else {
            boolean wasPlaying = song.equals(nowPlaying);
            
            daftarLagu.remove(song); // Hapus dari pustaka
            System.out.println("Menghapus " + song + " dari pustaka."); // Cetak pesan penghapusan dari pustaka

            if (wasPlaying) {
                this.nowPlaying = null; // Hentikan pemutaran secara internal
                System.out.println(song + " sedang diputar. Dihentikan."); // Pesan spesifik jika sedang diputar
            }
            // Pertimbangkan jika lagu juga perlu dihapus dari antrian
            // if (queue.contains(song)) {
            //     queue.remove(song);
            //     System.out.println("Juga menghapus " + song + " dari antrian.");
            // }
        }
    }
}