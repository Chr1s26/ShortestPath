package Dao;

import java.util.List;

import Model.Node;

public interface NodeDao {

	void addNode(Node node);
	List<Node> getNode();

}
