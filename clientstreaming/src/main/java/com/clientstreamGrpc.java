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
    comments = "Source: clientstreaming.proto")
public final class clientstreamGrpc {

  private clientstreamGrpc() {}

  public static final String SERVICE_NAME = "clientstream";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.Clientstreaming.bookcartrequest,
      com.Clientstreaming.bookcartresponse> getBookcartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bookcart",
      requestType = com.Clientstreaming.bookcartrequest.class,
      responseType = com.Clientstreaming.bookcartresponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.Clientstreaming.bookcartrequest,
      com.Clientstreaming.bookcartresponse> getBookcartMethod() {
    io.grpc.MethodDescriptor<com.Clientstreaming.bookcartrequest, com.Clientstreaming.bookcartresponse> getBookcartMethod;
    if ((getBookcartMethod = clientstreamGrpc.getBookcartMethod) == null) {
      synchronized (clientstreamGrpc.class) {
        if ((getBookcartMethod = clientstreamGrpc.getBookcartMethod) == null) {
          clientstreamGrpc.getBookcartMethod = getBookcartMethod = 
              io.grpc.MethodDescriptor.<com.Clientstreaming.bookcartrequest, com.Clientstreaming.bookcartresponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "clientstream", "bookcart"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.Clientstreaming.bookcartrequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.Clientstreaming.bookcartresponse.getDefaultInstance()))
                  .setSchemaDescriptor(new clientstreamMethodDescriptorSupplier("bookcart"))
                  .build();
          }
        }
     }
     return getBookcartMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static clientstreamStub newStub(io.grpc.Channel channel) {
    return new clientstreamStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static clientstreamBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new clientstreamBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static clientstreamFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new clientstreamFutureStub(channel);
  }

  /**
   */
  public static abstract class clientstreamImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.Clientstreaming.bookcartrequest> bookcart(
        io.grpc.stub.StreamObserver<com.Clientstreaming.bookcartresponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBookcartMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBookcartMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.Clientstreaming.bookcartrequest,
                com.Clientstreaming.bookcartresponse>(
                  this, METHODID_BOOKCART)))
          .build();
    }
  }

  /**
   */
  public static final class clientstreamStub extends io.grpc.stub.AbstractStub<clientstreamStub> {
    private clientstreamStub(io.grpc.Channel channel) {
      super(channel);
    }

    private clientstreamStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected clientstreamStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new clientstreamStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.Clientstreaming.bookcartrequest> bookcart(
        io.grpc.stub.StreamObserver<com.Clientstreaming.bookcartresponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getBookcartMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class clientstreamBlockingStub extends io.grpc.stub.AbstractStub<clientstreamBlockingStub> {
    private clientstreamBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private clientstreamBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected clientstreamBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new clientstreamBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class clientstreamFutureStub extends io.grpc.stub.AbstractStub<clientstreamFutureStub> {
    private clientstreamFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private clientstreamFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected clientstreamFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new clientstreamFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_BOOKCART = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final clientstreamImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(clientstreamImplBase serviceImpl, int methodId) {
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
        case METHODID_BOOKCART:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bookcart(
              (io.grpc.stub.StreamObserver<com.Clientstreaming.bookcartresponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class clientstreamBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    clientstreamBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.Clientstreaming.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("clientstream");
    }
  }

  private static final class clientstreamFileDescriptorSupplier
      extends clientstreamBaseDescriptorSupplier {
    clientstreamFileDescriptorSupplier() {}
  }

  private static final class clientstreamMethodDescriptorSupplier
      extends clientstreamBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    clientstreamMethodDescriptorSupplier(String methodName) {
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
      synchronized (clientstreamGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new clientstreamFileDescriptorSupplier())
              .addMethod(getBookcartMethod())
              .build();
        }
      }
    }
    return result;
  }
}
