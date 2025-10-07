
# 📝 Task CLI

A simple command-line **task tracker** built in Java.
Manage your tasks directly from the terminal — add, update, delete, and list them with ease.

This is a solution for project of https://roadmap.sh/projects/task-tracker

---

## 🚀 Features

- Add, update, and delete tasks
- Mark tasks as **todo**, **in-progress**, or **done**
- Filter tasks by status
- Persistent storage in a local JSON file
- Runs as a standalone `.jar` CLI tool

---

## ⚙️ Build Instructions

### 1. Clone the repository
```bash
git clone https://github.com/SuhibAbuYahia/TaskTracker.git
cd task-cli
```

### 2. Build the JAR using Maven
```bash
mvn clean package
```

This will create a runnable JAR file inside the `target/` directory:
```
target/task-cli-1.0.jar
```

---

## 💻 Running the CLI

Run the application using:
```bash
java -jar target/taskTrackerCLI-0.0.1-SNAPSHOT.jar <command> [arguments]
```

To make it feel like a native console command, you can create a shortcut:

### Linux / macOS (bash, zsh)
```bash
echo 'alias task-cli="java -jar /absolute/path/to/target/taskTrackerCLI-0.0.1-SNAPSHOT.jar"' >> ~/.bashrc
source ~/.bashrc
```

### Windows (PowerShell)
```powershell
Set-Alias task-cli "java -jar C:\path\to\target\taskTrackerCLI-0.0.1-SNAPSHOT.jar"
```

Now you can use `task-cli` directly in your terminal.

---

## 🧩 Available Commands

### 🟢 Add a new task
```bash
task-cli add "Buy groceries"
```
**Output:**
```
✅ Task added successfully (ID: 1)
```

### 🟡 Update an existing task
```bash
task-cli update 1 "Buy groceries and cook dinner"
```

### 🔴 Delete a task
```bash
task-cli delete 1
```

### 🔁 Mark a task as in progress
```bash
task-cli mark-in-progress 1
```

### ✅ Mark a task as done
```bash
task-cli mark-done 1
```

### 📋 List all tasks
```bash
task-cli list
```

### 📋 List tasks by status
```bash
task-cli list todo
task-cli list in-progress
task-cli list done
```

---

## 📂 Storage

All tasks are automatically stored in:
```
task_data.json
```

If the file doesn’t exist, it’s created on the first run.

---

## 🧱 Tech Stack

- **Java 17+**
- **Maven** for build automation
- **Gson** for JSON serialization
- **Simple CLI parser** using enums (`Option`, `TaskStatus`)

---

## 🔧 Contributing

Pull requests are welcome!
If you’d like to add new features (like due dates or priorities), open an issue or fork the repo.

---

## 📜 License

This project is licensed under the **MIT License** — feel free to use and modify it.

---

## 📝 Additional Notes

This project was designed so anyone cloning the repository can build the package and run it directly as a CLI tool.

By following the **Build Instructions** and **Running the CLI** section above, the user will be able to execute commands without manually compiling Java every time.

Example usage:
```bash
task-cli add "Buy groceries"
task-cli list
task-cli mark-in-progress 1
task-cli list in-progress
task-cli delete 1
```

This makes it simple to track tasks directly from the command line without a separate GUI or complex setup.
