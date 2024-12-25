package sorting

fun main() {
    val numbers = mutableListOf(12, 32, 4, 55, 6, 3)
    SelectionSort(numbers)
        .selectionSort()
        .forEach(::println)
}