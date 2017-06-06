import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class VirtualPetShelterApp {
	
	
	public static void main(String[] args) {
		
  //  Map<String,VirtualPet> mapPets  = new HashMap<String, VirtualPet>();     
	 VirtualPetShelter shelter = new VirtualPetShelter();
	
		
        VirtualPet vPet = new VirtualPet("Bob", "Nice big dog");
        shelter.petsByName.put("Bob", vPet);
        shelter.intake(vPet); 
        VirtualPet vPet1 = new VirtualPet("Johnny", "Little mean dog", 69, 49,2);
        shelter.petsByName.put("Johnny", vPet1);
        shelter.intake(vPet1);
        VirtualPet vPet2 = new VirtualPet("Lenny", "Snorty dog", 39,19,79);
        shelter.petsByName.put("Lenny", vPet2);
        shelter.intake(vPet2);
        VirtualPet vPet3 = new VirtualPet("Chatty", "Chatty kathy dog");
        shelter.petsByName.put("Chatty", vPet3);
        shelter.intake(vPet3);
        VirtualPet vPet4 = new VirtualPet("Lily", "Funky dog", 18, 81, 63);
        shelter.petsByName.put("Lily", vPet4);
        shelter.intake(vPet4);
        
        
		System.out.println("Thank you for volunteering at Farzana's Virtual Pet Shelter and Delicatessen!");
        System.out.println("This is the status of your pets!");
        
		System.out.println("");
		printHeader(); //Use method to print header
		
		printShelterAnimalStat(shelter);
		
		
       /* 
        for(Map.Entry<String, VirtualPet> entry: shelter.petsByName.entrySet()){
        	
        	VirtualPet v = entry.getValue();        	
        	System.out.println(v.name + "\t |" + v.hunger + "\t |" + v.thirst + "\t |" + v.boredom);
        
        }
        */
        printFooter();
        Scanner input = new Scanner(System.in);
        System.out.println("Type Quit to exit.");
	/*
		for(VirtualPet pet: petsByName.values()) { // remember, pets() returns petsByName.values
    		pet.feed();
    	}
		
	*/	
	   boolean play = true;
	    
		while (play == true) {
			
			showMenu();
			System.out.println("");
// Putting user input into vOption		
			String vOption = input.next();
			
// method to check if the user wants to quit			
			checkForQuit(vOption);
			int iOption = Integer.parseInt(vOption);
	    
// options the user chose  	        
	    switch(iOption) {    	
	    	case 1:{	     
	    		System.out.println("Meal Time! Let's feed them all.");
	     	    shelter.feedpets();   
	    		shelter.tick();
	    		
	    		System.out.println("After meal stats");
	    		printHeader(); //Use method to print header	    		
	    		printShelterAnimalStat(shelter);
	    		printFooter();      
	   	       break; 
	    	}   
	    	   
	    	case 2:{ 
	    	   System.out.println("Lets give them all water.");
	     	    shelter.waterpets();   
	    		shelter.tick();
	    		System.out.println("After water stats");
	    		printHeader(); //Use method to print header	    		
	    		printShelterAnimalStat(shelter);
	    		printFooter();      
                break; 
	    	}   
	    	
	    	case 3:{
	    		playMenu();
	    		String petName = input.next();
	    		checkForQuit(petName);
	    		shelter.playWith(petName);
	    		System.out.println("After play stats");
	    		printHeader(); //Use method to print header	    		
	    		printShelterAnimalStat(shelter);
	    		printFooter();      
	    		break; 	
	    		
	    	}
	    	
	    	case 4:{	    		
	    		System.out.println("Adoption is a noble act. Select by their name to adopt");
	    		System.out.println("");
	    		System.out.println(shelter.pets());
	    		String petName = input.next();
	    		checkForQuit(petName);
	    		shelter.adopt(petName);
	    		System.out.println("After adoption stats");
	    		printHeader(); //Use method to print header	    		
	    		printShelterAnimalStat(shelter);
	    		printFooter();    		
	    			    		
		   	    break; 
	    	}
	    	
	    	case 5:{	
	    		System.out.println("We always have room in our hearts for pets");
	    		System.out.println("Give us the name of the pet");
	    		String newPet = input.next();
	    		checkForQuit(newPet);
	    		System.out.println("Give us a description of the pet");
	    		String newDesc = input.next();
	    		checkForQuit(newDesc);
	    		VirtualPet newVPet = new VirtualPet(newPet, newDesc);
	    		shelter.intake(newVPet);
	    		System.out.println("After intake stats");
	    		printHeader(); //Use method to print header	    		
	    		printShelterAnimalStat(shelter);
	    		printFooter();
		   	    break; 
	    	}
	    	
	    	case 6:{	    		
	    		System.out.println("Thanks for visiting Farzana's Virtual Pet Shelter! Good bye. " );
	    		play = false;	    		
	    		System.out.println("");
	    		System.exit(0);
	    		break; 
	    	}
	    	
	    	default:{
	    		vPet.tick();
	    		showMenu();
	    		break; 
	    	}
			
	       }
		
		}
		input.close();
   }
	
	
// method to quit the program	
	public static void checkForQuit(String userInput){
		
		userInput = userInput.toLowerCase();
		
		if (userInput.equals("quit")) {		
		System.out.println("Nobody likes a quitter...");
		System.exit(0);
		}
	}

// show menu for available options	
    public static void showMenu(){
    	System.out.println(" ");
    	System.out.println("What would you like to do?");
    	System.out.println("1. Feed the pets");
    	System.out.println("2. Water the pets");
    	System.out.println("3. Play with a pet");
    	System.out.println("4. Adopt a pet");
    	System.out.println("5. Admit a pet");
    	System.out.println("6. Quit");
    	
   }
   
    public static void playMenu(){
    	System.out.println("ok, so you would like to play with a pet. Please choose one.");
    	System.out.println("");
    	System.out.println("Chatty: looks like he has seen better days");
    	System.out.println("Johnny: is a better nervous");
    	System.out.println("Bob: probably didn't start with that many legs");
    	System.out.println("Lenny: smells like Jennifer Lopez");
    	System.out.println("Lily: she is ready to play");
    	System.out.println("");
    	System.out.println("Enter the name of the pet you want to play with."
    			+ " Pet names are case-sensitive.");
    	System.out.println("");
    }
    
 // print header	
    public static void printHeader(){
    	System.out.println("Name" + "\t |Hunger " + "|Thirst " + "|Boredom");
        System.out.println("---------" + "|-------" + "|-------" + "|-------");
    }
    
    // print header	
    public static void printShelterAnimalStat(VirtualPetShelter s){
    	
    	
         for(Map.Entry<String, VirtualPet> entry: s.petsByName.entrySet()){
        	
        	VirtualPet v = entry.getValue();        	
        	System.out.println(v.name + "\t |" + v.hunger + "\t |" + v.thirst + "\t |" + v.boredom);
        
        }
    }
    
    // print footerheader	
    public static void printFooter(){
    	//System.out.println("Name" + "\t |Hunger " + "|Thirst " + "|Boredom");
        System.out.println("---------" + "|-------" + "|-------" + "|-------");
        System.out.println("");
    }
 
    
	
}
    	
    	
    	
   
    
	

	

