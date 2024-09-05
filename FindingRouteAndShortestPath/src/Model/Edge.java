package Model;

public class Edge {

	private Node startNode;
	private Node endNode;
	private double weight;
	
	public Edge(Node starNode, Node endNode, double weight) {
		this.startNode = starNode;
		this.endNode = endNode;
		this.weight = weight;
	}

	public Node getStartNode() {
		return startNode;
	}

	public void setStartNode(Node startNode) {
		this.startNode = startNode;
	}

	public Node getEndNode() {
		return endNode;
	}

	public void setEndNode(Node endNode) {
		this.endNode = endNode;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Edge [startNode=" + startNode.getName() + ", endNode=" + endNode.getName() + ", weight=" + weight + "]";
	}
	
	
}
