package dk.cphbusiness.template.model


/*
public class Pet {
    private final String name;

    public Pet(String name) {
        this.name = name;
        // foo(name);
        }

    String getName() {
        return name;
        }
    }
 */

open class Pet(val name: String, val age: Int, owner: Person) {
    var owner: Person = owner
        get() = field
        set(value) {
            field.pets.remove(this)
            field = value
            field.pets.add(this)
            }

    init {
        // this.owner = owner
        }
    }

class Cat(name: String, age: Int, owner: Person, private var lives: Int = 9) : Pet(name, age, owner) {
    val lifeCount: Int
        get() = lives
    init {
        if (lives > 9) lives = 9
        }
    }

class Dog(name: String, age: Int, owner: Person, var barkPitch: String) : Pet(name, age, owner)

class Person(val name: String, val pets: MutableList<Pet> = mutableListOf<Pet>())


fun main(args: Array<String>) {

    val kurt = Person("Kurt")

    val felix = Cat("Felix", 10, kurt, 1000)
    val rufus = Dog("Rufus", 7, kurt, "C3")

    println(rufus.barkPitch)
    rufus.barkPitch = "A3"
    println(felix.lifeCount)
    //felix.lifeCount = 1000 No go


    val sonja = Person("Sonja", mutableListOf(felix, rufus))
    val fie = Person("Fie", sonja.pets)

    felix.owner = fie

    }