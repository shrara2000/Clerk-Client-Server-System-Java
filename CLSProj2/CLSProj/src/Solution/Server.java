package Solution;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Server  {
static List<Cashier> AllCashiers = new ArrayList<Cashier>();
static List<log> AllLog= new ArrayList<log>();
static List<Item>AllItems= new ArrayList<Item>();
static Transaction T = new Transaction();
private static File F = new File("Alllog.txt");
private static void DeleteItem(String arr , DataOutputStream TC)
{ 
String []arr2=arr.split(" ");
String Username=arr2[0];
String ID=arr2[1];
int idx = Integer.parseInt(arr2[2]);
Item temp = T.GetItemAT(idx);
T.RemoveItem(idx);
log l = new log("Deleted Item "+temp.toString()+" From Transaction Number: "+Transaction.GetID()+" BY Cashier: "+Username+" With ID: "+ID);
Addlog(l);
try {
	TC.writeUTF(T.GetAllItems()+","+T.GetTotalPrice());
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
private static Item GetItem(int INum)
{
	for(Item i : AllItems)
	{
		if(i.getID()==INum)
		{
			return i;
		}
	}
	return null;
}

private static void InsertItem(String arr,DataOutputStream TC)
{
	String []arr2=arr.split(" "); 
	String Username=arr2[0];
	String ID=arr2[1];
	String []arr3=arr2[2].split("/");
	int INum=Integer.parseInt(arr3[0]);
	double IQty=Double.parseDouble(arr3[1]);
	Item S = GetItem(INum);
	
	 if(S.getType().equals("Counted"))
	 { 
		 CountativeItems CI = new CountativeItems(S.getName(), INum, S.getPrice(), (int)IQty);
		 T.AddItem(CI);
		 log l = new log("Add Item :"+CI.toString()+" To Transaction number: "+Transaction.GetID()+" BY Cashier: "+Username+" With ID: "+ID);
		 Addlog(l);
		 try {
			TC.writeUTF(T.GetAllItems()+","+T.GetTotalPrice());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 if(S.getType().equals("Weighted"))
	 { 
		 WeightedItems WI = new WeightedItems(S.getName(), INum, S.getPrice(), IQty);
		 T.AddItem(WI);
		 log l = new log("Add Item :"+WI.toString()+" To Transaction number: "+Transaction.GetID()+" BY Cashier: "+Username+" With ID :"+ID);
		 Addlog(l);
		 try {
			TC.writeUTF(T.GetAllItems()+","+T.GetTotalPrice());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	
}
private static void Addlog(log l)
{
	AllLog.add(l);
	UpdateAllLog(l);
}
private static void UpdateAllLog(log l) 
{ 
	try {
        FileWriter Wrt=new FileWriter(F);
            if (F.exists()) {
                             
                           try {
                               

                               RandomAccessFile raf = new RandomAccessFile(F, "rw");
                               raf.setLength(0);
                               raf.close();
                               
                           } catch (Exception ex) {
                               
                           }
	}
        for(log i : AllLog)
        {  Wrt.write(i.toString()+"\n");

        }
        
        
        
        
         Wrt.close();
    } catch (IOException ex) {
        
    }
	
	
	
}
private static void GenerateBill(String arr, DataOutputStream TC) {
	String []arr2=arr.split(" ");
	String Username=arr2[0];
        String ID=arr2[1];
	
	double PayedAmount=Double.parseDouble(arr2[2]);
	Bill b = new Bill(T,PayedAmount);
	log l = new log("Generated Bill number: "+b.getTID()+" By Cashier: "+Username+" With ID: "+ID+" Bill Amount: "+b.getTotalCost()+"Payed Amount: "+b.getAmountPayedByCustomer()+"Change: "+b.getChange()+"BoughtItems"+b.STS());
	Addlog(l);
	T=new Transaction();
	try {
		TC.writeUTF(b.toString());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private static Boolean logToSystem(String S)
{String Brief="";
String []temp=S.split(" ");
for(Cashier C : AllCashiers)
{
	if(C.getUsername().equals(temp[0])&&C.getPassword().equals(temp[1]))
	{
		Brief="Succesful Log Try By User :"+C.getName()+" ID :"+C.getId();
		log l = new log(Brief);
		
		Addlog(l);
		return true;
	}
}
Brief="Faild To log in";
log l = new log(Brief);
Addlog(l);
return false;
}
private static int GetCashierID(String Username)
{int temp;
log L = new log("GetCashierID");
Addlog(L);
	for(Cashier C : AllCashiers)
	{
		if(C.getUsername().equals(Username))
		{
			temp=C.getId();
	        return temp;
		}
	}
return -1;

	
}
public static void loadLog()
{ 

    Scanner s;
	try {
		s = new Scanner(F);
		 while(s.hasNextLine())
		    { String v = s.nextLine();
		    String []x=v.split(",");
		    String []l=x[1].split(" ");
		    
		    	log temp = new log(x[0],LocalDate.parse(l[0]),LocalTime.parse(l[1]));
		         AllLog.add(temp);
	} }catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
   
       
    } 

	public static void  main(String[] args) {
		try {
			AllCashiers.add(new Cashier("Ahmad",123,"A2000","Ao2"));
			AllCashiers.add(new Cashier("Rami",144,"R3000","Ro2"));
			AllItems.add(new WeightedItems("Tomato",123,5.00,0.0));
			AllItems.add(new WeightedItems("Potato",124,6.00,0.0));
			AllItems.add(new CountativeItems("Shampoo",55,7.5,0));
			AllItems.add(new CountativeItems("Chips",46,1.5,0));
			ServerSocket S = new ServerSocket(4444);
			Socket C1= S.accept();
			DataInputStream FC= new DataInputStream(C1.getInputStream());
			DataOutputStream TC = new DataOutputStream(C1.getOutputStream());
			loadLog();
			
			//Login To  System
			
			while(true)
			{
				
				 String MSG= FC.readUTF();
				 if(logToSystem(MSG))
					 {
					 TC.writeBoolean(true);
					 String []arr= MSG.split(" ");
					 TC.writeInt(GetCashierID(arr[0]));
					 break;
					 };
					 
				TC.writeBoolean(false);
				
                   				
			}
			
			
			boolean run=true;
			//StartProcessing
			while(run)
			{ 
				String []arr =FC.readUTF().split(":");
				switch(arr[0])
				{
				case "Insert":
					InsertItem(arr[1], TC);
					break;
				case "Delete":
					DeleteItem(arr[1],TC);
					break;
				case "Generate":
					GenerateBill(arr[1],TC);
					break;
				case "Logout":
					String []arr2=arr[1].split(" ");
					String Username=arr2[0];
					String ID=arr2[1];
					log l = new log("UserName : "+Username+" ID :"+ID+" LoggedOut");
					Addlog(l);
					run=false;
					break;
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

