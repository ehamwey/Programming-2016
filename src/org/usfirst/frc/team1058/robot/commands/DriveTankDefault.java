package org.usfirst.frc.team1058.robot.commands;

import org.usfirst.frc.team1058.robot.OI;
import org.usfirst.frc.team1058.robot.Robot;
import org.usfirst.frc.team1058.robot.subsystems.DriveBase;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTankDefault extends Command {
boolean splitArcadeMode = false;
    public DriveTankDefault() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivebase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivebase.initDriveBase(2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(splitArcadeMode){
        	double rspd = Robot.oi.driverGamepad.getLeftStickY()-Robot.oi.driverGamepad.getRightStickX();
        	double lspd = Robot.oi.driverGamepad.getLeftStickY()+Robot.oi.driverGamepad.getRightStickX();

        	Robot.drivebase.driveTank(rspd, lspd);
    	}
    	else{
    	if(Robot.oi.driverGamepad.getRightBumper() || Robot.oi.driverGamepad.getLeftBumper()){
    	Robot.drivebase.driveTank(-Robot.oi.driverGamepad.getLeftStickY(), -Robot.oi.driverGamepad.getRightStickY());
    	}
    	else{
        	Robot.drivebase.driveTank(Robot.oi.driverGamepad.getRightStickY(), Robot.oi.driverGamepad.getLeftStickY());

    	}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivebase.driveTank(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}
