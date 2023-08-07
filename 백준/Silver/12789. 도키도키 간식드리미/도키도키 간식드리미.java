import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Integer> linkedList = new LinkedList<Integer>();
    static Stack<Integer> st = new Stack<Integer>();
    static boolean trueSwitch = true;

    
    public static void main(String[]args) throws IOException{
    	read();
        
    	
       
        
    }//main()
    
    public static void read() throws IOException{
        int N = Integer.parseInt(br.readLine());
        String A = br.readLine();
        String[] arrA = A.split(" ");
        
        //큐에 차례로 추가
        for(int i=0; i<N; i++){
            linkedList.offer(Integer.parseInt(arrA[i]));
        }
        
        //큐에서 차례로 빼서 스택으로 넣는다.(큐가 isEmpty()일때까지)
        int n=1;
        while(!linkedList.isEmpty() || !st.isEmpty()){// 둘다 empty가 될때까지 실행
            if(!linkedList.isEmpty()) { // 1가 비어있지 않다면 ------------
            	if(linkedList.peek()!=n){ 										//1을 본다. 봤는데 n이 아니라면
            		if(!st.isEmpty()) {		//2가 비어있지 않다면 2를 봐준다
            			if(st.peek()==n) {			//이때 2가 n이있으면
            				st.pop();				//꺼내주고
            				n++;					//n++.
            			}else if(st.peek()!=n){		//이때 2에 n이 없으면
            				st.push(linkedList.poll());//1을꺼내서 2에 넣어준다.
            				//trueSwitch= false;
            				//break;
            			}
            		}else if(st.isEmpty()){ //2가 비어있다면
            			st.push(linkedList.poll());	//1에서 꺼내온다.
            		}
            	}else if(linkedList.peek()==n){									//1을봤는데 n이라면
            		linkedList.poll();//쇽 빼주고
            		n++;			//n++
            	}//else if
            }//if
            else if(linkedList.isEmpty()&&!st.isEmpty()) {//1가 비어있고 2가 비어있지 않다면
            	if(st.peek()==n) {//2에서 쇼부보자. 봤을때 n이면
            		st.pop();//뽑아내고
            		n++;//n++
            	}
            	else if(st.peek()!=n){//근데 n아니면?
            		trueSwitch=false;//바로실패때려버리기 ㅋㅋ
            		break;
            	}
            }
        }//while
       
        if(trueSwitch) bw.write("Nice\n");
        else if(!trueSwitch) bw.write("Sad\n");
        
        bw.flush();
        bw.close();
        br.close();
        

    }//read()
    
}//Main