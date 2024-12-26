package searching

import kotlin.time.measureTime

fun main() {
    val sortedList = (1..1_000_000).toList()
    val timeWithLoop = measureTime {
        binarySearchWithLoop(sortedList, 123121)
    }
    val timeWithRecursion = measureTime {
        binarySearchWithRecursion(sortedList, 123121)
    }
    println("Time with loop: $timeWithLoop")
    println("Time with recursion: $timeWithRecursion")
}

fun binarySearchWithLoop(list: List<Int>, item: Int): Int? {
    var low = 0
    var high = list.size - 1
    var iteration = 0

    while (low <= high) {
        iteration++
        val mid = (low + high) / 2
        val guess = list[mid]


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

fun binarySearchWithRecursion(
    list: List<Int>,
    item: Int,
    low: Int = 0,
    high: Int = list.size - 1,
    iteration: Int = 0
): Int? {
    // Базовое условие: если диапазон пуст, элемент не найден
    if (low > high) {
        println("Item $item not found after $iteration iterations")
        return null
    }

    // Вычисляем среднее значение
    val mid = (low + high) / 2
    val guess = list[mid]

    // Если элемент найден
    if (guess == item) {
        println("Found item $item at index $mid in $iteration iterations")
        return mid
    }

    // Рекурсивно продолжаем поиск в соответствующей половине
    return if (guess > item) {
        binarySearchWithRecursion(list, item, low, mid - 1, iteration + 1)
    } else {
        binarySearchWithRecursion(list, item, mid + 1, high, iteration + 1)
    }
}