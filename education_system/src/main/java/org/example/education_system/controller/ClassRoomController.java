package org.example.education_system.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.education_system.service.ClassRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/classroom")
public class ClassRoomController {
    private final ClassRoomService classRoomService;
    @PersistenceContext
    private EntityManager entityManager;

    public ClassRoomController(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }

    @GetMapping("/all")
    public List<Object[]> GetAllClass() {
        return classRoomService.GetAllClass();
    }

    // Thêm lớp học mới
    @PostMapping("/add")
    public ResponseEntity<String> addClass(@RequestParam String name_class, @RequestParam int maxStudents) {
        classRoomService.addClass(name_class, maxStudents);
        return ResponseEntity.ok("Lớp học đã được thêm thành công!");
    }

    // Cập nhật lớp học
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateClass(@PathVariable("id") int classId,
                                              @RequestParam String nameclass,
                                              @RequestParam int maxStudents) {
        classRoomService.updateClass(classId, nameclass, maxStudents);
        return ResponseEntity.ok("Cập nhật lớp học thành công!");
    }

    // Xóa lớp học
    @DeleteMapping("/delete/{classId}")
    public ResponseEntity<String> deleteClass(@PathVariable int classId) {
        try {
            classRoomService.deleteClass(classId);
            return ResponseEntity.ok("Xóa lớp thành công!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}