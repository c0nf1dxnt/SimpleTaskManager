import java.util.*;
import java.io.*;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private int nextId = 1;
    private static final String FILE_NAME = "tasks.txt";

    public TaskManager() {
        loadTasks();
    }

    public void addTask(String description) {
        tasks.add(new Task(nextId++, description));
        saveTasks();
    }

    public boolean completeTask(int id) {
        for (var task : tasks) {
            if (task.getId() == id) {
                task.setCompleted(true);
                saveTasks();
                return true;
            }
        }
        return false;
    }

    public boolean deleteTask(int id) {
        var it = tasks.iterator();
        while (it.hasNext()) {
            var task = it.next();
            if (task.getId() == id) {
                it.remove();
                saveTasks();
                return true;
            }
        }
        return false;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    private void saveTasks() {
        try (var pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (var task : tasks) {
                pw.println(task.getId() + "|" + task.getDescription() + "|" + task.isCompleted());
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    private void loadTasks() {
        var file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (var br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                var parts = line.split("\\|");
                if (parts.length == 3) {
                    var id = Integer.parseInt(parts[0]);
                    var desc = parts[1];
                    var completed = Boolean.parseBoolean(parts[2]);
                    var task = new Task(id, desc);
                    task.setCompleted(completed);
                    tasks.add(task);
                    if (id >= nextId) nextId = id + 1;
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }
} 