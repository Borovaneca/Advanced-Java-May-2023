package Advance.DefineClasses.Lab.BankAccount;

public class BankAccount {
   private static int nextID = 1;
   private static double interestRate = 0.02;

   private int id;
   private double balance;


   public BankAccount() {
       this.id = nextID;
       nextID++;
   }

   public static void setInterestRate(double interestRate) {
       BankAccount.interestRate = interestRate;
   }

   public double getInterestRate(int years) {
       return balance * years * interestRate;
   }

   public void deposit(double amount) {
       balance += amount;
   }

   public int getId() {
       return id;
   }
}
