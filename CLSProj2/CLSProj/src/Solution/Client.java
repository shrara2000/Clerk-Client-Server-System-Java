package Solution;

import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

//    public static void InsertItem(DataOutputStream TS, DataInputStream FS, Cashier Current, String Username) {
//        Scanner S = new Scanner(System.in);
//        String MSG = "Insert:" + Username + " " + Current.getId() + " ";
//        try {
//            System.out.println("Enter the number of the item");
//            int num = S.nextInt();
//            MSG += num + "/";
//            System.out.println("Enter the Quantity or the weight");
//            double Qty = S.nextDouble();
//            MSG += Qty;
//
//            TS.writeUTF(MSG);
//            String RMSG = FS.readUTF();
//            String[] arr = RMSG.split(",");
//            for (int i = 0; i < arr.length - 1; i++) {
//                System.out.println(arr[i]);
//            }
//            System.out.println("The Current total price is :" + arr[arr.length - 1]);
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    private static void ConfirmBill(DataOutputStream TS, DataInputStream FS, Cashier Current, String Username) {
//        Scanner S = new Scanner(System.in);
//        String MSG = "Generate:" + Username + " " + Current.getId() + " ";
//        try {
//            System.out.println("Enter The Amount the Customer Payed");
//            double Amount = S.nextDouble();
//            MSG += Amount;
//
//            TS.writeUTF(MSG);
//            String RMSG = FS.readUTF();
//            String[] arr = RMSG.split(",");
//            for (int i = 0; i < arr.length; i++) {
//                System.out.println(arr[i]);
//            }
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }
//
//    private static void Logout(DataOutputStream TS, Cashier Current, String Username) {
//        Scanner S = new Scanner(System.in);
//        String MSG = "Logout:" + Username + " " + Current.getId() + " ";
//        try {
//            TS.writeUTF(MSG);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }
//
//    private static void DeleteItem(DataOutputStream TS, DataInputStream FS, Cashier Current, String username) {
//        Scanner S = new Scanner(System.in);
//        String MSG = "Delete:" + username + " " + Current.getId() + " ";
//        try {
//            System.out.println("Enter The Index of the item you Want to Delete");
//            int Idx = S.nextInt();
//            MSG += Idx;
//
//            TS.writeUTF(MSG);
//            String RMSG = FS.readUTF();
//            String[] arr = RMSG.split(",");
//            for (int i = 0; i < arr.length - 1; i++) {
//                System.out.println(arr[i]);
//            }
//            System.out.println("The Current total price is :" + arr[arr.length - 1]);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }

    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 4444);
            DataInputStream FS = new DataInputStream(s.getInputStream());
            DataOutputStream TS = new DataOutputStream(s.getOutputStream());
            LoginForm login = new LoginForm();
            login.TS = TS;
            login.FS = FS;
            login.setVisible(true);
//	try {
//		Socket s = new Socket("localhost",4444);
//		DataInputStream FS= new DataInputStream (s.getInputStream());
//		DataOutputStream TS = new DataOutputStream(s.getOutputStream());
//		Scanner v = new Scanner(System.in);
//		System.out.print("Enter Your username");
//	 String Username= v.nextLine();
//	    System.out.print("Enter Your Password");
//     String Password = v.nextLine();
//     String Msg = Username+" "+Password;
//     TS.writeUTF(Msg);
//     boolean b =FS.readBoolean();
//    
//     while(!b)
//     {System.out.println("invalid username or password Entered");
//      System.out.println("Enter Your username");
//   	  Username= v.nextLine();
//   	  System.out.println("Enter Your Password");
//      Password = v.nextLine();
//      Msg = Username+" "+Password;
//      TS.writeUTF(Msg);
//      b =FS.readBoolean();
//     }
//     System.out.println(Username);
//     Cashier Current = new Cashier(Username,FS.readInt());
//     boolean run=true;
//     while(run)
//     {
//    	 System.out.println("press 1 to Enter an item \n press 2 delete an item \n press 3 to confirm transaction  \n press 4 to log out ");
//    	 int choice = v.nextInt();
//    	 switch (choice)
//    	 {
//    	 case 1 :
//    		 
//    		 InsertItem(TS,FS,Current,Username);
//    		 break;
//    	 case 2 :
//    		 DeleteItem(TS,FS,Current,Username);
//    		 break;
//    	 case 3 :
//    		 ConfirmBill(TS,FS,Current,Username);
//    		 break;
//    	 case 4 :
//    		 Logout(TS,Current,Username);
//    		 run=false;
//    		 break;
//    	default :
//    		System.out.println("Enter a Valid value");
//    	 
//    	 }
//     }
//
//
//     
//	} catch (UnknownHostException e) {
//		// TODO Auto-generated catch block
            //e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
