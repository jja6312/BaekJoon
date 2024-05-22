import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int [] parent;

    static class Edge implements Comparable<Edge>{
        private Star star1;
        private Star star2;
        private double distance;
        public Edge(Star star1, Star star2, double distance){
            this.star1 = star1;
            this.star2 = star2;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return distance-o.distance>0 ? 1 : -1;
        }
    }

    static class Star{
        int index;
        double x;
        double y;
        public Star(int index, double x, double y){
            this.index = index;
            this.x=x;
            this.y=y;
        }
    }


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        //부모 초기화
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        //입력된 별을 list에 담는다.
        List<Star> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = i+1;
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            list.add(new Star(index, x,y));
        }

        //별을 엣지로 처리할 것임.
        List<Edge> edgeList = new ArrayList<>();

        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.size(); j++){
                if(i==j) continue;//같은애들끼리 비교하지말자

                Star star1 = list.get(i);
                Star star2 = list.get(j);
                double distance = calDistance(star1,star2);
                edgeList.add(new Edge(star1,star2,distance));
            }
        }

        Collections.sort(edgeList);

        double sum=0;
        for(int i=0; i<edgeList.size(); i++){//엣지리스트를 순회하며
            Star star1 = edgeList.get(i).star1;
            Star star2 = edgeList.get(i).star2;
            double distance = edgeList.get(i).distance;

            //루트가 같지 않다면(사이클을 만들지않도록), 간선 추가
            if(find(star1.index)!=find(star2.index)){
                sum+=distance;
                union(star1.index,star2.index);
            }
        }
        sum = ((int)(sum*100))/100.0;


        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void union(int index1, int index2) {
        int root1 = find(index1);
        int root2 = find(index2);

        if(root1!=root2){
           parent[root2] = root1;
        }
    }

    private static int find(int index) {
        if(index==parent[index]) return index;

        return parent[index] = find(parent[index]);
    }

    private static double calDistance(Star star1, Star star2) {
        double dx = Math.abs(star1.x-star2.x);
        double dy = Math.abs(star1.y-star2.y);


        return Math.sqrt((Math.pow(dx,2)+Math.pow(dy,2)));
    }


}