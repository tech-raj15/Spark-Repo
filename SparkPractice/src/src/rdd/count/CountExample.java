package src.rdd.count;

public class CountExample {

    static void generateString(int A, int B) {
	String rt = "";
	while (0 < A || 0 < B) {

	    // More 'b', append "bba"
	    if (A < B) {
		if (0 < B--) {
		    rt += ('b');
		}
		if (0 < B--) {
		    rt += ('b');
		}
		if (0 < A--) {
		    rt += ('a');
		}
	    }

	    // More 'a', append "aab"
	    else if (B < A) {
		if (0 < A--) {
		    rt += ('a');
		}
		if (0 < A--) {
		    rt += ('a');
		}
		if (0 < B--) {
		    rt += ('b');
		}
	    }

	    // Equal number of 'a' and 'b'
	    // append "ab"
	    else {
		if (0 < A--) {
		    rt += ('a');
		}
		if (0 < B--) {
		    rt += ('b');
		}
	    }
	}
	System.out.println(rt);
    }

    // Driver code
    public static void Main(String[] args) {
	int A = 2, B = 6, C = 3;
	generateString(A, B);
    }

}
