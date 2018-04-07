package com.company;

import java.util.*;
import java.util.stream.Collectors;

class Vertex<T> {
    T value;
    int weight;

    public Vertex(T value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public Vertex(T value) {
        this.value = value;
        this.weight = 0;
    }
}

public class Graph<T> {
    private Map<T, LinkedList<Vertex<T>>> adjList;

    Graph() { adjList = new HashMap<>(); }

    Set<Vertex<T>> getAllVertexes() {
        Set<Vertex<T>> allVertexes = new HashSet<>();
        adjList.keySet().stream().forEach(x -> allVertexes.addAll(adjList.get(x)));
        return allVertexes;
    }

    int getGraphSize() { return getAllVertexes().size(); }

    void printBFS(T start) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        LinkedList<Vertex<T>> visited = new LinkedList<>();

        queue.add(new Vertex(start));
        visited.add(new Vertex(start));

        while(!queue.isEmpty()) {
            Vertex<T> temp = queue.poll();
            System.out.print(temp.value + " ");

            if(adjList.containsKey(temp)) {
                adjList.get(temp).forEach(current -> {
                    if(!visited.contains(current)) {
                        queue.add(new Vertex(current));
                        visited.addLast(current);
                    }
                });
            }
        }
    }

    void printDFS(T start) {
        Stack<Vertex<T>> stack = new Stack<>();
        LinkedList<Vertex<T>> visited = new LinkedList<>();

        stack.push(new Vertex(start));
        visited.add(new Vertex(start));

        while(!stack.isEmpty()) {
            Vertex<T> temp = stack.pop();
            System.out.print(temp.value + " ");

            if(adjList.containsKey(temp)) {
                adjList.get(temp).forEach(current -> {
                    if(!visited.contains(current)) {
                        stack.push(new Vertex(current));
                        visited.add(new Vertex(current));
                    }
                });
            }
        }
    }

    boolean isPathExists(T start, T end) {
        if(start == end) return true;

        Queue<Vertex<T>> queue = new LinkedList<>();
        LinkedList<T> visited = new LinkedList<>();
        queue.add(new Vertex(start));
        visited.addFirst(start);

        while(!queue.isEmpty()) {
            Vertex<T> temp = queue.poll();

            if(adjList.containsKey(temp.value)) {
                for(Vertex current : adjList.get(temp.value)) {
                    if(end == current.value) return true;
                    if(!visited.contains(current.value)) {
                        queue.add(current);
                        visited.add((T)current.value);
                    }
                }
            }
        }

        return false;
    }

    void addEdge(T start, T end) {
        LinkedList<Vertex<T>> temp = (adjList.containsKey(start))
                ? adjList.get(start) : new LinkedList<>(Arrays.asList(new Vertex<T>(start)));
        temp.addLast(new Vertex(end));
        adjList.put(start, temp);


    }

    void print() {
        adjList.keySet().forEach(vertex -> {
            adjList.get(vertex).stream().forEach(x -> System.out.print(x.value + " "));
            System.out.println();
        });
    }

    public static void main(String args[]) {
        Graph<Integer> graph = new Graph<>();
        graph.addEdge(0,2);
        graph.addEdge(2,4);
        graph.addEdge(0,3);
        graph.addEdge(3,5);
        graph.addEdge(5,6);
        graph.addEdge(1,7);
        graph.addEdge(7,5);
       // graph.addEdge(6,1);
        graph.addEdge(0,100);
        graph.addEdge(100,120);

        int d = 6;
        d = -d;
        System.out.println(d);
        //System.out.println(graph.isPathExists(0,7));

    }


}