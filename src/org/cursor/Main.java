package org.cursor;


import java.io.*;

public class Main {
    public static void main(String[] args) {
        File copyFrom = new File("resources/", args[0]);
        File copyTo = new File("resources/", args[1]);
        FileInputStream input = null;
        FileOutputStream output = null;

        try {
            input = new FileInputStream(copyFrom);

        } catch (FileNotFoundException e) {
            System.out.println("Error occurred: file does not exist, " +
                    "or is a directory rather than a regular file, " +
                    "or for some other reason cannot be opened for reading");
        }
        try {
            output = new FileOutputStream(copyTo);

        } catch (FileNotFoundException e) {
            System.out.println("Error occurred: file does not exist, " +
                    "or is a directory rather than a regular file, " +
                    "or for some other reason cannot be opened for reading");
        }
        byte[] buffer = new byte[1024];
        int lenght;
        try {
            while (true) {
                assert input != null;
                if (!((lenght = input.read(buffer)) > 0)) break;
                assert output != null;
                output.write(buffer, 0, lenght);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while writing to file");
        }
        try {
            input.close();
            assert output != null;
            output.close();
            System.out.println("File copied successfully");
        } catch (IOException e) {
            System.out.println("Error occurred while saving file");
        }
    }
}
