fun main() {
	val inputArray = intArrayOf(6, 15, 35, 45, 29, 3, 2)
	println("Input array -> $inputArray")
	println("Max value is "+searchMaximumValueUsingBinary(inputArray, 0, inputArray.size - 1))
}

fun searchMaximumValueLinearly(array: IntArray): Int {
	var maxValue = Int.MIN_VALUE
	for(element in array) {
		if(element > maxValue) {
			maxValue = element
		}
	}
	return maxValue
}

fun searchMaximumValueUsingBinary(array: IntArray, low: Int, high: Int): Int {
	if(low == high) {
		return array[low]
	}

	if(high == low + 1) {
		return Math.max(array[low], array[high])
	}

	val mid = (low + high) / 2
	if(array[mid] > array[mid + 1] && array[mid] > array[mid - 1]) {
		return array[mid]
	}

	if(array[mid] < array[mid + 1] && array[mid] > array[mid - 1]) {
		return searchMaximumValueUsingBinary(array, mid + 1, high)
	}
	else {
		return searchMaximumValueUsingBinary(array, low, mid - 1)
	}
}