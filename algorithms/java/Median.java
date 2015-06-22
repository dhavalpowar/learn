public class Median {
	public static double findMedianSortedArrays(int A[], int B[]) {
		if(A.length == 0) {
			if(B.length % 2 == 0) {
				return (double)(B[B.length/2]+B[(B.length/2) - 1])/2;
			} else {
				return (double)B[B.length/2];
			}
		} else if(B.length == 0) {
			if(A.length % 2 == 0) {
				return (double)(A[A.length/2]+A[(A.length/2) - 1])/2;
			} else {
				return (double)A[A.length/2];
			}
		} else {
			int m1 = 0, m2 = A.length, n1 = 0, n2 = B.length;
			while(m2-m1 > 1 && n2-n1 > 1 ) {
				if(A[(m2+m1)/2] == B[(n2+n1)/2]) {
					System.out.println("Inside equal");
					if(A.length % 2 == 0 && B.length % 2 == 0) {
						System.out.println("Inside even");
						return (double)(Math.max(A[(m2+m1)/2-1], B[(n2+n1)/2-1]) + Math.min(A[(m2+m1)/2], B[(n2+n1)/2]))/2;
					}
					return (double)A[(m2+m1)/2];
				} else if(A[(m2+m1)/2] > B[(n2+n1)/2]){
					
					System.out.println("Inside equal");
					m2 = (m2+m1)/2;
					n1 = (n2+n1)/2;
				} else if(A[(m2+m1)/2] < B[(n2+n1)/2]){
					
					System.out.println("Inside equal");
					m1 = (m2+m1)/2;
					n2 = (n2+n1)/2;
				}
			}

			return (double)(Math.max(A[m1], B[n1]) + Math.min(A[m2], B[n2]))/2;
		}
	}

	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{1,2}));
	}
}
