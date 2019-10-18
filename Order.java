package OOA_tool_rental;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.Scanner;

 public class Order {

    public HashMap<String, Integer> order_func(int days_count,String customer_no, int tools_Available,ArrayList<RentalRecordStore> rrstore) {
       ArrayList<String> toolsInUse = new ArrayList<>();
       InventoryFactory inventoryFactory = new InventoryFactory();
       RentalTool_main rental = new RentalTool_main(inventoryFactory);
//       int days_count =1;
  //     int tools_Available = 24;
   //    while(days_count <=3) {     //need to change it to 35
          Reduce_days rd = new Reduce_days();
          List<String> tools_rem = new ArrayList<>();
          tools_rem = rd.get_difference();
          System.out.println("-------------------------- DAY "+days_count+" --------------------------");
          System.out.println("-------------------------- Count of Tools Available in the store: "+tools_Available+" --------------------------");
          System.out.println("--------------------------- TOOLS AVAILABLE ARE -------------------------");
          for(int i=0;i<tools_rem.size();i++) {
           System.out.println(tools_rem.get(i));
          }
          if(days_count>1) {
            int k = rrstore.size();
              for (int i = 0; i < k; i++) {
                 System.out.println("Record for the day is " + rrstore.get(i));
              }
          }

          System.out.println("---------------------------"+ customer_no + "---------------------------");

          Scanner cust = new Scanner(System.in); 
          if(tools_Available < 3) 
            System.out.println("Choose the type of customer: REGULAR or CASUAL");
               
          else 
              System.out.println("Choose the type of customer: REGULAR, CASUAL, BUSINESS");
              
          String customer_type = cust.next();
        System.out.println("WELCOME " + customer_type+" CUSTOMER");
        String customer_name = "";
        int count_tools = 0;
        
        if (customer_type.equals("REGULAR")) {
           System.out.println("What is your name? 1.JOEY 2.CHANDLER 3.ROSS 4.GUNTHER");
           customer_name += cust.next();
           RegularCustomer custObj = new RegularCustomer(customer_name);
           System.out.println("Hi " + custObj.name);
           System.out.println("How many tools you want to buy? You can choose from 1 to 3 only!!");
           count_tools += cust.nextInt();
        } else {
           if (customer_type.equals("CASUAL")) {
              System.out.println("What is your name? 1.RACHEL 2.MONICA 3.JANICE 4.PHOEBE");
              customer_name += cust.next();
              CasualCustomer custObj = new CasualCustomer(customer_name);
              System.out.println("Hi " + custObj.name);
              System.out.println("How many tools you want to buy? You can choose from 1 to 2 only!!");
              count_tools += cust.nextInt();
           } else {
              if (customer_type.equals("BUSINESS")) {
                 System.out.println("What is your name? 1.BEN 2.EMMA 3.KEN 4.REGINA");
                 customer_name += cust.next();
                 BusinessCustomer custObj = new BusinessCustomer(customer_name);
                 System.out.println("Hi " + custObj.name);
                 System.out.println("You need to choose 3 tools!!");
                 count_tools += 3;
              }
           }
        }
       Scanner input = new Scanner(System.in);
        String[] tool_category = new String[count_tools];
       // tools_Available -= count_tools;
        int tool_cnt = count_tools;
        int i = 0;
  
        //Keep retrying till the customer is able to rent / record created.
        // ToDo: only stop when number of tools is zero (and 2 if it's business customer), coz you cannot rent then
        // Thus will have to use this method in all category classes : get_tools_in_use_list()
        // From these, calculate total tools in use presently and the diff/available ones (5*5 = 25 tools in all possible, minus this count))
        int total_profit=0;
           while (count_tools > 0) {
              
              System.out.println("Choose the " + (i + 1)
                    + " category you want to buy: PAINTING, CONCRETE, PLUMBING, WOODWORK, YARDWORK");
              tool_category[i] = input.next();
              int transactionResponse = rental.orderTool(tool_category[i], customer_name, customer_type, rrstore);
              if (transactionResponse == -1) {
                   //because user must reselect the category
                   continue;
             }
              else {
                total_profit += transactionResponse;
                i++;
                count_tools--;
              }
           }
    
  
        int k = rrstore.size();
        for (i = 0; i < k; i++) {
           System.out.println("Record is " + rrstore.get(i));
        }
        
        //System.out.println("-------------------------- PROFIT MADE IN DAY "+days_count+" IS "+total_profit+"$ -------------------------- ");

        HashMap<String, Integer> toolsAndProfitsMap = new HashMap<>();
        toolsAndProfitsMap.put("total_profit", total_profit);
        toolsAndProfitsMap.put("tool_cnt", tool_cnt);
        return toolsAndProfitsMap;
        //return tool_cnt;
        //input.close();
        
//      }
    }
 }
