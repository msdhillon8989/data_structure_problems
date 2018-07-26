package demos.reoccure;

import java.sql.Timestamp;
import java.util.Date;

public class Series {


    private Long id;

    private String title;

    private String createdBy;

    private Date creationDate;

    private Date startDate;

    private Date endDate;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    private String startTime;

    private String endTime;

    private String frequency;

    private Boolean noEndTime;

    private String daysOfWeek;

    private String weekOfMonth;

    private String dayOfMonth;

    private String monthOfYear;

    private String runOnDates;

    private Integer oCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }



    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Boolean getNoEndTime() {
        return noEndTime;
    }

    public void setNoEndTime(Boolean noEndTime) {
        this.noEndTime = noEndTime;
    }

    public String getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(String daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public String getWeekOfMonth() {
        return weekOfMonth;
    }

    public void setWeekOfMonth(String weekOfMonth) {
        this.weekOfMonth = weekOfMonth;
    }

    public String getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(String dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public String getMonthOfYear() {
        return monthOfYear;
    }

    public void setMonthOfYear(String monthOfYear) {
        this.monthOfYear = monthOfYear;
    }

    public String getRunOnDates() {
        return runOnDates;
    }

    public void setRunOnDates(String runOnDates) {
        this.runOnDates = runOnDates;
    }

    public Integer getoCount() {
        return oCount;
    }

    public void setoCount(Integer oCount) {
        this.oCount = oCount;
    }

}