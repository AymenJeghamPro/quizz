import java.util.*


fun main(args: Array<String>) {

    println(maxProfit())
}

fun findSumPair(numbers: Array<Int>, k: Int): Array<Int> {
    for (i in 0 until numbers.size - 1) {
        for (j in i + 1 until numbers.size) {
            if (numbers[i] + numbers[j] == k) {
                return arrayOf(i, j)
            }
        }
    }

    return emptyArray()
}

fun filterWords(array: List<String>, string: String): MutableList<Int> {
    var resultList = mutableListOf<Int>()
    string.mapIndexed { index, c ->
        array.mapIndexed { indexString, s ->
            if (s.contains(c)) {
                resultList.add(indexString)
            }
        }
    }
    return resultList
}

fun isNumberExists(array: List<Int>, int: Int): Boolean {

    return array.contains(int)
}

fun getDigitsSum(x: Int): Int {
    var x = x
    var sum = 0

    while (x != 0) {//x=56 x=5  x=483 4
        sum += x % 10//6 6+5  3  3+8 +4
        x /= 10//56/10=5 0   48 4 0
    }
    return sum
}

fun findJoinPoint(seq1: Int, seq2: Int): Int {
    var seq1 = seq1
    var seq2 = seq2
    while (seq1 != seq2) {
        if (seq1 < seq2) {
            if (seq1 == 0) return -1 // no chance to join, seq1 is 0
            seq1 += getDigitsSum(seq1)
        } else if (seq2 < seq1) {
            if (seq2 == 0) return -2 // no chance to join, seq2 is 0
            seq2 += getDigitsSum(seq2)
        }
    }
    return seq1
}

open class Fruit

class Apple : Fruit()

class Mango : Fruit()

fun computeDayGains(nbSeats: Int, payingGuests: IntArray, guestMovements: IntArray): Int {
    var sum = 0
    val occupants: MutableMap<Int, Int> = HashMap()
    val queue: Queue<*> = LinkedList<Any>()
    for (k in 1..nbSeats) {
        occupants[k] = -1
    }
    for (i in guestMovements.indices) {
        val currentMember = guestMovements[i]
        var flag = false
        if (!queue.contains(currentMember)) {
            for ((key, value) in occupants) {
                if (value == -1 && !occupants.containsValue(currentMember)) {
                    occupants[key] = currentMember
                    flag = true
                    break
                } else if (value == currentMember) {
                    occupants[key] = (if (queue.size == 0) -1 else queue.remove()) as Int
                    sum += payingGuests[currentMember]
                    flag = true
                }
            }
            if (!flag) queue.add(currentMember as Nothing?)
        } else {
            queue.remove(currentMember)
        }
    }
    return sum
}

fun isPalindrome(x: Int): Boolean {
    var num = x
    var reversedInteger = 0
    var remainder: Int

    val originalInteger: Int = num

    while (num != 0) {
        remainder = num % 10
        reversedInteger = reversedInteger * 10 + remainder
        num /= 10
    }

    return (originalInteger >= 0) && (originalInteger == reversedInteger)

}

fun romanToInt(s: String): Int {
    // Map to store romans numerals
    val romanMap: MutableMap<Char, Int> = HashMap()
    // Fill the map
    romanMap['I'] = 1
    romanMap['V'] = 5
    romanMap['X'] = 10
    romanMap['L'] = 50
    romanMap['C'] = 100
    romanMap['D'] = 500
    romanMap['M'] = 1000
    // Length of the given string
    val n = s.length
    // Variable to store result
    var num = romanMap[s[n - 1]]!!
    // Loop for each character from right to left
    for (i in n - 2 downTo 0) {
        // Check if the character at right of current character is
        // bigger or smaller
        if (romanMap[s[i]]!! >= romanMap[s[i + 1]]!!) {
            num += romanMap[s[i]]!!
        } else {
            num -= romanMap[s[i]]!!
        }
    }
    return num
}

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    var len = 0
    var res = ""
    for (j in 0 until strs[0].length) {
        val c = strs[0][j]
        for (i in 1 until strs.size) {
            if (j >= strs[i].length || strs[i][j] != c) {
                return res
            }
        }
        res += c
    }
    return res
}

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    val range = (1..2)
    s.forEach { c ->
        when {
            stack.empty() -> stack.push(c)
            (c - stack.peek()) in range -> stack.pop()
            else -> stack.push(c)
        }
    }
    return stack.empty()
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    val result: ListNode = ListNode(0)
    var current = result

    var node1 = l1
    var node2 = l2
    while (node1 != null || node2 != null) {
        if (node1 == null) {
            current.next = node2
            break
        }
        if (node2 == null) {
            current.next = node1
            break
        }

        if (node1.`val` < node2.`val`) {
            current.next = node1
            node1 = node1.next
        } else {
            current.next = node2
            node2 = node2.next
        }
        current = current.next!!
    }
    return result.next
}

fun removeDuplicates(nums: IntArray): Int {
    var cnt = if (nums.isNotEmpty()) 1 else 0

    for (i in 1 until nums.size) {
        if (nums[i] == nums[i-1]) continue
        nums[cnt] = nums[i]
        cnt++
    }
    return cnt
}

