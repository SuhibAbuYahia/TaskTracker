package com.roadmap.tasktrackercli.task;

import com.roadmap.tasktrackercli.enums.TaskStatus;
import com.roadmap.tasktrackercli.model.Task;
import com.roadmap.tasktrackercli.task.abstraction.AbstractionTaskAction;

import java.util.List;
import java.util.Locale;

public class ListTaskAction extends AbstractionTaskAction {

    @Override
    public void execute(String[] args) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available. Add one with: task add \"description\"");
            return;
        }

        if (args.length < 2) {
            tasks.forEach(System.out::println);
            return;
        }

        // Handle filtering by status
        String statusArg = args[1].toLowerCase(Locale.ROOT);

        final TaskStatus filterStatus = getFilterTaskStatus(statusArg);

        List<Task> filtered = tasks.stream()
                .filter(t -> t.getTaskStatus() == filterStatus)
                .toList();

        if (filtered.isEmpty()) {
            System.out.println("No tasks with status: " + filterStatus.getValue());
        } else {
            filtered.forEach(System.out::println);
        }
    }

    TaskStatus getFilterTaskStatus(String statusArg) {
        for (TaskStatus status : TaskStatus.values()) {
            if (status.getValue().equalsIgnoreCase(statusArg)) {
                return status;
            }
        }
        return null;
    }

}
