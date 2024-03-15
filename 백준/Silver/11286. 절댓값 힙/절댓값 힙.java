import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if(Math.abs(o1)==Math.abs(o2)) return o1 > o2 ? 1 : -1;
                        return Math.abs(o1)-Math.abs(o2);
                    }
                }
        );

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0 && !pq.isEmpty()){
                sb.append(pq.poll()+"\n");
            }else if(x==0 && pq.isEmpty()){
                sb.append("0\n");
            }else if(x!=0){
                pq.offer(x);
            }
        }//for

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}