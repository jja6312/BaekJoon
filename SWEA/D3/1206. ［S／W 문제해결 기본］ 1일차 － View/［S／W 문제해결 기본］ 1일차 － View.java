import java.util.*;
import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception
    {

        StringTokenizer st;
        int T=10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            String A = br.readLine();
            int[] arr = new int[n];
            st = new StringTokenizer(A, " ");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }//배열 초기화


            int sum = 0;
            for (int j = 0; j < n; j++) {
                int now = arr[j];
                int max = -1;
                for (int l = 1; l <= 2; l++) {
                    int lt, rt;

                    if (j - l >= 0) {
                        lt = arr[j - l];
                        if (max < lt) max = lt;
                    }

                    if (j + l < n) {
                        rt = arr[j + l];
                        if (max < rt) max = rt;
                    }
                }//for-2
                int sub = now - max;
                if (sub < 0) sub = 0;//음수면 더하지말자.
                sum += sub;
            }//for-1
            bw.write("#" + test_case + " " + sum + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}