package com.spring.boot.amazon.helper;

import com.spring.boot.amazon.model.Review;
import java.util.List;

public interface Parser {
    List<Review> parse(String fileName, boolean isHeader);
}
