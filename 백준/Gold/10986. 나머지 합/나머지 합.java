import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        read();
        bw.flush();
        bw.close();
        br.close();
    }

    public static void read() throws IOException {
        String A = br.readLine();
        StringTokenizer st = new StringTokenizer(A, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String B = br.readLine();
        st = new StringTokenizer(B, " ");

        long[] s = new long[N + 1];
        s[0] = 0;

        for (int i = 1; i <= N; i++) {
            s[i] = (s[i - 1] + Integer.parseInt(st.nextToken())) % M;
        }

        long[] C = new long[M];
        long ans = 0;

        // Initialize with 1 for the case where subarray starts from index 0
        C[0] = 1;

        for (int i = 1; i <= N; i++) {
            // add the count of subarrays that would sum to a number divisible by M when added to s[i]
            ans += C[(int) (s[i] % M)];
            
            // increment the count for remainder s[i] % M
            C[(int) (s[i] % M)]++;
        }

        bw.write(ans + "");
    }
}
