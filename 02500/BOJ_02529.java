import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static boolean[] visited;
    static int n;
    static long[] tmpArr;
    static char[] inequality;
    static String max;
    static String min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        visited = new boolean[10];
        max = String.valueOf(Long.MIN_VALUE);
        min = String.valueOf(Long.MAX_VALUE);

        n = Integer.parseInt(br.readLine());
        tmpArr = new long[n+1];
        inequality = new char[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            inequality[i] = st.nextToken().charAt(0);
        }
        dfs(0);

        System.out.println(max);
        System.out.println(min);
    }
    static void dfs(int depth){
        if (depth == n+1){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tmpArr.length; i++){
                sb.append(tmpArr[i]);
            }
            String result = String.valueOf(sb);

            if (result.compareTo(max) > 0){
                max = result;
            }
            if (result.compareTo(min) < 0){
                min = result;
            }

            return;
        }

        for (int i = 0; i < 10; i++){
            if (!visited[i]){
                visited[i] = true;
                if (depth == 0){
                    tmpArr[depth] = i;
                    dfs(depth + 1);
                }else if (inequality[depth-1] == '<' && tmpArr[depth - 1] < i){
                    tmpArr[depth] = i;
                    dfs(depth + 1);
                }else if (inequality[depth-1] == '>' && tmpArr[depth - 1] > i){
                    tmpArr[depth] = i;
                    dfs(depth + 1);
                }
                visited[i] = false;
            }
        }

    }

}