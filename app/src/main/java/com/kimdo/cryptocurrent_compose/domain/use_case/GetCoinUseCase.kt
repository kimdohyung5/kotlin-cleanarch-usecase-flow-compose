package com.kimdo.cryptocurrent_compose.domain.use_case

import com.kimdo.cryptocurrent_compose.common.Resource
import com.kimdo.cryptocurrent_compose.data.remote.dto.toCoinDetail
import com.kimdo.cryptocurrent_compose.domain.model.CoinDetail
import com.kimdo.cryptocurrent_compose.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(coinId:String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit( Resource.Loading<CoinDetail>() )
            val coin = repository.getCoinById(coinId ).toCoinDetail()
            emit( Resource.Success<CoinDetail>(coin))
        } catch( e: HttpException) {
            emit( Resource.Error<CoinDetail>( e.localizedMessage ?: "An unexpected error occurred"))
        } catch( e: IOException) {
            emit( Resource.Error<CoinDetail>( "Couldn't reach server. Check your internet connection."))
        }
    }
}