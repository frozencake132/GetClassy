import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {
        // Variables
        Scanner in = new Scanner(System.in);

        boolean doneInput = false;
        String id = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int YOB = 0;
        String rec = "";

        ArrayList<String> people = new ArrayList<>();

        // Create a loop to input a persons data
        do {
            id = SafeInput.getNonZeroLenString(in, "Enter your ID [000001]");
            firstName = SafeInput.getNonZeroLenString(in, "Enter your first name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter your last name");
            title = SafeInput.getNonZeroLenString(in, "Enter your title");
            YOB = SafeInput.getRangedInt(in, "Enter your year of birth [YYYY]", 1000, 9999);

            rec = id + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
            people.add(rec);
            System.out.println("You have entered: " + people.get(people.size() - 1));

            doneInput = SafeInput.getYNConfirm(in, "Are you done?");
        }
        while (!doneInput);


        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.txt");

        try {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for (String person : people) {
                writer.write(person, 0, person.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // person. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}