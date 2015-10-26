
/*Modified for esoff322.a2 by Nevin Leh, Aaron Newhall and  Tim Wegher
 * 
 */
package esof322.a2;


/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac AdventureGame.java
     To run:     java AdventureGame

     The main routine is AdventureGame.main
				    
**/


public class Player {

  private Room myLoc;

  private Item[] myThings = new Item[2];

  private int itemCount = 0;

  public void setRoom(Room r){
   myLoc = r;
   }

  public String look() {
   return myLoc.getDesc();
   }

  public void go(int direction){
     myLoc.exit(direction,this);
  }

  public void pickUp(Item i){
   if (itemCount < 2) {
      myThings[itemCount] = i;
      itemCount++;
      myLoc.removeItem(i);
      }
  }

  public boolean haveItem(Item itemToFind){
     for (int n = 0; n < itemCount ; n++)
       if (myThings[n] == itemToFind) return true;
     return false;
  }

  public void drop(int itemNum){
   if (itemNum >= 0 && itemNum <= itemCount-1){
      switch(itemNum){
      case 0: { myLoc.addItem(myThings[0]);
	        myThings[0]=myThings[1];
	        itemCount--; 
	        break;
	      }
      case 1: { myLoc.addItem(myThings[1]);
		itemCount--;
		break;
	      } 
      }
   }
   }

  public void setLoc(Room r){myLoc = r;}

  public Room getLoc(){return myLoc;}

  public String showMyThings(){
   String outString = "";
   for (int n = 0; n < itemCount ; n++)
     outString = outString + Integer.toString(n+1) + ": " 
       + myThings[n].getDesc() + " ";
   return outString;
  }

  public boolean handsFull(){return itemCount==2;}

  public boolean handsEmpty(){return itemCount==0;}

  public int numItemsCarried(){return itemCount;}
  
  public Item[] getMyThings(){return myThings;}//Added this so I could print where I needed to. 

}
    



