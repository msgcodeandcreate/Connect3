import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Profile {

    static public String username;
    static String password;
    static public String[] likings = new String[7];
	static String fileName = "profile.txt";

	public static void load() {
		String profileData = "";
    	try {
			profileData =  new String(Files.readAllBytes(Paths.get(fileName)));
		} catch (IOException e) {
    		System.out.println(e.fillInStackTrace());
		}
    	String tmp = profileData;

    	//Extract username
		int pos = tmp.indexOf("}");
		username = tmp.substring(1, pos);
		tmp = tmp.substring(pos+1);

		//Extract password
		pos = tmp.indexOf("}");
		password = tmp.substring(1, pos);
		tmp = tmp.substring(pos+2);

		//Extract likings/Dumb Hardcoding
		for (int i=0; i < likings.length-1; i++){
			pos = tmp.indexOf(",");
			likings[i] = tmp.substring(0, pos);

			tmp = tmp.substring(pos+1);
		}
		pos = tmp.indexOf("}");
		likings[likings.length-1] = tmp.substring(0, pos);
		tmp = tmp.substring(pos+1);

    	return;
	}

	public static void save(){
		try {
			//Prepare for more dumb hardcoding
			FileWriter fw = new FileWriter("profile.txt");
			fw.write("{"+username+"}{"+password+"}{"+likings[0]+","+likings[1]+","+likings[2]+","+likings[3]+","+likings[4]+","+likings[5]+","+likings[6]+"}");
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
				System.out.println("Profile created.");
			} else {
				System.out.println("Profile already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}


}
