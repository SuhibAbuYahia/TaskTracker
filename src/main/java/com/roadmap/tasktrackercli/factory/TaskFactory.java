package com.roadmap.tasktrackercli.factory;

import com.roadmap.tasktrackercli.enums.Option;
import com.roadmap.tasktrackercli.task.AddTaskAction;
import com.roadmap.tasktrackercli.task.ListTaskAction;
import com.roadmap.tasktrackercli.task.RemoveTaskAction;
import com.roadmap.tasktrackercli.task.UpdateStatusTaskAction;
import com.roadmap.tasktrackercli.task.UpdateTaskAction;
import com.roadmap.tasktrackercli.task.interfaces.TaskAction;

import java.util.Map;

public class TaskFactory {
    private static final Map<Option, TaskAction> actions = Map.of(
            Option.ADD, new AddTaskAction(),
            Option.LIST, new ListTaskAction(),
            Option.REMOVE, new RemoveTaskAction(),
            Option.UPDATE, new UpdateTaskAction(),
            Option.IN_PROGRESS, new UpdateStatusTaskAction(),
            Option.DONE, new UpdateStatusTaskAction(),
            Option.TODO, new UpdateStatusTaskAction()
    );

    public static TaskAction getAction(Option option) {
        return actions.get(option);
    }
}
