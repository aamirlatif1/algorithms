package algo.leetcode.graph.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

enum Color {
    WHITE, GRAY, BLACK
}


class Vertex{
    Color color;
    int distance;
    Vertex parent;
    List<Vertex> adj;
}

class Graph {
    List<Vertex> vertices;
}

public class BFS {

    void bfs(Graph graph, Vertex s) {
        for (Vertex u: graph.vertices) {
            u.distance = Integer.MAX_VALUE;
            u.parent = null;
            u.color = Color.WHITE;
        }
        s.color = Color.GRAY;
        s.distance = 0;
        s.parent = null;
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()){
            Vertex u = queue.remove();
            for (Vertex v : u.adj){
                if (v.color == Color.WHITE){
                    v.color = Color.GRAY;
                    v.distance = u.distance +1;
                    v.parent = u;
                    queue.add(v);
                }
            }
            u.color = Color.BLACK;
        }
    }

    public static void main(String[] args) {

    }

}
