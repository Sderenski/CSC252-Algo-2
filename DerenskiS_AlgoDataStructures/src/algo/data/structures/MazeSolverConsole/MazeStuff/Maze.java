package algo.data.structures.MazeSolverConsole.MazeStuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Maze {
    public ArrayList<MazeNode> allNodes = new ArrayList<>();

    public MazeNode start;
    public MazeNode end;

    private int solCount = 1;
    public HashMap<Integer, Stack<MazeNode>> solutions = new HashMap<>();

    /*
        Parsing is finished for the most part now
        What can I do with this data to start creating the Nodes???

        When creating the maze how do we load these

     */

    // Add the creation of the start and end nodes
    public Maze(String listNode, String pathNodes, ArrayList<String> conn){
        createNodes(listNode);
        settingPath(pathNodes);
        settingNodeConnections(conn);
    }

    // A function that creates and adds the nodes to the maze object.
    private void createNodes(String list){
        ArrayList<Character> nodeNames = new ArrayList<>();
        char[] listArr = list.toCharArray();
        for(int i = 0; i < listArr.length; i++) {
            if (listArr[i] != ',') {
                nodeNames.add(listArr[i]);
            }
        }
        for(char name : nodeNames){
            allNodes.add(new MazeNode(String.valueOf(name)));
        }
    }

    // Setting the Start and end nodes from the second line...
    private void settingPath(String list){
        String[] arrStr = list.split(",");
        for(MazeNode node : allNodes){
            if(node.getName().equals(arrStr[0])){
                this.start = node;
            }else if (node.getName().equals(arrStr[1])){
                this.end = node;
            }
        }
    }


    // Get the way to establish each of the connections for the nodes.
    private void settingNodeConnections(ArrayList<String> connectionStrs){
        // Loop through the strings and parse them to find the nodes. The first one
        // represents the node that will have the following connections
        for(String nodeConList : connectionStrs) {
            // the first node in the string list is the node that the connections will be added to.
            String[] nodeArr = nodeConList.split(",");
            ArrayList<MazeNode> connections = new ArrayList<>();
            for(MazeNode nodeSet : allNodes){
                if(nodeSet.getName().equals(nodeArr[0])) {
                    for(int i = 1; i < nodeArr.length; i++){
                        for(MazeNode nodeCon : allNodes) {
                            if(nodeCon.getName().equals(nodeArr[i])) {
                                connections.add(nodeCon);
                            }
                        }
                    }
                    nodeSet.setNodeConnections(connections);
                }
            }
        }
    }

    // Solver for the graph.
    public void solve(){
        Stack<MazeNode> visited = new Stack<>();
        visited.push(start);
        solutions.put(solCount, new Stack<MazeNode>());
        solutions.get(solCount).push(start);
        for(MazeNode subnode : start.getNodeConnections()){
            solveR(subnode, visited);
        }
        if(solutions.get(solCount).empty() || solutions.get(solCount).size() == 1) solutions.remove(solCount);
    }

    private void solveR(MazeNode node, Stack<MazeNode> visited){
        visited.push(node);
        solutions.get(solCount).push(node);
        for(MazeNode subnode : node.getNodeConnections()){
            if(!visited.contains(subnode)){
                solveR(subnode, visited);
            }
        }
        if(node.getName() == end.getName()) {
            solCount++;
            solutions.put(solCount, new Stack<MazeNode>());
        }
        else {
            if(!solutions.get(solCount).empty()) solutions.get(solCount).pop();
            visited.pop();
        }
    }

}
