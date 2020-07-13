package com.spring.boot.amazon;

import com.spring.boot.amazon.helper.CsvFileParser;
import com.spring.boot.amazon.helper.SimpleReader;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmazonApplication {
    private static final String PATH = "C:\\Users\\mfran\\Downloads\\Reviews.csv";
    private static boolean isHeader = true;

    public static void main(String[] args) {
        List<String> records1 = new SimpleReader().read(PATH);
        System.out.println("Size of list after reading Review file is " + records1.size());

        List<List<String>> records2 = new CsvFileParser().parse(PATH, isHeader);
        System.out.println("Size of list after parsing Review file with CsvFileParser is "
                            + records2.size());
    }
}
