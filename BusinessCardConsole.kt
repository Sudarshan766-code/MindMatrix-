// -----------------------------
// Business Card Console Program
// -----------------------------

// 1️⃣ Data Class
data class BusinessCard(
    val name: String,
    val title: String,
    val phone: String,
    val email: String
)

// 2️⃣ Center Text Helper Function
fun centerText(text: String, width: Int): String {
    val contentWidth = width - 2
    val padding = (contentWidth - text.length) / 2
    val leftPadding = if (padding > 0) padding else 0
    val rightPadding = contentWidth - text.length - leftPadding

    return "|" + " ".repeat(leftPadding) +
            text +
            " ".repeat(rightPadding) + "|"
}

// 3️⃣ Print Border
fun printBorder(width: Int) {
    println("-".repeat(width))
}

// 4️⃣ Print Empty Line
fun printEmptyLine(width: Int) {
    println("|" + " ".repeat(width - 2) + "|")
}

// 5️⃣ Print Logo
fun printLogo(width: Int) {
    val logo = "[ANDROID]"
    println(centerText(logo, width))
    printEmptyLine(width)
}

// 6️⃣ Print Header (Name + Title)
fun printHeader(card: BusinessCard, width: Int) {
    println(centerText(card.name, width))
    println(centerText(card.title, width))
    printEmptyLine(width)
}

// 7️⃣ Print Contact Information
fun printContacts(card: BusinessCard, width: Int, showContacts: Boolean) {
    if (showContacts) {
        val phoneLine = "  Phone: ${card.phone}"
        val emailLine = "  Email: ${card.email}"

        println("|" + phoneLine.padEnd(width - 2, ' ') + "|")
        println("|" + emailLine.padEnd(width - 2, ' ') + "|")
    } else {
        println(centerText("Contact Info Hidden", width))
    }
}

// 8️⃣ Main Function
fun main() {

    val width = 50

    val card = BusinessCard(
        name = "Sudarshan G",
        title = "Android Developer",
        phone = "+91-98765-43210",
        email = "sudarshan@example.com"
    )

    println("Do you want to show contact information? (yes/no)")
    val input = readLine()
    val showContacts = input?.lowercase() == "yes"

    printBorder(width)
    printLogo(width)
    printHeader(card, width)
    printContacts(card, width, showContacts)
    printBorder(width)
}
