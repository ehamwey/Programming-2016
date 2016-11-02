
package org.usfirst.frc.team1058.robot;

import org.usfirst.frc.team1058.robot.commands.AutoAimNFwdBack;
import org.usfirst.frc.team1058.robot.commands.AutoAimNFwdBackTwo;
import org.usfirst.frc.team1058.robot.commands.AutoAimToLeftGoal;
import org.usfirst.frc.team1058.robot.commands.AutoFwdBackLeftGoal;
import org.usfirst.frc.team1058.robot.commands.BallStealMoat;
import org.usfirst.frc.team1058.robot.commands.LowBarCourtyard;
import org.usfirst.frc.team1058.robot.commands.LowBarDoubleBreach;
import org.usfirst.frc.team1058.robot.commands.LowBarHighGoal;
import org.usfirst.frc.team1058.robot.commands.Moat;
import org.usfirst.frc.team1058.robot.commands.RampRage;
import org.usfirst.frc.team1058.robot.commands.RockWall;
import org.usfirst.frc.team1058.robot.commands.ShootingLoop;
import org.usfirst.frc.team1058.robot.commands.VoltageOnlyFrance;
import org.usfirst.frc.team1058.robot.subsystems.Climber;
import org.usfirst.frc.team1058.robot.subsystems.DriveBase;
import org.usfirst.frc.team1058.robot.subsystems.Intake;
import org.usfirst.frc.team1058.robot.subsystems.IntakeRoller;
import org.usfirst.frc.team1058.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static final DriveBase drivebase = new DriveBase();
	public static final Intake intake = new Intake();
	public static final Climber climber = new Climber();
	public static final IntakeRoller intakeRoller = new IntakeRoller();
	public static OI oi;
	public static final Shooter shooter = new Shooter();
    Command autonomousCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public Robot(){
    
    }
    public void robotInit() {
    	
		oi = new OI();
        chooser = new SendableChooser();
        chooser.addDefault("Low Bar Courtyard", new LowBarCourtyard());
        chooser.addObject("Low Bar Double Breach", new LowBarDoubleBreach());
        chooser.addObject("Moat", new Moat());
        chooser.addObject("RampRage", new RampRage());
        chooser.addObject("RockWall", new RockWall());
        chooser.addObject("France Only", new VoltageOnlyFrance());
        chooser.addObject("Moat BallSteal", new BallStealMoat());
        chooser.addObject("Low Bar High Goal", new LowBarHighGoal());
        chooser.addObject("AutoAim", new AutoAimToLeftGoal());
        chooser.addObject("AutoFwdBack", new AutoFwdBackLeftGoal());
        chooser.addObject("AutoAimNFwdBack", new AutoAimNFwdBack(true));
        chooser.addObject("AutoAimNFwdBackTwo", new AutoAimNFwdBackTwo(true));
        SmartDashboard.putData("Auto mode", chooser);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        Robot.intake.intakeAngleTalon.setPosition(0);
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();

    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
;