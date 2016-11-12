import java.util.LinkedList;
import java.util.Queue;

public class BFS
{
    private static Queue<Integer> queue;

    public static void main(String... arg)
    {
        queue = new LinkedList<Integer>();

        int arr[][] = new int[][] {
                {0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0},
                {1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 1, 0}
        };

        dobfs(arr, 0);
    }

    public static void dobfs(int adjacency_matrix[][], int source)
    {
        int number_of_nodes = adjacency_matrix[source].length;

        int[] visited = new int[number_of_nodes];
        int element;

        visited[source] = 1;
        queue.add(source);

        while (!queue.isEmpty())
        {
            element = queue.remove();
            System.out.print(element + "\t");
            for(int i = 0;i<number_of_nodes;i++) {
                if (adjacency_matrix[element][i] == 1 && visited[i] == 0)
                {
                    queue.add(i);
                    visited[i] = 1;
                }
            }
        }
    }
}