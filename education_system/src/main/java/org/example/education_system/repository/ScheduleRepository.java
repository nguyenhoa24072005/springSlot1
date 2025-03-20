package org.example.education_system.repository;

import org.example.education_system.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    @Procedure(name = "RegisterSchedule")
    void registerSchedule(@Param("studentId") int studentId,
                          @Param("classId") int classId,
                          @Param("subject") String subject,
                          @Param("scheduleDate") String scheduleDate,
                          @Param("modifiableUntil") String modifiableUntil);

    @Procedure(name = "GetStudentSchedule")
    List<Schedule> getStudentSchedule(@Param("studentId") int studentId);

    @Procedure(name = "UpdateSchedule")
    void updateSchedule(@Param("scheduleId") int scheduleId,
                        @Param("newScheduleDate") String newScheduleDate);
}
