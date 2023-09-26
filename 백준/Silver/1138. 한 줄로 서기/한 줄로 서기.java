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
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String secondLine = br.readLine();        
        StringTokenizer st = new StringTokenizer(secondLine, " ");
        
        Stack<Integer> result = new Stack<Integer>();
        Stack<Integer> temp = new Stack<Integer>();
        
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            
        }
        
        for(int i=N-1; i>=0; i--){
            for(int j=0; j<arr[i]; j++){
                temp.push(result.pop());
            }
            result.push(i+1);
            for(int j=0; j<arr[i]; j++){
                result.push(temp.pop());
            }
        }
        
        while(!result.isEmpty()){
            bw.write(result.pop()+" ");    
        }
        
        
        
        

    }//read()
}//Main