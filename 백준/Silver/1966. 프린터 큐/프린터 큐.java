

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=0; i<t; i++){
            int cnt=0;
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Deque<int[]> deque = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<n; j++){
                int num = Integer.parseInt(st.nextToken());
                deque.offer(new int[]{num, j});
            }

            while(!deque.isEmpty()){
                int[] poll= deque.poll();
                int pollNum = poll[0];
                int pollIdx = poll[1];
                boolean moreMaxNumExist = false;//더큰숫자가 존재하는지?
                for(int[] x: deque){//탐색
                    if(pollNum<x[0]){
                        moreMaxNumExist = true;//존재한다면 true
                        break;
                    }
                }

                if(moreMaxNumExist){//존재한다면 현재 poll을 다시 offer
                    deque.offer(new int[]{pollNum, pollIdx});
                }else if(!moreMaxNumExist && pollIdx==m){//존재하지않는다면 카운팅
                    cnt++;
                    break;
                }else if(!moreMaxNumExist){//존재하지않는다면 카운팅
                    cnt++;
                }

            }//while
            bw.write(cnt+"\n");
        }//for

        bw.flush();
        bw.close();
        br.close();

    }

}
