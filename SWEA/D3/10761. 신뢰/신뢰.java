

import java.io.*;
import java.util.*;

// ============== 문제 접근 ==============
// String을 담는 큐를 세 개 만들어서 풀자.
// 1번 큐 : B 스위치를 담는 큐
// 2번 큐 : O 스위치를 담는 큐
// 3번 큐 : BO 둘다 담는 큐

// 3번큐에서 뽑아낸 순서에 맞게, 버튼을 눌러야한다.
// 1,2번 큐를 peek해서, 본인이 눌러야될 버튼까지 열심히 달려간다.
// 하지만 본인이 눌러야될 버튼까지 도달하면 더이상 달려가면안되고, 3번큐를 확인(peek)했을 때 본인 알파벳이라면 다시 다음으로 달리게해준다.
// 본인의 큐가 끝나면 더이상 달리지 않아도 된다.

public class Solution {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t =Integer.parseInt(br.readLine());
        for(int test=1; test<=t; test++){
            sb.append("#").append(test).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n =Integer.parseInt(st.nextToken());
            Queue<String> queueB = new LinkedList<>();
            Queue<String> queueO = new LinkedList<>();
            Queue<String> queueBO = new LinkedList<>();

            //queue 초기화
            for(int i=0; i<n; i++){
                String alphabet = st.nextToken();
                String switchNum = st.nextToken();
                String sumStr = alphabet+switchNum;
                if(alphabet.equals("B")){
                    queueB.offer(sumStr);
                }else if(alphabet.equals("O")){
                    queueO.offer(sumStr);
                }
                queueBO.offer(sumStr);
            }

            // 달려나가라! 각자 peek한 곳의 숫자까지.
            int time = 0;
            int idxB = 1;
            int idxO = 1;
            while(!queueBO.isEmpty()){
                boolean justOneShot = false; //하나의 스위치만 트리거할 수 있다.
                //B야! 달려라.
                if(!queueB.isEmpty()) {// B 큐가 비어있지 않으면
                    int goalB = Integer.parseInt(queueB.peek().substring(1)); //숫자를 확인한다.
                    if(idxB < goalB){ // 만약 B의 위치가 목표점보다 작으면
                        idxB++; //목표로 달려
                    }else if(idxB == goalB && queueBO.peek().charAt(0)=='B'){// 목표점 까지 왔고, 내 차례라면?
                        //큐들에서 꺼내버리자!
                        queueB.poll();
                        queueBO.poll();
                        justOneShot = true;
                    }else if(idxB > goalB){
                        idxB--;
                    }

                    // 위 상황들이 아니면 가만히 기다려라..
                }

                //O야! 달려라.
                if(!queueO.isEmpty()) {// O 큐가 비어있지 않으면
                    int goalO = Integer.parseInt(queueO.peek().substring(1)); // 숫자를 확인.
                    if(idxO < goalO){ // 만약 O의 위치가 목표점보다 작으면
                        idxO++; //목표로 달려
                    }else if(idxO == goalO && queueBO.peek().charAt(0)=='O' && !justOneShot){// 목표점 까지 왔고, 내 차례고, 스위치를 이미 앞선 로직에서 누르지 않았다면?
                        //큐들에서 꺼내버리자!
                        queueO.poll();
                        queueBO.poll();
                    }else if(idxO > goalO){
                        idxO--;
                    }

                    // 위 상황들이 아니면 가만히 기다려라..
                }

                //이러다보면 언젠가 큐가 다 빠져나갈것. 그때가 시간이 끝난것.
                time++;
            }//while
            sb.append(time).append("\n");
        }//for
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
