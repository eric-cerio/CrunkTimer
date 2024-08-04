package utils


import platform.Foundation.NSURL
import platform.UIKit.UIApplication
import platform.UIKit.UIDocumentPickerDelegateProtocol
import platform.UIKit.UIDocumentPickerMode
import platform.UIKit.UIDocumentPickerViewController
import platform.UIKit.UIViewController
import platform.darwin.NSObject

actual class FilePicker : NSObject() {
    private var completionHandler: ((NSURL) -> Unit)? = null

    actual fun pickFile() {
        val viewController= UIApplication.sharedApplication.keyWindow?.rootViewController as UIViewController
        val documentPicker= UIDocumentPickerViewController(documentTypes = listOf("public.item"), inMode = UIDocumentPickerMode.UIDocumentPickerModeImport)
        documentPicker.allowsMultipleSelection()

        documentPicker.delegate = object : NSObject(), UIDocumentPickerDelegateProtocol {
            fun documentPicker(controller: UIDocumentPickerViewController, didPickDocumentsAtURLs: List<NSURL>) {
                didPickDocumentsAtURLs.firstOrNull()?.let { completionHandler?.invoke(it) }
            }

            override fun documentPickerWasCancelled(controller: UIDocumentPickerViewController) {
                completionHandler?.invoke(null)
            }
        }

        viewController?.presentViewController(documentPicker, animated = true, completion = null)
    }

    fun setCompletionHandler(handler: ((NSURL) -> Unit)?) {
        completionHandler = handler
    }
}