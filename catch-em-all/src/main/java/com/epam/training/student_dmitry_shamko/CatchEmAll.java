package com.epam.training.student_dmitry_shamko;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {
    static Exception exception = null;

    public static void riskyMethod() throws Exception {
            throw exception;
    }

    public static void main(String[] args) throws Exception {
        if (args.length >= 1) {
            switch (args[0]) {
                case "IOException":
                    exception = new IOException("IO exception");
                    break;
                case "FileNotFoundException":
                    exception = new FileNotFoundException("file not found exception");
                    break;
                case "ArithmeticException":
                    exception = new ArithmeticException("arithmetic exception");
                    break;
                case "NumberFormatException":
                    exception = new NumberFormatException("number format exception");
                    break;
                case "Exception":
                    exception = new Exception("exception");
                    break;
                default:
                    System.out.println("IOException, FileNotFoundException, ArithmeticException, NumberFormatException, Exception");
                    break;
            }
        }
        try {
            riskyMethod();
        }
        catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Resource is missing", e);
        }
        catch (IOException e) {
            throw new IllegalArgumentException("Resource error", e);
        }
        catch (ArithmeticException | NumberFormatException e) {
            System.err.println(e.getMessage());
        }
    }
}
