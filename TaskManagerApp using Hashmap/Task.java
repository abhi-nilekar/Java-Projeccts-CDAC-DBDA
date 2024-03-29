package core;

import java.time.LocalDate;
import java.util.UUID;

public class Task{
	
	private String taskId;
	private String taskName;
	private String description;
	private LocalDate taskDate;
	private TaskStatus status;
	boolean active;
	
	// creating enum to show task status
	public enum TaskStatus{
	PENDING, 
	IN_PROGRESS,
	COMPLETED
}

	//constructor, getters and setters
	public Task(String taskName, String description, LocalDate taskDate) {
		super();
		this.taskId = UUID.randomUUID().toString().substring(0, 6);
		this.taskName = taskName;
		this.description = description;
		this.taskDate = taskDate;
		this.status = status.PENDING;
		this.active = true;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "TaskManager [taskId=" + taskId + ", taskName=" + taskName + ", description=" + description
				+ ", taskDate=" + taskDate + ", status=" + status + ", active=" + active + "]";
	}
	
	//methods to work with status
	public void markAsInProgress() {
		this.status=TaskStatus.IN_PROGRESS;
	}
	public void markAsCompleted() {
		this.status=TaskStatus.COMPLETED;
	}
	public void markAsPending() {
		this.status=TaskStatus.PENDING;
	}

	//method to delete the task => but we just want to make its status as false
	public void deleteTask() {
		this.active=false;
	}
	
}
