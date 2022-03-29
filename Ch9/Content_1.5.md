Chapter9 java.lang 패키지와 유용한 클래스
======================

### 1.5 래퍼(Wrapper)클래스
***
객체지향 개념에서 모든 것은 객체로 다루어져야 한다. 그러나 자바에서는 8개의 기본형을 객체로 다루지 않아서 완전한 객체지향 언어가 아니라는 얘기를 듣는다. 이 기본형 변수도
객체를 다뤄야 하는 경우에 래퍼wrapper클래스를 사용하면 기본형 값을 객체로 다룰 수 있다.  
![image](https://user-images.githubusercontent.com/98599867/160671531-a8cfc7dc-3727-4951-bd06-16750c81c891.png)  
래퍼클래스의 생성자는 매개변수로 문자열이나 각 자료형의 값들을 인자로 받는다. 매개변수로 문자열 전달할때 알맞은 문자열 사용하지 않을시 NumberFormatException이 발생한다.
ex) new Intger("1.0");  
![image](https://user-images.githubusercontent.com/98599867/160671723-137cab47-6a6d-4648-8c55-abbc855a5c99.png)
이 처럼 래퍼 클래스들은 객체생성 시에 생성자의 인자로 주어진 각 자료형에 알맞은 값을 내부적으로 저장하고 있다.  
래퍼 클래스들은 모두 equals가 오버라이딩 되어있어 주소값이 아닌 가지고 있는 값을 비교. compareTo()를 제공  
compareTo() 함수는 두개의 값을 비교하여 int 값으로 반환해주는 함수이다. 그리고 toString도 오버라이딩 되어 있어 가지고 있는 값을 문자열로 반환.
<br><br>
**Number 클래스**
  ![image](https://user-images.githubusercontent.com/98599867/160673836-8417c08d-eb12-4383-b763-e4bfec975a74.png)  
  이 클래스는 추상클래스로 내부적으로 숫자를 멤버변수로 갖는 래퍼 클래스들의 조상이다. 기본형 중에서 숫자와 관련된 래퍼 클래스들은 모두 이 클래스의 자손이다.
 그 외에도 자손으로 BigInteger, BigDecimal 등이 있다.  
 참고로 Number클래스는 객체가 가지고 있는 값을 숫자와 관련된 기본형으로 변환하여 반환하는 메서드들을 정의하고 있다.  
 ![image](https://user-images.githubusercontent.com/98599867/160674657-4706e784-e415-458d-bf69-853bdac21d87.png)
<br><br>
**문자형을 숫자로 변환하기**  
```java
int i = Integer.parseInt("10"); //문자열을 기본형으로 변경
Integer i = Integer.valueOf("10); //문자열을 래퍼클래스로 변경
```
JDK1.5부터 도입된 오토박싱 기능 때문에 반환값이 기본형일때나 래퍼클래스일때 차이가 없어졌다.<br><br>

**오토박싱 & 언박싱**
1.5버전 이후 컴파일러가 자동으로 변환하는 코드를 넣어주기 때문에 기본형과 참조형간의 연산이 가능해 졌다. 
int i = 5;  
Integer iobj = new Integer(7);  
int sum = i + iobj; ==> 컴파일 되면 int sum = i = iobj.intValue();로 변환  
이 외에도 ArrayList, Vector클래스에 기본형 저장해야 할때나 형변환 필요할 때 컴파일러가 자동으로 코드를 추가해 준다.  
기본형 값을 래퍼 클래스로 자동 변환해주는 것 : 오토박싱, 그반대의 변환 : 언박싱<br><br>

```java
ArrayList<Integer> list = new ArrayList<Integer>();
list.add(10); //오토박싱 10 ->integer
list.get(0) //언박싱 
```
```java
class WrapperEx3 {
	public static void main(String[] args) {
		int i = 10;

        // 기본형을 참조형으로 형변환(형변환 생략가능)
		Integer intg = (Integer)i; // Integer intg = Integer.valueOf(i);
		Object   obj = (Object)i;  // Object obj = (Object)Integer.valueOf(i);

		Long     lng = 100L;  // Long lng = new Long(100L);

		int i2 = intg + 10;   // 참조형과 기본형간의 연산 가능
		long l = intg + lng;  // 참조형 간의 덧셈도 가능

		Integer intg2 = new Integer(20);
		int i3 = (int)intg2;  // 참조형을 기본형으로 형변환도 가능(형변환 생략가능)

		Integer intg3 = intg2 + i3; 

		System.out.println("i     ="+i);
		System.out.println("intg  ="+intg);
		System.out.println("obj   ="+obj);
		System.out.println("lng   ="+lng);
		System.out.println("intg + 10  ="+i2);
		System.out.println("intg + lng ="+l);
		System.out.println("intg2 ="+intg2);
		System.out.println("i3    ="+i3);
		System.out.println("intg2 + i3 ="+intg3);
	}
}
```
위 예제는 오토박싱을 이용해 기본형과 참조형 , 심지어는 참조형 간의 연산도 가능하다는 것을 보여준다.
