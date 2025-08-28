import { ChangeDetectionStrategy, Component, signal } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { provideNativeDateAdapter } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatSelectModule } from '@angular/material/select';
import { MatCardModule } from '@angular/material/card';
import { merge } from 'rxjs';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';


@Component({
  selector: 'app-reactiveform2',
providers: [provideNativeDateAdapter()],
  imports: [
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatDatepickerModule,
    MatSelectModule,
    MatCardModule
  ],
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './reactiveform2.html',
  styleUrl: './reactiveform2.css'
})
export class Reactiveform2 {
readonly form: FormGroup;

constructor(private fb: FormBuilder) {
  this.form = this.fb.group({
    name: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    dateofbirth: [''],
    option: ['']
  });
}

onSubmit() {
  if (this.form.valid) {
    console.log('Form Values:', this.form.value);
  } else {
    console.warn('Form is invalid. Please correct errors.');
    this.form.markAllAsTouched();
  }
}

}