import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Profile {

    static private String username;
    static private String password;
    static private Boolean[] likings;
	static String fileName = "profile.txt";

	public static String load() {
		String profileData = "";
    	try {
			profileData =  new String(Files.readAllBytes(Paths.get(fileName)));
		} catch (IOException e) {
    		System.out.println(e.fillInStackTrace());
		}

    	//Extract username
		int pos = profileData.indexOf("}");
		username = profileData.substring(1, pos);
		profileData = profileData.substring(pos+1);

		//Extract password
		pos = profileData.indexOf("}");
		password = profileData.substring(1, pos);
		profileData = profileData.substring(pos+1);

		//Extract likings
		int count = 0;
		for (int i = 0; i < profileData.length(); i++) {
			if (profileData.charAt(i) == ',') {
				count++;
			}
		}

		likings = new Boolean[count+1];
		for (int i=0; profileData != "}"; i++){
			pos = profileData.indexOf(",");
			if (profileData.substring(1, pos) == "true")
				likings[i] = true;
			else
				likings[i] = false;
			profileData = profileData.substring(pos+1);
		}


		System.out.println(profileData);



    	return profileData;
	}

	public static void save(String profileData){
		try {
			FileWriter fw = new FileWriter("profile.txt");
			fw.write(profileData);
			fw.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void create(){
		try {
			File f = new File("profile.txt");
			if (f.createNewFile()) {
				System.out.println("File created: " + f.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}


}
