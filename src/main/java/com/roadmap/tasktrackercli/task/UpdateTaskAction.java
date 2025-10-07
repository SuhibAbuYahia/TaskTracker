package com.roadmap.tasktrackercli.task;

import com.roadmap.tasktrackercli.model.Task;
import com.roadmap.tasktrackercli.task.abstraction.AbstractionTaskAction;

public class UpdateTaskAction extends AbstractionTaskAction {

    @Override
    public void execute(String[] args) {
        int id = Integer.parseInt(args[1]) - 1;
        Task task = tasks.get(id);
        task.setDescription(args[2]);
        tasks.set(id, task);
        saveTasks();
        System.out.println("updated: " + task);
    }
}
