

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());
        for(int t = 1; t <= test; t ++){
            sb.append("#").append(t).append(" ");
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=0; i<n; i++){
                pq.offer(Integer.parseInt(st.nextToken()));
            }

            while(!pq.isEmpty()){
                sb.append(pq.poll()).append(" ");
            }

            sb.append("\n");

        }//for - test
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
