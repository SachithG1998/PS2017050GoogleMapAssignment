package lk.ac.kln.stu.ps2017050googlemapassignment.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import lk.ac.kln.stu.ps2017050googlemapassignment.R
import lk.ac.kln.stu.ps2017050googlemapassignment.data.Datasource
import lk.ac.kln.stu.ps2017050googlemapassignment.databinding.FragmentUniversityLocationBinding
import lk.ac.kln.stu.ps2017050googlemapassignment.model.University

class UniversityLocationFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private var _binding: FragmentUniversityLocationBinding? = null
    private var mapFragment: SupportMapFragment? = null

    private val binding get() = _binding!!
    private val universities = Datasource().loadUniversities()

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val selectedUniversityName: String = binding.spinnerUniversity.selectedItem as String
        val selectedUniversity: List<University> = universities.filter { university -> university.name == selectedUniversityName }

        (activity as AppCompatActivity).supportActionBar?.title = selectedUniversity[0].name

        val university = selectedUniversity[0].location
        googleMap.addMarker(MarkerOptions().position(university).title(selectedUniversity[0].name))
        googleMap.setMinZoomPreference(17f)
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(university))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUniversityLocationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        populateSpinnerUniversity()

        val spinnerUniversity = binding.spinnerUniversity
        spinnerUniversity.onItemSelectedListener = this

        mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
    }

    private fun populateSpinnerUniversity() {
        val universities: MutableList<String> = mutableListOf()
        for (university in Datasource().loadUniversities()) {
            universities.add(university.name)
        }

        val adapter: ArrayAdapter<String>? = this.context?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_item,
                universities
            )
        }

        adapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerUniversity.adapter = adapter
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        mapFragment?.getMapAsync(callback)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}