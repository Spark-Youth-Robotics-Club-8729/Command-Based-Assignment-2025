package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class RobotContainer {
    private final DriveSubsystem driveSubsystem = new DriveSubsystem();
    private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    
    private final Joystick driverStick = new Joystick(0);
    private final Joystick operatorStick = new Joystick(1);

    public RobotContainer() {
        configureButtonBindings();
    }

    private void configureButtonBindings() {
        driveSubsystem.setDefaultCommand(new ArcadeDriveCommand(driveSubsystem, driverStick));
        intakeSubsystem.setDefaultCommand(new IntakeCommand(intakeSubsystem, operatorStick));
    }

    public Command getAutonomousCommand() {
        return new AutonomousCommand(driveSubsystem, intakeSubsystem);
    }
}