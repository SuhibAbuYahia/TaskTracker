package com.roadmap.tasktrackercli.enums;

import java.util.HashMap;
import java.util.Map;

public enum Option {
    ADD("add"),
    LIST("list"),
    DELETE("delete"),
    TODO("mark-todo", TaskStatus.TODO),
    IN_PROGRESS("mark-in-progress", TaskStatus.IN_PROGRESS),
    DONE("mark-done", TaskStatus.DONE),
    UPDATE("update");

    private final String command;
    private TaskStatus taskStatus;

    Option(String command) {
        this.command = command;
    }

    Option(String command, TaskStatus mappedStatus) {
        this.command = command;
        this.taskStatus = mappedStatus;
    }

    public String getCommand() {
        return command;
    }

    private static final Map<String, Option> LOOKUP = new HashMap<>();

    static {
        for (Option option : values()) {
            LOOKUP.put(option.command.toLowerCase(), option);
        }
    }

    public static Option fromString(String input) {
        Option option = LOOKUP.get(input.toLowerCase());
        if (option == null) {
            throw new IllegalArgumentException("Unknown command: " + input);
        }
        return option;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }
}
