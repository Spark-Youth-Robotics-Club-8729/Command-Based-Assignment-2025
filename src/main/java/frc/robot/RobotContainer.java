package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.Constants.OIConstants;

public class RobotContainer {
    private final DriveSubsystem driveSubsystem = new DriveSubsystem();
    private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

    private final Joystick driver = new Joystick(OIConstants.DRIVER_PORT);
    private final Joystick operator = new Joystick(OIConstants.OPERATOR_PORT);

    private final ArcadeDriveCommand arcadeDriveCommand = new ArcadeDriveCommand(driveSubsystem, driver);
    private final IntakeCommand intakeCommand = new IntakeCommand(intakeSubsystem, operator);

    public RobotContainer() {
        driveSubsystem.setDefaultCommand(arcadeDriveCommand);
        intakeSubsystem.setDefaultCommand(intakeCommand);
    }

    public Command getAutonomousCommand() {
        return new AutoCommand(driveSubsystem, intakeSubsystem);
    }
}
