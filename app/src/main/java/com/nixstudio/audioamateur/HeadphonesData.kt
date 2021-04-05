package com.nixstudio.audioamateur

object HeadphonesData {
    private val headphoneName = arrayOf(
        "Audio Technica ATH-M50X",
        "Moondrop Blessing 2",
        "Beyerdynamics DT 770 Pro",
        "Sennheiser HD 600",
        "Moondrop Liebesleid",
        "Philips SHP 9500",
        "Grado SR80E",
        "Samson SR850",
        "HIFIMAN Sundara",
        "Tin HiFi T4",
        "Sony WH-1000XM4"
    )

    private val headphoneType = arrayOf(
        "Closed-back headphone",
        "In-Ear Monitor",
        "Closed-back headphone",
        "Open-back headphone",
        "Earbuds",
        "Open-back headphone",
        "Open-back headphone",
        "Semi-open headphone",
        "Open-back headphone",
        "In-Ear Monitor",
        "ANC Closed-back headphone"
    )

    private val headphonePrice = arrayOf(
        "$149.00",
        "$319.99",
        "$164.99",
        "$399.00",
        "$299.99",
        "$84.99",
        "$99.00",
        "$49.99",
        "$349.00",
        "$99.00",
        "$348.00"
    )

    private val headphoneSellerTel = arrayOf(
        "081298738849",
        "082213378473",
        "08812347455",
        "087833928744",
        "081236472222",
        "081283277749",
        "085122273927",
        "081599203748",
        "082237848839",
        "087866374829",
        "081279695843"
    )

    private val headphoneDetail = arrayOf(
        "As the most critically acclaimed model in the M-Series line, the ATH-M50 is praised by top audio engineers and pro audio reviewers year after year. Now, the ATH-M50x professional monitor headphones feature the same coveted sonic signature, with the added feature of detachable cables. From the large aperture drivers, sound isolating earcups and robust construction, the M50x provides an unmatched experience for the most critical audio professionals.",
        "The configuration of 1 DD and 4BA efficiently utilizes the acoustic characteristics of dynamic and armature hybrid. Unlike the blind stacking together, Blessing2's configuration is simple, reasonable, and efficient. A custom full-frequency composite balanced armature is responsible for the mid-frequency, and it is used in the 500Hz-80004 frequency band that meets the VDSF Target Response in conjunction with the circuit and filtering conditions, which guarantees the quality and dynamic density.",
        "For decades now, professional users all around the world have placed their trust in our classic range: DT 770/880/990 PRO. These benchmark-setting studio headphones, available in three different models, boast extremely detailed resolution and very transparent sound. The DT 770 PRO headphones is the range’s closed-back model and offers maximum flexibility and detailed sound that you can rely on.",
        "HD 600 – Engineered for absolute clarity, the HD 600 is the professional’s choice for reference playback. An instrument of Sennheiser’s passion for perfect sound, it is globally recognized as the standard for analytical listening in both technical and hi-fi applications—even 20-plus years after its release.",
        "Using a full brass CNC cutting the production of the cavity, the overall plating layer of silver metal, and finally polished. The left unit has its family recognized concave ring,Easy to distinguish between the left and right sides. Using silver-plated OFC wire, silver-plated thickness of 8 microns. High frequency is very exciting,Medium Frequency is very clear and the dynamic range is large.",
        "Enjoy an authentic listening experience in style. Created to offer outstanding performance through open back architecture and high-precision 50mm speaker drivers. 50mm neodymium speaker drivers deliver superior Hi-Fi sound. Deluxe breathable ear-pads improve breathability and dissipate pressure and heat for longer wearing comfort. Comfortable double layered headband cushion.",
        "Grado has taken one of the world's most legendary headphones and made it even better. The SR80e has a new driver design, a new polymer to damp resonant distortion in the plastic housing, and a new cable from plug to driver connection. The way the SR80e's new driver and plastic housing move air and react to sound vibrations virtually eliminate transient distortions. This allows the signal flow over the new cable to reproduce sound that has improved tight control of the upper and lower range of the frequency spectrum, while supporting Grado's world renowned midrange. The SR80e will produce a sound that is pure Grado, with warm harmonic colors, rich full bodied vocals, excellent dynamics, and an ultra-smooth top end.",
        "SR850 Semi-Open Studio Headphones offer an outstanding listening solution for musicians, sound engineers and general music enthusiasts alike. With solid bass response, ultra-clear highs and a over-ear design, the SR850 ensure complete comfort and accurate headphone monitoring. These headphones offer an semi-open design for enhanced ambient listening environment, allowing appropriate bleed for better stereo imaging and a wider sound stage. The 50mm drivers offer exceptional sound reproduction and wide dynamic range to instill confidence in your final mix or simply provide outstanding sound quality for your general listening pleasure.",
        "The sanskrit word \"Sundara\" literally means \"Beautiful\" and this all new Planar Magnetic headphone fits this decription in every way. HIFIMAN has advanced it's manufacturing process to create this all new planar driver at unheard of prices. The SUNDARA at \$499 retail, HIFIMAN has again set an all new bar for performance to value ratio that the rest of the industry will have a very hard time following.",
        "A Carbon Nanotube Powered Audio Experience. Design. Power. Detail. Equipped with a ￠10mm CNT dynamic driver, the TINHIFI T4 delivers definition and detail with authority. The TINHIFI T4 combines elements of high end automotive and aviation design to create a unique and stylish expression perfectly formed for audio reproduction. A single dynamic driver delivers the entire frequency response from 10Hz to 20kHz. With total harmonic distortion of only 1% @ 1kHz, the TINHIFI T4 combines fidelity and harmony at remarkable value.",
        "Only music. Nothing else. It’s just you and your music with the WH-1000XM4 headphones. The easy way to enjoy less noise and even purer sound, with smart listening technology that automatically personalises your experience. Whether you’re flying long-haul or relaxing in a café, the WH-1000XM4 headphones deliver our best ever noise cancelling performance, keeping out even more high and mid frequency sounds."
    )

    private val headphoneImages = intArrayOf(
        R.drawable.athm50x,
        R.drawable.blessing2,
        R.drawable.dt770pro,
        R.drawable.hd600,
        R.drawable.liebeslaid,
        R.drawable.shp9500,
        R.drawable.sr80e,
        R.drawable.sr850,
        R.drawable.sundara,
        R.drawable.t4,
        R.drawable.wh1000xm4
    )

    val listData : ArrayList<Headphone>
    get() {
        val list = arrayListOf<Headphone>()
        for (position in headphoneName.indices) {
            val headphone = Headphone()

            headphone.name = headphoneName[position]
            headphone.detail = headphoneDetail[position]
            headphone.price = headphonePrice[position]
            headphone.type = headphoneType[position]
            headphone.sellerTel = headphoneSellerTel[position]
            headphone.photo = headphoneImages[position]

            list.add(headphone)
        }
        return list
    }

}