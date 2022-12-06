package Graphs;

public class LabGraph<T> extends AbstractGraph<T> {

    @Override
    public int outDegree(T deger) {
        Vertex<T> resultVertex;
        int sum = 0;
        for (Vertex<T> vertex:vertices) {
            if(vertex.value == deger){
                for (Edge<T> edge:vertex.edges) {
                    if(edge.from == vertex){
                        sum++;
                    }
                }
                return sum;
            }
        }
        return -1;
    }

    @Override
    public int inDegree(T deger) {
        Vertex<T> resultVertex;
        int sum = 0;
        for (Vertex<T> vertex:vertices) {
            for (Edge<T> edge:vertex.edges) {
                if(edge.to.value == vertex.value){
                    sum++;
                }
            }
        }
        if(sum == 0) return -1;
        return sum;
    }
}
