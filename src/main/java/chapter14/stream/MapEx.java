package chapter14.stream;

import java.io.File;
import java.util.stream.Stream;

public class MapEx {
    public static void main(String[] args) {
        File[] fArray = {new File("고은성.java"),new File("고은성"),new File("고은성.txt"),new File("고은성.jar"),
                new File("고은성.bat"),new File("고은성.jpg")};
        Stream<File> fileStream = Stream.of(fArray);
        fileStream.map(File::getName).filter(s -> s.indexOf('.') !=-1 )
                .peek(s->System.out.printf("%s \n",s))
                .map(s -> s.substring(s.indexOf('.')+ 1))
                .map(String::toUpperCase)
                .forEach(System.out::println);





    }
}
