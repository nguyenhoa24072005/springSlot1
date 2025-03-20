package org.example.education_system.entities;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_class", referencedColumnName = "id")
    private ClassRoom classRoom;
    @ManyToOne
    @JoinColumn(name = "id_students", referencedColumnName = "id")
    private Students students;
    private String subject;
    private Date date_schedule;
    private Date modifiable_until;

    public Schedule() {
    }

    public Schedule(ClassRoom classRoom, Students students, String subject, Date date_schedule, Date modifiable_until) {
        this.classRoom = classRoom;
        this.students = students;
        this.subject = subject;
        this.date_schedule = date_schedule;
        this.modifiable_until = modifiable_until;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getDate_schedule() {
        return date_schedule;
    }

    public void setDate_schedule(Date date_schedule) {
        this.date_schedule = date_schedule;
    }

    public Date getModifiable_until() {
        return modifiable_until;
    }

    public void setModifiable_until(Date modifiable_until) {
        this.modifiable_until = modifiable_until;
    }
}
