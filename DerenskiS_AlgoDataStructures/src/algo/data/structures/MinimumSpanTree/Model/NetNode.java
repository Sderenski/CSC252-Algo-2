package algo.data.structures.MinimumSpanTree.Model;

import java.util.HashMap;

public class NetNode {

    // Name/value
    private final String name;

    // List of nodes with weights
    // Created an Edge Object for each connection. Store in a hashmap
    private HashMap<NetNode, NetEdge> nodeConnections = new HashMap<>();

    private boolean vistied = false;

    public NetNode(String name){
        this.name = name;
    }

    public String getName() { return this.name; }

    public HashMap<NetNode, NetEdge> getNodeConnections() {
        return nodeConnections;
    }

    public void setNodeConnections(HashMap<NetNode, NetEdge> nodeConnections) {
        this.nodeConnections = nodeConnections;
    }

    public void setVistied(boolean bool){
        this.vistied = bool;
    }

    public boolean getVisited() {
        return this.vistied;
    }
}
