import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            int a = map.getOrDefault(A,0);
            int b = map.getOrDefault(B,0);
            if(A.equals("ChongChong") || B.equals("ChongChong") || a==1 || b==1){
                map.put(A,1);
                map.put(B,1);
            }
        }
        int cnt = 0;
        for(String key: map.keySet()){
            cnt+=map.get(key);
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();


    }
}
