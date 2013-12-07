package com.cstan;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

public class IPLocationFinder {
    public static void main(String[] args) {
        if (args.length!=1) {
            System.out.println("You need to pass in one IP address");
        } else {
            String ipAddress = args[0];
            // http://www.webservicex.net/geoipservice.asmx?WSDL
            GeoIPService ipService = new GeoIPService();
            GeoIPServiceSoap geoIPServiceSoap = ipService.getGeoIPServiceSoap();
            GeoIP geoIP = geoIPServiceSoap.getGeoIP(ipAddress);
            System.out.println(geoIP.getCountryName());
            
            // See more at: http://www.vineetmanohar.com/2009/11/3-ways-to-run-java-main-from-maven/#sthash.tGJtvGR6.dpuf
            // mvn exec:java -Dexec.mainClass="com.cstan.IPLocationFinder" -Dexec.args="173.194.126.17"
            // With pom.xml, use mvn test 
        }
    }
}
