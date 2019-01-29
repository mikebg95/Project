
Week 1:

Dag 1: introductiecollege bijgewoond en project voorstel doorgenomen.

Dag 2: Design document gemaakt en ingeleverd.

Dag 3: Begonnen aan prototype voor app

Dag 4: Prototype uitgewerkt en ingeleverd

Dag 5: Voornamelijk bezig geweest met juiste API’s zoeken (de mijne bleek te ingewikkeld te zijn om te gebruiken)

Dag 7: API omgezet tot bruikbare json-link, begonnen met code schrijven voor de json request.

Week 2:

Dag 1: API request volledig afgemaakt. Moest gefilterd worden, sommigen waren in het Duits; anderen hadden geen naam of waren niet volledig. 
	Exercise class gemaakt en data ingeladen tot Exercise objecten.
	ExercisesAdapter gemaakt en arraylist met exercise objecten gelinkt aan listview. Probleem hierbij was dat de equipment en (secundaire) spiergroepen aangegeven waren met een cijfer, waarbij een ander jsonbestand deze cijfers linkte aan de juiste namen. Omdat het in totaal maar ongeveer 25 key sets(?) waren, heb ik dit met de hand gedaan. Ik heb de twee functies getMuscles() en getEquipment() geschreven die deze info corrigeert en tot een string omzet die direct op de textView geprint kan worden.

Dag 2: 
	EditInfoActivity meer uitgewerkt: het is nu mogelijk om deze info te editen. Ik heb hiervoor een aparte activiteit, EditInfoActivity, geschreven. Ik heb een PopUpActivity geschreven, die wordt gestart als er door de gebruiker op een oefening wordt gedrukt. Een Pop-up scherm verschijnt met daarop meer informatie over de oefening.
	
Dag 3:
	Ik heb een optie toegevoegd om gevonden oefeningen aan een map met favoriete/opgeslagen oefeningen toe te voegen. Deze kunnen vervolgens via een andere button bekeken worden. Ook kunnen oefeningen weer uit deze map verwijderd worden. Hiervoor heb ik een public static variabele gemaakt die over meerdere activities kan worden aangeroepen. Binnen de favorieten-map verschijnt ook het pop-up scherm als er op een oefening wordt geklikt, met dezelfde informatie (behalve dat er nu staat “remove” ipv “add”).

Dag 4: 
	Ik ben voornamelijk bezig geweest met NewWorkoutActivity, een activity waarin de gebruiker een nieuwe workout kan samenstellen. Ik moest allereerst een nieuwe klasse aanmaken, WorkoutExercise. Deze verschilen van Exercise, omdat hij (1) de Exercise als object bevat, en (2) extra informatie bevat zoals aantal sets, aantal reps per set, aantal seconden rust tussendoor etc. 
Ik ben toen voornamelijk bezig geweest met de optie om dynamisch oefeningen aan een nieuwe workout toe te voegen. Elke keer dat er op de button wordt geklikt, wordt er dynamisch (binnen een ScrollView) een nieuw WorkoutExercise aangemaakt (met alle variabelen op null of 0). Dit wordt vervolgens doorgegeven aan de adapter, en verschijnt zo op het scherm.

Dag 5:
	Ik ben bezig geweest met de layout van de WorkoutExercise rows binnen NewWorkoutActivity. Ik ben lang bezig geweest met het mogelijk maken om hiervan ook dynamisch de variabelen aan te passen. 
	Mijn idee is dat elke row “uneditable” is (met TextViews ipv EditTexts). Op het moment dat er op de knop “add workout” wordt geklikt, ontstaat er een nieuwe row. Deze row (het laatste item in de ArrayList) wordt tegelijkertijd “editable” gemaakt (met EditTexts ipv TextViews). Ook staat er ipv de naam van de workout een button om een nieuwe oefening toe te voegen (deze button linkt naar FindExerciseActivity). Tevens verschijnt er een knop “add/save”. Als op deze knop wordt geklikt, wordt via setters de WorkoutExercise aangepast en wordt dit doorgegeven aan de adapter.
	Het probleem hierbij is dat het erg moeilijk is om aparte rows “editable” of “uneditable” te maken. Dit moet allereerst via (meerdere) ViewSwitchers gebeuren. Echter wordt het lastig omdat de rows in een listview zitten die via een adapter aan de ArrayList met WorkoutExercises wordt gelinkt. Ik moet dus nog uitzoeken hoe ik dit moet aanpakken. 


Week 3:

