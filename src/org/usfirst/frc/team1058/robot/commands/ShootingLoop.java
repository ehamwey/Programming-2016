package org.usfirst.frc.team1058.robot.commands;

import org.usfirst.frc.team1058.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ShootingLoop extends CommandGroup {
    boolean commandStarted;
    public  ShootingLoop() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    		addParallel(new DriveIntakeRoller(-2, 2));
    		addSequential(new WaitCommand(0.5));
    		addSequential(new ShootUp());
    		addSequential(new WaitCommand(0.475));
    		addSequential(new ShootDown());
    		addSequential(new DriveIntakeRoller(0,0));
    		this.end();
}
}
