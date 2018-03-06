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
            String choice = scanner.nextLine();

            try {
                stack.push(Integer.parseInt(choice));
            } catch(Exception ex) {
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
                    case "d":
                        debug = !debug;
                        break;
                }
            }

            if (debug) {
                System.out.println("Full stack " + stack.toString());
                System.out.println("Stack size " + stack.size());
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

    private static void top() {
        if (stack.size() > 0) {
            System.out.println(stack.top());
        }
    }
}
