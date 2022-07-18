package chapter12.annotation;

import java.lang.annotation.*;

@Deprecated
@SuppressWarnings("1111") //유효하지 않은 애너테이션은 무시된다.
@TestInfo(count = 2,testedBy = "aaa",testDate = @DateType(yymmdd = "171121",hhmmss = "181130"))
public class AnnotationEx {
    public static void main(String[] args) {
        Class<AnnotationEx> cls = AnnotationEx.class; //AnnotationEx의 객체를 얻는다.
        TestInfo anno = (TestInfo)cls.getAnnotation(TestInfo.class);
        System.out.println(TestInfo.class);
        System.out.println(anno.testedBy());
        System.out.println(anno.testDate().yymmdd());
        System.out.println(anno.testDate().hhmmss());
        System.out.println();
        Annotation[] annotations = cls.getAnnotations();
        for(Annotation a :annotations){
            System.out.println(a);
        }


    }

}
@Retention(RetentionPolicy.RUNTIME)//실행시에 사용가능하도록 지정
@interface TestInfo {
    int count() default 1;
    String testedBy();
    String[] testTools() default "JUNIT";
    TestType testType() default TestType.FIRST;
    DateType testDate();
}
enum TestType{
    FIRST, FINAL
}
@Retention(RetentionPolicy.RUNTIME)//실행시에 사용가능하도록 지정
@interface DateType {
    String yymmdd();
    String hhmmss();

}