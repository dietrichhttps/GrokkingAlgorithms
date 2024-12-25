package searching

fun main() {
    val sortedList = (1..1_000_000).toList()
    val search = BinarySearching(sortedList)
    val itemToFind = 345345
    search.binarySearch(itemToFind)
}