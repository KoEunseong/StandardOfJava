Chapter9 java.lang 패키지와 유용한 클래스
======================

### 2. 유용한 클래스
***
**2.1 java.util.Object**: Object클래스의 보조 클래스 느낌  
-모든 메서드가 static  
-객체의 비교나 널체크에 유용하다.  
```java
static boolean isNull(Object obj) //null이면 true 반환
static boolean nonNull(Object obj) //null이 아니면 true 반환
```
-requireNonNull()은 해당 객체가 널이 아니어하는 경우, 널이면 예외를 발생시킨다. 매개변수의 유효성 검사 간단히 할 수 있음.  
-compare() 메서드: 두 비교 대상이 같으면 0,크면 양수,작으면 음수 반환  
-equals() : Object클래스에 정의된 equals가 있는데 왜 여기 또? -> 널검사 안해도 됨  
![image](https://user-images.githubusercontent.com/98599867/160781217-d2bdba4c-80c5-4fc3-a70c-430bf710a8c5.png)<br><br>
-deapEquals(): 이 메서드는 객체를 재귀적으로 비교하기 때문에 다차원 배열도 비교 가능<br>
![image](https://user-images.githubusercontent.com/98599867/160781548-c3f554b4-7d5b-41c4-985a-683f48691a72.png)<br><br>
-toString(),equals() 내부적으로 널검사한다는걸 제외하고는 같음  
-hashCode() : 널검사후에 Object클래스의 hashCode()를 호출, 널일 때는 0을 반환
<br><br>

**2.2 java.util.Random 클래스**  
```java
int num = (int)(Math.random() * 6) + 1; //1~6
int num2 = new Random().nextInt(6) + 1; //nextInt(6)은 0~6 사이 정수를 반환
```
Math.random()과 Random()의 가장 큰 차이점은, 종자값을 설정할수 있다는 것. 생성자 Random()은 System.currentTimeMillis()를 종자값으로 하기ㅣ 때문에 실행할 때마다 얻는
난수가 달라진다.
```java
import java.util.*;

class RandomEx3 {
	public static void main(String[] args) {
		for(int i=0; i < 10;i++)
			System.out.print(getRand(5, 10)+",");
		System.out.println();

		int[] result = fillRand(new int[10], new int[]{ 2, 3, 7, 5});

		System.out.println(Arrays.toString(result));
	}

	public static int[] fillRand(int[] arr, int from, int to) { //배열 arr을 from과 to범위의 값들로 채워서 반환한다.
		for(int i=0; i < arr.length; i++) {
			arr[i] = getRand(from, to);
		}

		return arr;
	}

	public static int[] fillRand(int[] arr, int[] data) { //배열 arr을 배열 data에 있는 값들로 채워서 반환한다.
		for(int i=0; i < arr.length; i++) {
			arr[i] = data[getRand(0, data.length-1)];
		}

		return arr;
	}

	public static int getRand(int from, int to) { //from과 to 범위의 정수 값을 반환한다.from과 to 모두 범위에 포함
		return (int)(Math.random() * (Math.abs(to-from)+1)) + Math.min(from, to);
	}
}
```
괜찮아 보이는 메서드 정리<br><br>

**2.3 정규식 - java.util.regex 패키지**
정규식이라나 텍스트 데이터 중에서 원하는 조건과 일치하는 문자열을 찾아 내기 위해 사용하는 것으로 미리 정의된 기호와 문자를 이용해서 작성한 문자열을 말한다.
정규식을 이용하면 많은 양의 텍스트 파일 중에서 원하는 데이터를 손쉽게 뽑아 낼수도 있고 입력된 데이터가 형식에 맞는지 체크 할 수도 있다. 
```java
import java.util.regex.*;	// Pattern과 Matcher가 속한 패키지

class RegularEx1 {
	public static void main(String[] args) 
	{
		String[] data = {"bat", "baby", "bonus",
				    "cA","ca", "co", "c.", "c0", "car","combat","count",
				    "date", "disc"};		
		Pattern p = Pattern.compile("c[a-z]*");	// c로 시작하는 소문자영단어

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");
		}
	}
}
```
실행결과 : ca,co,car,combat,count,  
1. 정규식을 매개 변수로 Pattern 클래스의 static메서드인 Pattern complie(String regex)를 호출하여 pattern 인스턴스를 얻는다.  
 Pattern p = new Pattern.compile("c[a-z]*");
2. 정규식으로 비교할 대상을 매개변수로 Pattern클래스의 Matcher matcher(CharSequence input)를 호출해서 Matcher인스턴스를 얻는다.  
 Matcher m = p.matcher(data[i]);
3.Matcher인스턴스에서 matches를 호출해 정규식에 부합하는지 확인
if(m.matches())    
```java
import java.util.regex.*;	

class RegularEx2 {
	public static void main(String[] args) {
		String[] data = {"bat", "baby", "bonus", "c", "cA",
				        "ca", "co", "c.", "c0", "c#",
					"car","combat","count", "date", "disc"
						};		
		String[] pattern = {".*","c[a-z]*","c[a-z]", "c[a-zA-Z]",
                                          "c[a-zA-Z0-9]","c.","c.*","c\\.","c\\w",
                                          "c\\d","c.*t", "[b|c].*", ".*a.*", ".*a.+",
                                          "[b|c].{2}"
                                         };

		for(int x=0; x < pattern.length; x++) {
			Pattern p = Pattern.compile(pattern[x]);
			System.out.print("Pattern : " + pattern[x] + "  °á°ú: ");
			for(int i=0; i < data.length; i++) {
				Matcher m = p.matcher(data[i]);
				if(m.matches())
					System.out.print(data[i] + ",");
			}
			System.out.println();
		}
	} // public static void main(String[] args) 
}
```
![image](https://user-images.githubusercontent.com/98599867/160801468-5cbbb13d-2fcb-42a9-9fd9-590173fbe387.png)  
실행결과는 위와 같고 위 예제에 대한 자세한 설명은 p507책을 참고하자.

자바 정규식 [here](https://hamait.tistory.com/342)
```java
import java.util.regex.*;	

class RegularEx3{
	public static void main(String[] args) {
		String source  = "HP:011-1111-1111, HOME:02-999-9999 ";
		String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";

		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);

		int i=0;

		while(m.find()) {
			System.out.println( ++i + ": " + m.group() + " -> "+ m.group(1) +", "+ m.group(2)+", "+ m.group(3));		
		}
	} 
}
```
정규식의 일부를 괄호로 나누어 그룹화 할 수 있다. 그리고 그룹화된 부분은 group(int i)를 이용해 나누어 얻을 수 있다.  
find()는 주어진 소스 내에서 패턴과 일치하는 부분을 찾아내면 true, 못찾으면 false  
find를 호출해서 패턴과 일치하는 부분을 찾아낸 다음, 다시 find를 호출하면 이전에 발견한 패턴과 일치하는 부분의 다음부터 다시 패턴매칭을 시작한다. <br><br>

**2.4 java.util.Scanner 클래스**
화면, 파일 문자열과 같은 입력 소스로 부터 문자 데이터를 읽어오는데 도움을 주는 클래스.
```java
import java.util.*; 

class ScannerEx1 { 
	public static void main(String[] args) { 
		Scanner s = new Scanner(System.in);
		String[] argArr = null;

		while(true) { 
			String prompt = ">>"; 
			System.out.print(prompt); 

			// 화면으로부터 라인단위로 입력받는다. 
			String input = s.nextLine(); 

			input = input.trim();        // 입력받은 값에서 불필요한 앞뒤 공백을 제거한다. 
			argArr = input.split(" +");  // 입력받은 내용을 공백을 구분자로 자른다. 

			String command = argArr[0].trim(); 

			if("".equals(command)) continue; 

			// 명령어를 소문자로 바꾼다.
			command = command.toLowerCase();
  
 			// q 또는 Q를 입력하면 실행종료한다.
			if(command.equals("q")) { 
				System.exit(0); 
			} else { 
				for(int i=0; i < argArr.length;i++) 
					System.out.println(argArr[i]); 
			} 
		} // while(true) 
	} // main 
}
```
**2.5 java.util.StringTokenizer클래스**
StringToekenizer는 긴 문자열을 지정된 구분자를 기준으로 토큰이라는 여러 개의 문자열로 잘라내는데 사용된다.
```java
import java.util.*; 

class StringTokenizerEx1 { 
	public static void main(String[] args){ 
		String source = "100,200,300,400";
		StringTokenizer st = new StringTokenizer(source, ",");

		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
	} 
}
```
**2.6 java.math.BigInteger클래스**
정수형으로 표현할 수 있는 값의 한계값보다 더 큰 값을 다뤄야 할 때 사용하는 클래스 BigIntger
```java
import java.math.*;

class BigIntegerEx {
	public static void main(String[] args) throws Exception {
		BigInteger big =  BigInteger.ONE;

		for(int i=1; i<100;i++) { // 1!ºÎÅÍ 99!±îÁö Ãâ·Â
			System.out.printf("%d!=%s%n", i, calcFactorial(i));
			Thread.sleep(300); // 0.3ÃÊÀÇ Áö¿¬
		}
	}

	static String calcFactorial(int n) {
		return factorial(BigInteger.valueOf(n)).toString();
	}

	static BigInteger factorial(BigInteger n) {
		if(n.equals(BigInteger.ZERO)) {
			return BigInteger.ONE;
		} else {  // return n * factorial(n-1);
			return n.multiply(factorial(n.subtract진 (BigInteger.ONE)));
		}
	}
}
```
**2.7 java.util.BigDecimal 클래스**  
double타입으로 표현할수 있는 값은 상당히 범위가 넓지만, 정밀도가 최대 13자리 밖에 되지 않고 실수형의 특성상 오차를 피할수 없다. 이 클래스는 실수형과 달리 정수형을 이용해서
실수를 표현한다. 오차가 없는 2진 정수로 변환하여 다루는 것이다.
