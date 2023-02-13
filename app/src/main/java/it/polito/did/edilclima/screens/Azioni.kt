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
    val default: Boolean = false,
)

val azioni = arrayOf(

    // SOGGIORNO
    Azione(
        id = "0001",
        room = "soggiorno",
        title = "Pulizia",
        subtitle = "Lorem ipsum dolor sit amet",
        options = arrayOf(
            Opzione(
                id = "1",
                title = "Scopa",
                subtitle = "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet",
                co2 = 17,
                price = 22,
                quality = 2,
                default = true,
            ),
            Opzione(
                id = "2",
                title = "Aspirapolvere",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 3,
                price = 300,
                quality = 5,
            ),
            Opzione(
                id = "3",
                title = "Robot",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 7,
                price = 500,
                quality = 9,
            )
        )
    ),
    Azione(
        id = "0002",
        room = "soggiorno",
        title = "Televisore",
        subtitle = "Lorem ipsum dolor sit amet",
        options = arrayOf(
            Opzione(
                id = "1",
                title = "TV LCD",
                subtitle = "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet",
                co2 = 35,
                price = 450,
                quality = 5,
            ),
            Opzione(
                id = "2",
                title = "TV LED",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 98,
                price = 250,
                quality = 7,
            ),
            Opzione(
                id = "3",
                title = "TV OLED",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 138,
                price = 1150,
                quality = 10,
            )
        )
    ),
    Azione(
        id = "0003",
        room = "soggiorno",
        title = "Lampadine",
        subtitle = "Lorem ipsum dolor sit amet",
        options = arrayOf(
            Opzione(
                id = "1",
                title = "Incandescenza",
                subtitle = "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet",
                co2 = 29,
                price = 1,
                quality = 5,
                default = true,
            ),
            Opzione(
                id = "2",
                title = "Fluorescenza",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 50,
                price = 5,
                quality = 7,
            ),
            Opzione(
                id = "3",
                title = "Led",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 61,
                price = 3,
                quality = 9,
            )
        )
    ),
    Azione(
        id = "0004",
        room = "soggiorno",
        title = "Filtrazione aria",
        subtitle = "Lorem ipsum dolor sit amet",
        options = arrayOf(
            Opzione(
                id = "1",
                title = "Purificatore aria",
                subtitle = "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet",
                co2 = 6,
                price = 165,
                quality = 9,
            ),
        )
    ),

    // BAGNO
    Azione(
        id = "0005",
        room = "bagno",
        title = "Lavaggio panni",
        subtitle = "Lorem ipsum dolor sit amet",
        options = arrayOf(
            Opzione(
                id = "1",
                title = "Lavatrice",
                subtitle = "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet",
                co2 = 339,
                price = 350,
                quality = 5,
            ),
            Opzione(
                id = "2",
                title = "Lavatrice + asciugatrice",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 211,
                price = 929,
                quality = 7,
            ),
            Opzione(
                id = "3",
                title = "Lavasciuga",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 21,
                price = 600,
                quality = 9,
            )
        )
    ),

    // CUCINA
    Azione(
        id = "0006",
        room = "cucina",
        title = "Piano cottura",
        subtitle = "Lorem ipsum dolor sit amet",
        options = arrayOf(
            Opzione(
                id = "1",
                title = "Gas",
                subtitle = "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet",
                co2 = 87,
                price = 220,
                quality = 6,
                default = true,
            ),
            Opzione(
                id = "2",
                title = "Induzione",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 325,
                price = 519,
                quality = 8,
            )
        )
    ),
    Azione(
        id = "0007",
        room = "cucina",
        title = "Lavaggio stoviglie",
        subtitle = "Lorem ipsum dolor sit amet",
        options = arrayOf(
            Opzione(
                id = "1",
                title = "Lavaggio a mano",
                subtitle = "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet",
                co2 = 286,
                price = 0,
                quality = 2,
                default = true,
            ),
            Opzione(
                id = "2",
                title = "Lavastoviglie",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 65,
                price = 519,
                quality = 7,
            )
        )
    ),
    Azione(
        id = "0008",
        room = "cucina",
        title = "Forno",
        subtitle = "Lorem ipsum dolor sit amet",
        options = arrayOf(
            Opzione(
                id = "1",
                title = "Legna",
                subtitle = "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet",
                co2 = 130,
                price = 1499,
                quality = 4,
            ),
            Opzione(
                id = "2",
                title = "Gas",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 39,
                price = 549,
                quality = 7,
            ),
            Opzione(
                id = "3",
                title = "Elettrico",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 55,
                price = 399,
                quality = 9,
            )
        )
    ),
    Azione(
        id = "0009",
        room = "cucina",
        title = "Frigorifero",
        subtitle = "Lorem ipsum dolor sit amet",
        options = arrayOf(
            Opzione(
                id = "1",
                title = "Solo frigorifero",
                subtitle = "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet",
                co2 = 130,
                price = 289,
                quality = 7,
                default = true,
            ),
            Opzione(
                id = "2",
                title = "Frigorifero + freezer",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 65,
                price = 549,
                quality = 9,
            )
        )
    ),

    // CAMERA
    Azione(
        id = "0010",
        room = "camera",
        title = "Sveglia",
        subtitle = "Lorem ipsum dolor sit amet",
        options = arrayOf(
            Opzione(
                id = "1",
                title = "Gallo",
                subtitle = "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet",
                co2 = 2,
                price = 30,
                quality = 1,
            ),
            Opzione(
                id = "2",
                title = "Analogica",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 2,
                price = 15,
                quality = 4,
            ),
            Opzione(
                id = "3",
                title = "Digitale",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 1,
                price = 30,
                quality = 8,
            )
        )
    ),
    Azione(
        id = "0011",
        room = "camera",
        title = "Televisore",
        subtitle = "Lorem ipsum dolor sit amet",
        options = arrayOf(
            Opzione(
                id = "1",
                title = "TV LCD",
                subtitle = "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet",
                co2 = 35,
                price = 450,
                quality = 5,
            ),
            Opzione(
                id = "2",
                title = "TV LED",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 98,
                price = 250,
                quality = 7,
            ),
            Opzione(
                id = "3",
                title = "TV OLED",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 138,
                price = 1150,
                quality = 10,
            )
        )
    ),
    Azione(
        id = "0012",
        room = "camera",
        title = "Lampadine",
        subtitle = "Lorem ipsum dolor sit amet",
        options = arrayOf(
            Opzione(
                id = "1",
                title = "Incandescenza",
                subtitle = "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet",
                co2 = 29,
                price = 1,
                quality = 5,
                default = true,
            ),
            Opzione(
                id = "2",
                title = "Fluorescenza",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 50,
                price = 5,
                quality = 7,
            ),
            Opzione(
                id = "3",
                title = "Led",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 61,
                price = 3,
                quality = 9,
            )
        )
    ),

    // CASA
    Azione(
        id = "0013",
        room = "casa",
        title = "Infissi",
        subtitle = "Lorem ipsum dolor sit amett",
        options = arrayOf(
            Opzione(
                id = "1",
                title = "PVC",
                subtitle = "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet",
                co2 = 1178,
                price = 250,
                quality = 5,
                default = true,
            ),
            Opzione(
                id = "2",
                title = "Legno",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 1064,
                price = 500,
                quality = 7,
            ),
            Opzione(
                id = "3",
                title = "Alluminio",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 38,
                price = 700,
                quality = 9,
            )
        )
    ),
    Azione(
        id = "0014",
        room = "casa",
        title = "Ventilazione",
        subtitle = "Lorem ipsum dolor sit amet",
        options = arrayOf(
            Opzione(
                id = "1",
                title = "Ventilatore",
                subtitle = "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet",
                co2 = 156,
                price = 250,
                quality = 3,
            ),
            Opzione(
                id = "2",
                title = "Condizionatore mobile",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 143,
                price = 500,
                quality = 5,
            ),
            Opzione(
                id = "3",
                title = "Condizionatore fisso",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 96,
                price = 700,
                quality = 9,
            )
        )
    ),
    Azione(
        id = "0015",
        room = "casa",
        title = "Riscaldamento",
        subtitle = "Lorem ipsum dolor sit amet",
        options = arrayOf(
            Opzione(
                id = "1",
                title = "Pavimento",
                subtitle = "Lorem ipsum dolor sit amet lorem ipsum dolor sit amet",
                co2 = 1297,
                price = 7900,
                quality = 6,
            ),
            Opzione(
                id = "2",
                title = "Pompa di calore",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 1167,
                price = 7100,
                quality = 7,
            ),
            Opzione(
                id = "3",
                title = "Pellet",
                subtitle = "Lorem ipsum dolor sit amet",
                co2 = 432,
                price = 3500,
                quality = 9,
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