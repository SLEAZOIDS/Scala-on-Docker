FROM hseeberger/scala-sbt

RUN apt-get update && \
    apt-get -y install libatlas3-base libopenblas-base
