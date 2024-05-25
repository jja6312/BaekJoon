import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Number implements Comparable<Number>{
        int num;

        public Number(int num){
            this.num = num;
        }

        @Override
        public int compareTo(Number o){
            return o.num - num;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Number> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if(pq.isEmpty()){
                    bw.write("0\n");
                }else{
                    bw.write(pq.poll().num+"\n");
                }
            }else{
                pq.offer(new Number(num));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }



}
