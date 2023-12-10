import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static int[] tmpArr;
    static int[] numArr;
    static boolean[] visited;
    static int n;
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tmpArr = new int[n];
        numArr = new int[n];
        visited = new boolean[n];
        sum = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(sum);
    }
    static void dfs(int depth){
        if (depth == n){
            int tmp = 0;
            for (int i = 0; i < n-1; i++){
                tmp += Math.abs(tmpArr[i] - tmpArr[i+1]);
            }
            sum = Math.max(tmp,sum);
            return;
        }

        for (int i = 0; i < n; i++){
            if (!visited[i]){
                visited[i] = true;
                tmpArr[depth] = numArr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}