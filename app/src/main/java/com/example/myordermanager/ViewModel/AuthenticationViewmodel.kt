package com.example.myordermanager.ViewModel

import android.content.Context
import android.credentials.GetCredentialException
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import androidx.credentials.GetPasswordOption
import androidx.credentials.GetPublicKeyCredentialOption
import androidx.credentials.PasswordCredential
import androidx.credentials.PublicKeyCredential
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myordermanager.R
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.security.SecureRandom
import java.util.Base64
import javax.inject.Inject


@HiltViewModel
class AuthenticationViewmodel @Inject constructor(
    @ApplicationContext private val context: Context
) : ViewModel() {

    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    fun buttonClick(context: Context) {


        val credentialManager = CredentialManager.create(context)

        var request : GetCredentialRequest
           request= GetCredentialRequest.Builder()
               .addCredentialOption(getGoogleSignin())
              // .addCredentialOption(getPasskeySignin())
               .addCredentialOption(GetPasswordOption())
               .build()

        viewModelScope.launch {
            try {
                val result = credentialManager.getCredential(
                    context = context,
                    request = request
                )
                handleSignIn(result)
            } catch (e: GetCredentialException) {
                handleFailure(e)
            }
        }

    }

    private fun handleFailure(e: GetCredentialException) {
        TODO("Not yet implemented")
    }

    fun handleSignIn(result: GetCredentialResponse) {

        val credential = result.credential

        when (credential) {
            is PublicKeyCredential -> {
                val responseJson = credential.authenticationResponseJson
                // Share responseJson i.e. a GetCredentialResponse on your server to
                // validate and  authenticate
            }

            is PasswordCredential -> {
                val username = credential.id
                val password = credential.password
                // Use id and password to send to your server to validate
                // and authenticate
            }

            is GoogleIdTokenCredential -> {}
            /*  is CustomCredential -> {
                  // If you are also using any external sign-in libraries, parse them
                  // here with the utility functions provided.
                  if (credential.type == CustomCredential.TYPE)  {
                      try {
                          val ExampleCustomCredential = ExampleCustomCredential.createFrom(credential.data)
                          // Extract the required credentials and complete the authentication as per
                          // the federated sign in or any external sign in library flow
                      } catch (e: CustomCredential.ExampleCustomCredentialParsingException) {
                          // Unlikely to happen. If it does, you likely need to update the dependency
                          // version of your external sign-in library.
                          Log.e(TAG, "Failed to parse an ExampleCustomCredential", e)
                      }
                  } else {
                      // Catch any unrecognized custom credential type here.
                      Log.e(TAG, "Unexpected type of credential")
                  }
              } else -> {
              // Catch any unrecognized credential type here.
              Log.e(TAG, "Unexpected type of credential")
          }*/
        }
    }

    private fun generateNonce(): String {
        val nonce = ByteArray(16)
        SecureRandom().nextBytes(nonce)
        return Base64.getUrlEncoder().withoutPadding().encodeToString(nonce)
    }

    private fun getGoogleSignin(): GetGoogleIdOption {

        val googleIdOption=  GetGoogleIdOption.Builder()
            .setFilterByAuthorizedAccounts(true)
            .setServerClientId(context.getString(R.string.server_client_id))
            .setAutoSelectEnabled(true)
            .setNonce(generateNonce())
            .build()

        return googleIdOption

        /*val signInRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId("YOUR_WEB_CLIENT_ID")  // Replace with actual Web Client ID
                    .setFilterByAuthorizedAccounts(false)
                    .build()
            )
            .setAutoSelectEnabled(true)
            .build()*/

    /*    val googleSignInOption = GoogleIdTokenCredentialOption(
            supportedProviders = listOf("https://accounts.google.com"),
            serverClientId = "959648160791-6bpa62hagnbtvv22u7usbv6j43c0o5ce.apps.googleusercontent.com"
        )*/

    }

    private fun getPasskeySignin() : GetPublicKeyCredentialOption {

        /*val requestJson = """
{
   "challenge": "random-challenge-string",
  "rp": { "name": "ExampleApp", "id": "com.example.myordermanager" },
  "user": {
    "id": "base64-encoded-user-id",
    "name": "user@example.com",
    "displayName": "User Name"
  },
  "pubKeyCredParams": [
    { "type": "public-key", "alg": -7 }, 
    { "type": "public-key", "alg": -257 }
  ],
  "timeout": 60000,
  "attestation": "direct"
}
""".trimIndent()*/


        val passkeyRequestJson = JSONObject().apply {
            put("challenge", "random-challenge")
            put("rp", JSONObject().apply {
                put("name", "MyApp")
                put("id", "com.example.myordermanager") // ✅ Use app package name
            })
        }.toString()

        val publickey= GetPublicKeyCredentialOption(
            passkeyRequestJson
        )

        return /*GetCredentialRequest.Builder()
            .addCredentialOption(publickey)
            .build()*/ publickey



    }

}