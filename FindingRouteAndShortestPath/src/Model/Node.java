package Model;

public class Node {
	
	private String name;
	private Node childNode;
	private Node parentNode;
	private double distance;
	
	public Node(String name) {
		this.name = name;
		this.distance = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getChildNode() {
		return childNode;
	}

	public void setChildNode(Node childNode) {
		this.childNode = childNode;
		childNode.setParentNode(this);
	}

	public Node getParentNode() {
		return parentNode;
	}

	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public boolean equals(Node obj) {
		 if(obj==null) {
			 return false;
		 }
		return this.name.equals(obj.getName());
	}


}
