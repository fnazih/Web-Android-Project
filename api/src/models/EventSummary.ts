export class EventSummary {
    id: string;
    title: string;
    fav?: boolean;
    cover_url: string;
    date_start: string;
    category: string;

    constructor(id: string, title: string, cover_url: string,date_start: string,category: string, fav?: boolean) {
        this.id = id;
        this.title = title;
        this.cover_url = cover_url;
        this.date_start = date_start;
        this.category = category;
        this.fav = fav??false;
    }
}