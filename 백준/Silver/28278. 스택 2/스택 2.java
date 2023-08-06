import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Stack st = new Stack();

    public static void main(String[]args) throws IOException{
    	int N = Integer.parseInt(br.readLine());
    	for(int i=0; i<N; i++) {
    		read();
    	}
    	bw.flush();
    	bw.close();
    	br.close();
    }//main
    
    public static void read() throws IOException{
    	String A = br.readLine();
        if(A.charAt(0)=='1') {
        	String[] arrA = A.split(" ");
        	int x = Integer.parseInt(arrA[1]);
        	st.push(x);
        }else if(A.charAt(0)=='2') {
        	if(st.size()>=1) {
        		bw.write(st.pop()+"\n");
        	}else {
        		bw.write(-1+"\n");
        	}
        }else if(A.charAt(0)=='3') {
        	bw.write(st.size()+"\n");
        }else if(A.charAt(0)=='4') {
        	if(st.size()==0) bw.write(1+"\n");
        	else bw.write(0+"\n");
        }else if(A.charAt(0)=='5') {
        	if(st.size()>=1) {
        		bw.write(st.peek()+"\n");
        	}else {
        		bw.write(-1+"\n");
        	}
        	
        }
    	
    }
    /*
1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
3: 스택에 들어있는 정수의 개수를 출력한다.
4: 스택이 비어있으면 1, 아니면 0을 출력한다.
5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
    */
}//Main