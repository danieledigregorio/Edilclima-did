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
    val description: String,
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
                subtitle = "Strumento per pulire il pavimento con setole",
                description = "In termini di impatto ambientale è sicuramente la scelta preferibile: il consumo di CO2 è nullo. Il costo di una scopa è minimo; tuttavia, richiede un maggiore sforzo fisico rispetto ad altri sistemi di pulizia. Utilizzare unicamente la scopa non garantisce prestazioni ottimali, specialmente nella rimozione di peli di animali domestici.",
                co2 = 17,
                price = 22,
                quality = 2,
                default = true,
            ),
            Opzione(
                id = "2",
                title = "Aspirapolvere",
                subtitle = "Elettrodomestico per aspirare la polvere",
                description = "È richiesto uno sforzo minore rispetto alla scopa, ma il costo è sicuramente più elevato. L’impatto ambientale non è irrilevante, specialmente utilizzando aspirapolveri ad alta potenza. Un altro svantaggio è quello legato alla rumorosità.",
                co2 = 3,
                price = 300,
                quality = 5,
            ),
            Opzione(
                id = "3",
                title = "Robot",
                subtitle = "Elettrodomestico per pulire automaticamente il pavimento",
                description = "In termini di qualità di vita è sicuramente la scelta ottimale: non richiede nessuno sforzo ed è molto silenzioso. Anche il consumo di CO2 è inferiore rispetto ad altri sistemi di pulizia, ma il grosso svantaggio è legato al prezzo: utilizzare questi strumenti domotici costa parecchio.",
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
                subtitle = "TV con schermo a cristalli liquidi",
                description = "In generale, tutte le tipologie di televisioni hanno un impatto ambientale negativo; tra quelli selezionati è il peggiore in termini di consumo di KWh/anno e conseguentemente in termini di consumo di CO2. Offrono una buona esperienza visiva e il prezzo è accessibile.",
                co2 = 35,
                price = 250,
                quality = 5,
            ),
            Opzione(
                id = "2",
                title = "TV LED",
                subtitle = "TV con schermo retroilluminato",
                description = "In generale, tutte le tipologie di televisioni hanno un impatto ambientale negativo; il consumo di CO2 è inferiore rispetto ai televisori LCD, ma il prezzo è leggermente superiore. La qualità visiva è medio-alta.",
                co2 = 98,
                price = 450,
                quality = 7,
            ),
            Opzione(
                id = "3",
                title = "TV OLED",
                subtitle = "TV con schermo a tecnologia di illuminazione organica",
                description = "In generale, tutte le tipologie di televisioni hanno un impatto ambientale negativo; in confronto alle altre tipologie, però, sono leggermente più ecologici, grazie alla loro tecnologia di illuminazione organica. Sono considerati i migliori in termini di qualità dell'immagine e angolo di visione. Tuttavia, sono i più costosi sul mercato.",
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
                subtitle = "Lampadina tradizionale a filamento",
                description = "Richiedono molta energia elettrica per funzionare e producono una quantità significativa di calore. Il loro impatto ecologico è decisamente negativo. Inoltre, in alcuni paesi non sono più commercializzate a causa del loro basso rendimento energetico.",
                co2 = 29,
                price = 1,
                quality = 5,
                default = true,
            ),
            Opzione(
                id = "2",
                title = "Fluorescenza",
                subtitle = "Lampadine per illuminare al meglio la stanza",
                description = "Consumano meno energia e durano più a lungo rispetto alle lampadine incandescenti. Tuttavia, contengono mercurio, un metallo pesante tossico, e richiedono un corretto smaltimento per evitare l'inquinamento ambientale.",
                co2 = 50,
                price = 5,
                quality = 7,
            ),
            Opzione(
                id = "3",
                title = "Led",
                subtitle = "Lampadine a risparmio energetico",
                description = "Sono le più efficienti in termini di consumo energetico e durata, consumano circa il 75% in meno di energia rispetto alle lampadine incandescenti e hanno una durata di vita molto più lunga",
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
                subtitle = "Dispositivo che sfrutta un metodo di assorbimento",
                description = "Utilizzano una tecnologia di assorbimento per rimuovere le sostanze chimiche, come fumi, odori e gas tossici, dall'aria. I prezzi sono generalmente accessibili e l’impatto ecologico è medio-basso.",
                co2 = 43,
                price = 369,
                quality = 9,
            ),
            Opzione(
                id = "2",
                title = "Filtro d'aria",
                subtitle = "Depuratore d’aria dalle particelle solide in sospensione",
                description = "Rimuovono le particelle in sospensione, come polvere, peli di animali e polline attraverso una varietà di materiali filtranti. I filtri usa e getta possono produrre rifiuti in eccesso, mentre i filtri riutilizzabili possono essere più costosi.",
                co2 = 65,
                price = 59,
                quality = 3,
            ),
            Opzione(
                id = "3",
                title = "Ionizzatore d'aria",
                subtitle = "Dispositivo che produce ioni negativi per attaccarsi alle particelle inquinanti",
                description = "Generano ioni negativi che si attaccano alle particelle in sospensione nell'aria, facendole cadere a terra e rimuovendole dall'aria respirata. L'impatto ecologico di questi dispositivi è generalmente basso. Tuttavia, alcuni modelli possono produrre ozono in eccesso, che è dannoso per la salute umana.",
                co2 = 57,
                price = 126,
                quality = 6,
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
                subtitle = "Elettrodomestico per lavare i vestiti",
                description = "Tra le proposte selezionate, è sicuramente la scelta più economica, ma richiede uno sforzo maggiore per la parte di asciugatura dei panni. Il consumo di Kwh/anno è variabile, a seconda della potenza e dalla dimensione del modello, ma generalmente non è troppo impattante dal punto di vista ecologico",
                co2 = 339,
                price = 350,
                quality = 5,
            ),
            Opzione(
                id = "2",
                title = "Lavatrice + asciugatrice",
                subtitle = "Elettrodomestici che lavano e asciugano i vestiti separatamente",
                description = "Risulta conveniente per chi dispone di parecchio spazio in bagno e, in termini di impatto ecologico, è sicuramente migliore rispetto alla lavasciuga. Tuttavia, i costi sono parecchio elevati.",
                co2 = 211,
                price = 929,
                quality = 7,
            ),
            Opzione(
                id = "3",
                title = "Lavasciuga",
                subtitle = "Elettrodomestico che lava e asciuga i vestiti insieme",
                description = "Può essere conveniente per le persone che hanno spazi limitati, in quanto sostituisce la necessità di avere sia una lavatrice che un'asciugatrice separate. Necessitano di un periodo di tempo più lungo delle lavatrici per quanto riguarda i cicli di lavaggio e asciugatura. Inoltre, è richiesta maggior manutenzione.",
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
                subtitle = "Fornello alimentato a gas",
                description = "Generalmente i prezzi di acquisto sono convenienti; tuttavia, i costi a lungo termine possono essere elevati, poiché richiedono l'acquisto e la sostituzione regolare delle bombole di gas. L’impatto ecologico/ambientale è decisamente negativo.",
                co2 = 87,
                price = 220,
                quality = 6,
                default = true,
            ),
            Opzione(
                id = "2",
                title = "Induzione",
                subtitle = "Fornello a induzione magnetica",
                description = "Normalmente sono più costosi rispetto ai piani cottura a gas, ma sono più ecologici in termini di elettricità e consumo di CO2. Inoltre, i piani cottura a induzione sono più sicuri rispetto a quelli a gas, poiché non emettono gas infiammabili.",
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
                subtitle = "Acqua e sapone: tutto a mano",
                description = "Se da un lato, è vantaggioso perché non richiede elettricità, d’altro canto per uno stesso lavaggio si utilizza molta più acqua rispetto alla lavastoviglie. È sicuramente vantaggioso economicamente, ma lo sforzo impiegato e il tempo impiegato sono due aspetti svantaggiosi rispetto alla lavastoviglie.",
                co2 = 286,
                price = 0,
                quality = 2,
                default = true,
            ),
            Opzione(
                id = "2",
                title = "Lavastoviglie",
                subtitle = "Elettrodomestico che lava autonomamente i piatti",
                description = "In termini di impatto ambientale, l'uso della lavastoviglie è generalmente più sostenibile rispetto al lavaggio a mano, dato che generalmente consuma meno acqua. Tuttavia, viene utilizzata elettricità. Anche in termini di costi, conviene lavare i patti a mano.",
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
                subtitle = "Forno che utilizza il legno come combustibile",
                description = "Si tratta di una tipologia molto dispendiosa. Non emettono CO2 direttamente, ma richiedono l'utilizzo di legna, che deve essere raccolta o acquistata. Sono meno convenienti da usare rispetto ai forni elettrici o a gas.",
                co2 = 130,
                price = 1499,
                quality = 4,
            ),
            Opzione(
                id = "2",
                title = "Gas",
                subtitle = "Forno alimentato a gas",
                description = "Offrono una discreta efficienza energetica e una buona flessibilità nella cottura. I forni a gas emettono CO2 e possono essere più complessi da installare rispetto ai forni elettrici.",
                co2 = 39,
                price = 549,
                quality = 7,
            ),
            Opzione(
                id = "3",
                title = "Elettrico",
                subtitle = "Forno alimentato ad energia elettrica",
                description = "Sono alimentati dall'elettricità e funzionano grazie alla resistenza riscaldante. Sono facili da usare e possono essere controllati con precisione per la temperatura di cottura desiderata. Tuttavia, il loro impatto ambientale è elevato: consumano molta energia elettrica e producono una grande quantità di CO2.",
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
                subtitle = "Elettrodomestico per conservare gli alimenti freschi",
                description = "L’utilizzo di un frigorifero in casa è indispensabile per conservare i cibi. Generalmente, i frigoriferi sono molto accessibili al pubblico, specialmente se di piccole dimensioni. La scelta di non utilizzare il freezer ha un impatto ambientale minore, ma non consente di congelare alcuni alimenti particolari.",
                co2 = 130,
                price = 289,
                quality = 7,
                default = true,
            ),
            Opzione(
                id = "2",
                title = "Frigorifero + freezer",
                subtitle = "Elettrodomestico composto da un frigorifero e un congelatore",
                description = "In termini di comfort, è sicuramente la scelta migliore, perché consente di conservare a lungo termine determinati alimenti. Naturalmente utilizzare sia il frigorifero che il freezer comporta un consumo di energia maggiore e i costi di acquisto sono leggermente più elevati.",
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
                subtitle = "Chicchirichì",
                description = "La scelta più “genuina”, ma anche la più irrealizzabile, a meno che non si viva in campagna. Non ci sono costi legati a elettricità o consumi di CO2. Attenzione: l’orario della sveglia non è personalizzabile",
                co2 = 2,
                price = 30,
                quality = 1,
            ),
            Opzione(
                id = "2",
                title = "Analogica",
                subtitle = "Orologio meccanico con lancette",
                description = "Non consumando elettricità, non emettono CO2 direttamente. Tuttavia, prevedono l’utilizzo di pile, che devono essere periodicamente sostituite o ricaricate. Il costo d’acquisto è leggermente inferiore rispetto alla sveglia digitale.",
                co2 = 2,
                price = 15,
                quality = 4,
            ),
            Opzione(
                id = "3",
                title = "Digitale",
                subtitle = "Orologio elettronico con display digitale",
                description = "Richiede l'uso di componenti elettronici, che possono avere un impatto ambientale maggiore rispetto alle componenti meccaniche utilizzate in una sveglia analogica. È meno rumorosa ed è possibile selezionare diversi suoni per il risveglio.",
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
                subtitle = "TV con schermo a cristalli liquidi",
                description = "In generale, tutte le tipologie di televisioni hanno un impatto ambientale negativo; tra quelli selezionati è il peggiore in termini di consumo di KWh/anno e conseguentemente in termini di consumo di CO2. Offrono una buona esperienza visiva e il prezzo è accessibile.",
                co2 = 35,
                price = 250,
                quality = 5,
            ),
            Opzione(
                id = "2",
                title = "TV LED",
                subtitle = "TV con schermo retroilluminato",
                description = "In generale, tutte le tipologie di televisioni hanno un impatto ambientale negativo; il consumo di CO2 è inferiore rispetto ai televisori LCD, ma il prezzo è leggermente superiore. La qualità visiva è medio-alta.",
                co2 = 98,
                price = 450,
                quality = 7,
            ),
            Opzione(
                id = "3",
                title = "TV OLED",
                subtitle = "TV con schermo a tecnologia di illuminazione organica",
                description = "In generale, tutte le tipologie di televisioni hanno un impatto ambientale negativo; in confronto alle altre tipologie, però, sono leggermente più ecologici, grazie alla loro tecnologia di illuminazione organica. Sono considerati i migliori in termini di qualità dell'immagine e angolo di visione. Tuttavia, sono i più costosi sul mercato.",
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
                subtitle = "Lampadina tradizionale a filamento",
                description = "Richiedono molta energia elettrica per funzionare e producono una quantità significativa di calore. Il loro impatto ecologico è decisamente negativo. Inoltre, in alcuni paesi non sono più commercializzate a causa del loro basso rendimento energetico.",
                co2 = 29,
                price = 1,
                quality = 5,
                default = true,
            ),
            Opzione(
                id = "2",
                title = "Fluorescenza",
                subtitle = "Lampadine per illuminare al meglio la stanza",
                description = "Consumano meno energia e durano più a lungo rispetto alle lampadine incandescenti. Tuttavia, contengono mercurio, un metallo pesante tossico, e richiedono un corretto smaltimento per evitare l'inquinamento ambientale.",
                co2 = 50,
                price = 5,
                quality = 7,
            ),
            Opzione(
                id = "3",
                title = "Led",
                subtitle = "Lampadine a risparmio energetico",
                description = "Sono le più efficienti in termini di consumo energetico e durata, consumano circa il 75% in meno di energia rispetto alle lampadine incandescenti e hanno una durata di vita molto più lunga",
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
                subtitle = "Finestre in PVC",
                description = "Sono economici, resistenti all'acqua e all'aria, e hanno un'ottima isolamento termico. Tuttavia, possono essere meno resistenti agli agenti atmosferici rispetto ad altri materiali e possono avere un impatto ambientale negativo a causa della produzione di PVC.",
                co2 = 1178,
                price = 250,
                quality = 5,
                default = true,
            ),
            Opzione(
                id = "2",
                title = "Legno",
                subtitle = "Finestre in legno",
                description = "Sono resistenti, duraturi e hanno un ottimo isolamento termico. Tuttavia, sono anche più costosi rispetto ad altri materiali e richiedono manutenzione regolare.",
                co2 = 1064,
                price = 500,
                quality = 7,
            ),
            Opzione(
                id = "3",
                title = "Alluminio",
                subtitle = "Finestre in alluminio",
                description = "Sono resistenti, duraturi e hanno un ottimo isolamento termico. Tuttavia, possono avere un impatto ambientale negativo a causa della produzione di alluminio. Generalmente sono i più costosi, tra le categorie selezionate.",
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
                subtitle = "Elettrodomestico per creare corrente d'aria",
                description = "Non possono abbassare la temperatura dell'ambiente, ma semplicemente spostare l'aria circostante; quindi, potrebbero non essere adatti in caso di caldo eccessivo. Inoltre, alcuni modelli sono particolarmente rumorosi. I vantaggi sono legati ad un minor consumo di elettricità e un prezzo conveniente.",
                co2 = 156,
                price = 250,
                quality = 3,
            ),
            Opzione(
                id = "2",
                title = "Condizionatore mobile",
                subtitle = "Sistema di climatizzazione portatile",
                description = "Sono progettati per lavorare solo per brevi periodi di tempo. Hanno una potenza inferiore rispetto ai condizionatori fissi, il che li rende meno adatti per raffreddare spazi più grandi. ",
                co2 = 143,
                price = 500,
                quality = 5,
            ),
            Opzione(
                id = "3",
                title = "Condizionatore fisso",
                subtitle = "Sistema di climatizzazione installato a parete",
                description = "Sono progettati per lavorare a pieno regime per lunghi periodi di tempo, il che li rende più efficienti rispetto ai condizionatori mobili. Sia a livello di estetica, sia a livello di potenza sono migliori rispetto alle altre tipologie. Tuttavia, il costo è decisamente più elevato.",
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
                subtitle = "Sistema di riscaldamento tramite pavimento radiante",
                description = "Questo sistema utilizza tubi d'acqua nascosti sotto il pavimento per diffondere il calore nella stanza. È altamente efficiente dal punto di vista energetico, ma richiede un'installazione complessa e un costo elevato.",
                co2 = 1297,
                price = 7900,
                quality = 6,
            ),
            Opzione(
                id = "2",
                title = "Pompa di calore",
                subtitle = "Sistema di riscaldamento tramite pompa di calore",
                description = "Questo sistema utilizza una pompa di calore per trasferire il calore dall'ambiente esterno all'interno dell'edificio. È efficiente dal punto di vista energetico, ma richiede un costo elevato per l'acquisto e l'installazione.",
                co2 = 1167,
                price = 7100,
                quality = 7,
            ),
            Opzione(
                id = "3",
                title = "Pellet",
                subtitle = "Sistema di riscaldamento alimentato a pellet di legno",
                description = "Questo sistema utilizza una stufa a pellet o a legna per produrre calore. Le stufe a pellet o legna sono convenienti dal punto di vista del costo, ma producono una significativa quantità di CO2 e altri gas serra",
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