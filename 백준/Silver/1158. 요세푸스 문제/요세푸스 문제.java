import java.util.*;
import java.io.*;

public class Main{
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
    
        public static void main(String[]args) throws IOException{
                read();
                bw.flush();
                bw.close();
                br.close();
            
        }//main()
    
        public static void read() throws IOException{
            String firstLine = br.readLine();
            StringTokenizer st = new StringTokenizer(firstLine, " ");
            int originN = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            bw.write("<");
            ArrayList <Integer> arrList = new ArrayList<Integer>();
            int index = (K-1)%originN;
            int N = originN;
            for(int i=1; i<=originN; i++){
                arrList.add(i);
            }
            for(int i=0; i<originN; i++){
                if(i!=originN-1){
                    bw.write(arrList.get(index) +", ");
                    arrList.remove(index);
                    N--;    
                    index = (index + K-1) % N;
                }
                
                if (i==originN-1) {
                    bw.write(arrList.get(0)+"");
                }
            }
            bw.write(">");

        }//read()
}//Main