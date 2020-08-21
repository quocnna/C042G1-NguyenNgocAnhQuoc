package _02_LoopStatement.Exercises;

public class Display20PrimeNumber {
    private static int count =0;
    public static void main(String[] args) {
        int i=1;
        do{
            i++;
            if(checkPrimeNumber(i)){
                System.out.println(i);
                count++;
            }
        }while (count<20);
    }
    private static boolean checkPrimeNumber(int a){
        for (int i = 2; i < a; i++)
            if(a%i==0)
                return false;
        return true;
    }
}
