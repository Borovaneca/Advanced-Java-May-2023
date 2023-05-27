package Advance.DefineClasses.Lab.BankAccount;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String input = scanner.nextLine();
        HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();

        while (!input.equals("End")) {
            String[] inputData = input.split("\\s+");
            String command = inputData[0];

            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                bankAccounts.put(bankAccount.getId(), bankAccount);
                System.out.println("Account ID" + bankAccount.getId() + " created");

            } else if (command.equals("Deposit")) {
                int id = Integer.parseInt(inputData[1]);
                int deposit = Integer.parseInt(inputData[2]);
                if (!bankAccounts.containsKey(id)) {
                    System.out.println("Account does not exist");
                } else {
                    bankAccounts.get(id).deposit(deposit);
                    System.out.println("Deposited " + deposit + " to ID" + bankAccounts.get(id).getId());
                }

            } else if (command.equals("SetInterest")) {
                double interest = Double.parseDouble(inputData[1]);
                BankAccount.setInterestRate(interest);

            } else if (command.equals("GetInterest")) {
                int id = Integer.parseInt(inputData[1]);
                int years = Integer.parseInt(inputData[2]);
                if (!bankAccounts.containsKey(id)) {
                    System.out.println("Account does not exist");
                } else {
                    System.out.printf("%.2f%n", bankAccounts.get(id).getInterestRate(years));
                }

            }



            input = scanner.nextLine();
        }
    }
}
