/*
  @authors : Valentin POLLART - Fatima-Zohra NAZIH
  @title :
 */

import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';

//This file represents the module file. It links the data, the controllers and the providers
@Module({
  imports: [],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
