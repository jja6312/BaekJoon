import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[] arr = {a,b,c};
            Arrays.sort(arr);
            
            a = arr[0];
            b = arr[1];
            c = arr[2];

            if(a == 0 && b == 0 && c ==0) break;

            long powA = (long)Math.pow(a,2);
            long powB = (long)Math.pow(b,2);
            long powC = (long)Math.pow(c,2);

            if(powC == powA+powB) bw.write("right\n");
            else bw.write("wrong\n");

        }


        bw.flush();
        bw.close();
        br.close();

    }

}
