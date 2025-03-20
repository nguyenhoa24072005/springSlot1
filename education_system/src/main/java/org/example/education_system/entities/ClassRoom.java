package org.example.education_system.entities;

import jakarta.persistence.*;

@NamedStoredProcedureQuery(
        name = "GetAllClass",
        procedureName = "GetAllClass",
        resultClasses = ClassRoom.class
)

@NamedStoredProcedureQuery(
        name = "DeleteClass",
        procedureName = "DeleteClass",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "classId", type = Integer.class)
        }
)
@NamedStoredProcedureQuery(
        name = "UpdateClass",
        procedureName = "UpdateClass",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "classId", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "nameclass", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "maxStudents", type = Integer.class),
        }
)
@Entity
@Table(name = "class")
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_class")  // Ánh xạ với cột name_class trong DB
    private String nameclass;
    private int maxStudents;
    @Column(name = "currentStudents")
    private int currentStudents;

    public ClassRoom() {
    }

    public ClassRoom(String nameclass, int maxStudents) {
        this.nameclass = nameclass;
        this.maxStudents = maxStudents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameclass() {
        return nameclass;
    }

    public void setNameclass(String nameclass) {
        this.nameclass = nameclass;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public int getCurrentStudents() {
        return currentStudents;
    }

    public void setCurrentStudents(int currentStudents) {
        this.currentStudents = currentStudents;
    }
}
