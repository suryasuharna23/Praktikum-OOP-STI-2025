import java.util.*;

public class Main {
    /**
     * Mengecek apabila kartu memiliki nilai 10, J, Q, K, A
     * 
     * @param cards
     * @return true apabila kartu memiliki 10 sampai As, false sebaliknya
     */
    public static boolean isRoyal(String[] cards) {
        // Cek paket sama
        char paket = cards[0].charAt(0);
        for (String card : cards) {
            if (card.charAt(0) != paket) return false;
        }
        // Kumpulkan nilai kartu
        Set<Integer> values = new HashSet<>();
        for (String card : cards) {
            values.add(getValueIndex(card.charAt(1)));
        }
        // Royal set: harus ada A, T, J, Q, K => indeks 0,9,10,11,12
        Set<Integer> royalSet = new HashSet<>(Arrays.asList(0,9,10,11,12));
        return values.equals(royalSet);
    }

    /**
     * Mengecek apabila kartu dapat membentuk Full House
     * 
     * @param cards
     * @return true apabila kartu dapat membentuk Full House, false sebaliknya
     */
    public static boolean isFullHouse(String[] cards) {
        int[] freq = new int[13];
        for (String card : cards) {
            int idx = getValueIndex(card.charAt(1));
            freq[idx]++;
        }
        boolean foundThree = false;
        boolean foundTwo = false;
        for (int f : freq) {
            if (f == 3) foundThree = true;
            if (f == 2) foundTwo = true;
        }
        return foundThree && foundTwo;
    }

    /**
     * Mengecek apabila kartu dapat membentuk Flush
     * 
     * @param cards
     * @return true apabila kartu dapat membentuk Flush, false sebaliknya
     */
    public static boolean isFlush(String[] cards) {
        char paket = cards[0].charAt(0);
        for (String card : cards) {
            if (card.charAt(0) != paket) return false;
        }
        return true;
    }

    /**
     * Mengembalikan rangking dari set yang dimiliki dengan rangking berikut:
     * - Royal Flush: 3
     * - Full House: 2
     * - Flush: 1
     * - High Card: 0
     * 
     * @param cards
     * @return rangking
     */
    public static int getSetRanking(String[] cards) {
        if (isRoyal(cards)) return 3;
        else if (isFullHouse(cards)) return 2;
        else if (isFlush(cards)) return 1;
        else return 0;
    }

    // Helper method untuk mapping nilai kartu ke indeks angka
    private static int getValueIndex(char c) {
        switch (c) {
            case 'A': return 0;
            case '2': return 1;
            case '3': return 2;
            case '4': return 3;
            case '5': return 4;
            case '6': return 5;
            case '7': return 6;
            case '8': return 7;
            case '9': return 8;
            case 'T': return 9;
            case 'J': return 10;
            case 'Q': return 11;
            case 'K': return 12;
            default: return -1;
        }
    }

    public static void main(String[] args) {
        String[] cardsTuanBil = new String[5];
        String[] cardsTuanMask = new String[5];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            cardsTuanBil[i] = sc.nextLine().trim();
        }
        for (int i = 0; i < 5; i++) {
            cardsTuanMask[i] = sc.nextLine().trim();
        }
        sc.close();

        int rankBil = getSetRanking(cardsTuanBil);
        int rankMask = getSetRanking(cardsTuanMask);

        if (rankBil > rankMask) {
            System.out.println("Tuan Bil");
            System.out.println(rankBil);
        } else if (rankMask > rankBil) {
            System.out.println("Tuan Mask");
            System.out.println(rankMask);
        } else {
            System.out.println("Seri");
            System.out.println(rankBil);  // rankBil == rankMask
        }
    }
}
