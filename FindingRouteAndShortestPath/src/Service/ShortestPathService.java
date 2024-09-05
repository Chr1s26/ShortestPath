package Service;

import java.util.ArrayList;
import java.util.List;

import Model.Node;

public class ShortestPathService {
	
	private List<Node> shortestRoutes;
	private RouteService routeService;
	
	public ShortestPathService() {
		shortestRoutes = new ArrayList<Node>();
		routeService = new RouteService();
	}

	public void findShortestPath(Node startNode, Node endNode) {
	    findRoute(startNode, endNode);
	
	    System.out.print("Shortest path(s) from " + startNode.getName() + " to " + endNode.getName() + ": ");
	    double minWeight = this.FindMinWeight();
	    for (Node route : shortestRoutes) {
	        if (route.getDistance() == minWeight) {
	            display(route, "");
	        }
	    }
	}
	
	
	public void findRoute(Node startNode, Node endNode) {
		List<Node> routes = routeService.getRoutes();
		
	    for (Node route : routes) {
	        Node current = route;
	        while (current != null && !current.equals(startNode)) {
	            current = current.getParentNode();
	        }
	        if (current != null && current.equals(startNode)) {
	            if (route.getName().equals(endNode.getName())) {
	                shortestRoutes.add(route);
	            }
	        }
	    }
	}
	
	
	
	public double FindMinWeight() {
		  double minWeight = Double.MAX_VALUE;
		    for (Node route : shortestRoutes) {
		        if (route.getDistance() < minWeight) {
		            minWeight = route.getDistance();
		        }
		      }
		    return minWeight;
		    }
	
	
	
	private void display(Node path, String str) {
		if(path.getParentNode() != null) {
			str = str.equals("") ? path.getName()+"  (Weight : "+path.getDistance()+")" : path.getName() + "=>" + str;
			display(path.getParentNode(), str);
		}else {
			System.out.println(path.getName() + "=>" + str);
		}
	}

}
