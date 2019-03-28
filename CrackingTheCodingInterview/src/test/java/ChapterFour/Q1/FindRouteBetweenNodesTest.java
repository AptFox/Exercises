package test.java.ChapterFour.Q1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.ChapterFour.Graph;
import main.java.ChapterFour.Node;
import main.java.ChapterFour.Q1.FindRouteBetweenNodes;

class FindRouteBetweenNodesTest {

	@Test
	void test() {
		Graph g = new Graph();
		Node A = new Node();
		Node B = new Node();
		Node C = new Node();
		Node D = new Node();
		Node E = new Node();
		Node F = new Node();
		A.name = "A";
		B.name = "B";
		A.children = new Node [] {C,D};
		C.children = new Node [] {E,F};
		F.children = new Node [] {B,D};
		boolean expected = true;
		boolean actual = FindRouteBetweenNodes.checkForPath(g, A, B);
		assertTrue(actual);
	}

}
