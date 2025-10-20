import java.util.Scanner;
public class calculator {
    class addition {
        public int add(int a, int b) {
            return a + b;
        }
    }
    class subtraction {
        public int subtract(int a, int b) {
            return a - b;
        }
    }
    class multiplication {
        public int multiply(int a, int b) {
            return a * b;
        }
    }
    class division {
        public int divide(int a, int b) {
            if (b == 0) {
                throw new IllegalArgumentException("Division by zero is not allowed.");
            }
            return a / b;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        calculator calc = new calculator();
        char again;
        do {
            System.out.print("Enter first number: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid integer.");
                scanner.next(); // consume invalid token
            }
            int num1 = scanner.nextInt();

            System.out.print("Enter second number: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid integer.");
                scanner.next();
            }
            int num2 = scanner.nextInt();

            System.out.print("Enter the operator (+ - * /): ");
            char operator = scanner.next().charAt(0);

            if (operator == '+') {
                addition addObj = calc.new addition();
                int result = addObj.add(num1, num2);
                System.out.println("Result: " + result);
            } else if (operator == '-') {
                subtraction subObj = calc.new subtraction();
                int result = subObj.subtract(num1, num2);
                System.out.println("Result: " + result);
            } else if (operator == '*') {
                multiplication mulObj = calc.new multiplication();
                int result = mulObj.multiply(num1, num2);
                System.out.println("Result: " + result);
            } else if (operator == '/') {
                division divObj = calc.new division();
                try {
                    int result = divObj.divide(num1, num2);
                    System.out.println("Result: " + result);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Invalid operator");
            }

            System.out.print("Perform another calculation? (y/n): ");
            String resp = scanner.next();
            again = resp.length() > 0 ? Character.toLowerCase(resp.charAt(0)) : 'n';
        } while (again == 'y');

        System.out.println("Goodbye!");
        scanner.close();
    }
}
