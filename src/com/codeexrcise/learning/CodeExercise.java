package com.codeexrcise.learning;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Here we are going to write some functions to do some disk files clean up
 * 
 */
public class CodeExercise {
	List<String> result = new ArrayList<String>();

	  public static void main(String[] args) {

		System.out.println("=========Beginning of exercise 0=========");

		// For exercise 0. You will need to fill in the missing class
		// definition.
		ObjectTest();

		Interview interview = new Interview();

		// For exercise 1
		System.out.println("=  ========Beginning of exercise 1 =========");
		Period[] periods = new Period[3];
		periods[0] = new Period("1/1/2016", "7/1/2016");
		periods[1] = new Period("3/1/2016", "10/1/2016");
		periods[2] = new Period("11/1/2016", "12/1/2016");
		boolean result = interview.hasOverlappedPeriod(periods);
		System.out.println("Periods are overlapping :" + result);

		System.out.println("=========Beginning of exercise 1 =========");
		Period[] periods2 = new Period[3];
		periods2[0] = new Period("1/1/2016", "7/1/2016");
		periods2[1] = new Period("3/1/2017", "10/1/2017");
		periods2[2] = new Period("11/1/2018", "12/1/2018");
		boolean result2 = interview.hasOverlappedPeriod(periods2);
		System.out.println("Periods are overlapping :" + result2);

		// For exercise 2
		String folderPath = "C:\\Temp";
		List<String> listResult = interview.findLargeAndSmallFiles(folderPath, 1024 * 50, 10240);
		Iterator<String> files = listResult.iterator();
		while (files.hasNext()) {
			String file = (String) files.next();
			System.out.println(file);
		}
	}

	// Exercise 0
	//
	// Class definitions for Party and Organization are missing and you will
	// need to fill in the class definition.
	//
	// - "Party" is the root class.
	// - "Organization" and "Person" inherit from Party and they should have a data
	// member of 'FullName' either having it themselves or through inheritance.
	// - "Person" should have the data members of 'FirstName', 'LastName' and
	// 'FullName' either having them themselves or through inheritance.
	// - And 'FullName' = 'FirstName' + " " + "LastName"
	// - Example: FirstName = 'John' and LastName = 'Smith', FullName will be
	// 'John Smith'
	//
	// NOTE! NOTE! You have the freedom to design where the data members will be.
	// The above is just some general description for this exercise.
	//
	public static void ObjectTest() {
		Organization org = new Organization("CodeObjects");
		Person person = new Person("John", "Smith");

		ArrayList<Party> partyList = new ArrayList<Party>();
		partyList.add(org);
		partyList.add(person);

		for (Party p : partyList) {
			if (p.getFullName() != null) {
				if (p.getFullName().equals("John Smith")) {
					System.out.println("John Smith is found");
					break;
				}
			}
		}
	}

}

/**
 * A simple data structure to present a period. You can safely assume the end is
 * always greater than start
 */
class Period {
	public Date StartDate;
	public Date EndDate;

	public Period(String start, String end) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			this.StartDate = dateFormat.parse(start);
			this.EndDate = dateFormat.parse(end);

			if (this.StartDate.compareTo(this.EndDate) > 0) {
				throw new RuntimeException("The end date must be greater than the start date.");
			}
		} catch (ParseException ex) {
			throw new RuntimeException("Unable to prase the date", ex);
		}
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
}

class Interview {
	/**
	 * Exercise 1 Given a list of period to see if there is any period being
	 * overlapped Example: assuming we have the inputs like below Period 1: {
	 * "1/1/2016", "7/1/2016" } Period 2: { "3/1/2016", "12/1/2016" } Period 3: {
	 * "10/1/2016", "2/1/2017" } Period 4: { "5/1/2016", "6/15/2016" } We can see
	 * period 1, 2, 3 and 4 overlap with one another. Then this method should return
	 * true.
	 */
	
	public boolean hasOverlappedPeriod(Period[] periods) {
		boolean isOverLapped = Boolean.FALSE;
		for (int i = 0; i < periods.length; i++) {
			for (int j = 0; j < periods.length; j++) {
				if (i == j) {
					continue;
				} else {
					if (periods[j].getStartDate().after(periods[i].getStartDate())
							&& periods[j].getStartDate().before(periods[i].getEndDate())) {

						isOverLapped = Boolean.TRUE;
						break;
					}
				}
			}
		}
		return isOverLapped;
	}

	/**
	 * Exercise 2 To search the input folder and its children folders to find any
	 * file whose file size is either greater than the asking file size specified in
	 * 'largeFileSize' or less than the file size specified in 'smallFileSize'.
	 * 
	 * @return the list of files with the full path
	 * @throws Exception
	 */
	public List<String> findLargeAndSmallFiles(String searchFolder, long largeFileSize, long smallFileSize) {
		List<String> fileNames = new ArrayList<String>();
		File maindir = new File(searchFolder);

		if (maindir.exists() && maindir.isDirectory()) {
			File arr[] = maindir.listFiles();
			this.iterateOverFolders(arr, 0, largeFileSize, smallFileSize, fileNames);

		}

		return fileNames;
	}
	
	private void iterateOverFolders(File[] arr, int index, long largeFileSize, long smallFileSize,
			List<String> fileNames) {

		if (index == arr.length)
			return;

		if (arr[index].isFile()) {
			Path path = Paths.get(arr[index].getPath());
			long result = 0;
			try {
				result = Files.size(path);
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (result > largeFileSize || result < smallFileSize) {
				fileNames.add(arr[index].getPath());
			}
		} else if (arr[index].isDirectory()) {
			iterateOverFolders(arr[index].listFiles(), 0, largeFileSize, smallFileSize, fileNames);
		}

		iterateOverFolders(arr, ++index, largeFileSize, smallFileSize, fileNames);
	}
}

class Party {

	String firstName;
	String lastName;
	String fullName;

	public Party(String fullName) {
		super();
		this.fullName = fullName;
	}

	public Party(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {

		if (this.fullName != null) {
			return fullName;

		} else {
			return this.getFirstName() + " " + this.getLastName();
		}
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}

class Person extends Party {

	public Person(String firstName, String lastName) {
		super(firstName, lastName);
	}

}

class Organization extends Party {

	public Organization(String fullName) {
		super(fullName);
	}
}
