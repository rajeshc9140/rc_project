package com.sintecmedia.rc.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sintec.rc.erro.DemoApiValidationException;
import com.sintec.rc.model.Demo;
import com.sintec.rc.model.DemoRequest;
import com.sintec.rc.model.DemoResponse;
import com.sintec.rc.utils.DemoConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Controller to handle rating requests
 *
 * @author Jagadeesh.B
 */
@RestController
@RequestMapping("/v1")
@Api(tags = "demo", description = "Program or  demo")
public class DemoController {
  private static final Logger LOGGER = Logger.getLogger(DemoController.class);
 /* @Autowired
  private RatingService ratingService;

  @Autowired
  private RatingsApiDataValidator ratingsApiDataValidator;*/

  @ApiOperation(value = "Provides BookList", nickname = "BookList", code = 200, httpMethod = "POST", notes = "Returns  Ratings and Share Informations")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = DemoConstants.HTTP_STATUS_CODE_200, response = DemoResponse.class),
      @ApiResponse(code = 400, message = DemoConstants.HTTP_STATUS_CODE_400, response = String.class),
      @ApiResponse(code = 401, message = DemoConstants.HTTP_STATUS_CODE_401, response = String.class),
      @ApiResponse(code = 403, message = DemoConstants.HTTP_STATUS_CODE_403, response = String.class),
      @ApiResponse(code = 404, message = DemoConstants.HTTP_STATUS_CODE_404, response = String.class),
      @ApiResponse(code = 500, message = DemoConstants.HTTP_STATUS_CODE_500, response = String.class) })
  @RequestMapping(value= "/createDemo", method = RequestMethod.POST)
  public ResponseEntity<DemoResponse> getRatings(
      @ApiParam(required = true, value = "Program Ratings") @RequestBody DemoRequest demoRequest)
      throws DemoApiValidationException, ParseException {
    LOGGER.debug("Start :: getRatings() for bookids - \" + ratingRequest.getBookIds() + \" :: demos -\"\r\n"
        + "        + ratingRequest.getFilter().getDemographics() + \"");
    
   /* final long startTime = System.currentTimeMillis();
    ratingsApiDataValidator.validateRatingRequest(ratingRequest);
    final RatingResponse ratingResponse = ratingService.getRatings(ratingRequest);
    final long stopTime = System.currentTimeMillis();
    LOGGER.info("Total time for the getRatings response  is " + (stopTime - startTime)); */
    
    List demoList=new ArrayList<>();
    Demo lDemo=new Demo();
    lDemo.setId(demoRequest.getId());
    lDemo.setName(demoRequest.getName());
    demoList.add(lDemo);
    DemoResponse demoResponse=new DemoResponse();
    demoResponse.setDemo(demoList);
    
    
    return new ResponseEntity<DemoResponse>(demoResponse, HttpStatus.OK);
  }
}
