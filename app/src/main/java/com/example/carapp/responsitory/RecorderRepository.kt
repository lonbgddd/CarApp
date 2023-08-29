package com.example.carapp.responsitory

import com.example.carapp.data.model.Recorder
import kotlinx.coroutines.flow.Flow


interface RecorderRepository {
    suspend fun insertRecorder(recorder: Recorder)
    suspend fun deleteRecorder(recorder: Recorder)
    suspend fun getRecorderById(recorder: Recorder)

    suspend fun getRecorder(): Flow<List<Recorder>>
}