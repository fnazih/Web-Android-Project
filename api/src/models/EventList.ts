import { EventDTO } from './EventDTO'
import "../../data.json"
import {DataSource} from "./DataSource";

export class EventList {
  static eventList: EventDTO[] = []

  static initList() {
    let data: DataSource[] = require("../../data.json")
    this.eventList = data.map((item) => {
      item.fields.id = item.recordid
      return item.fields
    })

  }

  static addEvent(event: EventDTO) {
    if(this.eventList.some(element => element.id === event.id)) {
      return;
    }
    this.eventList.push(event);
  }

  static getEvent(id: string): EventDTO | undefined {
    return this.eventList.find(element => element.id === id)
  }

  static getAllEvents(): EventDTO[] | undefined {
    let num = 0;
    return this.eventList;
  }

  static getTotalNumberOfEvents() : number {
    return this.eventList.length;
  }

  static setFav(id: string, fav: boolean): EventDTO|undefined {
    let index = this.eventList.findIndex(item => item.id === id);
    this.eventList[index].fav = fav;
    return this.eventList[index];
  }
}