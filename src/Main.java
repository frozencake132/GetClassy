import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
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
        do
        {
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
        while(!doneInput);
    }
}