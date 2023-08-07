import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static LinkedList<Integer> linkedList = new LinkedList<Integer>();

    public static void main(String[]args) throws IOException{
    	read();
        loop();
        bw.write(""+linkedList.get(0));
        bw.flush();
        bw.close();
        br.close();

        
    }//main()
    
    public static void read() throws IOException{
        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++){
            linkedList.add(i);
        }
    }
    
    public static void loop(){
        while(true){
            if(linkedList.size()==1) break;
            linkedList.removeFirst();
            int saveInt = linkedList.getFirst();
            linkedList.removeFirst();
            linkedList.add(saveInt);
        }
    }
    
}//Main