
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GuildAccount {
    private final StringBuilder logBuilder; // untuk mencatat log yang masuk
    private final Lock lock; // lock untuk menghandle concurrency
    private int balance; // saldo kas guild
    

    public GuildAccount(int initialBalance) {
        this.balance = initialBalance;
        lock = new ReentrantLock();
        logBuilder = new StringBuilder();
        // - lengkapi konstruktor nya
        // - Catatan: selalu ingat untuk instansiasi semua objek pada atribut kelas ini
        // - untuk lock yang digunakan, gunakan ReentrantLock dari package java.util.concurrent.locks

    }

    /**
     * Melakukan deposit sejumlah uang ke kas guild.
     * 1. Jika jumlah uang yang didepositkan tidak valid (amount <= 0):
     *      - lempar FailedTransactionException dengan pesan "Nilai yang di-depositkan tidak boleh 0 atau negatif"
     *      - masukkan ke dalam log dengan entri log "[Nama adventurer] mencoba men-deposit, tetapi gagal karena jumlahnya tidak valid."
     * 2. Jika jumlahnya valid:
     *      - masukkan ke dalam log dengan entri log "[Nama adventurer] men-depositkan uang sejumlah [amount] ke kas. Saldo lama: [saldo lama], Saldo baru: [Saldo baru setelah deposit]."
     *      - contoh log nya yaitu "Ep men-depositkan uang sejumlah 3500 ke kas. Saldo lama: 6000, Saldo baru: 9500."
     * 3. Pastikan concurrency control dengan menggunakan lock, perhatikan juga bagaimana mengunci dan membuka lock agar tidak terjadi deadlock
     */
    public void deposit(Adventurer sender, int amount) throws FailedTransactionException{
        synchronized(lock){
            if (amount <= 0){
                this.log(sender.getName() + " mencoba men-deposit, tetapi gagal karena jumlahnya tidak valid.");
                throw new FailedTransactionException("Nilai yang di-depositkan tidak boleh 0 atau negatif");
            } else {
                int saldolama = getBalance();
                this.balance += amount;
                this.log(sender.getName() + " men-depositkan uang sejumlah "+amount+" ke kas. Saldo lama: "+saldolama+", Saldo baru: "+this.getBalance()+".");
            }
        }
        // Lengkapi kodenya di bawah ini
    }

    /**
     * Menarik sejumlah uang dari kas yang digunakan untuk keperluan tertentu
     * 1. Jika jumlah uang yang didepositkan tidak valid (amount <= 0):
     *      - lempar FailedTransactionException dengan pesan "Nilai yang ditarik tidak boleh 0 atau negatif"
     *      - masukkan ke dalam log dengan entri log "[Nama adventurer] mencoba menarik uang dari kas, tetapi gagal karena jumlahnya tidak valid."
     * 2. Jika saldo kurang:
     *      - masukkan ke dalam log dengan entri log "[Nama adventurer] mencoba menarik uang dari kas, tetapi gagal karena saldonya tidak cukup."
     *      - lempar FailedTransactionException dengan pesan "Saldo tidak cukup"
     * 3. Jika jumlahnya valid:
     *      - masukkan ke dalam log dengan entri log "[Nama adventurer] menarik uang sejumlah [amount] dari kas untuk [purpose]. Saldo lama: [saldo lama], Saldo baru: [Saldo baru setelah withdrawal]."
     *      - contoh log nya yaitu "Han menarik uang sejumlah 5000 dari kas untuk membeli pedang baru. Saldo lama: 10000, Saldo baru: 5000."
     * 4. Pastikan concurrency control dengan menggunakan lock, perhatikan juga bagaimana mengunci dan membuka lock agar tidak terjadi deadlock
     */
    public void withdraw(Adventurer withdrawer, int amount, String purpose) throws FailedTransactionException {
        synchronized(lock){
            if (amount <= 0){
                this.log(withdrawer.getName() + " mencoba menarik uang dari kas, tetapi gagal karena jumlahnya tidak valid.");
                throw new FailedTransactionException("Nilai yang ditarik tidak boleh 0 atau negatif");
            } else if (balance < amount){
                this.log(withdrawer.getName() + " mencoba menarik uang dari kas, tetapi gagal karena saldonya tidak cukup.");
                throw new FailedTransactionException("Saldo tidak cukup");
            } else {
                int saldolama = getBalance();
                this.balance -= amount;
                this.log(withdrawer.getName() + " menarik uang sejumlah "+amount+" dari kas untuk "+purpose+". Saldo lama: "+saldolama+", Saldo baru: "+this.getBalance()+".");
            }
        }
        // Lengkapi kodenya di bawah ini
    }

    /**
     * Memasukkan log ke dalam akun guild.
     * setiap entry baru harus ditandai dengan new line untuk memisahkan line pada log.
     * untuk menambahkan String baru ke dalam string builder, gunakan method append()
     */
    private void log(String entry) {
        logBuilder.append(entry);
        logBuilder.append("\n");
        // Lengkapi kodenya di bawah ini
    }
    /**
     * Mengambil nilai saldo pada kas.
     * Pastikan concurrency control dengan menggunakan lock
     */
    public int getBalance() {
        synchronized(lock){
        return balance;
        // isi di sini
        }
    }

    /**
     * Melihat log pada kas.
     * Pastikan concurrency control dengan menggunakan lock
     * Gunakan method toString() untuk mendapatkan String dari StringBuilder
     */
    public String getLog() {
        synchronized(lock){
        return logBuilder.toString();
        }
    }
}
