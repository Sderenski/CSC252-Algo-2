package algo.data.structures.MinimumSpanTree.Model;

public class NetEdge {

    private boolean keep = false;
    private int weight;

    public NetEdge(int weight) { this.weight = weight; }

    public int getWeight() { return this.weight; }

    public void setKeep(boolean keep){ this.keep = keep; }

    public boolean getKeep() { return this.keep; }
}
