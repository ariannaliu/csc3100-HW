import java.io.IOException;
import java.io.DataInputStream;
import java.io.FileInputStream;
public class mSort {
	public static void merge_sort(long[] A, int left, int right) {
		if(right>left) {
			int center = (left + right)/2;
			
			//divide
			merge_sort(A, left,center);
			merge_sort(A, center+1, right);
			
			//conquer
			merge(A,left,center,right);
		}
		else {
			return;
		}
	}
	
	private static void merge(long[] A, int left, int center, int right) {
		int n1 = center - left + 1;
		int n2 = right - center;
		long[] L = new long[n1+1];
		long[] R = new long[n2+1];
		for (int i=0; i<n1; i++) {
			L[i] = A[left+i];
		}
		for (int j=0; j<n2; j++) {
			R[j]=A[center+1+j];
		}
		L[n1] = 9223372036854775807L;
		R[n2] = 9223372036854775807L;
		int m = 0;
		int n = 0;
		for(int k=left; k<=right; k++) {
			if(L[m]<=R[n]) {
				A[k] = L[m];
				m++;
			}else {
				A[k] = R[n];
				n++;
			}
		}		
	}
	
	
	
	static class Reader{
		final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
        
        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        
        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }
        
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public char nextChar() throws IOException {
            return (char) read();
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
	}
	
//	public static void main(String[] args) throws IOException{
//		Reader in  = new Reader();
//		int k = in.nextInt();
	public static void main(String[] args) throws IOException {
		
        Reader in = new Reader();
        int k = in.nextInt();

        // Use .nextInt() to get next integer
        long arr[] = new long[k];
        for (int i = 0; i < k; i++) {
            arr[i] = in.nextInt();
        }

        mSort.merge_sort(arr,0,k-1);
        for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + "\n");
		
	}
}
