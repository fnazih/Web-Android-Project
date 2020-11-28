/*
  @authors : Valentin POLLART - Fatima-Zohra NAZIH
  @title :
 */

import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';
import {EventList} from "./models/EventList";

//This file represents the main file, which runs all of the API
async function bootstrap() {
  const app = await NestFactory.create(AppModule);
  const port = process.env.PORT;
  await app.listen(port??3000);
  EventList.initList()
}
bootstrap();
