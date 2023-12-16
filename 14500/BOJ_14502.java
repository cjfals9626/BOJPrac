import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx;
    static int[] dy;
    static int maxSafe;
    static int zeroCount;
    static int result;
    static List<Integer[]> virusStart;
    static int[][] tmpXY = new int[3][2];
    static int[][] lastXY = new int[3][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};
        maxSafe = 0;
        zeroCount = 0;
        result = 0;

        virusStart = new ArrayList<>();

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 2){
                    virusStart.add(new Integer[]{i,j});
                }
                if (num == 0){
                    zeroCount++;
                }
            }
        }

        dfs(0);

        System.out.println(result - 3);

    }
    static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x,y});

        visited[x][y] = true;
        int count = 0;
        while (!q.isEmpty()){
            int[] poll = q.poll();

            for (int i = 0; i < 4; i++){
                int nextX = poll[0] + dx[i];
                int nextY = poll[1] + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m || map[nextX][nextY] != 0 || visited[nextX][nextY]){
                    continue;
                }
                visited[nextX][nextY] = true;
                q.add(new int[]{nextX,nextY});
                count++;
            }
        }
        return count;
    }
    static void dfs(int depth){
        if (depth == 3){
            visited = new boolean[n][m];
            int sum = 0;
            for (int i = 0; i < virusStart.size(); i++){
                Integer[] getXY = virusStart.get(i);
                sum += bfs(getXY[0], getXY[1]);
            }
            int tmp = zeroCount - sum;

            if (result < tmp){
                result = tmp;
                for (int i = 0; i < 3; i++){
                    lastXY[i] = tmpXY[i];
                }
            }

            return;
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] == 0){
                    map[i][j] = 1;
                    tmpXY[depth] = new int[]{i, j};
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
}