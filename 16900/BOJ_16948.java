import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;

    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int curX = Integer.parseInt(st.nextToken());
        int curY = Integer.parseInt(st.nextToken());
        int destX = Integer.parseInt(st.nextToken());
        int destY = Integer.parseInt(st.nextToken());

        map[curX][curY] = 1;

        bfs(curX, curY);

        System.out.println(map[destX][destY] - 1);

    }
    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x, y});

        while (!q.isEmpty()){
            int[] poll = q.poll();

            for (int i = 0; i < 6; i++){
                int nextX = poll[0] + dx[i];
                int nextY = poll[1] + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n || map[nextX][nextY] > 0){
                    continue;
                }
                map[nextX][nextY] = map[poll[0]][poll[1]] + 1;
                q.add(new int[]{nextX, nextY});

            }

        }
    }
}


