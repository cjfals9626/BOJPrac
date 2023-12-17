
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String aS = st.nextToken();
        String bS = st.nextToken();
        String cS = st.nextToken();
        String dS = st.nextToken();
        long a = Long.parseLong(aS);
        long b = Long.parseLong(bS);
        long c = Long.parseLong(cS);
        long d = Long.parseLong(dS);

        String abS = aS.concat(bS);
        String cdS = cS.concat(dS);

        long ab = Long.parseLong(abS);
        long cd = Long.parseLong(cdS);

        System.out.println(ab+cd);
    }
}