package models;

public class Review {
    private int points;
    private String review;

    public Review(int points, String review) {
        this.points = points;
        this.review = review;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getReview() {
        return this.review;
    }

    public void setReview(String review) {
        this.review = review;
    }

}
