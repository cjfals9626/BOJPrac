import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++){
            int l = Integer.parseInt(br.readLine());

            int[][] map = new int[l][l];
            boolean[][] visited = new boolean[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken());
            int curY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int destX = Integer.parseInt(st.nextToken());
            int destY = Integer.parseInt(st.nextToken());

            bfs(curX, curY, destX, destY, l, map, visited);

            sb.append(map[destX][destY]).append('\n');
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y, int destX, int destY, int l, int[][] map, boolean[][] visited){
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{x,y});
        visited[x][y] = true;

        while (!q.isEmpty()){
            int[] poll = q.poll();
            int curX = poll[0];
            int curY = poll[1];

            if (destX == curX && destY == curY){
                return;
            }

            for (int i = 0; i < 8; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= l || nextY >= l || visited[nextX][nextY] || map[nextX][nextY] != 0){
                    continue;
                }

                q.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
                map[nextX][nextY] = map[curX][curY] + 1;
            }
        }
    }
}
