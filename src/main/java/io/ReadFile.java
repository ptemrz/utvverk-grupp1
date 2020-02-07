package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import domain.Contact;
import domain.ContactBook;

public class ReadFile {

			ContactBook cb = new ContactBook();
			
			public String readfile() {
				File file = new File("my content");
				for (Contact arquive : cb) {
					
						
					}

			File file = new File("");
			FileReader fr = null;
			{

				try {
					fr = new FileReader(file);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BufferedReader br = new BufferedReader(fr);

				String line = "";
				try {
					line = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return line;
			}
		}
	}
}