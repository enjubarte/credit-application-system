package me.dio.creditapplicationsystem.exception

import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class RestExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handlerValidException(ex: MethodArgumentNotValidException): ResponseEntity<ExceptionDetails>{
        val errors: MutableMap<String, String> = HashMap()
        ex.bindingResult.allErrors.forEach { 
            error: ObjectError ->
            val fieldName:String = (error as FieldError).field
            val message: String? = error.defaultMessage
            errors[fieldName] = message!!
        }
        return ResponseEntity(
            ExceptionDetails(
                "BAD REQUEST! CONSULT THE DOCUMENTATION",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                ex.javaClass.toString(),
                errors
            ),HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(DataAccessException::class)
    fun handlerValidException(ex: DataAccessException): ResponseEntity<ExceptionDetails>{
        return ResponseEntity(
            ExceptionDetails(
                "CONFLICT! CONSULT THE DOCUMENTATION",
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                ex.javaClass.toString(),
               mutableMapOf(ex.cause.toString() to ex.message!!)
            ),HttpStatus.BAD_REQUEST
        )
    }
}