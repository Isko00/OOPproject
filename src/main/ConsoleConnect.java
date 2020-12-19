package main;
import java.io.*;

public abstract class ConsoleConnect {
	private static InputStreamReader isr;
	private static BufferedReader reader;
	
	private static OutputStreamWriter osw;
	private static BufferedWriter writer;
	
	private ConsoleConnect() {}
	
	private static void assign() {
		isr = new InputStreamReader(System.in);
		reader = new BufferedReader(isr);
	
		osw = new OutputStreamWriter(System.out);
		writer = new BufferedWriter(osw);
	}
	
	private static void print(String text) {
		try {
			writer.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String read() {
		String input = "";
    	try {
    		input = reader.readLine();
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	return input;
	}

    private static void closeStreams() {
    	try {
			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public static String exchangeMessages(String text) {
    	assign();
    	/*if (text.length() == 0) {
    		closeStreams();
    		return "";
    	}*/
    	print(text);
    	print("qwe");
    	String answer = "qwe"/*getAnswer()*/;
    	return answer;
    }
}