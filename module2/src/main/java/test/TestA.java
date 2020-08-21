package test;

public class TestA {
 public static void main(String[] args) {
 //  TestB testB = new TestA2();
   TestA4 testA2 = new TestA4();
  System.out.println(testA2);
 }
}
class TestA2 implements TestB{
 @Override
 public String toString() {
  return "TestA2";
 }
}
class TestA3 extends TestA2{
}
class TestA4{
}

