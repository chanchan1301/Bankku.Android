package id.dompetku.app
import android.app.Activity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.view.View
import android.view.WindowManager
import android.graphics.Color
class MainActivity : Activity() {
 private lateinit var webView: WebView
 @Suppress("SetJavaScriptEnabled")
 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  window.statusBarColor = Color.rgb(21,35,35)
  window.navigationBarColor = Color.rgb(21,35,35)
  window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
  webView = WebView(this)
  webView.setBackgroundColor(Color.rgb(244,247,248))
  webView.settings.javaScriptEnabled = true
  webView.settings.domStorageEnabled = true
  webView.settings.allowFileAccess = false
  webView.settings.allowContentAccess = false
  webView.webViewClient = WebViewClient()
  webView.webChromeClient = WebChromeClient()
  webView.isVerticalScrollBarEnabled = false
  webView.overScrollMode = View.OVER_SCROLL_NEVER
  setContentView(webView)
  if (savedInstanceState == null) webView.loadUrl("file:///android_asset/index.html") else webView.restoreState(savedInstanceState)
 }
 override fun onSaveInstanceState(outState: Bundle) { webView.saveState(outState); super.onSaveInstanceState(outState) }
 @Deprecated("Deprecated in Android API, kept for broad compatibility")
 override fun onBackPressed() { if (::webView.isInitialized && webView.canGoBack()) webView.goBack() else super.onBackPressed() }
}
