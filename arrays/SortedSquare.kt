fun main() {
  val inputArray = mutableListOf(-3,-2,-1)
  println("-------------- Sorted Square Array --------------")
  print("Input array -> ")
  println(inputArray)
  print("Output array -> ")
  println(sortedSquaredArray(inputArray))
}

// Solution:
// 1. Take two pointers as left and right
// 2. Initialize left as 0 and right to last index of input inputArray.
// 3. Initialize results array of size inputArray.size and currentIndex for the result array which start from end.
// 4. Start a loop and iterate till left <= right.
// 5.    In each iteration, check the abs(inputArray[left]) < abs(inputArray[right]) and do the following
// 6.    If the abs(inputArray[left]) is greater than or equal to, then take inputArray[left] square and put in the results[currentIndex].
// 7.       else put inputArray[right] square to result[currentIndex].
// 8.    Decrement currentIndex in each iteration.
// 9. Once the loop is finished, return the results array.

// Better solution: Time Complexity: O(N) , Space Complexity: O(N)
fun sortedSquaredArray(array: List<Int>): List<Int> {
	val results = MutableList<Int>(array.size) {0}
	var left = 0
	var right = array.size - 1
	var currentIndex = right
	while(left <= right){
		var square: Int
		if(Math.abs(array[left]) < Math.abs(array[right])) {
			square = array[right] * array[right]
            right--
		}
		else {
			square = array[left] * array[left]
            left++
		}
		results[currentIndex] = square
		currentIndex--
	}
    return results
}
