package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants.DriveConstants;

public class ArcadeDriveCommand extends Command {
    private final DriveSubsystem drive;
    private final Joystick driver;

    public ArcadeDriveCommand(DriveSubsystem drive, Joystick driver) {
        this.drive = drive;
        this.driver = driver;
        addRequirements(drive);
    }

    @Override
    public void execute() {
        double forward = -driver.getRawAxis(1) * DriveConstants.MAX_FORWARD_SPEED;
        double turn = driver.getRawAxis(4) * DriveConstants.MAX_TURN_SPEED;
        drive.arcadeDrive(forward, turn);
    }

    @Override
    public void end(boolean interrupted) {
        drive.stop();
    }
}
