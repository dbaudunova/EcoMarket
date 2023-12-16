package com.example.ecomarket.ui.info

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.viewModels
import com.example.ecomarket.base.BaseFragment
import com.example.ecomarket.databinding.FragmentInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoFragment : BaseFragment<FragmentInfoBinding, InfoViewModel>() {

    override val viewModel: InfoViewModel by viewModels()
    private val number: String = "0707637341"

    override fun initListener() {
        super.initListener()
        binding.btnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$number")
            startActivity(intent)
        }
        binding.btnWhatsapp.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("smsto:${number}")
            intent.setPackage("com.whatsapp")
            startActivity(intent)
        }
        binding.btnInstagram.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.instagram.com/dbaudunova")
            intent.setPackage("com.instagram.android")
            startActivity(intent)
        }
    }

    override fun inflateViewBinding(): FragmentInfoBinding {
        return FragmentInfoBinding.inflate(layoutInflater)
    }
}