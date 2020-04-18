package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    public static volatile BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));

    static {
        try {
            firstFileName=reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface  {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends  Thread implements ReadFileInterface {
        String fileName;
        String fileContent="";
        String s;


        @Override
        public synchronized void run() {
            try {
                StringBuilder sb = new StringBuilder();
                BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
                while (( s = reader1.readLine()) != null) {
                    sb.append(s);
                    sb.append(" ");


                }
                fileContent = sb.toString();
                reader1.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void setFileName(String fullFileName) {
            this.fileName=fullFileName;
        }

        @Override
        public String getFileContent() {
            return fileContent;
        }
    }
}
