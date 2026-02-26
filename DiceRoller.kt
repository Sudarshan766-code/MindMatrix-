/**
 * Project: Session 6 – Dice Roller Console
 * Author: Sudarshan G
 * USN: 1JS22CS159
 * Course: Android App Development using Gen AI
 * Description:
 * This Kotlin console program simulates rolling a pair of dice.
 * It demonstrates functions, state updates, conditional logic,
 * and random number generation.
 */

import kotlin.random.Random

// Function to roll a single die
fun rollDie(sides: Int, rnd: Random): Int {
    return rnd.nextInt(1, sides + 1)
}

// Function to roll two six-sided dice
fun rollTwoDice(rnd: Random): Pair<Int, Int> {
    val firstDie = rollDie(6, rnd)
    val secondDie = rollDie(6, rnd)
    return Pair(firstDie, secondDie)
}

// Function to format roll result
fun formatRoll(rollNumber: Int, die1: Int, die2: Int): String {
    var output = "Roll $rollNumber: $die1 and $die2"

    // Check for double
    if (die1 == die2) {
        output += " -> Double!"
    }

    return output
}

fun main() {
    println("=== Dice Roller Console ===")

    // Seeded random for consistent output
    val random = Random(123)
    var rollCount = 0

    repeat(3) {
        println("Pressing 'Roll' button...")
        rollCount++

        val (dice1, dice2) = rollTwoDice(random)
        println(formatRoll(rollCount, dice1, dice2))
    }

    println("=== End of Simulation ===")
}
