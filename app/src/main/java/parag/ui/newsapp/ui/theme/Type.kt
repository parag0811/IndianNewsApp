package parag.ui.newsapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import parag.ui.newsapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val poppinsFontFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Black),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_semibold, FontWeight.SemiBold)
)

val robotoFontFamily = FontFamily(
    Font(R.font.roboto_black, FontWeight.Black),
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_regular, FontWeight.Normal)
)

val opensansFontFamily = FontFamily(
    Font(R.font.opensans_regular, FontWeight.Normal),
    Font(R.font.opensans_bold, FontWeight.Bold),
    Font(R.font.opensans_semibold, FontWeight.SemiBold),
    Font(R.font.opensans_medium, FontWeight.Medium)
)

val kanitFontFamily = FontFamily(
    Font(R.font.kanit_regular, FontWeight.Normal),
    Font(R.font.kanit_bold, FontWeight.Bold),
    Font(R.font.kanit_semibold, FontWeight.SemiBold)
)

val dmsansFontFamily = FontFamily(
    Font(R.font.dmsans_regular, FontWeight.Normal),
    Font(R.font.dmsans_bold, FontWeight.Bold),
    Font(R.font.dmsans_med, FontWeight.Medium)
)