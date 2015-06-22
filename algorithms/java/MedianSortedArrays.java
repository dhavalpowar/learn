import java.util.Arrays;

public class MedianSortedArrays {
	public static double findMedianSortedArrays(int[] A, int[] B) {
		int aLen = A.length;
		int bLen = B.length;	
		int abLen = aLen+bLen;
		int temp;
		int [] tempArr;
		//Assigning array A to be the smaller of the two elements
		if(aLen > bLen) {
			temp = aLen;
			aLen = bLen;
			bLen = temp;
			tempArr = A;
			A = B;
			B = tempArr;
		}


		int aStartIndex = 0;
		int aEndIndex = aLen-1;
		int bStartIndex = 0;
		int bEndIndex = bLen-1;
		int aMid = (aLen % 2 == 0 && aLen > 0) ? (aLen/2 - 1) : (aLen/2);
		int bMid = (bLen % 2 == 0 && bLen > 0) ? (bLen/2 - 1) : (bLen/2);
		
		int i, j;
		double median = -1;

		//Special cases
		if(aLen == 0 && bLen == 0) {
			return 0;
		}
		//If array A is empty
		else if(aLen == 0) {
			if(bLen == 1) {
				return (double) B[0];
			}
			//If length of array B is even
			else if(bLen % 2 == 0) {
				return (double)(B[bLen/2-1] + B[bLen/2]) / 2;
			}
			//If length of array B is odd
			else {
				return (double)B[bLen/2];
			}
		}
		//If array A has 1 element
		else if(aLen == 1) {
			//If array B has only one element
			if(bLen == 1) {
				return (double)(A[0] + B[0]) / 2;
			}
			//If array B has even number of elements
			else if(bLen % 2 == 0) {
				//If array B has middle element greater than A[0]
				if(A[0] <= B[bMid]) {
					return (double)B[bMid];
				}
				//If A[0] is greater than mid of B and lesser than (mid+1) of B 
				else if(A[0] > B[bMid] && A[0] <= B[bMid+1]) {
					return (double)A[0];
				}
				//If A[0] is greater than both, mid and (mid+1) of B
				else if(A[0] > B[bMid] && A[0] > B[bMid+1]) {
					return (double)B[bMid+1];
				}
			//If array B has odd number of elements
			} else {
				//If array B has middle element greater than A[0]
				if(A[0] < B[bMid] && A[0] < B[bMid-1]) {
					return (double)(B[bMid] + B[bMid-1]) / 2;
				}
				else if(A[0] <= B[bMid] && A[0] > B[bMid-1]) {
					return (double)(A[0] + B[bMid]) / 2;
				}
				//If A[0] is greater than mid of B and lesser than (mid+1) of B 
				else if(A[0] > B[bMid] && A[0] <= B[bMid+1]) {
					return (double)(A[0] + B[bMid]) / 2;
				}
				//If A[0] is greater than both, mid and (mid+1) of B
				else if(A[0] > B[bMid] && A[0] > B[bMid+1]) {
					return (double)(B[bMid] + B[bMid+1]) / 2;
				}
			}
		}
		//If array A has 2 elements
		// else if(aLen == 2) {
		// 	//If array B has 2 elements, find median of 4 elements
		// 	int[] arr;
		// 	if(bLen == 2) {
		// 		arr = new int[4];
		// 		arr[0] = A[0];
		// 		arr[1] = A[1];
		// 		arr[2] = B[0];
		// 		arr[3] = B[1];

		// 		return MedianOfFour(arr,true);
		// 	}
		// 	//If array B has even number of elements
		// 	else if(bLen % 2 == 0) {
		// 		arr = new int[4];
		// 		arr[0] = B[bMid];
		// 		arr[1] = B[bMid-1];
		// 		arr[2] = Math.max(A[0], B[bMid-2]);
		// 		arr[3] = Math.min(A[1], B[bMid+1]);

		// 		return MedianOfFour(arr,true);
		// 	//If array B has odd number of elements
		// 	} else {
		// 		arr = new int[3];
		// 		arr[0] = B[bMid];
		// 		arr[1] = Math.max(A[0], B[bMid-1]);
		// 		arr[2] = Math.min(A[1], B[bMid+1]);

		// 		Arrays.sort(arr);
		// 		return (double) arr[1];
		// 	}
		// }
		//Normal cases
		else {
			System.out.println("Normal");
			//Run while we 2 elements for each array
			while((aEndIndex-aStartIndex) != 1 || (bEndIndex-bStartIndex) != 1) {
				System.out.println("aStartIndex: "+ aStartIndex + "\t\taEndIndex: "+ aEndIndex+"\t\taMid: "+aMid);
				System.out.println("bStartIndex: "+ bStartIndex + "\t\tbEndIndex: "+ bEndIndex+"\t\tbMid: "+bMid+"\n\n");

				//If current median are equal
				if(A[aMid] == B[bMid]) {
					if(abLen % 2 == 0){
				        aStartIndex = aMid;
				        aEndIndex = aMid+1;
				        bStartIndex = bMid;
				        bEndIndex = bMid+1;
				    } else {
				        return A[aMid];
				    }
				} else if(A[aMid] > B[bMid]) {
					if(aStartIndex != aEndIndex-1) {
						aEndIndex = aMid;
					}
					//if(bMid != bStartIndex+1) {
						bStartIndex = bMid;
					//}
				} else if(A[aMid] < B[bMid]) {
					//if(aMid != aStartIndex) {
						aStartIndex = aMid;
					//}
					if(bStartIndex != bEndIndex-1) {
						bEndIndex = bMid;
					}
				}
				aMid = (aStartIndex + aEndIndex) / 2;
				bMid = (bStartIndex + bEndIndex) / 2;

				System.out.println("aStartIndex: "+ aStartIndex + "\t\taEndIndex: "+ aEndIndex+"\t\taMid: "+aMid);
				System.out.println("bStartIndex: "+ bStartIndex + "\t\tbEndIndex: "+ bEndIndex+"\t\tbMid: "+bMid+"\n\n");

			}

			int [] arrOfFour = new int[4];
			arrOfFour[0] = A[aStartIndex];
			arrOfFour[1] = A[aEndIndex];
			arrOfFour[2] = B[bStartIndex];
			arrOfFour[3] = B[bEndIndex];

			if(abLen % 2 == 0) {
				median =  MedianOfFour(arrOfFour, true);
			} else {
				median =  MedianOfFour(arrOfFour, false);
			}

		}
		return median;
	}

	/**
	 * Returns median of 4 numbers based on isEven flag
	 */
	public static double MedianOfFour(int[] arr, boolean isEven) {
		if(arr.length == 4) {
			Arrays.sort(arr);
			if(isEven) {
				return (double)(arr[1]+arr[2]) / 2;
			} else {
				return (double)arr[1];
			}
		}
		return -1;
	}

	public static void main(String [] args) {
		int[] A = {1,2};
		int[] B = {1,2,3};

		System.out.println(findMedianSortedArrays(A,B));
	}
}
