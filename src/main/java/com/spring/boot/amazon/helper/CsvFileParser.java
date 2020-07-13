package com.spring.boot.amazon.helper;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvFileParser implements Parser {
    @Override
    public List parse(String csvFile, boolean isHeader) {
        List<List<String>> records = new ArrayList<>();
        try {
            char charThatWillNotAppear = 127;
            CSVReader reader = new CSVReader(new FileReader(csvFile), ',', charThatWillNotAppear);
            String[] values = null;
            while ((values = reader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (isHeader) {
            records.remove(0);
        }
        return records;
    }
}
