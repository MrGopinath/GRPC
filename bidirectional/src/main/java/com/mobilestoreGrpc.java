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
public final class mobilestoreGrpc {

  private mobilestoreGrpc() {}

  public static final String SERVICE_NAME = "mobilestore";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.Store.searchmob,
      com.Store.cart> getMobileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "mobile",
      requestType = com.Store.searchmob.class,
      responseType = com.Store.cart.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.Store.searchmob,
      com.Store.cart> getMobileMethod() {
    io.grpc.MethodDescriptor<com.Store.searchmob, com.Store.cart> getMobileMethod;
    if ((getMobileMethod = mobilestoreGrpc.getMobileMethod) == null) {
      synchronized (mobilestoreGrpc.class) {
        if ((getMobileMethod = mobilestoreGrpc.getMobileMethod) == null) {
          mobilestoreGrpc.getMobileMethod = getMobileMethod = 
              io.grpc.MethodDescriptor.<com.Store.searchmob, com.Store.cart>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "mobilestore", "mobile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.Store.searchmob.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.Store.cart.getDefaultInstance()))
                  .setSchemaDescriptor(new mobilestoreMethodDescriptorSupplier("mobile"))
                  .build();
          }
        }
     }
     return getMobileMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static mobilestoreStub newStub(io.grpc.Channel channel) {
    return new mobilestoreStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static mobilestoreBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new mobilestoreBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static mobilestoreFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new mobilestoreFutureStub(channel);
  }

  /**
   */
  public static abstract class mobilestoreImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.Store.searchmob> mobile(
        io.grpc.stub.StreamObserver<com.Store.cart> responseObserver) {
      return asyncUnimplementedStreamingCall(getMobileMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMobileMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.Store.searchmob,
                com.Store.cart>(
                  this, METHODID_MOBILE)))
          .build();
    }
  }

  /**
   */
  public static final class mobilestoreStub extends io.grpc.stub.AbstractStub<mobilestoreStub> {
    private mobilestoreStub(io.grpc.Channel channel) {
      super(channel);
    }

    private mobilestoreStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected mobilestoreStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new mobilestoreStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.Store.searchmob> mobile(
        io.grpc.stub.StreamObserver<com.Store.cart> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getMobileMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class mobilestoreBlockingStub extends io.grpc.stub.AbstractStub<mobilestoreBlockingStub> {
    private mobilestoreBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private mobilestoreBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected mobilestoreBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new mobilestoreBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class mobilestoreFutureStub extends io.grpc.stub.AbstractStub<mobilestoreFutureStub> {
    private mobilestoreFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private mobilestoreFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected mobilestoreFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new mobilestoreFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_MOBILE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final mobilestoreImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(mobilestoreImplBase serviceImpl, int methodId) {
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
        case METHODID_MOBILE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.mobile(
              (io.grpc.stub.StreamObserver<com.Store.cart>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class mobilestoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    mobilestoreBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.Store.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("mobilestore");
    }
  }

  private static final class mobilestoreFileDescriptorSupplier
      extends mobilestoreBaseDescriptorSupplier {
    mobilestoreFileDescriptorSupplier() {}
  }

  private static final class mobilestoreMethodDescriptorSupplier
      extends mobilestoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    mobilestoreMethodDescriptorSupplier(String methodName) {
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
      synchronized (mobilestoreGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new mobilestoreFileDescriptorSupplier())
              .addMethod(getMobileMethod())
              .build();
        }
      }
    }
    return result;
  }
}
