package com.roadmap.tasktrackercli.task;

import com.roadmap.tasktrackercli.task.abstraction.AbstractionTaskAction;

public class RemoveTaskAction extends AbstractionTaskAction {

    @Override
    public void execute(String[] args) {
        tasks.removeIf(t -> String.valueOf(t.getId()).equals(args[1]));
        saveTasks();
        System.out.println("Removed task with ID " + args[1]);
    }
}
