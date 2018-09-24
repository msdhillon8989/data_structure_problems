package MovieReview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReviewRepo {

    private static ReviewRepo reviewRepo;
    List<Review> reviews = new ArrayList<>();
    private HashMap<Movie, List<Review>> movieReview = new HashMap<>();
    private HashMap<User, List<Movie>> moviesReviewdByUsers = new HashMap<>();
    private MovieRepository movieRepository;
    private UserRepository userRepository;
    //Iwhatever hghg;

    private ReviewRepo() {
        movieRepository = MovieRepository.getInstance();
        userRepository = UserRepository.getInstance();
    }

    public static ReviewRepo getInstance() {
        if (reviewRepo == null) {
            reviewRepo = new ReviewRepo();
        }
        return reviewRepo;
    }

    public void addReview(User user, Movie movie, Integer rating) {
       /* if (user.getReviewCount() == 3) {
            user.setUserType(UserType.CRITIC);
            System.out.println("User has been promoted");
        }*/
        Review r1 = new Review(user, movie, rating);
        List<Review> reviewList = movieReview.computeIfAbsent(movie, k -> new ArrayList<>());
        reviewList.add(r1);
        user.incementReviewCount();

        if (user.getUserType() == UserType.CRITIC) {
            Review r2 = new Review(user, movie, rating);
            reviewList.add(r2);
            user.incementReviewCount();
        }
        // movie.setScore(user.getUserType(),rating);
        List<Movie> movies = moviesReviewdByUsers.computeIfAbsent(user, k -> new ArrayList<>());
        movies.add(movie);
    }


    public boolean hasReviewed(User user, Movie movie) {
        if (moviesReviewdByUsers.containsKey(user)) {
            List<Movie> movies = moviesReviewdByUsers.get(user);
            if (movies.contains(movie)) {
                return true;
            }
        }
        return false;
    }


  /*  public List<Movie> topMoviesReviewByViewer(int year)
    {
       // List<Movie> movies = movieRepository.ge
    }*/
}
