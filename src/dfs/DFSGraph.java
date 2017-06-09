package dfs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by levente on 2017.06.07..
 */
public class DFSGraph {

    private int numOfVertices;
    private LinkedList<Integer> connections[];

    public DFSGraph(int size) {
        this.numOfVertices = size;
        this.connections = new LinkedList[numOfVertices];
        for (int i = 0; i < numOfVertices; i++){
            connections[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int con) {
        connections[v].add(con);
    }

    public void DFS(int v){

        boolean[] visited = new boolean[numOfVertices];
        DFSUtil(v, visited);
    }

    public void DFSUtil(int v, boolean[] visitArray){
        visitArray[v] = true;

        System.out.print(v+" ");

        Iterator<Integer> it = connections[v].listIterator();
        while (it.hasNext()){
            int n = it.next();
            if (!visitArray[n]){
                visitArray[n] = true;
                DFSUtil(n,visitArray);
            }
        }
    }

    public static void main(String[] args) {
        DFSGraph g = new DFSGraph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(4, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(2);
    }
}
