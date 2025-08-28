import { ChangeDetectorRef, Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { UserLoginService } from '../../services/user-login-service';
import { User } from '../../interface/user';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-user-register',
  imports: [RouterLink, FormsModule],
  templateUrl: './user-register.html',
  styleUrl: './user-register.css'
})
export class UserRegister {

  constructor(private router: Router,
    private userService: UserLoginService,
    private cdr: ChangeDetectorRef
  ){}

  newUser:User={
    userName:'',
    userEmail: '',
    passWord:''
  }

  repeatPassword:string=''

  ngOnInit(){
    this.cdr.detectChanges()
  }

  register(){
    if(this.repeatPassword!= this.newUser.passWord){
      alert("Passwords don't match...")
    }else{
      this.userService.createUser(this.newUser).subscribe(()=>{
        this.router.navigate(['/login'])
  })
    }
 
  }

}