//package com.project1.repos;

import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file;
import java.util.*;


public class LockedMeImpl implements LockedMe {
	
	private File[] files = null;
	private File currentDir;
	
	public LockedMeImpl(File currentDir) {
		super();
		this.currentDir = currentDir;
		files = currentDir.listFiles();
	}
	

	/*
	 * A method to display the initial display screen.
	 */
	@Override
	public void welcomeScreen()
	{
	  System.out.println("\n=========  Main Menu  ===========");
	  System.out.println("Welcome to Virtual Key for your repositories");
	  System.out.println("Developed by Mrunal Pilankar");
	  System.out.println("mrunalpilankar1298@gmail.com");
	}	
	
	
	/*
	 * This method overrides the interface method and checks if the file 
	 * already exists by ignoring the case sensitivity of the file names otherwise adds the 
	 * file to the directory.
	 */
	
	@Override
	public void addFile(String filename) {
		
			File file = new File(filename);
			try {
			      if ( file.createNewFile()) {
			        System.out.println("\nYour file : " + file.getName() + " is added.");
			      } else {
			        System.out.println("\nThis file already exists.");
			      }

		    } catch (IOException e) {
		      System.out.println("\nAn I/O error occurred.");
		    }
		}
		
	
	/*
	 * This method is used to delete a file from the directory
	 */

	@Override
	public void deleteFile(String filename) {
		File file = new File(filename); 	
		
			try {
				if ( fileExists(filename) && Files.deleteIfExists(file.toPath())) { 
				      System.out.println("\nYour file: " + file.getName() + " is deleted.");
				}
				else {
					System.out.println("\nYour specified file is not found.");
				}
			} catch (DirectoryNotEmptyException x) {
				System.out.println("\nYou can delete an empty directory only.");
				System.out.println("If you want to delete a file, enter an existing filename.");
			}	catch (IOException e) {
				 System.out.println("An I/O error occurred.");
			}
		
		
	}
	
	/*
	 * The search method uses the getName() method of File class
	 * and the equals method to check if the file exists in the 
	 * directory or not. This check is case-sensitive.
	 */
	@Override
	public void searchFile(String filename) {
		boolean flag = false;
		
        for(File f : files){
            if(f.isDirectory()) {
            	if (filename.equals(f.getName())) {
            		flag = true;
            		System.out.println("\nDirectory found : " + f.getName());
            	}
            }   
            if(f.isFile()){
            	if(filename.equals(f.getName())) {
            		flag = true;
            		System.out.println("\nFile found : "+ f.getName());
            	}
            }
        }
        if(!flag)
        {
        	System.out.println("\nNo such file found");
        }
	}

	@Override
	public void closeApplication() {
		System.exit(0);
		
	}


	/* 
	 *  This method is used to display the files in the directory.
	 */
	@Override
	public void displayFiles() {
		
		 	files = currentDir.listFiles();
	        for(File f : files){
	            if(f.isDirectory())
	                System.out.println(f.getName());
	            if(f.isFile()){
	                System.out.println(f.getName());
	            }
	        }
	}
	/*
	 * The fileExists method is used to check if a given filename exists in the directory.
	 * This filename check is case sensitive.
	 */
	
	public boolean fileExists(String filename){
	    String[] filenames = currentDir.list();
	    for(String file : filenames)
	        if(file.equals(filename))
	        {
	        	//System.out.println("Found");
	        	return true;
	        }
	    //System.out.println("Not found");
	        return false;
	}
	
	
	
}
