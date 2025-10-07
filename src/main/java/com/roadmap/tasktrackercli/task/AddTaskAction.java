package com.roadmap.tasktrackercli.task;

import com.roadmap.tasktrackercli.enums.TaskStatus;
import com.roadmap.tasktrackercli.model.Task;
import com.roadmap.tasktrackercli.task.abstraction.AbstractionTaskAction;

public class AddTaskAction extends AbstractionTaskAction {

    @Override
    public void execute(String[] args) {
        int id = tasks.size() + 1; // simple incremental ID
        Task task = Task.builder()
                .id(id)
                .description(args[1])
                .createdAt(System.currentTimeMillis())
                .updatedAt(System.currentTimeMillis())
                .taskStatus(TaskStatus.TODO)
                .build();
        tasks.add(task);
        saveTasks();
        System.out.println("Added: " + task);
    }
}
