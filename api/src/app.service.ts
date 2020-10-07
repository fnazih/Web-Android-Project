/*
  @authors : Valentin POLLART - Fatima-Zohra NAZIH
  @title :
 */

import { Injectable } from '@nestjs/common';
import { Evenement} from './Evenement';
//import { InjectModel } from '@nestjs/mongoose'

/*
This file contains the app service class, which implements every type of function
needed for the treatment of the data
*/
@Injectable()
export class AppService {
  private readonly eventList: Evenement[] = [];


}
