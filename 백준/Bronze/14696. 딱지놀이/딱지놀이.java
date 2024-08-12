

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int STAR =4;
    static final int CIRCLE =3;
    static final int RECTANGLE =2;
    static final int SEMO =1;



    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<n; i++){
            Map<Integer, Integer> map1 = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int ea = Integer.parseInt(st.nextToken());
            for(int j=0; j<ea; j++){
                int x = Integer.parseInt(st.nextToken());
                if(x==4) map1.put(STAR, map1.getOrDefault(STAR,0)+1);
                else if(x==3) map1.put(CIRCLE, map1.getOrDefault(CIRCLE,0)+1);
                else if(x==2) map1.put(RECTANGLE, map1.getOrDefault(RECTANGLE,0)+1);
                else if(x==1) map1.put(SEMO, map1.getOrDefault(SEMO,0)+1);
            }

            Map<Integer, Integer> map2 = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            ea = Integer.parseInt(st.nextToken());
            for(int j=0; j<ea; j++){
                int x = Integer.parseInt(st.nextToken());
                if(x==4) map2.put(STAR, map2.getOrDefault(STAR,0)+1);
                else if(x==3) map2.put(CIRCLE, map2.getOrDefault(CIRCLE,0)+1);
                else if(x==2) map2.put(RECTANGLE, map2.getOrDefault(RECTANGLE,0)+1);
                else if(x==1) map2.put(SEMO, map2.getOrDefault(SEMO,0)+1);
            }

            if(map1.getOrDefault(STAR, 0) != map2.getOrDefault(STAR, 0)){
                if(map1.getOrDefault(STAR, 0) > map2.getOrDefault(STAR, 0)) bw.write("A\n");
                else bw.write("B\n");
            }else{//별개수가 같다면
                if(map1.getOrDefault(CIRCLE, 0) != map2.getOrDefault(CIRCLE, 0)){
                    if(map1.getOrDefault(CIRCLE, 0) > map2.getOrDefault(CIRCLE, 0)) bw.write("A\n");
                    else bw.write("B\n");
                }else{//원개수가 같다면
                    if(map1.getOrDefault(RECTANGLE, 0) != map2.getOrDefault(RECTANGLE, 0)) {
                        if (map1.getOrDefault(RECTANGLE, 0) > map2.getOrDefault(RECTANGLE, 0)) bw.write("A\n");
                        else bw.write("B\n");
                    }else{//렉탱글이 같으면
                        if(map1.getOrDefault(SEMO, 0) != map2.getOrDefault(SEMO, 0)) {
                            if (map1.getOrDefault(SEMO, 0) > map2.getOrDefault(SEMO, 0)) bw.write("A\n");
                            else bw.write("B\n");
                        }else{
                            bw.write("D\n");
                        }
                    }
                }
            }
        }//for
        bw.flush();
        bw.close();
        br.close();

    }//main()

}
