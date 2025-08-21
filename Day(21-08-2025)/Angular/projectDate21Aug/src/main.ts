import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { Vehicle } from './app/vehicle/vehicle';

bootstrapApplication(App, appConfig)
  .catch((err) => console.error(err));
