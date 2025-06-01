import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i<n; i++){
            String perintah = scanner.nextLine();
            if (perintah.startsWith("tambah")){
                String[] bagian = perintah.split(" ");
                String nama = bagian[1];
                stack.push(nama);
                System.out.println("sudah menambahkan "+nama);
            } else if (perintah.equals("beli")){
                if (stack.isEmpty()){
                    System.out.println("maaf stock habis");
                } else {
                    String buyed = stack.pop();
                    System.out.println("telah membeli "+ buyed);
                }
            } else if (perintah.equals("lihat")){
                if (stack.isEmpty()){
                    System.out.println("maaf stock habis");
                } else {
                    System.out.println("print paling atas adalah "+stack.peek());
                }
            } else if (perintah.equals("habis?")){
                if (stack.isEmpty()){
                    System.out.println("ya, habis");
                } else {
                    System.out.println("masih ada kok");
                }
            }
        }
        scanner.close();
    }
}
