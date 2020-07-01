//package com.project1.repos;

import java.io.File;
import java.nio.file.*;


public interface LockedMe {

	public void welcomeScreen();
	public void addFile(String filename);
	public void deleteFile(String filename)  ;
	public void searchFile( String filename);
	public void displayFiles();
	public void closeApplication();
	
}
