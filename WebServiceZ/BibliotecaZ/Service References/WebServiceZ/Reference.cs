﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.34014
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace BibliotecaZ.WebServiceZ {
    using System.Runtime.Serialization;
    using System;
    
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.CollectionDataContractAttribute(Name="ArrayOfString", Namespace="http://tempuri.org/", ItemName="string")]
    [System.SerializableAttribute()]
    public class ArrayOfString : System.Collections.Generic.List<string> {
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="WebServiceZ.WSBibliotecaZSoap")]
    public interface WSBibliotecaZSoap {
        
        // CODEGEN: Generating message contract since element name HelloWorldResult from namespace http://tempuri.org/ is not marked nillable
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/HelloWorld", ReplyAction="*")]
        BibliotecaZ.WebServiceZ.HelloWorldResponse HelloWorld(BibliotecaZ.WebServiceZ.HelloWorldRequest request);
    
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/HelloWorld", ReplyAction="*")]
        System.Threading.Tasks.Task<BibliotecaZ.WebServiceZ.HelloWorldResponse> HelloWorldAsync(BibliotecaZ.WebServiceZ.HelloWorldRequest request);
        
        // CODEGEN: Generating message contract since element name titulo from namespace http://tempuri.org/ is not marked nillable
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/BuscaTitulo", ReplyAction="*")]
        BibliotecaZ.WebServiceZ.BuscaTituloResponse BuscaTitulo(BibliotecaZ.WebServiceZ.BuscaTituloRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/BuscaTitulo", ReplyAction="*")]
        System.Threading.Tasks.Task<BibliotecaZ.WebServiceZ.BuscaTituloResponse> BuscaTituloAsync(BibliotecaZ.WebServiceZ.BuscaTituloRequest request);
        
        // CODEGEN: Generating message contract since element name autor from namespace http://tempuri.org/ is not marked nillable
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/BuscaAutor", ReplyAction="*")]
        BibliotecaZ.WebServiceZ.BuscaAutorResponse BuscaAutor(BibliotecaZ.WebServiceZ.BuscaAutorRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/BuscaAutor", ReplyAction="*")]
        System.Threading.Tasks.Task<BibliotecaZ.WebServiceZ.BuscaAutorResponse> BuscaAutorAsync(BibliotecaZ.WebServiceZ.BuscaAutorRequest request);
        
        // CODEGEN: Generating message contract since element name isbn from namespace http://tempuri.org/ is not marked nillable
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/BuscaISBN", ReplyAction="*")]
        BibliotecaZ.WebServiceZ.BuscaISBNResponse BuscaISBN(BibliotecaZ.WebServiceZ.BuscaISBNRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/BuscaISBN", ReplyAction="*")]
        System.Threading.Tasks.Task<BibliotecaZ.WebServiceZ.BuscaISBNResponse> BuscaISBNAsync(BibliotecaZ.WebServiceZ.BuscaISBNRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ReplicaData", ReplyAction="*")]
        void ReplicaData();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ReplicaData", ReplyAction="*")]
        System.Threading.Tasks.Task ReplicaDataAsync();
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class HelloWorldRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="HelloWorld", Namespace="http://tempuri.org/", Order=0)]
        public BibliotecaZ.WebServiceZ.HelloWorldRequestBody Body;
        
        public HelloWorldRequest() {
        }
        
        public HelloWorldRequest(BibliotecaZ.WebServiceZ.HelloWorldRequestBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.Runtime.Serialization.DataContractAttribute()]
    public partial class HelloWorldRequestBody {
        
        public HelloWorldRequestBody() {
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class HelloWorldResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="HelloWorldResponse", Namespace="http://tempuri.org/", Order=0)]
        public BibliotecaZ.WebServiceZ.HelloWorldResponseBody Body;
        
        public HelloWorldResponse() {
        }
        
        public HelloWorldResponse(BibliotecaZ.WebServiceZ.HelloWorldResponseBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://tempuri.org/")]
    public partial class HelloWorldResponseBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=0)]
        public string HelloWorldResult;
        
        public HelloWorldResponseBody() {
        }
        
        public HelloWorldResponseBody(string HelloWorldResult) {
            this.HelloWorldResult = HelloWorldResult;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class BuscaTituloRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="BuscaTitulo", Namespace="http://tempuri.org/", Order=0)]
        public BibliotecaZ.WebServiceZ.BuscaTituloRequestBody Body;
        
        public BuscaTituloRequest() {
        }
        
        public BuscaTituloRequest(BibliotecaZ.WebServiceZ.BuscaTituloRequestBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://tempuri.org/")]
    public partial class BuscaTituloRequestBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=0)]
        public string titulo;
        
        public BuscaTituloRequestBody() {
        }
        
        public BuscaTituloRequestBody(string titulo) {
            this.titulo = titulo;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class BuscaTituloResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="BuscaTituloResponse", Namespace="http://tempuri.org/", Order=0)]
        public BibliotecaZ.WebServiceZ.BuscaTituloResponseBody Body;
        
        public BuscaTituloResponse() {
        }
        
        public BuscaTituloResponse(BibliotecaZ.WebServiceZ.BuscaTituloResponseBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://tempuri.org/")]
    public partial class BuscaTituloResponseBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=0)]
        public BibliotecaZ.WebServiceZ.ArrayOfString BuscaTituloResult;
        
        public BuscaTituloResponseBody() {
        }
        
        public BuscaTituloResponseBody(BibliotecaZ.WebServiceZ.ArrayOfString BuscaTituloResult) {
            this.BuscaTituloResult = BuscaTituloResult;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class BuscaAutorRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="BuscaAutor", Namespace="http://tempuri.org/", Order=0)]
        public BibliotecaZ.WebServiceZ.BuscaAutorRequestBody Body;
        
        public BuscaAutorRequest() {
        }
        
        public BuscaAutorRequest(BibliotecaZ.WebServiceZ.BuscaAutorRequestBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://tempuri.org/")]
    public partial class BuscaAutorRequestBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=0)]
        public string autor;
        
        public BuscaAutorRequestBody() {
        }
        
        public BuscaAutorRequestBody(string autor) {
            this.autor = autor;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class BuscaAutorResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="BuscaAutorResponse", Namespace="http://tempuri.org/", Order=0)]
        public BibliotecaZ.WebServiceZ.BuscaAutorResponseBody Body;
        
        public BuscaAutorResponse() {
        }
        
        public BuscaAutorResponse(BibliotecaZ.WebServiceZ.BuscaAutorResponseBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://tempuri.org/")]
    public partial class BuscaAutorResponseBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=0)]
        public BibliotecaZ.WebServiceZ.ArrayOfString BuscaAutorResult;
        
        public BuscaAutorResponseBody() {
        }
        
        public BuscaAutorResponseBody(BibliotecaZ.WebServiceZ.ArrayOfString BuscaAutorResult) {
            this.BuscaAutorResult = BuscaAutorResult;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class BuscaISBNRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="BuscaISBN", Namespace="http://tempuri.org/", Order=0)]
        public BibliotecaZ.WebServiceZ.BuscaISBNRequestBody Body;
        
        public BuscaISBNRequest() {
        }
        
        public BuscaISBNRequest(BibliotecaZ.WebServiceZ.BuscaISBNRequestBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://tempuri.org/")]
    public partial class BuscaISBNRequestBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=0)]
        public string isbn;
        
        public BuscaISBNRequestBody() {
        }
        
        public BuscaISBNRequestBody(string isbn) {
            this.isbn = isbn;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class BuscaISBNResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="BuscaISBNResponse", Namespace="http://tempuri.org/", Order=0)]
        public BibliotecaZ.WebServiceZ.BuscaISBNResponseBody Body;
        
        public BuscaISBNResponse() {
        }
        
        public BuscaISBNResponse(BibliotecaZ.WebServiceZ.BuscaISBNResponseBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://tempuri.org/")]
    public partial class BuscaISBNResponseBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=0)]
        public BibliotecaZ.WebServiceZ.ArrayOfString BuscaISBNResult;
        
        public BuscaISBNResponseBody() {
        }
        
        public BuscaISBNResponseBody(BibliotecaZ.WebServiceZ.ArrayOfString BuscaISBNResult) {
            this.BuscaISBNResult = BuscaISBNResult;
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface WSBibliotecaZSoapChannel : BibliotecaZ.WebServiceZ.WSBibliotecaZSoap, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class WSBibliotecaZSoapClient : System.ServiceModel.ClientBase<BibliotecaZ.WebServiceZ.WSBibliotecaZSoap>, BibliotecaZ.WebServiceZ.WSBibliotecaZSoap {
        
        public WSBibliotecaZSoapClient() {
        }
        
        public WSBibliotecaZSoapClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public WSBibliotecaZSoapClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public WSBibliotecaZSoapClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public WSBibliotecaZSoapClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        BibliotecaZ.WebServiceZ.HelloWorldResponse BibliotecaZ.WebServiceZ.WSBibliotecaZSoap.HelloWorld(BibliotecaZ.WebServiceZ.HelloWorldRequest request) {
            return base.Channel.HelloWorld(request);
        }
        
        public string HelloWorld() {
            BibliotecaZ.WebServiceZ.HelloWorldRequest inValue = new BibliotecaZ.WebServiceZ.HelloWorldRequest();
            inValue.Body = new BibliotecaZ.WebServiceZ.HelloWorldRequestBody();
            BibliotecaZ.WebServiceZ.HelloWorldResponse retVal = ((BibliotecaZ.WebServiceZ.WSBibliotecaZSoap)(this)).HelloWorld(inValue);
            return retVal.Body.HelloWorldResult;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<BibliotecaZ.WebServiceZ.HelloWorldResponse> BibliotecaZ.WebServiceZ.WSBibliotecaZSoap.HelloWorldAsync(BibliotecaZ.WebServiceZ.HelloWorldRequest request) {
            return base.Channel.HelloWorldAsync(request);
        }
        
        public System.Threading.Tasks.Task<BibliotecaZ.WebServiceZ.HelloWorldResponse> HelloWorldAsync() {
            BibliotecaZ.WebServiceZ.HelloWorldRequest inValue = new BibliotecaZ.WebServiceZ.HelloWorldRequest();
            inValue.Body = new BibliotecaZ.WebServiceZ.HelloWorldRequestBody();
            return ((BibliotecaZ.WebServiceZ.WSBibliotecaZSoap)(this)).HelloWorldAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        BibliotecaZ.WebServiceZ.BuscaTituloResponse BibliotecaZ.WebServiceZ.WSBibliotecaZSoap.BuscaTitulo(BibliotecaZ.WebServiceZ.BuscaTituloRequest request) {
            return base.Channel.BuscaTitulo(request);
        }
        
        public BibliotecaZ.WebServiceZ.ArrayOfString BuscaTitulo(string titulo) {
            BibliotecaZ.WebServiceZ.BuscaTituloRequest inValue = new BibliotecaZ.WebServiceZ.BuscaTituloRequest();
            inValue.Body = new BibliotecaZ.WebServiceZ.BuscaTituloRequestBody();
            inValue.Body.titulo = titulo;
            BibliotecaZ.WebServiceZ.BuscaTituloResponse retVal = ((BibliotecaZ.WebServiceZ.WSBibliotecaZSoap)(this)).BuscaTitulo(inValue);
            return retVal.Body.BuscaTituloResult;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<BibliotecaZ.WebServiceZ.BuscaTituloResponse> BibliotecaZ.WebServiceZ.WSBibliotecaZSoap.BuscaTituloAsync(BibliotecaZ.WebServiceZ.BuscaTituloRequest request) {
            return base.Channel.BuscaTituloAsync(request);
        }
        
        public System.Threading.Tasks.Task<BibliotecaZ.WebServiceZ.BuscaTituloResponse> BuscaTituloAsync(string titulo) {
            BibliotecaZ.WebServiceZ.BuscaTituloRequest inValue = new BibliotecaZ.WebServiceZ.BuscaTituloRequest();
            inValue.Body = new BibliotecaZ.WebServiceZ.BuscaTituloRequestBody();
            inValue.Body.titulo = titulo;
            return ((BibliotecaZ.WebServiceZ.WSBibliotecaZSoap)(this)).BuscaTituloAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        BibliotecaZ.WebServiceZ.BuscaAutorResponse BibliotecaZ.WebServiceZ.WSBibliotecaZSoap.BuscaAutor(BibliotecaZ.WebServiceZ.BuscaAutorRequest request) {
            return base.Channel.BuscaAutor(request);
        }
        
        public BibliotecaZ.WebServiceZ.ArrayOfString BuscaAutor(string autor) {
            BibliotecaZ.WebServiceZ.BuscaAutorRequest inValue = new BibliotecaZ.WebServiceZ.BuscaAutorRequest();
            inValue.Body = new BibliotecaZ.WebServiceZ.BuscaAutorRequestBody();
            inValue.Body.autor = autor;
            BibliotecaZ.WebServiceZ.BuscaAutorResponse retVal = ((BibliotecaZ.WebServiceZ.WSBibliotecaZSoap)(this)).BuscaAutor(inValue);
            return retVal.Body.BuscaAutorResult;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<BibliotecaZ.WebServiceZ.BuscaAutorResponse> BibliotecaZ.WebServiceZ.WSBibliotecaZSoap.BuscaAutorAsync(BibliotecaZ.WebServiceZ.BuscaAutorRequest request) {
            return base.Channel.BuscaAutorAsync(request);
        }
        
        public System.Threading.Tasks.Task<BibliotecaZ.WebServiceZ.BuscaAutorResponse> BuscaAutorAsync(string autor) {
            BibliotecaZ.WebServiceZ.BuscaAutorRequest inValue = new BibliotecaZ.WebServiceZ.BuscaAutorRequest();
            inValue.Body = new BibliotecaZ.WebServiceZ.BuscaAutorRequestBody();
            inValue.Body.autor = autor;
            return ((BibliotecaZ.WebServiceZ.WSBibliotecaZSoap)(this)).BuscaAutorAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        BibliotecaZ.WebServiceZ.BuscaISBNResponse BibliotecaZ.WebServiceZ.WSBibliotecaZSoap.BuscaISBN(BibliotecaZ.WebServiceZ.BuscaISBNRequest request) {
            return base.Channel.BuscaISBN(request);
        }
        
        public BibliotecaZ.WebServiceZ.ArrayOfString BuscaISBN(string isbn) {
            BibliotecaZ.WebServiceZ.BuscaISBNRequest inValue = new BibliotecaZ.WebServiceZ.BuscaISBNRequest();
            inValue.Body = new BibliotecaZ.WebServiceZ.BuscaISBNRequestBody();
            inValue.Body.isbn = isbn;
            BibliotecaZ.WebServiceZ.BuscaISBNResponse retVal = ((BibliotecaZ.WebServiceZ.WSBibliotecaZSoap)(this)).BuscaISBN(inValue);
            return retVal.Body.BuscaISBNResult;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<BibliotecaZ.WebServiceZ.BuscaISBNResponse> BibliotecaZ.WebServiceZ.WSBibliotecaZSoap.BuscaISBNAsync(BibliotecaZ.WebServiceZ.BuscaISBNRequest request) {
            return base.Channel.BuscaISBNAsync(request);
        }
        
        public System.Threading.Tasks.Task<BibliotecaZ.WebServiceZ.BuscaISBNResponse> BuscaISBNAsync(string isbn) {
            BibliotecaZ.WebServiceZ.BuscaISBNRequest inValue = new BibliotecaZ.WebServiceZ.BuscaISBNRequest();
            inValue.Body = new BibliotecaZ.WebServiceZ.BuscaISBNRequestBody();
            inValue.Body.isbn = isbn;
            return ((BibliotecaZ.WebServiceZ.WSBibliotecaZSoap)(this)).BuscaISBNAsync(inValue);
        }
        
        public void ReplicaData() {
            base.Channel.ReplicaData();
        }
        
        public System.Threading.Tasks.Task ReplicaDataAsync() {
            return base.Channel.ReplicaDataAsync();
        }
    }
}