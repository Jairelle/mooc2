
import java.util.ArrayList;
import java.util.List;

public class mainProgram {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");

        System.out.println(returnSize(list));
    }

    public static int returnSize(List<String> list) {
        return list.size();
    }
}
