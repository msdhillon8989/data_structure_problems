package demo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by Pankaj on 20/04/17.
 *
 */



public class UserLocation implements Serializable
{
    public UserLocation(String city, String state, String country, String locationTime) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.locationTime = locationTime;
    }

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private String city;

    private String state;

    private String country;

    private String locationTime;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocationTime() {
        return locationTime;
    }

    public void setLocationTime(String locationTime) {
        this.locationTime = locationTime;
    }

   /* public Date getLocationDateTime(){
        try {
            return  DATE_FORMAT.parse(locationTime);
        }
        catch (ParseException e) {
            return getEpochDate();
        }
    }*/
   public Date getLocationDateTime(){
       try {
           return !DATE_FORMAT.toPattern().matches(locationTime)
                   ? getEpochDate()
                   : DATE_FORMAT.parse(locationTime);
       }
       catch (ParseException e) {
           return getEpochDate();
       }
   }
    public static Date getEpochDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(1970,1,1);
        return calendar.getTime();
    }

    static final Comparator<UserLocation> dateTimeComparator = Comparator.comparing(
            UserLocation::getLocationDateTime);



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserLocation that = (UserLocation) o;

        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        return country != null ? country.equals(that.country) : that.country == null;
    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserLocation{" + "city='" + city + '\'' + ", state='" + state + '\'' + ", country='" + country + '\'' +
                '}';
    }

  /*  @Override
    public int compareTo(UserLocation o) {
        return (int)(getLocationDateTime().getTime()-o.getLocationDateTime().getTime());
    }*/
}
