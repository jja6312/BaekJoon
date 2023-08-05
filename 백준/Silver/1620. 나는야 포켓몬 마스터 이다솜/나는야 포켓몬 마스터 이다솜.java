import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String stringN = br.readLine();
        String[] arrN = stringN.split(" ");
        int N = Integer.parseInt(arrN[0]);
        int M = Integer.parseInt(arrN[1]);
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] numToName = new String[N];
        for(int i=0; i<N; i++){
            String pokemon = br.readLine();
            map.put(pokemon, i+1);
            numToName[i]=pokemon;
        }
        for(int i=0; i<M; i++){
            String keyValue = br.readLine();
            char a = keyValue.charAt(0);
            if((int)a>=65 && (int)a<123){
                bw.write(map.get(keyValue)+"\n");
            }else{
            	int keyValueInt = Integer.parseInt(keyValue);
                bw.write(numToName[keyValueInt-1]+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}