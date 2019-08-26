package com.megacrm.utils;

import java.io.*;

public class FileOpertionUtils {
	
	public void writeIntoFile(String file123) {
		String str123 = "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic lif";
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(file123);

			for (int i = 0; i < 1000; i++) {
				fw.write(str123);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			UtilsFactory.close(fw);
		}
	}
	
	public void readFromFile(String file123) {
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream(file123);
			byte[] b = new byte[1024*4];
			
			while( fin.read(b) != -1 );
			
		}	catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
			e.printStackTrace();
		}	catch (IOException e1) {
			System.out.println("Error Reading The File.");
			e1.printStackTrace();
		} finally {
			UtilsFactory.close(fin);
		}
		
	}

	
	public static void main(String[] args){
		try {
			File file = new File("123.txt");
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		FileOpertionUtils writefile = new FileOpertionUtils();
		writefile.writeIntoFile("123.txt");
	}
}
