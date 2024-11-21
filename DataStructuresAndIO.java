
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class DataStructuresAndIO {

    // Stack implementation
    public static class StackExample {

        public static void main(String[] args) {
            Stack<Integer> stack = new Stack<>();

            // Push operation: Add elements to the top of the stack
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
            stack.push(6);
            //stack.push(7);
            stack.push(8);
            stack.push(9);
            //stack.push(10);
            stack.push(11);
            //stack.push(12);

            // Pop operation: Remove and return the top element of the stack
            stack.pop();
            stack.pop();
            

            // Peek operation: Return the top element without removing it
            int topWithoutRemoval = stack.peek(); // Returns 2
            int topElement = stack.pop(); 
            System.out.println("Top element after pop: " + topElement);
            System.out.println("Current top element (peek): " + topWithoutRemoval);
        }
    }

    // Queue implementation using two stacks
    public static class MyQueue {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        // Enqueue operation: Add an element to the end of the queue
        public void enqueue(int x) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(x);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        // Dequeue operation: Remove and return the front element of the queue
        public int dequeue() {
            if (stack1.isEmpty()) {
                return -1; // Or throw an exception if preferred
            }
            return stack1.pop();
        }
    }

    // Error handling example with try-catch
    public static class ErrorHandlingExample {

        public static void main(String[] args) {
            try {
                // Code that might throw an exception
                //int result = 10 / 0;  // This will throw ArithmeticException
                int[] arr = new int[5];
                //arr[10] = 50; // This will throw ArrayIndexOutOfBoundsException
            } catch (ArithmeticException e) {
                // Handle arithmetic errors, such as division by zero
                System.out.println("Arithmetic error: " + e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                // Handle array index errors, such as accessing an invalid index
                System.out.println("Array index error: " + e.getMessage());
            } finally {
                // Code that always executes, regardless of exceptions
                System.out.println("This always executes");
            }
        }
    }

    // File writing example using FileWriter
    public static class FileWriteExample {

        public static void main(String[] args) {
            String fileName = "output.txt";
            try (FileWriter writer = new FileWriter(fileName)) {
                // Write text to the file
                writer.write("Hello, World!");
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                // Handle potential I/O errors during writing
                System.out.println("An error occurred while writing to the file.");
                e.printStackTrace();
            }
        }
    }

    // File reading example using BufferedReader
    public static class FileReadExample {

        public static void main(String[] args) {
            String fileName = "input.txt";
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Read and print each line from the file
                    System.out.println(line);
                }
            } catch (IOException e) {
                // Handle potential I/O errors during reading
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Uncomment one of the following lines to run a specific example

        StackExample.main(args);         // Run Stack example
        MyQueue queue = new MyQueue();   // Create and use queue instance here if needed
        ErrorHandlingExample.main(args);  // Run Error Handling example
        FileWriteExample.main(args);      // Run File Writing example
        FileReadExample.main(args);       // Run File Reading example
    }
}
