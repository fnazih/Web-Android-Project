import { EventDTO } from './EventDTO'
import "../../data.json"
import {DataSource} from "./DataSource";

export class EventList {
  static eventList: EventDTO[] = []

  static initList() {
    let data: DataSource[] = require("../../data.json")
    this.eventList = data.map((item) => {
      item.fields.id = item.recordid
      item.fields.fav = false
      return item.fields
    })
    let selected = this.eventList[0].category;
    this.eventList = this.eventList.filter(item => {
      return item.category === selected;
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