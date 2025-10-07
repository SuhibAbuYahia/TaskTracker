package com.roadmap.tasktrackercli.enums;

public enum TaskStatus {
    TODO("todo"),
    IN_PROGRESS("in-progress"),
    DONE("done");

    String value;

    TaskStatus(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
