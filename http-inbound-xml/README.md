HTTP Inbound Gateway sample
==========================

This example shows the operation of an Http Inbound Gateway. It creates an http inbound gateway, input channel, and uses a service activator to receive incoming message. It also specifies the payload-type on the Gateway so that the incoming payload can be mapped as a String.

It also configures 'wire tap' and 'logging channel adapter' to intercept and log all messages.

## Message Flow

The flow of message in this example is as follows:

    (http message comes to) HTTP Inbound Gateway -> Incoming Channel -> ServiceActivator -> InboundService
    
## Running the application

    ./gradlew run