package atmproject;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Account {
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat =  new DecimalFormat("'$'###,##0.00");
	HashMap<Integer ,Integer> data = new HashMap<Integer ,Integer>();
  public void getLogin()throws IOException{
	  int x = 1;
	  do {
		  try {
			  data.put(987654, 1234);
			  data.put(121212, 2121);
			  data.put(123123, 9876);
			  System.out.println("welcome the ATM project");
			  System.out.println("Enter your customer number");
			  setCustomerNumber(menuInput.nextInt());
			  System.out.println("Enter your pin number");
			  setPinNumber(menuInput.nextInt());
		  } catch (Exception e) { 
			  System.out.println("Invalid charater, Enter only Number"+"\n");
   			  x=2;
		  }
		  for (Entry<Integer, Integer> entry:data.entrySet()) {
			  if(entry.getKey()==getCustomerNumber()&& entry.getValue()==getpinNumber()) {
				  getAccountType1();
			  }
		  }
		  System.out.println("wrong customer number or id"+"\n");
	  }while(x==1);
	  
	  }
int selection;
  //diplay Account type menu
  public void getAccountType1() {
	  System.out.println("Select the Account you want to access");
	  System.out.println("Type 1: Checking Account");
	  System.out.println("Type 2: Saving Account");
	  System.out.println("Type 3: Exit");
	  System.out.println(menuInput.nextInt());
	  System.out.println("Enter your pin number");
	  setPinNumber(menuInput.nextInt());
	  
  switch (selection ) {
  case 1:
	  getCheckingBalance();
	  break;
  case 2:
	  getSavingBalance();
	  break;
  case 3:
	  System.out.println("Thank you for using this Atm,Bye");
	  break;
  default:
	  System.out.println("Invalid Choise"+"\n");
	  getAccountType1();
  }
  }

//Display Checking Account menu with Selection
public void getChecking() {
	System.out.println("Checking Account");
	System.out.println("Type 1: View Balance");
	System.out.println("Type 2: Withdraw funds");
	System.out.println("Type 3: Deposit funds");
	System.out.println("Type 4: Exit");
	System.out.println("Choice  : "+"\n");
    selection = menuInput.nextInt(); 
    switch(selection) {
    case 1:
    System.out.println("Saving Account Balance"+moneyFormat.format(getSavingBalance()));
    getAccountType1();
    break;
    case 2:
    	getSavingWithdrawInput();
    	getAccountType1();
    	break;
    case 3:
    	getSavingDepositInput();
    	getAccountType1();
    	break;
    default:
    	System.out.println("\n"+"Invalid choise"+"\n");
    	getSavingBalance();
    	
    }
   }
}

