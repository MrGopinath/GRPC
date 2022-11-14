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
    comments = "Source: unary.proto")
public final class unaryGrpc {

  private unaryGrpc() {}

  public static final String SERVICE_NAME = "unary";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.Unary.breq,
      com.Unary.bres> getBookstoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bookstore",
      requestType = com.Unary.breq.class,
      responseType = com.Unary.bres.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.Unary.breq,
      com.Unary.bres> getBookstoreMethod() {
    io.grpc.MethodDescriptor<com.Unary.breq, com.Unary.bres> getBookstoreMethod;
    if ((getBookstoreMethod = unaryGrpc.getBookstoreMethod) == null) {
      synchronized (unaryGrpc.class) {
        if ((getBookstoreMethod = unaryGrpc.getBookstoreMethod) == null) {
          unaryGrpc.getBookstoreMethod = getBookstoreMethod = 
              io.grpc.MethodDescriptor.<com.Unary.breq, com.Unary.bres>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "unary", "bookstore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.Unary.breq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.Unary.bres.getDefaultInstance()))
                  .setSchemaDescriptor(new unaryMethodDescriptorSupplier("bookstore"))
                  .build();
          }
        }
     }
     return getBookstoreMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static unaryStub newStub(io.grpc.Channel channel) {
    return new unaryStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static unaryBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new unaryBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static unaryFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new unaryFutureStub(channel);
  }

  /**
   */
  public static abstract class unaryImplBase implements io.grpc.BindableService {

    /**
     */
    public void bookstore(com.Unary.breq request,
        io.grpc.stub.StreamObserver<com.Unary.bres> responseObserver) {
      asyncUnimplementedUnaryCall(getBookstoreMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBookstoreMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.Unary.breq,
                com.Unary.bres>(
                  this, METHODID_BOOKSTORE)))
          .build();
    }
  }

  /**
   */
  public static final class unaryStub extends io.grpc.stub.AbstractStub<unaryStub> {
    private unaryStub(io.grpc.Channel channel) {
      super(channel);
    }

    private unaryStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected unaryStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new unaryStub(channel, callOptions);
    }

    /**
     */
    public void bookstore(com.Unary.breq request,
        io.grpc.stub.StreamObserver<com.Unary.bres> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBookstoreMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class unaryBlockingStub extends io.grpc.stub.AbstractStub<unaryBlockingStub> {
    private unaryBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private unaryBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected unaryBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new unaryBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.Unary.bres bookstore(com.Unary.breq request) {
      return blockingUnaryCall(
          getChannel(), getBookstoreMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class unaryFutureStub extends io.grpc.stub.AbstractStub<unaryFutureStub> {
    private unaryFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private unaryFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected unaryFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new unaryFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.Unary.bres> bookstore(
        com.Unary.breq request) {
      return futureUnaryCall(
          getChannel().newCall(getBookstoreMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BOOKSTORE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final unaryImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(unaryImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BOOKSTORE:
          serviceImpl.bookstore((com.Unary.breq) request,
              (io.grpc.stub.StreamObserver<com.Unary.bres>) responseObserver);
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

  private static abstract class unaryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    unaryBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.Unary.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("unary");
    }
  }

  private static final class unaryFileDescriptorSupplier
      extends unaryBaseDescriptorSupplier {
    unaryFileDescriptorSupplier() {}
  }

  private static final class unaryMethodDescriptorSupplier
      extends unaryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    unaryMethodDescriptorSupplier(String methodName) {
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
      synchronized (unaryGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new unaryFileDescriptorSupplier())
              .addMethod(getBookstoreMethod())
              .build();
        }
      }
    }
    return result;
  }
}
