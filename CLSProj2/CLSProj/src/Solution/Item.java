package Solution;

public abstract class  Item {
@Override
	public abstract String toString(); 
		
	
protected String getName() {
		return name;
	}
protected int getID() {
		return ID;
	}
	protected double getPrice() {
		return price;
	}
public Item(String name, int iD, double price, String Type) {
		
		this.name = name;
		ID = iD;
		this.price = price;
		this.Type=Type;
	}
public String getType() {
	return Type;
}

abstract double CalculateCost();
private String name;
private int   ID;
private double price;
private String Type;

}
