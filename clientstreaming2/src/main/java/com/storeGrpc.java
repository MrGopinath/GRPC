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
    comments = "Source: store.proto")
public final class storeGrpc {

  private storeGrpc() {}

  public static final String SERVICE_NAME = "store";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.Store.purchase,
      com.Store.total> getDeptstoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deptstore",
      requestType = com.Store.purchase.class,
      responseType = com.Store.total.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.Store.purchase,
      com.Store.total> getDeptstoreMethod() {
    io.grpc.MethodDescriptor<com.Store.purchase, com.Store.total> getDeptstoreMethod;
    if ((getDeptstoreMethod = storeGrpc.getDeptstoreMethod) == null) {
      synchronized (storeGrpc.class) {
        if ((getDeptstoreMethod = storeGrpc.getDeptstoreMethod) == null) {
          storeGrpc.getDeptstoreMethod = getDeptstoreMethod = 
              io.grpc.MethodDescriptor.<com.Store.purchase, com.Store.total>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "store", "deptstore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.Store.purchase.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.Store.total.getDefaultInstance()))
                  .setSchemaDescriptor(new storeMethodDescriptorSupplier("deptstore"))
                  .build();
          }
        }
     }
     return getDeptstoreMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static storeStub newStub(io.grpc.Channel channel) {
    return new storeStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static storeBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new storeBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static storeFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new storeFutureStub(channel);
  }

  /**
   */
  public static abstract class storeImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.Store.purchase> deptstore(
        io.grpc.stub.StreamObserver<com.Store.total> responseObserver) {
      return asyncUnimplementedStreamingCall(getDeptstoreMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDeptstoreMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.Store.purchase,
                com.Store.total>(
                  this, METHODID_DEPTSTORE)))
          .build();
    }
  }

  /**
   */
  public static final class storeStub extends io.grpc.stub.AbstractStub<storeStub> {
    private storeStub(io.grpc.Channel channel) {
      super(channel);
    }

    private storeStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected storeStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new storeStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.Store.purchase> deptstore(
        io.grpc.stub.StreamObserver<com.Store.total> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getDeptstoreMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class storeBlockingStub extends io.grpc.stub.AbstractStub<storeBlockingStub> {
    private storeBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private storeBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected storeBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new storeBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class storeFutureStub extends io.grpc.stub.AbstractStub<storeFutureStub> {
    private storeFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private storeFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected storeFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new storeFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_DEPTSTORE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final storeImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(storeImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DEPTSTORE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.deptstore(
              (io.grpc.stub.StreamObserver<com.Store.total>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class storeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    storeBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.Store.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("store");
    }
  }

  private static final class storeFileDescriptorSupplier
      extends storeBaseDescriptorSupplier {
    storeFileDescriptorSupplier() {}
  }

  private static final class storeMethodDescriptorSupplier
      extends storeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    storeMethodDescriptorSupplier(String methodName) {
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
      synchronized (storeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new storeFileDescriptorSupplier())
              .addMethod(getDeptstoreMethod())
              .build();
        }
      }
    }
    return result;
  }
}
