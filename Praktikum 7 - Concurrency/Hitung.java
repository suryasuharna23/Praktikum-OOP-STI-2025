public class Hitung {
    static final int NUM_OF_THREAD = 10;

    public boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Lengkapi method ini untuk mencari bilangan prima dari [0, N]. Wajib menggunakan conccurency!

    // Di dalam method run() dalam runnable sertakan pemanggilan ThreadTracker.mark();
    // Jika tidak, atau jika tidak menggunakan conccurency maka kode akan terus runtime error!

    public int hitungPrima(int N) throws InterruptedException {
        Thread[] threads = new Thread[NUM_OF_THREAD];
        int chunkSize = (int) Math.floor((double) N/NUM_OF_THREAD);
        int[] sums = new int[NUM_OF_THREAD];

        for (int i = 0; i<NUM_OF_THREAD; i++){
            int startIdx;
            int endIdx;

            startIdx = i*chunkSize;
            if (i < NUM_OF_THREAD - 1){
                endIdx = Math.min(startIdx+chunkSize, N);
            } else {
                endIdx = N;
            }

            final int threadIdx = i;
            threads[i] = new Thread(new Runnable() {
                public void run(){
                    ThreadTracker.mark();
                    synchronized(this){
                        for (int j = startIdx; j < endIdx; j++){
                            if (isPrime(j)){
                                sums[threadIdx]++;
                            }
                        }
                    }
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads){
            thread.join();
        }

        int totalSum = 0;
        for (int sum : sums){
            totalSum += sum;
        }

        return totalSum;
    }

}