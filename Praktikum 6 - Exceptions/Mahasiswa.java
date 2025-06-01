import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Mahasiswa {
    private String nim;
    private String nama;
    private HashMap<String, String> nilai;

    static public ArrayList<String> registeredNim = new ArrayList<>();

    /*
     * Konstruktor objek Mahasiswa
     *
     * Bila NIM sudah ada di dalam daftar registeredNim, maka throw Error
     * NimAlreadyExistsException
     * Hint: - Instatiasi HashMap menggunakan new HashMap<String, String>()
     * - Cara mengecek ada suatu objek ada di dalam ArrayList adalah,
     * arr.contains(obj)
     */
    public Mahasiswa(String nim, String nama) throws NimAlreadyExistsException {
        if (registeredNim.contains(nim)){
            throw new NimAlreadyExistsException();
        }
        this.nim = nim;
        this.nama = nama;
        this.nilai = new HashMap<>();
        registeredNim.add(nim);
    }

    /*
     * Menambahkan nilai matakuliah baru ke daftar nilai Mahasiswa, nilai akan
     * diubah ke indeks kemudian masuk ke daftar nilai
     *
     * Bila nilai yang diberikan kurang dari 0 atau lebih dari 100, maka throw Error
     * InvalidScoreException
     * Bila kode matkul sudah ada di daftar nilai Mahasiswa, maka throw
     * DuplicateSubjectException dengan format "{kode} already in grades!"
     * Hint: Pengecekan key dilakukan dengan menggunakan method containsKey(Object
     * key) pada HashMap
     * Pengecekan value dilakukan dengan menggunakan method containsValue(Object
     * value) pada HashMap
     */
    public void addGrade(String kodeMatkul, Double nilai) throws InvalidScoreException, DuplicateSubjectException {
        if (nilai < 0 || nilai > 100){
            throw new InvalidScoreException();
        }

        if (this.nilai.containsKey(kodeMatkul)){
            throw new DuplicateSubjectException(kodeMatkul + " already in grades!");
        }

        String index = "X";
        if (nilai > 90){
            index = "A";
        } else if (nilai > 70 && nilai <= 90){
            index = "B";
        } else if (nilai > 50 && nilai <= 70) {
            index = "C";
        } else if (nilai > 40 && nilai <= 50){
            index = "D";
        } else {
            index = "E";
        }

        this.nilai.put(kodeMatkul, index);
    }

    /* Getter untuk NIM Mahasiswa */
    public String getNim() {
        return nim;
    }

    /* Getter untuk nama Mahasiswa */
    public String getNama() {
        return nama;
    }

    /* Getter untuk daftar nilai Mahasiswa */
    public Map<String, String> getNilai() {
        return nilai;
    }
}

class NimAlreadyExistsException extends Exception {
    public String getMessage() {
        return "NIM is already registered!";
        // Implementasi custom message NimAlreadyExistsException
        // Return pesan multak berisi: "NIM is already registered!"
    }
}

class InvalidScoreException extends Exception {
    public String getMessage() {
        return "Score cannot be below 0 or above 100!";
        // Implementasi custom message InvalidScoreException
        // Return pesan multak berisi: "Score cannot be below 0 or above 100!"
    }
}

class DuplicateSubjectException extends Exception {
    public DuplicateSubjectException(String message) {
        super(message);
        // Implementasi DuplicateSubjectException
    }
}