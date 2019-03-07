import java.util.Scanner;
public class StackDemo {

	public static void main(String [] args) {
		Scanner keyboard = new Scanner(System.in);
		StackInterface<CompactDisc> notEngStack = new ArrayBasedStack<CompactDisc>(2);
		StackInterface<CompactDisc> RushStack = new ArrayBasedStack<CompactDisc>(2);
		StackInterface<CompactDisc> PinkStack = new ArrayBasedStack<CompactDisc>(2);
		StackInterface<CompactDisc> IronStack = new ArrayBasedStack<CompactDisc>(2);
		StackInterface<CompactDisc> remainingStack = new ArrayBasedStack<CompactDisc>(2);
		StackInterface<CompactDisc> inUseStack = new ArrayBasedStack<CompactDisc>(10);
		 
		boolean ans;
		String language;
		int press = 0;
		String removeAns;
		boolean isEng;
		int totalStack = 0;
		
		
				do {
					System.out.println();
					System.out.println("Press 1 to add the CD to stack");
					System.out.println("Press 2 to look at the top of non-English stack");
					System.out.println("Press 3 to look at the top of Rush stack");
					System.out.println("Press 4 to look at the top of Pink Floyd stack");
					System.out.println("Press 5 to look at the top of Iron Maiden stack");
					System.out.println("Press 6 to look at the top of remaining stack");
					System.out.println("Press 7 to look at the top of in-use stack");
					System.out.println("Press 8 to remove CD from satck");
					System.out.println("Press 9 to look at each size of all stacks");
					System.out.println("Press 10 to look at all stacks size in total");
					System.out.println("Press 11 to look at the contents of each stack");
					System.out.println("Press 12 to end the program");
					press = keyboard.nextInt();
					
					keyboard.nextLine();
						if(press ==1) {
							System.out.println("Enter CDs information"); 
							System.out.println("Please enter by example format");
								
								System.out.println("Enter artist name, ex Rush");
								String artist = keyboard.nextLine();
								
								System.out.println("Enter album name, ex Presto");
								String album = keyboard.nextLine();
								
								System.out.println("Enter the language of the lyric, ex English");
								language = keyboard.nextLine();			
								
								CompactDisc currentCDs = new CompactDisc();
								currentCDs.setArtist(artist);
								currentCDs.setAlbum(album);
								currentCDs.setLanguage(language);
								
								if(!"English".equals(language)) {
									try {
										System.out.println("CD is being added to non-English stack");
										notEngStack.push(currentCDs);
									}
									catch(StackFullException e) {
										System.out.println("No non-English CD to be added!");
									}
								}	
								
								else if("Rush".equals(artist)) {
									try {
										System.out.println("CD is being added to Rush stack");
										RushStack.push(currentCDs);
												
									}
									catch(StackFullException e) {
										System.out.println("No more Rush CD to be added");
										
									}
									
								}
								
								else if("Pink Floyd".equals(artist)) {
									try {
										System.out.println("CD is being added to Pink Floyd stack");
										PinkStack.push(currentCDs);
									}
									catch(StackFullException e) {
										System.out.println("No more Pink Floyd to be added");
									}
								}
								
								else if("Iron Maiden".equals(artist)) {
									try {
										System.out.println("CD is being added to Iron Maiden stack");
										IronStack.push(currentCDs);
									}
									catch(StackFullException e) {
										System.out.print("No more Iron Maiden CD to be added");
									}
								}
								
								else {
									try {
										System.out.println("CD is being added to remaining English stack");
										remainingStack.push(currentCDs);
									}
									catch(StackFullException e) {
										System.out.print("No more remaining CD to be added");
									}
								}
						}	
						if(press == 2) { 
							try {
								System.out.println("Top of non-Eng CD is : " + notEngStack.top());
							}
							catch(StackEmptyException e) {
								System.out.println("No more non-English CD to look at");
							}
						}
						
						if(press == 3) {
							
							try {
								System.out.println("Top of Rush CD is : " + RushStack.top());
							}
							catch(StackEmptyException e) {
								System.out.println("No more Rush CD to look at");
							}
						}
						if(press == 4) {
							try {
								System.out.print("Top of Pink Floyd CD is : " + PinkStack.top());
							}
							catch(StackEmptyException e) {
								System.out.println("No more Pink Floyd CD to look at");
							}
						}
						if(press == 5) {
							try {
								System.out.print("Top of Iron Stack CD is : " + IronStack.top());
							}
							catch(StackEmptyException e) {
								System.out.println("No more Iron Maiden CD to look at");
							}
						}
						if(press == 6) {
							try {
								System.out.print("Top of remainding CD is : " + remainingStack.top());
							}
							catch(StackEmptyException e) {
								System.out.println("No more remaining CD to look at");
							}
						}
						if(press == 7) {
							try {
								System.out.print("Top of in-use CD is : " + inUseStack.top());
							}
							catch(StackEmptyException e) {
								System.out.println("No more in-use CD to look at");
							}
						}
							
						if(press == 8) {
							System.out.println("Is the CD that you want to remove is in English language? true/false");
							isEng = keyboard.nextBoolean();
							if(isEng == false) {
								try {
									System.out.println("CD is being removed from non-English stack");
									CompactDisc tempCD = new CompactDisc();
									tempCD = notEngStack.top();
									notEngStack.pop();
									
									try {
										inUseStack.push(tempCD);
									}
									catch(StackFullException e) {
										System.out.println("Can't remove non-Eng CD. In-use stack is full");
									}
								}
								catch(StackEmptyException e) {
									System.out.println("No more non-Eng CD to remove to in-use stack");
								}
							}
						
							else if(isEng == true) {
								keyboard.nextLine();
								System.out.println("Select stack that you want to remove CD from: Rush/Pink Floyd/Iron Maiden/something else");
								removeAns = keyboard.nextLine();
								if(removeAns.equals("Rush")) {
									try {
										System.out.println("Rush CD is being removed from Rush stack");
										CompactDisc tempCD = new CompactDisc();
										tempCD = RushStack.top();
										RushStack.pop();
										try {
											inUseStack.push(tempCD);
										}
										catch(StackFullException e) {
											System.out.println("Can't remove Rush CD. In-use stack is full");
										}
									}
									catch(StackEmptyException e) {
										System.out.println("No more Rush CD to remove to in-use stack");
									}
									
								}
								else if(removeAns.equals("Pink Floyd")) {
									try {
										System.out.println("Pink Floyd CD is being removed from Rush stack");
										CompactDisc tempCD = new CompactDisc();
										tempCD = PinkStack.top();
										PinkStack.pop();
										try {
											inUseStack.push(tempCD);
										}
										catch(StackFullException e) {
											System.out.println("Can't remove Pink Floyd CD. In-use stack is full");
										}
									}
									catch(StackEmptyException e) {
										System.out.println("No more Pink Floyd CD to remove to in-use stack");
									}
									
								}
								else if(removeAns.equals("Iron Maiden")) {
									try {
										System.out.println("Iron Maiden CD is being removed from Iron Maiden stack");
										CompactDisc tempCD = new CompactDisc();
										tempCD = IronStack.top();
										IronStack.pop();
										try {
											inUseStack.push(tempCD);
										}
										catch(StackFullException e) {
											System.out.println("Can't remove Iron Maiden CD. In-use stack is full");
										}
									}
									catch(StackEmptyException e) {
										System.out.println("No more Iron Maiden CD to remove to in-use stack");
									}
								}
								else if(removeAns.equals("something else")) {
									try {
										System.out.println("remaining CD is being removed from Rush stack");
										CompactDisc tempCD = new CompactDisc();
										tempCD = remainingStack.top();
										remainingStack.pop();
										try {
											inUseStack.push(tempCD);
										}
										catch(StackFullException e) {
											System.out.println("Can't remove remaining CD. In-use stack is full");
										}
									}
									catch(StackEmptyException e) {
										System.out.println("No more remaining CD to remove to in-use stack");
									}
								}
							}
						}
						if(press == 9) {
							
							System.out.println("Size of non-Eng stack is: " + notEngStack.size());
							System.out.println("Size of Rush stack is: " + RushStack.size());
							System.out.println("Size of Pink Floyd stack is: " + PinkStack.size());
							System.out.println("Size of Iron Maiden stack is: " + IronStack.size());
							System.out.println("Size of remaining stack is: " + remainingStack.size());
							System.out.println("Size of in-use stack is: " + inUseStack.size());
						}
						if(press == 10) {
							totalStack = notEngStack.size() + RushStack.size() + PinkStack.size() +IronStack.size() +remainingStack.size()+ inUseStack.size();
							System.out.println("All size stacks in total is :" + totalStack);
						}
						if(press == 11) {
							
							System.out.println("Non-Eng stack contents : " + notEngStack.toString());
							System.out.println("Rush stack content : " + RushStack.toString());
							System.out.println("Pink Floyd stack content : " + PinkStack.toString());
							System.out.println("Iron Maiden stack content : " + IronStack.toString());
							System.out.println("Remaining stack content : " + remainingStack.toString());
							System.out.println("In-use stack content : " + inUseStack.toString());
							
							
						}	
						if(press == 12) {
							System.out.println("Program has ended. Good bye.");
						}
						
						
					}
					while(press != 12);
				}
		}

					
					



		

