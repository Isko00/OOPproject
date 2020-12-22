package testers;

import java.io.*;
import main.*;

public class UniversitySystemTester {
	private final InputStreamReader isr = new InputStreamReader(System.in);
	private final BufferedReader reader = new BufferedReader(isr);
	
	private final OutputStreamWriter osw = new OutputStreamWriter(System.out);
	private final BufferedWriter writer = new BufferedWriter(osw);

	static User u;
	
	public void print(String text) {
		try {
			writer.write(text);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void println(String text) {
		print(text + "\n");
	}

	public String read() {
		String input = "";
    	try {
    		input = reader.readLine();
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	return input;
	}

	public int readInt() {
		int input = 0;
    	try {
    		input = Integer.parseInt(reader.readLine());
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	return input;
	}

    public void closeStreams() {
    	try {
			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	private void load() {
		try {
			UniversitySystem.deserialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void save() {
		try {
			UniversitySystem.serialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void logIn(UniversitySystemTester UST, UniversitySystem US) {
		UST.println("Enter id: ");
		int id = UST.readInt();
		UST.println("Enter password: ");
		String pass = UST.read();

		try {
			u = US.autorise(id, pass);
			if (u instanceof Student) {
				StudentTester.menu(UST, US, u.getId());
			} else if (u instanceof Teacher) {
				TeacherTester.menu(UST, US, u.getId());
			} else if (u instanceof Manager) {
				ManagerTester.menu(UST, US);
			} else if (u instanceof TechSupport) {
				TechSupportTester.menu(UST, US);
			} else if (u instanceof Admin) {
				AdminTester.menu(UST, US);
			}

		} catch (Exception e) {
			UST.println(e.toString());
			UST.println(e.toString());
			UST.println("Try again?");
			UST.println("1) Again");
			UST.println("2) Back to menu");
			switch(UST.readInt()) {
				case 1:
					logIn(UST, US);
				case 2:
					menu(UST, US);
			}
		}
		
		menu(UST, US);
	}
	
	private void register(UniversitySystemTester UST, UniversitySystem US) {
		UST.println("Select user type:");
		UST.println("1) Student");
		UST.println("2) Teacher");
		UST.println("3) Admin");
		UST.println("4) Manager");
		UST.println("5) Tech support");
		int userType = UST.readInt();

		UST.println("Enter password"); 
		String pass = UST.read();
		
		Admin.addOrder(new Order("type [" + userType + "], " 
				+ "pass [" + pass + "]", 0));

		UST.println("Registrational order sended");
		//UST.println(US.getAllUsers().toString());

		UST.println("1) Register one more user");
		UST.println("2) Back to menu");
		int choise = UST.readInt();
		if (choise == 1) register(UST, US);
		if (choise == 2) menu(UST, US); 
	}

	private void menu(UniversitySystemTester UST, UniversitySystem US) {
		try {
			UST.println("Welcome!");
			UST.println("You have an account or want to register?");
			UST.println("1) Log in");
			UST.println("2) Register");
			UST.println("3) Exit");
			switch(UST.readInt()) {  
				case 1:
					logIn(UST, US);
					break;
				case 2:
					register(UST, US);
					break;
				default:
					UST.println("Bye!!!"); 
			}
		} catch (Exception e) {
			UST.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();
		}
	}
	
	public static void settleAnAborigine(UniversitySystemTester UST, 
				UniversitySystem US) {
		
		Admin a = new Admin("123", US);
		US.register(a);
		a.updateInfo(0, "name", "Aborigine");
	}
	
	public static void useSys() {
		UniversitySystemTester UST = new UniversitySystemTester();
		if (new File("backUp").exists()) { UST.load(); }
		
		UniversitySystem US = UniversitySystem.getInstance();
	
		UST.menu(UST, US);
		
		UST.save();
		UST.closeStreams();
	}
	
	public static void renewSys() {
		UniversitySystemTester UST = new UniversitySystemTester();
		
		UniversitySystem US = UniversitySystem.getInstance();
		
		settleAnAborigine(UST, US);
		
		UST.save();
		UST.closeStreams();
	}
	
	public static void main(String[] args) {
		//renewSys();
		useSys();
	}
}