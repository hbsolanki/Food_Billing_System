import java.util.*;
class Project
{	
	static int bill;
	static int cnt=1;
	static String name;
	static String mobile_number;
    static int order[]=new int[0];
	static int order_qun[]=new int[0];
	static int tempbill[]=new int[0];
	static String item[]=new String[]{"Onions Pizza","Tomatoes Pizza","Capsicum Pizza","Sweet Corn Pizza","Onions&Panner Pizza","Margheta Pizza","Ala Mexican Pizza","Authentic Pizza","Burn To Hell Pizza","Korma Panner Special Pizza","Cheesy Macaroni Veg"};
	static int price[]=new int[]{89,89,99,105,129,140,255,255,255,255,285};
	
		//needed variable and array defined
	
	void welcome()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.println("***** Welcome In Our Shop *****");
		System.out.print("Enter Your Name:");
		name=sc.nextLine();
		boolean flag=false;
	   //checking Mobile Number Valid
		do
		{
			System.out.print("Enter Mobile Number:");
			mobile_number=sc.nextLine();
			
			if(mobile_number.length()==10)
			{
				for(int i=0;i<mobile_number.length();i++)
				{
					if(mobile_number.charAt(i)>='0' && mobile_number.charAt(i)<='9')
					{
						flag=true;	
					} else
					{
						flag=false;
						System.out.println("Enter A Valid Number");
					}
				}
			} else
			{
				System.out.println("Enter A Valid NUmber");
				flag=false;
			}
		}while(flag==false);
		
		food();
	}
	
	void food()
	{
		System.out.println();	
		System.out.println("In Our Shop Given Pizza Are Avilable");
		
		System.out.println();
		for(int i=0;i<item.length;i++)
		{	
		System.out.println((i+1)+")"+item[i]+" - "+price[i]+"inr");
		}
		System.out.println();
		
		order_take();
	}
 	
	void order_take()
	{		
		System.out.println("If You Want To Add Food Then Type Food's Number Else Exit For 0");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		if(n<0||n>11)
		{
			System.out.println("invalid Option, Choice Valid Option");
			order_take();
		}
		
		if(n==0)
		{
			bill_Cal();
			return;
		}
		System.out.println("Enter Quantity");
		int q=sc.nextInt();
		int price[]=new int[]{89,89,99,105,129,140,255,255,255,255,285};
		
		bill+=price[n-1]*q;
		
		//increece array Size Use Temp 
		
		if(order.length<cnt)
		{
			int temp[]=new int[order.length];
			for(int i=0;i<order.length;i++)
			{
				temp[i]=order[i];
			}
			order=new int[cnt+1];
			for(int i=0;i<temp.length;i++)
			{
				order[i]=temp[i];
			}
		}
		if(order_qun.length<cnt)
		{
			int temp2[]=new int[order.length];
			for(int i=0;i<order_qun.length;i++)
			{
				temp2[i]=order_qun[i];
			}
			order_qun=new int[cnt+1];
			for(int i=0;i<temp2.length;i++)
			{
				order_qun[i]=temp2[i];
			}
		}
		if(tempbill.length<cnt)
		{
			int temp3[]=new int[order.length];
			for(int i=0;i<tempbill.length;i++)
			{
				temp3[i]=tempbill[i];
			}
			tempbill=new int[cnt+1];
			for(int i=0;i<temp3.length;i++)
			{
				tempbill[i]=temp3[i];
			}
		}	
		
		order[cnt-1]=n;
		order_qun[cnt-1]=q;
		tempbill[cnt-1]=(price[n-1]*q);
		 cnt++;
		
		order_take(); 
		 
	}
	
	void bill_Cal()
	{
		System.out.println("----------------------------------------------------------------");
		System.out.println();
		
		System.out.println("Name:"+name);
		System.out.println("Mobile Number:"+mobile_number);
		System.out.println();
		System.out.println("*-*-*-*-* Your Order is *-*-*-*-*");
		for(int i=0;i<order.length;i++)
		{
			if(order[i]!=0)
			{
				int q=order[i];
				System.out.println("  "+item[q-1]+" * "+order_qun[i]+" = "+tempbill[i]+"inr");
			}
		}
		System.out.println("     Your Total Bill Is:"+bill+"inr");
		System.out.println();
		
		System.out.println("  ~ THANKS FOR VISIT OUR SHOP ~");
	}

}

class Main
{
	public static void main(String args[])
	{
		Project th=new Project();
		th.welcome();
	}
}
 