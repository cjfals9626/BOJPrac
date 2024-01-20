import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static boolean[] nums;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        nums = new boolean[20*100000 + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        dfs(0, 0);

        for (int i = 0; i < nums.length; i++){
            if (!nums[i]){
                System.out.println(i);
                break;
            }
        }
    }
    static void dfs(int idx, int sum){

        nums[sum] = true;

        for (int i = idx; i < n; i++){
            if (!visited[i]){
                visited[i] = true;
                dfs(i, sum + arr[i]);
                visited[i] = false;
            }
        }
    }
}


