//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("====================1======================")
    val persons = mutableListOf(
        Employee("Алексей", 24, 30000),
        Employee("Евгения", 31, 45000),
        Employee("Константин", 45, 51000),
        Employee("Василиса", 27, 21000),
        Employee("Ульяна", 28, 27000)
    )

    println(persons.sortByName())
    println(persons.sort(2))
    println(persons.sort(3))
    println("====================2======================")
    val matrix : MutableList<MutableList<Int>> = mutableListOf(
        mutableListOf(5, 7, 1, 0),
        mutableListOf(1, 2, 0, 3),
        mutableListOf(8, 9, 4, 7)
    )
    for (i in matrix){
        for (j in i.indices){
            for (k in i.indices){
                if (i[j] < i[k]){
                    val buf = i[j]
                    i[j] = i[k]
                    i[k] = buf
                }
            }
        }
    }
    for (i in matrix){
        for (j in i){
            print("$j ")
        }
        println()
    }
    println("====================3======================")
    val matrix2 : MutableList<MutableList<Int>> = mutableListOf(
        mutableListOf(5, 7, 1, 0),
        mutableListOf(1, 2, 0, 3),
        mutableListOf(8, 9, 4, 7)
    )
    var res = 0
    for (i in matrix2){
        var k = 1
        var count = 0

        while (k != i.size - 1){
            if (i[k] > i[k - 1] && i[k] > i[k + 1] ){
                count++
                k++
            }
            else if (i[k] < i[k - 1] && i[k] < i[k + 1]){
                count++
                k++
            }
            else break
        }
        if (count == i.size - 2){
            res++
            for (j in i) print("$j ")
            println()
        }
    }
    println("Количество пилообразных последовательностей = $res")
}


fun MutableList<Employee>.sortByName(): MutableList<Employee>{
    for (i in this.indices){
        for (j in this.indices){
            if (this[j].name > this[i].name){
                val buf = this[i]
                this[i] = this[j]
                this[j] = buf
            }
        }
    }
    return this
}

fun MutableList<Employee>.sort(propertyNumber: Int): MutableList<Employee>{
    if (propertyNumber == 2){
        for (i in this.indices){
            for (j in this.indices){
                if (this[j].age > this[i].age){
                    val buf = this[i]
                    this[i] = this[j]
                    this[j] = buf
                }
            }
        }
    }
    else if (propertyNumber == 3){
        for (i in this.indices){
            for (j in this.indices){
                if (this[j].salary > this[i].salary){
                    val buf = this[i]
                    this[i] = this[j]
                    this[j] = buf
                }
            }
        }
    }
    return this
}

