// Got some problem (Cause i misunderstood the hashing method), will fix later 

public class MatricLinearProbing {
	private static final int SIZE=50; 
	private long hashTable[];
	private static int modValue = 7;
	
	// constructor
	public Matric() {
		this(SIZE);
	}
	
	public Matric(int N) {
		hashTable = new long[N];
		for (int counter = 0; counter < N; counter ++) {
			// Take 0 to be null value
			hashTable[counter] = (long) -1;
		}
	}
	
	// Add key function
	public void insertKey(String key) {
		// Convert String to integer 
		long longKey = convertKey(key);
		//hash function 
		int index = (int)(longKey % (long)modValue);
		while ((index < SIZE - 1)) {
			if (!isFull(index)) {
				hashTable[index] = longKey;
				System.out.println("Key inserted.");
				return;
			}
			else if (hashTable[index] == longKey) {
				System.out.println("Key already exist in database.");
				return;
			}
			index++;
		}
		System.out.println("Unable to insert key.");
	}
	
	// Search key function
	public int searchKey(String key) {
		// Convert to long key
		long longKey = convertKey(key);
		// initial hash function 
		int index = (int) (longKey % (long)modValue);
		// keep searching unless empty(if empty means cannot be inside) or exceed size
		while ((index) < (SIZE-1) || !isFull(index)) {
			if (longKey == hashTable[index]) {
				System.out.println("Key found at index " + index);
				return (index);
			}
		}
		// key not in hashTable
		System.out.println("Key not found.");
		return (-1);
	}
	
	// Delete key function
	public void deleteKey(String key) {
		// get location of key
		int index = searchKey(key);
		if (index == -1) {
			System.out.println("Key doesnt exist already.");
		}
		else {
			hashTable[index] = (long)-1;
			System.out.println("Key removed.");
		}
	}
	
	
	// Other functions
	public boolean isFull(int cot) {
		if (hashTable[cot] == -1)
			return false;
		else
			return true;
	}
	
	public long convertKey(String key) {
		// accept error for invalid key?
		char firstChar = key.charAt(0);
		char lastChar = key.charAt(key.length()-1);
		String resultKey = (int)firstChar + key.substring(1, 8) + (int)lastChar;
		long longKey = Long.parseLong(resultKey);
		return longKey;
		
	}
	
	public void printHashTable() {
		for (int i = 0; i < SIZE; i ++) {
			System.out.println(i + " " + hashTable[i]);
		}
	}
}