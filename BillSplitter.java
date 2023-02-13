import java.util.Scanner;

public class BillSplitter {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.println("Enter the total bill amount: ");
    // double totalAmount = input.nextDouble();
    
    System.out.println("Enter the number of people: ");
    int totalPeople = input.nextInt();
    
    double[] individualAmounts = new double[totalPeople];
    
    for (int i = 0; i < totalPeople; i++) {
      System.out.println("Enter the amount spent by person " + (i + 1) + ": ");
      individualAmounts[i] = input.nextDouble();
    }
    
    double totalSpent = 0.0;
    for (int i = 0; i < totalPeople; i++) {
      totalSpent += individualAmounts[i];
    }
    
    double averageAmount = totalSpent / totalPeople;
    double[] amountsToPay = new double[totalPeople];
    
    for (int i = 0; i < totalPeople; i++) {
      amountsToPay[i] = averageAmount - individualAmounts[i];
    }
    
    for (int i = 0; i < totalPeople; i++) {
      System.out.println("Person " + (i + 1) + " should pay $" + amountsToPay[i]);
    }

    input.close();
  }
}
