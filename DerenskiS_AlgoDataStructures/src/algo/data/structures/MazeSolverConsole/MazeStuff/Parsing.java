package algo.data.structures.MazeSolverConsole.MazeStuff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Parsing {
    // Using the absolute path for right now
    private static String fileString = "C:\\Users\\sderenski\\Documents\\Neumont\\2022 Spring\\CSC252 - Algo 2\\DerenskiS_AlgoDataStructures\\src\\algo\\data\\structures\\MazeSolverConsole\\Resources\\TestMazes.txt";
    private static BufferedReader input = null;
    private static Scanner scanner = new Scanner(System.in);



    // Could I try to split the data at the white space into different arraylists?
    // Then put them into a hashmap?

    public static HashMap<Integer, ArrayList<String>> fileParsing(){
        HashMap<Integer, ArrayList<String>> fileMaps = new HashMap<>();
        int hashCounter = 0;
        boolean quit = false;
        while(!quit){
            try{
                //fileString = getString("Enter in File Path: ");
                input = new BufferedReader(new FileReader(fileString));
                String line = input.readLine();
                fileMaps.put(hashCounter, new ArrayList<>());
                while(line != null){
                    if(line.equals("")) {
                        hashCounter++;
                        fileMaps.put(hashCounter, new ArrayList<>());
                        line = input.readLine();
                    } else if(line.startsWith("/")){
                        line = input.readLine();
                    }else {
                        fileMaps.get(hashCounter).add(line);
                        line = input.readLine();
                    }
                }
                input.close();
                quit = true;
            }catch(Exception e){
                System.out.println("That file doesn't exist");
            }
        }
        return fileMaps;
    }


    // Static functions
    private static String getString(String prompt) {
        System.out.print(prompt);
        // returns a string
        return scanner.nextLine();
    }


}
