package Year2022.Month03.Day29

/*
@Machine: RedmiBook Pro 15 
@Author: Barry
@Time: 2022/3/29 10:33 周二
@Description: 泛型约束
*/
class GenericConstraints<T>(var variable: Class<T>) where T : GenericConstraintsA, T : GenericConstraintsB {
}

open class GenericConstraintsA
interface GenericConstraintsB

