import java.util.Scanner;

class BankDetails {
	String name, userName, userPin, accountNo;
	float balance = 100000f;
	int transactions = 0;
	String transactionHistory = "";
	
	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Your Name : ");
		this.name = sc.nextLine();
		System.out.print("\nEnter Your Username : ");
		this.userName = sc.nextLine();
		System.out.print("\nEnter Your Userpin : ");
		this.userPin = sc.nextLine();
		System.out.print("\nEnter Your Account Number : ");
		this.accountNo = sc.nextLine();
		System.out.println("\nRegistration Successfully Completed. Kindly login !!");
	}
	
	public boolean login() {
		Scanner sc = new Scanner(System.in);
		boolean tryLogin = false;
		while ( !tryLogin ) {
			System.out.print("\nEnter Your Username : ");
			String Username = sc.nextLine();
			if ( Username.equals(userName) ) {
				while ( !tryLogin ) {
					System.out.print("\nEnter Your Pin : ");
					String UserPin = sc.nextLine();
					if ( UserPin.equals(userPin) ) {
						System.out.print("\nLogin Successful!!");
						tryLogin = true;
					}
					else {
						System.out.println("\nIncorrect Pin !! Try Again.");
					}
                }
			}
			else {
				System.out.println("\nOops!! Username Not Found.");
			}
		}
		return tryLogin;
	}
	
	public void withdraw() {
		Scanner sc = new Scanner(System.in);	
		System.out.print("\nEnter Amount To Be Withdrawn : ");
		float amount = sc.nextFloat();			
        if ( balance >= amount ) {
            transactions++;
            balance = balance - amount;
            System.out.println("\nAmount Withdrawn Successfully.");
            String str = amount + " Rs Withdrawed\n";
            transactionHistory = transactionHistory + str;            
        }
        else {
            System.out.println("\nInsufficient Balance.");
        }			
	}
	
	public void deposit() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Amount To Be Deposit : ");
		float amount = sc.nextFloat();
        if ( amount <= 100000f ) {
            transactions++;
            balance = balance + amount;
            System.out.println("\nAmount Successfully Deposited.");
            String str = amount + " Rs deposited\n";
            transactionHistory = transactionHistory+(str);
        }
        else {
            System.out.println("\nOops Sorry Limit Exceeded...Limit is 100000.00");
        }
	}
	
	public void transfer() {		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Recipient's Name : ");
		String receipent = sc.nextLine();
		System.out.print("\nEnter Amount To Transfer : ");
		float amount = sc.nextFloat();
		
        if ( balance >= amount ) {
            if ( amount <= 50000f ) {
                transactions++;
                balance = balance - amount;
                System.out.println("\nSuccessfully Transfered To " + receipent);
                String str = amount + " Rs transfered to " + receipent + "\n";
                transactionHistory = transactionHistory + (str);
            }
            else {
                System.out.println("\nOops Sorry...Limit is 50000.00");
            }
        }
        else {
            System.out.println("\nInsufficient Balance");
        }
	}
	
	public void checkBalance() {
		System.out.println("\nYour Balance is " + balance + " Rs");
	}
	
	public void transHistory() {
		if ( transactions == 0 ) {
			System.out.println("\nYour Bank Account is Empty.");
		}
		else {
			System.out.println("\n" + transactionHistory);
		}
	}
}

public class Task3_atmInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n------------ WELCOME TO ATM SYSTEM ----------\n");
		System.out.println("1.REGISTER \t2.EXIT");
		System.out.print("Select Your Option : ");
		
		int option = sc.nextInt();
		if ( option == 1 ) {
			BankDetails bd = new BankDetails();
			bd.register();
			while(true) {
				System.out.println("\n1.LOGIN \t2.EXIT");
				System.out.print("\nEnter Your Choice : ");
				int choice = sc.nextInt();
				if ( choice == 1 ) {
					if (bd.login()) {
						System.out.println("\n\n------------ WELCOME BACK " + bd.name + " -------------\n");
						boolean isFinished = false;
						while (!isFinished) {
							System.out.println("\n1.Withdraw \t2.Deposit \t3.Transfer \n4.Check Balance \t5.Transaction History \t6.Exit");
							System.out.print("\nEnter Your Choice : ");
							int select = sc.nextInt();
							switch(select) {
								case 1:
								bd.withdraw();
								break;
								case 2:
								bd.deposit();
								break;
								case 3:
								bd.transfer();
								break;
								case 4:
								bd.checkBalance();
								break;
								case 5:
								bd.transHistory();
								break;
								case 6:
								isFinished = true;
								break;
							}
						}
					}
				}
				else if(choice == 2){
					System.exit(0);
				}
                else{
                    System.out.print("Oops! Plz Enter From Choices Given.");                  
                }
			}
		}
		else if(option == 2) {
			System.exit(0);
		}
        else{
            System.out.print("Oops! Plz Enter From Choices Given.");
        }
	}
}


