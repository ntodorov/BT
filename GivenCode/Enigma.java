import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.IOException;


/**
 * Write a description of class Enigma here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enigma {
    // instance variables - replace the example below with your own
    private BinaryTree<Character> bt;

    private String[] encArr;
    private HashMap<Character, String> table;

    /**
     * Constructor for objects of class Enigma
     */
    public Enigma() {
        // initialise instance variables - main root is # never used as per the requirements.
        bt = new BinaryTree<Character>('#');

        table = new HashMap<Character, String>();

        encArr = new String[26];


    }

    void readTextFile(String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        try (Scanner scanner = new Scanner(path, StandardCharsets.UTF_8.name())) {
            while (scanner.hasNextLine()) {
                processLine(scanner.nextLine());
            }
        }

        //fill up the encoding array
        for (int i = 65; i <= 90; i++) {
            String code = (String)table.get((char)i);

            encArr[i - 65] = code;
        }
    }

    protected void processLine(String aLine) {

//        System.out.println(aLine);

        String[] parts = aLine.split(" ");
        char letter = parts[0].charAt(0);
        char[] morseCode = parts[1].toCharArray();

        //fill the hashmap
        table.put(letter, parts[1]);

        //fill the tree
        addChar(letter, morseCode, 0, bt.getRoot());
    }

    public void addChar(char ch, char[] code, int codeInd, BTNode<Character> node) {

//        System.out.println("addChar: " + ch + "  " + code[codeInd] + "  " + codeInd);

        if (codeInd == code.length - 1) {
            if (code[codeInd] == '.') {
                node.setLeft(new BTNode<Character>(ch));
//                System.out.println("addChar - left: " + ch + " parent: " + node.getElement());
            } else {
                node.setRight(new BTNode<Character>(ch));
//                System.out.println("addChar - right: " + ch + " parent: " + node.getElement());
            }
        } else {
            if (code[codeInd] == '.') {
                addChar(ch, code, ++codeInd, node.getLeft());
            } else {
                addChar(ch, code, ++codeInd, node.getRight());
            }
        }
    }

    //the print method from the requirements - it uses the iterator
    public void print() {
        Iterator<Character> i = bt.iterator();

        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    public int treeSize() {
        return bt.size();
    }

    private String getChar(char[] morseCode, int codeInd, BTNode<Character> node) {

        String result = "";

        if (codeInd == morseCode.length - 1) {
            if (morseCode[codeInd] == '.') {
                result = node.getLeft().getElement().toString();
            } else {
                result = node.getRight().getElement().toString();
            }
        } else {
            if (morseCode[codeInd] == '.') {
                result = getChar(morseCode, ++codeInd, node.getLeft());
            } else {
                result = getChar(morseCode, ++codeInd, node.getRight());
            }
        }

        return result;
    }

    public String decode(String aLine) {

        String result = "";

        String[] words = aLine.split("       ");


        for (String word : words) {
            String[] letters = word.split("   ");
            for (String letter : letters) {
                result += getChar(letter.toCharArray(), 0, bt.getRoot());
            }
            result += " ";
        }

        return result;
    }

    private String encodeChar(Character letter) {

        table.getOrDefault(letter, "");

        //adding 3 spaces after the morse code
        return table.getOrDefault(letter, "") + "   ";
    }

    public String encode(String aLine) {

        String result = "";

        String[] words = aLine.toUpperCase().split(" ");

        for (String word : words) {
            char[] letters = word.toCharArray();
            for (Character letter : letters) {
                result += encodeChar(letter);
            }

            //adding 7 spaces after the word
            result += "       ";
        }

        return result;
    }
}
