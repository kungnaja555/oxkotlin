var arr = arrayOf(
    arrayOf(" ",1,2,3),
    arrayOf(1,"-","-","-"),
    arrayOf(2,"-","-","-"),
    arrayOf(3,"-","-","-")
)

var player = "X"
var rowInt = 0
var colInt = 0
var c = 0

fun printArray(){
    for(row in arr){
        for(col in row){
            print("$col ")
        }
        println()
    }
}

fun changeArray(){
    arr[rowInt][colInt] = player
}

fun changePlayer(){
    if(player == "X"){
        player = "O"
    }else{
        player = "X"
    }
}

fun checkWinRow():Boolean{
    var count = 0
    for(i in 1..3){
        for(j in 1..3){
            if(arr[i][j] == player){
                count++
            }
        }
        count = 0
        if(count == 3){
            return true
        }
    }
    return false
}

fun checkWinCol():Boolean{
    var count = 0
    for(i in 1..3){
        for(j in 1..3){
            if(arr[j][i] == player){
                count++
            }
        }
        count = 0
        if(count == 3){
            return true
        }
    }
    return false
}

fun checkWinOb1():Boolean{
    var count = 0
    for(i in 1..3){
        if(arr[i][i] == player){
            count++
        }
    }
    if(count == 3){
        return true
    }
    return false
}

fun checkWinOb2():Boolean{
    var count = 0
    for(i in 1..3){
        if(arr[i][3-i] == player){
            count++
        }
    }
    if(count == 3){
        return true
    }
    return false
}


fun main(){
    while (true){
        printArray()
        print("Player $player Input Row and Col ")
        var input:String? = readLine()
        var rcList:List<String>? = input?.split(" ")
        if(rcList?.size != 2){
            println("Error: Must input 2 numbers R C (EX: 1 2)")
            continue
        }
        rowInt = rcList.get(0).toInt()
        colInt = rcList.get(1).toInt()
        if(rowInt < 1 || rowInt > 3 || colInt < 1 || colInt > 3) {
            println("Error: Must input row or col range 1-3")
            continue
        }
        if(arr[rowInt][colInt] != "-"){
            println("Error")
            continue
        }
        changeArray()
        c++
        if(checkWinRow()){
            println("$player Win")
            printArray()
            break
        }
        if(checkWinCol()){
            println("$player Win")
            printArray()
            break
        }
        if(checkWinOb1()){
            println("$player Win")
            printArray()
            break
        }
        if(checkWinOb2()){
            println("$player Win")
            printArray()
            break
        }
        if(c == 9){
            println("Draw")
            printArray()
            break
        }
        changePlayer()
    }


}
