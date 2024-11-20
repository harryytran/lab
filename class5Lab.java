import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

// A class to represent a queue
class Queue {
    int front, rear, size;
    int capacity;
    String array[];
 
    public Queue(int capacity)
    {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new String[this.capacity];
    }
 
    // Queue is full when size becomes
    // equal to the capacity
    boolean isFull(Queue queue)
    {
        return (queue.size == queue.capacity);
    }
 
    // Queue is empty when size is 0
    boolean isEmpty(Queue queue)
    {
        return (queue.size == 0);
    }
 
    // Method to add an item to the queue.
    // It changes rear and size
    void enqueue(String item)
    {
        if (isFull(this))
            return;
        this.rear = (this.rear + 1)
                    % this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;
    }
 
    // Method to remove an item from queue.
    // It changes front and size
    String dequeue()
    {
        if (isEmpty(this))
            return null;
 
        String item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        return item;
    }
 
    // Method to get front of queue
    String front()
    {
        if (isEmpty(this))
            return null;
 
        return this.array[this.front];
    }
 
    // Method to get rear of queue
    String rear()
    {
        if (isEmpty(this))
            return null;
 
        return this.array[this.rear];
    }
}


public class class5Lab {
    public static void main(String[] args) throws Exception {
        
        // Specify the path to your text file
        String filePath = "reversePoem.txt";

        // Create a stack to store the words
        Stack<String> lineStack = new Stack<>();
        Queue lineQueue = new Queue(1000);
        int maxLineLength = 0;

        try {
            // Open the file for reading using the BufferedReader
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            // Read the single line from the file
            String line1 = reader.readLine();

            // Replace every occurence of "Zz" with the empty string, to get rid of it.
            String line2 = line1.replace("Zz", "");

            // Replace every occurence of "yY" with a space, to establish words.
            String line3 = line2.replace("yY", " ");

            // Split the line by the characters "XX" to get each line of the poem in an array
            String[] lines = line3.split("XX");

            
            for (String line : lines) {
                lineStack.push(line);
                lineQueue.enqueue(line);
                if (line.length() > maxLineLength) {
                    maxLineLength = line.length();
                }
            }

            // close the BufferedReader
            reader.close();

        } catch (IOException e) {
            // Handle exceptions (e.g., file not found, IO error)
            e.printStackTrace();
        }

        // Specify the path to the output text file. This assumes one has already been made.
        String outputPath = "reversePoemSolved.txt";

        try {
            // Create a BufferedWriter to write to the text file
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));

            while(!lineStack.isEmpty()) {
                String poppedline= lineStack.pop();
                writer.write(poppedline);
                int padding = maxLineLength - poppedline.length();
                for (int i = 0; i < padding; i++) {
                    writer.write(" ");
                }
                writer.write("\t");
                String dequeuedline = lineQueue.dequeue();
                writer.write(dequeuedline);
                writer.newLine();
            }

            // Close the BufferedWriter
            writer.close();

        } catch (IOException e) {
            // Handle exceptions (e.g., file not found, IO error)
            e.printStackTrace();
        }




        
        System.out.println("Hello, World!");
    }
}