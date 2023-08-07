/*
push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/
import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static LinkedList<Long> linkedList = new LinkedList<Long>();
    public static void main(String[]args) throws IOException{
    	read();
        bw.flush();
        bw.close();
        br.close();

        
    }//main()
    
    public static void read() throws IOException{
        long N = Long.parseLong(br.readLine());
        for(int i=0; i<N; i++){
            String A = br.readLine();
            if(A.charAt(0)=='p'){//if(첫글자가 p라면)
                if(A.charAt(1)=='u'){
                    String arrA[] = A.split(" ");
                    linkedList.add(Long.parseLong(arrA[1]));//정수를 추가한다.
                    
                }else if(A.charAt(1)=='o'){
                    if(!linkedList.isEmpty()){
                        bw.write(linkedList.pollFirst()+"\n");
                    }else{
                        bw.write(-1+"\n");
                    }//else(st가 비어있지 않다면)
                }//else if(pop)
            }//if (첫글자가 p라면)
            else if(A.charAt(0)=='s'){
                bw.write(linkedList.size()+"\n");
            }else if(A.charAt(0)=='e'){
                if(linkedList.isEmpty()){
                    bw.write(1+"\n");
                }else{
                    bw.write(0+"\n");
                }
            }else if(A.charAt(0)=='f'){
                if(linkedList.isEmpty()) bw.write(-1+"\n");
                else bw.write(linkedList.getFirst()+"\n");
                
            }else if(A.charAt(0)=='b'){
                if(linkedList.isEmpty()) bw.write(-1+"\n");
                else{                    
                    bw.write(linkedList.getLast()+"\n");
                    
                }
                
            }
        }//for ----
    }
    
}//Main