package org.example.education_system.repository;

import jakarta.transaction.Transactional;
import org.example.education_system.entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {

    @Procedure(name = "GetAllStudents")
    List<Students> getAllStudents();

    @Procedure(name = "Student.addStudent")
    void addStudent(String studentName, String email, String iphone, Integer classId);

    @Procedure(name = "Student.updateStudent")
    void updateStudent(Integer studentId, String newName, String newEmail, String newPhone, Integer newClassId);

    @Modifying
    @Transactional
    @Query(value = "CALL DeleteStudents(:studentId)", nativeQuery = true)
    void deleteStudentById(@Param("studentId") Integer studentId);

    @Procedure(name = "Student.transferStudents")
    void transferStudent(int studentId, int newClassId);

}
