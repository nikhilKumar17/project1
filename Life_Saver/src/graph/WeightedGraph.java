package graph;
import java.util.* ;

public class WeightedGraph {
 

  private class Node {
		String label ;
		
		public Node(String label) {
			this.label = label ;
		}
		
		private List <Edge> edges = new ArrayList<>() ;
		
		@Override
		public String toString() {
			return label;
		}
		
		public void addEdge(Node to , int weight) {
			edges.add(new Edge(this , to , weight));
		}
		
		public List<Edge> getEdges() {
			return edges ;
		}
	}
	
	private class Edge {
		private Node from ;
		private Node to ;
		private int weight ;
		
		public Edge(Node from , Node to , int weight) {
			this.from = from ;
			this.to = to ;
			this.weight = weight ;
		}

		@Override
		public String toString() {
			return from + " --> " + to;
		} 
	}
	
	Map <String, Node> nodes  = new HashMap<>();
	
	public void addNode (String label) {
		nodes.putIfAbsent(label, new Node(label));
	}
	
	public void addEdge(String from , String to , int weight) {
		Node fromNode = nodes.get(from);
		if(from == null)
			throw new IllegalArgumentException();
		
		Node toNode = nodes.get(to);
		if(to == null)
			{throw new IllegalArgumentException();}
		else
		fromNode.addEdge(toNode, weight);
		toNode.addEdge(fromNode, weight);
		
	}
	
	public void print() {
		for(var node : nodes.values() ) {
			var edges = node.getEdges();
			if(!edges.isEmpty())
				System.out.println(node + " is connected to " + edges);
		}
	}
	
	public class NodeEntry {
		private Node node ;
		private int priority ;
		
		public NodeEntry(Node node, int priority) {
			this.node = node;
			this.priority = priority;
		}
	}
	
	
	
	
/*	public Path getShortestPath(String from , String to ) {
		Node fromNode = nodes.get(from);
		if(fromNode == null)
			throw new IllegalArgumentException();
		
		Node toNode = nodes.get(to);
		if(toNode == null)
			throw new IllegalArgumentException();
		
		Map <Node , Integer> distances = new HashMap<>();
		for(Node node : nodes.values())
			distances.put(node , Integer.MAX_VALUE);
		
		distances.replace(fromNode, 0);
		
		Map<Node , Node> previousNodes = new HashMap<>() ;
		
		Set<Node> visited = new HashSet<>();
		
		PriorityQueue <NodeEntry> queue = new PriorityQueue<>(
				Comparator.comparingInt(ne -> ne.priority));
		
		queue.add(new NodeEntry(fromNode , 0));
		
		while(!queue.isEmpty()) {
			Node current = queue.remove().node ;
			visited.add(current);
			
			for(Edge edge : current.getEdges()) {
				if(visited.contains(edge.to))
					continue ;
				
				var newDistance = distances.get(current) + edge.weight ;
				if(newDistance < distances.get(edge.to)) {
					distances.replace(current, newDistance);
					previousNodes.put(edge.to , current);
					queue.add(new NodeEntry(edge.to , newDistance));
				}
			}
		}
		
		
		return buildPath(previousNodes , toNode);	
	
	
	}*/
	
	 
	
	
	
	
	private Path buildPath(Map<Node , Node> previousNodes , Node toNode) {
		Stack<Node>  stack = new Stack<>();
		stack.push(toNode);
		Node previous = previousNodes.get(toNode);
		while(previous != null) {
			stack.push(previous);
			previous = previousNodes.get(previous);
		}
		
		Path path = new Path();
		
		while(!stack.isEmpty()) 
			path.add(stack.pop().label);
		
		return path ;
	}
	
	class PathEntry {
		List<String> path ;
		int priority ;
		
		public PathEntry(List<String> path, int priority) {
			this.path = path;
			this.priority = priority;
		}

		@Override
		public String toString() {
			return path + "  " + " Distance = " + priority + " km";
		}
	}
	
	private int getDistance( Map<Node , Integer> distances , Node to) {
		return distances.get(to);
	}
	
 public PathEntry getShortestPath(String from , String to ) {
		Node fromNode = nodes.get(from);
		if(fromNode == null)
			throw new IllegalArgumentException();
		
		Node toNode = nodes.get(to);
		if(toNode == null)
			throw new IllegalArgumentException();
		
		Map <Node , Integer> distances = new HashMap<>();
		for(Node node : nodes.values())
			distances.put(node , Integer.MAX_VALUE);
		
		distances.replace(fromNode, 0);
		
		Map<Node , Node> previousNodes = new HashMap<>() ;
		
		Set<Node> visited = new HashSet<>();
		
		PriorityQueue <NodeEntry> queue = new PriorityQueue<>(
				Comparator.comparingInt(ne -> ne.priority));
		
		queue.add(new NodeEntry(fromNode , 0));
		
		while(!queue.isEmpty()) {
			Node current = queue.remove().node ;
			visited.add(current);
			
			for(Edge edge : current.getEdges()) {
				if(visited.contains(edge.to))
					continue ;
				
				var newDistance = distances.get(current) + edge.weight ;
				
				if(newDistance < distances.get(edge.to)) {
					distances.replace(edge.to, newDistance);
					previousNodes.put(edge.to , current);
					queue.add(new NodeEntry(edge.to , newDistance));
				}
			}
		}
		
	    var stack = buildPath(previousNodes , distances ,toNode);
	    List<String> list = new ArrayList<>();
	    while(!stack.isEmpty()) {
	    	list.add(stack.pop().label);
	    }
	    int distance = getDistance(distances , toNode);
		return new PathEntry(list , distance) ;
	}
 
           private Stack<Node> buildPath(Map<Node , Node> previousNodes ,  Map<Node , Integer> distances ,Node toNode) {
		
//		int totalDistance = 0 ;
		Stack<Node>  stack = new Stack<>();
		stack.push(toNode);
		
//		ArrayDeque <Node> queue = new ArrayDeque<>();
		Node previous = previousNodes.get(toNode);
//		totalDistance += distances.get(toNode);
		
		while(previous != null) {
			stack.push(previous);
//			totalDistance += distances.get(previous);
			previous = previousNodes.get(previous);
		}
		return stack; }
	
}
 

	





