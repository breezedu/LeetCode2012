package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

/******************
 * Given a string containing only digits, 
 * restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * @author Frog
 *
 */
public class RestoreIPAddress {

	public static void main(String[] args){
		
		System.out.println("This is Restore IP Address program.");
		
		//1st, ask user to input a string of integers as the ip address
		System.out.println("Please input the IP address:");
		Scanner input = new Scanner(System.in);
		System.out.print("IP = ");
		String ip = input.next();
		input.close();
		
		
		//2nd, divide the string, store all possible ip addresses (a string with dot) into an arrayList
		ArrayList<String> ipAddress = restoreIpAddresses(ip);
		
		//printout the ip-addresses arrayList
		printArrayList(ipAddress);
		
		
	}//end main()

	private static ArrayList<String> restoreIpAddresses(String ip) {
		// TODO Auto-generated method stub
		ArrayList<String> ipSets = new ArrayList<String>();
		if(ip.length() > 12 || ip.length()<3) return ipSets;
		
		int count = 4; //there are 4 sections of ip address
		String currentIP = "";
		checkIpSections(ip, count, currentIP, ipSets);		
		
		return ipSets;
	}//end restoreIpAddresses() method;

	private static void checkIpSections(String ip, int count, String currentIP, ArrayList<String> ipSets) {
		// TODO Auto-generated method stub
	//	if(ip.length()>(count*3)) return;
		
		if(count==1 && validSection(ip)){
			currentIP += ip;
			ipSets.add(currentIP);
			return;
					
		} else {
			for(int i=1; i<4 && i<ip.length(); i++){
				String nextSection = ip.substring(0, i);
				
				if(validSection(nextSection)){
					int countNext = count-1;  // countNext = count-- does not work.
					String ipNext = ip.substring(i);
					String currentNext = currentIP + nextSection +".";
					checkIpSections(ipNext, countNext, currentNext, ipSets);
				}
				
			}//end for i<4/ip.length() loop;
			
		}	
		
	}//end checkIpSections() method

	private static boolean validSection(String ip) {
		// TODO check if the last few digits is a valid ip-section
		if(ip.charAt(0) == '0') return ip.equals("0"); //this is very important, try ip=010010 :)
				
		int num = Integer.parseInt(ip); 
		return num<=255 && num>=0;
	}

	private static void printArrayList(ArrayList<String> str) {
		// TODO printout every string in an arrayList
		if(str==null || str.size()==0) return;
		for(String e:str){
			System.out.println(" " + e);
		}
		
		System.out.println();
	}//end of printArrayList() method
	
	
}//end of everything in RestoreIPAddress class
