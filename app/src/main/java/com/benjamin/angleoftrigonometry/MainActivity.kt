package com.benjamin.angleoftrigonometry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.benjamin.angleoftrigonometry.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Calculate the interior angle of a polygon
        binding.calculator.setOnClickListener {
            val outPutText: Double? = angle()
            if (outPutText != null) {
                binding.output.text = getString(R.string.outPut, outPutText.toString())
            } else {
                binding.output.text = getString(R.string.Error)
            }

            // Check if the user wants to calculate interior vertex angle
            val CBInterior = binding.CBInnerAngel.isChecked
            val numberOfSides = binding.ETAngleOfShape.text.toString().toDoubleOrNull()
            val interiorAngle = if (numberOfSides != null && outPutText != null) {
                outPutText / numberOfSides
            } else {
                null
            }

            if (interiorAngle != null) {
                if (CBInterior) {
                    binding.TVOutputOfInnerVertex.text = getString(R.string.outputInterior, interiorAngle.toString())
                } else {
                    binding.TVOutputOfInnerVertex.text = ""
                }
            } else {
                if (CBInterior) {
                    binding.TVOutputOfInnerVertex.text = getString(R.string.Error)
                } else {
                    binding.TVOutputOfInnerVertex.text = ""
                }
            }

            // Check if the user wants to calculate exterior vertex angle
            val CBExterior = binding.CBExteriorAngel.isChecked
            val exteriorAngleVertex = if (numberOfSides != null) {
                360 / numberOfSides
            } else {
                null
            }

            if (exteriorAngleVertex != null) {
                if (CBExterior) {
                    binding.TVOutputOfExteriorVertex.text = getString(R.string.outputExterior, exteriorAngleVertex.toString())
                } else {
                    binding.TVOutputOfExteriorVertex.text = ""
                }
            } else {
                if (CBExterior) {
                    binding.TVOutputOfExteriorVertex.text = getString(R.string.Error)
                } else {
                    binding.TVOutputOfExteriorVertex.text = ""
                }
            }
        }
    }

    // Calculate the interior angle of a polygon
    private fun angle(): Double? {
        val numberOfSides = binding.ETAngleOfShape.text.toString().toDoubleOrNull()
        val internalAngle = if (numberOfSides != null) {
            if (numberOfSides >= 2) {
                (numberOfSides - 2) * 180
            } else {
                null
            }
        } else {
            null
        }
        return internalAngle
    }
}
