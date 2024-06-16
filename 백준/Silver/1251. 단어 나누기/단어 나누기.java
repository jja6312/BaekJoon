import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String A  = br.readLine();
        List<String> list = new ArrayList<>();
        for(int i=1; i<A.length(); i++){
            for(int j=i+1; j<A.length(); j++){
                StringBuilder sb1 = new StringBuilder(A.substring(0,i));
                StringBuilder sb2 = new StringBuilder(A.substring(i,j));
                StringBuilder sb3 = new StringBuilder(A.substring(j));

                StringBuilder sb = new StringBuilder();
                sb.append(sb1.reverse()).append(sb2.reverse()).append(sb3.reverse());
                list.add(sb.toString());
            }
        }

        Collections.sort(list);
        bw.write(list.get(0));
        bw.flush();
        bw.close();
        br.close();
    }

}
