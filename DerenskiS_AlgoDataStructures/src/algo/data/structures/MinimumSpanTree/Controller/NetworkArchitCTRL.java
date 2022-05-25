package algo.data.structures.MinimumSpanTree.Controller;


import algo.data.structures.MinimumSpanTree.Model.NetNode;
import algo.data.structures.MinimumSpanTree.Model.Network;
import algo.data.structures.MinimumSpanTree.Parsing;

import java.util.ArrayList;


public class NetworkArchitCTRL {
    private Network network;

    public void run(){
        parseHashmap();
        displayExample();
    }

    private void parseHashmap() {
        ArrayList<String> returnLines = Parsing.fileParsing();
        String nodeList = returnLines.get(0);
        returnLines.remove(0);

        network = new Network(nodeList, returnLines);
    }

    private void displayExample() {
        for(NetNode node : network.allNodes){
            System.out.println("\n"+node.getName());
            for (var key : node.getNodeConnections().keySet()){
                System.out.print("\n"+key.getName() + ": ");
                System.out.print(node.getNodeConnections().get(key).getWeight());
            }
            System.out.println();
        }
    }
}

