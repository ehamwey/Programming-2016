package org.usfirst.frc.team1058.robot.commands;

import org.usfirst.frc.team1058.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoFwdBackLeftGoal extends Command {
	NetworkTable dataTable;
	public static boolean goalFBInRange = false;
	double[] lfGPXA;
	double[] defaultvl;
	double leftGoalPositionY;
	double imageSizeY = 200; // the size of the GRIP RESIZED IMAGE in pixels
	double goalIdealCenterY = 20;
    public AutoFwdBackLeftGoal() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivebase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	dataTable = NetworkTable.getTable("GRIP/myContoursReport"); // create a new imageTable with the image data
    	lfGPXA = new double[5];
    	defaultvl = new double[5];
    	lfGPXA[0] = 0;
    	lfGPXA[1] = 0;
    	lfGPXA[2] = 0;
    	lfGPXA[3] = 0;
    	lfGPXA[4] = 0;
    	defaultvl[0] = 0;
    	defaultvl[1] = 0;
    	defaultvl[2] = 0;
    	defaultvl[3] = 0;
    	defaultvl[4] = 0;


    }

    // Called repeatedly when this Command is scheduled to run
	protected void execute() {
    	
    	defaultvl[0] = 0 ;
    	lfGPXA = dataTable.getNumberArray("centerY", defaultvl); // get the contour-ed goal image 
    	try{
    	leftGoalPositionY = lfGPXA[0];
    	}
    	catch(ArrayIndexOutOfBoundsException e){
    		System.out.println("No goal!");
    		goalFBInRange = true;
    	}
    	double tolerance = 15
    			;
 // set default value to -1 when no image is returned, so the robot waits for an image position)
    	SmartDashboard.putNumber("left goal angle", leftGoalPositionY);
    if((leftGoalPositionY > goalIdealCenterY+(0.5*tolerance)) || (leftGoalPositionY < goalIdealCenterY-(0.5*tolerance))){
    		// if robot is outside of the acceptable goal range....
    	SmartDashboard.putBoolean("goalFBInRange", false);
    	if(leftGoalPositionY >= (goalIdealCenterY+(3*tolerance))){ // if goal is at 230 or greater pixels
    		Robot.drivebase.driveTank(-0.35, -0.35);
    		SmartDashboard.putBoolean("goalFarFwd", true);
    		SmartDashboard.putBoolean("goalCloseFwd", false);
    		SmartDashboard.putBoolean("goalCloseBack", false);
    		SmartDashboard.putBoolean("goalFarBack", false);
    		
    	}
    	if(leftGoalPositionY > (goalIdealCenterY+tolerance) && leftGoalPositionY < (goalIdealCenterY+(3*tolerance))){
    		//if goal position is between 210 and 230
    		Robot.drivebase.driveTank(-0.14, -0.14);
    		SmartDashboard.putBoolean("goalFarFwd", false);
    		SmartDashboard.putBoolean("goalCloseFwd", true);
    		SmartDashboard.putBoolean("goalCloseBack", false);
    		SmartDashboard.putBoolean("goalFarBack", false);
    	}
    	if(leftGoalPositionY <= (goalIdealCenterY-(3*tolerance))){
    		//if goal position is less than 170
    		Robot.drivebase.driveTank(0.35, 0.35);
    		SmartDashboard.putBoolean("goalFarFwd", false);
    		SmartDashboard.putBoolean("goalCloseFwd", false);
    		SmartDashboard.putBoolean("goalCloseBack", false);
    		SmartDashboard.putBoolean("goalFarBack", true);
    	}
    	if(leftGoalPositionY < (goalIdealCenterY-tolerance) && leftGoalPositionY > (goalIdealCenterY-(3*tolerance))){
    		//if goal position is less than 190 but greater than 170
    		Robot.drivebase.driveTank(0.14, 0.14);
    		SmartDashboard.putBoolean("goalFarFwd", false);
    		SmartDashboard.putBoolean("goalCloseFwd", false);
    		SmartDashboard.putBoolean("goalCloseBack", false);
    		SmartDashboard.putBoolean("goalFarBack", true);
    	}
    	}
    
    else{
     	goalFBInRange = true;
    	SmartDashboard.putBoolean("goalFBInRange", true);
    	SmartDashboard.putBoolean("goalFarFwd", false);
		SmartDashboard.putBoolean("goalCloseFwd", false);
		SmartDashboard.putBoolean("goalCloseBack", false);
		SmartDashboard.putBoolean("goalFarBack", false);
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
