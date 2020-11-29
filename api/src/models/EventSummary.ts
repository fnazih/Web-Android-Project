export class EventSummary {
    id: string;
    title: string;
    fav?: boolean;
    img_url: string;
    date_start: string;

    constructor(id: string, title: string, img_url: string,date_start: string, fav?: boolean) {
        this.id = id;
        this.title = title;
        this.img_url = img_url;
        this.date_start = date_start;
        this.fav = fav??false;
    }
}