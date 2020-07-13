package com.spring.boot.amazon;

import com.spring.boot.amazon.helper.CsvFileParser;
import com.spring.boot.amazon.helper.SimpleReader;
import com.spring.boot.amazon.model.Review;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.File;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class AmazonApplicationTests {
    private static final String ACTUAL_FILE = "C:\\Users\\mfran\\Downloads\\Reviews.csv";
    private static final String TEST_EMPTY_FILE = "C:\\Users\\mfran\\Downloads\\ReviewsTest.csv";
    private static final String FILE_DOES_NOT_EXIST = "C:\\Users\\mfran\\Downloads\\DoesNotExist.csv";
    private static final List<String> EMPTY_LIST_RESULT = Collections.EMPTY_LIST;

    @Test
    public void checkIfFileDoesNotExist() {
        File file = new File(FILE_DOES_NOT_EXIST);
        boolean isExist = file.exists();
        Assert.assertFalse(isExist);
    }

    @Test
    public void readFromEmptyFileUsingSimpleReader() {
        List<String> actualResult = new SimpleReader().read(TEST_EMPTY_FILE);
        Assert.assertEquals("Test failed! You should returned empty list.",
                EMPTY_LIST_RESULT, actualResult);
    }

    @Test
    public void readFromEmptyFileUsingCsvFileParser() {
        List<Review> actualResult = new CsvFileParser().parse(TEST_EMPTY_FILE, true);
        Assert.assertEquals("Test failed! You should returned empty list.",
                EMPTY_LIST_RESULT, actualResult);
    }

    @Test
    public void readFileUsingSimpleReader() {
        long actualResult = new SimpleReader().read(ACTUAL_FILE).size();
        Assert.assertEquals("Test failed! You should returned actual size.",
                568455, actualResult);
    }

    @Test
    public void readFileUsingCsvFileParserWithHeader() {
        long actualResult = new CsvFileParser().parse(ACTUAL_FILE, true).size();
        Assert.assertEquals("Test failed! You should returned actual size.",
                568454, actualResult);
    }

    @Test
    public void readFileUsingCsvFileParserWithoutHeader() {
        long actualResult = new CsvFileParser().parse(ACTUAL_FILE, false).size();
        Assert.assertEquals("Test failed! You should returned actual size.",
                568455, actualResult);
    }
}
