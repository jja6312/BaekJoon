import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String haveCard = br.readLine();
        String[] haveCardArr = haveCard.split(" ");
        int M = Integer.parseInt(br.readLine());
        String checkCard = br.readLine();
        String[] checkCardArr = checkCard.split(" ");
        
        Map <String, Integer> map = new HashMap<String, Integer>();
        int[] count = new int[N];
        for(int i=0; i<N; i++){
            map.put(haveCardArr[i], map.getOrDefault(haveCardArr[i],0)+1);
     
            }
        
        
        for(int i=0; i<M; i++){
            bw.write(map.getOrDefault(checkCardArr[i],0)+" ");
        }
        bw.flush();
        bw.close();
        br.close();
        
    }
}