import java.awt.*;
import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arrN = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrM = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrN);


        for (int i = 0; i < m; i++) {
        int startIdx = 0;
        int endIdx = n - 1;
            boolean isFind = false;
            while (startIdx<=endIdx) {

                int idx = (startIdx + endIdx) / 2;
                if (arrN[idx] == arrM[i]) {
                    isFind = true;
                    break;
                } else if (arrN[idx] > arrM[i]) {
                    endIdx = idx-1;
                } else if (arrN[idx] < arrM[i]) {
                    startIdx = idx+1;
                }

            }//while
            if(isFind) bw.write("1\n");
            else bw.write("0\n");

        }//for


        bw.flush();
        bw.close();
        br.close();


    }//main


}//MainClass