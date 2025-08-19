import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { HomeComp } from './app/home-comp/home-comp';

bootstrapApplication(App, appConfig)
  .catch((err) => console.error(err));
