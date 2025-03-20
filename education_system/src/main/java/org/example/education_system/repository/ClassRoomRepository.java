package org.example.education_system.repository;

import org.example.education_system.entities.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Integer> {

    @Query(value = "CALL GetAllClass()", nativeQuery = true)
    List<ClassRoom> getAllClass();

    // Gọi Stored Procedure thêm lớp học

    @Procedure(value = "AddClass")
    void addClass(@Param("name_class") String name_class, @Param("maxStudents") int maxStudents,@Param("currentStudents") int currentStudents);

    // Gọi Stored Procedure cập nhật lớp học
    @Procedure(value = "UpdateClass")
    void updateClass(@Param("classId") int classId,
                     @Param("nameclass") String nameclass,
                     @Param("maxStudents") int maxStudents);

    // Gọi Stored Procedure xóa lớp học
    @Procedure(name = "DeleteClass")
    void deleteClass(@Param("classId") int classId);
}
