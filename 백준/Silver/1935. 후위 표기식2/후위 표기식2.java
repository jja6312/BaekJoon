import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Deque <Double>deque = new ArrayDeque<Double>();
    
        public static void main(String[]args) throws IOException{
            read();
            br.close();
            
        }//main()
    
        public static void read() throws IOException{
            int N = Integer.parseInt(br.readLine());
            String secondColumn = br.readLine();
            Double[] arr = new Double[N];
            for(int i=0; i<N; i++){//arr에 A,B,C의 정수값 할당
                arr[i] = Double.parseDouble(br.readLine());
            }
            
            for(int i=0; i<secondColumn.length(); i++){//데큐에 ABC...갖다넣기
                char element =secondColumn.charAt(i);
                if(!((int)element>=65 && (int)element<=90)) {
                	double index2 = deque.pollLast();
                	double index = deque.pollLast();
                	if(element=='*') {
                		deque.offerLast((double)index*index2);
                	}else if(element=='/') {
                		deque.offerLast((double)index/index2);
                	}else if(element=='+') {
                		deque.offerLast((double)index+index2);
                	}else if(element=='-') {
                		deque.offerLast((double)index-index2);
                	}//else if
                }else {
                	deque.offerLast(arr[(int)element-'A']);
                	
                }
                
            }//for     
            
            System.out.printf("%.2f", deque.pollLast());
            //그리고 deque에 갖다넣어서 연산을 나열하자.
        }//read()
            
            
            
}//Main