package vijay.randomNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*********
 * 
 * @author vijay sani
 *
 *Random numbers generated for a given range , can be used in N-puzzle game(Mystic Square )
 */
public class RandomNumber {

	public static void main(String []args){
		//Variable Declaration and initialization.
		int i=0,rand=0,roundExponential=0,roundedValue=0,uniqueArraySize=0;
		boolean validarray=false;
		HashMap<Integer,Integer> maparray = null;
		
		//Accept the input from user
		System.out.println("Enter the maximum value of the random numbers to be generated:");
		Scanner arraySize=new Scanner(System.in);
		String range=arraySize.next();
		
		roundExponential= range.length();
		//convert the random number from double to integer value, use roundExponential to convert the value into 2-digit,3-digit accordingly depending on the range.
		roundedValue=(int)Math.pow(10, roundExponential);
		
		//use the max-range value for array-size
		uniqueArraySize=Integer.parseInt(range);
		
		//use a hashmap variable as hashmap accepts only unique key values (in our case we can use the random generated as the unique key to 
		//store the value and avoid storing identical key values ), but since hashmap sorts the key in the order, but it helps store unsorted values in array uniqueArray 
		maparray = new HashMap<Integer, Integer>(); 
	    
	    int[] uniqueArray=new int[uniqueArraySize];
		while(validarray==false){
			rand=(int)(Math.random()*roundedValue);
			rand=(rand % uniqueArraySize)+1;//modulus operator gives us only the numbers inside that maximum range
			System.out.println("random:"+rand);
			if(!maparray.containsKey(rand)){ //check if the new random number generated was previously generated if not then put the value in hashmap and use it future checking
				maparray.put(rand, rand);
				uniqueArray[i]=rand; //Store the non-repated generated random numbers in this array
				i++;
			}
			System.out.println("maparray"+maparray.toString());
			if(maparray.size()==uniqueArraySize-1){
				validarray=true; //stop the while loop when we have the generated all the numbers in the given range
			}
		}
		System.out.println("maparray"+maparray);
		for(i=0;i<uniqueArraySize-1;i++){
			System.out.print(" "+uniqueArray[i]);//print the random numbers generated in the given range.
		}
	}
}
