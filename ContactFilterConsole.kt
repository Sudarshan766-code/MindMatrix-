// -----------------------------------
// Contact Filter Console Application
// Developed by Sudarshan G – Session 5 Lab
// -----------------------------------

data class Contact(
    val name: String,
    val phone: String?,
    val email: String?,
    val favorite: Boolean
)

// Format a single contact
fun formatContact(contact: Contact): String {
    val phoneDisplay = contact.phone ?: "N/A"
    val emailDisplay = contact.email ?: "N/A"
    val favoriteTag = if (contact.favorite) " | Favorite" else ""

    return "${contact.name} | Phone: $phoneDisplay | Email: $emailDisplay$favoriteTag"
}

// Higher-order function to filter contacts
fun filterContacts(
    contacts: List<Contact>,
    predicate: (Contact) -> Boolean
): List<Contact> {
    return contacts.filter(predicate)
}

// Print contacts with title
fun printContacts(title: String, contacts: List<Contact>) {
    println(title)

    contacts.forEachIndexed { index, contact ->
        println("${index + 1}. ${formatContact(contact)}")
    }

    println()
}

fun main() {

    val allContacts = listOf(
        Contact("Maya Patel", "+91-90000-11111", "maya@example.com", true),
        Contact("Raj Sharma", null, "raj@sample.com", false),
        Contact("Li Wei", "+86-13800000000", null, false),
        Contact("Sara Ali", null, null, false),
        Contact("Tom OBrien", "+1-555-1234", "tom@example.org", true)
    )

    // Print all contacts
    printContacts("--- All Contacts ---", allContacts)

    // Print favorite contacts
    val favoriteContacts = filterContacts(allContacts) { it.favorite }
    printContacts("--- Favorite Contacts ---", favoriteContacts)

    // Print contacts with email
    val contactsWithEmail = filterContacts(allContacts) { it.email != null }
    printContacts("--- Contacts with Email ---", contactsWithEmail)
}
