import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<Node>[] list;
    static boolean[] visited;

    static int result = 0;
    static int max_idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++){
            list[i] = new ArrayList<Node>();
        }

        for (int i = 1; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int firstVal = Integer.parseInt(st.nextToken());
            int secondVal = Integer.parseInt(st.nextToken());
            int edgeVal = Integer.parseInt(st.nextToken());

            list[firstVal].add(new Node(secondVal, edgeVal));
            list[secondVal].add(new Node(firstVal, edgeVal));
        }

        visited[1] = true;
        //result = Math.max(dfs(1), result);
        dfs(1,0);

        Arrays.fill(visited, false);
        visited[max_idx] = true;
        dfs(max_idx, 0);

        System.out.println(result);
    }

    public static void dfs(int idx, int cnt) {

        if(result < cnt) {
            result = cnt;
            max_idx = idx;
        }

        for(Node a : list[idx]) {
            if(!visited[a.num]) {
                visited[a.num] = true;
                dfs(a.num, cnt+a.edge);
            }
        }
    }
/*    static int dfs(int cur){

        int sum = 0;
        int max = 0;

        for (Node i : list[cur]){
            if (!visited[i.num]){
                visited[i.num] = true;

                int curVal = dfs(i.num) + i.edge;
                max = Math.max(max, curVal);

                sum += curVal;
            }
        }


        if (list[cur].size() == 3){
            result = Math.max(result, sum);
        }

        return max;
    }*/

    static class Node{
        int num;
        int edge;

        public Node(int num, int edge) {
            this.num = num;
            this.edge = edge;
        }
    }
}
