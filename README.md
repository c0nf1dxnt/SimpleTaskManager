# TaskManager

A simple Java console application for managing a to-do list.

## Features

- Add a new task
- Mark a task as completed by id
- Delete a task by id
- View all tasks (completed tasks are marked)
- Tasks are saved between sessions (in the `tasks.txt` file)

## Project Structure

- `src/Task.java` — Task class (id, description, status)
- `src/TaskManager.java` — Task management, file operations
- `src/Main.java` — Console user interface

## How to Run

1. Compile all files:
    ```sh
    javac src/*.java
    ```
2. Run the application:
    ```sh
    java -cp src Main
    ```

## Requirements

- Java 10 or newer
