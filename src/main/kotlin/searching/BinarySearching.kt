package searching

class BinarySearching(
    private val list: List<Int> // Список должен быть отсортирован
) {
    init {
        require(list == list.sorted()) { "List must be sorted for binary search" }
    }

    fun binarySearch(item: Int): Int? {
        var low = 0
        var high = list.size - 1
        var iteration = 0

        while (low <= high) {
            iteration++
            val mid = (low + high) / 2
            val guess = list[mid]

            // Выводим текущий прогресс (опционально)
            println("Iteration: $iteration, Low: $low, High: $high, Mid: $mid, Guess: $guess")

            when {
                guess == item -> {
                    println("Found item $item at index $mid in $iteration iterations")
                    return mid
                }
                guess > item -> high = mid - 1
                else -> low = mid + 1
            }
        }

        println("Item $item not found after $iteration iterations")
        return null // Элемент не найден
    }
}
