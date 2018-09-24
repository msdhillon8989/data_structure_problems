package MovieReview;

public class Service {

    static MovieRepository movieRepository;
    static UserRepository userRepository;
    static ReviewRepo reviewRepo;

    public Service() {

    }


    public static void main(String[] args) {
        movieRepository = MovieRepository.getInstance();
        userRepository = UserRepository.getInstance();
        reviewRepo = ReviewRepo.getInstance();


        movieRepository.addMovie("Don", 2006, Genre.ACTION, Genre.COMEDY);
        movieRepository.addMovie("Tiger", 2008, Genre.DRAMA);
        movieRepository.addMovie("Padmaavat", 2006, Genre.ACTION);
        movieRepository.addMovie("Robot", 2019, Genre.ACTION, Genre.THRILLER);
        movieRepository.addMovie("Guru", 2010, Genre.DRAMA);
        movieRepository.addMovie("Metro", 2012, Genre.ROMANCE);


        userRepository.addUser("SRK");
        userRepository.addUser("Salman");
        userRepository.addUser("Deepika");


        addReview("SRK", "Don", 2);
        addReview("SRK", "Tiger", 7);
        addReview("SRK", "Robot", 5);
        addReview("SRK", "Don", 5);
        addReview("SRK", "Metro", 5);
        addReview("SRK", "Guru", 5);
        addReview("SRK", "Padmaavat", 5);


        System.out.println();
    }

    private static void addReview(String name, String movieName, int rating) {
        Movie movie = movieRepository.getMovie(movieName);
        if (!movie.hasReleased()) {
            System.out.println("Movie Yet to release");
        } else

        {

            User user = userRepository.getUser(name);

            if (!reviewRepo.hasReviewed(user, movie)) {
                reviewRepo.addReview(user, movie, rating);
            } else {
                System.out.println("Multiple review not allowed");
            }
        }

    }

}
