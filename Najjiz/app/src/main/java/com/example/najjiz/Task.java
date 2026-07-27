package com.example.najjiz;

/**
 * Simple data model representing a single row of the "tasks" table.
 */
public class Task {

    private final int id;
    private final String title;
    private final String priority;

    public Task(int id, String title, String priority) {
        this.id = id;
        this.title = title;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPriority() {
        return priority;
    }
}
