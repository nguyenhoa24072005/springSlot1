package org.example.education_system.controller;

import org.example.education_system.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Lấy danh sách tất cả sinh viên
    @GetMapping("/list")
    public List<Object[]> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Thêm sinh viên mới
    @PostMapping("/add")
    public String addStudent(@RequestParam String nameStudent,
                             @RequestParam String email,
                             @RequestParam String iphone,
                             @RequestParam Integer classId) {
        try {
            studentService.addStudent(nameStudent, email, iphone, classId);
            return "Student added successfully!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    // Cập nhật thông tin sinh viên
    @PutMapping("/{studentId}")
    public String updateStudent(@PathVariable Integer studentId,  // Dùng @PathVariable
                                @RequestParam String newName,
                                @RequestParam String newEmail,
                                @RequestParam String newPhone,
                                @RequestParam Integer newClassId) {
        try {
            studentService.updateStudent(studentId, newName, newEmail, newPhone, newClassId);
            return "Student updated successfully!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }


    // Xóa sinh viên
    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer studentId) {
        try {
            studentService.deleteStudent(studentId);
            return ResponseEntity.ok("Student deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }


    // Điều chuyển sinh viên sang lớp khác
    @PostMapping("/transfer")
    public String transferStudent(
            @RequestParam int studentId,
            @RequestParam int newClassId) {
        try {
            studentService.transferStudent(studentId, newClassId);
            return "Sinh viên đã được chuyển thành công!";
        } catch (Exception e) {
            return "Lỗi: " + e.getMessage();
        }
    }

}
