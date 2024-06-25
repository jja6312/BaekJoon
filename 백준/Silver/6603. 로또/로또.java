import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            dfs(arr, 0, new StringBuilder(), 0);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int[] arr, int start, StringBuilder sb, int depth) throws IOException {
        if (depth == 6) {
            bw.write(sb.toString().trim() + "\n");
            return;
        }

        for (int i = start; i < arr.length; i++) {
            int length = sb.length();
            sb.append(arr[i]).append(" ");
            dfs(arr, i + 1, sb, depth + 1);
            sb.setLength(length);
        }
    }
}
