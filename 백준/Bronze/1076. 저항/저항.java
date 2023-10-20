import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 저항 색에 따른 값과 곱 매핑
        Map<String, Integer> valueMap = new HashMap<>();
        valueMap.put("black", 0);
        valueMap.put("brown", 1);
        valueMap.put("red", 2);
        valueMap.put("orange", 3);
        valueMap.put("yellow", 4);
        valueMap.put("green", 5);
        valueMap.put("blue", 6);
        valueMap.put("violet", 7);
        valueMap.put("grey", 8);
        valueMap.put("white", 9);

        String firstColor = sc.next();
        String secondColor = sc.next();
        String thirdColor = sc.next();

        long result = (valueMap.get(firstColor) * 10 + valueMap.get(secondColor))
                * (long) Math.pow(10, valueMap.get(thirdColor));
        System.out.println(result);
    }
}
