/**
  *@authors : Valentin POLLART - Fatima-Zohra NAZIH
  *@title : Events in Paris
 **/

import {Body, Controller, Get, Param, Put} from '@nestjs/common';
import { AppService } from './app.service';
import {EventSummary} from "./models/EventSummary";
import {EventDTO} from "./models/EventDTO";
import {BodyDTO} from "./models/BodyDTO";

//This file contains the app controller that controls every type of requests and treats them
@Controller('/events')
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  async list(): Promise<EventDTO[]> {
    return await this.appService.list()
  }

  @Get('favs')
  async Fav(): Promise<EventDTO[]> {
    return await this.appService.listFav()
  }

  @Get(':id')
  async get(@Param('id') id: string): Promise<EventDTO> {
    return this.appService.get(id);
  }

  @Put(':id')
  async fav(@Param('id') id: string, @Body() body: BodyDTO): Promise<EventDTO> {
    return await this.appService.fav(id, body.fav)
  }
}
