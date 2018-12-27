# fluent.ly 
[![Build Status](https://travis-ci.org/TechnionYP5779/team6.svg?branch=master)](https://travis-ci.org/TechnionYP5779/team6)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/TechnionYP5779/team6.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/TechnionYP5779/team6/alerts/)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/TechnionYP5779/team6.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/TechnionYP5779/team6/context:java)
[![SonarCubeQuality](https://sonarcloud.io/api/project_badges/measure?project=team6project&metric=alert_status)](https://sonarcloud.io/dashboard?id=team6project)

# Team6 Parking Renting

We worked on creating a platform allowing users to park and rent parking spots.
We use *Jetty Embedded* with *HttpServlet* local server. In the future we will use remote one.
All features (except sigining up) require the user to be logged in, and if he doesn't have and account he can
easily create one.
Our non-authentication information is saved on a remote *MySql server*.
At the moment we have the following features:

## User Interface

Our UI created with *JavaScript under Angular* technology.
From our front page you can sign up, log in, see existing available parking spots, and set up a parking spot
(so that other users will be able to rent it).


![UI](https://i.ibb.co/xLn0KpV/Whats-App-Image-2018-12-27-at-16-04-59.jpg)



## Signing up
A user can sign up directly from the front page, with easily and beautifully custom form.
Sigining up is handled using *Auth0* technology.
A signed up user can log in.

## Log In
A user can log in directly from the front page, with a badass custom form.
Logging in is handled using *Auth0* technology.
A logged in user can use the rest of the features.

### Find Parking
A logged in user can see all availble parking spots, displayed on a map provided using *Google Maps API*, and
on a table.
The map will center to his current location and display prices on the parking spaces markers displayed
on the map.
Clicking on the markers will show additional information regarding the parking space.

### Becoming a host
A logged in user can sign up his parking space, to be rent by other users.

## Prerequisites

1. Eclipse Java 2018-09, you can download it from the official website: https://www.eclipse.org/downloads/
2. Java JDK 1.8, you can download if from the official website: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
3. JSON jar. You can add it as described here: https://github.com/TechnionYP5779/team6/wiki/How-to-add-JSON-external-jar-to-project
4. GSON jar. You can add it as described here: https://github.com/TechnionYP5779/team6/issues/238
5. MySql connector. You can add it as described here: https://github.com/TechnionYP5779/team6/wiki/Integrating-SQL (following steps 1 and 2 only)


## Contributors

Please read [contributers.txt](https://github.com/TechnionYP5779/team6/blob/master/contributers.txt) for details regarding the contributors to this project.
