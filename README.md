# ismin-2020-project

This project contains an Android app as well as an API that collects an open source database of different kinds of events in Paris.

- The Kotlin/XML files for the Android app are located in the "android" directory :
  - ActivityMain.kt
  - Event.kt
  - EventActivity.kt
  - EventAdapter.kt
  - EventList.kt
  - EventService.kt
  - FavBody.kt
  - MyActivityCallback.kt
  - SubCategoryFragment.kt
  - WelcomeActivity.kt
  - onEventItemClickListener.kt
  
- The TypeScript files for the API are located in the "api" directory :
  - app.controller.spec.ts
  - app.controller.ts
  - app.module.ts
  - app.service.ts
  - main.ts
  - models directory :
    - BodyDTO.ts
    - DataSource.ts
    - Evenement.ts
    - EventDTO.ts
    - EventList.ts
    - EventSummary.ts

- The routes used by the API are the following :
  - \events\ : access to all of the events collected on the database
  - \events\id\ : access to a particular event on the list
  - \events\favs\ : access to all of the events kept by the user in their favorites

(URL : https://events-in-paris.cleverapps.io)


# Running the app

To run the app, you can open the "android" directory as a project on Android Studio, and run it on a virtual Android device, or directly on your Android smartphone by allowing the USB Debugger configuration in the Android Developers settings.


The activity is available in both English and French, but the events content will remain in French, due to the database language unicity.

In the app, you have access to the whole event list, where you can like/unlike events to keep them in the favorites tab ("Favorites" button on the right bottom). You can also click on an event to see more details, such as its description, location, and date.



# Credits :
NAZIH Fatima-Zohra | POLLART Valentin
