import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String A = br.readLine();
        ArrayList<String> arrList = new ArrayList<String>();

        for(int i=0; i<A.length();i++){
            for(int j=i+1; j<=A.length(); j++){
                String a = A.substring(i,j);
                arrList.add(a);
            }
        }
        Set<String> set = new HashSet<String>(arrList);
        bw.write(set.size()+"");
        bw.flush();
        bw.close();
        br.close();
        
    }
}