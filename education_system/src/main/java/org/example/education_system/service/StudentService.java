package org.example.education_system.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.education_system.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    // Lấy danh sách tất cả sinh viên
    @Transactional
    public List<Object[]> getAllStudents() {
        return entityManager.createNativeQuery("CALL GetAllStudents()").getResultList();
    }

    // Thêm sinh viên mới
    // Cập nhật số lượng sinh viên trong lớp
    @Transactional
    public void addStudent(String nameStudent, String email, String iphone, Integer classId) {
        studentRepository.addStudent(nameStudent, email, iphone, classId);
    }

    // Cập nhật thông tin sinh viên
    @Transactional
    public void updateStudent(Integer studentId, String newName, String newEmail, String newPhone, Integer newClassId) {
        studentRepository.updateStudent(studentId, newName, newEmail, newPhone, newClassId);
    }

    // Xóa sinh viên
    @Transactional
    public void deleteStudent(Integer studentId) {
        studentRepository.deleteStudentById(studentId);
    }

    // Điều chuyển sinh viên sang lớp khác
    @Transactional
    public void transferStudent(Integer studentId, Integer newClassId) {
        studentRepository.transferStudent(studentId, newClassId);
    }
}
