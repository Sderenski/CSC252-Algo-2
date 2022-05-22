package algo.data.structures.MazeSolverConsole;

import algo.data.structures.MazeSolverConsole.MazeStuff.Maze;
import algo.data.structures.MazeSolverConsole.MazeStuff.MazeNode;
import algo.data.structures.MazeSolverConsole.MazeStuff.Parsing;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args){
        // Test whether or not the parsing class is doing it right. and how it looks
        HashMap<Integer, ArrayList<String>> returnLines = Parsing.fileParsing();
        for(var key : returnLines.keySet()){
            System.out.println(key);
            for(var line : returnLines.get(key)){
                System.out.println(line);
            }
        }

        // A full working Graph Data Structure....
        System.out.println("\n\n\n");

        String nodeList = returnLines.get(1).get(0);
        String pathNode = returnLines.get(1).get(1);
        returnLines.get(1).remove(0);
        returnLines.get(1).remove(1);
        Maze test1 = new Maze(nodeList, pathNode, returnLines.get(1));
        for(var node : test1.allNodes){
            System.out.print(node.getName() + " ");
        }
        System.out.println();
        System.out.println("Start: " + test1.start.getName());
        System.out.println("End: " + test1.end.getName());
        for(MazeNode node : test1.allNodes){
            System.out.println();
            System.out.print(node.getName() + ": ");
            for(MazeNode conNode : node.getNodeConnections()){
                System.out.print(conNode.getName() + " ");
            }
        }



//        var maze = new Maze();
//
//        // Parse the file and create the nodes!
//        // Testing the thingy
//        var nodeA = new MazeNode("A");
//        var nodeB = new MazeNode("B");
//        var nodeC = new MazeNode("C");
//
//        maze.allNodes.add(nodeA);
//        maze.allNodes.add(nodeB);
//        maze.allNodes.add(nodeC);
//
//        maze.start = nodeA;
//        maze.end = nodeB;
        // Tell the maze to solve itself


    }
}
