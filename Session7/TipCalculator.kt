/**
 * Session 7 – Tip Calculator Console
 * Author: Sudarshan G
 * USN: 1JS22CS159
 *
 * Description:
 * Console-based Kotlin program that calculates tip amount
 * based on bill amount, tip percentage, and optional round-up.
 */

import java.util.Locale
import kotlin.math.ceil

// Pure function to calculate tip
fun calculateTip(amount: Double, tipPercent: Int, roundUp: Boolean): Double {
    var tip = amount * tipPercent / 100.0

    if (roundUp) {
        tip = ceil(tip)
    }

    return tip
}

// Function to format amount to two decimal places
fun formatAmount(amount: Double): String {
    return String.format(Locale.US, "%.2f", amount)
}

fun main() {

    println("=== Tip Calculator Console ===")

    // Scenario 1
    val bill1 = 50.00
    val tip1 = calculateTip(bill1, 15, false)
    println("Bill: ${formatAmount(bill1)} | Tip percent: 15% | Round up: false | Tip: ${formatAmount(tip1)}")

    // Scenario 2
    val bill2 = 75.20
    val tip2 = calculateTip(bill2, 18, true)
    println("Bill: ${formatAmount(bill2)} | Tip percent: 18% | Round up: true  | Tip: ${formatAmount(tip2)}")

    // Scenario 3
    val bill3 = 100.00
    val tip3 = calculateTip(bill3, 20, false)
    println("Bill: ${formatAmount(bill3)} | Tip percent: 20% | Round up: false | Tip: ${formatAmount(tip3)}")

    println("=== End of Calculation ===")
}
