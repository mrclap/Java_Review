class Casting {
  public static void main(String [] args){
    // float에 범위를 넘는 double형 값을 casting하여 넣으면 infinity가 됨.

    double d = 1.0e100; // float보다 큰 수
    float f = (float)d;

    String result;
    if(f>d) {
      result = "true";
    }else{
      result = "false";
    }
    System.out.println("d : " + d + ", f : " + f);
    System.out.println("d > f ? => " + result );

    double d2 = 1.0e-50;
    float f2 = (float)d;

    if(f2>d2) {
      result = "true";
    }else{
      result = "false";
    }
    System.out.println("d2 : " + d2 + ", f2 : " + f2);
    System.out.println("d2 > f2 ? => " + result );
  }
}