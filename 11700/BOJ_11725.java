import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        result = new int[n + 1];

        for (int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int firstVal = Integer.parseInt(st.nextToken());
            int secondVal = Integer.parseInt(st.nextToken());

            list[firstVal].add(secondVal);
            list[secondVal].add(firstVal);
        }

        visited[1] = true;
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++){
            sb.append(result[i]).append('\n');
        }
        System.out.println(sb);
    }
    static void dfs(int val){

        for (int i : list[val]){
            if (!visited[i]){
                result[i] = val;
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
