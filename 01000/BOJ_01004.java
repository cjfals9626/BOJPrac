import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int planet = Integer.parseInt(br.readLine());

            int count = 0;

            for (int j = 0; j < planet; j++){
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                if (doubleCheck(cx, cy, r, x1,y1,x2,y2)){
                    count++;
                }

            }
            sb.append(count).append('\n');

        }
        System.out.println(sb);
    }
    static boolean doubleCheck(int x1, int y1, int r, int x2, int y2, int x3, int y3){
        if (inCircle(x1, y1, r,x2,y2) && inCircle(x1, y1, r, x3, y3)){
            return false;
        } else if (inCircle(x1, y1, r, x2, y2) || inCircle(x1, y1, r, x3, y3)) {
            return true;
        }else{
            return false;
        }
    }
    static boolean inCircle(int x1, int y1, int r, int x2, int y2){

        int dx = Math.abs(x1 - x2);
        int dy = Math.abs(y1 - y2);

        int calR = (dx * dx) + (dy * dy);

        if (calR > (r*r)){
            return true;
        }else{
            return false;
        }
    }
}