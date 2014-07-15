package com.mengangx.test.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class DeepCopyAGraph {
	public static class Node<T extends Comparable<T>> {
		T nodeName;
		List<Node<T>> neighbors;
		
		public Node(T t) {
			nodeName = t;
		}
		
		public T getName() {
			return nodeName;
		}
		
		public void setNeighbors(List<Node<T>> list) {
			neighbors = list;
		}
		
		public List<Node<T>> getNeighbors(){
			return neighbors;
		}
		
		public Node<T> deepCopy( Map<Node<T>, Node<T>> map) {
			Node<T> copy = map.get(this);
			if (copy == null) {
			    copy = new Node<T>(nodeName);
			    copy.setNeighbors(new ArrayList<Node<T>>());
			    map.put(this, copy);
			    for (Node<T> neighbor : neighbors) {
			    	copy.neighbors.add(neighbor.deepCopy(map));
			    }
			}
			return copy;			
		}
		
	}
	
	public static class Graph<T extends Comparable<T>> {
		List<Node<T>> nodes;
		
		public Graph(List<Node<T>> list) {
			nodes = list;
		}
		
		public List<Node<T>> getNodes() {
			return nodes;
		}
		
		public void print() {
			for (Node<T> node : nodes) {
				System.out.println(node.getName());
				System.out.println(node);
				System.out.println("neighbors: ");
				System.out.println(node.getNeighbors());
			}
		}
		
		public Graph<T> deepCopy() {
			Graph<T> g = new Graph<T>(new ArrayList<Node<T>>());
			Map<Node<T>, Node<T>> map = new IdentityHashMap<Node<T>, Node<T>>();
			for (Node<T> n : nodes) {
				g.nodes.add(n.deepCopy(map));
			}
			return g;
		}
	}
	
	
	public static void main (String [] args) {
		Node<String> nodeA = new Node<String>("a");
		Node<String> nodeB = new Node<String>("b");
		
		nodeA.setNeighbors(Arrays.asList(nodeB));
		nodeB.setNeighbors(Arrays.asList(nodeA));
		
		Graph<String> g = new Graph<String>(Arrays.asList(nodeA, nodeB));
		g.print();
		
		Graph<String> copy = g.deepCopy();
		copy.print();
		
		
		
	}
}