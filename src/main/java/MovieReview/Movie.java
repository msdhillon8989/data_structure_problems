package MovieReview;

import java.text.SimpleDateFormat;
import java.util.*;

public class Movie {
    private String name;
    private Integer year;
    private List<Genre> genres;
   // private HashMap<UserType, Integer> totalRating;


    public Movie() {

    }

    public Movie(String name, Integer year, Genre... genres) {
        this.name = name;
        this.year = year;
        //totalRating = new HashMap<>();
        this.genres = new ArrayList<>();
        Collections.addAll(this.genres, genres);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }


    public boolean hasReleased() {
        int currentYear = Integer.parseInt(new SimpleDateFormat("YYYY").format(new Date()));
        if (year > currentYear) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        Movie movie = (Movie) obj;
        return movie.name.equals(this.name);
    }


  /*  public void setScore(UserType userType, Integer rating) {
        if (totalRating.containsKey(userType)) {
            totalRating.put(userType, totalRating.get(userType) + rating);
            if (userType == UserType.CRITIC) {
                totalRating.put(userType, totalRating.get(userType) + rating);
            }
        }
    }*/
}
