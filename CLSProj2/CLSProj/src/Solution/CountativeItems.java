package Solution;

public class CountativeItems extends Item {
private int Amount;
	public CountativeItems(String name, int iD, double price,int Qty) {
		super(name, iD, price,"Counted");
		Amount=Qty;
	}

	@Override
	double CalculateCost() {
		
		return getPrice()*Amount;
	}

	@Override
	public String toString() {
		return getName()+" "+getID()+" "+getAmount()+" "+CalculateCost();
	}

	public int getAmount() {
		return Amount;
	}

}
