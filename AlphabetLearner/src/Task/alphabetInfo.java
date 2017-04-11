package Task;

public class alphabetInfo {
	
	//This is what setNATOLetter stores the NATO letter in
	String natoLetter;
	
	//Empty constructor allows for an object to be created initially and then re-set every time the TimerTask runs
	public alphabetInfo(){
		
	}
	
	//Uses a switch statement with 27 branches to set what the NATO letter should be based on a character
	public void setNATOLetter(char letter){
		switch(letter){
			case 'a':
				this.natoLetter = "Alpha";
				break;
			case 'b':
				this.natoLetter = "Bravo";
				break;
			case 'c':
				this.natoLetter = "Charlie";
				break;
			case 'd':
				this.natoLetter = "Delta";
				break;
			case 'e':
				this.natoLetter = "Echo";
				break;
			case 'f':
				this.natoLetter = "Foxtrot";
				break;
			case 'g':
				this.natoLetter = "Golf";
				break;
			case 'h':
				this.natoLetter = "Hotel";
				break;
			case 'i':
				this.natoLetter = "India";
				break;
			case 'j':
				this.natoLetter = "Juliet";
				break;
			case 'k':
				this.natoLetter = "Kilo";
				break;
			case 'l':
				this.natoLetter = "Lima";
				break;
			case 'm':
				this.natoLetter = "Mike";
				break;
			case 'n':
				this.natoLetter = "November";
				break;
			case 'o':
				this.natoLetter = "Oscar";
				break;
			case 'p':
				this.natoLetter = "Papa";
				break;
			case 'q':
				this.natoLetter = "Quebec";
				break;
			case 'r':
				this.natoLetter = "Romeo";
				break;
			case 's':
				this.natoLetter = "Sierra";
				break;
			case 't':
				this.natoLetter = "Tango";
				break;
			case 'u':
				this.natoLetter = "Uniform";
				break;
			case 'v':
				this.natoLetter = "Victor";
				break;
			case 'w':
				this.natoLetter = "Whiskey";
				break;
			case 'x':
				this.natoLetter = "Xray";
				break;
			case 'y':
				this.natoLetter = "Yankee";
				break;
			case 'z':
				this.natoLetter = "Zulu";
				break;
			default:
				this.natoLetter = "Error";
				
		}
	}
	
	//Returns the NATO letter of the object to be used in the main program
	public String getNATOLetter(){
		return this.natoLetter;
	}
}
