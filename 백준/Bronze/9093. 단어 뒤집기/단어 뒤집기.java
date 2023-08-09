import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[]args) throws IOException{
    	read();
        bw.flush();
        bw.close();
        br.close();

        
    }//main()
    
    public static void read() throws IOException{
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String A = br.readLine();
            st = new StringTokenizer(A, " ");
            while(st.hasMoreTokens()){
                String word = st.nextToken();
                Deque<Character> dq = new ArrayDeque<Character>();
                for(int j=0; j<word.length(); j++){
                    dq.offerFirst(word.charAt(j));
                }
                for(int j=0; j<word.length(); j++){
                   bw.write(dq.pollFirst()+"");
                }
                   bw.write(" ");
            }//while
            bw.write("\n");
        }//for

    }//read()
    
}//Main