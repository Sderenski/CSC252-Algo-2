package algo.data.structures.MinimumSpanTree.Model;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class Network {

    public ArrayList<NetNode> allNodes = new ArrayList<>();
    public ArrayList<NetNode> visitedNodes = new ArrayList<>();

    // TODO I have finished setting up the graph with the weighted edges on the node connections....

    // Add the creation of the start and end nodes
    public Network(String listNode, ArrayList<String> conn){
        createNodes(listNode);
        settingNodeConnections(conn);
        primSolve();
    }

    // A function that creates and adds the nodes to the maze object.
    private void createNodes(String list){
        String[] nodeNames = list.split(",");
        for(String node : nodeNames){
            allNodes.add(new NetNode(node));
        }

    }


    // Get the way to establish each of the connections for the nodes.
    private void settingNodeConnections(ArrayList<String> connectionStrs){
        // Loop through the node list and then add to the hashmap of connections.
        for(String nodeConnList : connectionStrs){
            String[] nodeArr = nodeConnList.split(",");
            HashMap<NetNode, NetEdge> connections = new HashMap<>();
            for(NetNode nodeSet : allNodes) {
                if(nodeSet.getName().equals(nodeArr[0])){
                    for(int i = 1; i < nodeArr.length; i++){
                        String[] nodeArt = nodeArr[i].split(":");
                        for(NetNode nodeCon : allNodes) {
                            if(nodeCon.getName().equals(nodeArt[0])) {
                                connections.put(nodeCon, new NetEdge(Integer.parseInt(nodeArt[1])));
                            }
                        }
                    }
                    nodeSet.setNodeConnections(connections);
                }
            }
        }
    }

    // Now it is time to solve this bitch
    // We have to choose between prim's or kurskal's algorithm to solve the shortest path forward....
    // I will be trying to use Prim's algo for this. Just have to understand how to structure
    // the data to sort and search through...


    // Use an Array list of pairs to link nodes and weights.
    public void primSolve(){
        visitedNodes.clear();

        //Loops through all the nodes in the graph
        for(NetNode nodeBase : allNodes){
            // Creates a temp node for to hold the value
            NetNode hashKeyNode = new NetNode("null");
            // Loops through and compares to add the values
            for(NetNode nodeCon : nodeBase.getNodeConnections().keySet()){
                if(!visitedNodes.contains(nodeCon)){
                    // How will the logic work in this section? It will have to go through each and then figure out... wait
                    // What if they do what it is normally then do the check before leaving the node. IF true, leaves the value,
                    // if false dumps it.....
                    if(hashKeyNode.getName().equals("null")) hashKeyNode = nodeCon;
                    // Maybe call the loop system again as you are checking them.....
                    else if(nodeBase.getNodeConnections().get(nodeCon).getWeight() < nodeBase.getNodeConnections().get(hashKeyNode).getWeight()){
                        hashKeyNode = nodeCon;
                    }
//                    if(checkVisitedList(hashKeyNode)){
//                        hashKeyNode = null;
//                    }
                }
            }
            // Makes sure that it found a node to add
            addingFunction(hashKeyNode, nodeBase);
        }
        // Calculates the length of the path taken by the weights of the connections
        int feetCount = countFeet(visitedNodes);
        System.out.println("Cable Length in Feet: " + feetCount);
    }

    private int countFeet(ArrayList<NetNode> nodeList){
        int countFeet = 0;
        for(NetNode nodeBase : nodeList){
            for(var key : nodeBase.getNodeConnections().keySet()){
                if(nodeBase.getNodeConnections().get(key).getKeep()){
                    countFeet += nodeBase.getNodeConnections().get(key).getWeight();
                }
            }
        }
        return countFeet;
    }

    private void addingFunction(NetNode hashKeyNode, NetNode nodeBase){
        if(!hashKeyNode.getName().equals("null")) {
            nodeBase.getNodeConnections().get(hashKeyNode).setKeep(true);
            visitedNodes.add(hashKeyNode);
        }
    }

    // Have another method to check the visited list to verify that the list is the shortest possible.
    // There is an issue with how I am handling the checking of the node....
    private boolean checkVisitedList(NetNode nodeConCompare) {
        /*
            What am I doing wrong to check these.........
            Sit and think about it a little more....
         */
        boolean result = false;
        for(NetNode nodeBase : allNodes){
            NetNode hashKeyNode = new NetNode("null");
            // Loops through and compares to add the values
            for(NetNode nodeCon : nodeBase.getNodeConnections().keySet()){
                // Maybe call the loop system again as you are checking them.....
                // How do we work this logic? Do we add all the checks or no
                if(nodeCon.getName().equals(nodeConCompare.getName())) {
                    if (nodeBase.getNodeConnections().get(nodeCon).getWeight() < nodeBase.getNodeConnections().get(nodeConCompare).getWeight()) {
                        hashKeyNode = nodeCon;
                        result = true;
                    }
                }
            }
            // Adding the Shorter path...
            if(result) addingFunction(hashKeyNode, nodeBase);
        }

        return result;
    }
}
