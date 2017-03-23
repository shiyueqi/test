package io;

import java.io.*;

/**
 * date: 2017/02/09 09:46.
 * author: Yueqi Shi
 */
public class InputTest {

    public void testBufferedReader() {
        File file = new File("G:/magpie-benchmark-rpc-obj-20-100000-1k.log");
        System.out.println("*********testBufferedReader*********");
        System.out.println("path:" + file.getPath());
        System.out.println("name:" + file.getName());
        System.out.println("parent:" + file.getParent());

        try {
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            for (int i = 0; i < 40; i++) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    System.out.println(line);
                } else {
                    break;
                }
            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testInputStream() {
        File file = new File("G:/magpie-benchmark-rpc-obj-20-100000-1k.log");
        System.out.println("*********testInputStream*********");
        System.out.println("path:" + file.getPath());
        System.out.println("name:" + file.getName());
        System.out.println("parent:" + file.getParent());

        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[3000];
            inputStream.read(bytes);

            String input = new String(bytes);
            System.out.println(input);

            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        InputTest inputTest = new InputTest();
        inputTest.testBufferedReader();
        inputTest.testInputStream();
    }
}
