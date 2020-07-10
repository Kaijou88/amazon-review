package com.spring.boot.amazon.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimpleReader implements Reader {
    public List read(String csvFile) {
        List<String> records = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))) {
            while (bufferedReader.ready()) {
                records.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records;
    }
}
