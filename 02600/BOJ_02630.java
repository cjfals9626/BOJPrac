import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int n;
    static int[][] map;

    static int whiteCount = 0;
    static int blueCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        prevRecu(n,0,0);

        System.out.println(whiteCount);
        System.out.println(blueCount);

    }

    static void prevRecu(int size, int x, int y){
        if (map[x][y] == 0){
            recu(size, x,y,0);
        }else {
            recu(size, x,y,1);
        }
    }

    static void recu(int size, int x, int y, int sig){
        if (size == 1){
            if (sig == 0){
                whiteCount++;
            }else{
                blueCount++;
            }
            return;
        }

        int newSize = size/2;

        boolean isAll = true;

        for (int i = x; i < x + size; i++){
            for (int j = y; j < y + size; j++){
                if (sig != map[i][j]){
                    isAll = false;
                }
            }
        }

        if (isAll){
            if (sig == 0){
                whiteCount++;
            }else{
                blueCount++;
            }
            return;
        }


        for (int i = x; i < x + size; i += newSize){
            for (int j = y; j < y + size; j += newSize){
                recu(newSize, i, j, map[i][j]);
            }
        }
    }
}