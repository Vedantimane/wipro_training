import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Task } from "../task/task";
import { ITask } from '../itask';
import { TaskList } from "../task-list/task-list";

@Component({
  selector: 'app-home',
  imports: [Task, TaskList],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {
 tasks: ITask[] = [];

  addTask(task: ITask) {
    this.tasks.push(task);
  }

  deleteTask(taskId: number) {
  this.tasks = this.tasks.filter(task => task.taskId !== taskId);
}

}