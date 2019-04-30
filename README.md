# Java의 정석 다시 보기

국비교육과정 교재였던 **Java의 정석** 다시 공부하기!
Java기초, 제대로 다시 쌓기!
기초가 **튼튼해야** 높이 쌓을 수 있다!

## Ground Rule

- '아는것 같은데?'는 없다!
- 눈과 머리를 믿지 말자! 무조건 타이핑해보자
- 하자 하자 하자!!! 

- - -
### Ch01. 자바를 시작하기 전에
#### about Java
##### 자바의 특징
- OS independent <code>("Write once. run anywhere")</code>
- 객체지향
- 배우기 쉽다 
  - 기본구문 : c++
  - 객체지향구문 : small talk (<code>관련 정보 찾아 볼 것</code>)
- 메모리 자동 관리(GC)
- 네트워크 / 분산처리 지원 
  - 풍부한 NW라이브러리 
- 멀티쓰레드 지원
  - 자바 인터프리터가 담당 : 시스템관계 없이 구현이 가능
- 동적 로딩(Dynamic Loading) 지원
  - 필요한 시점에 클래스를 로딩, 변경된 일부 클래스만 다시 컴파일
  
  
##### 자바로 프로그램 작성 기초
- 자바애플리케이션에는 main메서드를 포함하는 클래스가 반드시 하나있어야 한다.
  - <code>Exception in thread "main" java.lang.NoSuchMethodError: main</code>
- 소스파일의 이름은 <code>public class</code>의 이름과 일치해야 한다.
- 클래스파일은 .java 파일과는 달리 클래스마다 하나씩 생성된다.


- - -
### Ch02. 변수(Variable)
#### 1. 변수
##### 변수의 초기화
- Garbage value 
 - 메모리는 여러프로그램이 공유하는 자원이다. 변수를 선언만하고 초기화하지 않으면, 메모리만 할당해둔 상태이므로 이전에 메모리에 써둔 정체모를 값이 그대로 들어있다. 그게 가비지벨류다.
 
##### 변수의 명명규칙
- 대소문자가 구분되며 길이에 제한이 없다.
- 예약어를 사용해서는 안된다.
- 숫자로 시작해서는 안된다.
- 특수문자는 '_', '$'만을 허용한다.
- (+)클래스 이름의 첫 글자는 항상 대문자로 한다. / _변수와 메서드의 이름은 소문자_
- (+)카멜표기법을 사용한다.
  - exampleValue
- (+)상수는 대문자로 표기하며, '_'를 이용한다
  - FINAL_VALUE



#### 2. 변수의 타입
##### 기본형 vs 참조형
- 기본형은 실제 값(data)을, 참조형 변수는 주소(address)를 갖는다.
  - 자바는 참조형 변수간 연산이 불가하다.
- 참조형 변수는 (4byte 혹은 8byte 크기의 주소) or null을 값으로 갖는다.
   
##### Using <code>short</code> data type on 32-bit CPU
- ~~메모리의 사용은 줄일 수 있으나, cpu에서 32bit식 연산하므로 연산 후 다시 short size(1byte)로 데이터를 잘라내는 작업이 수행 됨~~
  - <code>조금 더 공부해봐야 할 듯. JVM operand stack 등 개념과도 연관이 있을지 모름</code>
- ~~32bit cpu로 동작해서?>??????~~
  
실수형 리터럴 표현
- **실수형 리터럴은 기본이 double이므로 float 변수 사용시 접미사 f가반드시 필요!**
- float 10f  / float 10.0f
- float 3.14e3f / float 3140.0f
- overflow 발생 -> infinity
- underflow -> 너무 작은 값을 표현하려고 할 때( 0이 되어 버림) 
  - ex) float타입의 -1.4x10e-45 ~ 1.4x10e-45 범위
- <code> int type : 부호 + 값
 float type : 부호 + 지수 + 가수</code>
 이므로 실수 타입은 더 큰 절대값을 표현할 수 있으나 정밀도가 떨어진다.

문자형 
```java
char타입의 경우 반드시 문자가 들어가야 함.
    char ch = ''; // error!
    char ch2 = ' '; // available!

String은 클래스이므로 연산자 new를 이용해야 하지만
    String str = new String("string")
    String str2 = "string"
의 표현 허용
```

