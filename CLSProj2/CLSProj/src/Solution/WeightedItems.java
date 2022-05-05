package Solution;

public class WeightedItems extends Item {
	private double Weight;
	
public WeightedItems(String name, int iD, double price, double Weight) {
		super(name, iD, price,"Weighted");
		this.Weight=Weight;
	}
@Override
public double CalculateCost() {
	return	getPrice()*Weight;
	 
}
@Override
public String toString() {
	 return getName()+" "+getID()+" "+getWeight()+" "+CalculateCost();
}
public double getWeight() {
	return Weight;
}


}
