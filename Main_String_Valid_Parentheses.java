import java.util.*;
public class Main_String_Valid_Parentheses { 
    static boolean isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); 
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (st.isEmpty()) return false;
                char top = st.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }  
        return st.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);     
        System.out.print("Enter a string with brackets: ");
        String s = sc.nextLine();
        if (isBalanced(s)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
        sc.close();
    }
}