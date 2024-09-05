package MainTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Dao.EdgeDao;
import Dao.EdgeDaoImpl;
import Dao.NodeDao;
import Dao.NodeDaoImpl;
import Model.Edge;
import Model.Node;
import Service.EdgeService;
import Service.NodeService;
import Service.RouteService;
import Service.ShortestPathService;

public class Test {
	
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static ShortestPathService shortestPathService = new ShortestPathService();
    static NodeService nodeService = new NodeService();
    static EdgeService edgeService = new EdgeService();
    static RouteService routeService = new RouteService();
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		int num;
		do {
		System.out.println("Choose the option : ");
		System.out.println("1. Add Node ");
		System.out.println("2. Add Edge ");
		System.out.println("3. Display Node ");
		System.out.println("4. Display Edge ");
		System.out.println("5. Display All Routes ");
		System.out.println("6. Find Shortest Path ");
		System.out.println("7. Exit ");
	    num = Integer.parseInt(bufferedReader.readLine());
		switch (num) {
		
		case 1: nodeService.addNode(); break;
		case 2: edgeService.addEdge(); break;
		case 3: nodeService.displayNode(); break;
		case 4: edgeService.displayEdge(); break;
		case 5: routeService.getAllRoutes();break;
		case 6: findShortestPath();break;
		default: System.out.println("Invalid option. Please choose between 1 and 7."); break;
		}}while(num != 7);
		
		
		
//		NodeDao nodeDao = new NodeDaoImpl();
//		EdgeDao edgeDao = new EdgeDaoImpl(); 
//		
//		nodeDao.addNode(new Node("A"));
//		nodeDao.addNode(new Node("B"));
//		nodeDao.addNode(new Node("C"));
//		nodeDao.addNode(new Node("D"));
//		nodeDao.addNode(new Node("E"));
//		nodeDao.addNode(new Node("F"));
//		
//		edgeDao.addEdge(new Edge(new Node("A"),new Node("F"), 1));
//		edgeDao.addEdge(new Edge(new Node("A"),new Node("B"), 3));
//		edgeDao.addEdge(new Edge(new Node("F"),new Node("C"), 1));
//		edgeDao.addEdge(new Edge(new Node("B"),new Node("C"), 3));
//		edgeDao.addEdge(new Edge(new Node("B"),new Node("D"), 1));
//		edgeDao.addEdge(new Edge(new Node("D"),new Node("E"), 4));
//		edgeDao.addEdge(new Edge(new Node("C"),new Node("E"), 3));
//
//		routeService.getAllRoutes();
//		shortestPathService.findShortestPath(new Node("A"),new Node("E"));
	}
	
	public static void findShortestPath() throws IOException { 
		System.out.println("Enter the StartNode");
		String startNode = bufferedReader.readLine();
		Node sNode = nodeService.FindStartNode(new Node(startNode));
		System.out.println("Enter the EndNode");
		String endNode = bufferedReader.readLine();
		Node eNode = nodeService.FindEndNode(new Node(endNode));
		shortestPathService.findShortestPath(sNode,eNode);
	}


}
