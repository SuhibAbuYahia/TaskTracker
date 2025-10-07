package com.roadmap.tasktrackercli.task.abstraction;

import com.google.gson.reflect.TypeToken;
import com.roadmap.tasktrackercli.json.JsonManager;
import com.roadmap.tasktrackercli.model.Task;
import com.roadmap.tasktrackercli.task.interfaces.TaskAction;

import java.lang.reflect.Type;
import java.util.List;

public abstract class AbstractionTaskAction implements TaskAction {
    private static final String FILE_NAME = "tasks.json";
    protected static List<Task> tasks;
    private final JsonManager<Task> jsonManager;

    public AbstractionTaskAction() {
        Type listType = new TypeToken<List<Task>>() {}.getType();
        this.jsonManager = new JsonManager<>(FILE_NAME, listType);
        tasks = jsonManager.load();
    }

    protected void saveTasks() {
        jsonManager.save(tasks);
    }
}
