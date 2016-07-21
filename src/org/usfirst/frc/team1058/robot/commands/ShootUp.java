package org.usfirst.frc.team1058.robot.commands;

import org.usfirst.frc.team1058.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootUp extends Command {

    public ShootUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    	setTimeout(0.1);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
     	Robot.shooter.shooterSolenoid.set(true);
    	Robot.shooter.shooterSolenoid2.set(true);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
   
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
