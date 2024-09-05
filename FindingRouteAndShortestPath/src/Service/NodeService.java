package Service;

import java.io.IOException;

import Dao.NodeDao;
import Dao.NodeDaoImpl;
import Model.Node;

public class NodeService extends BaseService {

	public NodeDao nodeDao;
	
	
	public NodeService() {
		nodeDao = new NodeDaoImpl();
	
	} 
	
	public void addNode() throws NumberFormatException, IOException {
		
		System.out.print("How many nodes do you want to add?");
		int flag = Integer.parseInt(bufferedReader.readLine());		
		int i = 0;
		do {
			System.out.print("Enter Node : ");
			String node = bufferedReader.readLine();
			nodeDao.addNode(new Node(node));
			i++;
		}while(i < flag);
	}
	
	
	
	public void displayNode() {
		for(Node nodes: nodeDao.getNode()) {
			System.out.println(nodes.getName());
		}
	}
	
	
	public Node FindStartNode(Node startNode) {
		Node sNode = startNode; 
		for(Node node : nodeDao.getNode()) {
			if(node.getName().equals(startNode)) {
				sNode = node;
			}
		}
		return sNode;
	}
	
	public Node FindEndNode(Node EndNode) {
		Node eNode = EndNode; 
		for(Node node : nodeDao.getNode()) {
			if(node.getName().equals(EndNode)) {
				eNode = node;
			}
		}
		return eNode;
	}

}
