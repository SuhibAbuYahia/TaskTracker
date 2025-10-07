package com.roadmap.tasktrackercli.model;

import com.roadmap.tasktrackercli.enums.TaskStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Task {
    private int id;
    private String description;
    private TaskStatus taskStatus;
    private long createdAt;
    private long updatedAt;

    public String toString() {
        return String.format("TaskId: %d\n Task description: %s\n Task status: %s\n Last update: %d\n", id, description, taskStatus, updatedAt);
    }
}
