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
- 64bit cpu에서 int를 사용하는 것은 왜 괜찮은가???
  - ~~32bit cpu로 동작해서?>??????~~
  
```
리터럴 부분 집에서 한 것 추가하기
```


실수

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


 


