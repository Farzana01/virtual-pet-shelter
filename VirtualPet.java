
public class VirtualPet {

	String name;
	String description;
	int hunger;
	int thirst;
	int boredom;
	boolean clean;
	
	
	
	// creating constructor overload here so if two parameters are passed, it will execute this constructor
		public VirtualPet(String nameC, String descriptionC) {
			    this.name = nameC ;
				this.description=descriptionC;		
				this.hunger = 31;
				this.thirst = 29;
				this.boredom = 46;
				this.clean = true;
								
			}
			
// creating a constructor that is accepting default values for hunger, thirst and boredom
// 	this constructor will execute all parameters
	public VirtualPet(String nameC, String descriptionC, int hungerC, int thirstC, int boredomC) {
	    this.name = nameC ;
		this.description=descriptionC;		
		this.hunger = hungerC; // The default values will be set from the VirtualPetShelterApp with public static void main(String[] args)
		this.thirst = thirstC; // The default values will be set from the VirtualPetShelterApp with public static void main(String[] args)
		this.boredom = boredomC; // The default values will be set from the VirtualPetShelterApp with public static void main(String[] args)
				
	}
	
	public String toString() {
        return description.toString() + " " + name;
    }
	
 
    
    public void water() {
    	
    	this.thirst = thirst + 7;
        if (this.thirst >= 100){
       	  	this.thirst = 100;
       	  	
        }
    };
    public void play(){
        this.boredom = boredom - 8;  
    	
    	if (this.boredom <= 0){
    		this.boredom = 0;
       	 
     }    	 
        	
    };
	
	public void feed() {
		
		this.hunger = hunger + 9;
        if (this.hunger >= 100){
        	this.hunger = 100;
        	
        } 
        this.thirst = thirst - 4;
	};
	
	public String getName() {
		   return name;

		}
    
     void tick() {
    	
    	this.hunger = hunger + 5;
    	this.thirst = thirst - 2;
    
    	return;
    }


    
}

       	
	
	
	

	 
	