특수문자 다루기
```java
/b : backspace로 지우는 것이 가능.
System.out.println("가나다/t123/bABC") // 가나다  12ABC 
```

casting
- double -> float
  - float의 범위를 넘어서는 값 캐스팅 시 'inifinity'
  
int와 float의 정밀도 차이
- int의 범위는 약 20억으로 2,000,000,000 약 <u>**10자리**</u>의 정확도,
- float은 훨씬 큰 수를 저장할 수 있지만, <u>**7자리**</u>의 정밀도를 가짐

- - -
### Ch03. 연산자(Operator)
#### 3. 산술연산자
##### 사칙연산자

byte 타입을 사용하더라도 연산은 int로 이루어짐
```java
byte a = 10;
byte b = 20;
byte c = a + b; // error
byte c = (byte)(a + b) // okay
```

long 타입을 사용하더라도 연산은 int로 이루어짐
```java
int x = 1_000_000;  <--- **언더바를 잘 사용하자!**
int y = 2_000_000;

long z = x * y; // overflow

long z = (long)x * y; // okay
```

상수, 리터럴의 연산은 컴파일 시에 바로 계산되므로 컴파일 에러가 발생하지 않는다
```java
int a = 'a';
int c = a + 1; //error

int c = 'a' + 1; //okay
```

_ _ _
### Ch04. 조건문과 반복문 
#### 1. 조건문
##### -
#### 2. 반복문
##### 2.1 for문

쉼표를 이용하여 여러 변수, 여러 증감식을 한 번에 나타낼 수 있음
```java
for(int i=1, j-10;i<10;i++,j--) { ... } 
```

필요하지않은 요소는 생략할 수 있음
```java
for(;;){ ... } // 기본적으로 무한 반복을 하는 for문
```

~~loop에 label을 붙여 continue, break에 사용할 수 있지만 쓰지말자~~


- - -
### Ch05. 배열(Array)
#### 1. 배열
##### 배열이란
배열은 각 저장공간이 연속적으로 배치된다
 - _정말 100% 그런것인가_..?

##### 배열의 선언/생성
선언은 타입명 뒤 혹은 변수 이름 뒤
```java
int[] numbers;
int numbers[];
```

길이가 0인 배열이 필요할 때가 있다?
- <code>int[] arr = new int[0];</code>
- todo) 있다고하는데 나중에 다시 살펴보자.


##### 배열초기화

배열에 저장할 값을 {}를 이용하여 초기화
- new int[]를 생략할 수 있음
```java
int[] numbers = new int[]{ 1, 2, 3, 4, 5};
int[] numbers = {1, 2, 3, 4, 5};
단, 배열의 선언과 생성이 따로인 경우 생략할 수 없음.
```

길이가 0인 배열

```java
int[] number = new int[0];
int[] number = new int[]{};
int[] number = {};
```


#### 2. String베열
##### 

_ _ _
### Ch06. 객체지향언어
#### 3. 변수와 메서드
##### 3.7 JVM의 메모리 구조

Method Area / Call stack / Heap 으로 구성
- 메서드 영역 : 클래스 데이터(*.class), 클래스 변수 데이터를 저장
- 힙 : 인스턴스, 인스턴스 변수를 저장
- 호출 스택 : 메서드 작업에 필요한 메모리 공간, 메서드가 다른 메서를 호출하면, 그 위에 스택으로 호출된 메서드가 할당됨

기본형 매개변수 vs 참조형 매개변수 => <u>***당연한듯 보이지만 실제 구현할때 가끔 헷갈리니 잘 봐둘것!***</u>
- 기본형 매개변수는 변수의 값을 읽기만 함
- 참조형 매개변수는 변수의 값을 읽고 변경할 수 있음(값의 주소를 받기때문)
  - 배열을 이용하여 굳이 클래스를 생성하지 않고도 call by reference를 구현할 수 있다.
  - return을 참조형으로하면 호출한 method가 호출된 method에서 생성한 객체를 사용할 수 있다.

##### 3.10 재귀호출(recursive call)

재귀호출은 반복문보다 수행시간이 더 오래 걸린다
- 매개변수 복사, 실행 후 복귀 주소 저장 등의 이유
<<<<<<< HEAD

