package org.example.education_system.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.example.education_system.entities.ClassRoom;
import org.example.education_system.repository.ClassRoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClassRoomService {
    private final ClassRoomRepository classRoomRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public ClassRoomService(ClassRoomRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    @Transactional
    public List<Object[]> GetAllClass() {
        return entityManager.createNativeQuery("CALL GetAllClass()").getResultList();
    }



    // Thêm lớp học
    @Transactional
    public void addClass(String name_class, int maxStudents) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery("AddClass")
                .registerStoredProcedureParameter(1, String.class, jakarta.persistence.ParameterMode.IN)
                .registerStoredProcedureParameter(2, Integer.class, jakarta.persistence.ParameterMode.IN)
                .setParameter(1, name_class)
                .setParameter(2, maxStudents);

        query.execute();
    }

    // Cập nhật thông tin lớp học
    @Transactional
    public void updateClass(int classId, String nameclass, int maxStudents) {
        classRoomRepository.updateClass(classId, nameclass, maxStudents);
    }

    // Xóa lớp học
    @Transactional
    public void deleteClass(int classId) {
        try {
            classRoomRepository.deleteClass(classId);
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi xóa lớp: " + e.getMessage());
        }
    }

    public Optional<ClassRoom> getClassById(int classId) {
        return null;
    }
}
