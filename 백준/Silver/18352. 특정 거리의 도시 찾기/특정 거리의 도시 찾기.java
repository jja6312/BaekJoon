import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<City>[] cities;
    static int[] minDistance;

    static class City implements Comparable<City>{
        int nextCity;
        int distance;

        public City(int nextCity, int distance){
            this.nextCity = nextCity;
            this.distance = distance;
        }

        @Override
        public int compareTo(City o) {
            return distance - o.distance;
        }
    }


    public static void main(String[] args) throws IOException {
        //우선순위큐로, k보다 작은 도시들을 후보군에서 제거한다.
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        cities = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            cities[i] = new ArrayList<>();
        }
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            cities[start].add(new City(next,1));
        }

        minDistance = new int[n+1];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        minDistance[x] = 0;

        dijkstra(x);

        boolean found = false;
        for(int i=1; i<=n; i++){
            if(minDistance[i]==k){
                bw.write(i+"\n");
                found = true;
            }
        }

        if(!found){
            bw.write("-1\n");
        }






        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra(int x) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.add(new City(x,0));

        while(!pq.isEmpty()){
            City current = pq.poll();
            int currentCity = current.nextCity;
            int currentDistance = current.distance;

            if(currentDistance > minDistance[currentCity]) continue;

            for(City neighbor : cities[currentCity]){
                int newDistance = currentDistance + neighbor.distance;
                if(newDistance< minDistance[neighbor.nextCity]){
                    minDistance[neighbor.nextCity] = newDistance;
                    pq.add(new City(neighbor.nextCity, newDistance));
                }
            }
        }

    }


}
