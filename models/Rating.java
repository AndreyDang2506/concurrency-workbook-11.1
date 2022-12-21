package models;

import java.util.ArrayList;
import java.util.List;

public class Rating {

    double points;
    List<Review> reviews = new ArrayList<Review>();

    public Rating() {
    }

    public Rating(Rating src) {
        this.points = src.points;
        this.reviews = new ArrayList<Review>(src.reviews);
    }

    public double getPoint() {
        return points;
    }

    public void add(Review review) {
        reviews.add(review);
        computeRating();
    }

    private double computeRating() {
        double totalPoints = reviews.stream().map(Review::getPoints).reduce(0, Integer::sum);
        this.points = totalPoints / reviews.size();
        return this.points;
    }

    public static Rating average(Rating r1, Rating r2) {
        Rating combined = new Rating();
        combined.reviews = new ArrayList<>(r1.reviews);
        combined.reviews.addAll(r2.reviews);
        combined.computeRating();
        return combined;
    }

}