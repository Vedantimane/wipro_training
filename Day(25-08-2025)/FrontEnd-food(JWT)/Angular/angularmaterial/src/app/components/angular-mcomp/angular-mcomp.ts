
import {MatListModule} from '@angular/material/list';
import {Component, inject} from '@angular/core';
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatStepperModule} from '@angular/material/stepper';

@Component({
  selector: 'app-angular-mcomp',
  imports: [MatListModule, MatStepperModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,],
  templateUrl: './angular-mcomp.html',
  styleUrl: './angular-mcomp.css'
})
export class AngularMComp {

  cities:string[]=["mumbai", "pune","delhi","chennai","Solapur","Kolhapur"];
  private _formBuilder = inject(FormBuilder);

  firstFormGroup: FormGroup = this._formBuilder.group({firstCtrl: ['']});
  secondFormGroup: FormGroup = this._formBuilder.group({secondCtrl: ['']});
   thirdFormGroup: FormGroup = this._formBuilder.group({thirdCtrl: ['']});

}
