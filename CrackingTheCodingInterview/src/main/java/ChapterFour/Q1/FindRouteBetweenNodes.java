/*
 * Given a directed graph, design an algorithm to find out if there is a route between two nodes
 */

package main.java.ChapterFour.Q1;

import java.util.LinkedList;
import java.util.Queue;

import main.java.ChapterFour.Graph;
import main.java.ChapterFour.Node;

public class FindRouteBetweenNodes {
	public static boolean checkForPath(Graph g, Node A, Node B) {
		Queue<Node> q = new LinkedList<Node>();
		A.visited = true;
		q.add(A);
		while(!q.isEmpty()) {
			Node n = q.remove();
			if(n.name == B.name) {
				return true;
			}else if (n.children != null) {
				for(Node k : n.children) {
					if(k.visited == false) {
						q.add(k);
						k.visited = true;
					}
				}
			}
		}
		return true;
	}
}
