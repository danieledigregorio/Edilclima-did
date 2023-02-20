package it.polito.did.edilclima.screens

data class ImprevistoItem(
    val id: String,
    val title: String,
    val text: String,
    val co2: Int,
    val price: Int,
)

val imprevisti = arrayOf(
    ImprevistoItem(
        id = "a1",
        title = "Terremoto",
        text = "Una scossa di terremoto ha danneggiato gli infissi. Per ripararli pagate 3000,00€",
        co2 = 0,
        price = 3000,
    ),
    ImprevistoItem(
        id = "a2",
        title = "Ondata di calore",
        text = "A causa del caldo eccessivo, la bolletta aumenta. Pagate 400,00€",
        co2 = 0,
        price = 400,
    ),
    ImprevistoItem(
        id = "a3",
        title = "Ondata di freddo",
        text = "A causa del freddo eccessivo, la bolletta aumenta. Pagate 600,00€",
        co2 = 0,
        price = 600,
    ),
    ImprevistoItem(
        id = "a4",
        title = "Alluvione",
        text = "A causa di un forte alluvione si sono rilevati danni agli elettrodomestici. Per ripararli pagate 2000,00€",
        co2 = 0,
        price = 2000,
    ),
    ImprevistoItem(
        id = "1",
        title = "Inverno rigido",
        text = "Le spese di riscaldamento aumentano! Pagate 500,00€",
        co2 = 0,
        price = 500,
    ),
    ImprevistoItem(
        id = "2",
        title = "Bolletta del gas",
        text = "Le spese di riscaldamento aumentano! Pagate 500,00€",
        co2 = 0,
        price = 500,
    ),
    ImprevistoItem(
        id = "3",
        title = "Condominio",
        text = "Manutenzione straordinaria del condominio! Pagate 500,00€",
        co2 = 0,
        price = 500,
    ),
    ImprevistoItem(
        id = "4",
        title = "Grandine",
        text = "La grandine ha rotto i vetri delle finestre! Dovete sostituirli: pagate 500,00€",
        co2 = 0,
        price = 500,
    ),
    ImprevistoItem(
        id = "5",
        title = "Tasse",
        text = "Tassa sulla proprietà dell'immobile. Pagate 800,00€",
        co2 = 0,
        price = 800,
    ),
    ImprevistoItem(
        id = "6",
        title = "Bonus statale",
        text = "Incentivo statale per la transizione energetica! Guadagnate 2500,00€",
        co2 = 0,
        price = -2500,
    ),
    ImprevistoItem(
        id = "7",
        title = "Bonus",
        text = "Ogni squadra guadagna 3000,00€",
        co2 = 0,
        price = -3000,
    ),
    ImprevistoItem(
        id = "8",
        title = "Bonus CO2",
        text = "Incentivo statale per la transizione energetica! Guadagnate 1500,00€",
        co2 = 0,
        price = -1500,
    ),
    ImprevistoItem(
        id = "9",
        title = "Bonus",
        text = "Ogni squadra guadagna 2000,00€",
        co2 = 0,
        price = -2000,
    ),
    ImprevistoItem(
        id = "10",
        title = "Bonus CO2",
        text = "Incentivo statale per la transizione energetica! Guadagnate 1000,00€",
        co2 = 0,
        price = -1000,
    ),
)

fun getImprevistoById(id: String): ImprevistoItem {
    return imprevisti.single { a -> a.id == id }
}
fun getImprevisti(): List<ImprevistoItem> {
    return imprevisti.toList()
}
fun isRealImprevisto(id: String): Boolean {
    return imprevisti.any { it.id == id }
}