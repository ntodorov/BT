import java.io.Console;
import java.nio.file.Path;
import java.util.*;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Write a description of class Morse here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Morse {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Binary Tree Test\n");

        int choice;
        Enigma en;
        Path codesTXT = Paths.get(System.getProperty("user.dir"), "../codes.txt");
        String userText;

        do {
            System.out.println("\nBinary Tree Operations\n");
            System.out.println("0. print the tree ");
            System.out.println("1. encode ");
            System.out.println("2. decode");
            System.out.println("3. quit");

            choice = scan.nextInt();
            switch (choice) {
                case 0:
                    en = new Enigma();
                    en.readTextFile(codesTXT.toString());

                    System.out.println("tree size:" + en.treeSize());
                    en.print();
                    break;
                case 1:
                    en = new Enigma();
                    en.readTextFile(codesTXT.toString());

                    System.out.println("Enter text to encode");
                    //for some reason the main scanner does not work here. Creating new fixes the issue.
                    Scanner in1 = new Scanner(System.in);
                    userText = in1.nextLine();
                    System.out.println("Encoded: "+ en.encode(userText));
                    break;
                case 2:
                    en = new Enigma();
                    en.readTextFile(codesTXT.toString());
                    System.out.print("Please enter text to decode : ");
                    Scanner in = new Scanner(System.in);
                    userText = in.nextLine();
                    System.out.println("Decoded: " + en.decode(userText));
                    break;
                case 3:
                    System.out.println("Have a nice day!");
                    break;

                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }

        } while (choice != 3);

        scan.close();
    }

}
