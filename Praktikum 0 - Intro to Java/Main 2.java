import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nilaiKartu = 0;
        int i = 0;
        while (i < 5){
            int inputKartu = scanner.nextInt();
            nilaiKartu += inputKartu;
            i++;
        }
        int multiple = scanner.nextInt();
        int booster = scanner.nextInt();
        if (booster == 1){
            int result = nilaiKartu * (multiple*2);
            System.out.printf("%d\n",result);
        } else if (booster == 2){
            int result = nilaiKartu * (multiple*3);
            System.out.printf("%d\n",result);
        } else {
            int result = nilaiKartu * multiple;
            System.out.printf("%d\n",result);
        }
        
    }
}