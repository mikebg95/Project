Problem statement

The problem is a lack of a single simple, user-friendly workout app that lets the user set their own goals, design their own workout routine and set a personal diet based on the user's physical characteristics and goals. 

The target audience of this app is people that workout regularly and seriously, and want one single app thats keep track of their progress, as well as an app that generates simple recipes based on their progress and goals.


Solution
This app serves as a workout planner and notebook, keeps track of the users goals and progress, and provides the user with recipes based on their goals and physical characteristics.

Within the app it is possible to browse through a database of exercises (with filters such as equipment, intensity, muscle group etc.) and add these to a workout routine, as well as setting the amount of sets, repetitions and rest in between sets. It is also possible for the user to set a weekly workout schedule. The user can also browse through previous workouts that they have completed. Within the routine/schedule it is possible to replace exercises with similar exercises (based on muscle group) from the database.

The user can also set their own goals (weight gain/loss), which is kept track of and visualised by way of a graph. Based on physical characteristics and goals, the app calculates the needed daily amount of calories, and, based on this amount as well as amount of protein, fat, carbs etc., and number of meals per day, can browse through a database of recipes and find suitable recipes for the user. Again, there are filters (such as ingredients, cooking equipment, time needed). The user can then add recipes to their list of "favorite recipes". 

In short, this app serves as a workout planner and notebook, keeps track of the users goals and progress, and provides the user with recipes based on their goals and physical characteristics.


Main features
- User-friendly workout planner (connected to API of workout exercises) that keeps track of weight, sets, reps, etc.
- Possible to view previous workouts; app keeps track of progress within individual workouts.
- Personal workout notebook that keeps track of weight, goals etc. and presents this to the user (in a graph).
- Caloric intake calculator, based on physical characteristics and goals.
- Recipe-generator, based on calculated personal caloric intake and API of recipes.

Minimum Viable Product
- The app lets the user look up exercises, and add these to create workouts. It keeps track of previous workouts and progress of the user. 
- The app serves as a workout planner for the user, letting the user create weekly workouts and check these workouts off.
- The app keeps track of the users weight and progress.
- The app calculates the users caloric intake, and looks up recipes according to the caloric intake and the number of meals the user wishes to eat in a day. 


Optional parts to implement
- The app presents the users progress and goals in a pretty-looking graph. 
- The "current workout" can serve as a "electronic personal trainer", timing the rest time in between sets (and alerting the user when the rest time is finished) and letting the user check off sets when they are finished.
- Within workouts the user has the option to replace certain exercises with "similar exercises" (which are searched for in the API) for the same muscle mass.
- While searching within the API's (both for the exercises as well as the recipes), the user can filter out based on equipment, level of difficulty, and muscle groups (for the exercises API), and ingredients, cooking equipment and time spent (for the recipes API).
- The user can create a profile in the app with the user's characteristics (height, age, etc.), weight, and previous workouts.
- The user can save certain recipes to their "favorite recipes" and can easily review these.


Data sources
Recipes API:
https://spoonacular.com/

Workout exercises API:
https://developers.google.com/android/reference/com/google/android/gms/fitness/data/WorkoutExercises
https://wger.de/en/software/api

Similar apps
Many health apps either focus specifically on the user's personal progress (like FitBit); others focus solely on workout exercises (like FitPlan and Sworkit). Most fitness apps are solely focused on exercises, while most diet apps are solely focused on recipes (getFit: . This app tries to connect these two, just as they are connected in the non-technological world.

Hardest parts
The hardest part is most likely the fact that there are many screens and options in this app, and they must all be connected in a workable way. Keeping track of the users progress, and searching through the API's will most likely be the hardest part of this application.
