FROM ubuntu:latest

# this could be rearanged to save on build steps
# in some cases
RUN apt update && \

# for dev
    apt install mcedit -y && \
    apt install curl -y && \
# java installation    
    apt install -y openjdk-21-jdk && \

# timezone setup
    apt install -y tzdata && \
    ln -fs /usr/share/zoneinfo/Europe/Bratislava /etc/localtime && \
    dpkg-reconfigure -f noninteractive tzdata
# end of timezone setup

COPY . /app
WORKDIR /app
RUN ./gradlew build

CMD ./gradlew bootRun