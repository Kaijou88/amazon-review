package com.spring.boot.amazon.helper;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvFileReader implements Reader {
    @Override
    public List read(String csvFile) {
        CSVReader reader = null;
        List<List<String>> records = new ArrayList<>();
        try {
            char charThatWillNotAppearInText = 127;
            reader = new CSVReader(new FileReader(csvFile), ',', charThatWillNotAppearInText);
            String[] values = null;
            while ((values = reader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
