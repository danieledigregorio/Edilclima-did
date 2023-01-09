package it.polito.did.edilclima

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import it.polito.did.edilclima.ui.theme.Black
import it.polito.did.edilclima.ui.theme.White1

// Set of Material typography styles to start with
val poppinsFamily = FontFamily(
    Font(R.font.poppins_thin, FontWeight.Thin, FontStyle.Normal),
    Font(R.font.poppins_extralight, FontWeight.ExtraLight, FontStyle.Normal),
    Font(R.font.poppins_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.poppins_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.poppins_semibold, FontWeight.SemiBold, FontStyle.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.poppins_extrabold, FontWeight.ExtraBold, FontStyle.Normal),
    Font(R.font.poppins_black, FontWeight.Black, FontStyle.Normal),
    Font(R.font.poppins_thin_italic, FontWeight.Thin, FontStyle.Italic),
    Font(R.font.poppins_extralight_italic, FontWeight.ExtraLight, FontStyle.Italic),
    Font(R.font.poppins_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.poppins_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.poppins_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.poppins_semibold_italic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.poppins_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.poppins_extrabold_italic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.poppins_black_italic, FontWeight.Black, FontStyle.Italic),
)
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = poppinsFamily,
        color = White1,
    ),
    body2 = TextStyle(
        fontFamily = poppinsFamily,
        color = White1,
    ),
    h1 = TextStyle(
        fontFamily = poppinsFamily,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = White1,
    ),
    h2 = TextStyle(
        fontFamily = poppinsFamily,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = White1,
    ),
    h3 = TextStyle(
        fontFamily = poppinsFamily,
        color = White1,
    ),
    h4 = TextStyle(
        fontFamily = poppinsFamily,
        color = White1,
    ),
    h5 = TextStyle(
        fontFamily = poppinsFamily,
        color = White1,
    ),
    h6 = TextStyle(
        fontFamily = poppinsFamily,
        color = White1,
    ),
    button = TextStyle(
        fontFamily = poppinsFamily,
    ),
    caption = TextStyle(
        fontFamily = poppinsFamily,
    ),
    subtitle1 = TextStyle(
        fontFamily = poppinsFamily,
    ),
    subtitle2 = TextStyle(
        fontFamily = poppinsFamily,
    ),
    overline = TextStyle(
        fontFamily = poppinsFamily,
    ),
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)