##### 3.11 클래스 메서드(static)

멤버변수 : 클래스 영역에 선언된 변수
- 인스턴트 변수 : 인스턴스 생성시 생성
- 클래스 변수 : 인스턴스 생성여부와 관계없이 생성

#### 4. 오버로딩(overloading)
##### 4.5 가변인자(varargs)와 오버로딩

가변인자를 이용해 연속되는 파라미터를 하나로 묶어 줄 수 있다.
```java
String concatenate(String s1, String s2) {...}
String concatenate(String s1, String s2, String s3) {...}
String concatenate(String s1, String s2, String s3, String s4) {...}

=>
String concatentage(String... str) {...}

```
**하지만 호출 시 마다 배열이 생성되므로 비효율 발생!**


#### 5. Constructor
##### 5.1 생성자

생성자가 instance를 생성하는 것이 아니다! ** 연산자 new **가 생성하는 것이다!!! keep in mind!

##### 5.4 생성자에서 다른 생성자 호출 그리고 this

한 생성자에서 다른 생성자 호출시 반드시 <u>첫 줄</u>에서 해야 함!
 - 그렇지 않을 경우 이미 위에서 초기화한 어떤 값을 아래에서 생성자를 호출함으로 날려 버릴 수가 있음.

this
 - 참조변수
 - 인스턴스 자신을 가리킴
 - 인스턴스의 주소가 존재
 - cf)this(): this()는 생성자이며, 같은 클래스의 다른 생성자를 호출할때 사용한다.
 
#### 6. 변수의 초기화
##### 6.1 변수의 초기화

멤버변수(클래스 변수, 인스턴스 변수)는 초기화 없이 사용할 수 있지만(기본값으로 초기화)
지역 변수(메서드의 변수)는 사용전 반드시 초기화를 거쳐야 한다.
 
멤버변수의 초기화 방법
 1. 명시적 초기화(explicit initialization)
 2. 생성자(constructor)
 3. 초기화 블럭(initialization block)
 
##### 6.3 초기화 블럭(initialization block)

초기화 블럭의 종류
- 클래스 초기화 블럭
  - 클래스 메모리에 처음 로딩될 때 한 번 수행
```java
static { ... }
```

- 인스턴스 초기화 블럭
  - 생성자와 같이 인스턴스를 생성할 때 마다 수행(생성자보다 우선)
```java
{ ... } 
```


_ _ _
### Ch07. 객체지향 프로그래밍
#### 2. 오버라이딩(overriding)
##### 2.2 오버라이딩의 조건
1. 접근 제어자는 조상 클래스의 메서드보다 좁은 범위일 수 없다.
 - 조상 클래스의 메서드가 protected라면, 자식은 protected or public 이어야 함
 - public -> protected, (default), private
2. 조상 클래스의 메서드보다 많은 수의 예외를 선언할 수 없다.
 - 갯수뿐만이 문제가 아니라 Exception의 상속 관계도 고려해야 한다.
 
##### 2.5 super() - 조상 클래스의 생성자
부모클래스의 생성자에 매개변수가 없는 기본형태의 생성자( 클래스명(){ ... } )가 없으면, 상속받은 클래스의 생성자에 반드시 부모 생성자를 명시해야함.
안그러면 컴파일러가 super(); 를 default로 추가하므로 컴파일 에러 발생.
 
#### 3. package와 import
##### 3.2 패키지 선언
패키지명은 클래스와 구분하기 위해 '소문자'로 쓰는 것을 원칙으로 함

##### java.lang
java.lang의 클래스들은 패키지명 없이 사용이 가능하다.
- String
- StringBuffer
- Process
- Runtime
- Thread
- Math
- StrictMath
- Exception Throwable
- Error
- Package
- Class
- ClassLoader
- Wrapper
- System
- Stream

##### 3.5 static import
import문을 사용하여 클래스의 패키지명을 생략하듯,
static import문을 사용하여 static멤버 호출 시 클래스 이름을 생략할 수 있다.

```java
import static java.lang.Math.random;
import static java.lang.System.out;

System.out.println(Math.random()); -> out.println(random());
```

#### 4. 제어자(Modifier)
##### 4.2 static: '클래스의', '공통적인'
##### 4.3 final: '마지막의', '변경될 수 없는'
더 이상 오버라이딩을 할 수 없다..... 사요나라.

