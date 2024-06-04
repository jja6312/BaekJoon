import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Computer implements Comparable<Computer> {
        int relatedCom;
        int time;

        public Computer(int relatedCom, int time) {
            this.relatedCom = relatedCom;
            this.time = time;
        }

        @Override
        public int compareTo(Computer o) {
            return time - o.time;
        }
    }

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());//간선 개수
            int bugCom = Integer.parseInt(st.nextToken());

            List<Computer>[] edgeList = new ArrayList[n + 1];
            initList(edgeList, n);

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int computerA = Integer.parseInt(st.nextToken());
                int computerB = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                edgeList[computerB].add(new Computer(computerA, time));

            }//for-1

            int[] timeArr = new int[n + 1];
            Arrays.fill(timeArr, Integer.MAX_VALUE);//무한으로 초기화
            timeArr[bugCom] = 0;//첫시작컴퓨터는 감염되는데 걸리는시간 0

            PriorityQueue<Computer> pq = new PriorityQueue<>();
            pq.offer(new Computer(bugCom, 0));//가장 처음감염된 컴퓨터를 queue에 삽입


            while (!pq.isEmpty()) {
                Computer currentCom = pq.poll();
                int currentRelatedCom = currentCom.relatedCom;
                int currentTime = currentCom.time;


                for (Computer nextCom : edgeList[currentRelatedCom]) {
                    if (timeArr[nextCom.relatedCom] > timeArr[currentRelatedCom] + nextCom.time) {
                        //짧은 시간으로 초기화
                        timeArr[nextCom.relatedCom] = timeArr[currentRelatedCom] + nextCom.time;
                        pq.offer(nextCom);//다음순서 컴퓨터를 큐에 추가
                    }
                }
            }//while

            //큐에 추가작업이 끝나면, 데이터 검수
            int maxTime = 0;
            int sumCnt = 0;
            for (int time : timeArr) {
                if (time != Integer.MAX_VALUE) {
                    sumCnt++;
                    maxTime = Math.max(maxTime,time);
                }
            }

            bw.write(sumCnt +" "+maxTime+"\n");
        }//for-0:testCase


        bw.flush();
        bw.close();
        br.close();


    }//main

    private static void initList(List<Computer>[] edgeList, int n) {
        for (int i = 1; i <= n; i++) {
            edgeList[i] = new ArrayList<>();
        }
    }

}//Main
