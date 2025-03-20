package org.example.education_system.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardService {
    private final JdbcTemplate jdbcTemplate;

    public DashboardService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, Integer> getDashboardStats() {
        Map<String, Integer> stats = new HashMap<>();
        int totalStudents = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM students", Integer.class);
        int totalClasses = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM class", Integer.class);
        stats.put("totalStudents", totalStudents);
        stats.put("totalClasses", totalClasses);
        return stats;
    }
}

