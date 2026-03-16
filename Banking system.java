import java.util.*;
class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=balance;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public String getAccountHolder() {
        return accountHolder;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance+=amount;
        System.out.println("Updated balance: " + balance);
    }
    public void withdraw(double amount) {
        if (balance>=amount) {
            balance-=amount;
            System.out.println("Updated balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
    public void displayAccountDetails() {
        System.out.println("Account Number: " +accountNumber);
        System.out.println("Account Holder: " +accountHolder);
        System.out.println("Balance: " +balance);
    }
}
class SavingsAccount extends BankAccount {
    private double interestRate;
    public SavingsAccount(int accountNumber,String accountHolder,double balance,double interestRate) {
        super(accountNumber,accountHolder,balance);
        this.interestRate=interestRate;
    }
    public void calculateInterest() {
        double interest=getBalance()*interestRate/100;
        System.out.println("Interest: " +interest);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        int accountNumber=sc.nextInt();sc.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String accountHolder=sc.nextLine();
        System.out.print("Enter Balance: ");
        double balance=sc.nextDouble();
        System.out.print("Enter Interest Rate: ");
        double interestRate=sc.nextDouble();
        
        SavingsAccount acc=new SavingsAccount(accountNumber,accountHolder,balance,interestRate);
        System.out.print("Deposit Amount: ");
        double deposit=sc.nextDouble();
        acc.deposit(deposit);
        System.out.print("Withdraw Amount: ");
        double withdraw=sc.nextDouble();
        acc.withdraw(withdraw);
          
        acc.calculateInterest();
        sc.close();
    }
}