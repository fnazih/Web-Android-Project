/*
  @authors : Valentin POLLART - Fatima-Zohra NAZIH
  @title :
 */

import { Controller, Get } from '@nestjs/common';
import { AppService } from './app.service';

//This file contains the app controller that controls every type of requests and treats them
@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  getHello(): string {
    return this.appService.getHello();
  }
}
