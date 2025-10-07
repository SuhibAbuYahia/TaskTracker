package com.roadmap.tasktrackercli.task;

import com.roadmap.tasktrackercli.enums.Option;
import com.roadmap.tasktrackercli.enums.TaskStatus;
import com.roadmap.tasktrackercli.model.Task;
import com.roadmap.tasktrackercli.task.abstraction.AbstractionTaskAction;

public class UpdateStatusTaskAction extends AbstractionTaskAction {

    @Override
    public void execute(String[] args) {
        Option option = Option.fromString(args[0]);
        int id = Integer.parseInt(args[1]) - 1; // simple incremental ID
        Task task = tasks.get(id);
        task.setTaskStatus(option.getTaskStatus());
        tasks.set(id, task);
        saveTasks();
        System.out.println("update: " + task);
    }
}
