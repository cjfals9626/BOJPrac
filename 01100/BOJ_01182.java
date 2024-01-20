import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static int n;
    static int s;
    static int totalCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        totalCount = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        dfs(0, 0);

        if (s == 0){
            totalCount--;
        }

        System.out.println(totalCount);
    }
    static void dfs(int idx, int sum){
        if (sum == s){
            totalCount++;
        }

        for (int i = idx; i < n; i++){
            if (!visited[i]){
                visited[i] = true;
                dfs(i, sum + arr[i]);
                visited[i] = false;
            }
        }
    }
}


