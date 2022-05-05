package Solution;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class log {
@Override
	public String toString() {
	
		return  Action + "," +Time.toString()+" "+Time2.toString();
	}
private String Action;
private LocalDate Time;
private LocalTime Time2;
public log(String Action)
{
	this.Action=Action;
	Time=LocalDate.now();
	Time2=LocalTime.now();
}
public log(String string, LocalDate parse,LocalTime P2) {
	this.Action=string;
	Time=parse;
	Time2=P2;
} 
public String getAction() {
	return Action;
}
public void setAction(String action) {
	Action = action;
}
public LocalDate getTime() {
	return Time;
}
public void setTime(LocalDate time) {
	Time = time;
}

}
