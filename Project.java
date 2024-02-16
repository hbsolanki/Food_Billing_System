import java.util.*;
class FoodBill {
    static String item[]=new String[]{"Onions Pizza","Tomatoes Pizza","Capsicum Pizza","Sweet Corn Pizza","Onions&Panner Pizza","Margheta Pizza","Ala Mexican Pizza","Authentic Pizza","Burn To Hell Pizza","Korma Panner Special Pizza","Cheesy Macaroni Veg"};
    static int price[] = new int[] { 89, 89, 99, 105, 129, 140, 255, 255, 255, 255, 285 };
    static int orderPizzaNumber []= new int[10];
    static int orderPizzaquantity[]= new int[10];
    static Scanner sc = new Scanner(System.in);
    static int orderNumber = 0;
    static String name;
	static String mobile_number;
    public static void main(String[] args) {
        welcome();
        int choice;
        do {
            System.out.println();
            System.out.println("(1)Order Pizza \n(2)Show Cart \n(3)Bill Generate \n(4)Exit");
            System.out.println();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    orderPizza();
                    break;
                case 2:
                    showCart();
                    break;

                case 3:
                    billGenerate();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Enter Valid Option");
            }
        } while (choice != 4);
    }
    
    public static void welcome() {
        System.out.println();
		System.out.println("***** Welcome In Our Shop *****");
		System.out.print("Enter Your Name:");
		name=sc.nextLine();

		boolean flag=false;
        do{
            System.out.print("Enter Mobile Number:");
                mobile_number=sc.nextLine();
                
			if(mobile_number.length()==10){
				for(int i=0;i<mobile_number.length();i++){
					if(mobile_number.charAt(i)>='0' && mobile_number.charAt(i)<='9'){
						flag=true;	
					} else{
						flag=false;
						System.out.println("Enter A Valid Number");
					}
				}
			} else{
				System.out.println("Enter A Valid NUmber");
				flag=false;
			}
		}while(flag==false);
		
    }
    
    public static void orderPizza() {

        if (orderNumber >= 10) {
            billGenerate();
        }


        System.out.println("Available pizza");
        System.out.println();
        for (int i = 0; i < item.length; i++) {
            System.out.println((i + 1) + " " + item[i] + " " + price[i]+"₹");
        }
        System.out.println("If You Want To Add Food Then Type Food's Number Else Exit For 0");
        int choicePizzaNumber = sc.nextInt();
        
        if (choicePizzaNumber > 11 || choicePizzaNumber < 0) {
            System.out.println("Enter Valid Pizza Number");
            orderPizza();
        } else if (choicePizzaNumber == 0) {
            return;
        } else {
            
            int quan;
            do{
                System.out.println("Enter Quantity");
                quan = sc.nextInt();

                if (quan < 0) {
                    System.out.println("Enter Valid Quantity");
                }
            } while (quan < 0);

            orderPizzaNumber[orderNumber] = choicePizzaNumber ;
            orderPizzaquantity[orderNumber] = quan;
            orderNumber++;
        }
    }
    
    public static void showCart() {
        System.out.println("Your Card is : ");
        for (int i = 0; i < orderPizzaNumber.length; i++) {
            if (orderPizzaNumber[i] == 0) {
                break;
            }
            System.out.println((i+1)+" "+item[orderPizzaNumber[i]-1]+" Quantity : "+orderPizzaquantity[i]);
        }
    }
    
    public static void billGenerate() {
        int totalBill = 0;

        for (int i = 0; i < orderPizzaNumber.length; i++) {
            if (orderPizzaNumber[i] == 0) {
                break;
            }
            totalBill += price[orderPizzaNumber[i]-1] * orderPizzaquantity[i];
        }

        end(totalBill);
    }
    

    public static void end(int totalBill) {
        System.out.println("----------------------------------------------------------------");
		System.out.println();
		
		System.out.println("Name:"+name);
		System.out.println("Mobile Number:"+mobile_number);
		System.out.println();
		System.out.println("*-*-*-*-* Your Order is *-*-*-*-*");
		showCart();
		System.out.println("     Your Total Bill Is:"+totalBill+"₹");
		System.out.println();
		
        System.out.println("  ~ THANKS FOR VISIT OUR SHOP ~");
        System.exit(0);
    }
    
}
