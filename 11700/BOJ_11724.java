import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static boolean[] visited;
    static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        arr = new boolean[n + 1][n + 1];
        visited[0] = true;

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());

            arr[firstNode][secondNode] = arr[secondNode][firstNode] = true;
        }

        int count = 0;
        for (int i = 1; i <= n; i++){
            if (!visited[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    static void dfs(int node){
        for (int i = 1; i <= n; i++){
            if (!visited[i] && arr[node][i]){
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
