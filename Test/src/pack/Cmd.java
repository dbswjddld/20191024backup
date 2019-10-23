package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Cmd {
	private StringBuffer buffer;
	private Process process;
	private BufferedReader bufferedReader;
	private StringBuffer readBuffer;
	
	public String inputCommand(String cmd) {
		buffer = new StringBuffer();
		
		buffer.append("cmd");
		buffer.append(cmd);
		
		return buffer.toString();
	}
	
	public String execCommand(String cmd) {
		String line = null;
		try {
			process = new ProcessBuilder("sqlplus", "/","as","sysdba").start();
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "EUC-KR"));
			readBuffer = new StringBuffer();
			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "EUC-KR"));
			readBuffer = new StringBuffer();
			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}
}
