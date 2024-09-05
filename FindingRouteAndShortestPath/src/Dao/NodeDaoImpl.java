package Dao;

import java.util.ArrayList;
import java.util.List;

import Model.Node;

public class NodeDaoImpl implements NodeDao {

	private static List<Node> nodes = new ArrayList<Node>();
	
	@Override
	public void addNode(Node node) {
		nodes.add(node);
	}

	@Override
	public List<Node> getNode() {
		return nodes;
	}
}
