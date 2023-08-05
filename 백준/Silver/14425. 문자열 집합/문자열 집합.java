import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String A = br.readLine();
        String[] NM = A.split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        
        String[] S = new String[N];
        String[] inspectorS = new String[M];
        for(int i=0; i<N; i++) S[i] = br.readLine();
        for(int i=0; i<M; i++) inspectorS[i] = br.readLine();
            
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<N; i++) map.put(S[i],1);
        int count=0;
        for(int i=0; i<M; i++) {
            count += map.getOrDefault(inspectorS[i],0);
        }
        bw.write(""+count);
        bw.flush();
        bw.close();
        br.close();
        
        
    }//main
}//Main