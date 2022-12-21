import java.util.Arrays;
import java.util.List;

import models.Rating;
import models.Review;
import models.User;

public class EntryPoint {
    public static void main(String[] args) {
        User john = new User("John", 30);
        john.getRating().add(new Review(5, ""));
        john.getRating().add(new Review(3, "not bad"));
        User julie = new User("Julie", 35);
        john.getRating().add(new Review(4, "great!"));
        john.getRating().add(new Review(2, "terrible experience"));
        julie.getRating().add(new Review(4, ""));
        List<User> users = Arrays.asList(john, julie);
        Rating averageRating = users.stream()
                .reduce(new Rating(),
                        (rating, user) -> Rating.average(rating, user.getRating()),
                        Rating::average);

        System.out.println(averageRating.getPoint());
    }
}
