package com.spring.boot.amazon.helper;

import com.opencsv.CSVReader;
import com.spring.boot.amazon.exceptions.DataProcessingException;
import com.spring.boot.amazon.model.Review;
import com.spring.boot.amazon.model.mappers.ReviewMapper;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileParser implements Parser {
    @Override
    public List<Review> parse(String csvFile, boolean isHeader) {
        List<Review> records = new ArrayList<>();
        try {
            char charThatWillNotAppear = 127;
            CSVReader reader = new CSVReader(new FileReader(csvFile), ',', charThatWillNotAppear);
            String[] values = null;
            while ((values = reader.readNext()) != null) {
                records.add(new ReviewMapper().createReview(values));
            }
        } catch (IOException e) {
            throw new DataProcessingException("File parsing is failed.", e);
        }
        if (isHeader && !records.isEmpty()) {
            records.remove(0);
        }
        return records;
    }
}
