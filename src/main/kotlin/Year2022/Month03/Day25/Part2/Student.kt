package Year2022.Month03.Day25.Part2

/* 
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/25 2:15 周五
@Description: 与Marks、Totals建立委托关系
*/
class Student(studentId: Int, marks: Marks, totals: Totals) : Marks by marks, Totals by totals

fun main() {
    val studentOne = Student(1, StdMarks(), StdTotals())
    studentOne.printMarks()
    studentOne.printTotals()
    println("----------------------")
    val studentTwo = Student(2, ExcelMarks(),ExcelTotals())
    studentTwo.printMarks()
    studentTwo.printTotals()
}