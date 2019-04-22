class Operation {
  public static void main(String [] args){

    // byte 타입을 사용하더라도 연산은 int로 이루어짐
    byte a = 10;
    byte b = 20;

//    byte c = a + b; // error
//    System.out.println(c);

    byte c = (byte)(a + b);
    System.out.println(c);


    // long 타입을 사용하더라도 연산은 int로 이루어짐
    int x = 1_000_000;
    int y = 2_000_000;

//    long z = x * y; // overflow
//    System.out.println(z);

    long z = (long)x * y; // okay
    System.out.println(z);


    // 상수, 리터럴의 연산은 컴파일 시에 바로 계산되므로 컴파일 에러가 발생하지 않는다.

//    char aa = 'a';
//    char cc = aa + 1; // error
    char cc = 'a' + 1;
    System.out.println(cc);

  }
}