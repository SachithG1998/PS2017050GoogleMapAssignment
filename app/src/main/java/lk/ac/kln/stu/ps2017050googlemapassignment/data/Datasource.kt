package lk.ac.kln.stu.ps2017050googlemapassignment.data

import com.google.android.gms.maps.model.LatLng
import lk.ac.kln.stu.ps2017050googlemapassignment.model.University

class Datasource {
    fun loadUniversities(): List<University> {
        return listOf<University>(
            University("University of Colombo", LatLng(6.9000149, 79.8566051)),
            University("University of Kelaniya", LatLng(6.9731110, 79.9158580)),
            University("University of Peradeniya", LatLng(7.2563751, 80.5929232)),
            University("University of Sri Jayewardenepura", LatLng(6.852767, 79.9013959)),
            University("University of Moratuwa", LatLng(6.7951276, 79.8986783)),
            University("University of Jaffna", LatLng(9.6848556, 80.0198526)),
            University("University of Ruhuna", LatLng(5.9380921, 80.5739457)),
            University("Eastern University, Sri Lanka", LatLng(7.7944366, 81.5768284)),
            University("South Eastern University of Sri Lanka", LatLng(7.2969678, 81.8478441)),
            University("Rajarata University of Sri Lanka", LatLng(8.3608034, 80.5011482)),
            University("Sabaragamuwa University of Sri Lanka", LatLng(6.7145912, 80.7850298)),
            University("Wayamba University of Sri Lanka", LatLng(7.3225984, 79.9860276)),
            University("Uva Wellassa University of Sri Lanka", LatLng(6.9818952, 81.0740943)),
            University("University of Visual and Performing Arts", LatLng(7.0180002, 80.1891933)),
            University("Gampaha Wickramarachchi University of Indigenous Medicine", LatLng(7.0903519, 80.0344449)),
            University("University of Vavuniya", LatLng(8.758557, 80.4929579)),
        )
    }
}