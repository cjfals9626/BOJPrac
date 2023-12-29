import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n;
    static int m;
    static char[][] map;
    static int[][] mapInt;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];
        mapInt = new int[n][m];

        for (int i = 0; i < n; i++){
            String s = br.readLine();
            for (int j = 0; j < m; j++){
                char c = s.charAt(j);
                map[i][j] = c;
            }
        }

        boolean isCor = false;

        for (int i = 0; i < n; i++){
            if (!isCor){
                for (int j = 0; j < m; j++){
                    dfs(i, j, map[i][j], 0, i, j);
                    if (mapInt[i][j] != 0){
                        isCor = true;
                        break;
                    }
                }
            }
        }

        if (isCor){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }


    static void dfs(int x, int y, char sign, int count, int destX, int destY){

        if (x == destX && y == destY && count >= 4){
            mapInt[x][y] = count;
        }

        for (int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m || map[nextX][nextY] != sign || visited[nextX][nextY]){
                continue;
            }

            visited[nextX][nextY] = true;
            dfs(nextX, nextY, sign, count + 1, destX, destY);
            visited[nextX][nextY] = false;
        }
    }
}
