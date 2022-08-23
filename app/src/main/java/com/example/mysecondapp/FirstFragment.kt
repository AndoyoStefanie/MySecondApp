package com.example.mysecondapp

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.MySecondApp.R
import com.example.MySecondApp.databinding.FragmentFirstBinding as FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment(private var _binding: FragmentFirstBinding1? = null) : Fragment() {

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding1.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.randomButton.setOnClickListener { view.findViewById<Button>(R.id.random_button).setOnClickListener {

                view.findViewById<Button>(R.id.toast_button).setOnClickListener {
                    view.findViewById<Button>(R.id.count_button).setOnClickListener {
                        countMe(view)
                    }
                    // create a Toast with some text, to appear for a short time
                    val myToast = Toast.makeText(context, "Hello Toast!", Toast.LENGTH_SHORT)
                    // show the Toast
                    myToast.show()
                }
            }
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    private fun countMe(view: View) {

        val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
        val countString = showCountTextView.text.toString()
        var count = countString.toInt()
        count++
        showCountTextView.text = count.toString()
    }

    @Deprecated("Deprecated in Java")
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
