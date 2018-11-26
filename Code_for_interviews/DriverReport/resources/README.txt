AUTHOR: AptFox
DATE: 2018/09/09
VERSION: 1.0

NAME
----
DriverReport

INTRODUCTION
-------------
This program generates a report of drivers total miles driven and average speed. 
The values reported are rounded to the nearest integer. The report is sorted by 
most miles driven to least. This is a console application. 

INSTALL
-------
Requirements: Java SE Runtime Environment 8

There are two ways to run this program. The easiest way is to run the batch file located in the same
directory as the program (The batch file will only work on Windows). The second way is to run the 
program from the console.

Running the program using the batch file:
-> Step 1: Double-click the "Run.bat" file.

Running the program from console:
-> Step 1: Open a terminal/cmd window
-> Step 2: Navigate to the directory containing the program (.jar file)
-> Step 3: Enter the following command 'java -jar DriverReport.jar'

INCLUDED FILES
--------------
Run.bat                          <- A windows batch file for executing the program.
README.txt                       <- You are here.
DriverReport.jar             <- An executable jar containing the program.
testInputFile.txt                <- A sample file provided to test the txt file input of the program.
DriverReportProjectFiles.zip <- The directory containing the source/dev files for the program.


USAGE
-----
Once the program is running you will be prompted to select your style of input. Invalid entries for input style 
will result in program terminatation. The options for input style are 'C' for Console or 'F' for File. If Console 
input is selected, commands must be entered one at a time followed by the enter/return key. The program will 
continue to take in commands until the exit command is entered. The exit command is: '!wq'.

If File input is select then the name of a text file conatining valid commands must be 
entered. The program will search the directory where it is run from by default. If the text file is located 
outside of the present directory then the fully qualified file path must be supplied with the name.  

Commands:

Driver [Name]                                         <- Used to create a driver. Must be entered before a trip.

Trip [Name] [Start Time] [Stop Time] [Miles Driven]   <- Used to enter a trip for a previously created driver.
 
 -- [Start Time]  <- Entered in 24 hour format. Ex: 01:00
 -- [Stop Time]   <- Entered in 24 hour format. Ex: 23:00
 -- [Miles Driven]<- Entered as a decimal. Ex: 22.7

Notes: Commands must be seperated by spaces. Commands that don't meet the format specified above will be discarded. 
Duplicate 'Driver' commands will be discarded. 'Trip' commands where no driver exists will be discarded. To avoid 
this ensure that you've entered a 'Driver' command for the driver first. 


Example Commands:
Driver Dan
Trip Dan 07:15 07:45 17.3

DEVELOPMENT APPROACH
--------------------
Intial Setup
I don't know that I followed any popular development approach like TDD. I reread the problem statement many times. 
Each time attempting to read between the lines of the requirements. Trying to see if there was hidden meaning. After 
that I reasoned through the problem once in my head conceptualizing the objects and how they might interact. I then 
started modeling objects by functionality. For example: Driver objects contain trips because Drivers take trips while
trips don't take themselves. I copied requirements from the problem statement into the objects 
and methods. Noted each requirement with a "//TODO:" to ensure I don't forget to implement them.

The Lone Interface
You'll notice that the project has a single interface called IReportGenerator for accessing the class that contains the primary logic
(ReportGeneratorImpl).It's implemented this way because in java the main method or entry point for your program is required to be 
static. However, if you attempt to make a reference to any other objects or, methods or classes from that static method java will
give you the following error: "Cannot make a static reference to a non-static field or method". I've done battle with this error 
before and was not in the mood to re-hash our old disagreements. As a result I created an interface, created a static field for it
under the class and initialized it with the class the contains my primary logic. Thereby satisfying the main class/compiler and still
not having to change each and everything to Static.

Time.java
While developing this I realized that calculating time could be tricky so originally I opted to create my own "Time.java" 
class to work out my own method of handling time. I actually wrote out a small algorthim for handling time but didn't implement 
it because it would have made testing much more complex and I found out about the existence of LocalTime objects. The gist of 
my thinking with the Time objects was that I could handle hours and minutes as integers with bounds bounds I specify. I'd then 
create a method for calcualting the difference between them because I already know all the bounds of miltary time and I control
the objects creation. The Time object has been removed as well as it's methods. 

Comparing Driver Objects
One of the requirements that seemed decptively simple was the requirement that the report be output in order from most miles driven
to least. All of my Driver objects were placed into a Map because I needed to be able to recall a driver at any time to add trips to it.
Maps aren't super simple to sort in my experience. Or at least I haven't had enough opportunites to try. I needed a way of comparing 
all the driver objects I'd created without writing logic that explicitly removed each one from the map and re-added it to another data 
structure. Basically I don't know how to sort maps very well. I could learn it but it seemed like a lot of work for little reward. I do 
know how to sort via Collections and I know that the values in a Map can be dump into a List. So to solve this issue I opted to dump
the maps values into a List of Driver objects. I then wrote a overrode the "compareTo" method on my Driver objects to compare purely
based on the totalMilesDriven variable. Called Collections.sort() on the List and the drivers were sorted. 

Data Structure Choices
My choices of data structures such as List, Map, Array, etc... weren't the result of a complex deliberate thought process. I picked the 
structures I was most familiar with and that satisfied the need I had at the moment. For example, I used Arrays when I needed to operate
on indicies, List when I needed to store objects to be recalled later in their order and Map when I needed to be able to recall an 
object based on a key. 

Primitives vs Objects
I started by setting primitives for everything but decided along the way to switch to objects because I'd rather deal with the 
additional null checks than lose access to the methods that come with those objects. 

Remarks
I'm sure there are plenty of other ways to implement this program that are more clever or use tricks/idioms of the language. 
Like how I could have used LAMBDA's to sort my map since I implemented in Java 8 or I could have written a custom Comparator
for sorting. I decided against trying to show off my l33t skills in favor of code that easy to read, easy to understand and 
easy to expand. I've tried to be witty with my code before and it usually results in me somehow getting it to work but not
really understanding why. That'd be a nightmare if we had to go over this code. Basically this code is reflective of my skill 
level. No gimmicks or hacks.

TESTING APPROACH
----------------
To test the program, I followed the logic taking note of what could go wrong independent of validation.
For example, I ignored that fact that a check for null in an earlier method would mean that null is unlikely
for the current method. The approach was essentially to isolate each method and figure out how it deals with 
expected/unexpected input independently. I limited my test cases to methods that either changed the state of 
an object or returned a calculation. I believe it's pointless to test getters and setters or methods that 
only call other methods. I also tried to make the names of the tests and their internal veriables as informataive 
as possible instead of commenting the tests themselves. 