fun removeElement(nums: IntArray, `val`: Int): Int {
    var res = 0
    for (i in nums.indices) {
        if (nums[i] != `val`) {
            nums[res++] = nums[i]
        }
    }
    return res
}

fun strStr(haystack: String, needle: String): Int {
    if (needle == "") return 0

    val n = haystack.length
    val m = needle.length

    for (i in 0 .. n-m) {
        for (j in 0 until m) {
            if (needle[j] != haystack[i+j])
                break
            if (j == m-1) return i
        }
    }
    return -1
}

fun searchInsert(nums: IntArray, target: Int): Int {
    var position = 0

    for(i in nums.indices) {
        position = if(i== nums.size-1) i+1 else i

        if(nums[i] >= target) return i
    }
    return position
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val head = ListNode(0)
    var p = l1
    var q = l2
    var cur = head
    var cnt = 0

    while (q != null || p != null) {
        val x = p?.`val` ?: 0
        val y = q?.`val` ?: 0

        val temp = x+y+cnt
        cnt = temp/10
        cur.next = ListNode(temp%10)
        cur = cur.next!!
        if (p != null) p = p.next
        if (q != null) q = q.next
    }
    if (cnt > 0) {
        cur.next = ListNode(cnt)
    }
    return head.next
}

fun lengthOfLongestSubstring(s: String): Int {
    // Sliding window start pointer
    var start = 0
    // Result
    var max = 0
    // Occurance map
    var occ = mutableMapOf<Char, Int>()

    for ((i, c) in s.withIndex()) {

        if (occ.containsKey(c)) {
            // Found a clash, move the start pointer
            // next to the previous occurance if applicable
            val seekPoint = occ[c]!! + 1
            start = Math.max(seekPoint, start)
        }

        val length = i - start + 1
        max = Math.max(length, max)

        // Update the map with latest occurance
        // when clash happen next time, use this index
        occ[c] = i
    }
    return max
}

fun zigZagConvert(s: String, numRows: Int): String {
    if (numRows == 1) return s

    var n = s.length
    var res = ""
    var cnt = numRows


    for (i in 0 until numRows) {
        cnt = if (cnt - 1 == 0) numRows-1 else cnt-1

        var x = cnt*2
        var j = i
        while (j < n) {
            res += s[j]
            j += x
            if ((numRows-1)*2-x != 0)
                x = (numRows-1)*2-x
        }
    }
    return res
}

fun reverse(x: Int): Int {
    var res = 0
    var n = x
    while (n != 0) {
        if (Math.abs(res) > Int.MAX_VALUE/10) return 0

        res = res*10 + n % 10
        n /= 10
    }
    return res
}

fun myAtoi(str: String): Int {
    val ans =  arrayListOf<Int>()

    var first = false
    var flag = 1
    var pos = 0

    for (i in str.indices) {
        if (str[i] != ' ') {
            if (str[i] in '0' .. '9' || str[i] == '-' || str[i] == '+') {
                if (str[i] == '-') flag = -1
                first = true
                pos = i
            }
            break
        }
    }

    if (!first) {
        return 0
    } else {
        pos = if (str[pos] == '-' || str[pos] == '+') pos+1 else pos
        while (pos < str.length && str[pos] == '0') pos++
        while (pos < str.length && str[pos] in '0'..'9') {
            ans.add(str[pos]-'0')
            pos++
        }
        var cnt: Long = 1
        var res: Long = 0

        if (ans.size > 10) {
            return if (flag == -1) -2147483648 else 2147483647
        }

        for (i in ans.size-1 downTo 0) {
            res += ans[i]*cnt
            cnt *= 10

            if (res >= Int.MAX_VALUE) break
        }
        res *= flag

        if (res < Int.MIN_VALUE) res = -2147483648
        if (res > Int.MAX_VALUE) res = 2147483647

        return res.toInt()
    }
}


fun solve(weight0: Int, weight1: Int, weight2: Int): Int {

    val list = mutableListOf<Int>()
    list.add(weight0)
    list.add(weight1)
    list.add(weight2)

    val max = list.maxOrNull()

    return list.indexOf(max)

}


fun maxProfit(): MutableList<String> {
    val stcks = mutableListOf<String>("one","two","three","four","five","six")
    val even: IntArray = intArrayOf(2, 4, 6,8,10,12)
    val odd: IntArray = intArrayOf(1, 3, 5,7,9,11)
    val nos: IntArray = intArrayOf(11, 13, 15,17,19,21)

    val lala = mutableListOf(even,odd,nos)

    var resultList = mutableListOf<String>()

    val result = (0 until stcks.size).map { col ->
        lala.map { it[col] }.average()
    }

    print3largest(result).map {
        resultList.add(stcks[it])
    }

    return resultList
}

fun print3largest(arr: List<Double>): MutableList<Int> {
    var first: Double
    var second: Double
    var third: Double

    second = Double.MIN_VALUE
    first = second
    third = first
    var i: Int = 0
    while (i < arr.size) {

     if (arr[i] > first) {
            third = second
            second = first
            first = arr[i]
        } else if (arr[i] > second) {
            third = second
            second = arr[i]
        } else if (arr[i] > third) third = arr[i]
        i++
    }
    return mutableListOf(arr.indexOf(first),arr.indexOf(second),arr.indexOf(third))
}