import java.text.SimpleDateFormat;
import java.util.*;

public class Check {
  private int number, routingNumber;
  Date date;
  private double amount;
  private String bankName;
  
  public Check(int number_, double amount_, Date date_) {
	  number = number_;
	  amount = amount_;
	  date = date_;
	  routingNumber = 0;
	  bankName = "Own account";
  }
  
  public Check(int number_, int routingNumber_, Date date_, double amount_, String bankName_){
	  number = number_;
	  routingNumber = routingNumber_;
	  date = date_;
	  amount = amount_;
	  bankName = bankName_;
  }
  /****** GETTERS ******/
  public int getNumber() {return number;}
  public int getRoutingNumber() {return routingNumber;}
  public String getDate() {
	  SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	  String dateString = formatter.format(date);
	  return dateString;
  }
  public double getAmount() {return amount;}
  public String getBankName() {return bankName;}
}
