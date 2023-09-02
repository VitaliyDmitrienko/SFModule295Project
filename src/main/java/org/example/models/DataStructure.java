package org.example.models;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "DataStructure")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataStructure {
    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    private List<Student> studentList;

    @XmlElementWrapper(name = "universities")
    @XmlElement(name = "university")
    private List<University> universityList;

    @XmlElementWrapper(name = "statisticsData")
    @XmlElement(name = "statistics")
    private List<Statistics> statisticsList;

    @XmlElement(name = "executionDate")
    private Date executionDate;

    public DataStructure() {
    }

    public DataStructure(List<Student> studentList, List<University> universityList, List<Statistics> statisticsList, Date executionDate) {
        this.studentList = studentList;
        this.universityList = universityList;
        this.statisticsList = statisticsList;
        this.executionDate = executionDate;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<University> getUniversityList() {
        return universityList;
    }

    public void setUniversityList(List<University> universityList) {
        this.universityList = universityList;
    }

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public void setStatisticsList(List<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public DataStructure createDataStructure ()
    { return new DataStructure(studentList, universityList, statisticsList, executionDate);}
}
