private fun translateX(piece: String): Int {
    return convertSecondCharToNum(piece[0].toUpperCase())
}

private fun translateY(piece: String): Int {
    return piece[1].toString().toInt() - 1
}

private fun checkLength(piece: String): Boolean {
    var boo = false
    if (piece.length == 2)
        boo = true
    return boo
}

fun checkBoard(input: String, board: Array<Array<String>>): Boolean {
    var boo = true
    if (board[translateX(input)][translateY(input)] == "emps") {
        boo = false
    }
    return boo
}

fun checkStrings(input: String, board: Array<Array<String>>) : Boolean{
    var boo = false
    if ((checkX(input[0].toLowerCase()) && checkY(input[1].toString().toInt()) && (checkBoard(
        input,
        board
    ))))
        boo = true
    return boo
}

private fun checkFlags(input: String, board: Array<Array<String>>): Boolean {
    var boo = false
    if (checkLength(input)) {
        if (checkStrings(input, board))
            boo = true
    }
    return boo
}

fun pieceInput(): String {
    println("Enter piece to move (coordinates only) : ")
    return input()
}

fun pieceMoveInput(board: Array<Array<String>>): String {
    var input = pieceInput()
    var boo = false
    while (!boo) {
        boo = checkFlags(input, board)
        if (!boo) {
            println("Invalid Input!")
            println()
            input = pieceInput()
        }
    }
    return input
}