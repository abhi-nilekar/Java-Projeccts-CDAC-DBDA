package core;

import java.time.LocalDate;
import utils.TaskValidator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import core.Task.TaskStatus;

public class TestTaskManager {

    public static void main(String[] args) {

        Map<String, Task> taskManager = new HashMap<>();
        boolean exit = false;

        try (Scanner sc = new Scanner(System.in)) {

            while (!exit) {
                try {
                    System.out.println(
                            "Enter your choice : \n" 
                            + "1. Add a new task \n" 
                            + "2. Delete a task \n" 
                            + "3. Update task status \n" 
                            + "4. Display all pending tasks \n" 
                            + "5. Display all pending tasks today \n"
                            + "6. Display all tasks sorted by taskDate \n"
                            + "7. Display all task details \n"
                            + "0. Exit");

                    int choice = sc.nextInt();
                    sc.nextLine(); // consume newline left-over
                    
                    //populate map with initial data
                    TaskValidator.populateMap(taskManager);
                    
                    switch (choice) {
                        case 1: {
                            TaskValidator.addNewTask(taskManager);
                            break;
                        }
                        case 2:
                        	TaskValidator.deleteTask(taskManager);
                            break;
                        case 3:
                            TaskValidator.updateStatus(taskManager);
                            break;
                        case 4:
                        	TaskValidator.displayPendingTasks(taskManager);
                        	break;
                        case 5:
                        	TaskValidator.displayTodaysPendingTasks(taskManager);
                        	break;
                        case 6:
                        	TaskValidator.sortTasksByDate(taskManager);
                        	break;
                        case 7:
                            taskManager.values().forEach(t->System.out.println(t));
                            break;
                        case 0:
                        	System.out.println("Exiting the program !!!");
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid choice, please try again.");
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
