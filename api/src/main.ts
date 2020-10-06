/*
  @authors : Valentin POLLART - Fatima-Zohra NAZIH
  @title :
 */

import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';

//This file represents the main file, which runs all of the API
async function bootstrap() {
  const app = await NestFactory.create(AppModule);
  await app.listen(3000);
}
bootstrap();
