package it.polito.did.edilclima.screens

data class ImprevistoItem(
    val id: String,
    val text: String,
)

val imprevisti = arrayOf(
    ImprevistoItem(
        id = "1",
        text = "Lorem ipsum dolor sit amet"
    ),
)

fun getImprevistoById(id: String): ImprevistoItem {
    return imprevisti.single { a -> a.id == id }
}