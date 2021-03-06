package testers;

import java.util.Vector;

import main.*;

public class TechSupportTester {
	public static void menu(UniversitySystemTester UST, UniversitySystem US) {
		TechSupport t = new TechSupport("qwe", US);
		menu : while(true) {
			UST.println("Select action:");
			UST.println("1) Check unread order");
			UST.println("2) Check done order");
			UST.println("3) Exit");
			
			switch(UST.readInt()) {
				case 1:
					checkUnreadOrder : while(true) {
						Order o = t.getUnreadOrder();
						UST.println(o.toString());
		
						UST.println("Select action:");

						UST.println("1) Accept order");
						UST.println("2) Reject order");
						UST.println("3) Exit");

						int choise = UST.readInt();
						if (choise == 1) t.acceptOrder(o);
						if (choise == 2) {
							UST.println("Type reason you send for teacher:");
							String reason = UST.read();
							t.rejectOrder(o, reason);

							UST.println("Order rejected");
						}
						if (choise == 3) break menu;
						
						UST.println("1) Check one more unread order");
						UST.println("2) Back to menu");
						UST.println("3) Exit");
						
						choise = UST.readInt();
						if (choise == 1) continue checkUnreadOrder;
						if (choise == 2) continue menu;
						if (choise == 3) break menu;
						
						break;
					}
					break;
				case 2:
					checkOrders : while(true) {
						Vector<Order> v = t.getOrders();
						for (Order o : v) {
							UST.println(o.toString());
							UST.println("");
						}
				
						UST.println("Orders printed");
						
						UST.println("1) Print one more time");
						UST.println("2) Back to menu");
						UST.println("3) Exit");
						
						int choise = UST.readInt();
						if (choise == 1) continue checkOrders;
						if (choise == 2) continue menu;
						if (choise == 3) break menu;
						
						break;
					}
					break;

				default :
					break menu;
			}
		}
	}
}
