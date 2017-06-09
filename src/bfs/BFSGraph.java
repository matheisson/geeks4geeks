package bfs;

import java.util.*;

/**
    So, if we want to visit the elements level-by-level (and left-to-right, as usual),
 we would start at level 0 with j, then go to level 1 for f and k, then go to level 2 for a, h and z,
 and finally go to level 3 for d.
    This level-by-level traversal is called a breadth-first traversal because we explore the breadth,
 i.e., full width of the tree at a given level, before going deeper.
**/
public class BFSGraph {

    private int NoOfVertices;
    private LinkedList<Integer> adjacencies[];

    public BFSGraph(int v){
        this.NoOfVertices = v;
        this.adjacencies = new LinkedList[NoOfVertices];
        for (int i = 0; i < v; i++){
            adjacencies[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w){
        adjacencies[v].add(w);
    }

    public void BFS(int root){

        boolean visited[] = new boolean[NoOfVertices];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[root] = true;
        queue.add(root);

        while (queue.size() != 0){

            root = queue.poll();
            System.out.print(root+" ");
            Iterator<Integer> it = adjacencies[root].listIterator();

            while (it.hasNext()){
                int n = it.next();
                if (!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[])
    {
        BFSGraph g = new BFSGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);
    }
}
