package com.aditya.SmartTaskManager;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(TaskRepository repository) {
    	return args -> {
            if (repository.count() == 0) { // Only add tasks if repository is empty
                repository.save(new Task(null, "Finish Project", "Complete the Spring Boot project with security", LocalDate.of(2025, 9, 10)));
                repository.save(new Task(null, "Prepare Report", "Write final documentation for submission", LocalDate.of(2025, 9, 15)));
                repository.save(new Task(null, "Team Meeting", "Discuss progress with the team", LocalDate.of(2025, 9, 5)));
                repository.save(new Task(null, "Fix Bugs", "Resolve critical issues in authentication flow", LocalDate.of(2025, 9, 8)));
                repository.save(new Task(null, "Code Review", "Review code and provide feedback", LocalDate.of(2025, 9, 12)));
            }
        };
    }
}