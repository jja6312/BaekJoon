import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Deque<Character> deque = new ArrayDeque<>();

        boolean isTrue;
        int cnt=0;
        for(int i=0; i<n; i++){
            isTrue = true;

            String A = br.readLine();
            if(A.length()%2==1) continue;
            for(int j=0; j<A.length(); j++){

                if(j==0){//첫번째 문자열이라면 그냥 추가한다.
                    deque.addLast(A.charAt(j));
                    continue;
                }

                if(!deque.isEmpty() && deque.peekLast()==A.charAt(j)){//비어있지 않고, 현재 문자열과 스택이 같으면
                    deque.removeLast();//스택에서 꺼내준다.
                }else if(!deque.isEmpty() && deque.peekLast()!=A.charAt(j)){//같지 않으면 false다.
                    deque.addLast(A.charAt(j));
                }else if(deque.isEmpty()){//비어있다면 새로 집어 넣어 준다.
                    deque.addLast(A.charAt(j));
                }
            }//for2

            if(!deque.isEmpty()) isTrue=false;

            if(isTrue) cnt++;
            deque.clear();//정리
        }//for1
        bw.write(""+cnt);
        bw.flush();
        bw.close();
        br.close();
    }

}