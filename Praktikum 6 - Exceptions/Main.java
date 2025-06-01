import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);    
        String password = scanner.nextLine();
        Password password1 = new Password(password);
        try {
            boolean valid = false; 
            if (password1.validate()){
                valid = true;
            }
            if (valid){
                System.out.println(valid);
                System.out.println("Password validated.");
            }
        } catch (InvalidLengthException e){
            System.out.println(e.getMessage());
            System.out.println("Password string error!");
        } catch (InvalidPasswordException e){
            System.out.println(e.getMessage());
            System.out.println("Password string error!");
        } finally{
            System.out.println("Operation finished.");
            scanner.close();
        }
    }
}