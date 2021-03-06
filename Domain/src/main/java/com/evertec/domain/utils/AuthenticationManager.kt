package com.evertec.domain.utils

import com.evertec.businessmodels.request.Auth
import com.evertec.domain.R
import com.evertec.utils.ViewManager
import com.evertec.utils.security.CryptoTools

object AuthenticationManager {
    fun buildAuthentication(nonce : String): Auth {
        val seed = CryptoTools.buildSeed()
        val cryptNone = CryptoTools.buildNonce(nonce)
        return Auth(
            login = ViewManager.getInstance.getString(R.string.login_service),
            tranKey = CryptoTools.buildPasswordDigest(
                tranKey = ViewManager.getInstance.getString(R.string.tranKey_service),
                seed = seed,
                nonce = nonce
            ),
            nonce = cryptNone,
            seed = seed
        )
    }
}