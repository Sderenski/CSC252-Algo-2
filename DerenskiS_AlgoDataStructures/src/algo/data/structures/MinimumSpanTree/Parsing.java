package algo.data.structures.MinimumSpanTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Parsing {
    private static String fileString;
    private static BufferedReader input = null;
    private static Scanner scanner = new Scanner(System.in);



    // Could I try to split the data at the white space into different arraylists?
    // Then put them into a hashmap?

    public static ArrayList<String> fileParsing(){
        ArrayList<String> stringArray = new ArrayList<>();
        int hashCounter = 0;
        boolean quit = false;
        while(!quit){
            try{
                fileString = getString("Enter in File Path: ");
                input = new BufferedReader(new FileReader(fileString));
                String line = input.readLine();
                while(line != null){
                    stringArray.add(line);
                    line = input.readLine();
                }
                input.close();
                quit = true;
            }catch(Exception e){
                System.out.println("That file doesn't exist");
            }
        }
        return stringArray;
    }


    // Static functions
    private static String getString(String prompt) {
        System.out.print(prompt);
        // returns a string
        return scanner.nextLine();
    }

}
