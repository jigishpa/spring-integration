Hello World XML sample
==========================

This is a basic Spring Integration sample. It creates an input channel, an output channel, and uses a service activator to send and receive messages.

It also configures 'wire tap' and 'logging channel adapter' to intercept and log all messages.

## Message Flow

The flow of message in this example is as follows:

    (application creates) Message -> Input Channel -> ServiceActivator -> Output Channel -> (application retrieves message)
    
## Running the application

    ./gradlew run