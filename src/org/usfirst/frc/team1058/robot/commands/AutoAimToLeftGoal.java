package org.usfirst.frc.team1058.robot.commands;

import org.usfirst.frc.team1058.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class AutoAimToLeftGoal extends Command {
	NetworkTable dataTable;
	double leftGoalPositionX;
	double imageSizeX = 400; // the size of the GRIP RESIZED IMAGE in pixels
	double goalCenterX = imageSizeX/2;
    public AutoAimToLeftGoal() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivebase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	dataTable = NetworkTable.getTable("GRIP/myContoursReport"); // create a new imageTable with the image data

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	leftGoalPositionX = dataTable.getNumber("centerX", -1); // get the contour-ed goal image 
    	double tolerance = 10;
 // set default value to -1 when no image is returned, so the robot waits for an image position)
    	
    if((leftGoalPositionX > goalCenterX+0.5*tolerance) || (leftGoalPositionX < goalCenterX-0.5*tolerance)){
    		// if robot is outside of the acceptable goal range....
    	if(leftGoalPositionX >= (goalCenterX+3*tolerance)){
    		Robot.drivebase.driveTank(0.3, -0.3);
    	}
    	if(leftGoalPositionX > (goalCenterX+tolerance) && leftGoalPositionX < (goalCenterX+3*tolerance)){
    		Robot.drivebase.driveTank(0.15, -0.15);
    	}
    	if(leftGoalPositionX <= (goalCenterX-3*tolerance)){
    		Robot.drivebase.driveTank(-0.3, 0.3);
    	}
    	if(leftGoalPositionX < (goalCenterX-tolerance) && leftGoalPositionX > (goalCenterX-3*tolerance)){
    		Robot.drivebase.driveTank(-0.15, 0.15);
    	}
    	}
    if(leftGoalPositionX == -1){
    		//wait until a contour is found and its center is passed through. 
    		// if we are lined up, and the returned contour is within the tolerance range, end the code.
    	}
    else{
    	//when lined up and the goal is seen
    	this.end();
    	}
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivebase.driveTank(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
