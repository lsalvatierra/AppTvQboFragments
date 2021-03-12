package com.qbo.apptvqbofragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.qbo.apptvqbofragments.databinding.FragmentPrimerBinding


class PrimerFragment : Fragment() {

    private var _binding: FragmentPrimerBinding? = null
    private val binding get() = _binding!!
    private lateinit var colapeticiones : RequestQueue


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPrimerBinding.inflate(inflater, container, false)
        val vista = binding.root
        colapeticiones = Volley.newRequestQueue(context)
        obtenerDatosApiRest()
        return vista
    }
    private fun obtenerDatosApiRest() {
        val urlapirest = "https://api.coinpaprika.com/v1/coins/eth-ethereum"
        val request = JsonObjectRequest(
            Request.Method.GET,
            urlapirest,
            null,
            { response->
                binding.tvid.text = response.get("id").toString()
                binding.tvnombre.text = response.get("name").toString()
                binding.tvsimbolo.text = response.get("symbol").toString()
            },{

            }
        )
        colapeticiones.add(request)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}