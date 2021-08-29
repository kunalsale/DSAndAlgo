// Find a number in an array where all the element on the left side are smaller than the 
// element and all the element on the right side are greater than the element.

// Example: 6  2  5  4  7  9  11  8  10 
// Here the element is 7 as elements on the left 6, 2, 5, 4 < 7
// and the elements on the right are greater 9, 11, 8, 10 > 7

// Contraints: 
// Time complexity has to O(n)
// No contraints on the Space as it can be used

// Approach:
// Any given element to be the answer of the problem has to be greater than the largest on // the left side and smaller than the smallest on the left side. 

// As for 7, 6 was the largest element on the left and 8 was the smallest on the right.
// 1. Take array for computing the left largest element for the current element.
// Assign the first element in the left array as Int.MIN_VALUE and the start the iteration // from second element.
// left = [Int.MIN_VALUE, 6, 6, 6, 6, 7, 9, 11, 11] 
// 2. Now for right minimum computation take one pointer which will be rightMininum = 
// Int.MAX_VALUE.
// right = [2 ,4 ,4 ,7 , 8, 8, 8, 10, Int.MAX_VALUE] 
// 3. Then iterate from the last element 
//    a. If left[i] < array[i] && right < array[i]
//    		return i
//.   b. else right = Math.min(array[i], right)

fun main() {
	val inputArray = intArrayOf(6, 2, 5, 4, 9, 11, 8, 10)
	println("Input array -> $inputArray")
	println("Number is "+findNumber(inputArray))
}

fun findNumber(inputArray: IntArray): Int {
	val size = inputArray.size

	val leftArray = IntArray(size)
	leftArray[0] = Int.MIN_VALUE

	for(i in 1 .. size - 1) {
		leftArray[i] = Math.max(inputArray[i - 1], leftArray[i - 1])
	}

	var rightMin = Int.MAX_VALUE
	for(i in (size - 1) downTo 0) {
		val currentElement = inputArray[i]
		if(leftArray[i] < currentElement && rightMin > currentElement) {
			return currentElement
		}
		rightMin = Math.min(currentElement, rightMin)
	}

	return -1
}



























