import java.util.Arrays;
import java.util.List;
class task {
    public static void main(String[] args) {
        List<String> listStrings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        listStrings.stream()
                   .filter(s -> !s.isEmpty())
                   .forEach(System.out::println);
    }
}