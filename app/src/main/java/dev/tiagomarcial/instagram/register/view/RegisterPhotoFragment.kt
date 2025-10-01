package dev.tiagomarcial.instagram.register.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.tiagomarcial.instagram.R
import dev.tiagomarcial.instagram.commom.view.customDialog

class RegisterPhotoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val customDialog = customDialog(requireContext())

        customDialog.setTitle(R.string.define_photo_profile)

        customDialog.addButton(R.string.photo, R.string.gallery, R.string.cancel) {
            when (it.id) {
                R.string.photo -> {
                Log.i("Teste","foto")
                }
                R.string.gallery -> {

                }
                R.string.cancel -> {
                    customDialog.dismiss()

                }
            }
        }

        customDialog.show()

    }

}