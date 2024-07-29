import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Word implements Comparable<Word>{
        int frequent;
        int length;
        String text;

        public Word(int frequent, int length, String text){
            this.frequent = frequent;
            this.length = length;
            this.text = text;
        }


        @Override
        public int compareTo(Word o) {
            if(frequent != o.frequent){
                return o.frequent - frequent;
            }else if(length != o.length){
                return o.length - length;
            }else{
                return text.compareTo(o.text);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            String A = br.readLine();
            if(A.length() < m) continue;

            int a = map.getOrDefault(A,0);
            if(a == 0){
                map.put(A,1);
            }else{
                map.put(A,a+1);
            }
        }

        PriorityQueue<Word> pq = new PriorityQueue<>();
        for(String key:map.keySet()){
            pq.offer(new Word(map.get(key),key.length(),key));
        }

        while(!pq.isEmpty()){
            bw.write(pq.poll().text+"\n");
        }


        bw.flush();
        bw.close();
        br.close();


    }
}
