# 📋 Najjiz — Task & To-Do Manager

<div align="center">

![Najjiz](https://img.shields.io/badge/Najjiz-Task%20Manager-4CAF50?style=for-the-badge)
![Android](https://img.shields.io/badge/Android-5.0+-4CAF50?style=for-the-badge&logo=android)
![API](https://img.shields.io/badge/minSdk-21-4CAF50?style=for-the-badge)
![Language](https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java)
![Database](https://img.shields.io/badge/Database-SQLite-blue?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

**A lightweight, intuitive task management app built with Android & SQLite**

*CS475 Mobile Computing — Phase 2*

[Features](#-features) • [Screenshots](#-screenshots) • [Getting Started](#-getting-started) • [Architecture](#-architecture) • [Contributing](#-contributing)

</div>

---

## 📱 About Najjiz

**Najjiz** is a sleek, user-friendly task and to-do manager designed to help you stay organized and productive. With a clean interface and intuitive workflow, managing your daily tasks has never been easier.

Whether you're planning your day, tracking projects, or organizing personal tasks, Najjiz keeps everything in one place with fast, local storage powered by SQLite.

---

## ✨ Features

### 🎯 Core Features
- ✅ **Add New Tasks** — Create tasks with custom titles and priority levels (High/Medium/Low)
- 👁️ **View Task Details** — See all task information at a glance with color-coded priorities
- 🗑️ **Delete Tasks** — Remove tasks with a confirmation dialog to prevent accidents
- 💾 **Local Storage** — All data stored securely in SQLite (no cloud required)
- 📦 **Lightweight** — Minimal dependencies, fast performance, low memory footprint

### 🎨 User Experience
- **Clean Interface** — Minimalist design with Material Design principles
- **RecyclerView** — Smooth, efficient task list rendering
- **CardView Layout** — Each task presented in a visually appealing card format
- **Priority Badges** — Color-coded priority indicators for quick scanning
- **Confirmation Dialogs** — Safe deletion with DialogFragment confirmation
- **Floating Action Button** — Quick access to create new tasks

---

## 📸 Screenshots

> *Replace the placeholder images below with your actual app screenshots*

<div align="center">
  <table>
    <tr>
      <td align="center">
        <strong>Welcome Screen</strong><br>
        <img src="[INSERT_SCREENSHOT_1]" width="250" alt="Welcome/Register Screen">
      </td>
      <td align="center">
        <strong>Task Dashboard</strong><br>
        <img src="[INSERT_SCREENSHOT_2]" width="250" alt="Task List View">
      </td>
      <td align="center">
        <strong>Add Task Form</strong><br>
        <img src="[INSERT_SCREENSHOT_3]" width="250" alt="Add New Task">
      </td>
    </tr>
    <tr>
      <td align="center">
        <strong>Delete Confirmation</strong><br>
        <img src="[INSERT_SCREENSHOT_4]" width="250" alt="Delete Dialog">
      </td>
      <td align="center">
        <strong>Task Details</strong><br>
        <img src="[INSERT_SCREENSHOT_5]" width="250" alt="Task Card Detail">
      </td>
      <td align="center">
        <strong>Priority Levels</strong><br>
        <img src="[INSERT_SCREENSHOT_6]" width="250" alt="Priority Levels">
      </td>
    </tr>
  </table>
</div>

---

## 🚀 Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

- **Android Studio** (Latest Stable Version)
  - Download: [developer.android.com/studio](https://developer.android.com/studio)
- **Java Development Kit (JDK)** 11 or higher
- **Android SDK** with support for API 21 (Android 5.0) or higher
- **Git** (for cloning the repository)

### Installation & Setup

#### **Step 1: Clone the Repository**
```bash
git clone https://github.com/Rwzan/Najjiz_Android_Project.git
cd Najjiz
```

#### **Step 2: Open in Android Studio**
1. Open **Android Studio**
2. Click **File** → **Open**
3. Navigate to and select the `Najjiz/` folder (the project root)
4. Click **Open**

#### **Step 3: Sync Gradle**
- Android Studio will automatically prompt you to sync Gradle files
- Wait for the sync to complete (requires internet connection for initial sync to download dependencies)
- If prompted, accept any SDK updates

#### **Step 4: Configure Emulator or Device**

**Using an Emulator:**
1. Go to **Tools** → **AVD Manager**
2. Click **Create Virtual Device**
3. Select a device (e.g., Pixel 6) and API level 21 or higher
4. Finish setup and start the emulator

**Using a Physical Device:**
1. Enable **Developer Mode**: Settings → About → Build Number (tap 7 times)
2. Enable **USB Debugging**: Settings → Developer Options → USB Debugging
3. Connect device via USB cable

#### **Step 5: Run the App**
1. Select your target device/emulator from the top toolbar
2. Click the **Run** button (▶️ green play icon)
3. Wait for the build to complete and the app to launch

---

## 📖 How to Use

### First Launch

1. **Welcome Screen** (`RegisterActivity`)
   - Enter your name
   - Click **"START MANAGING"** to proceed to the main dashboard

### Main Dashboard

2. **Task List** (`MyTasksActivity`)
   - View all your tasks in a scrollable list
   - Each task shows **title** and **priority level**
   - Tap a task card to view full details
   - Long press or swipe to delete (confirmation required)

### Adding a Task

3. **Create New Task** (`AddTaskActivity`)
   - Click the **Floating Action Button (FAB)** (➕ icon)
   - Enter task **title**
   - Select **priority**: High, Medium, or Low
   - Click **"SAVE TASK"**
   - Task appears immediately in your list

### Deleting a Task

4. **Remove Task** 
   - Click the **delete icon** on any task card
   - **Confirmation dialog** appears
   - Confirm to permanently delete (cannot be undone)

---

## 🏗️ Architecture & Technical Details

### Technology Stack

| Component | Technology | Purpose |
|-----------|-----------|---------|
| **Language** | Java | Core application logic |
| **Database** | SQLite | Local task persistence |
| **UI Framework** | Android Views | User interface components |
| **List Display** | RecyclerView | Efficient task list rendering |
| **Cards** | CardView | Individual task styling |
| **Dialogs** | DialogFragment | User confirmations |
| **Min API Level** | 21 (Android 5.0) | Broad device compatibility |
| **Target API** | 31+ | Modern Android features |

### Architecture Pattern

Najjiz follows a **layered architecture** with clear separation of concerns:

```
┌─────────────────────────────────────────────┐
│          User Interface Layer               │
│  (Activities, RecyclerView, CardView)       │
├─────────────────────────────────────────────┤
│          Business Logic Layer               │
│  (Adapters, DialogFragments)                │
├─────────────────────────────────────────────┤
│          Data Access Layer                  │
│  (DatabaseHelper, Task Model)               │
├─────────────────────────────────────────────┤
│          SQLite Database                    │
│  (tasks table)                              │
└─────────────────────────────────────────────┘
```

### Project Structure

```
Najjiz/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/najjiz/
│   │   │   │   ├── Activities/
│   │   │   │   │   ├── RegisterActivity.java      # Welcome & onboarding
│   │   │   │   │   ├── MyTasksActivity.java       # Main dashboard
│   │   │   │   │   └── AddTaskActivity.java       # Task creation form
│   │   │   │   ├── Adapters/
│   │   │   │   │   └── TaskAdapter.java           # RecyclerView adapter
│   │   │   │   ├── Dialogs/
│   │   │   │   │   └── DeleteConfirmDialogFragment.java  # Delete confirmation
│   │   │   │   ├── Database/
│   │   │   │   │   └── DatabaseHelper.java        # SQLite operations
│   │   │   │   └── Models/
│   │   │   │       └── Task.java                  # Task data model
│   │   │   │
│   │   │   └── res/
│   │   │       ├── layout/
│   │   │       │   ├── activity_register.xml      # Welcome screen
│   │   │       │   ├── activity_my_tasks.xml      # Task list view
│   │   │       │   ├── activity_add_task.xml      # Add task form
│   │   │       │   └── item_task.xml              # Task card layout
│   │   │       ├── values/
│   │   │       │   └── strings.xml, colors.xml, etc.
│   │   │       └── drawable/
│   │   │           └── [app icons & images]
│   │   │
│   │   └── AndroidManifest.xml
│   │
│   └── build.gradle                 # App-level dependencies
│
├── build.gradle                     # Project-level config
├── settings.gradle
└── README.md
```

### Database Schema

**Table: `tasks`**

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| `task_id` | INTEGER | PRIMARY KEY, AUTO_INCREMENT | Unique task identifier |
| `title` | TEXT | NOT NULL | Task title/description |
| `priority` | TEXT | - | Priority level (High/Medium/Low) |

**Key Operations:**
- `insertTask(Task)` — Add new task to database
- `getAllTasks()` — Retrieve all tasks
- `deleteTask(int taskId)` — Remove task by ID
- `updateTask(Task)` — Edit existing task (future implementation)

### Core Components

#### 1. **Activities** (User Interface Screens)

- **RegisterActivity**: 
  - Entry point of the app
  - User name input
  - Navigation to main dashboard

- **MyTasksActivity**: 
  - Main dashboard
  - RecyclerView displaying all tasks
  - Floating Action Button for adding tasks
  - Task selection and deletion

- **AddTaskActivity**: 
  - Form for creating new tasks
  - Title input field
  - Priority dropdown (High/Medium/Low)
  - Save button to persist to database

#### 2. **TaskAdapter** (RecyclerView Adapter)
- Binds task data to RecyclerView items
- Handles task card display logic
- Manages click events for task interaction

#### 3. **DeleteConfirmDialogFragment** (Dialog)
- Confirmation dialog before deleting tasks
- Prevents accidental data loss
- Communicates result back to parent activity

#### 4. **DatabaseHelper** (Database Management)
- SQLite database initialization
- CRUD operations (Create, Read, Update, Delete)
- Query methods for task retrieval
- Transaction management

#### 5. **Task Model** (Data Class)
- POJO (Plain Old Java Object)
- Properties: taskId, title, priority
- Getters and setters for data access

---

## 🔧 Development

### Building from Source

#### **Build APK for Distribution**
```bash
# Navigate to project directory
cd Najjiz

# Build release APK
./gradlew assembleRelease

# APK location: app/build/outputs/apk/release/
```

#### **Build and Run Debug Version**
```bash
./gradlew clean build
./gradlew installDebug
```

#### **Run Tests**
```bash
./gradlew test              # Unit tests
./gradlew connectedAndroidTest  # Instrumentation tests
```

### Code Style & Conventions

- **Java Naming**: camelCase for variables/methods, PascalCase for classes
- **Resource IDs**: snake_case (e.g., `activity_register`, `btn_save_task`)
- **Comments**: Clear documentation for complex logic
- **Android Best Practices**: Following official Android development guidelines

---

## 🎯 Phase 2 Requirements

This project fulfills the following CS475 Mobile Computing Phase 2 requirements:

✅ Multiple Activities (RegisterActivity, MyTasksActivity, AddTaskActivity)  
✅ Data Persistence (SQLite database)  
✅ RecyclerView for efficient list display  
✅ User Input & Validation (Form handling)  
✅ Dialogs & Fragments (Confirmation dialogs)  
✅ CRUD Operations (Create, Read, Delete)  
✅ Material Design Components (CardView, FAB)  

---

## 🚀 Future Enhancements

Potential features for Phase 3 and beyond:

- 📅 **Due Dates** — Add deadline functionality with date picker
- 🔔 **Notifications** — Reminders for upcoming/overdue tasks
- ✏️ **Edit Tasks** — Modify existing task details
- 🏷️ **Categories/Tags** — Organize tasks by category
- 🎨 **Themes** — Dark mode and custom color schemes
- ☁️ **Cloud Sync** — Firebase integration for cross-device sync
- 🔍 **Search & Filter** — Find tasks by keyword or priority
- ✅ **Completion Tracking** — Mark tasks as done
- 📊 **Statistics** — View productivity insights and task analytics
- 🌐 **Multi-language Support** — Localization (Arabic, English, etc.)

---

## 🤝 Contributing

We welcome contributions! If you'd like to improve Najjiz, follow these steps:

### How to Contribute

1. **Fork the Repository**
   ```bash
   git clone https://github.com/Rwzan/Najjiz_Android_Project.git
   cd Najjiz
   ```

2. **Create a Feature Branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

3. **Make Your Changes**
   - Write clean, well-commented code
   - Follow the existing code style
   - Test thoroughly

4. **Commit Your Changes**
   ```bash
   git add .
   git commit -m "Add feature: brief description of changes"
   ```

5. **Push to Your Fork**
   ```bash
   git push origin feature/your-feature-name
   ```

6. **Submit a Pull Request**
   - Describe your changes clearly
   - Reference any related issues

### Code Guidelines

- Use meaningful variable and function names
- Add comments for complex logic
- Avoid hardcoding strings (use `strings.xml`)
- Test on multiple API levels
- Follow Android best practices

---

## ❓ Troubleshooting

### **Issue: Gradle Sync Fails**
- **Solution**: 
  - Check internet connection
  - Click **File** → **Sync Now**
  - Clear cache: **File** → **Invalidate Caches** → **Invalidate & Restart**

### **Issue: App Crashes on Launch**
- **Solution**:
  - Check Android Studio Logcat for error messages
  - Ensure minSdk is set to 21 or higher
  - Verify all activities are declared in `AndroidManifest.xml`

### **Issue: RecyclerView Shows No Tasks**
- **Solution**:
  - Verify database permissions in `AndroidManifest.xml`
  - Check database file exists
  - Ensure adapter is properly initialized

### **Issue: Emulator Won't Start**
- **Solution**:
  - Update Android Studio and SDK
  - Delete and recreate the AVD
  - Ensure CPU virtualization is enabled in BIOS
  - Try a different API level

### **Issue: Database File Not Found**
- **Solution**:
  - Database is created automatically on first run
  - Check database path: `/data/data/com.example.najjiz/databases/`
  - Use Android Studio's Device File Explorer to verify

---

## 📄 License

This project is licensed under the **MIT License** — see the LICENSE file for details.

You are free to use, modify, and distribute this project as long as you include the original copyright notice.

---

## 👤 Author

**Developed by**: [Your Name / Rwzan]  
**Course**: CS475 — Mobile Computing  
**Institution**: [Your University]  
**Phase**: 2  

---

## 📞 Contact & Support

- **GitHub Issues**: [Report bugs or request features](https://github.com/Rwzan/Najjiz_Android_Project/issues)
- **Email**: [your.email@example.com]
- **LinkedIn**: [Your LinkedIn Profile]

---

## 📚 Resources

Helpful resources used in building Najjiz:

- [Android Developer Documentation](https://developer.android.com)
- [Android Architecture Components](https://developer.android.com/topic/architecture)
- [SQLite Database Guide](https://developer.android.com/training/data-storage/sqlite)
- [RecyclerView Tutorial](https://developer.android.com/guide/topics/ui/layout/recyclerview)
- [Material Design Guidelines](https://material.io/design)

---

<div align="center">

**⭐ If you found this project helpful, please consider giving it a star!**

Made with ❤️ for CS475 Mobile Computing

</div>
