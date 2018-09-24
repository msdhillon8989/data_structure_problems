package MovieReview;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MovieRepository {
    static private MovieRepository movieRepository;
    //private List<Movie> movies = new ArrayList<>();
    private HashMap<String, Movie> map = new HashMap<>();
    private HashMap<Genre, List<Movie>> genreMapList = new HashMap<>();
    private HashMap<Integer, List<Movie>> yearMapList = new HashMap<>();
   // private List<Movie> upcomingMovies = new ArrayList<>();

    private MovieRepository() {

    }

    static public MovieRepository getInstance() {
        if (movieRepository == null) {
            movieRepository = new MovieRepository();
        }
        return movieRepository;
    }


    public Movie addMovie(String name, Integer year, Genre... genres) {
        if (map.containsKey(name)) {
            System.out.println("Movie Already exist");
        } else {
            Movie movie = new Movie(name, year, genres);
            // movies.add(movie);
            map.put(name, movie);

            for (Genre genre : genres) {
                List<Movie> genreList = genreMapList.computeIfAbsent(genre, k -> new ArrayList<>());
                genreList.add(movie);
            }

            List<Movie> yearList = yearMapList.computeIfAbsent(year, k -> new ArrayList<>());
            yearList.add(movie);


            return movie;
        }

        return null;
    }


    public Movie getMovie(String movie) {
        return map.get(movie);
    }
}
