
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws Exception {
		//Relative file path of csv file to be tested
		//createUserMap takes the file path, parses the data, calls the mapUser method with the data as a parameter,
		//and then calls the sortMap method with the map created from the mapUser method as a parameter
		//Thus, createUserMap returns a fully sorted and duplicate ID eliminated map
		//All that is left is to print the map data to the respective csv files, which is what the csvWriter method does
		
		 csvWriter(createUserMap("C:\\Users\\jacob\\Software\\CSV\\src\\csv\\test.csv"));

	}
	
	//createUserMap parses data from csv file and calls both the mapUser method and sortMap method
	//Returns the sorted and duplicate id eliminated map 
	
	public static Map<String, List<User>> createUserMap(String s) throws Exception{
		File file = new File(s);
		  
		//Read text from csv file
		  BufferedReader input = new BufferedReader(new FileReader(file));
		  
		  //Initialization of string to hold each line of csv file
		  String line;
		 
		  //initialize the userMap
		   Map<String, List<User>> UserMap = new HashMap<>();
		  
		   //Parse each csv line by comma into array 
		  while ((line = input.readLine()) != null) {
			 String[] lineArray = line.split(",", 6);
		    int i=Integer.parseInt(lineArray[3].trim());  
		    User user = new User(lineArray[0], lineArray[1], lineArray[2], i, lineArray[4]);
		   
		    //Call mapUser method to place user entry into map
		    mapUser(user, UserMap);
		  }
			
		  //call sortMap method to sort list by last and first name ascending
		  sortMap(UserMap);
			
		  //return sorted list
		  return UserMap;  
		    
	}
	
	//mapUser method to place User objects into map
	public static void mapUser(User user, Map<String, List<User>> UserMap) {
		
		 //If map is empty, make make a new list and add User. Add list to map.
		//Map key is the insurance business, and value is a list of User objects
		
		 if(UserMap.size() == 0) {
			 List<User> newList = new ArrayList<User>();
			 newList.add(user);
				UserMap.put(newList.get(0).insurance, newList);
			}else {
				
				//if map is not empty, loop through each map entry
				
				boolean uniqueBussines = true;
			for (Map.Entry<String,List<User>> entry : UserMap.entrySet()) {
				
				//if entry's key(insurance business) is equal to the User object's insurance value
				
			 if(entry.getKey().equals(user.insurance)) {
				 boolean uniqueID = true;
				 
				 //Loop through all User objects in the list 
				 
				 for(User users: entry.getValue()) {
					 
					 //compare user object's id values in the list to the current user's id value
					 
					if(users.userID.equals(user.userID)) {
						
						//if they are the same id, compare version int
						
						if(users.version < user.version) {
							
							//if the list's user version is less than current user's version
							//remove list user and add current user
							
							entry.getValue().remove(users);
							entry.getValue().add(user);
							uniqueID = false;
							uniqueBussines = false;
							break;
						}
					}
				 }
				 //if the current user's id is unique, add to that insurance's list
				 
				 if(uniqueID == true) {
					 entry.getValue().add(user);
					 uniqueBussines = false;
				 }
				 
			 }
			 
		 }
			//if the current user's insurance is unique, make a new list, add the User object, and the add list to map
			
			if(uniqueBussines == true) {
				List<User> newList = new ArrayList<User>();
				 newList.add(user);
					UserMap.put(newList.get(0).insurance, newList);
			}
			}

	}
	
	//sortMap method that uses a Comparator to compare last then first name 
	
	public static void sortMap( Map<String, List<User>> UserMap) {
		for(List<User> user: UserMap.values()) {
			Collections.sort(user, new Comparator<User>(){

				
				@Override
				public int compare(final User o1,final User o2) {
					int result = o1.lastName.compareTo(o2.lastName);
					
					//if the last names are not equal, sort by last name
					if (result != 0) {
						return result;
					}
					//if last names are equal, sort by first name
	                return o1.firstName.compareTo(o2.firstName);   
				}
				
			});
		}
	}

	//csvWriter method that writes map data to their respective insurance csv files
	public static void csvWriter(Map<String, List<User>> userMap) throws Exception {
		
		
		//Loop through map elements, which are Lists of User objects with the same insurance business,
		for(Entry<String, List<User>> user: userMap.entrySet()) {
				
			//Try creating new file writer
			 try (PrintWriter csvWriter = new PrintWriter(new File(user.getValue().get(0).insurance+".csv"))) {

				 //String builder that allows for appending strings together
				 StringBuilder line = new StringBuilder();
				 
				 //first column data
				 
				 line.append("user id");
					line.append(",");
					line.append("first name");
					line.append(",");
					line.append("last name");
					line.append(",");
					line.append("version");
					line.append(",");
					line.append("insurance company");
					line.append("\n");
			
			//loop through each User object in list
			for(User userInfo: user.getValue()) {
				
				//append User object elements to the string in csv format
				line.append(userInfo.userID);
				line.append(",");
				line.append(userInfo.firstName);
				line.append(",");
				line.append(userInfo.lastName);
				line.append(",");
				line.append(String.valueOf(userInfo.version));
				line.append(",");
				line.append(userInfo.insurance);
				line.append("\n");
		
			}
			//write string to csv file, named by insurance company
			csvWriter.write(line.toString());

			
			 } catch (FileNotFoundException e) {
			      System.out.println(e.getMessage());
			    }
			
		}
	}

}
