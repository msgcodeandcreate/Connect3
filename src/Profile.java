import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Profile {

    static String username;
    static String password;
    static String[] likings = new String[7];
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
		profileData = profileData.substring(pos+2);

		//Extract likings/Dumb Hardcoding
		for (int i=0; i < likings.length-1; i++){
			pos = profileData.indexOf(",");
			System.out.println(profileData.substring(0, pos));
			likings[i] = profileData.substring(0, pos);

			profileData = profileData.substring(pos+1);
			System.out.println(profileData);
		}
		pos = profileData.indexOf("}");
		likings[likings.length-1] = profileData.substring(0, pos);
		profileData = profileData.substring(pos+1);

		for (String bool : likings){
			System.out.println(bool);
		}


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