더 이상 다른 녀석이 상속을 받을 수도 없다. 마지막 세대

**인스턴스 변수는 생성자에서 초기화 되도록 할 수 있다**
```java

class Card {
    final int NUMBER;
    final STring KIND;
    static int width = 100;
    static int height = 250;
    
    Card(String kind, int num) {
        KIND = kind; // <- 여기서 final 인스턴스변수 초기화
        NUMBER = num; // <- 여기서 final 인스턴스변수 초기화
    }
}
```

**카드 deck을 만들였다면 실제 실행시에 카드값을 바꾸는 로직이 아닌, 순서를 바꾸는 형태로 코딩해야 한다!!!!!!!!!!!**

##### 4.4 abstract: '추상의', '미완성의'
##### 4.5 접근 제어자
실제 구현에서 적용해보자!!!

> private: 같은 클래스 내에서만 접근

> default: 같은 패키지 내에서만 접근

> protected: 같은 패키지 내에서 + 다른 패키지의 자손클래스에서(상속에 의해)

> public: 접근 제한 없음


접근제어자를 통한 캡슐화(encapsulation)
- 외부로부터의 접근 제한
- 복잡성을 줄임: 클래스내에서만 사용되는 내부작업을 위한 변수나 메서드 등을 감춤
```java
public class Time {
    public int hour;
    public int minute;
    public int second;
}
// 위 처럼 Time 클래스가 정의된 경우
Time t = new Time();
t.hour = 25; // 이러한 형태의 값 할당이 가능하지만 말도안된다!
// 따라서 setter를 이용하며, setter에서 유효한 값인지 판단 후 할당해준다.
public class Time {
    private int hour;
    private int minute;
    private int second;
    
    public int getHour() { return hour; }
    public void setHour(int hour) {
        if(hour < 0 || hour > 23) return;
        this.hour = hour;
    }
    public int getMinute() { return minute; }
    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) return;
        this.minute = minute;
    }
    public int getSecond() { return second; }
    public void setSecond(int second) {
        if (second < 0 || second > 59) return;
        this.second = second;
    }
}
```

생성자를 private으로 선언하여 인스턴스 생성을 제한할 수 있다
- singleton 패턴을 사용한다던가..

클래스의 생성자가 private이라면 class는 final로 선언하는 것이 좋다
- 자손클래스의 인스턴스 생성시 조상클래스의 생성자를 호출해야하지만 불가능하므로

#### 5. 다형성(polymorphism)
##### 5.1 다형성이란
'여러 가지 형태를 가질 수 있는 능력'
- 한 타입의 참조변수에 여러 타입의 객체를 담을 수 있다!!!

##### 5.3 instanceof 연산자

참조변수가 참조하고 있는 인스턴스의 실제 타입을 알아보기 위해 사용하는 연산자
```java
if (c instanceof FireEngine) { ... }
```

##### 5.4 참조변수와 인스턴스의 연결

메서드의 경우 조상 타입의 참조변수로 자손의 인스턴스를 참조하는 경우에도 오버라이딩되어 인스턴스의 메서드가 호출되지만
인스턴스 변수의 경우에는 참조변수 타입에 따라 달라져버린다!

#### 6. 추상 클래스(abstract class)

추상 메서드를 단지 {} 를 이용하여서도 만들 수 있지만,
상속받는 자손 클래스에게 해당 메서드의 구현을 '강요'하기 위해서 필요하다.

#### 7. 인터페이스(interface)

추상 클래스보다 더 추상화 정도가 높으며, **일반메서드/멤버변수**를 가질 수 **없다**.
**상수**는 public static final(생략가능)의 형태로 가질 수 있음
메서드는 public abstract(생략가능)

**<u>jdk 1.8부터 static, default method가 가능하다고 하니 찾아보자</u>**

리턴타입이 인터페이스라는 것은 메서드가 해당 인터페이스를 구현한 클래스의 인스턴스를 반환한다는 것을 의미한다.

##### 7.7 인터페이스의 장점
1. 개발시간을 단축할 수 있다
2. 표준화가 가능하다
3. 서로 관계없는 클래스들에게 관계를 맺어 줄 수 있다.
 - 다형성을 갖게 해주기 좋다?!
 - SCV가 치료할 수 있는 유닛들을 구분하기
 
