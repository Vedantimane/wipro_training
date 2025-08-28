import { ChangeDetectorRef, Component } from '@angular/core';
import { UserLoginService } from '../../services/user-login-service';
import { User } from '../../interface/user';
import { Router, RouterLink } from '@angular/router';
import { TokenData } from '../../interface/token-data';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  imports: [FormsModule, CommonModule,RouterLink],
  templateUrl: './login.html',
  styleUrls: ['./login.css']
})
export class Login {

  constructor(private router:Router,
    private userService: UserLoginService,
    private cdr: ChangeDetectorRef
    
  ){}

  user = {
    userEmail:'',
    passWord:'',
    userName:''
  }

  users:User[]=[]

  jwtToken : TokenData={token:''} 

  ngOnInit(){
    this.userService.getUser().subscribe((user)=>{
      this.cdr.detectChanges();
      this.users = user;
    })
  }

  login(){
    console.log("inside login ")
    this.userService.login(this.user).subscribe((token)=>{
      this.jwtToken = token;
      // console.log("jwt token is", this.jwtToken)
      localStorage.setItem('tokenValue', this.jwtToken.token)
      // console.log("jwt token is", this.jwtToken)
      this.router.navigate(['/foodList'])
    }, (error)=>{
      console.log("error while sign in ", error)
    }
  )
  }
}