import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Profile {

    private String username;
    private String password;
	static String fileName = "profile.txt";


    public Profile(String username, String password) {
        this.username = username;
        this.password = password;
    }

	public static String load() {
    	try {
			return new String(Files.readAllBytes(Paths.get(fileName)));
		} catch (IOException e) {
    		System.out.println(e.fillInStackTrace());
    		return "";
		}
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