Dag 1:
	Ik heb een contextmenu (AlertDialog) toegevoegd, zodat, als er nu door de gebruiker lang op een exercise in NewWorkoutActivity wordt geklikt, de gebruiker nu 3 opties krijgt: (1) Edit (de gebruiker kan hierna de eigenschappen van die Exercise aanpassen), (2) Delete (de Exercise wordt hierna uit de Workout verwijderd), en (3) Cancel (het contextmenu verdwijnt hierna). 
	Ook is het me, door middel van ViewSwitchers, gelukt om enkel de Uneditable views te laten zien als een nieuwe row wordt aangemaakt. Als er via het context menu op “Edit” wordt geklikt, veranderen deze uneditable views naar de editable views, en kan de gebruiker de variabelen aanpassen. Echter werkt dit nog niet volledig naar behoren, dus moet ik hier nog aan werken. Het is de bedoeling dat alle rows by default Uneditable zijn. Op het moment dat er een exercise wordt toegevoegd, moet deze (als enige) Editable zijn. Ook moet, op het moment dat er bij een exercise op “Edit” wordt geklikt, enkel de relevante exercise Editable worden. Nadat een oefening is aangepast of toegevoegd, moeten alle rows weer by default Uneditable zijn. 

Dag 2:
	Het is me nog steeds niet gelukt een functie te schrijven die een specifieke row editable maakt. Ik heb dit overgeslagen en ga dit tot het einde bewaren.
	Ik heb toegevoegd dat er per workout een “Muscle Group” en een “Workout Day” moeten worden ingevuld. Ook wordt er om een (optionele) comment gevraagd via een Pop-Up scherm.
	Bij het opslaan van een workout wordt er een Workout object gemaakt en in een ArrayList<Workout> geplaatst. Als de gebruiker gaat naar WorkoutScheduleActivity, worden de Workouts via een WorkoutAdapter in een ListView getoond.
	Ik heb tevens toegevoegd dat de gebruiker de individuele workouts kan bekijken, aanpassen of verwijderen. Hiervoor heb ik de Activities WorkoutInfoActivity (voor het bekijken) en EditWorkoutActivity (voor het aanpassen) gemaakt. 
	Ook is het nu mogelijk voor de gebruiker om bij een oefening voor een nieuwe workout een oefening via FindExerciseActivity uit te zoeken en toe te voegen aan de Exercise. Ook wordt er automatisch een datum aan de Workout toegevoegd waarop de gebruiker voor het laatst de Workout in kwestie heeft aangepast (of aangemaakt).
	
	De problemen waar ik nu tegenaan loop zijn:
(1)	Als er een row wordt geselecteerd om te editen, wordt altijd de laatste row editable gemaakt (in plaats van de geklikte row).
(2)	Bij het bekijken/editen van individuele workouts verdwijnt de lijst met WorkoutExercise’s. 

Dag 3:
	Het is me nu gelukt om enkel de aangeklikte row “editable” te maken als er door de gebruiker bij die row op “Edit” wordt geklikt. Dit heb ik binnen de adapter gedaan, in plaats van binnen de activity. De reden hiervoor was dat de OnItemClickListener en OnItemLongClickListener in de activity niet werken, omdat er clickable views en buttons in de aparte rows zitten. 
	Ook heb ik het probleem van de verdwijnende WorkoutExercises in EditWorkoutActivity en WorkoutInfoActivity opgelost. Dit probleem kwam doordat ik een static variabele (met de WorkoutExercises) aan de listview linkte, maar deze static variabele ook telkens moest clearen om nieuwe workouts aan te kunnen maken. Ik heb dit opgelost door een extra “dummy” Arraylist aan te maken waar ik alle WorkoutExercises in stop voordat ik de andere (static) ArrayList clear.
  Een ander probleem waar ik momenteel tegenaan loop is het probleem dat de EditText’s Workout Day en Muscle Group(s) telkens worden gecleared als de Activity (tijdelijk) wordt verlaten (bijv. bij het toevoegen van een Exercise). Ik heb geprobeerd de ingevulde waarden als intent mee te geven, maar op een of andere manier kunnen de waarden niet correct worden opgehaald van de intent. 

