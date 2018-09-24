package MovieReview;

public class User {
    private String name;
    private UserType userType;
    private Integer reviewCount;



    public User(String name) {
        this.name = name;
        userType = UserType.VIEWER;
        reviewCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public void incementReviewCount() {
        this.reviewCount = reviewCount + 1;

    }


    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        return name.equals(user.name);
    }
}
