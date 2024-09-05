package Dao;

import java.util.List;

import Model.Edge;

public interface EdgeDao {

	void addEdge(Edge edge);
	List<Edge> getEdge();
}
