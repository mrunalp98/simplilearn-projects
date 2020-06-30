//package com.project1.repos;
import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.*;



public class LockedMeMain {
	public static void main(String[] args) {

		int choice = 0;
		int choice2 = 0;
		
		String currentDirectory = System.getProperty("user.dir");
	    System.out.println("\n\nYour current working directory " + currentDirectory + " is the root directory. ");
	    
	    File currentDir = new File(".");
		
		String filename = null;
		
		LockedMeImpl l = new LockedMeImpl(currentDir);
		
		do {
			  l.welcomeScreen();
			  System.out.println("\nThis CLI has the following options : ");
			  System.out.println("Enter 1 . Display current files in Ascending order");
			  System.out.println("Enter 2 . Select Menu for (add/delete/search) file operations");
			  System.out.println("Enter 3 . Close the application ");
			  System.out.print("Enter choice here >> ");
		  	  Scanner scan = new Scanner(System.in);

		  	  // check if the input is valid.
			  // The input should be a number
		  	  if(scan.hasNextInt()) {
		  	  		  choice = scan.nextInt();
					  switch(choice)
					  {
					  case 1:
						   System.out.println("\nDisplaying the files in Ascending order : ");
						   l.displayFiles();
						   break;
					  case 2:
						  do
						  {
							  System.out.println("\nEnter 1 : Add a file to the directory ");
							  System.out.println("Enter 2 : Delete a user specified file from the directory");
							  System.out.println("Enter 3 : Search a user specified file from the directory");
							  System.out.println("Enter 4 : Go back to main menu");
							  System.out.print("Enter choice here >> ");
							  
							  Scanner sc = new Scanner(System.in);

							  // check if the input is valid.
							  // The input should be a number
							  if(sc.hasNextInt()){
									choice2 = sc.nextInt();
									if(choice2 < 4 ) {
									  System.out.println("Enter filename");
									  filename = sc.next();
									}
								    if(choice2 > 4){
									  System.out.println("Invalid choice");
									   break;
								    }
								    if (choice2 == 1) 
									  l.addFile(filename);
									 
								    if (choice2 == 2)
									  l.deleteFile(filename);
								  
								    if (choice2 == 3)
									  l.searchFile(filename);

							  } else {
							  	System.out.println("\nPlease select a proper input");
					  			System.out.println("Select a number between 1 to 4 as your choice.");
					  			
							  }
							   
							 
						  }while(choice2 != 4);
						  
						  break;
					  case 3:
						  l.closeApplication();
					  default:
						  System.out.println("Invalid choice");
						  System.out.println("Please choose from above options");
					  }
		  	  } else {
		  	  	System.out.println("\nPlease select a proper input");
				System.out.println("Select a number between 1 to 3 as your choice.");
				choice =0 ;
		  	  }
			 
		}while(choice != 3);
		
		
	}
	
	
}
