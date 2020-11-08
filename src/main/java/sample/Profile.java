package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Profile {

    static String username;
    static String password;
    static String[] likings = new String[7];
    static String fileName = "profile.txt";

    /**
     * Reads data from Profile file and extracts username, password and likings,
     * which are then stored for easy access in their respective static variable.
     */
    public static void load() {
        String profileData = "";
        try {
            profileData = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            System.out.println(e.fillInStackTrace());
        }

        //Extract username
        int pos = profileData.indexOf("}");
        username = profileData.substring(1, pos);
        profileData = profileData.substring(pos + 1);

        //Extract password
        pos = profileData.indexOf("}");
        password = profileData.substring(1, pos);
        profileData = profileData.substring(pos + 2);

        //Extract likings/Dumb Hardcoding
        for (int i = 0; i < likings.length - 1; i++) {
            pos = profileData.indexOf(",");
            likings[i] = profileData.substring(0, pos);

            profileData = profileData.substring(pos + 1);
        }
        pos = profileData.indexOf("}");
        likings[likings.length - 1] = profileData.substring(0, pos);
        profileData = profileData.substring(pos + 1);

        return;
    }

	/**
	 * Saves the @profileData to the profile file
	 * @param profileData
	 */
	public static void save(String profileData) {
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

	/**
	 * Creates new empty profile file
	 */
	public static void create() {
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
