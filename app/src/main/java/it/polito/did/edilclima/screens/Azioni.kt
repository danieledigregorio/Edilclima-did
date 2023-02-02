package it.polito.did.edilclima.screens

data class Azione(
    val id: String,
    val room: String,
    val title: String,
    val subtitle: String,
    val options: Array<Opzione>
)
data class Opzione(
    val id: String,
    val title: String,
    val subtitle: String,
    val co2: Int,
    val price: Int,
    val quality: Int,
    val default : Boolean = false,
)

val azioni = arrayOf(
    Azione(
        id = "0001",
        room = "casa",
        title = "Pulizia pavimenti",
        subtitle = "Lorem ipsum dolor sit amet",
        options = arrayOf(
            Opzione(
                id = "1",
                title = "\uD83E\uDDF9 Scopa",
                subtitle = "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet",
                co2 = 100,
                price = 5,
                quality = 20,
                default = true,
            ),
            Opzione(
                id = "2",
                title = "Aspirapolvere",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 0,
                price = 100,
                quality = 100,
            ),
            Opzione(
                id = "3",
                title = "Robot",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 0,
                price = 100,
                quality = 100,
            )
        )
    ),
)

fun getAzioneById(id: String): Azione {
    return azioni.single { a -> a.id == id }
}
fun getAzioni(): List<Azione> {
    return azioni.toList()
}