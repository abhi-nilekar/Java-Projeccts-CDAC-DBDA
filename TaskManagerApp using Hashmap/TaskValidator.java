package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import core.Task;
import core.Task.TaskStatus;

public class TaskValidator {
	
	//populate the taskManager map with initial data
	public static void populateMap(Map<String, Task> taskManager) {
		taskManager.put("1", new Task("study","complete the assignment",LocalDate.parse("2024-01-01")));
		taskManager.put("2", new Task("sports","go for badminton",LocalDate.parse("2024-02-12")));
		taskManager.put("3", new Task("social media","surf social media",LocalDate.parse("2023-12-01")));
		taskManager.put("4", new Task("study","prepare for the exam",LocalDate.parse("2024-03-29")));
		taskManager.put("5", new Task("reading","read a good book",LocalDate.parse("2024-01-01")));
	}
	
	//case 1: to create a new task
	public static void addNewTask(Map<String, Task> taskManager) {
		
		System.out.println("Enter task details : Name, Description, task date : ");
		Scanner sc=new Scanner(System.in);
        String name = sc.nextLine();
        String description = sc.nextLine();
        LocalDate date = LocalDate.parse(sc.nextLine());
        Task task = new Task(name, description, date);
        taskManager.put(task.getTaskId(), task);
        System.out.println("New task added Successfully !!!");
	}
	
	//case 2 : to delete a task
	public static void deleteTask(Map<String, Task> taskManager) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter task name to delete : ");
        String taskName = sc.nextLine();
        Task task = taskManager.get(taskName);
        if(task != null) {
            task.deleteTask();
            System.out.println("Task deleted successfully !!!");
        } else {
            System.out.println("Task not found !!!");
        }
	}
	
	//method for case 3 : to update the task status
	public static void updateStatus(Map<String, Task> taskManager) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter Task ID to update the status");
            String taskID = sc.nextLine();

            Task task = taskManager.get(taskID);
            if (task != null) {
                System.out.println("Choose new status : 1.PENDING 2.IN PROGRESS 3.COMPLETED");
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline character after reading the integer

                switch (choice) {
                    case 1:
                        task.markAsPending();
                        break;
                    case 2:
                        task.markAsInProgress();
                        break;
                    case 3:
                        task.markAsCompleted();
                        break;
                    default:
                        System.out.println("Invalid choice !!!");
                }
            } else {
                System.out.println("Task not found");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
 
	//case 4 : to display all pending tasks
	public static void displayPendingTasks(Map<String, Task> taskManager) {
		System.out.println("All pending tasks : ");
		taskManager.values()
		.stream()
		.filter(t->t.getStatus().equals(TaskStatus.PENDING))
		.forEach(tsk->System.out.println(tsk));
	}
	
	//case 5 : display all tasks pending for today
	public static void displayTodaysPendingTasks(Map<String, Task> taskManager) {
		System.out.println("Todays pending tasks : ");
    	taskManager.values().stream()
    	.filter(t->t.getStatus().equals(TaskStatus.PENDING))
    	.filter(td->td.getTaskDate().equals(LocalDate.now()))
    	.forEach(tsk->System.out.println(tsk));
	}

	//case 6 : Display all tasks sorted by taskDate
	public static void sortTasksByDate(Map<String, Task> taskManager) {
		System.out.println("All tasks sorted by task date");
		List<Task> sortedTasks = new ArrayList<>(taskManager.values());
		Collections.sort(sortedTasks, (task1,task2)-> task1.getTaskDate().compareTo(task2.getTaskDate()));
		for(Task tsk: sortedTasks) {
			System.out.println(tsk);
		}
		
	}
}
