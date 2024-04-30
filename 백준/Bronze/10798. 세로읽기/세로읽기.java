import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        List<Character>[] arr = new ArrayList[5];

        List<Character> list;

        int maxLen = -1;
        for(int i=0; i<5; i++){
            String A = br.readLine();
            list = new ArrayList<>();
            for(int j=0; j<A.length(); j++){
                list.add(A.charAt(j));
            }
            arr[i] = list;
            if(list.size()>maxLen) maxLen = list.size();
        }

        for(int i=0; i<maxLen; i++){
            for(int j=0; j<5; j++){
                if(i>=arr[j].size()) continue;
                bw.write(arr[j].get(i)+"");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }//main

}//Main
