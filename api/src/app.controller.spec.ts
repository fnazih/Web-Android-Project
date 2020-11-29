/**
 *@authors : Valentin POLLART - Fatima-Zohra NAZIH
 *@title : Events in Paris
 **/

import { Test, TestingModule } from '@nestjs/testing';
import { AppController } from './app.controller';
import { AppService } from './app.service';

/*
This file is a test file for the app controller, in order to check the validity
of the requests
 */
describe('AppController', () => {
  let appController: AppController;

  beforeEach(async () => {
    const app: TestingModule = await Test.createTestingModule({
      controllers: [AppController],
      providers: [AppService],
    }).compile();

    appController = app.get<AppController>(AppController);
  });
});
