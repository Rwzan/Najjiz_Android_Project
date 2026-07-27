# Najjiz — Task & To-Do Manager (CS475 Mobile Computing, Phase 2)


## How to open and run
1. Open Android Studio.
2. **File → Open** and select this project's root folder (`Najjiz/`).
3. Let Gradle sync (requires internet access for the first sync to download dependencies).
4. Run on an emulator or device (minSdk 21 / Android 5.0+).

## What's implemented 

**Activities (3):**
- `RegisterActivity` — launcher/welcome screen, name input, "START MANAGING" button.
- `MyTasksActivity` — main dashboard, RecyclerView of tasks, FAB to add a task.
- `AddTaskActivity` — form with title + priority (High/Medium/Low), "SAVE TASK" button.

**Features (3):**
- Add New Task (AddTaskActivity → SQLite INSERT).
- View Task Details (title + priority shown directly on each CardView).
- Delete Task (DialogFragment confirmation → SQLite DELETE).

**Database (SQLite, single table, `DatabaseHelper.java`):**
- Table `tasks(task_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, priority TEXT)`.
- Operations: `insertTask()`, `deleteTask()`, `getAllTasks()` (INSERT / DELETE / SELECT ALL).

**Android Components:**
- `RecyclerView` — displays the task list in `MyTasksActivity`.
- `CardView` — each task row (`item_task.xml`).
- `DialogFragment` — `DeleteConfirmDialogFragment.java`, delete confirmation.

## Project structure
```
app/src/main/java/com/example/najjiz/
├── RegisterActivity.java
├── MyTasksActivity.java
├── AddTaskActivity.java
├── TaskAdapter.java
├── DeleteConfirmDialogFragment.java
├── DatabaseHelper.java
└── Task.java

app/src/main/res/layout/
├── activity_register.xml
├── activity_my_tasks.xml
├── activity_add_task.xml
└── item_task.xml
```
