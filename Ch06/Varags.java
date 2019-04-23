class Varags {
  public static void main(String [] args){

    // !!! 선언과 동시가 아니라면 new String[]을 제외한 { ... } 만을 사용할 수는 없다!!! 깜빡했다!
//    System.out.println(concatenate("_", {"100", "200", "300"}));
    System.out.println(concatenate("_", new String[]{"100", "200", "300"}));
    System.out.println(new String[]{"100", "200", "300"});

  }
  static String concatenate(String delim, String... args) {
    String result = "";

    for(String str: args) {
      result += str + delim;
    }

    return result;
  }
}