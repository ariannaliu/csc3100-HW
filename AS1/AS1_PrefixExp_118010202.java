import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PREFIX {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.valueOf(in.readLine());
        int size = -1;
        long a;
        long b;
        long c;
		
        // all the string is stored in the init_arr
        String init_arr[] = new String[k];
        String init_target;
        for(int j = 0 ; j<k ; j++) {
        	init_target = in.readLine();
        	init_arr[j] = init_target;
        }
        
        long arr[] = new long [k];
        long num_target;
        String target;
        for (int i = init_arr.length-1; i>=0; i--) {
        	target = init_arr[i];
        	

        	if(target.charAt(0) == '+') {
        		// get the + operation
        		if(size <= 0) {
        			System.out.print("Invalid\n");
        			return;
        		}
        		else {
        			// there are at least two element in an array
        			a = arr[size-1];
        			b = arr[size];
        			c = Math.floorMod(a+b,1000000007L);
        			size -= 1;
        			arr[size] = c;
        		}
        	}
        	else if(target.charAt(0)=='-') {
        		//get a - operation
        		if(size <= 0) {
        			System.out.print("Invalid\n");
        			return;
        		}
        		else {
        			a = arr[size-1];
        			b = arr[size];
        			c = Math.floorMod(b-a,1000000007L);
        			size -= 1;
        			arr[size] = c;
        		}
        	}
        	else if(target.charAt(0)=='*') {
        		//get a - operation
        		if(size <= 0) {
        			System.out.print("Invalid\n");
        			return;
        		}
        		else {
        			a = arr[size-1];
        			b = arr[size];
        			c = Math.floorMod(a*b,1000000007L);
        			size -= 1;
        			arr[size] = c;
        		}
        	}
        	else {
        		num_target = Long.valueOf(target);
        		size += 1;
        		arr[size] = Math.floorMod(num_target,1000000007L);
        	}
		}
        System.out.print(arr[0]);
	}
}
