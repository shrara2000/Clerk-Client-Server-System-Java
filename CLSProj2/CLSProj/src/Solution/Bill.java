package Solution;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bill {
	public String STS()
	{
		String S="<<";
		for(Item i : AllBoughtItems)
		{
		 S+=i.toString()+"/";	
		}
		S+=">>";
		return S;
		
	}
	public String GetAllItems()
	{   int idx=0;
		String All="";
		for(Item i:AllBoughtItems )
		{
			All+=idx+" "+i.toString()+",";
			idx++;
		}
		return All;
		
		
	}
	public int getTID() {
		return TID;
	}
	public double getAmountPayedByCustomer() {
		return AmountPayedByCustomer;
	}
	public double getChange() {
		return Change;
	}
	private  List<Item> AllBoughtItems ;
	private double TotalCost;
	private int TID;
	private double AmountPayedByCustomer;
	private double Change;
	private LocalDate D;
	private LocalTime L;
	
		
public Bill(Transaction T ,double APBC)
{
	TotalCost=T.GetTotalPrice();
	TID=Transaction.GetID();
	AllBoughtItems=T.GetAllItems2();
	AmountPayedByCustomer=APBC;
    Change=APBC-TotalCost;
    D=LocalDate.now();
    L=LocalTime.now();
 
    
}
@Override
public String toString() {
return "T2F Groceries,"+"Date&Time:"+D.toString()+" "+L.toString()+","+GetAllItems()+", TotalCost: "+TotalCost+" PayedAmount: "+AmountPayedByCustomer+" Change: "+Change;
}
public double getTotalCost() {
	return TotalCost;
}



}
