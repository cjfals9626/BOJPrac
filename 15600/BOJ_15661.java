import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int n;
    static int[][] abl;
    static boolean[] visited;
    static int min;
    static Integer[] t1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        abl = new int[n][n];
        visited = new boolean[n];
        min = Integer.MAX_VALUE;
        t1 = new Integer[n];


        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                int num = Integer.parseInt(st.nextToken());
                abl[i][j] = num;
            }
        }

        dfs(0, 0);

        System.out.println(min);
    }
    static void dfs(int depth, int preNode){
        if (depth == n - 1 || min == 0){
            return;
        }

        for (int i = preNode; i < n; i++){
            if (!visited[i]){
                visited[i] = true;
                t1[depth] = i;
                for (int j = depth + 1; j < n; j++){
                    t1[j] = null;
                }

                cal(t1);

                dfs(depth + 1, i);
                visited[i] = false;
            }
        }
    }

    static void cal(Integer[] team1){
        int totalTeam1 = 0;
        int totalTeam2 = 0;

        boolean[] team2 = new boolean[n];
        for (int i = 0; i < n; i++){
            team2[i] = true;
        }

        for (int i = 0; i < n; i++){

            if (team1[i] != null){
                team2[team1[i]] = false;
            }

            for (int j = 0; j < n; j++){
                if (i != j && team1[i] != null && team1[j] != null){
                    totalTeam1 += abl[team1[i]][team1[j]];
                }
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i != j && team2[i] == true && team2[j] == true){
                    totalTeam2 += abl[i][j];
                }
            }
        }

        int d = Math.abs(totalTeam1 - totalTeam2);

        if (min > d) {
            min = d;
        }
    }
}