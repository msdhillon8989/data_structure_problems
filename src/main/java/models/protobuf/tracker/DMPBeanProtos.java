// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/dmpbean.proto

package models.protobuf.tracker;

public final class DMPBeanProtos {
  private DMPBeanProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_DMPBean_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_DMPBean_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\021src/dmpbean.proto\"N\n\007DMPBean\022\025\n\rend_po" +
      "int_url\030\001 \001(\t\022\026\n\016request_header\030\002 \001(\t\022\024\n" +
      "\014request_body\030\003 \001(\tB*\n\027models.protobuf.t" +
      "rackerB\rDMPBeanProtosP\001"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_DMPBean_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_DMPBean_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_DMPBean_descriptor,
              new String[] { "EndPointUrl", "RequestHeader", "RequestBody", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
