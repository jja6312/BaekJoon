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
        /*앞 n자리 혹은 뒤n자리 중 작은값을 선택.*/
        String firstLine = br.readLine();
        StringTokenizer st = new StringTokenizer(firstLine, " ");
        String A = st.nextToken();
        String B = st.nextToken();
        
        
        int sub = B.length()-A.length();
        
        Character [] arr = new Character[B.length()];
        for(int i=0; i<B.length(); i++) {
        	arr[i] = B.charAt(i); 
        }
        
        
        int result = 51;
        int start=0;
        int end= A.length();
        
        for(int i=0; i<=sub; i++) {
        	int cnt = 0;
        	for(int j=0; j<A.length(); j++) {
        		if(A.charAt(j)!=arr[start]) cnt++;
        		if(j==A.length()-1) start = start-(A.length()-1);
        		start++;
        	}//for
        	if (cnt<=result) result = cnt;
        	
        }
        bw.write(result+"");
        
        
        
    }//read()
}//Main