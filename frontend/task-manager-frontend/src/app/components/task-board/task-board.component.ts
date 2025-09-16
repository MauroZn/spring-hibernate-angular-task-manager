import { Component, OnInit } from '@angular/core';
import { Task } from '../../models/task.model';
import { TaskService } from '../../services/task.service';
import {TaskStatus} from "../../models/task-status.enum";

@Component({
  selector: 'app-task-board',
  templateUrl: './task-board.component.html',
  styleUrls: ['./task-board.component.css']
})
export class TaskBoardComponent implements OnInit {

  tasks: Task[] = [];

  newTask: Partial<Task> = { title: '', description: '', status: TaskStatus.PENDING };
  taskStatuses = Object.values(TaskStatus);

  constructor(private taskService: TaskService) {}

  ngOnInit(): void {
    this.loadTasks();
  }

  loadTasks() {
    this.taskService.getTasks().subscribe({
      next: (data) => this.tasks = data,
      error: (err) => console.error(err)
    });
  }

  getTasksByStatus(status: string): Task[] {
    return this.tasks.filter(task => task.status === status);
  }

  createTask() {
    this.taskService.createTask(this.newTask as Task).subscribe({
      next: (task) => {
        this.tasks.push(task);
        this.newTask = { title: '', description: '', status: TaskStatus.PENDING };
      },
      error: (err) => console.error(err)
    });
  }

  updateTask(task: Task) {
    if (!task.id) return;
    this.taskService.updateTask(task.id, task).subscribe({
      next: (updatedTask) => {
        const index = this.tasks.findIndex(t => t.id === updatedTask.id);
        if (index > -1) {
          this.tasks[index] = updatedTask;
        }
      },
      error: (err) => console.error(err)
    });
  }

  confirmDelete(task: Task) {
    const confirmed = confirm(`Are you sure you want to delete the task "${task.title}"?`);
    if (confirmed) {
      this.deleteTask(task);
    }
  }

  deleteTask(task: Task) {
    if (!task.id) return;
    this.taskService.deleteTask(task.id).subscribe({
      next: () => {
        this.tasks = this.tasks.filter(t => t.id !== task.id);
      },
      error: (err) => console.error(err)
    });
  }


}
