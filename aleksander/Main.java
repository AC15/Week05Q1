package aleksander;

import java.util.Scanner;

public class Main {
    private static StackFactory<Integer> stackFactory = new StackFactory<>();
    private static Stack<Integer> stack = stackFactory.empty();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = true;

        while (quit) {
            String choice = scanner.nextLine();

            try {
                stack = stackFactory.push(Integer.parseInt(choice), stack);
            } catch (Exception ex) {
                switch (choice) {
                    case "q":
                        quit = false;
                        break;
                    case "+":
                        add();
                        break;
                    case "-":
                        subtract();
                        break;
                    case "*":
                        multiply();
                        break;
                    case "/":
                        divide();
                        break;
                    case "s":
                        swap();
                        break;
                    case "t":
                        top();
                        break;
                    case "p":
                        print();
                        break;
                    case "r":
                        rotate();
                        break;
                }
            }

            System.out.println("Depth = " + stack.depth());
            System.out.println("Top = " + stack.top());
        }

        scanner.close();
    }

    private static void add() {
        int firstNumber = pop();
        int secondNumber = pop();

        stack = stackFactory.push(firstNumber + secondNumber, stack);
    }

    private static void subtract() {
        int firstNumber = pop();
        int secondNumber = pop();

        stack = stackFactory.push(firstNumber - secondNumber, stack);
    }

    private static void multiply() {
        int firstNumber = pop();
        int secondNumber = pop();

        stack = stackFactory.push(firstNumber * secondNumber, stack);
    }

    private static void divide() {
        int firstNumber = pop();
        int secondNumber = pop();

        stack = stackFactory.push(firstNumber / secondNumber, stack);
    }

    private static int pop() {
        int top = stack.top();
        stack = stack.pop();
        return top;
    }

    private static void swap() {
        int firstNumber = pop();
        int secondNumber = pop();

        stack = stackFactory.push(firstNumber, stack);
        stack = stackFactory.push(secondNumber, stack);
    }

    private static void top() {
        if (stack.depth() > 0) {
            System.out.println(stack.top());
        }
    }

    private static void print() {
        System.out.println(stack.toString());
    }

    /**
     * Rotates the stack. Number on top moves to the bottom,
     * and all the other number move up one place.
     */
    private static void rotate() {
        int topStack = pop();
        Stack<Integer> stackCopy = stackFactory.empty();

        while (!stack.isEmpty()) {
            stackCopy = stackFactory.push(pop(), stackCopy);
        }

        stack = stackFactory.push(topStack, stack);

        while (!stackCopy.isEmpty()) {
            int top = stackCopy.top();
            stackCopy = stackCopy.pop();
            stack = stackFactory.push(top, stack);
        }
    }
}
