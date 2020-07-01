
<h1  align="center">Reverse Geolocating Rest Api With Spring Boot</h1>  
  
    
  
    
  
<p>  
  
    
  
    
  
<a  href="#"  target="_blank">  
  
    
  
    
  
<img  alt="License: MIT"  src="https://img.shields.io/badge/License-MIT-yellow.svg"  />  
  
   
  
    
  
    
  
</p>  
  
    
  
    
    
    
  
    
  
    
  
> A simple web app providing Rest api for reverse geolocating the provided coordinate.  It is a spring boot project using spring web starter pack. The embedded server is tomcat. Any other embedded server can be used as well. Works Offline.
  
    
    
     
   
    
    
## Install  
  
    
```sh  
  
sudo apt update  
  
sudo apt install openjdk-14-jdk-headless maven  
  
git clone https://github.com/roshanlc/reverse-geolocating-rest-api-spring-boot.git  
  
cd reverse-geolocating-rest-api-spring-boot  
  
mvn clean package  
  
java -jar target/reversegeolocator-0.0.1-SNAPSHOT.jar --server.port=8080  
  
    
```  
  
    
## Usage  
  
<p>  <img   src="/assets/demo.png"  alt="Usage with curl on bash shell"></p>  
  
  
## Documentation  
` Documentation is available on /docs endpoint`  
  
<table class="tg" >  
<thead>  
  <tr>  
    <th class="tg-0lax">Method</th>
    <th class="tg-0lax">Endpoint</th>
    <th class="tg-0lax">Parameters</th>  
    <th class="tg-0lax">Response</th>  
    <th class="tg-0lax">Demo</th>  
  </tr>  
</thead>  
<tbody>  
  <tr>  
    <td class="tg-0lax">GET</td> 
    <td class="tg-0lax">/locate</td>  
    <td class="tg-0lax">lat<br>lon<br></td>  
    <td class="tg-0lax">Returns json format location details</td>  
    <td class="tg-baqh">/locate?lat=65.654&amp;lon=54.35</td>  
  </tr>  
  <tr> 
     <td class="tg-0lax">GET</td> 
    <td class="tg-0lax">/docs</td>  
    <td class="tg-0lax"></td>  
    <td class="tg-0lax">Returns this documentation</td>  
    <td class="tg-0lax">/docs</td>  
  </tr>  
</tbody>  
</table>  
    
  
## Libraries Used  
  
* [OfflineReverseGeoCode:](https://github.com/AReallyGoodName/OfflineReverseGeocode)  
  
* [Thanks to the developer: AReallyGoodName](https://github.com/AReallyGoodName)  
  
    
  
## Author  
  
    
    
    
👤 **Roshan Lamichhane**  
  
    
    
    
* Blog: https://roshanlc.github.io  
  
    
  
    
  
* Twitter: [@_roshanlc](https://twitter.com/_roshanlc)  
  
    
  
    
  
* Github: [@roshanlc](https://github.com/roshanlc)  
* Linked: [@lamichhaneroshan](https://linkedin.com/lamichhaneroshan)  
  
    
  
    
  
    
  
## Show your support  
  
    
    
    
Give a ⭐️ if you liked this project !
