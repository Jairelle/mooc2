
import java.util.HashMap;
import java.util.Map;

public class MainProgram {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("one", "yksi");
        map.put("two", "kaksi");

        System.out.println(returnSize(map));
    }

    public static int returnSize(Map<String, String> map) {
        return map.size();
    }
}
