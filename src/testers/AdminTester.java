package testers;

import java.util.Vector;

import main.*;

public class AdminTester {
	public static void menu(UniversitySystemTester UST, UniversitySystem US) {
		Admin a = new Admin("qwe", US);
		menu : while(true) {
			UST.println("Select action:");
			UST.println("1) Add user");
			UST.println("2) Update user info");
			UST.println("3) Delete user");
			UST.println("4) Check unread order");
			UST.println("5) Check done order");
			UST.println("6) Get all users");
			UST.println("7) Exit");
			
			switch(UST.readInt()) {
				case 1:
					register : while(true) {
						UST.println("Select user type:");
						UST.println("1) Student");
						UST.println("2) Teacher");
						UST.println("3) Admin");
						UST.println("4) Manager");
						UST.println("5) Tech support");
						int userType = UST.readInt();
			
						UST.println("Enter password"); 
						String pass = UST.read();
						
						switch (userType) {
							case 1:
								a.addUser(UserType.STUDENT, pass);
						    	break;
							case 2:
								a.addUser(UserType.TEACHER, pass);
								break;
							case 3:
								a.addUser(UserType.ADMIN, pass);
								break;
							case 4:
								a.addUser(UserType.MANAGER, pass);
								break;
							case 5:
								a.addUser(UserType.TECHSUPPORT, pass);
								break;
						}
			
						UST.println("Registration is over");
			
						UST.println("1) Register one more user");
						UST.println("2) Back to menu");
						UST.println("3) Exit");
			
						if (UST.readInt() == 1) continue register;
						if (UST.readInt() == 2) continue menu;
						if (UST.readInt() == 3) break menu;
						break;
					}
					break;
				case 2:
					updateUserInfo : while(true) {
						UST.println("Enter user id:");
						int id = UST.readInt();
						UST.println("Enter property you want to update:");
						String property = UST.read();
						UST.println("Enter value of this property:");
						String value = UST.read();
						
						a.updateInfo (id, property, value);
	
						UST.println("Property updated");
						
						UST.println("1) Update one more property");
						UST.println("2) Back to menu");
						UST.println("3) Exit");
						
						if (UST.readInt() == 1) continue updateUserInfo;
						if (UST.readInt() == 2) continue menu;
						if (UST.readInt() == 3) break menu;
						
						break;
					}
					break;
				case 3:
					deleteUser : while(true) {
						UST.println("Enter user id:");
						int id = UST.readInt();
						
						a.deleteUser (id);
	
						UST.println("User deleted");
						
						UST.println("1) Delete one more user");
						UST.println("2) Back to menu");
						UST.println("3) Exit");
						
						if (UST.readInt() == 1) continue deleteUser;
						if (UST.readInt() == 2) continue menu;
						if (UST.readInt() == 3) break menu;
						
						break;
					}
					break;
				case 4:
					checkUnreadOrder : while(true) {
						Order o = a.getUnreadOrder();
						UST.println(o.toString());
		
						UST.println("Select action:");

						UST.println("1) Accept order");
						UST.println("2) Reject order");
						UST.println("3) Exit");

						if (UST.readInt() == 1) a.acceptOrder(o);
						if (UST.readInt() == 2) {
							UST.println("Type reason you send for teacher:");
							String reason = UST.read();
							a.rejectOrder(o, reason);

							UST.println("Order rejected");
						}
						if (UST.readInt() == 3) break menu;
						
						UST.println("1) Check one more unread order");
						UST.println("2) Back to menu");
						UST.println("3) Exit");
						
						if (UST.readInt() == 1) continue checkUnreadOrder;
						if (UST.readInt() == 2) continue menu;
						if (UST.readInt() == 3) break menu;
						
						break;
					}
					break;
				case 5:
					checkOrders : while(true) {
						Vector<Order> v = a.getOrders();
						for (Order o : v) {
							UST.println(o.toString());
							UST.println("");
						}
				
						UST.println("Orders printed");
						
						UST.println("1) Print one more time");
						UST.println("2) Back to menu");
						UST.println("3) Exit");
						
						if (UST.readInt() == 1) continue checkOrders;
						if (UST.readInt() == 2) continue menu;
						if (UST.readInt() == 3) break menu;
						
						break;
					}
					break;

				case 6:
					getAllUsers : while(true) {
						UST.println(US.toString());
				
						UST.println("Users printed");
						
						UST.println("1) Print one more time");
						UST.println("2) Back to menu");
						UST.println("3) Exit");
						
						if (UST.readInt() == 1) continue getAllUsers;
						if (UST.readInt() == 2) continue menu;
						if (UST.readInt() == 3) break menu;
						
						break;
					}
					break;
					
				default :
					break menu;
			}
		}
	}
}
