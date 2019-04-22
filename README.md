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
