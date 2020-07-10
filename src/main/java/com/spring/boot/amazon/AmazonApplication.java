package com.spring.boot.amazon;

import com.spring.boot.amazon.helper.SimpleReader;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmazonApplication {
    private static final String PATH = "C:\\Users\\mfran\\Downloads\\Reviews.csv";

    public static void main(String[] args) {
        List records = new SimpleReader().read(PATH);
        System.out.println("Size of list after reading Review file is " + records.size());
    }
}
