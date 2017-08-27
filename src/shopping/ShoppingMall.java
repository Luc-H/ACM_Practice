package shopping;

import java.util.Scanner;

public class ShoppingMall
{
	public static void main(String[] args) {
		Node[] nodes;
		Edge[] edges;

		//get input
		Scanner input = new Scanner(System.in);

		// n= num nodes		m = num edges
		int n = input.nextInt(), m = input.nextInt();
		nodes = new Node[n];
		edges = new Edge[m];

		//get input for nodes
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node(input.nextInt(), input.nextInt(), input.nextInt());
		}
		//get input for edges
		for (int i = 0; i < m; i++) {
			int s = input.nextInt(), e = input.nextInt();
			String t = input.next();
			// define two edges each for bi-directionality
			edges[i] = new Edge(nodes[s], nodes[e], t, false);
			edges[i] = new Edge(nodes[e], nodes[s], t, true);
		}

		input.nextLine();
		// q = numQueries
		int q = Integer.parseInt(input.nextLine());
		int[][] queries = new int[q][2];
		//get the queries
		for (int i = 0; i < q; i++) {
			queries[i][0] = input.nextInt();
			queries[i][1] = input.nextInt();
		}

		//***************
		System.out.println("Input complete");

		//Dijkstra
	}

	/**
	 * Holds the information for a node
	 */
	static class Node {
		int floor;
		int x;
		int y;

		/**
		 * Nodes Constructor
		 *
		 * @param floor the floor
		 * @param x     the x-pos
		 * @param y     the y-pos
		 */
		Node(int floor, int x, int y) {
			this.x = x;
			this.y = y;
			this.floor = floor;
		}
	}

	/**
	 * Holds the information for an edge
	 */
	static class Edge {
		Node start;
		Node end;
		double weight;

		/**
		 * Edge Constructor
		 *
		 * @param start      The starting node
		 * @param end        The ending node
		 * @param weightType The type of edge weighting (ie: stairs/walking/lift/escalator)
		 * @param reverse    Escalators have alternate reverse weights, used to determine which type.
		 */
		Edge(Node start, Node end, String weightType, Boolean reverse) {
			this.start = start;
			this.end = end;
			this.weight = calculateWeight(weightType, start, end, reverse);
		}

		/**
		 * Calculates the distance/weight of the edge
		 *
		 * @param weightType The type of edge weighting (ie: stairs/walking/lift/escalator)
		 * @param start      The starting node
		 * @param end        The ending node
		 * @param reverse    Escalators have alternate reverse weights, used to determine which type.
		 * @return The final weighting after calculations
		 */
		private static double calculateWeight(String weightType, Node start, Node end, Boolean reverse) {
			if (weightType.equals("walking")) {
				return Math.sqrt(Math.pow(start.x - end.x, 2) + Math.pow(start.y - end.y, 2));
			} else if (weightType.equals("stairs")) {
				return Math.sqrt(Math.pow(Math.sqrt(Math.pow(start.x - end.x, 2) + Math.pow(start.y - end.y, 2)), 2) + 25);
			} else if (weightType.equals("lift")) {
				return 1;
			} else {
				if (reverse) {
					return 3 * Math.sqrt(Math.pow(Math.sqrt(Math.pow(start.x - end.x, 2) + Math.pow(start.y - end.y, 2)), 2) + 25);

				} else {
					return 1;
				}

			}
		}
	}
}


