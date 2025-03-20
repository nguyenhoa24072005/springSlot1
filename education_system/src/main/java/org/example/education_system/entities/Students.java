package org.example.education_system.entities;

import jakarta.persistence.*;
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "Student.addStudent",
                procedureName = "AddStudents",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "studentName"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "email"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "iphone"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "classId")
                }
        ),
        @NamedStoredProcedureQuery(
                name = "Student.updateStudent",
                procedureName = "UpdateStudent",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "studentId"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "newName"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "newEmail"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "newPhone"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "newClassId")
                }
        ),
        @NamedStoredProcedureQuery(
                name = "Student.transferStudents",
                procedureName = "TransferStudents",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "studentId"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "newClassId")
                }
        )
})
@Entity
@Table(name ="students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_student")
    private String nameStudent;
    private String email;
    private String iphone;

    @ManyToOne
    @JoinColumn(name = "id_class", referencedColumnName = "id")
    private ClassRoom classRoom;

    public Students() {
    }

    public Students(String nameStudent, String email, String iphone, ClassRoom classRoom) {
        this.nameStudent = nameStudent;
        this.email = email;
        this.iphone = iphone;
        this.classRoom = classRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
