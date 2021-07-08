package com.example.myapplication.extension

import kotlinx.coroutines.flow.*

suspend inline fun <T> Flow<T>.getResult(
    crossinline onSuccess: (T) -> Unit,
    noinline onError: (() -> Unit)? = null,
    noinline onComplete: (() -> Unit)? = null
) {
    this
        .onEach { item -> onSuccess(item) }
        .onCompletion { onComplete?.invoke() }
        .catch { error -> onError?.invoke() }
        .collect()
}