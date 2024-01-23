import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[][][] shapes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        shapes = new int[][][]{
                {
                        {1, 1, 1, 1},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}
                },
                {
                        {1, 1, 0, 0},
                        {1, 1, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}
                },
                {
                        {1, 0, 0, 0},
                        {1, 0, 0, 0},
                        {1, 1, 0, 0},
                        {0, 0, 0, 0}
                },
                {
                        {1, 0, 0, 0},
                        {1, 1, 0, 0},
                        {0, 1, 0, 0},
                        {0, 0, 0, 0}
                },
                {
                        {1, 1, 1, 0},
                        {0, 1, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}
                }
        };


        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j ++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }


        int resultMax = 0;

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 5; j ++){
                resultMax = Math.max(resultMax, checkOneShape(shapes[j])) ;
                resultMax = Math.max(resultMax, checkOneShape(symmetryUpDown(shapes[j]))) ;
                resultMax = Math.max(resultMax, checkOneShape(symmetryRL(shapes[j]))) ;
                shapes[j] = rotation(shapes[j]);
            }
        }

        System.out.println(resultMax);

    }

    static int[][] rotation(int[][] arr){
        int[][] tmpArr = new int[4][4];

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++) {
                tmpArr[j][4-1-i] = arr[i][j];
            }
        }
        return tmpArr;
    }

    static int checkOneShape(int[][] arr){
        int max = 0;
        for (int i = 0; i < n+3; i++){
            for (int j = 0; j < m+3; j++){
                max = Math.max(max, check(arr, i - 3, j - 3));
            }
        }
        return max;
    }

    static int check(int[][] arr, int x, int y){
        int sum = 0;
        int count = 0;
        for (int i = x; i < x + 4; i++){
            for (int j = y; j < y + 4; j++){
                if (i < 0 || j < 0 || i >= n || j >= m){
                    continue;
                }
                if (arr[i - x][j - y] == 1){
                    sum += map[i][j];
                    count++;
                }
            }
        }
        if (count == 4){
            return sum;
        }else{
            return 0;
        }
    }

    static int[][] symmetryUpDown(int[][] arr){
        int[][] tmpArr = new int[4][4];

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++) {
                tmpArr[i][j] = arr[i][3 - j];
            }
        }
        return tmpArr;
    }

    static int[][] symmetryRL(int[][] arr){
        int[][] tmpArr = new int[4][4];

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++) {
                tmpArr[i][j] = arr[3 - i][j];
            }
        }
        return tmpArr;
    }
}


