Solar System Sim README

********************************************************************************************************************

Welcome to Solar System Sim
Version 5.3
Created by Harry Baker

********************************************************************************************************************

Component Files

SolarSystemSim.java (Driver)

SolarSystem.java (Class which holds the intial data for each body and runs the simulations)

GravBody.java (Class that models a body)

DataOutput.java (Class for printing data to a file)

PhysicsVector.java (Class for creating 3-vectors) 3rd Party Source

********************************************************************************************************************

Solar System Sim allows you to simulate the solar system using n-body calculations. The current version contains 
27 different objects or bodies. These are:

The Sun

Planets:
Mercury
Venus
Earth
Mars
Jupiter
Saturn
Uranus
Neptune

Dwarf Planets:
Ceres
Pluto
Eris

Moons:
The Moon
Phobos
Deimos
Ganymede
Callisto
Io
Europa
Enceladus
Mimas
Titan
Triton
Charon

Comets:
Halley's Comet

Spacecraft:
Voyager 1
Voyager 2

A total of 27 bodies. All contribute towards calculating the gravitational forces between each other body (though 
some will negiliably). 

The simulation uses data from JPL at an epoch of 22nd November 2017 at midnight. From this point, one can run the
simulatiom for as long as one desires.

********************************************************************************************************************

Running SolarSystemSim

1. Check that all the required files are within the same folder (see Component Files).

2. Compile the entire folder from the command prompt using javac SolarSystemSim.java

3. Launch the program by using the command java SolarSystemSim from the command prompt

4. You now have the choice to either run the standard simulation, the alternative (alpha) increasing time-step
   simulator or to exit the program. Enter the number corresponding to your choice. If an int is not entered, a
   warning will be printed and the default option will be to run the standard simulator. If an int other than a
   menu option is entered, you will have to re-enter your choice.

********************************************************************************************************************

Standard Solar System Sim

1. You should now be presented with a welcome message and a list of all the bodies simulated. You can now print out
   the intial data for each body to the screen by entering Y. If you do not wish this, enter N. The question will be
   asked until you enter either Y or N. This form is used throught the simulation where every a question is followed
   by (Y/N).

2. Similarily, the next option is to print out the intial total mechanical energy and angular momentum of the 
   simulation.

3. The next option is to add a new body to the simulation. If you enter Y, you can then enter in the details of your
   new body. First its name, which can be anything you want. Next its mass and then it radius. Be sure to enter only
   numbers here, no units required. Scientific form is fine though, such as 1.0e3 for 1000. Exception handling is 
   included in this program so if you accidently enter a letter then a default value is chosen and the program moves 
   on to the next option. If you enter a negative value for mass or radius then you will have re-enter your input as
   this is not possible. Finally, you can then enter in the position and velocity of your body. Again no letters but
   negative values are allowed. Your body will now be added to the simulation. You can add another one by entering Y
   when prompted or enter N to move onto the next option.

4. Now the algorithm to use in the simulation must be chosen. The options are:
   (1) Euler
   (2) Euler-Cramer
   (3) Euler-Richardson
   (4) Verlet
   (5) Beeman
   Choose by entering in the number corresponding with your choice. Make sure it is one of the menu options. If for
   an example a 6  is entered, you will have to re-enter as this is not an option. If anything other than an integer
   say 4.0 instead of 4 is entered, the exception is caught an the choice is set at a default of 1 for Euler.

5. Next, the time-step of the simulation can be determined. This is the small increments in time that the bodies in
   the simulation are moved by using iterative algorithms. You must enter a positive number, again no letters.

6. The duration is then entered. Again, this must be a positive number

7. Then one is asked whether to create an output file(s). If Y is entered, output files will be created for the 
    x-y position of each body, the difference in total intial and final mechanical energy and the difference in total 
    initial and final angular momentum of the system, at a frequency specified in the next step.

8. If an output file was chosen to be produced, one can now enter what they should be called. All of the files 
    produced will start with this name.

9. If an output file was chosen to be produced, one can then enter the frequency of outputs to file. This is after
    how many iterations that data will be sent to the output files. It is recommend to selected a reasonably high
    number as this is an intensive task.

10. The simulation will now run based on the parameters you have entered. When the calculation is completed, a 
    message is printed to the screen and you are prompted with more options. 

11. Entering Y to printing final solar system kinematics will print the positions and velocities of all the bodies
    in the simulation, including any you have added.

12. Entering Y to the next question will print the final total energy and angular momentum of the system and the
    difference between the intial and final values. This is a good way to see how accurately the different 
    algorithms conserve energy and momentum of the system.

13. Finally, you can choose to re-run the simulation by entering 1 again when the main menu is presented again. This 
    will reset everything back to the intial data (without any bodies you have entered). This question will prompted 
    at the end of every simulation. Similarily, you can choose to run the alternative simulator (2) or exit the 
    program by entering 3. A goodbye message is then printed and the program ends.

*******************************************************************************************************************

Alternative Simulator (Alpha)
*********Warning***************************************************************************************************
This method is not fully polished. It may contain some irregularities. This is primarily for data collection so the
style of the code is not to such a standard as the main simulator!
*******************************************************************************************************************
This version has less user options as it allows for the more easy collection of data on energy or angular momentum
conservation by increasing the time-step from its initial value entered by the user, at the end of every run of the
simulation for a user defined duration. This continues until the time-step exceeds the duration. A file is outputted
containing the difference between the initial and final energy and angular momentum of the system at the end of every 
run of the simulation. The user steps are:

1. Choose 2 at the main menu

2. Choose algorithm to use

3. Enter time-step

4. Enter duration

5. Choose whether to create output files

6. Name the output files (if any are to be created)

7. Simulation then runs, printing the current time-step every run

8. Finishs operation and returns to main menu

    
      