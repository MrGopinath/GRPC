package com;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: serverstream.proto")
public final class serverstreamingGrpc {

  private serverstreamingGrpc() {}

  public static final String SERVICE_NAME = "serverstreaming";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.Serverstream.areq,
      com.Serverstream.ares> getAuthorsearchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "authorsearch",
      requestType = com.Serverstream.areq.class,
      responseType = com.Serverstream.ares.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.Serverstream.areq,
      com.Serverstream.ares> getAuthorsearchMethod() {
    io.grpc.MethodDescriptor<com.Serverstream.areq, com.Serverstream.ares> getAuthorsearchMethod;
    if ((getAuthorsearchMethod = serverstreamingGrpc.getAuthorsearchMethod) == null) {
      synchronized (serverstreamingGrpc.class) {
        if ((getAuthorsearchMethod = serverstreamingGrpc.getAuthorsearchMethod) == null) {
          serverstreamingGrpc.getAuthorsearchMethod = getAuthorsearchMethod = 
              io.grpc.MethodDescriptor.<com.Serverstream.areq, com.Serverstream.ares>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "serverstreaming", "authorsearch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.Serverstream.areq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.Serverstream.ares.getDefaultInstance()))
                  .setSchemaDescriptor(new serverstreamingMethodDescriptorSupplier("authorsearch"))
                  .build();
          }
        }
     }
     return getAuthorsearchMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static serverstreamingStub newStub(io.grpc.Channel channel) {
    return new serverstreamingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static serverstreamingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new serverstreamingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static serverstreamingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new serverstreamingFutureStub(channel);
  }

  /**
   */
  public static abstract class serverstreamingImplBase implements io.grpc.BindableService {

    /**
     */
    public void authorsearch(com.Serverstream.areq request,
        io.grpc.stub.StreamObserver<com.Serverstream.ares> responseObserver) {
      asyncUnimplementedUnaryCall(getAuthorsearchMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAuthorsearchMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.Serverstream.areq,
                com.Serverstream.ares>(
                  this, METHODID_AUTHORSEARCH)))
          .build();
    }
  }

  /**
   */
  public static final class serverstreamingStub extends io.grpc.stub.AbstractStub<serverstreamingStub> {
    private serverstreamingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private serverstreamingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serverstreamingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new serverstreamingStub(channel, callOptions);
    }

    /**
     */
    public void authorsearch(com.Serverstream.areq request,
        io.grpc.stub.StreamObserver<com.Serverstream.ares> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getAuthorsearchMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class serverstreamingBlockingStub extends io.grpc.stub.AbstractStub<serverstreamingBlockingStub> {
    private serverstreamingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private serverstreamingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serverstreamingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new serverstreamingBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.Serverstream.ares> authorsearch(
        com.Serverstream.areq request) {
      return blockingServerStreamingCall(
          getChannel(), getAuthorsearchMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class serverstreamingFutureStub extends io.grpc.stub.AbstractStub<serverstreamingFutureStub> {
    private serverstreamingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private serverstreamingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected serverstreamingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new serverstreamingFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_AUTHORSEARCH = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final serverstreamingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(serverstreamingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AUTHORSEARCH:
          serviceImpl.authorsearch((com.Serverstream.areq) request,
              (io.grpc.stub.StreamObserver<com.Serverstream.ares>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class serverstreamingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    serverstreamingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.Serverstream.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("serverstreaming");
    }
  }

  private static final class serverstreamingFileDescriptorSupplier
      extends serverstreamingBaseDescriptorSupplier {
    serverstreamingFileDescriptorSupplier() {}
  }

  private static final class serverstreamingMethodDescriptorSupplier
      extends serverstreamingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    serverstreamingMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (serverstreamingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new serverstreamingFileDescriptorSupplier())
              .addMethod(getAuthorsearchMethod())
              .build();
        }
      }
    }
    return result;
  }
}
