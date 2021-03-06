package com.evertec.repository.local.mapper

import com.evertec.businessmodels.business.Amount
import com.evertec.businessmodels.business.Status
import com.evertec.businessmodels.response.PaymentResponse
import com.evertec.repository.local.entities.AmountDTO
import com.evertec.repository.local.entities.PaymentResponseDTO
import com.evertec.repository.local.entities.StatusDTO


object PaymentRepositoryPaymentResponseMapper {
    fun mapPaymentResponseDTO(paymentResponse: PaymentResponse): PaymentResponseDTO {
        val paymentResponseDTO = PaymentResponseDTO()
        paymentResponseDTO.amount = mapAmountDTO(paymentResponse.amount)
        paymentResponseDTO.email = paymentResponse.email
        paymentResponseDTO.authorization = paymentResponse.authorization
        paymentResponseDTO.date = paymentResponse.date
        paymentResponseDTO.franchise = paymentResponse.franchise
        paymentResponseDTO.franchiseName = paymentResponse.franchiseName
        paymentResponseDTO.internalReference = paymentResponse.internalReference
        paymentResponseDTO.issuerName = paymentResponse.issuerName
        paymentResponseDTO.paymentMethod = paymentResponse.paymentMethod
        paymentResponseDTO.receipt = paymentResponse.receipt
        paymentResponseDTO.reference = paymentResponse.reference
        paymentResponseDTO.status = mapStatusDTO(paymentResponse.status)
        paymentResponseDTO.transactionDate = paymentResponse.transactionDate
        return paymentResponseDTO
    }

    fun mapAmountDTO(amount: Amount): AmountDTO {
        val amountDto = AmountDTO()
        amountDto.currency = amount.currency
        amountDto.total = amount.total
        return amountDto
    }

    fun mapStatusDTO(status: Status): StatusDTO {
        val statusDTO = StatusDTO()
        statusDTO.date = status.date
        statusDTO.message = status.message
        statusDTO.reason = status.reason
        statusDTO.status = status.status
        return statusDTO
    }

    fun mapPaymentResponseBusiness(paymentResponseDTO: PaymentResponseDTO): PaymentResponse {
        val paymentResponse = PaymentResponse()
        paymentResponse.amount = mapAmountBusiness(paymentResponseDTO.amount)
        paymentResponse.email = paymentResponseDTO.email
        paymentResponse.authorization = paymentResponseDTO.authorization
        paymentResponse.date = paymentResponseDTO.date
        paymentResponse.franchise = paymentResponseDTO.franchise
        paymentResponse.franchiseName = paymentResponseDTO.franchiseName
        paymentResponse.internalReference = paymentResponseDTO.internalReference
        paymentResponse.issuerName = paymentResponseDTO.issuerName
        paymentResponse.paymentMethod = paymentResponseDTO.paymentMethod
        paymentResponse.receipt = paymentResponseDTO.receipt
        paymentResponse.reference = paymentResponseDTO.reference
        paymentResponse.status = mapStatusBusiness(paymentResponseDTO.status)
        paymentResponse.transactionDate = paymentResponse.transactionDate
        return paymentResponse
    }

    fun mapAmountBusiness(amountDTO: AmountDTO): Amount {
        return Amount(
            currency = amountDTO.currency,
            total = amountDTO.total
        )
    }

    fun mapStatusBusiness(statusDTO: StatusDTO): Status {
        val status = Status()
        status.date = statusDTO.date
        status.message = statusDTO.message
        status.reason = statusDTO.reason
        status.status = statusDTO.status
        return status
    }
}