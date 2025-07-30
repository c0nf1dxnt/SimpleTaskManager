import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var manager = new TaskManager();
        var scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add a task");
            System.out.println("2. Mark as completed");
            System.out.println("3. Delete a task");
            System.out.println("4. Show task list");
            System.out.println("0. Exit");
            System.out.print("Choose an action: ");
            var input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.print("Enter task description: ");
                    var desc = scanner.nextLine();
                    manager.addTask(desc);
                    System.out.println("Task added.");
                    break;
                case "2":
                    System.out.print("Enter task ID to mark as completed: ");
                    var idToComplete = Integer.parseInt(scanner.nextLine());
                    if (manager.completeTask(idToComplete)) {
                        System.out.println("Task marked as completed.");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case "3":
                    System.out.print("Enter task ID to delete: ");
                    var idToDelete = Integer.parseInt(scanner.nextLine());
                    if (manager.deleteTask(idToDelete)) {
                        System.out.println("Task deleted.");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case "4":
                    System.out.println("\nTask list:");
                    for (var task : manager.getTasks()) {
                        System.out.println(task);
                    }
                    break;
                case "0":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
} 