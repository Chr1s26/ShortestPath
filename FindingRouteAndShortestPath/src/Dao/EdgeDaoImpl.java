package Dao;

import java.util.ArrayList;
import java.util.List;

import Model.Edge;

public class EdgeDaoImpl implements EdgeDao {
	
	private static List<Edge> edges = new ArrayList<Edge>();
	
	
	@Override
	public void addEdge(Edge edge) {
		edges.add(edge);
	}

	@Override
	public List<Edge> getEdge() {
		return edges;
	}
	

}
