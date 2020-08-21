package _03_Arrays_Methods.Exercises;

public class CombineArray {
    public static void main(String[] args) {
        int[] a= {1,2,3};
        int[] b= {4,5,6};
        int[] c = new int[a.length+b.length];
        for (int i = 0,k=0; i < c.length; i++) {
            if(i<a.length){
                c[i]= a[k++];
            }else if(i==a.length){
                k=0;
                c[i]=b[k++];
            }
            else
                c[i]= b[k++];
        }
    }
}
