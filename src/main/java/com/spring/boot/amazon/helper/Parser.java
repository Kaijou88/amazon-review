package com.spring.boot.amazon.helper;

import java.util.List;

public interface Parser {
    List parse(String file, boolean isHeader);
}
