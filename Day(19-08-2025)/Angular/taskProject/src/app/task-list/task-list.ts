import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Task } from "../task/task";
import { ITask } from '../itask';

@Component({
  selector: 'app-task-list',
  imports: [],
  templateUrl: './task-list.html',
  styleUrl: './task-list.css'
})
export class TaskList {
   @Input() tasks: ITask[] = [];

   @Output() deleteTask = new EventEmitter<number>();

  onDeleteTask(id: number) {
    this.deleteTask.emit(id);
  }
}

