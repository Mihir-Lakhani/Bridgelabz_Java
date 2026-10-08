/*
3. Circular Linked List: Task Scheduler
Each task contains Task ID, Task Name, Priority, and Due Date.
Operations:
1. Add a task at the beginning, end, or a specific position.
2. Remove a task by Task ID.
3. View the current task and move to the next task.
4. Display all tasks starting from head.
5. Search for tasks by Priority.
Hint: The last node's next pointer must point back to head.
Positions are zero-based; moving past the last task returns to the first.
 */

package Java_LinkedLists.PracticeProblems.CircularLinkedList;

public class TaskScheduler {

    private class Task {
        private final String taskId;
        private final String name;
        private final int priority;
        private final String dueDate;
        private Task next;

        Task(String taskId, String name, int priority, String dueDate) {
            this.taskId = taskId;
            this.name = name;
            this.priority = priority;
            this.dueDate = dueDate;
        }

        void displayTask() {
            System.out.printf("ID: %s | Task: %s | Priority: %d | Due Date: %s%n",
                    taskId, name, priority, dueDate);
        }
    }

    private Task head;
    private Task tail;
    private Task currentTask;
    private int size;

    private Task findById(String taskId) {
        if (head == null) return null;
        Task current = head;
        do {
            if (current.taskId.equals(taskId)) return current;
            current = current.next;
        } while (current != head);
        return null;
    }

    private boolean validTask(String taskId, String name, String dueDate) {
        if (taskId == null || taskId.isBlank() || name == null || name.isBlank()
                || dueDate == null || dueDate.isBlank()) {
            System.out.println("Task ID, name, and due date cannot be empty");
            return false;
        }
        if (findById(taskId) != null) {
            System.out.println("Task ID already exists: " + taskId);
            return false;
        }
        return true;
    }

    void addBeginning(String taskId, String name, int priority, String dueDate) {
        if (!validTask(taskId, name, dueDate)) return;
        Task newTask = new Task(taskId, name, priority, dueDate);
        if (head == null) {
            head = tail = currentTask = newTask;
            newTask.next = newTask;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
        size++;
    }

    void addEnd(String taskId, String name, int priority, String dueDate) {
        if (!validTask(taskId, name, dueDate)) return;
        Task newTask = new Task(taskId, name, priority, dueDate);
        if (head == null) {
            head = tail = currentTask = newTask;
            newTask.next = newTask;
        } else {
            newTask.next = head;
            tail.next = newTask;
            tail = newTask;
        }
        size++;
    }

    // Insert AT index: 0 = beginning, size = end.
    void addMid(String taskId, String name, int priority, String dueDate, int index) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            addBeginning(taskId, name, priority, dueDate);
            return;
        }
        if (index == size) {
            addEnd(taskId, name, priority, dueDate);
            return;
        }
        if (!validTask(taskId, name, dueDate)) return;
        Task current = head;
        for (int i = 0; i < index - 1; i++) current = current.next;
        Task newTask = new Task(taskId, name, priority, dueDate);
        newTask.next = current.next;
        current.next = newTask;
        size++;
    }

    void remove(String taskId) {
        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }
        Task previous = tail;
        Task current = head;
        do {
            if (current.taskId.equals(taskId)) {
                if (size == 1) {
                    head = tail = currentTask = null;
                } else {
                    previous.next = current.next;
                    if (current == head) head = current.next;
                    if (current == tail) tail = previous;
                    if (current == currentTask) currentTask = current.next;
                    tail.next = head;
                }
                current.next = null;
                size--;
                System.out.println("Removed task: " + taskId);
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
        System.out.println("Task not found: " + taskId);
    }

    void viewCurrentTask() {
        if (currentTask == null) {
            System.out.println("No current task");
        } else {
            currentTask.displayTask();
        }
    }

    void moveToNextTask() {
        if (currentTask == null) {
            System.out.println("Task list is empty");
            return;
        }
        currentTask = currentTask.next;
        viewCurrentTask();
    }

    void displayAll() {
        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }
        Task current = head;
        do {
            current.displayTask();
            current = current.next;
        } while (current != head);
    }

    void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }
        Task current = head;
        boolean found = false;
        do {
            if (current.priority == priority) {
                current.displayTask();
                found = true;
            }
            current = current.next;
        } while (current != head);
        if (!found) System.out.println("No tasks found with priority: " + priority);
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addEnd("T101", "Revise linked lists", 1, "2026-10-09");
        scheduler.addBeginning("T102", "Submit assignment", 1, "2026-10-08");
        scheduler.addEnd("T103", "Practice Java", 2, "2026-10-10");
        scheduler.addMid("T104", "Review OOP", 2, "2026-10-09", 1);

        System.out.println("=== All Tasks ===");
        scheduler.displayAll();
        System.out.println("\n=== Current Task ===");
        scheduler.viewCurrentTask();
        System.out.println("\n=== Move Through Tasks (Wraps Around) ===");
        for (int i = 0; i < 5; i++) scheduler.moveToNextTask();
        System.out.println("\n=== Tasks with Priority 1 ===");
        scheduler.searchByPriority(1);
        System.out.println("\n=== Remove First and Last Tasks ===");
        scheduler.remove("T102");
        scheduler.remove("T103");
        scheduler.displayAll();
        System.out.println("\n=== Current Task After Removal ===");
        scheduler.viewCurrentTask();
        scheduler.remove("T999");
    }
}
