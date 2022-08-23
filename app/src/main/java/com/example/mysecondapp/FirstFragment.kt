package com.example.mysecondapp

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.MySecondApp.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    
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
      private fun countMe(view: View) {

        val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
        val countString = showCountTextView.text.toString()
        var count = countString.toInt()
        count++
        showCountTextView.text = count.toString()
        
}
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.countButton.setOnClickListener {
            countMe(view)
        }
        binding.randomButton.setOnClickListener {
            val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
            val currentCount = showCountTextView.text.toString().toInt()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
            findNavController().navigate(action)
        }
        binding.toastButton.setOnClickListener {
           // create a Toast with some text, to appear for a short time
           val myToast = Toast.makeText(context, "Hello Toast!", Toast.LENGTH_SHORT)
            // SHOW TOAST
            myToast.show()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
