import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int n;
    static int[][] map;

    static int minusCount = 0;
    static int zeroCount = 0;
    static int plusCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }
        prevRecu(n,0,0);

        StringBuilder sb = new StringBuilder();
        sb.append(minusCount).append('\n');
        sb.append(zeroCount).append('\n');
        sb.append(plusCount).append('\n');
        System.out.println(sb);
    }

    static void prevRecu(int size, int x, int y){
        recu(size,x,y,map[x][y]);
    }
    static void recu(int size, int x, int y, int sig){
        if (size == 1){
            if (sig == -1){
                minusCount++;
            }else if (sig == 0){
                zeroCount++;
            }else{
                plusCount++;
            }
            return;
        }

        boolean isFull = true;
        for (int i = x; i < x + size; i++){
            for (int j = y; j < y + size; j++){
                if (sig != map[i][j]){
                    isFull = false;
                }
            }
        }

        if (isFull){
            if (sig == -1){
                minusCount++;
            }else if (sig == 0){
                zeroCount++;
            }else{
                plusCount++;
            }
            return;
        }


        int newSize = size/3;

        for (int i = x; i < x + size; i += newSize){
            for (int j = y; j < y + size; j += newSize){
                recu(newSize,i,j,map[i][j]);
            }
        }
    }
}