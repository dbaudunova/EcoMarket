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

    override fun initListener() {
        super.initListener()
        binding.btnCall.setOnClickListener {
            val number = "0707637341"
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:$number")

            startActivity(intent)

        }
    }

    override fun inflateViewBinding(): FragmentInfoBinding {
        return FragmentInfoBinding.inflate(layoutInflater)
    }
}