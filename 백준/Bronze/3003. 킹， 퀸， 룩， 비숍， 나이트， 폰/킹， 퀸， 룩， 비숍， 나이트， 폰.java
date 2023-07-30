
import java.util.Scanner;
public class Main{
    public static void main(String []args){
    	
        Scanner s = new Scanner(System.in);
        String A = s.nextLine();
        String[] arr = A.split(" ");
        Integer[] arr2 = new Integer[arr.length];
        for(int i=0; i<arr.length; i++) {
        	arr2[i]=Integer.parseInt(arr[i]);
        }
        for(int i=0; i<arr.length; i++){
            if(i>=0 && i<=1){
                arr2[i]=1-arr2[i];
            }else if(i>=2 && i<=4){
                arr2[i]=2-arr2[i];
            }else if(i>4){
                arr2[i]=8-arr2[i];
            }
            System.out.print(arr2[i]+" ");
        }//for
        
        
        
    }//main()
}//Main class