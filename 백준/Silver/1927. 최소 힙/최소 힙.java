import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static class Num implements Comparable<Num>{
        int num;
        public Num(int num){
            this.num = num;
        }

        @Override
        public int compareTo(Num o) {
            return num-o.num;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Num> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if (pq.isEmpty()) bw.write("0\n");
                else bw.write(pq.poll().num+"\n");
            }else{
                pq.offer(new Num(x));
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
