import java.util.Scanner;

public class Evaluate {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LLStack<Double> nums = new LLStack<>();
        LLStack<String> ops = new LLStack<>();

        // (5+(7*3))
        // nums 3, 7, 5
        // ops (, +, (, *
        // go back at )
        while (scan.hasNext()) {
            String line = scan.next();
            String[] spl = line.split(" ");

            for (String s : spl) {
                if (s.equals(")")) {
                    System.out.println(ops);
                    System.out.println(nums);
                    System.out.println("______");

                    double num2 = nums.pop();
                    double num1 = nums.pop();
                    String op = ops.pop();

                    if (op.equals("(")) {

                        op = ops.pop();
                    }
                    if (op.equals("+")) {
                        nums.push(num1 + num2);
                    } else if (op.equals("-")) {
                        nums.push(num1 - num2);
                    } else if (op.equals("/")) {
                        nums.push(num1 / num2);
                    } else if (op.equals("*")) {
                        nums.push(num1 * num2);
                    } else {
                        throw new Error(op);
                    }
                    System.out.println(ops);
                    System.out.println(nums);
                    op = ops.pop(); // maybe problmes later
                    while (ops.iterator().hasNext() && op.equals("(")) {
                        op = ops.pop();
                    }
                    System.out.println(ops);
                    System.out.println(nums);
                    continue;
                }
                if (s.equals("/") || s.equals("*") ||
                        s.equals("+") || s.equals("-") || s.equals("(")) {
                    ops.push(s);
                } else {
                    nums.push(Double.valueOf(s));
                }
            }

        }

        scan.close();
    }
}
