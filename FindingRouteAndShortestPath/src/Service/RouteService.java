package Service;

import java.util.ArrayList;
import java.util.List;

import Dao.EdgeDao;
import Dao.EdgeDaoImpl;
import Dao.NodeDao;
import Dao.NodeDaoImpl;
import Model.Edge;
import Model.Node;

public class RouteService {
	
	public NodeDao nodeDao;
	public EdgeDao edgeDao;
	public List<Edge> edges;
	public Node startNode;
	private static List<Node> routes;
	
	public RouteService() {
		nodeDao = new NodeDaoImpl();
		edgeDao = new EdgeDaoImpl();
		edges = edgeDao.getEdge();
		routes = new ArrayList<>();
	} 
	
	
	
	public void getAllRoutes() {
		routes.clear();
		for(Node nodes : nodeDao.getNode() ) {
			this.startNode = nodes;
			this.FindAllPath(nodes, nodes.getParentNode());
		}
		for(Node path : routes) {
			display(path, "");
		} 
	}
	
	
	
	public void FindAllPath(Node nodes, Node previousNode) {
		
		List<Node> childNodesArray = this.getChildNode(nodes);
		for(Node nodeArray : childNodesArray) {
			
			Node childNode = new Node(nodeArray.getName());
			if(previousNode == null) {
				previousNode = new Node(nodes.getName());
			}
			previousNode.setChildNode(childNode);
			
			this.calculateWeight(previousNode, childNode);
			this.addRoutes(childNode);
			this.FindAllPath(nodeArray, childNode);
		}
	}
	
	
	
	private Node getRoutePath(Node childNode) {
		Node childNodes = childNode.getParentNode() == null ? childNode : this.getRoutePath(childNode.getParentNode());
		return childNodes;}
	
	private void addRoutes(Node childNode) {
		Node root = getRoutePath(childNode);
		if(root.getName().equals(this.startNode.getName())){
			routes.add(childNode);}}
	
	
	
	
	private List<Node> getChildNode(Node nodes) {
		List<Node> childs = new ArrayList<Node>();
		for(Edge edge : edges){
			if(edge.getStartNode().equals(nodes)) {
				childs.add(edge.getEndNode());}}
		return childs;}
	
	
	
	public void calculateWeight(Node startNode, Node endNode) {
		double weight = 0;
		for(Edge edge: edges) {
			if(startNode.equals(edge.getStartNode()) && endNode.equals(edge.getEndNode())) {
				weight = edge.getWeight();
			}}
		double total = startNode.getDistance() + weight;
		endNode.setDistance(total);}
	
	
	
	private void display(Node path, String str) {
		if(path.getParentNode() != null) {
			str = str.equals("") ? path.getName()+"  (Weight : "+path.getDistance()+")" : path.getName() + "=>" + str;
			display(path.getParentNode(), str);
		}else {
			System.out.println(path.getName() + "=>" + str);
		}
	}

	public List<Node> getRoutes() {
		return routes;
	} 
	
	
	}
