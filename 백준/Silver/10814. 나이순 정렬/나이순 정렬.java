import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[][] result = new String[N][];
        for(int i=0; i<N; i++){
            String n = br.readLine();
            String[] nSplit = n.split(" ");
            result[i] = nSplit;
        }//for
        
        Arrays.sort(result, new Comparator<String[]>(){
            
            @Override
            public int compare(String[] s1, String[] s2){
                if (s1[0]==s2[0]){
                    return s1[1].compareTo(s2[1]);    
                }
                return Integer.parseInt(s1[0])-Integer.parseInt(s2[0]);
            }
        });
        for(int i=0; i<N; i++){
            bw.write((result[i])[0]+" "+(result[i])[1]);                
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
        
    }
}