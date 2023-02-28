import java.util.Scanner;

public class fizzBuzz{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number: ");
        int userNumber = scanner.nextInt();
        String result = (userNumber % 5 == 0 && userNumber % 3 == 0) ? "FizzBuzz" : (userNumber % 3 == 0) ? "Buzz" : (userNumber % 5 == 0) ? "Fizz" : Integer.toString(userNumber);
        System.out.println(result);
        scanner.close();
    }
}