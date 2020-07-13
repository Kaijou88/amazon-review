package com.spring.boot.amazon.model.mappers;

import com.spring.boot.amazon.model.Review;

public class ReviewMapper {
    public Review createReview(String[] array) {
        Review review = new Review();
        review.setId(array[0]);
        review.setProductId(array[1]);
        review.setUserId(array[2]);
        review.setProfileName(array[3]);
        review.setHelpfulnessNumerator(array[4]);
        review.setHelpfulnessDenominator(array[5]);
        review.setScore(array[6]);
        review.setTime(array[7]);
        review.setSummary(array[8]);
        review.setText(array[9]);
        return review;
    }
}
