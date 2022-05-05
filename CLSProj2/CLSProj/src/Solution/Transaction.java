package Solution;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
private  List<Item> AllBoughtItems = new ArrayList<Item>();
private double TotalCost=0.0d;
private static int TID=0;
public List<Item> GetAllItems2()
{
	return AllBoughtItems;
}
public Item GetItemAT(int idx)
{
	return AllBoughtItems.get(idx);
}
public Transaction()
{
	TID++;
}
public void AddItem(Item S)
{
	AllBoughtItems.add(S);
	TotalCost+=S.CalculateCost();
}
public void RemoveItem(int idx)
{
	Item temp=AllBoughtItems.get(idx);
	TotalCost-=temp.CalculateCost();
	AllBoughtItems.remove(idx);
}
public String GetAllItems()
{   int idx=0;
	String All="";
        

	for(Item i:AllBoughtItems )
        {	
        
		All+=","+idx+" "+i.toString();
		idx++;
	}
	return All;
	
	
}
public double GetTotalPrice()
{
	return TotalCost;
}
public static int GetID()
{
	return TID;
}


}
