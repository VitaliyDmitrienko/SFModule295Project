// Module 27.8 intermediate project (Statistics: Student/University)
package org.example.models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;
import java.util.OptionalDouble;

public class Student {
    @SerializedName("StudFullName")
    private String fullName = null;
    @SerializedName("UnivID")
    private String universityId;
    @SerializedName("CurCourseNum")
    private int currentCourseNumber;
    @SerializedName("AvgExamScr")
    private float avgExamScore;

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    @Override
    public String toString() {
        return "Student: {" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                '}' + '\n';
    }

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public Student () {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return currentCourseNumber == student.currentCourseNumber && Float.compare(student.avgExamScore, avgExamScore) == 0 && Objects.equals(fullName, student.fullName) && Objects.equals(universityId, student.universityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, universityId, currentCourseNumber, avgExamScore);
    }
}
