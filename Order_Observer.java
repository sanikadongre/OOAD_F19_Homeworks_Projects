package OOA_tool_rental;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Order_Observer {
  public static void main(String args[]) {
    Order obj = new Order();
    Random random = new Random();
    int days_count =1;
      int tools_Available = 24;
      int profit_per_day = 0;
      ArrayList<RentalRecordStore> rrstore = new ArrayList<RentalRecordStore>();
      while(days_count <=3 ) {
      int customersOnTheDay = random.nextInt(6)+1; //randomly select between 1 and 7 customers, on any given day.
      for (int i=1;i<=customersOnTheDay;i++) {
        HashMap<String, Integer>  toolsProfitMap = obj.order_func(days_count,"Customer No: "+Integer.toString(i),tools_Available,rrstore);
         tools_Available -= toolsProfitMap.get("tool_cnt");
         profit_per_day += toolsProfitMap.get("total_profit");
      }
      System.out.println("-------------------------- PROFIT MADE IN DAY "+days_count+" IS "+profit_per_day+"$ -------------------------- ");
       days_count++;
      }
  }
}
