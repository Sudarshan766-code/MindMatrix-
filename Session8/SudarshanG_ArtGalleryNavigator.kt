/*
 Session 8 - AADK Task 8
 Art Space Navigation + Testable Logic
 Name: Sudarshan G
 Description:
 Console-based Art Gallery Navigator with
 structured business logic for unit testing.
*/

// -----------------------------
// DATA MODEL
// -----------------------------

data class Artwork(
    val title: String,
    val artist: String,
    val year: Int
)

// -----------------------------
// BUSINESS LOGIC (Testable)
// -----------------------------

class ArtGalleryManager(private val artworks: List<Artwork>) {

    var currentIndex: Int = 0
        private set

    private val favourites = mutableListOf<Artwork>()

    fun getCurrentArtwork(): Artwork {
        return artworks[currentIndex]
    }

    fun nextArtwork() {
        currentIndex = (currentIndex + 1) % artworks.size
    }

    fun previousArtwork() {
        currentIndex =
            if (currentIndex - 1 < 0)
                artworks.size - 1
            else
                currentIndex - 1
    }

    fun toggleFavourite() {
        val current = getCurrentArtwork()
        if (favourites.contains(current)) {
            favourites.remove(current)
        } else {
            favourites.add(current)
        }
    }

    fun getFavourites(): List<Artwork> {
        return favourites
    }
}

// -----------------------------
// DISPLAY FUNCTION
// -----------------------------

fun displayArtwork(art: Artwork) {
    println("Viewing: ${art.title} (${art.artist}, ${art.year})")
    println("--------------------------------------------")
}

// -----------------------------
// SIMPLE UNIT TEST FUNCTIONS
// -----------------------------

fun testNextWrapLogic() {
    val artworks = listOf(
        Artwork("A", "Artist1", 2000),
        Artwork("B", "Artist2", 2001)
    )

    val manager = ArtGalleryManager(artworks)

    manager.nextArtwork()
    manager.nextArtwork()

    if (manager.currentIndex == 0) {
        println("PASS: Next wrap logic working")
    } else {
        println("FAIL: Next wrap logic incorrect")
    }
}

fun testFavouriteToggle() {
    val artworks = listOf(
        Artwork("A", "Artist1", 2000)
    )

    val manager = ArtGalleryManager(artworks)

    manager.toggleFavourite()

    if (manager.getFavourites().isNotEmpty()) {
        println("PASS: Favourite added")
    } else {
        println("FAIL: Favourite not added")
    }

    manager.toggleFavourite()

    if (manager.getFavourites().isEmpty()) {
        println("PASS: Favourite removed")
    } else {
        println("FAIL: Favourite not removed")
    }
}

// -----------------------------
// MAIN FUNCTION (Lab Simulation)
// -----------------------------

fun main() {

    val artworks = listOf(
        Artwork("Starry Night", "Vincent van Gogh", 1889),
        Artwork("Mona Lisa", "Leonardo da Vinci", 1503),
        Artwork("The Persistence of Memory", "Salvador Dali", 1931),
        Artwork("The Scream", "Edvard Munch", 1893)
    )

    val gallery = ArtGalleryManager(artworks)

    println("----- ART GALLERY NAVIGATOR -----")

    displayArtwork(gallery.getCurrentArtwork())

    println("-> Next Artwork")
    gallery.nextArtwork()
    displayArtwork(gallery.getCurrentArtwork())

    println("-> Next Artwork")
    gallery.nextArtwork()
    displayArtwork(gallery.getCurrentArtwork())

    println("-> Previous Artwork")
    gallery.previousArtwork()
    displayArtwork(gallery.getCurrentArtwork())

    println("-> Toggle Favourite")
    gallery.toggleFavourite()

    println("Favourites List:")
    gallery.getFavourites().forEach {
        println("${it.title} by ${it.artist}")
    }

    println("\n----- RUNNING TEST CASES -----")
    testNextWrapLogic()
    testFavouriteToggle()
}
