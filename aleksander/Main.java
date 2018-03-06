package aleksander;

import java.util.Collections;
import java.util.Scanner;

// The LinkedStack implementation is fully functional. The ArrayStack has some minor bugs.

public class Main {
    private static Stack<Integer> stack = new LinkedStack<>();;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = true;

        while (quit) {
            String choice = scanner.nextLine();

            try {
                stack.push(Integer.parseInt(choice));
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
        }

        scanner.close();
    }

    private static void add() {
        if (stack.validate()) {
            return;
        }

        int firstNumber = pop(stack);
        int secondNumber = pop(stack);

        stack.push(firstNumber + secondNumber);
    }

    private static void subtract() {
        if (stack.validate()) {
            return;
        }

        int firstNumber = pop(stack);
        int secondNumber = pop(stack);

        stack.push(firstNumber - secondNumber);
    }

    private static void multiply() {
        if (stack.validate()) {
            return;
        }

        int firstNumber = pop(stack);
        int secondNumber = pop(stack);

        stack.push(firstNumber * secondNumber);
    }

    private static void divide() {
        if (stack.validate()) {
            return;
        }

        int firstNumber = pop(stack);
        int secondNumber = pop(stack);

        stack.push(firstNumber / secondNumber);
    }

    private static int pop(Stack<Integer> stack) {
        int top = stack.top();
        stack.pop();
        return top;
    }

    private static void swap() {
        if (stack.validate()) {
            return;
        }

        int firstNumber = pop(stack);
        int secondNumber = pop(stack);

        stack.push(firstNumber);
        stack.push(secondNumber);
    }

    private static void top() {
        if (stack.size() > 0) {
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
        if (stack.validate()) {
            return;
        }

        int topStack = pop(stack);
        Stack<Integer> stackCopy = new LinkedStack<>();

        while (!stack.isEmpty()) {
            stackCopy.push(pop(stack));
        }

        stack.push(topStack);

        while (!stackCopy.isEmpty()) {
            stack.push(pop(stackCopy));
        }
    }
}
