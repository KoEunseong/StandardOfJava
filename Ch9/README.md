Chapter9 java.lang 패키지와 유용한 클래스
======================
## 1. java.lang 패키지
**java.lang** 패키지는 자바에서 가장 기본이 되는 클래스들을 포함하고 있고 그렇기 때문에 import 없이도 사용이 가능하다.(ex String, System 클래스)


### 1.1 Object클래스
Object클래슨는 모든 클래스의 최고 조상이기 때문에 Object클래스의 멤버들은 모든 클래스에서 바로 사용 가능하다.
<!-- Image -->
![object 클래스 메서드](https://s3.ap-northeast-2.amazonaws.com/opentutorials-user-file/module/516/2123.png)

-`equals(Object obj) `<br>
매개변수로 객체의 참조변수를 받아서 비교하여 그 결과를 boolean값으로 알려 주는 역할
```java
class EqualsEx1 {
	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);		

		if (v1.equals(v2)) {
			System.out.println("v1과 v2는 같습니다.");
		} else {
			System.out.println("v1과 v2는 다릅니다.");		
		}

		v2 = v1;

		if (v1.equals(v2)) {
			System.out.println("v1과 v2는 같습니다.");
		} else {
			System.out.println("v1과 v2는 다릅니다.");		
		}
	} // main 실행결과는 첫번째 : true 두번째 false
} 

class Value {
	int value;

	Value(int value) {
		this.value = value;
	}
}
```
이처럼 기존 Object클래스는 두 참조변수에 저장된 값이 같은지 판단하는 기능밖에 할 수 없기 때문에 다른 것으로(ex: id) 비교하기 위해서는 아래 예제처럼 오버라이딩 해서 사용하면 된다.
```java
class Person {
	long id;

	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Person) {
			return id ==((Person)obj).id;
		} else {
			return false;
		}
	}

	Person(long id) {
		this.id = id;
	}
}

class EqualsEx2 {
	public static void main(String[] args) {
		Person p1 = new Person(8011081111222L);
		Person p2 = new Person(8011081111222L);

		if(p1==p2)
			System.out.println("p1과 p2는 같은 사람입니다.");
		else
			System.out.println("p1과 p2는 다른 사람입니다.");

		if(p1.equals(p2))
			System.out.println("p1과 p2는 같은 사람입니다.");
		else
			System.out.println("p1과 p2는 다른 사람입니다.");
	
	}
}
```
String 클래스도 문자열 값이 같으면 true가 오버라이딩이 구현되어 있다.



-`hashCode()`<br>
  해싱 기법에 사용되는 '해시함수를 구현한것. 클래스의 인스턴스 변수 값으로 객체의 같고 다름을 판단해야하는 경우라면 equals메서드 뿐 만 아니라 hashCode 메서드도 적절히 오버
  라이딩 해야한다. 같은 객체라면 hashCode메서드를 호출했을 때의 결과값인 해시코드도 같아야 하기 때문이다.
  ```java
  class HashCodeEx1 {
	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");

		System.out.println(str1.equals(str2));
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
	}
}
```
String클래스는 문자열의 내용이 같으면 동일한 hash코드를 반환하도록 hashCode()메서드가 오버라이딩 되어있다. 반면에 System.identityHashCode(Object x)는 객체의 주소 값으로 해시코드를 생성하기 때문에 모든 객체에 대해 항상 다른 해시코드 값을 반환할 것을 보장한다. 그래서 str1과 str2는 해시코드는 같지만 서로 다른 객체라는 것을 알 수 있다.
<br><br>
-`toString()` : Object클래스에 정의된 toString()은 아래와 같다.
```java
public String toString(){
  return getClass().getName+"@"+Integer.toHexString(hashCode());
}
```
즉 toString을 호출하면 쿨래스 이름에 16진수의 해시코드를 얻게된다.<br>
```java
package langPackage;
class Card2 {
    String kind;
    int number;

    Card2() {
        this("SPADE", 1);
    }

    Card2(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }
    @Override
    public String toString() {
        // Card인스턴스의 kind와 number를 문자열로 반환한다.
        return "kind : " + kind + ", number : " + number;
    }
}

public class CardToString{
    public static void main(String[] args) {
        Card2 c1 = new Card2();
        Card2 c2 = new Card2("HEART", 10);
        //System.out.println(c1.toString());
        System.out.println(c1);
        System.out.println(c2.toString());
    }
}
```
<br>
위 예제처럼 오버라이딩해서 일반적으로 인스턴스나 클래스에 대한 정보 또는 인스턴스 변수들의 값을 문자열로 반환하도록 오버라이딩 되는것이 보통이다.
Object 클래스에 정의된 toString접근제어자가 public 이므로 Card클래스의 toString의 접근제어자도 public으로 했다는 것을 눈 여겨 보자. 조상에 정의된 메서드를 자손에서 오버라
이딩 할 때는 조상의 정의된 접근제어자보다 같거나 더 넓어야 하기 대문이다.<br>
--참고로 String클래스와 Date 클래스의 경우 Date인스턴스가 갖고 있는 날짜와 시간을 문자열로 변환하여 반환하도록 오버라이딩 되어 있다.<br>
<br>

-`Clone()`<br>
이 메서드는 자신을 복제하여 새로운 인스턴스를 생성하는 일을 한다. Object 클래스에 정의된 clone()은 단순히 인스턴스변수의 값만 복사하기 때문에 참조타입의 인스턴스 변수가 있
는 클래스는 완전한 인스턴스 복제가 이루어지지 않는다. 
```java
package langEx;
class Point implements Cloneable{
	int x,y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return x + " " + y;
	}
	@Override
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
public class CloneEx1 {
	public static void main(String[] args) {
		Point a = new Point(3, 5);
		Point copy = (Point) a.clone();
		System.out.println(a);
		System.out.println(copy);
		copy.x = 5;
		System.out.println(a);
		System.out.println(copy);
		
	}
}
```
clone을 사용하려면 먼저 복제할 클래스가 cloneable인터페이스를 구현해야하고, clone()을 오버라이딩하면서 접근 제어자를 protected에서 public으로 변경한다. 그래야만 상속 관계
가 없는 다른 클래스에서 clone()을 호출 할 수 있다.

**공변타입 변환**
```java
public Point clone() { //반환타입을 Object 타입에서 Point로 변환
  	Object obj = null;
	try {
		obj = super.clone();
	} catch (CloneNotSupportedException e) {}
	return (Point)obj; //Ponit타입으로 형변환
}```
이기능은 오버라이딩 할 때 조상 메서드의 반환타입을 자손 클래스의 타입으로 변경을 허용하는 것이다.!!! 조상의 타입이 아닌 실제로 반환되는 자손 객체의 타입으로 반환할 수 
있어서 번거로운 형변환이 줄어든다는 장점이 있다.<br>
point p = (Point)original.clone();  --------->  Point p = original.clone();
<br>
```java
import java.util.Arrays;

public class CloneEx2 {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        int[] copy = arr.clone();
        copy[0] = 6;

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(copy));
    }
}
```
clone을 이용해서 배열을 복사하는 예제이다. 배열도 객체이기 때문에 Object클래스를 상속받으며 동시에 Cloneable인터페이스와 Serializable인터페이스가 구현되어 있다.
배열 뿐 아니라 util패키지에 Vector, ArrayList 등등 클래스들이 이러한 방식으로 복제가 가능하다.
```java
ArrayList list2 = (ArrayList)list.clone()
```

