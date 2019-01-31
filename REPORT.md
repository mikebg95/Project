*************************************************
VIDEO DEMONSTRATION: https://youtu.be/5rMDeys4kk4
*************************************************

Description

The app allows the user to find exercises (through an online api source), and add these exercises to the list of favorite exercises, which can then be viewed.
It is also possible for the user to create a new workout, and insert the exercise, the amounts of sets, reps and kg's. These workouts can be viewed, edited and deleted.

![Screenshot](https://github.com/mikebg95/Project/blob/master/doc/screenshot.jpg)


Technical Design

![Technical Design](https://github.com/mikebg95/Project/blob/master/doc/REPORT.png)

Custom classes used:

- Exercise
   - name
   - muscles
   - secondary muscles
   - equipment
   - description

- WorkoutExercise
   - Exercise
   - set1, set2, set3, set4, set5 (number of reps)
   - rest (number of seconds rest)
   - kg1, kg2, kg3, kg4, kg5 (amount of kg's per set)
   
- Workout
   - WorkoutExercises (ArrayList)
   - workout day
   - muscle group(s)
   - comment
   - date
   
   
   Custom Adapter used:
   - ExerciseAdapter
   - WorkoutExerciseAdapter
   - WorkoutAdapter 
   
  
Challenges

By far the biggest challenge that I've faced was the fact that I completely underestimated making such a (relatively) large app.
Seeing how we've made multiple (smaller) apps in the weeks prior to this project, I assumed I would not take too much time to make a larger app.
For this reason I planned on doing way too many things, and ended up having to give up on a lot of functionality I was planning to add in the beginning. 
One of the first things I decided to leave out was the tracker, that keeps track of personal information (weight, height, etc.) and of the personal goal(s), and presents this in a nice graph. 
Around the same time I also realized I was not gonna be able to add graphs for each single workout either. I ended up with the Workouts, Exercises and a Personal Profile.
However, without the graphs displaying the information and progress to the user, it seemed useless to have an Activity showing the user's personal information (especially since I realized I wasn't gonna be able to add an account functionality).
I ended up with the Exercises functionality (which lets a user search, view and save exercises), and the Workout functionality (where the user can create, save, view and edit workouts). 
To be quite honest, I am kind of disappointed in myself, as I had expected to be able to present a better app at the end of the period. However, I have learned ALOT from this project (mainly, to not underestimate a project like this), and have gained alot of usefull skills and knowledge for future apps!


Defending my decisions

Overall, I think I made a good decision to focus solely on the Exercise and Workout functionality. I believe that if I hadn't done this, I would not have been able to finish the app in time.
I also believe this functionality was the most crucial to the app, and the app is still very useful without all the functionality I decided to leave out. However, vice versa this would not have been the case.
Therefore I believe I made a good decision in leaving out the things I left out. Although the app could certainly use some more time to perfect, I believe it is a useful and user-friendly app, that I will probably use myself.
If I had had more time, I would definitely like to add some functionality that, per individual exercise, presents the user with a graph, showing progress/regress. However, given the time that we had to finish this project, I believe it was a good choice to leave this functionality out, as I probably wouldn't have finished the project on time otherwise.
