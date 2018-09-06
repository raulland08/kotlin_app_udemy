package com.raulpineres.primeraappandroidkotlin.activities

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Toast
import com.raulpineres.primeraappandroidkotlin.R
import kotlinx.android.synthetic.main.activity_permissions.*

class PermissionsActivity : AppCompatActivity() {

    private val REQUEST_CODE = 100
    private val REQUEST_RESULT = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)

        button_picture.setOnClickListener { getPictureAskingPermissions() }
    }

    private fun getPictureAskingPermissions(){
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), REQUEST_CODE)
        }else {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, REQUEST_RESULT)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            REQUEST_CODE -> {
                if(grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(intent, REQUEST_RESULT)
                }else {
                    Toast.makeText(this, "No puedes tomar la foto. ¡Necesitas permisos!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode){
            REQUEST_RESULT -> {
                if(resultCode == Activity.RESULT_OK){
                    val extras = data!!.extras
                    val imageBitMap = extras.get("data") as Bitmap

                    image_view_picture.setImageBitmap(imageBitMap)
                }else {
                    Toast.makeText(this, "Ha ocurrido un error recbiendo la foto", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
