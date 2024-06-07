import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<City>[] listEdge;

    static class City implements Comparable<City>{
        int nextCity;
        int busCost;

        public City(int nextCity, int busCost){
            this.nextCity = nextCity;
            this.busCost = busCost;
        }

        @Override
        public int compareTo(City o) {
            return busCost-o.busCost;
        }
    }


    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        listEdge = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            listEdge[i] = new ArrayList<>();
        }


        int m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++){
            StringTokenizer st=  new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int busCost = Integer.parseInt(st.nextToken());

            listEdge[start].add(new City(end, busCost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        PriorityQueue<City> pq = new PriorityQueue<>();


        int[] cost = new int[n+1];
        int[] prev = new int[n + 1];  // 경로 추적을 위한 배열 추가
        Arrays.fill(cost,Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        cost[startCity] = 0;//시작 도시 거리 초기화


        pq.offer(new City(startCity, 0));
        while(!pq.isEmpty()){
            City currentCity = pq.poll();
            int city = currentCity.nextCity;
            int busCost = currentCity.busCost;

            if (busCost > cost[city]) continue;

            for(City next:listEdge[city]){
                if(cost[next.nextCity]>cost[city]+next.busCost){
                    cost[next.nextCity] = cost[city] + next.busCost;
                    pq.offer(new City(next.nextCity, cost[next.nextCity]));
                    prev[next.nextCity] = city;//이전 도시 기록
                }
            }

        }

        bw.write(cost[endCity]+"\n");

        List<Integer> list = new ArrayList<>();
        int goal = endCity;

        while (goal != -1) {  // 경로를 추적하여 리스트에 추가
            list.add(goal);
            goal = prev[goal];
        }



        Collections.reverse(list);

        bw.write(list.size() + "\n");
        for (int x : list) {
            bw.write(x + " ");
        }



        bw.flush();
        bw.close();
        br.close();


    }//main



}//Main
