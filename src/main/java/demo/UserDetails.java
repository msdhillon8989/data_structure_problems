package demo;

/**
 * Created by maninder on 8/12/16.
 */


import com.fasterxml.jackson.core.JsonParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.List;


/**
 * Created by maninder on 8/12/16.
 */
public class UserDetails
{
    public String email;

    public String firstName;

    public String lastName;

    public String userBirthday;

    public String city;

    public String gender;

    public Long mobile;

    public String password;

    public String source;

    public String state;

    public String country;

    public Integer countryCode;

    public Long appID;

    public String osID;

    public String identity;

    public String mobileVerificationCode;

    public Integer status;

    public Integer emailVerify;

    public Integer mobileVerify;

    public Long clientTransactionID;

    public String resetPassToken;

    public String emailToken;

    public String email2;

    public String langCode;

    public String currency;

    public String ip;

    public String facebookID;

    public String twitterID;

    public String googleID;

    public String imageURL;

    public String userName;

    public String userLocation;

    public String dob;

    public String employmentStatus;

    public String annualSalary;

    public String screenName;

    public Double longitude;

    public Double latitude;

    public Integer idxLong;

    public Integer idxLat;

    public String refUserID;

    public String gcmRegID;

    public String statusRef;

    public Integer abuseFlag;

    public String osVersion;

    public String pubUID;

    public String appVersion;

    public String sdkVersion;

    public String timestamp;

    public String macAddress;

    public String deviceType;

    public String connectionType;

    public String screenDensityX;

    public String screenDensityY;

    public String screenHeight;

    public String carrierName;

    public String screenDensityCategory;

    public String deviceID;

    public String deviceModel;

    public String language;

    public String assetValue;

    public String name;

    public String age;

    public String sex;

    public String location;

    public String maritalStatus;

    public String birthday;

    public String twitterHander;

    public String education;

    public String nationality;

    public String employment;

    public String deviceAdvertisingID;

    public Integer walletAvailable = 1;

    public Integer isRooted = 0;

    public String ageGroup;

    public String segments;
    public String id;


    public List<String> interestList;

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        UserDetails userDetails = mapper.readValue("{\"id\":\"uderID\",\"birthday\":\"1987\"}",UserDetails.class);
        System.out.println(userDetails.id);
        System.out.println(userDetails.birthday);



    }
}
