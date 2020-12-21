package testers;

import main.*;

public class UniversitySystemTester {

	public static void main(String[] args) {
/*		
		Admin a = new Admin("123");
		UniversitySystem.getInstance().register(a);
		a.updateInfo(a, "name", "Islam");
*/

		try {
			UniversitySystem.deserialize();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(UniversitySystem.getInstance().getUser(0));
/*	
		try {
			UniversitySystem.serialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
*/
	}
}
