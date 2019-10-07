package iamutkarshtiwari.github.io.ananas.editimage

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment
import java.io.Serializable


data class ImageEditorScreens(
    var withPaint: Boolean = false,
    var withAddText: Boolean = true,
    var withFilter: Boolean = true,
    var withRotate: Boolean = true,
    var withCrop: Boolean = true,
    var withBrightness: Boolean = true,
    var withSaturation: Boolean = true,
    var withForcePortrait: Boolean = false,
    var withStickers :Boolean = true,
    var withBeauty :Boolean = true
) : Serializable

fun Fragment.startImageEditor(sourcePath: String?, destinationPath: String?, requestCode: Int, featuresScreens: ImageEditorScreens.() -> Unit) {

    val intent = Intent(
        context,
        EditImageActivity::class.java
    )
    val features = ImageEditorScreens().apply(featuresScreens)
    intent.putExtra(SOURCE_PATH, sourcePath)
    intent.putExtra(OUTPUT_PATH, destinationPath)
    intent.putExtra(FEATURES_SCREENS,features)
    startActivityForResult(intent, requestCode)
}

fun Activity.startImageEditor(sourcePath: String?, destinationPath: String?, requestCode: Int, featuresScreens: ImageEditorScreens.() -> Unit) {
    val intent = Intent(
        this,
        EditImageActivity::class.java
    )
    val features = ImageEditorScreens().apply(featuresScreens)
    intent.putExtra(SOURCE_PATH, sourcePath)
    intent.putExtra(OUTPUT_PATH, destinationPath)
    intent.putExtra(FEATURES_SCREENS,features)

    startActivityForResult(intent, requestCode)
}