Dag 4:
	Ik ben vandaag begonnen met het toevoegen van de onBackPressed() functies. Een probleem met de app was namelijk dat, na bijvoorbeeld het aanmaken van een nieuwe workout, als de gebruiker terugklikte, hij bij NewWorkoutActivity aankwam, met alle reeds ingevulde waarden al ingevuld, ondanks dat de workout al was toegevoegd. Ik heb tevens een Toast-bericht toegevoegd waarin wordt aangegeven dat, om de activity te verlaten, de gebruiker nog een keer op terug moet klikken. Ook wordt er aangegeven dat de workout niet wordt opgeslagen als de gebruiker nog een keer terugklikt. Als de gebuiker inderdaad de tweede keer terugklikt, worden alle waarden gecleared.
  Het is me allereerst gelukt om de waarden van de Workout Day en Muscle Group(s) op te slaan terwijl de gebruiker deze aan het invullen is (via een TextChangeListener). Echter, als de activity (tijdelijk) wordt verlaten (bijvoorbeeld om een exercise aan de WorkoutExercise toe te voegen), worden deze variabelen gereset. Dit heb ik uiteindelijk opgelost door de variabelen static te maken, zodat ze over meerdere activities gelijk blijven. 
	Een nieuw probleem wat hierbij is opgetreden is echter dat deze waarden altijd blijven staan, ook als de nieuwe workout wordt gecancelled of als de workout al is toegevoegd. Dit heb ik opgelost door de variabelen te clearen als (1) de workout wordt toegevoegd en (2) op de ‘Back’-knop wordt geklikt.
  Ook ben ik vandaag begonnen aan het uitwerken van de Search-functie bij ExerciseActivity (via een OnTextChangedListener). Om dit te doen moest ik, binnen de ExerciseAdapter, een Custom Filter maken aangezien het niet om een simpele arraylist met strings gaat, maar om een arraylist met custom objecten. Ik krijg echter telkens een error dat, binnen de getView()-functie, de positie van het object in de ArrayList niet overeenkomt met de grootte van de ListView. 

Dag 5:
	Ik heb vandaag het probleem met de search-functie opgelost, met behulp van een van de begeleiders. Het probleem zat hem in het aanroepen van “super” binnen de constructor van de adapter. Hierdoor ontstonden er als het ware twee verschillende arraylists met Exercises, waardoor de grootte van de arraylist niet overeenkwam met de ArrayList zelf. Om dit op te lossen moest ik een van de ArrayLists clearen en opnieuw aanmaken.
  Ook heb ik vandaag enkele extra ideeen van de app verwijderd, namelijk PreviousExercisesActivity en PreviousWorkoutsActivity. Deze behoorden niet tot het Minimal Viable Product en zou ik niet op tijd af hebben kunnen krijgen. 
  Een groot probleem waar ik tegenaanloop is de manier waarop alle info in de app in een database wordt opgeslagen. Doordat iedere Workout bestaat uit enkele Strings en een ArrayList met WorkoutExercises, en iedere WorkoutExercise weer bestaat uit enkele int’s en een Custom Exercise Object, gaat het heel moeilijk worden dit via sqLite in een database te stoppen en aan te roepen. Onze groepsmentor raadde mij aan dit wellicht via Gson te doen, dus ik ga mij hier nu in verdiepen.

Week 3:
	
Dag 1:
	Ik heb allereerst voor alle 5 sets toegevoegd dat de gebruiker de optie heeft om niet alleen het aantal reps per set, maar ook het aantal kg per set in te voeren. Dit heb ik uiteraard niet alleen in het layout-bestand aangepast, maar ook in de WorkoutExercise klasse (incl getters en setters), evenals in de workout_exercise_row. Om dit te doen heb ik substantiele wijzigingen moeten doorvoeren in de layout, zodat alles in één row zou passen. 
  Een probleem waar ik nu tegenaanloop, is dat, wanneer de gebruiker op een EditText (of het nou de Workout Day, Muscle Group, of een edittext binnen een workout_exercise_row) aanklikt en het toetsenbord verschijnt, het gehele scherm als het ware naar boven wordt verplaatst, waardoor het bovenste deel van het scherm niet meer in zicht is. Het lukt mij niet dit probleem op te lossen, dus bewaar ik dit voor later, omdat het verder geen effect heeft op de andere functionaliteit van de app. 

Dag 2:
	Ik heb het voorgenoemde probleem (waarbij het hele scherm verdwijnt als het toetsenbord verschijnt) opgelost, door enkele views en layout-objecten in een scrollview te plaatsen.
	Ook heb ik enkele kleine dingen van de layout nog toegevoegd (titels, textviews met uitleg, etc.), en heb ik voor elke layout file ook een “landscape variation” gemaakt. 
	Vervolgens heb ik mijn code (grotendeels) opgeschoond, voornamelijk door functies buiten de OnCreate()-methodes te plaatsen. Echter, bij de adapters was dit niet mogelijk, omdat, bijvoorbeeld, bij het klikken op ‘edit’ of ‘delete’ bij één van de rows, is moet de positie van de row worden achterhaald. Dit kan (voor zover ik weet) alleen als de functie binnen de getView methode staat. 
	 


