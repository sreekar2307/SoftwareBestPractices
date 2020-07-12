package com.company;
import java.io.*;
import java.util.*;

import static java.lang.String.join;

public class ReadWriteIO{

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