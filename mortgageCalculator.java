import java.text.NumberFormat;
import java.util.Scanner;

public class mortgageCalculator {

    public static void main (String[] arg){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        int principal = scanner.nextInt();
        System.out.print("Annual Interest Rate: ");
        float rate = scanner.nextFloat();
        System.out.print("Period (Years): ");
        byte period = scanner.nextByte();
        float monthlyRate = rate / 100 / period;
        float p = period * 12;
        // float n = (Math.pow((1 + monthlyRate), p));
        double mortgage = (principal * ((monthlyRate * Math.pow(1 + monthlyRate, p)) / (Math.pow(1 + monthlyRate, p) - 1)));
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
        scanner.close();
    }
}