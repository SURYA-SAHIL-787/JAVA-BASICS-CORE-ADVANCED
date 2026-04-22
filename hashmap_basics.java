import java.util.HashMap;

public class hashmap_basics {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        // Insert
        map.put("apple", 10);
        map.put("banana", 20);

        // Access
        System.out.println(map.get("apple")); // 10

        // Check
        System.out.println(map.containsKey("banana")); // true

        // Remove
        map.remove("apple");

        System.out.println(map);
    }
}
