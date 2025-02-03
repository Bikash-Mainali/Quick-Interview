package java8.StreamAPI.concat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/21/22
 */
public class ConcatCharacterStream {

    public static void main(String[] args) {

        Stream<Character> combined = Stream.concat(characterStream("Hello"), characterStream("World"));
        combined.forEach(System.out::print);
        //Stream.concat(Stream.of("Hello").limit(1), Stream.of("World").limit(1)).forEach(System.out::print);
    }

    public static Stream<Character> characterStream(String s){
        List<Character> characterList = new ArrayList<>();
        for(char c : s.toCharArray()){
            characterList.add(c);
        }
        return characterList.stream();
    }
}


