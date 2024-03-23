package com.leetcode;

import javafx.util.Pair;

import java.util.*;

class Graph {
    int [][]adj;

    public Graph(int n, int[][] edges) {
        adj = new int[n][n];

        for(int i = 0; i < n; i++)
            Arrays.fill(adj[i], -1);

        for(int arr[] : edges) {
            adj[arr[0]][arr[1]] = arr[2];
            adj[arr[0]][arr[0]] = 0;
            adj[arr[1]][arr[1]] = 0;
        }
    }
    
    public void addEdge(int[] edge) {
        adj[edge[0]][edge[1]] = edge[2];
    }
    
    public int shortestPath(int node1, int node2) {
        Map<Integer, Integer> shortestPath = new HashMap<>();

        PriorityQueue<Pair<Integer, Integer>>  pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        pq.add(new Pair<>(0, node1));

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> currentVertexWeight = pq.poll();
            int currentVertex = currentVertexWeight.getValue();
            int currentWeight = currentVertexWeight.getKey();

            if(shortestPath.containsKey(currentVertex)) {
                continue;
            }
            shortestPath.put(currentVertex, currentWeight);

            int[] edges = adj[currentVertex];

            for(int i = 0; i < edges.length; i++) {
                if(edges[i] != -1 && edges[i] != 0) {
                    if(shortestPath.containsKey(i)) {
                        continue;
                    }

                    int tmpDistance = currentWeight + edges[i];
                    pq.add(new Pair<>(tmpDistance, i));
                }
            }

        }

        return shortestPath.getOrDefault(node2, -1);
    }

    public static void main(String[] args) {
//        Input ["Graph", "shortestPath", "shortestPath", "addEdge", "shortestPath"]
//                [[4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]], [3, 2], [0, 3], [[1, 3, 4]], [0, 3]]
//        Output [null, 6, -1, null, 6]
//
//        Explanation
        Graph g = new Graph(4, new int[][]{{0, 2, 5}, {0, 1, 2}, {1, 2, 1}, {3, 0, 3}});
        System.out.println(g.shortestPath(3, 2)); // return 6. The shortest path from 3 to 2 in the first diagram above is 3 -> 0 -> 1 -> 2 with a total cost of 3 + 2 + 1 = 6.
        System.out.println(g.shortestPath(0, 3)); // return -1. There is no path from 0 to 3.
        g.addEdge(new int[] {1, 3, 4}); // We add an edge from node 1 to node 3, and we get the second diagram above.
        System.out.println(g.shortestPath(0, 3)); // return 6. The shortest path from 0 to 3 now is 0 -> 1 -> 3 with a total cost of 2 + 4 = 6.
    }
}