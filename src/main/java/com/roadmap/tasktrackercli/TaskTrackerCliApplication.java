package com.roadmap.tasktrackercli;

import com.roadmap.tasktrackercli.enums.Option;
import com.roadmap.tasktrackercli.factory.TaskFactory;
import com.roadmap.tasktrackercli.task.interfaces.TaskAction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskTrackerCliApplication {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Available commands: add, list, remove");
            return;
        }

        try {
            Option option = Option.fromString(args[0]);
            TaskAction action = TaskFactory.getAction(option);
            action.execute(args);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }    }

}
