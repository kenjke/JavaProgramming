package com.epam.aleksandr_generalov.java.lesson3;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Task5Runner {

    public static void main(String[] args) {
        Task5Runner runner = new Task5Runner();
        runner.startApplication(args);
    }

    private void startApplication(String[] args) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            Course javaServletsCourse = new Course("Технология Java Servlets", 16);
            Course strutsFramework = new Course("Struts Framework", 24);
            Student firstStudent = new Student("Ivanov Ivan", "J2EE Developer", simpleDateFormat.parse("16-03-2018 15:00"),
                    Arrays.asList(javaServletsCourse, strutsFramework));
            Course reviewJavaCourse = new Course("Обзор технологий Java", 8);
            Course swingLibraryCourse = new Course("Библиотека JFC/Swing", 16);
            Course jdbcCourse = new Course("Технология JDBC", 16);
            Student secondStudent = new Student("Petrov Petr", "Java Developer", simpleDateFormat.parse("16-03-2018 15:00"),
                    Arrays.asList(reviewJavaCourse, swingLibraryCourse, jdbcCourse));
            if (args.length != 0 && Integer.parseInt(args[0]) != 0) {
                getTimeInformation(firstStudent, args);
                getTimeInformation(secondStudent, args);
            } else {
                getTimeInformation(firstStudent, null);
                getTimeInformation(secondStudent, null);
            }
        } catch (ParseException e) {
            System.out.println("Unable to parse data!");
        }
    }

    private void getTimeInformation(Student student, Object o) {
        if (student.getStartDate().getHours() < 10) {
            student.getStartDate().setHours(10);
        }
        if (student.getStartDate().getHours() > 18) {
            student.getStartDate().setHours(18);
        }
        Integer totalDuration = student.getTotalDuration();
        int hours = student.getStartDate().getHours();
        while (hours < 18) {
            hours++;
            totalDuration--;
            student.getStartDate().setHours(hours);
        }
        Date endDate = student.getStartDate();
        int daysCount = 0;
        int hoursCount = 0;
        while (totalDuration > 0) {
            if (totalDuration < 8) {
                hoursCount++;
                totalDuration -= totalDuration;
            } else {
                daysCount++;
                totalDuration -= 8;
            }
        }
        endDate = DateUtils.addDays(endDate, daysCount);
        endDate = DateUtils.addHours(endDate, hoursCount);
        if (endDate.getHours() > 18) {
            hours = endDate.getHours() - 18;
            endDate = DateUtils.addDays(endDate, 1);
            endDate.setHours(0);
            endDate = DateUtils.addHours(endDate, 10 + hours);
        }
        Date currentDate = new Date();
        if (currentDate.getHours() < 10) {
            currentDate.setHours(10);
        }
        if (currentDate.getHours() > 18) {
            currentDate.setHours(18);
        }
        boolean isAfter = true;
        int courseDelta = 0;
        if (currentDate.after(endDate)) {
            Date tempDate = endDate;
            tempDate.setMinutes(0);
            tempDate.setSeconds(0);
            while (!currentDate.toString().equals(tempDate.toString())) {
                hours = tempDate.getHours();
                hours++;
                courseDelta++;
                if (hours == 18) {
                    tempDate = DateUtils.addDays(tempDate, 1);
                    tempDate.setHours(10);
                } else {
                    tempDate.setHours(hours);
                }
            }
        } else {
            isAfter = false;
            Date tempDate = currentDate;
            tempDate.setMinutes(0);
            tempDate.setSeconds(0);
            while (!endDate.toString().equals(tempDate.toString())) {
                hours = tempDate.getHours();
                hours++;
                courseDelta++;
                if (hours == 18) {
                    tempDate = DateUtils.addDays(tempDate, 1);
                    tempDate.setHours(10);
                } else {
                    tempDate.setHours(hours);
                }
            }
        }
        if (o != null) {
            String toShow = student.getFullName() + " ";
            toShow += "work time: from 10 to 18 ";
            toShow += "(" + student.getCurriculum() + ") ";
            toShow += "total duration: " + totalDuration + " ";
            toShow += "start date" + student.getStartDate().toString() + " ";
            toShow += "end date" + endDate.toString() + " ";
            int days = courseDelta / 8;
            hours = courseDelta % 8;
            if (isAfter) {
                toShow += "course has been completed " + ((days == 0) ? "" : days) + "days" + hours + "hours ago";
            } else {
                toShow += "course must be completed after " + ((days == 0) ? "" : days) + "days" + hours + " hours";
            }
            System.out.println(toShow);
        } else {
            String toShow = student.getFullName() + " ";
            toShow += "(" + student.getCurriculum() + ") ";
            int days = courseDelta / 8;
            hours = courseDelta % 8;
            if (isAfter) {
                toShow += "course has been completed " + ((days == 0) ? "" : days) + "days" + hours + " hours ago";
            } else {
                toShow += "course must be completed after " + ((days == 0) ? "" : days) + "days" + hours + " hours";
            }
            System.out.println(toShow);
        }
    }
}
