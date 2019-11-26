package io.kang.chapter03.basicsyntax

class Person(val name: String, var age: Int = 0) {
    var children: MutableList<Person> = mutableListOf<Person>();

    init {
        println("name is $name, age is $age")
    }

    constructor(name: String, age: Int, parent: Person) : this(name, age) {
        parent.children.add(this)
    }
}

fun main() {
    val person = Person("yuan")
    val parentPerson = Person("kang", 1, person)

    val derived = Derived("kang", 1)
    derived.draw()

    val demo = Demo(MutableList<String>(10){"a"})
    println(demo.size)
    println(demo.listToString)
}


open class Base(val p: Int) {
    open val vertexCount: Int = 0
    open fun draw() {
        println("Base.draw()")
    }
    constructor(base: String, p: Int): this(p){
        println("base is $base")
    }
}
class Derived: Base {
    override var vertexCount = 4
    constructor(base: String, p: Int): super(base, p)

    override fun draw() {
        println("Derived.draw()")
    }
}

class Demo(val aList: MutableList<String>) {
    var size: Int = 0
        get() = aList.size
        set(value) {
            field = value
        }
    var listToString: String
        get() = aList.toString()
        set(value) {
            aList.add(value)
        }
}