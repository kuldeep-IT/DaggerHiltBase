package com.example.mvvmwithdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.mvvmwithdi.constants.Constants.ERROR_OBJECT
import com.example.mvvmwithdi.constants.Constants.USER_LIST
import com.example.mvvmwithdi.constants.Constants.USER_OBJECT
import com.example.mvvmwithdi.model.User
import com.example.mvvmwithdi.ui.Resource
import com.example.mvvmwithdi.utils.Utils.getArrayBody
import com.example.mvvmwithdi.utils.Utils.getObjectBody
import com.example.mvvmwithdi.viewmodel.DataViewModel
import dagger.hilt.android.AndroidEntryPoint


//Processor : Application
//Battery : Activity
//Camera :  Fragment

/*info: https://blog.mindorks.com/dagger-hilt-tutorial*/

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val dataViewModel: DataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataViewModel.getLiveData().observe(this){response ->
            when(response){
                is Resource.Success -> {
//                    hideProgressBar()
                    when(response.endpoint){
                        USER_LIST -> {
                            response.data?.let { responseData ->
                                Log.d("API_RESPONSE", responseData.toString())
                                val arrayUser = responseData.getArrayBody<ArrayList<User>/*User*/, User>(className = User::class.java)
                                Log.d("API_RESPONSE", "HELLO")
//                        Log.d("API_RESPONSE", "${response.getBody<ArrayList<User>, User>(className = User::class.java)} ")

                            }
                        }
                        USER_OBJECT->{
                            response.data?.let { responseData ->
                                val userModel = responseData.getObjectBody<User>(className = User::class.java)

                                Log.d("API_RESPONSE", "HELLO")
//                        Log.d("API_RESPONSE", "${response.getBody<ArrayList<User>, User>(className = User::class.java)} ")
                            }
                        }
                        ERROR_OBJECT->{
                            Log.d("API_ERROR", "ERROR")
                        }
                    }

                }
                is Resource.Error -> {
                    Log.d("API_ERROR", response.message.toString())
                }
            }
        }

        dataViewModel.getData(USER_LIST)
//        dataViewModel.postDataApi(USER_OBJECT, User())
//        dataViewModel.putDataApi(USER_OBJECT,User())
        dataViewModel.getData(ERROR_OBJECT)

    }


}