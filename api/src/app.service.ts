/**
 *@authors : Valentin POLLART - Fatima-Zohra NAZIH
 *@title : Events in Paris
 **/

import {Injectable} from '@nestjs/common';
import {EventSummary} from "./models/EventSummary";
import {EventList} from "./models/EventList";
import {EventDTO} from "./models/EventDTO";

/*
This file contains the app service class, which implements every type of function
needed for the treatment of the data
*/
@Injectable()
export class AppService {
  async list(): Promise<EventDTO[]> {
    return EventList.getAllEvents()
  }

  async listFav(): Promise<EventDTO[]> {
    return EventList.getAllEvents().filter(item => item.fav === true)
  }

  async get(id: string): Promise<EventDTO> {
    return EventList.getEvent(id);
  }

  async fav(id: string, fav: boolean): Promise<EventDTO> {
    return EventList.setFav(id, fav);
  }
}
