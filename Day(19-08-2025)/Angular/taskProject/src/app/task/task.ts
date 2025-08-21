import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ITask } from '../itask';

@Component({
  selector: 'app-task',
  imports: [],
  templateUrl: './task.html',
  styleUrl: './task.css'
})
export class Task {
 @Output() taskAdded = new EventEmitter<ITask>();

  private nextId = 1; 

  addTask(desc: string, cat: string) {
    if (!desc || !cat) return;

    const newTask: ITask = {
      taskId: this.nextId++,
      taskDescription: desc,
      taskCategory: cat
    };

    this.taskAdded.emit(newTask); 
  }
}