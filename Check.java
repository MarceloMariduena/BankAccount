import java.util.*;

public class Check {
  private int number = 1000, routingNumber;
  private static int instanceCounter = 0;
  Date date;
  private double amount;
  private String bankName;
  
  public Check(double amount_, Date date_) {
	  instanceCounter++;
	  number += instanceCounter;
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
  public Date getDate() {return date;}
  public double getAmount() {return amount;}
  public String getBankName() {return bankName;}
}