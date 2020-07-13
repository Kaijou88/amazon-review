package com.spring.boot.amazon.model;

public class Review {
    private String id;
    private String productId;
    private String userId;
    private String profileName;
    private String helpfulnessNumerator;
    private String helpfulnessDenominator;
    private String score;
    private String time;
    private String summary;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getHelpfulnessNumerator() {
        return helpfulnessNumerator;
    }

    public void setHelpfulnessNumerator(String helpfulnessNumerator) {
        this.helpfulnessNumerator = helpfulnessNumerator;
    }

    public String getHelpfulnessDenominator() {
        return helpfulnessDenominator;
    }

    public void setHelpfulnessDenominator(String helpfulnessDenominator) {
        this.helpfulnessDenominator = helpfulnessDenominator;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Review{"
                + "id = '" + id + '\''
                + ", productId = '" + productId + '\''
                + ", userId = '" + userId + '\''
                + ", profileName = '" + profileName + '\''
                + ", helpfulnessNumerator = '" + helpfulnessNumerator + '\''
                + ", helpfulnessDenominator = '" + helpfulnessDenominator + '\''
                + ", score = '" + score + '\''
                + ", time = '" + time + '\''
                + ", summary = '" + summary + '\''
                + ", text = '" + text + '\''
                + '}';
    }
}
