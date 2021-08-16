package br.com.zup.edu

import io.grpc.Channel
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import javax.inject.Singleton

@Factory
class GrpcClientStub {

    @Singleton
    fun fretesClientStub(@GrpcChannel("localhost:50051") channel: ManagedChannel): FretesServiceGrpc.FretesServiceBlockingStub?{

        val channel = ManagedChannelBuilder.forAddress("localhost", 50051)
            .usePlaintext()
            .maxRetryAttempts(10)
            .build()

        return FretesServiceGrpc.newBlockingStub(channel)
    }

}