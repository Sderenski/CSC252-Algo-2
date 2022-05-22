package algo.data.structures.MazeSolverConsole.MazeStuff;

import java.util.ArrayList;

public class MazeNode {
    // Name/value
    private final String name;

    // List of nodes
    private ArrayList<MazeNode> nodeConnections = new ArrayList<>();

    public MazeNode(String name){
        this.name = name;
    }

    public String getName() { return this.name; }

    public ArrayList<MazeNode> getNodeConnections() {
        return nodeConnections;
    }

    public void setNodeConnections(ArrayList<MazeNode> nodeConnections) {
        this.nodeConnections = nodeConnections;
    }
}
