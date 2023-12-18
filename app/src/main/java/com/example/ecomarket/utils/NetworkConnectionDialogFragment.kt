package com.example.ecomarket.utils

import com.example.ecomarket.base.BaseDialog
import com.example.ecomarket.databinding.FragmentNetworkConnectionDialogBinding
import com.example.ecomarket.utils.NetworkManager

class NetworkConnectionDialogFragment : BaseDialog<FragmentNetworkConnectionDialogBinding>() {
    override fun inflateViewBinding(): FragmentNetworkConnectionDialogBinding {
        return FragmentNetworkConnectionDialogBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        super.initViews()
        NetworkManager(requireActivity().application).observe(viewLifecycleOwner) {
            if (it) {
                dialog?.hide()
            } else {
                dialog?.show()
            }
        }
    }
}

