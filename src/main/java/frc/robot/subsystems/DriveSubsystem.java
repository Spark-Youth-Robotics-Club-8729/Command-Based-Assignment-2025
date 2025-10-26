package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {

    private final SparkMax frontLeft = new SparkMax(DriveConstants.FRONT_LEFT_ID);
    private final SparkMax backLeft = new SparkMax(DriveConstants.BACK_LEFT_ID);
    private final SparkMax frontRight = new SparkMax(DriveConstants.FRONT_RIGHT_ID);
    private final SparkMax backRight = new SparkMax(DriveConstants.BACK_RIGHT_ID);

    private final DifferentialDrive drive;

    public DriveSubsystem() {
        
        backLeft.addFollower(frontLeft);
        backRight.addFollower(frontRight);

        drive = new DifferentialDrive(frontLeft, frontRight);
    }

    public void arcadeDrive(double forward, double turn) {
        drive.arcadeDrive(forward, turn);
    }

    public void stop() {
        drive.stopMotor();
    }
}
