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
		try {
			writer.write(text + "\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	private static User createUser(int userType, String pass, 
			UniversitySystem US) {
		
		
		return u;
	}
	
	private void logIn(UniversitySystemTester UST, UniversitySystem US) {
		UST.println("Enter id: ");
		int id = UST.readInt();
		UST.println("Enter password: ");
		String pass = UST.read();

		UST.println(US.getAllUsers().toString());
		
		UST.println("id = " + id + " pass = " + pass);

		try {
			u = US.autorise(id, pass);
			if (u instanceof Student) {
				//return studentMenu();
			} else if (u instanceof Teacher) {
				UST.println("te");
				//return teacherMenu();
			} else if (u instanceof Manager) {
				UST.println("ma");
				//continue managerMenu;
			} else if (u instanceof TechSupport) {
				UST.println("tec");
				//continue techSupportMenu;
			} else if (u instanceof Admin) {
				UST.println("ad");
				//continue adminMenu;
			}
			return;

		} catch (Exception e) {
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
		
		return;
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

		u = createUser(userType, pass, US);
		US.register(u);

		UST.println("Registration is over");
		UST.println(US.getAllUsers().toString());

		UST.println("1) Register one more user");
		UST.println("2) Back to menu");

		if (UST.readInt() == 1) register(UST, US);
		if (UST.readInt() == 2) menu(UST, US);
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
				case 2:
					register(UST, US);
				default:
					UST.println("Bye!!!"); 
					UST.save();
			}
		} catch (Exception e) {
			System.out.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();
			UST.save();
		}
	}
	
	public static void main(String[] args) {
		UniversitySystemTester UST = new UniversitySystemTester();
		
		if (new File("backUp").exists()) { UST.load(); }
		
		UniversitySystem US = UniversitySystem.getInstance();
		/*UST.menu(UST, US);*/
		ManagerTester.menu(UST, US);
	}
}