4. 독립적인 프로그래밍이 가능하다
 - 클래스의 선언과 구현을 분리시킬 수 있으므로
 
##### 7.8 인터페이스의 사용
- 인터페이스를 매개변수로 활용하여, 인스턴트를 매개변수로 넣어주는 것을 이용해 여러 인스턴트에 대해 동일한 작업을 수행할 수 있다.
- 또한 매개변수로 인스턴트를 넣어주지않고 아예 getInstance와 같은 메서드를 갖는 클래스를 별도로 생성하여 거기에서만 인스턴스를 바꿀 수 있도록 하는 코드를 작성할 수도 있다.
  - 1권 p399~400 

##### 7.9 default 메서드와 static 메서드
- JDK 1.8부터 지원한다

static
- static 메서드가 추가되기 전에는 collection 인터페이스와 collections 클래스가 함께 존재했다
  - collections 클래스는 collection 인터페이스와 관련된 static 메서드들이 구현되어있음
  - 11장에 더 자세히!

default
- 인터페이스에 선언된 모든 추상메서드는 구현체에서 구현되어야 함
- 디폴트 메서드는 추상메서드가 아니기 때문에 구현체에서 구현되지 않아도 문제가 없다.
  - ***이거.. 인터페이스의 근간과 충돌하는 문제가 있지 않나??.. 특히 .. 내용없이 {}로 바로 닫아버린다면, 구현체에따라서 해당 메서드의 기능이 없는데.. 사용하려고 시도하는 등의 문제가...생기지않을까?***
- 여러 인터페이스에서 동일한 이름의 default 메서드가 있는경우 구현체에서 오버라이딩해서 문제를 해결

_ _ _
### Ch08. 예외처리(Exception handling)
***Exception은 개발자의 실수를 위해 존재한다기보다는 사용상의 문제들을 managing하기 위한 것이라고 생각된다.
물론 1차적으로 입력값을 체크한다던가 하는 처리는 해야겠지!***


#### 1. 예외처리(exception handling)
에러 vs 예외
- 에러 : 메모리 부족, 스택오버플로우 등으로 일단 발생하면 복구할 수 없는 심각한 오류
- 예외 : 발생하더라도 수습이 될 수 있는 비교적 덜 심긱한 것

##### 1.2 예외 클래스의 계층 구조
크게 RuntimeException과 이를 제외한 나머지 Exception으로 나누어짐
- RuntimeException
   - 프로그래머의 실수에 의해서 발생하는 예외
   - 프로그래밍 요소와 관련이 깊다
       - IndexOutOfBoundsException : 배열의 범위를 벗어남
       - NullPointerException : 값이 null인 참조변수의 멤버를 호출하려 함
       - ClassCastException : 클래스간 형변환을 잘못함
       - ArithmaticException : 정수를 0으로 나누려고 시도함
       
- 그 외의 Exception
    - 외부 영향에 의해 발생하는 예외
       - FileNotFoundException : 존재하지 않는 파일의 이름 입력
       - ClassNotFoundException : 실수로 클래스의 이름을 잘못 적음
           - ***왜 클래스의 이름을 잘못적는 것이 외부 영향일까 ..?***
       - DataFormatException : 데이터 형식이 잘못 됨

##### 1.3 예외처리(try catch)
예외를 처리하지 못하면, 프로그램은 비정상 종료되며,
JVM의 '예외처리기(UncaughtExceptionHandler)'가 받아서 예외의 원인을 출력

##### 1.5 예외의 발생과 catch블럭
printStackTrace() / getMessage()

printStackTrace()
- 에외 발생 당시의 호출스택에 있던 메서드의 정보와 예외 메시지를 출력

getMessage()
- 예외 메시지 출력

에러메시지
- <code>Exception e = new Exception(**"에러메시지"**);</code>

RuntimeException이 발생하는 코드를 가지고 있어도 컴파일은 문제없이 됨
- 프로그래머의 실수에 의해 발생하는 것이므로 컴파일러가 예외처리를 강제하지 않음
- 즉 컴파일 단계에서 예외처리를 체크하지 않음(unchecked예외)
- 만일 RuntimeException클래스들에 속하는 예외가 발생할 가능성이있는 코드마다 예외처리를하면 코드가 매우 비효율적으로 변함..
  - 배열을 화면에 뿌린다거나 하는 프로세스마다.. try catch를 잡아줘야함.

