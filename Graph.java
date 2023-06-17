package com.leetcode;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {
//        n = 3, edges = {{0,1},{1,2},{2,0}}, source = 0, destination = 2
//        System.out.println(new Graph().validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));
//        {{0,1},{0,2},{3,5},{5,4},{4,3}}
//        System.out.println(new Graph().validPath(6, new int[][] {{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));

//        System.out.println(new Graph().validPath(10, new int[][]{{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}}, 5, 9));
        List<List<Integer>> list = new ArrayList<>();//[[1,3],[3,0,1],[2],[0]]
        list.add(Arrays.asList(1, 3));
        list.add(Arrays.asList(3, 0, 1));
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(0));
//        System.out.println(new Graph().canVisitAllRooms(list));
        List<List<Integer>> list2 = new ArrayList<>();//[[1],[2],[3],[]]
        list2.add(Arrays.asList(1));
        list2.add(Arrays.asList(2));
        list2.add(Arrays.asList(3));
        list2.add(new ArrayList<>());
//        System.out.println(new Graph().canVisitAllRooms(list2));

//        adjList = [[2,4],[1,3],[2,4],[1,3]]
        Node _1 = new Node(1);
        Node _2 = new Node(2);
        Node _3 = new Node(3);
        Node _4 = new Node(4);
        _1.neighbors = (Arrays.asList(_2, _4));
        _2.neighbors = (Arrays.asList(_1, _3));
        _3.neighbors = (Arrays.asList(_2, _4));
        _4.neighbors = (Arrays.asList(_1, _3));
//        System.out.println(new Graph().cloneGraph(_1));

        // n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
        System.out.println(new Graph().findCheapestPrice(4, new int[][]{
                {0,1,100},
                {1,2,100},
                {2,0,100},
                {1,3,600},
                {2,3,200}} ,0, 3, 1));
    }
    

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int cheapestPrice = -1;
        int prices[] = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for(int j = 0; j <= k; j++) {
            int tmpPrices[] = prices.clone();
            for (int i = 0; i < flights.length; i++) {
                if(prices[flights[i][0]] == Integer.MAX_VALUE) {
                    continue;
                }
                if(prices[flights[i][0]] + flights[i][2] < tmpPrices[flights[i][1]]) {
                    tmpPrices[flights[i][1]] = prices[flights[i][0]] + flights[i][2];
                }
            }
            prices = tmpPrices;
            System.out.println(Arrays.toString(tmpPrices));
            System.out.println(Arrays.toString(prices));
        }

        return prices[dst] == Integer.MAX_VALUE ? cheapestPrice : prices[dst];
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> cloneNodes = new HashMap<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(node);

        while (!nodeQueue.isEmpty()) {
            Node original = nodeQueue.poll();
            Node clone = new Node(original.val);
            cloneNodes.put(original, clone);

            for(Node current : original.neighbors) {
                if(!cloneNodes.containsKey(current)) {
                    nodeQueue.add(current);
                }
            }
        }

        for(Node originalCurrent : cloneNodes.keySet()) {
            for(Node originalCurrentNeighbor : originalCurrent.neighbors) {
                cloneNodes.get(originalCurrent).neighbors.add(cloneNodes.get(originalCurrentNeighbor));
            }
        }

        return cloneNodes.get(node);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //List<Boolean> roomList = new ArrayList<>();
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        //roomList.add(true);

        for(int i = 1; i < rooms.size(); i++) {
            //roomList.add(i, false);
            visited[i] = false;
        }

        Stack<Integer> keys = new Stack<>();
        keys.addAll(rooms.get(0));

        while (!keys.isEmpty()){
            Integer unlock = keys.pop();
            //roomList.set(unlock, true);
            visited[unlock] = true;

            List<Integer> newKeys = rooms.get(unlock);
            for(int i = 0; i < newKeys.size(); i++) {
                //if(!roomList.get(newKeys.get(i)))
                //    keys.add(newKeys.get(i));
                if(!visited[newKeys.get(i)])
                    keys.add(newKeys.get(i));
            }
        }

        for(int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
//        return !roomList.contains(Boolean.FALSE);
        return true;
    }

    public boolean validPath1(int n, int[][] edges, int source, int destination) {

        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> vertexs = new HashMap<>();

        for(int i = 0; i < edges.length; i++) {
            if(vertexs.containsKey(edges[i][0])) {
                vertexs.get(edges[i][0]).add(edges[i][1]);
            } else {
                vertexs.put(edges[i][0], new HashSet<>());
                vertexs.get(edges[i][0]).add(edges[i][1]);
            }

            if(vertexs.containsKey(edges[i][1])) {
                vertexs.get(edges[i][1]).add(edges[i][0]);
            } else {
                vertexs.put(edges[i][1], new HashSet<>());
                vertexs.get(edges[i][1]).add(edges[i][0]);
            }
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> integerList = new LinkedList<>();
        integerList.add(source);

        while (!integerList.isEmpty()) {
            Integer current = integerList.poll();
            visited.add(current);
            if(vertexs.get(current).contains(destination)) {
                return true;
            } else {
                for(Integer ne : vertexs.get(current)) {
                    if(!visited.contains(ne)) {
                        integerList.add(ne);
                    }
                }
            }
        }

        return false;
    }
}
