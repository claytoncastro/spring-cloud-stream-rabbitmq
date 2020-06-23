# spring-cloud-stream-rabbitmq
### About

The objective of this project is to show the use of the following technologies:
* Spring Cloud Stream
* RabbitMQ

### Environment
* Java 8
* Maven 3.5.0
* Docker
* RabbitMQ

### About the project
This is a meeting confirmation software. The user must provide their information 
as name and email and confirm their participation in the meeting. All user data 
is saved to the database and then made available in a queue that will be used by 
another service called "spring-cloud-stream-rabbitmq-consumer".

### What do you need for run the project?
Docker needs to be installed and you will need a RabbitMQ image. 

#### Docker
You should download the Docker and install it:
~~~
https://hub.docker.com/editions/community/docker-ce-desktop-windows
~~~
#### RabbitMQ  
 Then you should download a RabbitMQ image. To do this, follow the following steps:
* Open the terminal
* Type the commands:
    * First you have to create the directory to persist the data outside the container.
        ~~~
        mkdir -p /docker/rabbitmq/data
        ~~~
    * Now, download the RabbitMQ image:
        ~~~
        VERSION=3-management
        export VERSION
        docker pull rabbitmq:$VERSION
        ~~~
    * List the images using the following command:
         ~~~
         docker images
         ~~~
    * Now you should execute the RabbitMQ container using the command:
         ~~~
         docker run -d --name rabbitmq \
          -p 5672:5672 \
          -p 15672:15672 \
          --restart=always \
          --hostname rabbitmq-master \
          -v /docker/rabbitmq/data:/var/lib/rabbitmq \
          rabbitmq:$VERSION
         ~~~
    * After running RabbitMQ, you can see it accessing the URL:
        ~~~
        http://localhost:15672/
        ~~~