import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int[] arr;
    static int n;
    static boolean[] visited;
    static int[] tmpArr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        tmpArr = new int[6];

        while (s != null && !s.isEmpty()){
            StringTokenizer st = new StringTokenizer(s);

            n = Integer.parseInt(st.nextToken());

            arr = new int[n];
            visited = new boolean[n];


            for (int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }


            dfs(0,0);
            sb.append('\n');



            s = br.readLine();
            if (s.equals("0"))
                break;
        }
        System.out.println(sb);

    }
    static void dfs(int depth, int preNode){
        if (depth == 6){

            for (int i = 0; i < 6; i++){
                sb.append(tmpArr[i] + " ");
            }
            sb.append('\n');

            return;
        }

        for (int i = preNode; i < n; i++){
            if (!visited[i]){
                visited[i] = true;
                tmpArr[depth] = arr[i];
                dfs(depth+1, i);
                visited[i] = false;
            }
        }
    }
}