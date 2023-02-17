package com.example.universitieslist.ui.fragments

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.fragment.findNavController
import com.example.universitieslist.R
import com.example.universitieslist.databinding.UniversityWebviewFragmentBinding
import com.example.universitieslist.utils.BaseFragment


class UniversityWebViewFragment : BaseFragment(R.layout.university_search_fragment) {

    private lateinit var universityWebViewFragment: UniversityWebviewFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        universityWebViewFragment =
            UniversityWebviewFragmentBinding.inflate(inflater, container, false)
        viewInitialize()
        return universityWebViewFragment.root
    }


    private fun viewInitialize() {
        universityWebViewFragment.ivBack.setOnClickListener { findNavController().popBackStack() }
        arguments?.getString("url")?.let { universityWebViewFragment.WebView.loadUrl(it) }

        val webViewClient: WebViewClient = object: WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view?.loadUrl(request?.url.toString())
                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                universityWebViewFragment.WebView.hide()
                universityWebViewFragment.progressCircular.show()
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                universityWebViewFragment.WebView.show()
                universityWebViewFragment.progressCircular.hide()
                super.onPageFinished(view, url)
            }
        }
        universityWebViewFragment.WebView.webViewClient = webViewClient

        universityWebViewFragment.WebView.settings.defaultTextEncodingName = "utf-8"
    }
}