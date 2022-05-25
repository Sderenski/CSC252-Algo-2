package algo.data.structures.MazeSolverConsole.MazeStuff;

import java.util.ArrayList;
import java.util.HashMap;

public class MazeController {

    private ArrayList<Maze> mazeList = new ArrayList<>();
    public void run() {
        parseHashMap();
        displaySol();
    }

    private void parseHashMap() {
        HashMap<Integer, ArrayList<String>> returnLines = Parsing.fileParsing();
        for(int key : returnLines.keySet()){
            String nodeList = returnLines.get(key).get(0);
            String pathNode = returnLines.get(key).get(1);
            returnLines.get(key).remove(0);
            returnLines.get(key).remove(0);

            mazeList.add(new Maze(nodeList, pathNode, returnLines.get(key)));
        }
    }

    private void displaySol() {
        for(Maze maze : mazeList){
            maze.solve();
            System.out.println("\nSolutions:\n");
            if(!maze.solutions.isEmpty()) {
                for (var key : maze.solutions.keySet()) {
                    System.out.print(key + ": ");
                    for (var elm : maze.solutions.get(key)) {
                        System.out.print(elm.getName() + " ");
                    }
                    System.out.println();
                }
            } else System.out.println("No Solution");
        }
    }
}
