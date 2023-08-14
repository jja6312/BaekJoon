import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String firstLine;
    
    public static void main(String[]args) throws IOException{
        read();
        div();
        bw.flush();
        bw.close();
        br.close();

    }//main()

    public static void read() throws IOException{
        firstLine = br.readLine();
        // 괄호마다 () 가 몇개있는지 파악
        // 괄호가 n개 있다면, n+1개를 반환.
    }//read()

    public static void div() throws IOException{
        int len = firstLine.length();
        Deque<Character> deque = new ArrayDeque<Character>();
        int answer = 0;
        for(int i=0; i<len; i++){
            if(firstLine.charAt(i)=='('){
                deque.offer(firstLine.charAt(i));
            }else{
                deque.poll();
                if(firstLine.charAt(i-1)=='('){
                    answer+=deque.size();
                }else{
                    answer++;
                }//else
            }//else
        }//for
        bw.write(answer+"");
    }//div()
}//Main