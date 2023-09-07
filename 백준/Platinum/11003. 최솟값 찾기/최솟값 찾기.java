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
        String A = br.readLine();
        StringTokenizer st = new StringTokenizer(A, " ");
        int N = Integer.parseInt(st.nextToken());
        int L =Integer.parseInt(st.nextToken());
        String B = br.readLine();
        Deque<Node> mydeque = new LinkedList<>();
        
        st = new StringTokenizer(B, " ");
        //arr초기화
        for(int i=0; i<N; i++){
            int now = Integer.parseInt(st.nextToken());
            //새로운 값이 들어올때마다 정렬 대신, 현재 수보다 큰 값을 덱에서 제거해 시간복잡도를 줄임.
            while(!mydeque.isEmpty() && mydeque.getLast().value > now){
                mydeque.removeLast();
            }
            mydeque.addLast(new Node(now, i));
            //범위에서 벗어난 값은 덱에서 제거
            if(mydeque.getFirst().index <=i-L){
                mydeque.removeFirst();
            }
            bw.write(mydeque.getFirst().value+" ");
        }
        
    }//read()
    
    static class Node{
        public int value;
        public int index;
        
        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}//Main