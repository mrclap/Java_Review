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

### 4. 오버로딩(overloading)
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
