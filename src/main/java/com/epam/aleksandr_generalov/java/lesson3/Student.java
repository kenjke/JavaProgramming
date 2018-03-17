package com.epam.aleksandr_generalov.java.lesson3;

import java.util.Date;
import java.util.List;

public class Student {

    private String fullName;
    private String curriculum;
    private Date startDate;
    private List<Course> courses;

    public Student(String fullName, String curriculum, Date startDate, List<Course> courses) {
        this.fullName = fullName;
        this.curriculum = curriculum;
        this.startDate = startDate;
        this.courses = courses;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Integer getTotalDuration(){
        Integer toReturn = 0;
        for(Course course : courses){
            toReturn += course.getDuration();
        }
        return toReturn;
    }
}
