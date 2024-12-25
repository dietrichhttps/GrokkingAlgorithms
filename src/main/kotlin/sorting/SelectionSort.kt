package sorting

class SelectionSort(
    private val numbers: MutableList<Int>
) {

    private fun findSmallest(): Int {
        var smallest = numbers[0]
        var smallestIndex = 0
        for (i in 1 until numbers.size) {
            if (numbers[i] < smallest) {
                smallest = numbers[i]
                smallestIndex = i
            }
        }
        return smallestIndex
    }

    fun selectionSort(): List<Int> {
        val sortedNumbers = mutableListOf<Int>()
        while (numbers.isNotEmpty()) {
            val smallestIndex = findSmallest()
            sortedNumbers.add(numbers[smallestIndex])
            numbers.removeAt(smallestIndex)
        }
        return sortedNumbers
    }
}