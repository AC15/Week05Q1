package aleksander;

import java.util.Scanner;

// The LinkedStack implementation is fully functional. The ArrayStack has some minor bugs.

public class Main {
    private static Stack<Integer> stack;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1: ArrayStack\n" +
                "2: LinkedStack");
        int choiceOfStack = scanner.nextInt();
        stack = (choiceOfStack == 1) ? new ArrayStack<>() : new LinkedStack<>();

        boolean debug = false;
        boolean quit = true;

        while (quit) {
            System.out.println("0: Close\n" +
                    "1: Push Number\n" +
                    "2: Add\n" +
                    "3: Subtract\n" +
                    "4: Multiply\n" +
                    "5: Divide\n" +
                    "6: Swap\n" +
                    "7: Debug Mode");

            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    quit = false;
                    break;
                case 1:
                    System.out.print("Input number: ");
                    int input = scanner.nextInt();
                    stack.push(input);
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    subtract();
                    break;
                case 4:
                    multiply();
                    break;
                case 5:
                    divide();
                    break;
                case 6:
                    swap();
                    break;
                case 7:
                    debug = !debug;
                    break;
            }

            if (debug) {
                if (stack.size() > 1) {
                    System.out.println(stack.top());
                }

                System.out.println(stack.toString());
                System.out.println(stack.size());
            }
        }

        scanner.close();
    }

    private static void add() {
        if (stack.validate()) {
            return;
        }

        int firstNumber = pop();
        int secondNumber = pop();

        stack.push(firstNumber + secondNumber);
    }

    private static void subtract() {
        if (stack.validate()) {
            return;
        }

        int firstNumber = pop();
        int secondNumber = pop();

        stack.push(firstNumber - secondNumber);
    }

    private static void multiply() {
        if (stack.validate()) {
            return;
        }

        int firstNumber = pop();
        int secondNumber = pop();

        stack.push(firstNumber * secondNumber);
    }

    private static void divide() {
        if (stack.validate()) {
            return;
        }

        int firstNumber = pop();
        int secondNumber = pop();

        stack.push(firstNumber / secondNumber);
    }

    private static int pop() {
        int top = stack.top();
        stack.pop();
        return top;
    }

    private static void swap() {
        if (stack.validate()) {
            return;
        }

        int firstNumber = pop();
        int secondNumber = pop();

        stack.push(firstNumber);
        stack.push(secondNumber);
    }
}
