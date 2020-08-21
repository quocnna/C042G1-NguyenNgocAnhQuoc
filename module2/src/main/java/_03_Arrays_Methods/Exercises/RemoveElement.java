package _03_Arrays_Methods.Exercises;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
public class RemoveElement {
    public static void main(String[] args) {
            int[] a = {1,2,3,4,5,3,7};
        int[] newArr = new int[a.length - 2];
        for(int j=0, k=0; j<a.length; j++) {
            if(j == 2 || j==5)
                continue;
            newArr[k++] = a[j];
        }
      //  a=  ArrayUtils.removeAll(a,2,5);
        System.out.println(Arrays.toString(newArr));
    }
}
