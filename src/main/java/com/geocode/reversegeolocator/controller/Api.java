package com.geocode.reversegeolocator.controller;


import com.geocode.reversegeolocator.model.ReturnObject;

import com.geocode.reversegeolocator.reversegeocode.ReverseGeoCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.InputStream;

@CrossOrigin("*")
@RestController
@RequestMapping("")

public class Api
{
    String docs = "<style type=\"text/css\">\n" +
            ".tg  {border-collapse:collapse;border-color:#93a1a1;border-spacing:0;}\n" +
            ".tg td{background-color:#fdf6e3;border-color:#93a1a1;border-style:solid;border-width:1px;color:#002b36;\n" +
            "  font-family:Arial, sans-serif;font-size:14px;overflow:hidden;padding:10px 5px;word-break:normal;}\n" +
            ".tg th{background-color:#657b83;border-color:#93a1a1;border-style:solid;border-width:1px;color:#fdf6e3;\n" +
            "  font-family:Arial, sans-serif;font-size:16px;font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}\n" +
            ".tg .tg-baqh{text-align:center;vertical-align:top}\n" +
            ".tg .tg-0lax{text-align:left;vertical-align:top}\n" +
            "</style>\n" +
            "<table class=\"tg\">\n" +
            "<thead>\n" +
            "  <tr>\n" +
            "    <th class=\"tg-0lax\">Endpoint</th>\n" +
            "    <th class=\"tg-0lax\">Parameters</th>\n" +
            "    <th class=\"tg-0lax\">Response</th>\n" +
            "    <th class=\"tg-0lax\">Demo</th>\n" +
            "  </tr>\n" +
            "</thead>\n" +
            "<tbody>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-0lax\">/locate</td>\n" +
            "    <td class=\"tg-0lax\">lat<br>lon<br></td>\n" +
            "    <td class=\"tg-0lax\">Returns json format location details</td>\n" +
            "    <td class=\"tg-baqh\">/locate?lat=65.654&amp;lon=54.35</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td class=\"tg-0lax\">/docs</td>\n" +
            "    <td class=\"tg-0lax\"></td>\n" +
            "    <td class=\"tg-0lax\">Returns this documentation</td>\n" +
            "    <td class=\"tg-0lax\">/docs</td>\n" +
            "  </tr>\n" +
            "</tbody>\n" +
            "</table>" +
            "<br><br><p><a href=\"https://github.com/roshanlc/reverse-geolocating-rest-api-spring-boot\">The project is hosted on GitHub as well.</a></p>";

    ReverseGeoCode reverseGeoCode;
    private static final Logger logger =  LoggerFactory.getLogger(Api.class);

    /**
     * Constructor will load the reverseGeoCode object
     */
    public Api()
    {
        try
        {

            InputStream in = getClass().getResourceAsStream("/cities500.txt");
            reverseGeoCode = new ReverseGeoCode(in, true);
            logger.info("Cities file loaded ");
        }
        catch(Exception e)
        {
            logger.error("Error while loading file, error : "  + e.toString());
            logger.error("Program will now terminate.");
            System.exit(1);
        }
    }



    @GetMapping(value = "/docs")
    private String returnDocs(HttpServletRequest request )
    {

      logger.info("Method: " + request.getMethod() + "\t\tQueryString: " + request.getQueryString());
      return docs;

    }

    @GetMapping(value = "/locate", produces = "application/json")
    private Object returnReverseGeoLocation(@RequestParam(value = "lat") String lat, @RequestParam(value = "lon") String lon,HttpServletRequest request )
    {
        try {
            Double latitude = Double.parseDouble(lat);
            Double longitude = Double.parseDouble(lon);

            logger.info("Method: " + request.getMethod() + "\t\tQueryString: " + request.getQueryString());

            return reverseGeoCode.nearestPlace(latitude, longitude);

        }
        catch (Exception e)
        {
            return  e;
        }
    }


    @GetMapping(value={"","*","/error","*/*"},produces = "application/json")
    private ReturnObject returnErrorMsg(HttpServletRequest request)
    {
        logger.info("Method: " + request.getMethod()  + "\t\tQueryString: " + request.getQueryString());
        return new ReturnObject(400,"Invalid Request. Documentation available at context path /docs");
    }
}
