package com.shot.fsavings.Controller;

import com.shot.fsavings.Common.URI;
import com.shot.fsavings.Entity.GoalEntity;
import com.shot.fsavings.Service.DashboardService;
import com.shot.fsavings.Service.GoalService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DashboardController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnboardingController.class);

    @Autowired
    private DashboardService dashboardService;
    @Autowired
    private GoalService goalService;

    //suggestions
    @RequestMapping(value = URI.SAVE_GOAL_INFO, method = RequestMethod.POST)
    ResponseEntity<?> saveGoal(@RequestBody GoalEntity goal) {
        try {
            goalService.saveGoal(goal);
            return ResponseEntity.ok(goal);
        } catch (Exception e) {
            LOGGER.debug("DashboardController: saveGoal -- Error");
            return ResponseEntity.badRequest().body("FAILURE");
        }
    }

    @RequestMapping(value = URI.UPDATE_GOAL_INFO, method = RequestMethod.POST)
    ResponseEntity<?> generateGoal(@PathVariable String id) {
        try {
            goalService.generateGoal(id);
            return ResponseEntity.ok(id);
        } catch (Exception e) {
            LOGGER.debug("DashboardController: updateGoal -- Error");
            return ResponseEntity.badRequest().body("FAILURE");
        }
    }
    //cash flows
}
