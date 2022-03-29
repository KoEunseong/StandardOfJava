Chapter9 java.lang 패키지와 유용한 클래스
======================

### 1.4 Math 클래스
***
Math클래스는 기본적으로 수학계산에서 유용한 메서드로 구성되어 있다. Math클래스의 접근제어자는 private이라서 다른 클래스에서 생성이 불가하고 Math클래스의 모든 메서드들은 
static이다.<br><br>
**올림,버림,반올림**  
```
90.7552 * 100 //9075.52
Math.round(9075.52) //9076
9076 / 100.0 //90.76 소수점 셋째자리에서 반올림하는법
```
-round메서드는 항상 소수점 첫째 자리에서 반올림해서 정수값(long)을 결과로 돌려준다.  
-rint()도 round처럼 소수점 첫째 자리에서 반올림하지만 반환값이 double이다. 두 정수의 정가운데 있는 값은 가장 가까운 짝수 정수를 반환한다.  
-ceil 올림, floor 버림<br><br>
**예외를 발생시키는 메서드**<br>
메서드 이름에 'Exact'가 포함된 메서드들은 정수형 간의 연산에서 발생할 수 있는 오버플로우를 감지하기 위함. 연산자는 단지 결과를 반환할 뿐 오버플로우의 발생여부에 대해 알려주
지 않는다.
```java
import static java.lang.Math.*;
import static java.lang.System.*;

class MathEx2 {
	public static void main(String args[]) {
		int i = Integer.MIN_VALUE;

		out.println("i ="+i);
		out.println("-i="+(-i));

		try {
			out.printf("negateExact(%d)= %d%n",  10, negateExact(10));
			out.printf("negateExact(%d)= %d%n", -10, negateExact(-10));

			out.printf("negateExact(%d)= %d%n", i, negateExact(i)); // 예외발생
		} catch(ArithmeticException e) {
			// i를 long타입으로 형변환 다음에 negateExact(long a)를 호출
		     out.printf("negateExact(%d)= %d%n",(long)i,negateExact((long)i));
		}
	} // main의 끝
}
```
![실행결과](https://user-images.githubusercontent.com/98599867/160663712-8373b64b-5bec-48b8-aabc-863bee9fad3a.png)
<br>
**삼각함수와 지수, 로그**
자바 api를 참조하자  
sqrt() : 제곱근 계산  
pow() : n제곱을 계산  

**Math클래스의 메서드**<br>
가볍게 훝어보자  
![image](https://user-images.githubusercontent.com/98599867/160670459-dd32b84d-a964-4643-9e42-8f336380bf24.png)




