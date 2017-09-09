package shopping;

import java.util.Scanner;

public class ShoppingMall
{
	public static void main(String[] args)
	{
		Node[] nodes;
		Edge[] edges;

		//get input
		Scanner input = new Scanner(System.in);

		// n= num nodes		m = num edges
		int n = input.nextInt(), m = input.nextInt();
		nodes = new Node[n];
		edges = new Edge[m * 2];

		//get input for nodes
		for (int i = 0; i < n; i++)
		{
			nodes[i] = new Node(input.nextInt(), input.nextInt(), input.nextInt(), i);
		}
		//get input for edges
		for (int i = 0; i < m * 2; i += 2)
		{
			int s = input.nextInt(), e = input.nextInt();
			String t = input.next();
			// define two edges each for bi-directionality
			edges[i] = new Edge(nodes[s], nodes[e], t, false);
			edges[i + 1] = new Edge(nodes[e], nodes[s], t, true);
		}

		input.nextLine();
		// q = numQueries
		int q = Integer.parseInt(input.nextLine());
		int[][] queries = new int[q][2];
		//get the queries
		for (int i = 0; i < q; i++)
		{
			queries[i][0] = input.nextInt();
			queries[i][1] = input.nextInt();
		}

		//***************
		System.out.println("Input complete");

		for (int i = 0; i < queries.length; i++)
		{
			dijkstraS(nodes, edges, nodes[queries[i][0]], nodes[queries[i][1]]);
		}

	}


	private static void dijkstraL(Node[] nodes, Edge[] edges, Node origin, Node destination)
	{
		//Reset all nodes
		for (Node node : nodes)
		{
			node.distanceFromSource = Double.MAX_VALUE;
			node.checked = false;
		}

		//Set origin to our initial node.
		origin.distanceFromSource = 0;
		origin.checked = true;

		//create and empty array of nodes visited
		Node[] visitedNodes = new Node[nodes.length];
		boolean uncheckedNodes = true;
		Node currentNode = origin;



	}


	private static void dijkstraS(Node[] nodes, Edge[] edges, Node origin, Node destination)
	{
		double[] distances = new double[edges.length];
		for (int i = 0; i < nodes.length; i++)
		{
			nodes[i].checked = false;
			nodes[i].distanceFromSource = 1000000;
		}
		origin.distanceFromSource = 0;
		origin.checked = true;

		Node currentNode = origin;

		currentNode.distanceFromSource = 0;

		boolean uncheckedNodes = true;
		for (int i = 0; i < 100; i++)
		{
			for (Edge edge : edges)
			{
				if (edge.from != currentNode || edge.to.checked) continue;

				if (currentNode.distanceFromSource + edge.weight < edge.to.distanceFromSource)
				{
					edge.to.distanceFromSource = currentNode.distanceFromSource + edge.weight;
					edge.to.from = currentNode;
				}
				currentNode.checked = true;

				uncheckedNodes = false;
				for (Node node : nodes)
				{
					if (!node.checked)
					{
						if (!uncheckedNodes)
						{
							currentNode = node;
							uncheckedNodes = true;
						}

						if (node.distanceFromSource < currentNode.distanceFromSource)
						{
							currentNode = node;
						}
					}
				}
			}


		}

		currentNode = destination;
		String path = currentNode.number + "";

		while (currentNode != origin)
		{
			currentNode = currentNode.from;
			path = currentNode.number + " " + path;
		}

		System.out.println(path);

	}

	/**
	 * Holds the information for a node
	 */
	private static class Node
	{
		int floor;
		int x;
		int y;

		double distanceFromSource;
		boolean checked;
		Node from;
		int number;

		/**
		 * Nodes Constructor
		 *
		 * @param floor the floor
		 * @param x     the x-pos
		 * @param y     the y-pos
		 */
		Node(int floor, int x, int y, int number)
		{
			this.x = x;
			this.y = y;
			this.floor = floor;
			this.number = number;
		}
	}

	/**
	 * Holds the information for an edge
	 */
	private static class Edge
	{
		Node from;
		Node to;
		double weight;

		/**
		 * Edge Constructor
		 *
		 * @param start      The starting node
		 * @param end        The ending node
		 * @param weightType The type of edge weighting (ie: stairs/walking/lift/escalator)
		 * @param reverse    Escalators have alternate reverse weights, used to determine which type.
		 */
		Edge(Node start, Node end, String weightType, Boolean reverse)
		{
			this.from = start;
			this.to = end;
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
		private static double calculateWeight(String weightType, Node start, Node end, Boolean reverse)
		{
			if (weightType.equals("walking"))
			{
				return Math.sqrt(Math.pow(start.x - end.x, 2) + Math.pow(start.y - end.y, 2));
			} else if (weightType.equals("stairs"))
			{
				return Math.sqrt(Math.pow(Math.sqrt(Math.pow(start.x - end.x, 2) + Math.pow(start.y - end.y, 2)), 2) + 25);
			} else if (weightType.equals("lift"))
			{
				return 1;
			} else
			{
				if (reverse)
				{
					return 3 * Math.sqrt(Math.pow(Math.sqrt(Math.pow(start.x - end.x, 2) + Math.pow(start.y - end.y, 2)), 2) + 25);

				} else
				{
					return 1;
				}

			}
		}
	}
}


