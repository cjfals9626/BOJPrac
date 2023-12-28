import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1, 1};
    static int m;
    static int n;
    static int[][] map;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1){
                    q.add(new int[]{i, j});
                }
            }
        }


        bfs();


        int max = 0;

        boolean isFull = true;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] == 0){
                    isFull = false;
                }
                max = Math.max(max, map[i][j]);
            }
        }


        if (isFull){
            System.out.println(max - 1);
        }else{
            System.out.println(-1);
        }

    }
    static void bfs(){

        while (!q.isEmpty()){
            int[] poll = q.poll();

            int curX = poll[0];
            int curY = poll[1];

            for (int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m || map[nextX][nextY] != 0){
                    continue;
                }
                q.add(new int[]{nextX, nextY});
                map[nextX][nextY] = map[curX][curY] + 1;
            }
        }
    }
}
