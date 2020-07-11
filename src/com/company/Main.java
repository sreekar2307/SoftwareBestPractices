package com.company;
import java.io.*;
import java.util.*;

import static java.lang.String.join;

public class Main{;

    static Node head = null;
    static boolean flag =true;
    public static void missing4(int[] arr)
    {
        final int N = arr.length;

        int[] helper = new int[4];
        int[] ans = new int[4];
        Arrays.stream(arr).forEach(e->{
            if(e/N >=1 ){
                helper[e%(N+4)] = -1*e; // negative sign indicates presence
            }
            else{
                arr[e-1]*=-1;
            }
        });
        for (int i = 0,k=0; i <N+4; i++) {
            if(i<N && arr[i]>0){
                ans[k] = arr[i];
                k++;
            }
            else if(helper[i]>0){
                ans[k] = i-N;
                k++;
            }
        }

    }

    static boolean reverse(Node curr){
        if(curr!=null){
            char temp = curr.value;
            curr = curr.next;
            boolean response = reverse(curr);
            if(temp == head.value){
                head = head.next;
                return response;
            }
            else {
               return false;
            }
        }
        return true;
    }

    static class ReadIO {
        private final BufferedReader br;
        StringTokenizer stringTokenizer;

        public ReadIO(InputStream inputStream) {
            this.br = new BufferedReader(new InputStreamReader(inputStream));
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String next() throws IOException {
            if (stringTokenizer == null || !stringTokenizer.hasMoreElements())
                stringTokenizer = new StringTokenizer(br.readLine());
            return stringTokenizer.nextToken();
        }

        public String readLine() throws IOException {
            return br.readLine();
        }

        public void closePipe() throws IOException {
            br.close();
        }
    }

    static class WriteIO {
        private final BufferedWriter bw;

        public WriteIO(OutputStream outputStream) {
            this.bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        }

        public void writeLine(CharSequence string) throws IOException {
            writeEmptyLine();
            bw.write(string.toString());
            bw.flush();
        }

        public void writeLine(int value) throws IOException {
            writeLine(Integer.toString(value));
        }

        public void writeLine(long value) throws IOException {
            writeLine(Long.toString(value));
        }

        public void writeLine(double value) throws IOException {
            writeLine(Double.toString(value));
        }

        public void writeArray(String[] strings, String delimiter) throws IOException {
            writeLine(join(delimiter, strings));
        }

        public void write(String string) throws IOException {
            bw.write(string);
            bw.flush();
        }

        public void write(int value) throws IOException {
            write(Integer.toString(value));
        }

        public void write(long value) throws IOException {
            write(Long.toString(value));
        }

        public void write(double value) throws IOException {
            write(Double.toString(value));
        }


        private void writeEmptyLine() throws IOException {
            bw.write("\n");
            bw.flush();
        }

        public void closePipe() throws IOException {
            bw.close();
        }
    }
}

class Stack<T>{
    private final List<T> elements;
    private int topIndex;
    private static final Exception STACK_EMPTY = new Exception("Stack Empty");

    public Stack() {
        elements = new ArrayList<T>();
        topIndex = -1;
    }

    public synchronized void push(T element) {
        elements.add(element);
        ++topIndex;
    }

    public synchronized T pop() throws Exception {
        if (elements.size() == 0) {
            throw STACK_EMPTY;
        }
        return elements.remove(topIndex--);
    }

    public T peek() throws Exception {
        if (elements.size() == 0)
            throw STACK_EMPTY;
        return elements.get(topIndex);
    }
}

class Queue<T>{
    private final List<T> elements;
    private static final Exception QUEUE_EMPTY = new Exception("Queue Empty");
    private int rear;
    public Queue(){
        elements = new ArrayList<>();
        rear = -1;
    }
    public void enQueue(T element){
        elements.add(0,element); // always adding at front
        rear++;
    }
    public T deQueue() throws Exception {
        if(rear!=-1)
          return elements.remove(rear--);
        throw QUEUE_EMPTY;
    }
    public T peek() throws Exception {
        if(rear!=-1)
            return elements.get(rear);
        throw QUEUE_EMPTY;
    }
}

class Node{
    char value;
    Node next;

    public Node(char value) {
        this.value = value;
    }
}