

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static class Box implements Comparable<Box>{
		int h;

		public Box(int h){
			this.h = h;
		}


		@Override
		public int compareTo(Box o) {
			return h-o.h; //박스 높이가 낮은것부터 오름차순 정렬
		}
	}
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringBuilder sb = new StringBuilder();
	    for (int test = 1; test <= 10; test++) {
	        sb.append("#").append(test).append(" ");
			List<Box> list = new ArrayList<>(); // Box를 높이 순으로 오름차순 정렬
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int i=0; i<100; i++){ // 상자를 리스트에 담는다.
				list.add(new Box(Integer.parseInt(st.nextToken())));
			}

			Collections.sort(list); //오름차순으로 정렬.

			for(int i=0; i<n; i++){ //덤프횟수 n만큼 작업을 반복한다.
				list.get(list.size()-1).h--;//최대값에서 하나 뺸다.
				list.get(0).h++;//최소값에 하나 더한다.

				Collections.sort(list); // 배열 다시 정렬. 시간복잡도 O(n * 100 * log 100)
			}

			sb.append(list.get(list.size()-1).h - list.get(0).h).append("\n"); //최대 - 최소 출력

	    }
	    bw.write(sb.toString());
	    bw.flush();
	    bw.close();
	    br.close();
	}

}
