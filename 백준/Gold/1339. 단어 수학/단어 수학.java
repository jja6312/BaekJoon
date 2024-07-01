import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static class Alpabet implements Comparable<Alpabet>{
        long weight;
        char ch;
        public Alpabet(long weight, char ch){
            this.weight = weight;
            this.ch = ch;
        }
        @Override
        public int compareTo(Alpabet o) {
            return Long.compare(o.weight, this.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        long[] weights = new long[26];  // 알파벳 가중치 저장 배열
        List<String> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            String A = br.readLine();
            list.add(A);
            long weight = 1;
            for(int j = A.length() - 1; j >= 0; j--){
                weights[A.charAt(j) - 'A'] += weight;
                weight *= 10;
            }
        }

        PriorityQueue<Alpabet> pq = new PriorityQueue<>();
        for(int i = 0; i < 26; i++){
            if(weights[i] > 0){
                pq.offer(new Alpabet(weights[i], (char)('A' + i)));
            }
        }

        int[] values = new int[26];
        int val = 9;
        while(!pq.isEmpty()){
            Alpabet current = pq.poll();
            values[current.ch - 'A'] = val--;
        }

        long sum = 0;
        for(String x : list){
            sum += parseStrToInt(x, values);
        }

        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static long parseStrToInt(String x, int[] values) {
        long sum = 0;
        long tenPow = 1;
        for(int i = x.length() - 1; i >= 0; i--){
            sum += values[x.charAt(i) - 'A'] * tenPow;
            tenPow *= 10;
        }
        return sum;
    }
}