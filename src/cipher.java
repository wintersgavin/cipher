import java.io.File; 
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class cipher {

    public static String encrypt(int num, String input) {
        int i = 0;
        String empt = "";
        while(i < input.length()) {
            char sing = input.charAt(i);
            sing += num;
            empt += sing;
            i++;
        }
        return empt;
    }

    public static String decrypt(int num, String input) {
        System.out.println();
        System.out.println(input);
        int i = 0;
        String empt = "";
        while(i < input.length()) {
            char sing = input.charAt(i);
            sing -= num;
            empt += sing;
            i++;
        }
        System.out.print(empt);
        return empt;
    }//

    public static void createFile(String pathname) {
        try {
            File myObj = new File(pathname);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
            else {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeFile(String input, String pathname) {
        try {
            FileWriter myWriter = new FileWriter(pathname);
            myWriter.write(input);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static List<String> readFile(String pathname) {
        List<String> values = new ArrayList<>();
        try {
            File myObj = new File(pathname);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                values.add(data);
                System.out.println(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return values;
    }

    public static void main(String[] args) {

        //comment from here

        int num = 2;
        //any number (as long it's real) can be used, but most of the time it won't end up in the alphabet
        String fileName = "encrypted.txt";
        //specifies the file name that you can find in IntelliJ's project directory (same one as where the project is stored)
        String decryptFile = "decrypted.txt";
        //same thing different name
        System.out.println("Encryption number: " + num);
        //prints a message specifying the number of characters you moved from the original, any number can be used
        String input = "chicken wing chicken wing";
        //fun fact: this has every character of the alphabet in it
        createFile(fileName);
        //creates a new file
        writeFile(encrypt(num,input),fileName);
        //writes to the new file the contents of the encrypt function
        List<String> reader = readFile(fileName);
        //creates a list string based on the output of the readFile (which is a list of strings)
        createFile(decryptFile);
        //new file to store decrypted message in
        int i = 0;
        while(i < reader.toArray().length) {
            //makes the list of strings an array of strings, and gets the length
            writeFile(decrypt(num,reader.get(i)),decryptFile);
            //writes to the file the decrypted message based on the line of text we are on
            //so this will work with multiple lines of text
            i++;
        }//while

        //comment to here (details listed below)

        /*included below is a method commented out to read from a file that you already have in the directory
        encrypt or decrypt it at you will
        THIS WILL NOT CREATE A NEW FILE, THE FILE NEEDS TO BE IN THE DIRECTORY FOR THIS TO WORK
        IT WILL ONLY CREATE THE OPPOSITE VERSION OF WHATEVER YOU CHOOSE, SO IF YOU CHOOSE TO ENCRYPT, 
        IT WILL ENCRYPT OR VICE VERSA, DO NOT DO BOTH AT THE SAME TIME, AS THERE IS ONLY ONE FILE
        also if you do use this, make sur eto comment out the selected lines above to stop them from running
        * /
        //^ delete the space here if you want the below section to run
        
        int yourNum = 0; //any number you choose here
        String yourFile = "C:/Users/gavin/IdeaProjects/cipher/src/MLK.txt";

        List<String> readYourFile = readFile(yourFile);

        String opp = "opposite";
        createFile(opp);
        int j = 0;
        while(j < readYourFile.toArray().length) {

            writeFile(decrypt(yourNum, readYourFile.get(j)),opp); //encrypted text to decrypted text
            writeFile(encrypt(yourNum, readYourFile.get(j)),opp); //decrypted text to encrypted text

        }//while
        //*/

    }//main(String[] args)
}//cipher