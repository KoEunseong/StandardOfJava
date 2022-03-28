Chapter9 java.lang 패키지와 유용한 클래스
======================

### 1.2 String 클래스
***
기존의 다른 언어에서는 문자열을 char형의 배열로 다루었으나 자바에서는 문자열을 위한 클래스 String을 제공한다. String 클래스는 문자열을 저장하고 이를 다루는데 필요한 메서드를
함께 제공한다. <br>

**변경 불가능한(immutable) 클래스**  
String 클래스에는 문자열을 저장하기 위해서 문자혈 배열 참조변수(char[]) value를 인스턴스 변수로 정의해놓고 있다. 인스턴스 생성시 문자열은 value에 문자형 배열로 저장되는 것
한번 생성된 String 인스턴스가 갖고 있는 문자열은 읽어 올수만 있고 변경할 수는 없다. 
```java
String a = "a";
String b = "b";
a = a+b;
```
예를 들어 이런식으로 문자열을 결합하는 경우 문자열이 바뀌는 것이 아니라 새로운 문자열이 담긴 인스턴스가 생성 되는 것이다.  
문자열을 다루는 작업이 많이 필요한 경우에는 StringBuffer클래스를 사용하는 것이 좋다.<br>

**문자열의 비교**
```java
String str1 = "abc";
String str2 = "abc"
String str3 = new String("abc");
String str4 = new String("abc");

```
![](https://media.vlpt.us/images/0_sujeong/post/1cd096a1-2c57-493f-98b1-9fd483046473/image.png) <br>
String 클래스의 생성자를 이용한 경우에는 new 연산자에 의해서 항상 새로운 String 인스턴스가 생성, but 문자열 리터럴은 이미 존재하는 것을 재사용하는 것이다.  
equals()를 사용했을 때는 모두 true(문자열 내용을 비교) , == 를 사용했을 때는 결과가 다름(인스턴스 주소 비교)
<br><br>
**문자열 리터럴**
```java
String str1 = "abc";
String str2 = "abc"
String str3 = "abc"
```
위에 예제를 실행하면 "abc"를 담고 있는 String인스턴스가 하나 생성된 후 str 123모두 이 인스턴스를 참조하게 된다.(리터럴 들이 constant pool 상수 저장소에 저장)<br><br>
**빈 문자열**  
길이가 0인 배열 존재 가능 -> String s = ""; : 내부에 new char[0]과 같이 길이가 0인 char형 배열을 저장하고 있는 것.(char c ='';은 안됨)
<br><br>
**Stirng클래스의 생성자와 메서드**  
책에 보면 자주 사용될만한 생성자와 메서드에 대해 자세히 설명해 놨다. 필요할 때 구글링 해서 써야겠다.  
Click [자바메서드 설명](http://www.dreamy.pe.kr/zbxe/CodeClip/3766960)  
Click [스트링버퍼설명](http://www.tcpschool.com/java/java_api_stringBuffer)  

**join()과 StringJoiner**
```java
import java.util.StringJoiner;

class StringEx4 {
	public static void main(String[] args) {
		String animals = "dog,cat,bear";
		String[] arr   = animals.split(",");

		System.out.println(String.join("-", arr));

		StringJoiner sj = new StringJoiner("/","[","]");
		for(String s : arr)
			sj.add(s);

		System.out.println(sj.toString());
	}
}
```
![qq](https://user-images.githubusercontent.com/98599867/160453123-6cbdf946-061e-4ac9-bf4d-d6c87a78e88c.JPG)<br>
join : 여러 문자열 사이에 구분자를 넣어서 결합
<br><br>
**문자 인코딩 변환**
getByte(String charsetName)을 사용하면 문자열의 문자 인코딩을 다른 인코딩으로 변경할 수 있다.

```java
byte[] b = "가".getBytes("UTF-8"); //문자열을 UTF-8로 변환
String s = new String(b,"UTF-8"); //byte배열을 문자열로 변환
```
**String.format()**
printf()와 사용법이 유사  
**기본형 값 -> Strinig , String -> 기본형 값**
```java
int i = 100;
String str1 = i + ""; //문자열로 변환
String str2 = String.valueOf(i);
int i = Integer.parseInt("100");//정수형으로 변환
int i2 = Integer.valueOf("100");

문자열애 공백 또는 문자가 포함되있는 경우 예외 발생할 수 있으므로 주의 해야한다. 문자열 양끝의 공백 제거해주는 trim()을 같이 사용하면 좋다.  
int v = Integer.parseInt(" 123 ".trim());
