// Task Class
class Task {
    int taskId;
    String taskName;
    String status;
    
    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Task [ID=" + taskId + ", Name=" + taskName + ", Status=" + status + "]";
    }
}

// Node Class
class Node {
    Task task;
    Node next;
    
    Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

// TaskLinkedList Class
class TaskLinkedList {
    private Node head;

    // Add task to the end of the list
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Search for a task by taskId
    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse and print all tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete a task by taskId
    public boolean deleteTask(int taskId) {
        if (head == null) return false;

        if (head.task.taskId == taskId) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.task.taskId == taskId) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

// Main Class
public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();
        
        // Add tasks
        taskList.addTask(new Task(1, "Task 1", "Pending"));
        taskList.addTask(new Task(2, "Task 2", "Completed"));
        taskList.addTask(new Task(3, "Task 3", "In Progress"));
        
        // Traverse tasks
        System.out.println("Traversing all tasks:");
        taskList.traverseTasks();
        
        // Search task
        System.out.println("\nSearching for task with ID 2:");
        Task task = taskList.searchTask(2);
        if (task != null) {
            System.out.println("Found: " + task);
        } else {
            System.out.println("Task not found.");
        }
        
        // Delete task
        System.out.println("\nDeleting task with ID 1:");
        if (taskList.deleteTask(1)) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task deletion failed.");
        }
        
        // Traverse tasks again
        System.out.println("\nTraversing all tasks after deletion:");
        taskList.traverseTasks();
    }
}
