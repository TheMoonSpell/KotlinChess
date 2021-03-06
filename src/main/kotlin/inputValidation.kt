import kotlin.system.exitProcess

fun exitMsg() {
    println("Inputs are not valid!")
    exitProcess(1)
}

fun pieceList(): List<Char> {
    return listOf('P', 'R', 'B', 'Q', 'N', 'K')
}

fun xList(): List<Char> {
    return listOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h')
}

fun yList(): List<Int> {
    return listOf(1, 2, 3, 4, 5, 6, 7, 8)
}

fun checkDir(pieceType: Char, library: List<Char>): Boolean {
    var boo = false
    for (piece in library)
        if (pieceType == piece) {
            boo = true
            break
        }
    return boo
}

fun checkY(Y: Int): Boolean {
    var boo = false
    for (piece in yList())
        if (Y == piece) {
            boo = true
            break
        }
    return boo
}

fun checkPieceType(pieceType: Char): Boolean {
    return checkDir(pieceType, pieceList())
}

fun checkX(X: Char): Boolean {
    return checkDir(X, xList())
}

private fun checkLength(piece: String): Boolean {
    var boo = false
    if (piece.length == 3)
        boo = true
    return boo
}

private fun checkPiece(piece: String) {
    if (!((checkPieceType(piece[0].toUpperCase()) &&
                checkX(piece[1].toLowerCase()) && checkY(piece[2].toString().toInt())))
    ) {
        exitMsg()
    }
}

fun validateInput(input: List<String>) {
    if (input != listOf("")) {
        for (piece in input) {
            if (checkLength(piece)) {
                checkPiece(piece)
            } else {
                exitMsg()
            }
        }
    }
}
