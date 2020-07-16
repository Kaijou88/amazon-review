package com.spring.boot.amazon.helper;

import com.spring.boot.amazon.model.Review;
import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParser;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParserSettings;

public class CsvFileParser implements Parser {
    private static final int MAX_CHARS_PER_COLUMN = 30_000;
    private static final short ID_INDEX = 0;
    private static final short PRODUCT_ID_INDEX = 1;
    private static final short USER_ID_INDEX = 2;
    private static final short PROFILE_NAME_INDEX = 3;
    private static final short HELP_NUMERATOR_INDEX = 4;
    private static final short HELP_DENOMINATOR_INDEX = 5;
    private static final short SCORE_INDEX = 6;
    private static final short TIME_INDEX = 7;
    private static final short SUMMARY_INDEX = 8;
    private static final short TEXT_INDEX = 9;

    @Override
    public List<Review> parse(String csvFileName, boolean isHeader) {
        List<Review> records = new ArrayList<>();
        try {
            CsvParserSettings settings = new CsvParserSettings();
            settings.setMaxCharsPerColumn(MAX_CHARS_PER_COLUMN);
            settings.detectFormatAutomatically();
            CsvParser parser = new CsvParser(settings);
            List<String[]> lines = parser.parseAll(new File(csvFileName));
            int firstLine = 0;
            if (isHeader) {
                firstLine = 1;
            }
            for (int i = firstLine; i < lines.size(); i++) {
                records.add(createReview(lines.get(i)));
            }
        } catch (Exception e) {
            throw new RuntimeException("File parsing is failed.", e);
        }
        return records;
    }

    private Review createReview(String[] array) {
        Review review = new Review();
        review.setId(Long.parseLong(array[ID_INDEX]));
        review.setProductId(array[PRODUCT_ID_INDEX]);
        review.setUserId(array[USER_ID_INDEX]);
        review.setProfileName(array[PROFILE_NAME_INDEX]);
        review.setHelpfulnessNumerator(Long.parseLong(array[HELP_NUMERATOR_INDEX]));
        review.setHelpfulnessDenominator(Long.parseLong(array[HELP_DENOMINATOR_INDEX]));
        review.setScore(Long.parseLong(array[SCORE_INDEX]));
        review.setTime(LocalDateTime.ofInstant(
                Instant.ofEpochMilli(Long.parseLong(array[TIME_INDEX])),
                                        TimeZone.getDefault().toZoneId()));
        review.setSummary(array[SUMMARY_INDEX]);
        review.setText(array[TEXT_INDEX]);
        return review;
    }
}
