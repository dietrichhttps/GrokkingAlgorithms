package recursion

import kotlin.math.max

fun main() {
    val res = findMax(mutableListOf(1, 2, 10, 20, 23))
    print(res)
}

fun fact(x: Int): Int {
    if (x == 1) {
        return 1
    }
    return x * fact(x - 1)
}

fun sum(list: List<Int>): Int {
    return if (list.isEmpty()) {
        0
    } else {
        list[0] + sum(list.drop(1))
    }
}

fun size(list: List<Int>, counter: Int = 0): Int {
    return if (list.isEmpty()) {
        counter
    } else {
        size(list.drop(1), counter + 1)
    }
}

fun findMax(list: List<Int>, maxValue: Int = Int.MIN_VALUE): Int {
    return if (list.isEmpty()) {
        maxValue
    } else {
        findMax(list.drop(1), max(list[0], maxValue))
    }
}