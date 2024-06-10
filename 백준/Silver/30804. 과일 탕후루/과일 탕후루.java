import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            int fruit = Integer.parseInt(st.nextToken());
            arr[i] = fruit;
        }

        int lt=0;
        int maxLen=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int rt=0; rt<n; rt++){
            int fruit = arr[rt];
            map.put(fruit, map.getOrDefault(fruit,0)+1);

            while(map.size()>2){
                //과일종류가 2보다 커지면, lt를 우측으로 땅겨본다.
                map.put(arr[lt], map.get(arr[lt])-1);
                if(map.get(arr[lt])==0) map.remove(arr[lt]);

                lt++;
            }
            maxLen = Math.max(maxLen, rt-lt+1);
        }
        bw.write(maxLen+"");

        bw.flush();
        bw.close();
        br.close();


    }//main


}//Main