##### 1.8 finally
try블럭에 return이 있더라도
finally실행 후 return 된다.

##### 1.9 자원 자동 반환 (try-with-resource)

```java
try( 객체 생성 문장 ) { // 이때 생성되는 객체가 try블록 종료 후 close()를 호출하려면
                     // AutoCloseable 인터페이스를 구현한 객체이어야 한다.
    ...
}
```

##### 1.11 에외 되던지기 (exception re-throwing)
catch에서 예외 처리 후 다시 throw exception으로 호출한 메서드에 예외를 던짐

- - -
### Ch09. java.lang
#### 1. java.lang
##### 1.1 object 클래스
hashCode() 
- 자바에서는 객체의 주소값을 이용하여 해시값을 만들기때문에 서로다른 두 객체는 같은 해시값을 가질 수 없음
  - <code>System.identityHashCode(Object x)</code>
```java
// String클래스에 오버라이딩 된 hashCode메서드
// 동일한 값을 가진 String객체라면 동일한 hash값을 가지도록 되어있다.
public int hashCode() {
    int h = hash;
    if (h == 0 && value.length > 0) {
        char val[] = value;

        for (int i = 0; i < value.length; i++) {
            h = 31 * h + val[i];
        }
        hash = h;
    }
    return h;
}
```


> native 메서드
- 자바에서 네이티브 응용프로그램/C/C++/어셈블리 등의 다른 언어로 작성된 라이브러리들을 호출

공변 반환 타입(Convariant return type)
-  자손 클래스에서 메서드의 리턴 타입을 자손 클래스 타입으로 변경할 수 있음(jdk 1.5~)

##### 1.2 String 클래스

```java
// 컴파일러에 의해 str1과 str2는 동일한 String 인스턴스를 참조하게 된다.
String str1 = "abc";     // str1 == str2
String str2 = "abc";
String str3 = new String("abc"); // str3 != str4
String str4 = new String("abc");
```

##### 1.5 Wrapper 클래스

Integer, Float, Long등은 기본형 int, float, long의 wapper클래스
- \>, < 등의 연산자 대신 compareTo 사용,
- Byte.parseByte, Integer.parseInt는 기본형을 반환하지만
- Byte.valueOf, Integer.valueOf는 래퍼 클래스를 반환
```java
int i = Integer.paraseInt("100")   <---> int i = Integer.valueOf("100")
long ln = Long.parseLong("100")    <---> long ln = Long.valueOf("100")
```
- 래퍼클래스가 기본형보다 조금 더 느림
- 오토박싱으로 인해 기본형과 참조형(래퍼클래스)간에 연산이 가능
- 기본형->래퍼클래스 : 오토박싱
- 래퍼클래스->기본형 : 언박싱
- ArrayList등에 기본형 int를 넣으면 오토박싱이 이루어짐

#### 2.유용한 클래스
#### 2.1 java.util.Objects
- Object클래스의 보조 클래스, 모든 메서드가 static
- 객체비교, 널체크 등에 유용함


- - -
### Ch10.날짜와 시간 & 형식화
#### 1. 날짜와 시간
##### 1.1 Calendar와 Date

Date<->Calendar
> 1. Calendar -> Date
```java
Calendar cal = Calendar.getInstance();
...
Date d = new Date(cal.getTimeInMillis());
```
2. Date -> Calendar
```java
Date d = new Date();
...
Calendar cal = Calendar.getInstance();
cal.setTime(d);
```

#### 3. java.time패키지
##### 3.1 java.time 패키지의 핵심 클래스

- - - 
### Ch11. 컬렉션 프레임 워크(Collections Framework)
<u>***전체적으로 자유롭게 collection을 사용할 수 있어야한다!!!***</u>


#### 1. 컬렉션 프레임웍(Collections Framework)
데이터 군을 저장하는 클래스들의 표준화 설계

##### 1.9 TreeSet
자바의 TreeSet은 '레드-블랙 트리'로 구현되어 짐

[zedd0202님의 친절한 설명](https://zeddios.tistory.com/237)

