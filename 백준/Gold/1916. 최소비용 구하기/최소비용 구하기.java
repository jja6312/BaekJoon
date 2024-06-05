import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;

    static class City implements Comparable<City>{
        int endCity;
        int bus;

        public City(int endCity,int bus){
            this.endCity = endCity;
            this.bus = bus;
        }

        @Override
        public int compareTo(City o) {
            return bus-o.bus;
        }
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        List<City>[] edgeList = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            edgeList[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            int bus = Integer.parseInt(st.nextToken());
            edgeList[startCity].add(new City(endCity, bus));//엣지리스트에 도착정보 추가

        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(A,0));

        int[] cityINF = new int[n+1];
        Arrays.fill(cityINF,Integer.MAX_VALUE);
        cityINF[A] = 0;//출발지점 초기화

        while(!pq.isEmpty()){
            City city = pq.poll();
            int endCity = city.endCity;
            int bus = city.bus;

            if(endCity==B) {//다음 도시가 목적지라면 멈춘다.
                break;
            }

            if(cityINF[endCity]< bus) continue; // 현재 도착지비용이 이미 작으면 넘어간다.

            //아니라면,
            for(City next : edgeList[endCity]){
                int newCost = bus+next.bus;//다음으로 가기
                if(newCost < cityINF[next.endCity]){
                    cityINF[next.endCity] = newCost;
                    pq.offer(new City(next.endCity, newCost));
                }
            }

        }

        bw.write(cityINF[B]+"");
        bw.flush();
        bw.close();
        br.close();


    }//main

}//Main
