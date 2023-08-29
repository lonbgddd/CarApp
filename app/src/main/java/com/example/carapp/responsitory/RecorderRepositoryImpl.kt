package com.example.carapp.responsitory

import com.example.carapp.data.model.Recorder
import com.example.carapp.data.network.RetroService
import kotlinx.coroutines.flow.Flow

class RecorderRepositoryImpl(private val data: RetroService) : RecorderRepository {
    override suspend fun insertRecorder(recorder: Recorder) {

    }

    override suspend fun deleteRecorder(recorder: Recorder) {
        TODO("Not yet implemented")
    }

    override suspend fun getRecorderById(recorder: Recorder) {
        TODO("Not yet implemented")
    }

    override suspend fun getRecorder(): Flow<List<Recorder>> {
        return data.getPostList()
    }
}