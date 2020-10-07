import { Evenement } from './Evenement'

export class EventList {
  private readonly eventList: Evenement[] = []

  addEvent(event: Evenement) {
    if(this.eventList.length == 0) {
      this.eventList.push(event);
    }

    else{
      for(let i = 0; i < this.eventList.length; i++) {
        if(this.eventList[i].title.localeCompare(event.id) == 0) {
          return;
        }
      }
      this.eventList.push(event);
    }
  }

  getEvent(id: string): Evenement | undefined {
    let chosenEvent;

    if(this.eventList.length == 0) {
      return;
    }

    else
    {
      for(let i = 0; i < this.eventList.length; i++)
      {
        if(this.eventList[i].id.localeCompare(id) == 0)
          chosenEvent = this.eventList[i];
        return chosenEvent;
      }
    }
  }

  // getBooksOf(author: string): Book[]{
  //   let bookshelff = [];
  //
  //   for(let i = 0; i < this.bookshelf.length; i++) {
  //     if(this.bookshelf[i].author.localeCompare(author) == 0) {
  //       bookshelff.push(this.bookshelf[i]);
  //     }
  //   }
  //   return bookshelff;
  // }

  getAllEvents(): Evenement[] | undefined {
    return this.eventList.sort((bookA, bookB) => bookA.date_start.localeCompare(bookB.date_start));
  }

  getTotalNumberOfBooks() : number {
    return this.eventList.length;
  }
}