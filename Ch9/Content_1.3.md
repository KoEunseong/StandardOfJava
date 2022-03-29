Chapter9 java.lang 패키지와 유용한 클래스
======================

### 1.3 StringBuffer클래스와 StringBuiler클래스
***
-String클래스는 인스턴스를 생성할 때 지정된 문자열을 변경할 수 없었지만 StringBuffer 클래스는 변경이 가능하다. 내부적으로 문자열 편집을 위한 버퍼를 가지고 있으며,
StringBuffer 인스턴스를 생성할 때 그 크기를 지정할 수 있다. String 클래스와 유사하게 char형 배열의 참조변수를 인스턴스 변수로 선언해 놓고 있다.  
-인스턴스를 생성할 때 버퍼(배열)의 크기를 충분히 지정해주는 것이 좋다. why? 버퍼넘어가면 버퍼 길이 늘려주는 작업이 추가로 수행되어서 비효율.
-String클래스와 달리 equals()를 오버라이딩하지 않았다.  
![image](https://user-images.githubusercontent.com/98599867/160566916-4aad44f6-9f9b-46b0-911b-f7cde5217ba8.png)
<br><br>
**StringBuffer의 생성자**  
StringBuffer 클래스의 인스턴스를 생성할 때, 적절한 길이의 char형 배열이 생성되고 배열은 문자열을 저장하고 편집하기 위한 공간(buffer)으로 사용된다. StringBuffer인스턴스를 생성할때, 버퍼의 크기를 지정해주지 않으면 16개의 문자를 저장할 수 있는 크기의 버퍼를 생성한다.  
![image](https://user-images.githubusercontent.com/98599867/160586468-c8fd0613-7702-4cbe-a471-456569d94afb.png)
<br><br>
**StringBuffer의 변경**
```java
StringBuffer sb = new StringBuffer("abc");
sb.append("123");
StringBuffer sb2 = sb.append("zz");
System.out.println(sb);
System.out.println(sb2); //둘다 같은 인스턴스를 가키고 있으므로 같은 내용 출력
```

**StringBuffer 클래스의 비교**<br>
앞에서 말했듯이 StringBuffer클래스는 equals메서드를 오버라이딩 하지 않았기 때문에 equals를 써도 == 연산자와 같은결과가 나온다. 반면 toString은 오버라이딩 되어 있어서
toString을 호출하면 그 안에 담겨있는 문자열이 나오는데 그문자열을 통해서 비교해야 한다.<br>
```java
class StringBufferEx1 {
	public static void main(String[] args) {
		StringBuffer sb  = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");

		System.out.println("sb == sb2 ? " + (sb == sb2));
		System.out.println("sb.equals(sb2) ? " + sb.equals(sb2));
		
		// StringBuffer의 내용을 String으로 변환한다.
		String s  = sb.toString();	// String s = new String(sb);와 같다.
		String s2 = sb2.toString();

		System.out.println("s.equals(s2) ? " + s.equals(s2));
	}
}
```
<br>**String클래스의 생성자와 메서드**  
String클래스와 유사한 메서드를 많이 가지고 있고 추가,변경, 삭제와 같이 저장된 내용을 변경할 수 있는 메서드들이 추가로 제공된다. 책p480  
![image](https://user-images.githubusercontent.com/98599867/160637972-d509a6ef-31d4-4f91-98a8-442a989c2e38.png)
![image](https://user-images.githubusercontent.com/98599867/160638003-6fbb9e4e-f7a1-457a-a995-4bfa076057eb.png)


**StringBuilder**  
StringBuffer는 멀티스레드 안전하도록 동기화되어있다. 멀티쓰레드로 작성된 프로그램이 아닌경우 StringBuffer에서 쓰레드의 동기화만 뺀 StringBuilder클래스를 사용하면 성능
을 높일수 있다.

