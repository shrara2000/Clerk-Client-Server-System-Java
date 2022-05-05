package Solution;

public class Cashier {
private int id;
String name;
String username;
String Password;
public Cashier(String name,int ID)
{
	this.name= name;
	id=ID;
}
public Cashier(String name,int ID,String PW,String Username)
{
	this.name= name;
	id=ID;
	Password = PW;
	username=Username;
}
public int getId() {
	return id;
}
public String getName() {
	return name;
}
public String getUsername() {
	return username;
}
public String getPassword() {
	return Password;
}


}
