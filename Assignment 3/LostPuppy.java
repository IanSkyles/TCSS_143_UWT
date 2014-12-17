/*
* 
* LostPuppy.java
* TCSS 143 – Autumn 2014
* Assignment 3
*
*/

import java.util.Random;

/**
* This class in combination with PuppyPlay.java will play a game that the user guesses to
*       find the location of a puppy who is lost in a building
* @author Ian Skyles iskyles@uw.edu
* @version 10/14/2014
*/

public class LostPuppy {
        //array for building
        private char[][] myHidingPlaces;
        //floor location for lost puppy
        private int myFloorLocation;
        //room location for lost puppy
        private int myRoomLocation;
        //the winning player
        private char myWinner;
        //keeps track of puppy being found
        private boolean myFound;
        
        //constructor
         /**
            * Constructor method of the class. Sets up all necessary variables given 
            * rooms and floors
            *
            * @param theFloors is used for input from driver method / class (gets floors)
            * @param theRooms is used for input from driver method / class (gets rooms)
            * @return no return - its a constructor
            */
        public LostPuppy(int theFloors, int theRooms) {
                Random rand = new Random();
                this.myHidingPlaces = new char [theFloors][theRooms];
                for(int i = 0; i < theFloors; i++) {
                        for(int j = 0; j < theRooms; j++) {
                                this.myHidingPlaces[i][j] = ' ';
                        }
                }
                //assigns random location for the lost puppy to be at
                this.myFloorLocation = rand.nextInt(theFloors);
                this.myRoomLocation = rand.nextInt(theRooms);
                //puts the puppy "in" the building
                this.myHidingPlaces[myFloorLocation][myRoomLocation] = 'P';
                this.myWinner = ' ';
                this.myFound = false;
        }
        /**
          * Checks if room on specfiic floor has been gussed yet
          *   
          * @param theGussedFloor is the the floor # gussed
          * @param theGussedRoom is the the Room # gussed          
          * @return boolean - true or false based on if room was searched already
          */
        public boolean roomSearchedAlready(int theGussedFloor, int theGussedRoom) {
                boolean flag = true;
                if(myHidingPlaces[theGussedFloor][theGussedRoom] != 1
                   && myHidingPlaces[theGussedFloor][theGussedRoom] != 2) 
                   {
                        flag = false;
                   }  
                   return flag;
        }
        /**
          * Checks if puppy is in specfic room/floor combination
          *   
          * @param theGussedFloor is the the floor # gussed
          * @param theGussedRoom is the the Room # gussed          
          * @return boolean - true or false based on if puppy is in location gussed
          */
        public boolean puppyLocation(int theGussedFloor, int theGussedRoom) {
                boolean flag = false;
                if(myHidingPlaces[theGussedFloor][theGussedRoom] == 'P') 
                   {
                        flag = true;
                   } 
                   return flag;
        }
        /**
          * checks if guess is valid (in array)
          *   
          * @param theGussedFloor is the the floor # gussed
          * @param theGussedRoom is the the Room # gussed          
          * @return boolean - true or false based on if guess is a valid choice
          */
        public boolean indicesOK(int theGussedFloor, int theGussedRoom) {
                boolean flag = false;
                if(theGussedFloor < myHidingPlaces.length
                   && theGussedRoom < myHidingPlaces[0].length)
                   {
                        flag = true;
                   }
                   return flag;       
        } 
        /**
          * returns # of floors(rows)
          *                      
          * @return int - # of floors
          */
        public int numberOfFloors() {
                return myHidingPlaces.length;
        }
         /**
          * returns # of Rooms(columns)
          *                      
          * @return int - # of Rooms
          */
        public int numberOfRooms() {
                return myHidingPlaces[0].length;
        }
        /**
          * searchs room and determines wether or not room contains the dog or is empty
          *      it also changes myWinner, myFound idepending on results
          * @param theGussedFloor is the the floor # gussed
          * @param theGussedRoom is the the Room # gussed 
          * @param thePlayer is the player number - 1 or 2 for current setup         
          * @return boolean - true or false based on if puppy is in room/floor or its empty
          */
        public boolean searchRoom(int theGussedFloor, int theGussedRoom, char thePlayer) {
                boolean flag = false;
                if(myHidingPlaces[theGussedFloor][theGussedRoom] == ' ') {
                        myHidingPlaces[theGussedFloor][theGussedRoom] = thePlayer;
                } else if(myHidingPlaces[theGussedFloor][theGussedRoom] == 'P') {
                        flag = true;
                        this.myWinner = thePlayer;
                        this.myFound = true;                        
                }
                return flag;
        }
        
        // @Override
        /**
          * returns a string of the building
          *                      
          * @return String - returns a large string with building, spaces, gusses / puppy
          */

        public String toString() {
        
                String building = "";
                                
                
                //builds the roof!
                for(int i = 0; i <= myHidingPlaces[0].length * 4; i++) {
                        building += "_";
                }
                //each rows beginning except first and last + new lines
                for(int i = myHidingPlaces.length - 1; i >= 0; i--) {
                        building += "\n" + "|";
                        //cycles by each element in array by using both loops
                        for(int z = 0; z < myHidingPlaces[0].length; z++) {
                                if(puppyLocation(i,z)) {
                                        if(myFound) {
                                                //if they have found puppy display it 
                                                //with the player who found it
                                                building += "" + myWinner + "P" + " ";
                                        } else {
                                                //if they havent found puppy yet hide it
                                                building += "   "; 
                                        }                                
                                }
                                else {
                                        building += " " + myHidingPlaces[i][z] + " ";
                                }             
                                building += "|";                         
                         }
                         building += "\n" + "|";
                         for(int z = 0; z <= (myHidingPlaces[0].length - 1); z++) {
                                building += "___|";
                         }
                }
                return building;                       
                         
        }
}