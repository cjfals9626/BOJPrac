import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int year = 1;

        int tmpE = 1;
        int tmpS = 1;
        int tmpM = 1;

        while (!(tmpE == e && tmpS == s && tmpM == m)){
            year++;
            tmpE++;
            tmpS++;
            tmpM++;
            if (tmpE >= 16){
                tmpE = 1;
            }
            if (tmpS >= 29){
                tmpS = 1;
            }
            if (tmpM >= 20){
                tmpM = 1;
            }
        }

        System.out.println(year);
    }

}