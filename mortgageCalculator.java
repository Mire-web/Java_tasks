import java.text.NumberFormat;
import java.util.Scanner;

public class mortgageCalculator {

    public static void main (String[] arg){
        final int months_in_year = 12;
        final int percent = 100;
        float monthlyRate;
        int no_of_payments;
        double totalRepayment;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal ($1K - $1M): ");
        int principal = scanner.nextInt();
        while(principal < 1000 || principal > 1000000){
            System.out.println("Enter a valid amount between $1000 and $1000000");
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
        }
        System.out.print("Annual Interest Rate (>0%): ");
        float annual_interest_rate = scanner.nextFloat();
        while(annual_interest_rate < 1 || annual_interest_rate > 30){
            System.out.println("Enter a valid rate between 1% and 30%");
            System.out.print("Annual Interest Rate (>0%): ");
            annual_interest_rate = scanner.nextFloat();
        } 
        System.out.print("Period (Years): ");
        int period_of_loan = scanner.nextInt();
        while(period_of_loan < 1 || period_of_loan > 30){
            System.out.println("Enter a period between 1 and 30");
            System.out.print("Period (Years): ");
            period_of_loan = scanner.nextInt();
        }
        
        monthlyRate = (annual_interest_rate / percent) / months_in_year;
        no_of_payments = period_of_loan * months_in_year;
        float mortgage = (float)(principal * ((monthlyRate * (Math.pow((1 + monthlyRate), no_of_payments))) / (Math.pow((1 + monthlyRate), no_of_payments) - 1)));
        
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Your monthly loan repayment is " + mortgageFormatted);

        totalRepayment = (mortgage * no_of_payments);
        System.out.println("Your total repayment is " + NumberFormat.getCurrencyInstance().format(totalRepayment));
        System.out.print("Do you want to make a repayment now?: ");
        String response = scanner.next().toLowerCase();
        
        while(!response.equals("yes") && !response.equals("no")){
        System.out.println("Enter a valid response!!!");
        System.out.print("Do you want to make a repayment now?: ");
        response = scanner.next().toLowerCase();
        }
        if(response.equals("yes")){
            System.out.print("Enter repayment amount: ");
            float repayment_amount = scanner.nextFloat();
            System.out.println("Your new loan balance is " + NumberFormat.getCurrencyInstance().format(totalRepayment - repayment_amount));
            System.out.println("Thank you for banking with us :)\nClosing...");
        }
        else if (response.equals("no")){
            System.out.println("Thank you for banking with us \nClosing...");
        }

        scanner.close();
    }
}