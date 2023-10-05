package com.example.grub_go

import android.content.Context
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Onboarding(navController: NavHostController,context: Context)
{val firstNameState = remember { mutableStateOf("") }
    val lastNameState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val phoneState = remember { mutableStateOf("") }



    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)) {
        //Logo

        Box(modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .size(100.dp)
            .padding(top = 20.dp)) {
            Row(modifier = Modifier.padding(start=90.dp), horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(id = R.drawable.kebab__3_),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(55.dp),
                )
                //Logo name
                Text(text = "Grub Go", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top=15.dp, start = 20.dp), color = Color(0xDA2C221C), fontFamily = FontFamily.Monospace)
            }
        }

        //Box with text

        Box(modifier = Modifier.background(color = Color(0xF8375238))) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
                .padding(start = 75.dp)
                .padding(bottom = 40.dp), verticalArrangement = Arrangement.Center) {
                Text(text = "Let's get to know you", fontSize = 25.sp, color = Color(0xFFF1EEEC))
            }
        }

        //Box containing input parameters

        Box() {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Personal information", modifier = Modifier.padding(start = 15.dp, top = 50.dp), fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Medium, fontSize = 20.sp, color = Color(0xDA2C221C))
                Text(text = "First name", modifier = Modifier.padding(start=20.dp, top = 20.dp, bottom = 5.dp), color = Color.DarkGray, fontSize = 15.sp)
                OutlinedTextField(
                    value = firstNameState.value,
                    onValueChange = { firstNameState.value = it },
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                        .size(48.dp),

                    shape = RoundedCornerShape(8.dp),
                )
                Text(text = "Last name", modifier = Modifier.padding(start=20.dp, top = 20.dp, bottom = 5.dp), color = Color.DarkGray, fontSize = 15.sp)
                OutlinedTextField(
                    value = lastNameState.value,
                    onValueChange = { lastNameState.value = it },
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                        .size(48.dp),

                    shape = RoundedCornerShape(8.dp),
                )
                Text(text = "Email", modifier = Modifier.padding(start=20.dp, top = 20.dp, bottom = 5.dp), color = Color.DarkGray, fontSize = 15.sp)
                OutlinedTextField(
                    value = emailState.value,
                    onValueChange = { emailState.value = it },
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                        .size(48.dp),

                    shape = RoundedCornerShape(8.dp),
                )
                Text(text = "Phone", modifier = Modifier.padding(start=20.dp, top = 20.dp, bottom = 5.dp), color = Color.DarkGray, fontSize = 15.sp)
                OutlinedTextField(
                    value =phoneState.value,
                    onValueChange = { phoneState.value = it },
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                        .size(48.dp),

                    shape = RoundedCornerShape(8.dp),
                )

            }
        }

        //Button

        Column(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                             val filled=firstNameState.value.isNotBlank()&&lastNameState.value.isNotBlank()&&emailState.value.isNotBlank() &&phoneState.value.isNotBlank()
                             val emailvalid= Patterns.EMAIL_ADDRESS.matcher(emailState.value).matches()
                if(filled && emailvalid)
                {
//                    saveUserInfo()
                    navController.navigate(Profile.route)
                }
                else
                {
                    mToast(context)
                }
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 10.dp)
                .padding(top = 30.dp, start = 15.dp, end = 15.dp),colors = ButtonDefaults.buttonColors(Color(0xFFF4CE14)),shape = RoundedCornerShape(8.dp), border = BorderStroke(1.5.dp, color = Color(0xFFA7981C))
            , elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp)) {
                Text(text = "Register", fontSize = 17.sp,color=Color.Black )
            }
        }

    }



}

private fun mToast(context: Context) {
    Toast.makeText(context,"Registration unsuccessfull. Please enter all the data correctly.",Toast.LENGTH_LONG).show()

}

//
//@Preview
//@Composable
//fun Preview(){
//    Onboarding()
//}