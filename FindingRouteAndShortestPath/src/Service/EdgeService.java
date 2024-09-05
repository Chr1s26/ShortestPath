package Service;

import java.io.IOException;

import Dao.EdgeDao;
import Dao.EdgeDaoImpl;
import Model.Edge;
import Model.Node;

public class EdgeService extends BaseService{
	
	public EdgeDao edgeDao;
	
	public EdgeService() {
		edgeDao = new EdgeDaoImpl();
	}

	public void addEdge() throws NumberFormatException, IOException {
		
		System.out.print("How many Edges do you want to add?");
		int flag = Integer.parseInt(bufferedReader.readLine());
		int i = 0;
		do {
			System.out.print("Enter Start Node : ");
			String snode = bufferedReader.readLine();
			System.out.print("Enter End Node : ");
			String enode = bufferedReader.readLine();
			System.out.print("Enter Weight : ");
			double weight = Double.parseDouble(bufferedReader.readLine());
			
			Edge edge = new Edge(new Node(snode),new Node(enode),weight);
			edgeDao.addEdge(edge);
			i++;
		}while(i < flag);
	}
	
	public void displayEdge() {
		for(Edge edges : edgeDao.getEdge()) {
			System.out.println(edges);
		}
	}

}
