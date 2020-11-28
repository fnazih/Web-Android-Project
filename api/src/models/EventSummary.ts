export class EventSummary {
    id: string;
    title: string;
    fav?: boolean;

    constructor(id: string, title: string, fav?: boolean) {
        this.id = id;
        this.title = title;
        this.fav = fav??false;
    }
}