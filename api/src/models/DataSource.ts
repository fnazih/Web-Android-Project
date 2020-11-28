import {EventDTO} from "./EventDTO";

export interface DataSource {
    datasetid: string;
    recordid: string;
    fields: EventDTO;
}