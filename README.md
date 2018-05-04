## rainy-hills-histogram 

Imagine a histogram (bar graph). The application calculates a volume of water the histogram 
could hold in case of heavy rain. You can assume that each histogram bar has width 1.

Example: 
```
Input: {3,2,4,1,2}
The volume is 2
```

### Prerequisites
You will need to install java v1.8 and gradle, before you'll run app.
Please see bellow, the installation example for Linux OS 

```
//install java
sudo add-apt-repository ppa:webupd8team/java
sudo apt update
sudo apt install oracle-java8-installer
javac -version
//install maven
sudo apt-get install maven
//install git
apt-get install git
//install docker
sudo apt-get install docker-ce

```

### Installing
Before you will use the app you will need to execute next commands:

```
git clone ${repo_url}
cd rainyhills
//build a project
mvn clean install
//build a docker image
docker build -t rainy-hills-app .
//run docker container
docker run -it -p 8080:8080 rainy-hills-app
```

### Testing the app

Go to http://{host_url}:8080/rainyhills/rainyHills.xhtml, enter the input array, press a compute button and see a result.

